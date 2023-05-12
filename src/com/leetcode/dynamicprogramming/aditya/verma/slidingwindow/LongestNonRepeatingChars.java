package com.leetcode.dynamicprogramming.aditya.verma.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingChars {


    public static int findLongestUniqueChars(String text){

        int size=text.length();
        int start=0;
        int end=0;

        int max=Integer.MIN_VALUE;

        String[] arr=text.split("");
        Map<String,Integer> map =  new HashMap<>();


        while (end<size){

            if(map.get(arr[end])==null){
                map.put(arr[end], 1);
                end++;
            }
            else{
                max=map.size();
                while (map.size()>0){
                    map.remove(arr[start]);
                    start++;
                }
                map.put(arr[start],1 );
                end++;

            }

        }

        return max==Integer.MIN_VALUE?(map.size()>0?map.size():0):max;
    }


    public static void main(String[] args) {
//aewabbewa
        String str ="pwwkew";
        System.out.println(findLongestUniqueChars(str));
    }
}
