package com.leetcode.dynamicprogramming.medium;

public class Leetcode1155 {

    final static int mod=(int)1e9+7;

    public static int numRollsToTarget(int d, int f, int target) {

        int[] ways=new int[target+1];
        ways[0]=1;

        for(int p=1;p<=d;p++){
            int[] new_ways= new int[target+1];
            for(int q=0;q<=target;q++){
                for(int i=1;i<=f;i++){
                    if(i+q<=target){
                        new_ways[i+q]+=ways[q];
                        if(new_ways[i+q]>=target){
                            new_ways[i+q]-=mod;
                        }
                        if(new_ways[i+q]<0){
                            new_ways[i+q]+=mod;

                        }
                    }
                }

            }
            ways=new_ways;
        }

        return ways[target];
    }


    public static void main(String[] args) {
        System.out.println(numRollsToTarget(30, 30, 500));
    }
}
