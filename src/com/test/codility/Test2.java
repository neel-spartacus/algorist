package com.test.codility;

import java.awt.*;
import java.util.HashSet;

public class Test2 {

//https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/discuss/841690/My-Java-Solution-O(n)
   // This above question was asked in the next codility online test for Zalando
    public static int test(String s){
        long[] charCount = new long[26];

        for(char ch : s.toCharArray()){
            charCount[ ch - 'a'] ++;
        }

        HashSet<Long> set = new HashSet<>();
        int noOfDeletion = 0;

        for(long val : charCount){
            while(val !=0 && set.contains(val)){
                val--;
                noOfDeletion++;
            }
            set.add(val);
        }

        return noOfDeletion;
    }


    public static void main(String[] args) {

        String s="example";

        System.out.println(test(s));

    }
}
