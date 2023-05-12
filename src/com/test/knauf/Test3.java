package com.test.knauf;

import java.util.HashMap;

public class Test3 {

//https://www.geeksforgeeks.org/count-of-subarrays-with-average-k/

    static int countKAverageSubarrays(int[] arr,
                                      int k)
    {
        int n=arr.length;
        int result = 0, curSum = 0;

        HashMap<Integer,Integer> freqPrefixSumMap = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            curSum += (arr[i] - k);

            if (curSum == 0)
                result++;

            if (freqPrefixSumMap.containsKey(curSum)){
                result += freqPrefixSumMap.get(curSum);
                freqPrefixSumMap.put(curSum, freqPrefixSumMap.get(curSum) + 1);
            }
            else{
                freqPrefixSumMap.put(curSum, 1);
            }

        }

        return result;
    }

    public static void main(String[] args) {

        //int[] arr={2,1,4};
        int[] arr={0,4,3,-1};
        int k=2;

        System.out.println(countKAverageSubarrays(arr,k));

    }
}
