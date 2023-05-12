package com.scaler.searching;

import java.util.Arrays;

public class AggressiveCows {

    public static int solve(int[] A,int B){

        Arrays.sort(A);
        int maxElement=A[A.length-1];
        int minElement=A[0];

        //No of edges between n nodes will be n-1.So,there will be B-1 distances between B cows.
        int maxRange=((maxElement-minElement)/(B-1));

        int l=1;
        int r=maxRange;

        while (l<r){

            int mid=l+((r-l)/2);
            if(maxFeasibleDistance(mid,A,B)){
                l=mid+1;
            }

            else{
                r=mid-1;
            }

        }
        return maxFeasibleDistance(l,A,B)?l:l-1;

    }

    private static boolean maxFeasibleDistance(int mid, int[] arr,int cows) {
        int initVal=arr[0];
        cows-=1;//For 1st position
        int i=1;
       while (i<arr.length && cows>0){
           if(arr[i]-initVal>=mid){
               cows--;
               initVal=arr[i];
           }
           i++;
       }
       if(cows<=0){
           return true;
       }
       else{
           return false;
       }

    }

    public static int maxElement(int[] arr){
        int max=Integer.MIN_VALUE;
        int len=arr.length;
        for(int i=0;i<len;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public static int minElement(int[] arr){
        int min=Integer.MAX_VALUE;
        int len=arr.length;
        for(int i=0;i<len;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        //int[] A={5, 17, 100, 11 };
        //int[] A={1,2,3,4,5};
        int[] A={82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95 };
        int B=8;

        System.out.println(solve(A,B));
    }
}
