package com.tleeliminators.prefixsum.dynamicprogramming;

// Problem : https://cses.fi/problemset/task/1634

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimizingCoins {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int noOfCoins = Integer.parseInt(str[0]);
        int sum = Integer.parseInt(str[1]);
        String[] values = br.readLine().split(" ");

        int[] coinValues = new int[noOfCoins];

        for (int i = 0; i < noOfCoins; i++) {
            coinValues[i] = Integer.parseInt(values[i]);
        }

        long[] minMumOfCoins = new long[sum + 1];
        long num=0;
        minMumOfCoins[0]=0;


        for (int i = 1; i < sum+1; i++) {
            minMumOfCoins[i]=Integer.MAX_VALUE;
           for(int value:coinValues){
               if(value<=i){
                   num=minMumOfCoins[i-value]+1;
                   minMumOfCoins[i]=num<minMumOfCoins[i]?num:minMumOfCoins[i];
               }
           }

        }

        System.out.println(minMumOfCoins[sum]>0 && minMumOfCoins[sum]<Integer.MAX_VALUE?minMumOfCoins[sum]:(minMumOfCoins[sum]==0)?0:-1);
        br.close();
    }
}
