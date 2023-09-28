package com.acabes.assignments.java.nullobjectaccess;

public class AccessNullObject {

    public static void firstMethod(){
        try{
            secondMethod();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void secondMethod() throws Exception{
        thirdMethod();
    }

    public static void thirdMethod() throws Exception{
        DummyClass dummy = null;

        dummy.someDummyMethod();

    }


    public static void main(String[] args) {

        firstMethod();
    }
}
