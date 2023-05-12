package com.scaler.arrays;

public class MaxAbsDiffValueIndexSum {

    public static void main(String[] args) {
       // int arr[]={3, -2, 5, -4};
        int arr[]={1, 3, -1};
        System.out.println(maxAbsDiffValueIndexSum(arr));
    }

    public static int maxAbsDiffValueIndexSum(int[] arr){
        int maxValue=Integer.MIN_VALUE;
        int minValue=Integer.MAX_VALUE;
        int maxSum;
        int maxDiff;

        for(int i=0;i<arr.length;i++){
            int sum=arr[i]+i;
            if(maxValue<sum){
                maxValue=sum;
            }
            if(minValue>sum){
                minValue=sum;
            }
        }
        maxSum=maxValue-minValue;
         maxValue=Integer.MIN_VALUE;
         minValue=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int diff=arr[i]-i;
            if(maxValue<diff){
                maxValue=diff;
            }
            if(minValue>diff){
                minValue=diff;
            }
        }
        maxDiff=maxValue-minValue;

        return Math.max(maxSum,maxDiff);
    }
}
