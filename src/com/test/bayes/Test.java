package com.test.bayes;

public class Test {


    public static int  solve(String str){

        char[] chars=str.toCharArray();

        int evenSum=0;
        for(int i=0;i<chars.length; i=i+2 ){
            evenSum+=chars[i]-'0' ;
        }
        evenSum*=3;
        for(int i=1;i<chars.length; i=i+2 ){
            evenSum+=chars[i]-'0' ;
        }

        int lastDisgit=evenSum%10;

        return lastDisgit!=0?10-lastDisgit:lastDisgit;

    }

    public static void main(String[] args) {

        String str="39847";
        System.out.println(solve(str));

    }
}
