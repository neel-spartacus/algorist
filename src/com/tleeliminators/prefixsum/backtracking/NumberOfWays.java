package com.tleeliminators.prefixsum.backtracking;

//https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/Y


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfWays {

    public static int numOfWays(int n,int[] result){

      if(n==0 || n==1){
          return 1;
      }
      else if(n==2){
          return 2;
      }
      else{
          result[0]=1;
          result[1]=1;
          result[2]=2;

          for(int i=3;i<n+1;i++){
              result[i]=result[i-3]+result[i-2]+result[i-1];
          }

      }

     return result[n];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int start=Integer.parseInt(str[0]);
        int end=Integer.parseInt(str[1]);
        int n=end-start;
        int[] result= new int[n+1];

        System.out.println(numOfWays(n, result));

    }
}
