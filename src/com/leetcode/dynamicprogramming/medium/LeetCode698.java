package com.leetcode.dynamicprogramming.medium;

public class LeetCode698 {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length;
        int sum=0;

        boolean[] visited= new boolean[n];

        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(k<=0 || k>=16 || sum%k!=0){
            return false;
        }
        int m=sum/k;
        int[][] t=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=1;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(nums[i-1]<=j){
                    t[i][j]=t[i-1][j-nums[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }

        }
        return k==t[n][m]?true:false;
    }


  /*  public static boolean canPartitionOptimized(int[] nums){

        int n=nums.length;
        int sum=0;


        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int m=sum/2;

        boolean[] dp = new boolean[sum+1];

        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > num; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];

    }*/

    public static void main(String[] args) {
        int[] nums={4,3,2,3,5,2,1};
        int k=4;

        System.out.println(canPartitionKSubsets(nums,k));
    }
}
