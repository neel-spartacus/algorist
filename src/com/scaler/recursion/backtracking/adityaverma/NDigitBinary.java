package com.scaler.recursion.backtracking.adityaverma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NDigitBinary {


    public static List<String> generate( int n){
        int ones=n,zeros=n;

        List<String> digitList= new ArrayList<>();
        String output="";

        helper(n,ones,zeros,output,digitList);

        return digitList;

    }

    public static void helper(int length,int ones,int zeros,String output,List<String> digitList){

        if(output.length()==length){
            digitList.add(output);
            return;
        }

        if(ones!=0){
            output+="1";
            helper(length,ones-1,zeros,output,digitList);
            output=output.substring(0,output.length()-1);
        }
        if(zeros>ones){
            output+="0";
            helper(length,ones,zeros-1,output,digitList);
        }

    }
    public static void main(String[] args) {

        int n=4;
        List<String> list=generate(n);
        System.out.println(Arrays.toString(list.toArray()));

    }
}
