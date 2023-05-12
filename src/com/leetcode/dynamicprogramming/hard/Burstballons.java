package com.leetcode.dynamicprogramming.hard;

//Problem no:316 leetcode
public class Burstballons {


    public static int maxCoins(int[] nums) {

        int n=nums.length;

        if(n==0){
            return 0;
        }

        int dp[][]=new int[n][n];
        for(int L=n-1;L>0;L--){
            for(int R=L;R<n;R++){

                for(int i=L;i<=R;i++){
                   /* if(L-1<0){
                        nums[L-1]=1;
                    }
                    if(R+1>n-1){
                        nums[R+1]=1;
                    }*/
                    dp[L][R]=Math.max(dp[L][R],((nums[i]*(L==0?1:nums[L-1])*(R==n-1?1:nums[R+1]))+ (L<=i-1?dp[L][i-1]:0)+(i+1<=R?dp[i+1][R]:0)));
                }
            }

        }
        return dp[0][n-1];
    }


    public static void main(String[] args) {
        int[] nums=new int[]{3,1,5,8};
        System.out.println(maxCoins(nums));
    }
}
