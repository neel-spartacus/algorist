package com.scaler.recursion.backtracking;

public class A {

    A other;

    void fun(){

        A a= new A();
        A b= new A();

        a.other=b;
        b.other=a;
    }

    public static void main(String[] args) {

        A test= new A();
        test.fun();
    }
}
