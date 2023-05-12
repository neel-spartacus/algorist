package com.tleeliminators.prefixsum.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//https://cses.fi/problemset/task/1745

public class MoneySums {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int noOfCoins = Integer.parseInt(br.readLine());

        String[] values = br.readLine().split(" ");

        int[] coinValues = new int[noOfCoins];
        int maxSum = 0;

        for (int i = 0; i < noOfCoins; i++) {
            coinValues[i] = Integer.parseInt(values[i]);
            maxSum += coinValues[i];
        }
        int[][] dp = new int[noOfCoins + 1][maxSum + 1];
        boolean[][] possibleSum = new boolean[noOfCoins + 1][maxSum + 1];

        for (int i = 0; i < noOfCoins + 1; i++) {
            for (int j = 0; j < maxSum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                    possibleSum[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                    possibleSum[i][j] = true;
                }
            }
        }

        for (int i = 1; i < noOfCoins + 1; i++) {
            for (int j = 1; j < maxSum + 1; j++) {
                if (coinValues[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - coinValues[i - 1]] + dp[i - 1][j];
                    possibleSum[i][j] = possibleSum[i - 1][j - coinValues[i - 1]] || possibleSum[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                    possibleSum[i][j] = possibleSum[i - 1][j];
                }
            }
        }

        int count = 0;
        for (int j = 1; j < maxSum + 1; j++) {
            if (possibleSum[noOfCoins][j]) {
                count++;
            }
        }
        List<Integer> distinctSums = new ArrayList<>();

        for (int j = 1; j < maxSum + 1; j++) {
            if (dp[noOfCoins][j] != 0) {
                distinctSums.add(j);
            }
        }
        System.out.println(count);
        String finalSulList = distinctSums.stream().map(i -> i.toString()).collect(Collectors.joining(" "));
        System.out.println(finalSulList);
        br.close();
    }
}
