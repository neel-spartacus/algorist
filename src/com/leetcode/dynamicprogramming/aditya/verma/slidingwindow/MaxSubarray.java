package com.leetcode.dynamicprogramming.aditya.verma.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubarray {


    public static List<Integer> findMaxSubarray(int[] arr,int k){

        int size=arr.length;
        int start=0;
        int end=0;
        int max=Integer.MIN_VALUE;
        List<Integer> maxSubarrayList= new ArrayList<>();

        if(size==1){
            maxSubarrayList.add(arr[0]);
            return maxSubarrayList;
        }
        if(k>size){
            maxSubarrayList.add(Arrays.stream(arr).max().getAsInt());
            return maxSubarrayList;
        }

        while (end<size){

            if(arr[end]>max){
                max=arr[end];
            }

            if(end-start+1<k){
                end++;
            }

            else if(end-start+1==k){
                maxSubarrayList.add(max);
                int i=start,j=end;
                if(max==arr[start]){
                    if(i==j){
                        max= Integer.MIN_VALUE;
                    }
                    else {
                        i = i + 1;
                        max=Integer.MIN_VALUE;
                        while (i < j) {
                            max = Math.max(max, Math.max(arr[i], arr[j]));
                            i++;
                        }
                    }

                }
                start++;
                end++;
            }

        }

        return maxSubarrayList;
    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }


    public static void main(String[] args) {
        int  K = 3;
        //int  K = 5;
       //int[] arr = {9,10,9,-7,-4,-8,2,-6};
        int[] arr = {1,3,-1,-3,5,3,6,7};

        List<Integer> maxSubarray=findMaxSubarray(arr, K);

        System.out.println(Arrays.toString(maxSubarray.toArray()));


    }
}
