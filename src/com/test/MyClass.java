package com.test;


import java.util.*;
import java.util.stream.Collectors;

interface One {
    default void method() {
        System.out.println("One");
    }
}



class Three implements One, Two {
    public void method() {
        One.super.method();
    }
}

interface Two {
    default void method () {
        System.out.println("One");
    }
}

public class MyClass {
    static int age;
    public static final String message ="Hello!";
        static void print(){
         System.out.println(message);
    }
     void print2(){};


    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        List<String> phones = people.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(phones);
    }

        static int swapsies(int a, int b) {
            int temp=a;
            a=10;
            b=15;
            return a;
        }
    }



