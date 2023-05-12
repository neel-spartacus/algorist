package com.tleeliminators.prefixsum.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinCombinations2 {
    static final int MOD = 1000000007;
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


        // dp[w] = the number of ordered ways to add coins up to w
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < noOfCoins; i++) {  // loop through coins
            for (int w = 0; w <= sum; w++) {  // loop through sums
                if (w - coinValues[i] >= 0) {  // prevent out of bounds cases
                    dp[w] = (dp[w] + dp[w - coinValues[i]]) % MOD;
                }
            }
        }
        System.out.println(dp[sum]);
    }
}
