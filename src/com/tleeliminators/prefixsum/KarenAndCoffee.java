package com.tleeliminators.prefixsum;

//Problem : https://codeforces.com/contest/816/problem/B

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KarenAndCoffee {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        double N = 2e5+10;
        String s = br.readLine();

        String[] s1 = s.split(" ");
        int noOfRecipes = Integer.parseInt(s1[0]);
        int minNumOfRecipes = Integer.parseInt(s1[1]);
        int numOfQueries = Integer.parseInt(s1[2]);
        //int k = Integer.parseInt(s1[2]);

        long[] prefix = new long[(int) N+1];


        prefix[0]=0;
        for (int i = 1; i < noOfRecipes+1; i++) {
            String recipes = br.readLine();
            String[] recipe = recipes.split(" ");
            long a = Long.valueOf(recipe[0]);
            long b = Long.valueOf(recipe[1]);
            prefix[(int)a]++;
            prefix[(int)b+1]--;

        }

        for(int i=0;i<(int)N;i++){
            prefix[i]+=(i==0)?0:prefix[i-1];
        }

        for(int i=0;i<(int)N;i++){
            if(prefix[i]>=minNumOfRecipes){
                prefix[i]=1;
            }
            else{
                prefix[i]=0;
            }
            prefix[i]+=(i==0)?0:prefix[i-1];
        }


        for (int i = 0; i < numOfQueries; i++) {

            String queryLine = br.readLine();
            String[] queries = queryLine.split(" ");

            int count = 0;
            long a = Long.valueOf(queries[0]);
            long b = Long.valueOf(queries[1]);

            //Since l and r in query will be sored in index i-1 and j-1
            //So,range will be given by prefix[j-1]-prefix[i-1-1]
            System.out.println(prefix[(int)b]-prefix[(int)a-1]);
        }

        br.close();

    }
}
