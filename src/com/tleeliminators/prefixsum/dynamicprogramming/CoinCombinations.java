package com.tleeliminators.prefixsum.dynamicprogramming;


// https://cses.fi/problemset/task/1636


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinCombinations {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        long mod=(long) 1e9+7;
        String[] str = br.readLine().split(" ");
        int noOfCoins = Integer.parseInt(str[0]);
        int sum = Integer.parseInt(str[1]);
        String[] values = br.readLine().split(" ");

        int[] coinValues = new int[noOfCoins];

        for (int i = 0; i < noOfCoins; i++) {
            coinValues[i] = Integer.parseInt(values[i]);
        }
        long[][] dp = new long[noOfCoins + 1][sum + 1];

        for (int i = 0; i < noOfCoins + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }
                if(j==0){
                    dp[i][j]=1;
                }
            }
        }

        for(int i=1;i<noOfCoins+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coinValues[i-1]<=j){
                    dp[i][j]=dp[i][j]+ (dp[i][j-coinValues[i-1]]+dp[i-1][j])%mod;
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        System.out.println(dp[noOfCoins][sum]);
        br.close();

    }
}
