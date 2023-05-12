package com.scaler.searching;

public class RotatedSortedArraySearchTwo {

    //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28202/Neat-JAVA-solution-using-binary-search

    public static boolean search(final int[] A, int B) {

        int size = A.length;

        int left = 0;
        int right = size - 1;

        while (left <= right) {

            int mid = left + ((right - left) / 2);

            if (A[mid] == B) {
                return true;
            }

            if (A[mid] > A[left] || A[mid]>A[right]) {
                if (B >= A[left] && B < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(A[mid]<A[left] || A[mid]<A[right]) {
                if (B <= A[right] && B > A[mid]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }

            }
            else{
                right--;//Remove duplicates
            }

        }

        return false;
    }

    public static void main(String[] args) {

        int[] A={1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        //int[] A={5,1,3};
        int B=2;

        System.out.println(search(A,B));
    }
}
