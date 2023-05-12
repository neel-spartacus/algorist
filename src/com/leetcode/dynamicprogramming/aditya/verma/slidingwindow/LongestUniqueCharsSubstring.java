package com.leetcode.dynamicprogramming.aditya.verma.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestUniqueCharsSubstring {


    public static int findLongestUniqueChars(String text,int k){

        int size=text.length();
        int start=0;
        int end=0;

        int max=Integer.MIN_VALUE;

        String[] arr=text.split("");
        Map<String,Integer> map =  new HashMap<>();


        while (end<size){

                if(map.get(arr[end])==null){
                    map.put(arr[end], 1);
                }
                else{
                    int temp=map.get(arr[end]);
                    map.put(arr[end],temp+1 );
                }
            if(map.size()<k){
                end++;
            }
            else if(map.size()==k){
                max=Math.max(max, end-start+1);
                end++;
            }
            else{
                while (map.size()>k){
                    int temp=map.get(arr[start]);
                    if(temp-1==0){
                        map.remove(arr[start]);
                    }
                    else{
                        map.put(arr[start],temp-1 );
                    }
                    start++;
                }
                end++;

            }
            }


        return max==Integer.MIN_VALUE?-1:max;
    }

    public static void main(String[] args) {

        String text="aaaa";
        int K=2;

        System.out.println(findLongestUniqueChars(text,K));
    }
}
