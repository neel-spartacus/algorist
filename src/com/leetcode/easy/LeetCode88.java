package com.leetcode.easy;

import java.util.Arrays;

public class LeetCode88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int total=m+n;
        for(int i=m,j=0;i<total && j<n;i++,j++){
             nums1[i]=nums2[j];
        }

        Arrays.sort(nums1);

    }

    public static void mergeEfficient(int[] nums1, int m, int[] nums2, int n){

            int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
            while (tail1 >= 0 && tail2 >= 0) {
                nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                        nums1[tail1--] : nums2[tail2--];
            }

            while (tail2 >= 0) { //only need to combine with remaining nums2
                nums1[finished--] = nums2[tail2--];
            }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,1,0,0,0},nums2= new int[]{2,5,6};
        int m = 3, n = 3;
       mergeEfficient(nums1, m, nums2, n);
    }
}
