package com.tleeliminators.prefixsum.dynamicprogramming;

//https://atcoder.jp/contests/dp/tasks/dp_f

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String[] str1 = br.readLine().split("");
        int m=str1.length;
        String[] str2 = br.readLine().split("");
        int n=str2.length;
        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(str1[i-1].equals(str2[j-1])){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        //System.out.println(dp[m][n]);
        StringBuilder sb = new StringBuilder();

        int len1=m;
        int len2=n;
        while (len1!=0 && len2 !=0){
            if(str1[len1-1].equals(str2[len2-1])){
                    sb.append(str1[len1-1]);
                    len1=len1-1;
                    len2=len2-1;
            }
            else if(dp[len1][len2-1]<dp[len1-1][len2]){
                len1--;

            }else{
                len2--;
            }
        }

        System.out.println(sb.reverse());

        br.close();


    }

}
