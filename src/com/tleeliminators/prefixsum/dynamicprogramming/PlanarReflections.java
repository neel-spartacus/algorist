package com.tleeliminators.prefixsum.dynamicprogramming;


//https://codeforces.com/problemset/problem/1498/C

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlanarReflections {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        long mod = (long) 1e9 + 7;
        int numOfElements = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfElements; i++) {
            String[] inputs = br.readLine().split(" ");
            int planes = Integer.parseInt(inputs[0]);
            int decayAge = Integer.parseInt(inputs[1]);

            long[][][] dp = new long[1001][1001][2];


            for(int p=0;p<1001;p++){
                for(int q=0;q<1001;q++){
                    for(int r=0;r<2;r++){
                        dp[p][q][r]=-1;
                    }

                }
            }
            int numOfParticles=reflections(1,decayAge,1,dp,planes,mod);
            System.out.println(numOfParticles);

        }

        br.close();
    }

    public static int reflections(int planes,int decayAge,int direction,long[][][] dp,int totalPlanes,long mod){

        if(decayAge==1){
            return 1;
        }
        if(dp[planes][decayAge][direction]!=-1){
            return (int) dp[planes][decayAge][direction];
        }
        long ans=2;
        if(direction==1){
            if(planes<totalPlanes){
                ans+=reflections(planes+1,decayAge,direction,dp,totalPlanes,mod)-1;
            }
            ans%=mod;
            if(planes>1){
                ans+=reflections(planes-1,decayAge-1,1-direction,dp,totalPlanes,mod)-1;
            }
            ans%=mod;
            dp[planes][decayAge][direction]=ans;

        }else{
            if(planes>1){
                ans+=reflections(planes-1,decayAge,direction,dp,totalPlanes,mod)-1;
            }
            ans%=mod;
            if(planes<totalPlanes){
                ans+=reflections(planes+1,decayAge-1,1-direction,dp,totalPlanes,mod)-1;
            }
            ans%=mod;
            dp[planes][decayAge][direction]=ans;
        }

        return (int) ans;
    }
}
