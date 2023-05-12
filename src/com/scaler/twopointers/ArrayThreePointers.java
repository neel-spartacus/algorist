package com.scaler.twopointers;

public class ArrayThreePointers {

    public static int minimize(final int[] A, final int[] B, final int[] C) {

        int sizeA=A.length;
        int sizeB=B.length;
        int sizeC=C.length;

        int minMax=Integer.MAX_VALUE;

        int i=0;
        int j=0;
        int k=0;

        while (i<sizeA && j<sizeB && k<sizeC){

            minMax=Math.min(minMax,Math.max(Math.abs(A[i]-B[j]),Math.max(Math.abs(B[j]-C[k]),Math.abs(C[k]-A[i]))));
            int min=Math.min(A[i],Math.min(B[j],C[k]));
            if(min==A[i]){
                i++;
            }else if(min==B[j]){
                j++;
            }else {
                k++;
            }

        }

        return minMax;
    }

    public static void main(String[] args) {

        int[] A={1, 4, 10};
        int[] B={2, 15, 20};
        int[] C={10, 12};

        System.out.println(minimize(A,B,C));
    }
}
