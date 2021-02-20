package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

public class NumberOfWaysToCover {

    static int lcs(int arr){

        int[] dp= new int[arr+1];

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=arr;i++){

            if(i-3>=0){
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
            else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }

        return dp[arr];
    }

    public static void main(String[] args) {
        int dist=4;

        System.out.println(lcs(dist));

    }
}
