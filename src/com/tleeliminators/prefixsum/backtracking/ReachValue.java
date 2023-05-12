package com.tleeliminators.prefixsum.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReachValue {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder stringBuilder= new StringBuilder();
        for(int i = 0;i<t;i++){

            long reachValue=Long.parseLong(br.readLine());
            stringBuilder.append(reachValue(1,1, reachValue));
            stringBuilder.append(System.lineSeparator());



        }

        System.out.println(stringBuilder);
    }

    public static String reachValue(long n,long m,long reachValue){

        if(n==reachValue || m==reachValue){
            return "YES";
        }

        if(reachValue%10!=0 && reachValue%20!=0){
            return "NO";

        }

        long multipleTen=n*10;
        long multipleTwenty=m*20;
        long multiPleOfBoth=n*20;
        long multiPleOfBoth1=m*10;

        if(multipleTen==reachValue || multiPleOfBoth==reachValue || multiPleOfBoth1==reachValue|| multipleTen==reachValue){
            return "YES";
        }



        if(n>reachValue && m>reachValue ){
            return "NO";
        }

        return reachValue(multipleTen,multipleTwenty,reachValue);


    }
}
