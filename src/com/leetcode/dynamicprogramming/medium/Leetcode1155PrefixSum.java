package com.leetcode.dynamicprogramming.medium;

public class Leetcode1155PrefixSum {

    final static int mod=(int)1e9+7;

    public static int numRollsToTarget(int d, int f, int target) {

        int[] ways=new int[target+1];
        ways[0]=1;

        for(int p=1;p<=d;p++){
            int[] new_ways= new int[target+1];
            for(int q=1;q<=target;q++){
                addPrefixSum(q,q-1,ways);
            }
                for(int i=1;i<=target;i++){
                    new_ways[i]=ways[i-1]-((i-f-1>=0?ways[i-f-1]:0));
                    if(new_ways[i]<0){
                        new_ways[i]+=mod;
                    }

            }
            ways=new_ways;
        }

        return ways[target];
    }

    private static void addPrefixSum(int a,int b,int[]ways){
        ways[a]+=ways[b];
        if(ways[a]>=mod){
            ways[a]-=mod;
        }
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2, 6, 7));
    }
}
