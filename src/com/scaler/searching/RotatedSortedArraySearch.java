package com.scaler.searching;

public class RotatedSortedArraySearch {

    public static int search(final int[] A, int B) {

        int size=A.length;

        int left=0;
        int right=size-1;

        while (left<right){

            int mid=left+((right-left)/2);

            if(A[mid]==B){
                return mid;
            }

            if(A[mid]>=A[left]){
                if(B>=A[left] && B<A[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{
                if(B<A[left] && B>A[mid]){
                    left=mid+1;
                }
                else {
                    right=mid-1;
                }
            }

        }


        return A[left]==B?left:-1;
    }

    public static void main(String[] args) {

        int[] A={101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 };
        //int[] A={5,1,3};
        int B=202;

        System.out.println(search(A,B));
    }
}
