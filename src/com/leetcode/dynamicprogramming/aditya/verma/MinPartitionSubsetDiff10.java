package com.leetcode.dynamicprogramming.aditya.verma;


import sun.awt.image.IntegerComponentRaster;

import java.util.ArrayList;
import java.util.List;

public class MinPartitionSubsetDiff10 {

    public static int minSubsetDiff(int[] arr){

        int n=arr.length;
        int range=0;
        int minSubsetDiff= Integer.MAX_VALUE;

        List<Integer> subset= new ArrayList<>();

        for(int i=0;i<n;i++){
            range+=arr[i];
        }
        boolean[][] t= new boolean[n+1][(range+1)/2];
        subsetSum(t, arr, (range+1)/2);

        for(int j=1;j<(range+1)/2;j++){
            if(t[n][j]==true){
                subset.add(j);
            }
        }

        for(int value:subset){
            minSubsetDiff=Math.min(minSubsetDiff, (range-(2*value)));
        }

        return minSubsetDiff;
    }

    public static void subsetSum(boolean[][] t,int[] arr, int sum ){
        int n=arr.length;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum;j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }

        }
    }

    public static void main(String[] args) {

        int[] arr={1, 6, 11, 5};
        //int[] arr={1,2,7};

        System.out.println(minSubsetDiff(arr));
    }
}
