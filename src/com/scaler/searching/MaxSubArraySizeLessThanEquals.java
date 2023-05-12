package com.scaler.searching;

//https://www.geeksforgeeks.org/longest-subarray-sum-elements-atmost-k/


public class MaxSubArraySizeLessThanEquals {


    public static int  solution(int[] A,int K){
        int len=A.length;
        int[] prefixSum=new int[len];
        prefixSum[0]=A[0];

        for(int i=1;i<len;i++){
            prefixSum[i]=prefixSum[i-1]+A[i];
        }
        int l=0;
        int r=len-1;
        int maxIndex=Integer.MIN_VALUE;

        while (l<r){

            int mid=l+((r-l)/2);
            int maxSumInThisWindow=maxSubArraySum(A,len,mid);

            if(maxSumInThisWindow<=K){
                l=mid;
            }
            else{
                r=mid-1;
            }
        }
        return l+1;//since index is 0 based,hence adding 1;
    }

    private static int maxSubArraySum(int[] a, int size,int window) {

        int left=0;
        int right=0;
        int sum=0;
        int maxSum=Integer.MIN_VALUE;

        while(right<size){
            sum+=a[right];
            if(right-left+1<window){
                right++;
            }
            else if(right-left+1==window){
                maxSum=Math.max(maxSum,sum);
                sum-=a[left];
                left++;
                right++;
            }
        }

        return maxSum;

    }

    public static void main(String[] args) {


        int[] A={1, 2, 1, 0, 1, 1, 0};
        int K=4;
        System.out.println(solution(A,K));

    }

}
