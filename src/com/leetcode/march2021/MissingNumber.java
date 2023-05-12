package com.leetcode.march2021;

import java.util.Arrays;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int n=nums.length;
        int missingNum=(int)1e4+5;
        try{
            for(int num:nums){
                if(num<0 || num>n){
                    throw new RuntimeException();
                }
            }
            if(n<1 || n>10000){
                throw new RuntimeException();
            }
            Arrays.sort(nums);
            for(int i=0;i<n;i++){

                if(n==1&& nums[i]==0){
                    return 1;
                }
                if(i==nums[i]){
                        continue;
                    }
                    else {
                        missingNum = i;
                        break;
                    }
                }

        }catch (Exception e){
            System.out.println("Invalid input");
        }
      return missingNum==(int)1e4+5?n : missingNum;
    }


    public static int missingNumberXOR(int[] nums){
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    public static void main(String[] args) {
        int[] nums={0,1,3,5,2};
        System.out.println(missingNumberXOR(nums));
    }
}
