package com.scaler.twopointers;

import java.util.Arrays;

public class MaxContinuousSeriesOfOnes {


    public static  int[] maxone(int[] A, int B) {

        int i = 0, j;
        int start=-1;
        int end=-1;
        for (j = 0; j < A.length; j++) {
            if (A[j] == 0) B--;
            if(B==0){
                int len1=end-start;
                int len2=j-i;
                if(len2>len1){
                    start=i;
                    end=j;
                }
            }
            if (B < 0 && A[i++] == 0) {
                B++;
            }
        }
        if((start==-1||end==-1)&& (j-i)>(end-start)){
            start=i;
            end=j-1;
        }
        int[] arr= new int[end - start+1];

        for (int i1 = 0;i1<arr.length&&start<=end;i1++,start++){
            arr[i1]=start;
        }

        return arr;
    }

    public static void main(String[] args) {

       // int[] arr={1, 0, 0, 0, 1, 0, 1};
        int[] arr={1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0};
        //int[] arr={1, 1, 0 };
        int maxNumOfReplacements=4;

        System.out.println(Arrays.toString(maxone(arr,maxNumOfReplacements )));

    }

}
