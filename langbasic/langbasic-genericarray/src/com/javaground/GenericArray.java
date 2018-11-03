package com.javaground;

public class GenericArray<T> {
    public T[] array;
    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[])new Object[sz];
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) { return array[index]; }
    // Method that exposes the underlying representation:
    public T[] rep() { return array; }
    public static void main(String[] args) {
        GenericArray<Integer> gai =
                new GenericArray<Integer>(10);
        gai.put(0,10);
        Integer elem = gai.get(0);
        Integer[] arr = (Integer[]) new Object[12];
        // This causes a ClassCastException:
        // Integer[] ia = (Integer[]) gai.rep();
        // This is OK:
        Object[] oa = gai.rep();
    }
}

//public class GenericArray<T> {
//    private Object[] array;
//    public GenericArray(int sz) {
//        array = new Object[sz];
//    }
//    public void put(int index, T item) {
//        array[index] = item;
//    }
//    @SuppressWarnings("unchecked")
//    public T get(int index) { return (T)array[index]; }
//    @SuppressWarnings("unchecked")
//    public T[] rep() {
//        return (T[])array; // Warning: unchecked cast
//    }
//    public static void main(String[] args) {
//        GenericArray<Integer> gai =
//                new GenericArray<Integer>(10);
//        for(int i = 0; i < 10; i ++)
//            gai.put(i, i);
//        for(int i = 0; i < 10; i ++)
//            System.out.print(gai.get(i) + " ");
//        System.out.println();
//        try {
//            Integer[] ia = gai.rep();
//        } catch(Exception e) { System.out.println(e); }
//    }
//}
