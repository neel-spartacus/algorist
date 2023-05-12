package com.tleeliminators.prefixsum.backtracking;


//https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/H

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InvertedPyramid {

    public static void pyramid(int t,int org,StringBuilder sb){
        if(t==0){
            return;
        }
            // Inner loop print space
            for(int j = t; j < org; j++)
            {
               sb.append(" ");
            }

            // Inner loop print star
            for(int j = 1; j <= (2 * t - 1); j++)
            {
                sb.append("*");
            }

            // Ending line after each row
            sb.append(System.lineSeparator());

        pyramid(t-1,org,sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        double N = 2e5 + 10;
        int t = Integer.parseInt(br.readLine());
        int org=t;
        StringBuilder sb =new StringBuilder();
        pyramid(t,org,sb);
        System.out.println(sb);


    }
}
