package com.leetcode.weekly.contests.twoeightyfour;

import java.util.Stack;

public class MaximizeTopMostElement {

    public static int maximumTop(int[] nums, int k) {

        int len=nums.length;
        if(len==1 && k>=1){
            return -1;
        }
        int max=Integer.MIN_VALUE;
        Stack<Integer> stack= new Stack<>();
        for(int i=len-1;i>=0;i--){
            stack.push(nums[i]);
        }
        while (k>1){
            if(stack.isEmpty()){
                stack.push(max);
            }
            else {
                int removedItem=stack.pop();
                max=Math.max(max,removedItem);
            }

            k--;
        }

        while (k!=0 && !stack.isEmpty()){
            int pop=stack.pop();
            if(!stack.isEmpty()){
                int pop2=stack.pop();
                if(pop<pop2){
                    max=Math.max(max,Math.max(pop,pop2));
                }
            }
            k--;
        }
        return max==Integer.MIN_VALUE?-1:max;

    }

    public static void main(String[] args) {

        int[] nums={99,95,68,24,18};
        int k=69;
        System.out.println(maximumTop(nums,k));
    }
}
