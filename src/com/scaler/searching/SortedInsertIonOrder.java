package com.scaler.searching;

public class SortedInsertIonOrder {


    public static int searchInsert(int[] A, int B) {

        int size=A.length;
        int left=0;
        int right=size-1;
        while (left<=right){

            int mid=left+ ((right-left)/2);

            if(A[mid]<B){
                left=mid+1;
            }
            else if(A[mid]>B){
                right=mid-1;
            }
            else{
                return mid;
            }
        }

        return left;
    }


    public static void main(String[] args) {

        int[] A={1};
        int B=1;

        System.out.println(searchInsert(A,B));
    }
}
