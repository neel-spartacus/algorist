package com.scaler.twopointers;

import java.util.Arrays;

public class PairsWithGivenDiff {


    public static int solve(int[] A, int B) {

        int n=A.length;
        Arrays.sort(A);

        int i=0;
        int j=i+1;

        int count=0;
        while (i<n && j<n){

            if(A[j]-A[i]>B){
                int Ai=A[i];
                while (i<n&& A[i]==Ai){
                    i++;
                }
            }else if(A[j]-A[i]<B){
                int Aj=A[j];
                while (j<n&& A[j]==Aj){
                    j++;
                }
            }else{
                int Ai=A[i];
                int Aj=A[j];
                count++;
                while (i<n&& A[i]==Ai){
                    i++;
                }
                while (j<n&& A[j]==Aj){
                    j++;
                }

            }

            if(i>=j){
                j=i+1;
            }

        }

        return count;
    }
    public static void main(String[] args) {

        int[] arr={ 8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3 };
        int b=3;
        System.out.println(solve(arr,b));
    }
}
