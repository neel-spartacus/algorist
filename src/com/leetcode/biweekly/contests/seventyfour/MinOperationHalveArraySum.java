package com.leetcode.biweekly.contests.seventyfour;


//Problem: https://leetcode.com/contest/biweekly-contest-74/problems/minimum-operations-to-halve-array-sum/

import java.util.Arrays;

public class MinOperationHalveArraySum {


    public static int halveArray(int[] nums) {

        int len= nums.length;

        double min=Integer.MAX_VALUE;
        long sum=0;

        for( int i=0;i<len;i++){
            sum+=nums[i];
        }

        double halve=(double)sum/2;

        Arrays.sort(nums);

        for(int i=0;i<len;i++){
            double val=(double) nums[i]/2;
            double intermediate=sum-nums[i]+val;
            if(intermediate<halve){
                while (intermediate<halve){

                }
            }
        }

//Incomplete

        return 0;
    }

    public static void main(String[] args) {

        int[] nums={5,19,8,1};

        System.out.println(halveArray(nums));

    }
}
