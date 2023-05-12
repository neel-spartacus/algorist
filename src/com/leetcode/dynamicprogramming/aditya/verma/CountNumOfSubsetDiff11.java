package com.leetcode.dynamicprogramming.aditya.verma;

public class CountNumOfSubsetDiff11 {

    public static int numOfsubset(int[] nums,int target){

        int n=nums.length;
        int sum=0;
        int subset=0;
        /*Suppose the two subsets are s1 and s2.Therefore the below equations exsit:
          s1-s2=diff and s1+s2=sum
          Adding both,
          2s1=sum+diff
          s1=(sum+diff)/2*/
        for (int i=0;i<n;i++){
            sum+=nums[i];
        }

        subset=(sum+target)/2;

        return countNumOfSubsets(nums, subset);


    }

    public static int countNumOfSubsets(int[]arr,int sum){

        int n=arr.length;
        int[][] t = new int[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=1;
                }

            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]]+t[i-1][j];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {

        int[]arr={5,2,2,7,3,7,9,2,3};
        int diff=9;

        System.out.println(numOfsubset(arr, diff));
    }
}
