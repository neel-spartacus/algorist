package com.leetcode.dynamicprogramming.aditya.verma.slidingwindow;

public class MaxSumSubarray {


    public static int findMaxSumSubarray(int[] arr,int size,int window){

        int start=0;
        int end=0;
        int max=Integer.MIN_VALUE;
        int sum=0;


        while (end<size){
            sum=sum+arr[end];

            if(end-start+1<window){
                end++;
            }
            else if(end-start+1==window){
                max=Math.max(max, sum);
                sum=sum-arr[start];
                start++;
                end++;
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int N = 4, K = 2;
        int[] arr = {100, 200, 300, 400};

        System.out.println(findMaxSumSubarray(arr,N,K ));
    }
}
