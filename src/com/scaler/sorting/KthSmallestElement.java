package com.scaler.sorting;

import java.util.Arrays;

public class KthSmallestElement {

    public static int kthsmallest(final int[] A, int B) {

        if(B>=A.length){
            return -1;
        }
        Arrays.sort(A);
        return A[B-1];
    }

    public static void main(String[] args) {

        int[] arr={2, 1, 4, 3, 2};
        System.out.println(kthsmallest(arr,3));
    }
}
