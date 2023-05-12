package com.tleeliminators.prefixsum.dynamicprogramming;


// https://atcoder.jp/contests/dp/tasks/dp_i

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ICoins {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        long mod = (long) 1e9 + 7;
        int num = Integer.parseInt(br.readLine());

        String[] probabilities = br.readLine().split(" ");
        int size=probabilities.length;
        double[] headProbabilities= new double[size];
        for(int i=0;i<size;i++){
            headProbabilities[i]=Double.parseDouble(probabilities[i]);
        }

        double[][] dp= new double[num+1][num+1];

        dp[0][0]=1;

        for(int i=1;i<size+1;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]*(1-headProbabilities[i-1]);
                }
                else{
                    dp[i][j]=dp[i-1][j]*(1-headProbabilities[i-1])+dp[i-1][j-1]*headProbabilities[i-1];
                }
            }
        }

        double ans=0.0;
        for(int i=size;i>(size/2);i--){
            ans+=dp[size][i];
        }

        System.out.println(ans);

        br.close();
    }
}
