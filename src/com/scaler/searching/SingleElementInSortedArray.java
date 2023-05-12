package com.scaler.searching;

public class SingleElementInSortedArray {

    public static int solve(int[] A) {
        int size=A.length;

        if(size<2){
            return A[0];
        }
        int left=0;
        int right=size-1;

        while (left<right){
            int mid=left+((right-left)/2);

            if(A[mid]!=A[mid-1<0?0:mid-1] && A[mid]!=A[mid+1>size-1?size-1:mid+1]){
                return A[mid];
            }

            if(mid%2==0){
                if(A[mid]==A[mid+1]){
                    left=mid+1;
                }
                else {
                    if(A[mid]==A[mid-1<0?0:mid-1]){
                        right=mid-1<0?0:mid-1;
                    }
                }
            }
            else{
                if (A[mid]==A[mid-1<0?0:mid-1]){
                    left=mid+1;
                }else{
                    right=mid-1<0?0:mid-1;
                }
            }
        }
        return A[left];
    }

    public static void main(String[] args) {

        //int[] A={1,1,4,4,5,5,7,8,8,9,9};
       // int[] A={1,1,7};
        int[] A={2,3,3};
        System.out.println(solve(A));
    }
}
