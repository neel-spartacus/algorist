package com.leetcode.dynamicprogramming.aditya.verma.slidingwindow;

public class LargestSubarrayOfSumK {


    public static int findLargestSubarrayOfSum(int[] arr,int k){

        int n=arr.length;
        int start=0;
        int end=0;
        int sum=0;
        int max=Integer.MIN_VALUE;

        while (end<n){

            sum=sum+arr[end];
            if(sum<k){
                end++;
            }
            else if(sum==k){
                max=Math.max(max, end-start+1);
                end++;
            }
            else{
                while (sum>k){
                    sum=sum-arr[start];
                    start++;
                }
                end++;

            }

        }

    return max;
    }

    public static void main(String[] args) {

        int[] arr= {4,1,1,1,2,3,5};
        int k=5;

        System.out.println(findLargestSubarrayOfSum(arr, k));

    }
}
