package com.scaler.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {

    public static int[] pivotArray(int[] nums, int pivot) {

        int len= nums.length;

        List<Integer> values= new ArrayList<>();
        List<Integer> equalValues=new ArrayList<>();

        for(int i=0;i<len;i++){
            if(nums[i]<pivot){
                values.add(nums[i]);
            }
            else if(nums[i]==pivot){
                equalValues.add(nums[i]);
            }
        }
        values.addAll(equalValues);
        for(int i=0;i<len;i++){
            if(nums[i]>pivot){
                values.add(nums[i]);
            }
        }

        int[] arr=values.stream().mapToInt(i -> i).toArray();

        return arr;
    }

    public static void main(String[] args) {

        int[] nums={9,12,5,10,14,3,10};
        int pivot=10;
        System.out.println(Arrays.toString(pivotArray(nums,pivot)));
    }
}
