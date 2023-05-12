package com.tleeliminators.prefixsum.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSumOfProducts {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int numOfElements = Integer.parseInt(br.readLine());

        String[] firstInputs = br.readLine().split(" ");

        String[] secondInputs = br.readLine().split(" ");

        int[] arrayOne = new int[numOfElements];
        int[] arrayTwo = new int[numOfElements];

        for(int i=0;i<numOfElements;i++){
            arrayOne[i]=Integer.parseInt(firstInputs[i]);
            arrayTwo[i]=Integer.parseInt(secondInputs[i]);
        }

        long[] dp= new long[numOfElements+1];
        dp[0]=0;
        for(int i=0;i<numOfElements;i++){
            for(int j=0;j<numOfElements;j++){
                //dp[i][j]=(j-1)<0?Math.max(arrayTwo[i]*arrayOne[j],arrayTwo[i]*arrayOne[j+1]):((j+1)>=numOfElements)?Math.max(arrayTwo[i]*arrayOne[j],arrayTwo[i]*arrayOne[j-1]):Math.max(arrayTwo[i]*arrayOne[j-1],Math.max(arrayTwo[i]*arrayOne[j],arrayTwo[i]*arrayOne[j+1]));
            }
        }

    }



}
