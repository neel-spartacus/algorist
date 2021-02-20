package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

import java.util.Arrays;

public class PartitionSubsetDP {

    static boolean lcs(int[]arr){

        int len1=arr.length;
        Arrays.sort(arr);
        int sum=0;
        int targetSum=0;
        for(int i = 0;i<len1;i++){
            sum+=arr[i];
        }
        if(sum%2!=0){
            return false;
        }
        else{
            targetSum=sum/2;
        }
        int[][] lcs= new int[len1][targetSum+1];
        for(int k=0;k<len1;k++){
            lcs[k][0]=0;
        }
        for(int i=0;i<len1;i++){
            for(int j=1;j<=targetSum;j++){
                 if(j<arr[i]){
                     lcs[i][j]=lcs[i-1][j];

                     }
                 else{
                     if(arr[i]==1){
                         lcs[i][j]=1;
                         continue;
                     }
                     else {
                         lcs[i][j]=Math.max(arr[i]+ lcs[i-1][j-arr[i]], lcs[i-1][j]);
                     }
                 }
            }
        }

        int answer=lcs[len1-1][targetSum];
        return answer==targetSum;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{1,8,7,4,6,6};

        System.out.println(lcs(arr));

    }
}
