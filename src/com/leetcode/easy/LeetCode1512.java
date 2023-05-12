package com.leetcode.easy;

public class LeetCode1512 {
    public static int numIdenticalPairs(int[] nums) {

        int size=nums.length;
        int count=0;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(nums[i]==nums[j] && i<j){
                    count++;
                }
            }
        }

 return count;
    }

    public static int numIdenticalPairsLinear(int[] nums) {
        int res = 0, count[] = new int[101];
        for (int a: nums) {
            res += count[a]++;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums=new int[]{1,2,3,1,1,3};
        System.out.println(numIdenticalPairsLinear(nums));
    }
}
