package com.scaler.searching;

public class PeakElement {


    public static int solve(int[] A) {

        int size=A.length;
        int peakElement=0;
        if(size==1){
            return A[0];
        }
        else {
            peakElement=binary(A,peakElement,0,size-1);
        }

        return peakElement;
    }

    public static int binary(int[] A,int peakElement,int left,int right){

        int len=A.length;
        while (left<=right){
            int mid= left+((right-left)/2);
            if(mid-1<0 && A[mid]>=A[left]){
                peakElement=Math.max(peakElement,A[mid]);
                peakElement=Math.max(peakElement,binary(A,peakElement,mid+1,right));
                left=mid+1;
            }
            else if(mid+1>right && A[mid]>=A[right]){
                peakElement=Math.max(peakElement,A[mid]);
                peakElement=Math.max(peakElement,binary(A,peakElement,left,mid-1));
                right=mid-1;
            }
            else{
                if(mid-1<0){
                    mid=1;
                }if(mid+1>len-1){
                    mid=len-2;
                }
                if(A[mid]>=A[mid-1] && A[mid]>=A[mid+1]){
                    peakElement=A[mid];
                    peakElement=Math.max(peakElement,Math.max(binary(A,peakElement,left,mid-1),binary(A,peakElement,mid+1,right)));
                }
                else{
                    peakElement=Math.max((binary(A,peakElement,left,mid-1<0?0:mid-1)),binary(A,peakElement,mid+1>len-1?len-1:mid+1,right));
                }
                break;
            }
        }
        return peakElement;

    }

   // https://leetcode.com/problems/find-peak-element/solution/- Iterative
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

//https://leetcode.com/problems/find-peak-element/solution/ -Recursive
    public int findPeakElementRecursive(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }

    public static void main(String[] args) {

        //int[] A= new int[]{5, 17, 100, 11};
        int[] A= new int[]{1,2,3,4,5};
        //int[] A= new int[]{3,2};
        System.out.println(solve(A));
    }
}
