package com.scaler.sorting;

import java.util.Arrays;

public class MergeSortedArrays {


    public static int[] solve(final int[] A, final int[] B) {

        int sizeA=A.length;
        int sizeB=B.length;

        int[] result=new int[sizeA+sizeB];

        int i=0;
        int j=0;
        int k=0;

        while (i<sizeA&&j<sizeB){
            if(A[i]<=B[j]){
                result[k]=A[i];
                i++;
            }else{
                result[k]=B[j];
                j++;
            }
            k++;
        }

        if(i==sizeA){
            for(int p=j;p<sizeB;p++){
                result[k]=B[p];
                k++;
            }
        }
        if(j==sizeB){
            for(int p=i;p<sizeA;p++){
                result[k]=A[p];
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] A={-4,3};
        int[] B={-2,-2};

        int[] result=solve(A,B);

        System.out.println(Arrays.toString(result));
    }
}
