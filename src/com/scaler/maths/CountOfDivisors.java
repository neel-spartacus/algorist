package com.scaler.maths;

import java.util.Arrays;

public class CountOfDivisors {

    public static int[] solve(int[] A) {

        int len=A.length;
        int[] countDivisors= new int[len];

        for(int i=0;i<len;i++){

            int val=A[i];

            int count=1;
            for(int j=1;j<val;j++ ){
                if(val%j==0){
                    count++;
                }
            }
            countDivisors[i]=count;

        }

        return countDivisors;
    }

    public static void main(String[] args){
        int[] A = {10,20};
        int[] result=solve(A);
        System.out.println(Arrays.toString(result));
    }

}
