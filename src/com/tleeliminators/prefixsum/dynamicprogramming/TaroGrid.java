package com.tleeliminators.prefixsum.dynamicprogramming;


//https://atcoder.jp/contests/dp/tasks/dp_h

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaroGrid {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        long mod=(long) 1e9+7;
        String[] str = br.readLine().split(" ");
        int row = Integer.parseInt(str[0]);
        int column = Integer.parseInt(str[1]);
        String[][]grid= new String[row+1][column+1];

        for(int i=1;i<row+1;i++){
            String[] values = br.readLine().split("");
            for(int j=1;j<column+1;j++){
                    grid[i][j]=values[j-1];
                }

            }
        long[][]dp=new long[row+1][column+1];

        for(int i=0;i<row+1;i++){
            for(int j=0;j<column+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                    grid[i][j]="#";
                }
            }
        }


        for(int i=1;i<=row;i++){
            for(int j=1;j<=column;j++){
               if(grid[i][j].equalsIgnoreCase(".")){
                   if(i==1 && j==1){
                       dp[1][1]=1;
                       continue;
                   }
                   else {
                       dp[i][j]=dp[i][j]+(dp[i][j-1]+dp[i-1][j])%mod;
                   }

               }
            }
        }

        System.out.println(dp[row][column]);

        br.close();
    }
}
