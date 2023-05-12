package com.leetcode.dynamicprogramming.medium;

public class LeetCodeTargetSum494 {

    public static int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            if(target==nums[0]  || target==-nums[0]){
                return 1;
            }
            else if(target==0){
                return 0;
            }
            else{
                return 0;
            }

        }
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

        if(target==0 && (sum%2!=0)){
            return 0;
        }

        if((sum+target)%2!=0){
            return 0;
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
            for(int j=0;j<sum+1;j++){
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

        int[] nums={5,2,2,7,3,7,9,0,2,3};
        int target=9;

        System.out.println(findTargetSumWays(nums,target));
    }
}
