package com.scaler.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateParenthesis {


    public static ArrayList<String> generateParenthesis(int A) {

        int open=A,close=A;
        ArrayList<String> generatedParenthesis = new ArrayList<>();

        helper(open,close,"",generatedParenthesis);

        return generatedParenthesis;

    }

    public static void helper(int open,int close,String str,ArrayList<String> parenthesisList){

        if(open==0 && close==0){
            parenthesisList.add(str);
            return;
        }

        if(open!=0) {
            str+="(";
            helper(open-1,close,str,parenthesisList);
            str=str.substring(0,str.length()-1);
        }
        if(close>open){
            str+=")";
            helper(open,close-1,str,parenthesisList);
            }

        }


    public static void main(String[] args) {

        int A=3;
        ArrayList<String> list=generateParenthesis(A);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
