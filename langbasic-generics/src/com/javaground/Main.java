package com.javaground;

import javafx.geometry.HorizontalDirection;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        TwoTuple<String, Integer> twoTuple = new TwoTuple<>("Diff", 24);
        //TwoTuple twoTuple = new TwoTuple<>("Diff", 24); will give compiler errors
        String a = twoTuple.getA();
        System.out.println("something");

        List someList = new ArrayList();
        someList.add("ABC");
        someList.add(123);
        someList.add(new Vehicle());

        List<Vehicle> vechList = new ArrayList<>();
        //compile error
        //vechList.add("aab");

        vechList.add(new Vehicle());

        //wrong
        //ClassTypeCapture<Vehicle> type1 = new ClassTypeCapture<Vehicle>(String.class);

        ClassTypeCapture<Vehicle> vechType = new ClassTypeCapture<>(Vehicle.class);

        Fish fish = Fish.class.newInstance();
        System.out.println(fish);

        Animal.Feet feet = new Animal.Feet();
        //Holder raw = new Holder<Long>();
        Holder raw = new Holder();
        raw.set(new Object());
                Long lng = 1L;

        Holder<?> holderUnboundedWithVehicleActual = new Holder<Vehicle>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unboundedContainerWithCarActual = new Holder<Car>();
        Holder<Car> carHolder = new Holder<Car>();

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        //======== Sub Generic =================================
        wildCarSubType(new Holder());

        Object num = genericWildSubType(new Holder());

        Holder<Fish> fishHolder = new Holder<Fish>();

        Holder<? extends Car> carSubContainer = new Holder<Car>();
        //Not Allowed
        //Holder<? extends Vehicle> vehicleContainer = new Holder<Fish>();
        genericWildSubType(carSubContainer);
        genericWildSubType(fishHolder);
        genericWildSubType(unboundedContainerWithCarActual);
        genericWildSubType(raw);

        //Run time error
        //genericWildSubTypeAssignment(fishHolder, 12L); //compiling Ok

        //compiler not allowed
        //Fish anotherNum = genericWildSubTypeAssignment(fishHolder, 12L);
        //Long anotherNum = genericWildSubTypeAssignment(fishHolder, 12L);
        Long aLong = genericWildSubTypeAssignment(new Holder(), 12L);
        aLong = genericWildSubTypeAssignment(new Holder<Long>(), 12L);
        Object someInst = genericWildSubTypeAssignment(new Holder<Long>(), 12L);
        Fish aFish = genericWildSubTypeAssignment(fishHolder, new Fish());
        Object result = genericWildSubTypeAssignment(unboundedContainerWithCarActual, 12L);
        genericWildSubTypeAssignment(unboundedContainerWithCarActual, new Car());
        Long someLong;
        Car someCar;
        //Not Allowed
//        someCar = genericWildSubTypeAssignment(unboundedContainerWithCarActual, new Car());
//        someCar = genericWildSubTypeAssignment(unboundedContainerWithCarActual, 12L);
//        someLong = genericWildSubTypeAssignment(unboundedContainerWithCarActual, 12L);
        genericWildSubTypeAssignment(unboundedContainerWithCarActual, 12L);
        Long long2 = genericWildSubTypeAssignment(bounded, new Long(21));

        Object someObj = genericWildSubTypeAssignment(carSubContainer, 12L);
        someCar = genericWildSubTypeAssignment(carSubContainer, new Car());
        //Not Allowed
        //Car aCar = genericWildSubTypeAssignment(carSubContainer, 12L);

        Holder<? super Long> longSuperContainer = new Holder<Object>();
        Holder<? super Car> carSuperContainer = new Holder<Vehicle>();

        //========= Super Generic ==============================
        //Not Allowed
        //carSuperContainer.set(new Vehicle());
        carSuperContainer.set(new Car());
        carSuperContainer.set(new ElectricCar());

        genericWildSuperType(new Holder());
        //Not Allowed
        //genericWildSuperType(unboundedContainerWithCarActual);
        someObj = genericWildSuperType(carSuperContainer);
        Holder<? super Vehicle> vehicleSuperContainer = new Holder<>();
        //Not Allowed
        //Vehicle someVehicle = genericWildSuperType(vehicleSuperContainer);
       // someCar = genericWildSubType(carHolder);
        //someVehicle = genericWildSuperType(carSuperContainer);
        someCar = genericWildSuperType(carHolder);

        genericWildSuperTypeAssignment(longSuperContainer, aLong);
        genericWildSuperTypeAssignment(new Holder(), aFish);
        aLong = genericWildSuperTypeAssignment(longSuperContainer, 21L);
        //Run time error
        //aLong = genericWildSuperTypeAssignment(qualified, 21L);

        genericWildSuperTypeAssignment(carSuperContainer, new Car());
        //Not Allowed
//        genericWildSuperTypeAssignment(unboundedContainerWithCarActual, new Car());
//        genericWildSuperTypeAssignment(carSuperContainer, new Vehicle());
//        genericWildSuperTypeAssignment(carSuperContainer, new Fish());


        //not allowed
//        aLong = genericWildSuperType(unbounded, 21L);
//        aLong = genericWildSuperType(bounded, 21L);

        //========== Wild Type ================================
        //wildSubType(holderUnbounded, new Car());
        wildCarSubType(new Holder<Car>());
        wildCarSubType(new Holder<ElectricCar>());
        //Not Allowed
        //wildSubType(new Holder<Vehicle>());

        wildCarSuperType(new Holder<Vehicle>());
        wildCarSuperType(new Holder<Car>());
        //Not Allowed
        //wildCarSuperType(new Holder<ElectricCar>());

        Holder<? super Car> carSuperHolder = new Holder<Vehicle>();
        carSuperHolder.set(new Car());
        carSuperHolder.set(new ElectricCar());
        //Not Allowed
        //carSuperHolder.set(new Vehicle());
        //Not Allowed
        Vehicle v2;
        //v2 = carSuperHolder.get();
        v2 = (Vehicle) carSuperHolder.get();
        v2 = (Car) carSuperHolder.get();
        v2 = (ElectricCar) carSuperHolder.get();

        Holder<? extends Car> carExtendsHolder1 = new Holder<ElectricCar>();
        //Not Allowed
        //Holder<? extends Car> carExtendsHolder2 = new Holder<Vehicle>();
        //Cannot add specific type of element
        Vehicle v1 = carExtendsHolder1.get();
        Car c1 = carExtendsHolder1.get();
        //Not Allowed
        //ElectricCar e1 = carExtendsHolder1.get();
        //Fish f1 = carExtendsHolder1.get();
//        carExtendsHolder1.set(new Vehicle());
//        carExtendsHolder1.set(new Car());
    }

    static void rawArgs(Holder holder, Object arg) {
         holder.set(arg); // Warning:
         //Unchecked call to set(T) as a
         //member of the raw type Holder

        //it is Ok
        //holder.set(new Fish());

        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    static void unboundedArg(Holder<?> holder, Object arg) {
        // holder.set(arg); // Error:
        // set(capture of ?) in Holder<capture of ?>
        // cannot be applied to (Object)
        // holder.set(new Fish()); // Same error
        // Can’t do this; don’t have any ‘T’:
        // T t = holder.get();
        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    static <T> T genericWildSubType(Holder<? extends T> container){
        T someElem =  container.get();
        return someElem;
    }

    static <T> T genericWildSubTypeAssignment(Holder<? extends T> holder, T content){
        return holder.get();
    }

    static <T> T genericWildSuperType(Holder<? super T> container){
        Object aCar = container.get();
        return (T)aCar;
        //Not Allowed
        //Vehicle aVehi = container.get();
    }

    static <T> T genericWildSuperTypeAssignment(Holder<? super T> holder, T content){
        //not allowed
        //T element =  holder.get();
        Object element = holder.get();

        holder.set((T)element);
        return (T)element;
    }

    // called by wildSubType(new Holder<Car>);
    static Car wildCarSubType(Holder<? extends Car> holder) throws Exception{
        Car individual = holder.get();

        Class carType = Car.class;
        Car car = (Car)carType.newInstance();
        carType = Class.forName("com.javaground.Car");
        car = (Car)carType.newInstance();
//        holder.set(carType.newInstance());
        //not allowed
//        holder.set(new Vehicle());
//        holder.set(new Car());
//        holder.set(new Object());
        return individual;
    }

    // called by wildCarSuperType(new Holder<Vehicle>());
    static Vehicle wildCarSuperType(Holder<? super Car> holder){
        Object car = holder.get();

        ElectricCar oneECar = new ElectricCar();
        holder.set(oneECar);
        return (Car)car;

        // not allowed by compiler
//        Car oneCar = new Car();
//        holder.set(oneCar);

    }
}

class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }
}

class CallVehicle {

}

class TwoTuple<A, B> {
    A first;
    B second;
    public TwoTuple(A a, B b){
        first = a;
        second = b;
    }
    public A getA(){
        return first;
    }
}

class Fish{
    public Fish(int weight){

    }

    public Fish(){

    }
}

class Vehicle {}

class Car extends Vehicle {
    public Car(){}
}

class ElectricCar extends Car{

}

class Animal {
    public static class Feet{

    }
}

class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T val) { value = val; }
    public void set(T val) { value = val; }
    public T get() { return value; }
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
}