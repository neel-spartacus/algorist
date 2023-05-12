package com.tleeliminators.prefixsum.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Flowers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        long mod = (long) 1e9 + 7;
        String[] str = br.readLine().split(" ");
        int cases = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);


        int[][] dp= new int [100005][2];
        // 0-> red rose
        // 1-> white rose
        //state-dp[length][rose]->number of ways roses can be selected from string length
        dp[1][0]=1;
        dp[k][1]=1;//Only when K white roses are there in subsequence, it can be selected to get 1 way to select them.

        long[][] prefixSum= new long[100005][2];
        prefixSum[0][0]=0;
        prefixSum[0][1]=0;
        for( int i=2;i<100005;i++){
            dp[i][0]+=(dp[i-1][0]%mod+dp[i-1][1]%mod)%mod;
            dp[i][1]+=(((i-k<0)?0:dp[i-k][0]%mod)+((i-k<0)?0:dp[i-k][1]%mod))%mod;
        }
        for(int i=1;i<100005;i++){
            prefixSum[i][0]=(prefixSum[i-1][0] + dp[i][0])%mod;
            prefixSum[i][1]=(prefixSum[i-1][1] + dp[i][1])%mod;
        }
        StringBuilder stringBuilder= new StringBuilder();
        for(int init=0;init<cases;init++){
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            long ans=0;
            ans+= (prefixSum[end][0]-prefixSum[start-1][0]<0?mod+(prefixSum[end][0]-prefixSum[start-1][0]):prefixSum[end][0]-prefixSum[start-1][0])%mod;
            ans+=(prefixSum[end][1]-prefixSum[start-1][1]<0?mod+ (prefixSum[end][1]-prefixSum[start-1][1]):prefixSum[end][1]-prefixSum[start-1][1])%mod;
            ans%=mod;
            stringBuilder.append(ans).append(System.lineSeparator());
        }
        System.out.println(stringBuilder.toString());

        br.close();

    }
}
