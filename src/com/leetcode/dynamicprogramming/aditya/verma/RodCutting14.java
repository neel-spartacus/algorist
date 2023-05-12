package com.leetcode.dynamicprogramming.aditya.verma;

public class RodCutting14 {

    public static int maxRodCutPrice(int length,int[] price){

        int[]cuts= new int[length];
        for(int i=0;i<length-1;i++){
            cuts[i]=i+1;
        }
        int[][] t=new int[cuts.length+1][length+1];

        for(int i=0;i<=cuts.length;i++){
            for(int j=0;j<=length;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }

        for(int i=1;i<=cuts.length;i++){
            for(int j=1;j<=length;j++){

                if (cuts[i - 1] <= j) {
                    t[i][j]=Math.max(price[i-1]+t[i][j-cuts[i-1]],t[i-1][j] );
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[cuts.length][length];

    }

    public static void main(String[] args) {

        int rodLength=8;
        int[]price={3, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(maxRodCutPrice(rodLength, price));

    }
}
