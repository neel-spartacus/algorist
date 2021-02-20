package com.leetcode.dynamicprogramming;

public class MaxSubArrayDp {

   /* public static int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = Math.max(Integer.MIN_VALUE, current);

        for (int i = 1; i < nums.length; i ++) {
            if(current < 0) {
                current = nums[i];
                max = Math.max(max, nums[i]);
            } else {
                current += nums[i];
                max = Math.max(max, current);
            }
        }

        return max;
    }*/


    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxCur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCur = Math.max(nums[i], maxCur + nums[i]);
            maxSum = Math.max(maxCur, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {

        int[] value={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(value));

    }
}
