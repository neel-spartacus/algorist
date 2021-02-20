package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

import java.util.Arrays;

public class CodilityDemo {


   public static int solution(int[] arr) {

       int max = Integer.MIN_VALUE;
       int smallestInt = 1;
       int len = arr.length;

       Arrays.sort(arr);

       if (arr[0] > 1) {
           return smallestInt;
       }

       if (arr[len - 1] < smallestInt) {
           return smallestInt;
       }

       for (int a = 0; a < len; a++) {
           if (arr[a] == smallestInt) {
               smallestInt++;
           }

       }
       return smallestInt;
   }

    public static void main(String[] args) {

    }
}
