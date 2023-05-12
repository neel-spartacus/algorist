package com.leetcode.dynamicprogramming.aditya.verma.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountAnagrams {


    public static int countAnagrams(String text,String pattern){

        int size=text.length();
        int patternLength=pattern.length();
        int start=0;
        int end=0;
        int count=0;
        int ans=0;

        List<Integer> startIndices= new ArrayList<>();
        String[] arr=text.split("");
        String[] anagram=pattern.split("");
        Map<String,Integer> map =  new HashMap<>();
        for(String c:anagram){
            if(map.get(c)==null){
                map.put(c, 1);
            }
            else{
                int temp=map.get(c);
                map.put(c,temp+1 );
            }
        }
        count=map.size();

        while (end<size){

            if(map.containsKey(arr[end])){
                int uniqueCount=map.get(arr[end]);
                map.put(arr[end],uniqueCount-1 );
                if(map.get(arr[end])==0){
                    count--;
                }
            }

            if(end-start+1<patternLength){
                end++;
            }
            else if(end-start+1==patternLength){
                if(count==0){
                    ans++;
                    startIndices.add(start);
                }

                if(map.containsKey(arr[start])){
                    int uniqueCount=map.get(arr[start]);
                    map.put(arr[start],uniqueCount+1 );
                    if(map.get(arr[start])==1){
                        count++;
                    }
                }

                start++;
                end++;
            }
        }


  return ans;
    }

    public static void main(String[] args) {

        String text="forxxorfxdofr";
        String pattern="for";

        System.out.println(countAnagrams(text,pattern));
    }
}
