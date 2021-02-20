package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

import java.util.Scanner;

public class LongestCommonSubsequence {

    static int lcs(char[] first,char[] second){

        int len1=first.length;
        int len2=second.length;
        int[][] lcs= new int[len1+1][len2+1];
        lcs[0][0]=0;
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                 if(i==0 || j==0){
                     lcs[i][j]=0;
                 }
                 else if(first[i-1]==second[j-1]){
                     lcs[i][j]=lcs[i-1][j-1]+1;
                 }
                 else{
                     lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
                 }
            }
        }

        int answer=lcs[len1][len2];

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstWord=sc.next();
        String secondWord=sc.next();

        char[] first=firstWord.toCharArray();
        char[] second=secondWord.toCharArray();

        System.out.println(lcs(first,second));

    }
}
