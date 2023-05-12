package com.leetcode.dynamicprogramming.aditya.verma.slidingwindow;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MaxSubarrayOptimal {


    public static List<Integer> findMaxSubarray(int[] arr, int k){

        int size=arr.length;
        int start=0;
        int end=0;
        int max=Integer.MIN_VALUE;
        List<Integer> maxSubarrayList= new ArrayList<>();
        Queue<Integer> queue= new ConcurrentLinkedDeque<>();

        if(size==1){
            maxSubarrayList.add(arr[0]);
            return maxSubarrayList;
        }
        if(k>size){
            maxSubarrayList.add(Arrays.stream(arr).max().getAsInt());
            return maxSubarrayList;
        }

        while (end<size){

            if(!queue.isEmpty()){
                for (Integer element:queue){
                    if(element<arr[end]){
                        queue.remove(element);
                    }
                }
            }
            queue.add(arr[end]);
            if(end-start+1<k){
                end++;
            }

            else if(end-start+1==k){
                maxSubarrayList.add(queue.peek());
                if(arr[start]==queue.peek()){
                    queue.poll();
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
        //int  K = 3;
        int  K = 5;
        //int [] arr={1,-1};
        int[] arr = {9,10,9,-7,-4,-8,2,-6};
        //int[] arr = {1,3,-1,-3,5,3,6,7};

        List<Integer> maxSubarray=findMaxSubarray(arr, K);

        System.out.println(Arrays.toString(maxSubarray.toArray()));


    }
}
