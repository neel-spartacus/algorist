package com.scaler.maths;

public class ClosestMinMax {

    public static int solve(int[] A) {

        int n=A.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int minSubArray=Integer.MAX_VALUE;

        int lIndex=-1;
        int rIndex=-1;

        for(int i=0;i<n;i++){
            min=Math.min(min,A[i]);
            max=Math.max(max,A[i]);
        }

        for(int i=0;i<n;i++){
            if(A[i]==min){
                lIndex=i;
            }
            if(A[i]==max){
                rIndex=i;
            }
            if(lIndex!=-1 && rIndex!=-1){
                int size=Math.abs(rIndex-lIndex)+1;
                minSubArray=Math.min(minSubArray,size);
            }
        }
        return minSubArray;
    }

    public static void main(String[] args) {

        int[] A={343, 291, 963, 165, 152};
        System.out.println(solve(A));
    }
}
