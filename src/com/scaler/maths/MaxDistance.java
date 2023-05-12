package com.scaler.maths;

public class MaxDistance {

    //https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

    public static int maximumGap(final int[] A) {

        int n=A.length;
        int[] minL= new int[n];
        int[] maxR= new int[n];
        int lIndex=0;
        int rIndex=0;
        int maxDistance=-1;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        minL[0]=A[0];
        maxR[n-1]=A[n-1];
        for(int i=0;i<n;i++){
            min=Math.min(min,A[i]);
            minL[i]=min;
        }
        for(int j=n-1;j>=0;j--){
            max=Math.max(max,A[j]);
            maxR[j]=max;
        }

        while (lIndex<n && rIndex<n){
            if(minL[lIndex]<=maxR[rIndex]){
                maxDistance=Math.max(maxDistance,rIndex-lIndex);
                rIndex+=1;
            }
            else {
                lIndex+=1;
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        final int[]A={3, 5, 4, 2};
        System.out.println(maximumGap(A));
    }
}
