package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

public class PartitionSubset {

    static boolean lcs(int[] arr){

        int len1=arr.length;
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


        return recursive(arr, targetSum, 0,len1);
    }

    static boolean recursive(int[] val,int sum,int count,int length){
        if(count<length){
            if(sum-val[count]==0){
                return true;
            }
            else{
                return recursive(val, sum,count+1,length);
            }
        }
       return false;
    }

    public static void main(String[] args) {

        int[] arr= new int[]{1,5,11,5};

        System.out.println(lcs(arr));

    }
}
