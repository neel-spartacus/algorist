package com.leetcode.dynamicprogramming.easy;

public class LeetCode746 {

    public static int minCostClimbingStairs(int[] cost) {

        int size=cost.length;

        int[] zerothIndexDp= new int[size+1];
        int[] firstIndexDp= new int[size+1];

        zerothIndexDp[0]=cost[0];
        zerothIndexDp[1]=cost[1];
        firstIndexDp[0]=cost[1];
        firstIndexDp[1]=cost[2];

        for(int i=2;i<size+1;i++){
            if(i==size){
                zerothIndexDp[i]=Math.min(zerothIndexDp[i-1],zerothIndexDp[i-2]);
            }
            else{
                zerothIndexDp[i]=Math.min(zerothIndexDp[i-1],zerothIndexDp[i-2])+cost[i];
            }

        }

        for(int i=2;i<size+1;i++){
            if(i==size){
                firstIndexDp[i]=Math.min(firstIndexDp[i-1],firstIndexDp[i-2]);
            }
            else{
                firstIndexDp[i]=Math.min(firstIndexDp[i-1],firstIndexDp[i-2])+cost[i] ;
            }

        }

        return Math.min(zerothIndexDp[size],firstIndexDp[size]);

    }


    public static int minCostClimbingStairsOptimized(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            if (i<2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
    public static void main(String[] args) {

        int[]cost={1,1,0,0};

        System.out.println(minCostClimbingStairsOptimized(cost));

    }
}
