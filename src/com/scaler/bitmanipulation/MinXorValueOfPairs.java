package com.scaler.bitmanipulation;

import java.util.Arrays;

public class MinXorValueOfPairs {

    public static int findMinXor(int[] A) {
        Arrays.sort(A);

        int n=A.length;
        int min=Integer.MAX_VALUE;
        int val=0;

        for(int i=0;i<n-1;i++){
            val=A[i]^A[i+1];
            min=Math.min(val,min);
        }

        return min;
    }

    public static void main(String[] args) {
       // int[] A={ 4, 7,0, 9};
        int[] A={ 15, 5, 1, 10, 2};
        System.out.println(findMinXor(A));
    }
}
