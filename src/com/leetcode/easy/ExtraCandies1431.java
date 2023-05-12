package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtraCandies1431 {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int size=candies.length;
        List<Boolean> candiesList= new ArrayList<>();
        int[] elements=new int[size];
        for(int i=0;i<size;i++){
            elements[i]=candies[i];
        }

        Arrays.sort(elements);
        int max=elements[size-1];

        for(int j=0;j<size;j++){
            if(candies[j]==max){
                candiesList.add(Boolean.TRUE);
                continue;

            }
            else{
                if(max-candies[j]<=extraCandies){
                    candiesList.add(Boolean.TRUE);
                }
                else {
                    candiesList.add(Boolean.FALSE);
                }

            }
        }

        return candiesList;
    }

    public static void main(String[] args) {
        int[] candies=new int[]{4,2,1,1,2};
        int extraCandies=1;

        System.out.println(kidsWithCandies(candies, extraCandies));
    }
}
