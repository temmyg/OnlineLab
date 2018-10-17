package com.labartifacts;

import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        System.out.println("hello WORLD!!");
        Vehicle vehicle = null;

        try {
            Transport<Vehicle> inst = new Transport<Vehicle>(Vehicle.class);
            vehicle = inst.getVehicle();
        }
        catch (Exception e){
            throw e;
        }
        System.out.println(vehicle);
    }
}

class Vehicle{

}

class GenericBase<T> {
    private T element;
    public void set(T arg) { arg = element; }
    public T get() { return element; }
}

class SpecificGeneric<T extends Shop>{
    public T getSomething(Class<T> typeInfo){
        try {
            return typeInfo.newInstance();
        }
        catch (Exception e){
            return null;
        }
    }
}

class Shop{

}

class ToyShop extends Shop{

}

class Market<T> extends GenericBase<T>{
    public T entities(){
        return get();
    }
}

class Manufacturer<T1 extends Shop> extends  SpecificGeneric<T1>{
     public T1 find(Class<T1> typeInfo){
        return getSomething(typeInfo);
    }
}

class Transport<T>{
    private Class<T> typeParamInfo;
    public Transport(Class<T> typeInfo) throws NoSuchMethodException{
        typeParamInfo = typeInfo;   //.getConstructor();
    }
    public T getVehicle() throws Exception{
        return typeParamInfo.newInstance();
    }
}