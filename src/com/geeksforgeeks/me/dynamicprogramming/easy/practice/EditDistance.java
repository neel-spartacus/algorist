package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

import java.util.Scanner;

public class EditDistance {

    static int lcs(char[] first,char[] second){

        int len1=first.length;
        int len2=second.length;
        int[][] lcs= new int[len2+1][len1+1];
        lcs[0][0]=0;
        for(int p=1;p<=len1;p++){
            lcs[0][p]=p;
        }
        for(int q=1;q<=len2;q++){
            lcs[q][0]=q;
        }
        for(int i=1;i<=len2;i++){
            for(int j=1;j<=len1;j++){
                 if(second[i-1]==first[j-1]){
                     lcs[i][j]=lcs[i-1][j-1];
                 }
                 else{
                     lcs[i][j]=Math.min(Math.min(lcs[i-1][j],lcs[i][j-1]),lcs[i-1][j-1])+1;
                 }
            }
        }

        int answer=lcs[len2][len1];

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
