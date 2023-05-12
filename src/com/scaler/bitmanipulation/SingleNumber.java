package com.scaler.bitmanipulation;

public class SingleNumber {

    public static int singleNumber(final int[] A) {

        int xor=A[0];
        int n=A.length;
        for(int i=1;i<n;i++){
            xor^=A[i];
        }

        return xor;
    }

    public static void main(String[] args) {

        int[] A={1, 2, 2, 3, 1};
        System.out.println(singleNumber(A));
    }
}
