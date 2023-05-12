package com.scaler.twopointers;

import java.util.Arrays;

public class ClosestSum {

    public static int threeSumClosest(int[] A, int B) {

        int n=A.length;

        Arrays.sort(A);

        long max=Integer.MIN_VALUE;
        long min=Integer.MAX_VALUE;
        for( int i=0;i<n;i++){

            int j=i+1,k=n-1;

            while (j<k){
                if(A[i]+A[j]+A[k]<=B){
                    max=Math.max(max,A[i]+A[j]+A[k]);
                    j++;
                }
                else{
                    min=Math.min(min,A[i]+A[j]+A[k]);
                    k--;
                }
            }
        }

       return (int) (((B-max)>=(min-B))?min:max);

    }

    public static void main(String[] args) {

        //int[] arr={-1, 2, 1, -4};
        //int[] arr={-10, -10, -10};
        int[] arr={-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3};

        int target=-1;

        System.out.println(threeSumClosest(arr,target));
    }
}
