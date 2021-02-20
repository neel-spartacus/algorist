package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

import java.util.*;

public class CodilityOddOccurencesInArrayTest {


    private static int oddOccurence(int[] ranks){

        int count=0;
        try{

            int len= ranks.length;
            if(len<1||len>100000){
                throw new RuntimeException();
            }
            Map<Integer,Integer> map= new HashMap<>();
            List<Integer> list = new ArrayList<Integer>();
            for (int i : ranks)
            {
                list.add(i);
            }

            for(int i = 0; i< ranks.length; i++){
                if(ranks[i]<0|| ranks[1]>1000000000){
                    throw new RuntimeException();
                }
                if(map.containsKey(ranks[i])){
                    int value=map.get(ranks[i]);
                    map.put(ranks[i],value+1 );
                }
                else{
                    map.put(ranks[i],1 );
                }
            }

            for(Integer key:map.keySet()){
                if(list.contains(key+1)){
                    count+=map.get(key);
                }
            }

            return count;
        }
        catch (Exception ex){
            System.out.println("Invalid input value: " + ex.getMessage());
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr={4,4,3,3,1,0};
        System.out.println(oddOccurence(arr));
    }
}
