package io.algoexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoNumberSum {

    public static void main(String args[]) throws Exception {

        int[] arrayOfNumbers= new int[]{3,5,-4,8,1,11,-1,6};
        int sum=25;

        int[] sortedArray= twoNumberSum(arrayOfNumbers, sum);

        System.out.println(sortedArray.toString());


    }

    public static int[] twoNumberSum(int[] array, int targetSum) {

        List<Integer> numberList= new ArrayList<>();
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]+array[j]==targetSum){
                    numberList.add(array[i]);
                    numberList.add(array[j]);
                    break;
                }
            }
        }
        if(numberList.isEmpty()){
            return new int[numberList.size()];
        }
        else{
            Integer[] arr = new Integer[numberList.size()];
            arr=numberList.toArray(arr);
            Arrays.sort(arr);
            return  new int[]{arr[0].intValue(),arr[1].intValue()};
        }

    }
}
