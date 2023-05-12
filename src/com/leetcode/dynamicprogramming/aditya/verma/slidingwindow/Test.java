package com.leetcode.dynamicprogramming.aditya.verma.slidingwindow;

import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        Optional<String> opt = Optional.empty();
       // Optional<String> opt = null;
        opt.ifPresent(name -> System.out.println(name.length()));
    }
}
