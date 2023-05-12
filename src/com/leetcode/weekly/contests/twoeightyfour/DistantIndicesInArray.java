package com.leetcode.weekly.contests.twoeightyfour;

import java.util.*;

public class DistantIndicesInArray {


    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        int len=nums.length;

        Set<Integer> intermediateResult=new TreeSet<>();
        List<Integer> result= new ArrayList<>();
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(Math.abs(i-j)<=k && nums[j]==key){
                    intermediateResult.add(i);
                }
            }
        }
        intermediateResult.stream().forEach(value->result.add(value));

        return result;

    }

    public static void main(String[] args) {

        int[] nums={3,4,9,1,3,9,5};
        int key =9;
        int k=1;
        System.out.println(findKDistantIndices(nums,key,k));

    }
}
