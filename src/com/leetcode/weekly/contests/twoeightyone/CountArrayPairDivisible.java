package com.leetcode.weekly.contests.twoeightyone;

import java.util.HashMap;
import java.util.Map;

public class CountArrayPairDivisible {


    public static long countPairs(int[] nums, int k) {

        int len=nums.length;
        long pairCount=0;
        int[] gcdArr= new int[len];

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<len;i++){
            gcdArr[i]=gcd(nums[i],k);
        }

        for(int i=0;i<len;i++){
            int gcd=k/gcdArr[i];

            for(int key:map.keySet()){
                if(((long)gcd*key)%k==0){
                    pairCount+=map.get(key);
                }
            }
            map.put(gcd,map.getOrDefault(gcd,0)+1);
        }

        //for(int i=0;i<len-1;i++){
          /*  int i=0;
            int j=i+1;
            while (i<len && j<len){
                if((gcdArr[i]*gcdArr[j])%k==0) {
                    pairCount++;
                }
                if(j==len-1){
                    i++;
                    j=i+1;
                    continue;
                }
                j++;
            }*/

      //  }
        return pairCount;
    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static void main(String[] args) {

        int[] nums=new int[]{1,2,3,4};
        int k=5;
        System.out.println(countPairs(nums,k));
    }
}
