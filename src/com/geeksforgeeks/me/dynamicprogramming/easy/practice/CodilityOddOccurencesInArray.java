package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodilityOddOccurencesInArray {


    private static int oddOccurence(int[] arr){

        Map<Integer,Integer> map= new HashMap<>();
        int count=0;
        List list = Arrays.asList(arr);

        for(int i=0;i<arr.length;i++){

            if(map.containsKey(arr[i])){
                int value=map.get(arr[i]);
                map.put(arr[i],value+1 );
            }
            else{
                map.put(arr[i],1 );
            }
        }

        for(Integer key:map.keySet()){
            if(map.get(key)%2!=0){
                return key;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr={9,3,5,9,5,7,3,19,7};
        System.out.println(oddOccurence(arr));
    }
}
