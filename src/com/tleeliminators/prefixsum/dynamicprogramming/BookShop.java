package com.tleeliminators.prefixsum.dynamicprogramming;


//https://cses.fi/problemset/task/1158

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookShop {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        long mod = (long) 1e9 + 7;
        String[] str = br.readLine().split(" ");
        int noOfBooks = Integer.parseInt(str[0]);
        int maxTotalPrice = Integer.parseInt(str[1]);
        String[] bookPrices = br.readLine().split(" ");
        String[] bookPages = br.readLine().split(" ");

        int[] price = new int[noOfBooks];
        int[] pages = new int[noOfBooks];

        for (int i = 0; i < noOfBooks; i++) {
            price[i] = Integer.parseInt(bookPrices[i]);
            pages[i] = Integer.parseInt(bookPages[i]);
        }

         long[][] dp = new long[noOfBooks + 1][maxTotalPrice + 1];


        for (int i = 0; i < noOfBooks + 1; i++) {
            for (int j = 0; j < maxTotalPrice + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }
                if(j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1;i<noOfBooks+1;i++){
            for(int j=1;j<maxTotalPrice+1;j++){
                if(price[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-price[i-1]]+pages[i-1]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

            System.out.println(dp[noOfBooks][maxTotalPrice]);
            br.close();
        }

    }
