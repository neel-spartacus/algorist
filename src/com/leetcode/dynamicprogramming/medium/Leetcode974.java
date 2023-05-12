package com.leetcode.dynamicprogramming.medium;

import com.sun.deploy.util.SyncAccess;

public class Leetcode974 {

    public static int subarraysDivByK(int[] A, int K) {

        int n=A.length;

        int[] prefixSum=new int[n];
        int[] modgroups=new int[K];
        prefixSum[0]=A[0];

        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+(A[i]);
        }
        int ways=0;
        for(int i=0;i<n;i++){
            int group=prefixSum[i]%K;
            if(group<0){
                group+=K;
            }
            modgroups[group]++;
        }

        for(int val:modgroups){
            if(val>1){
                ways+=(val*(val-1))/2;
            }
        }

    return ways+modgroups[0];
    }

    public static void main(String[] args) {
        int[] A ={4,5,0,-2,-3,1};
        int K=5;
        System.out.println(subarraysDivByK(A, K));
    }
}
