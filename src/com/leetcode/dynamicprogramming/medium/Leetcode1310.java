package com.leetcode.dynamicprogramming.medium;

public class Leetcode1310 {

    public static int[] xorQueries(int[] arr, int[][] queries) {

        int len=arr.length;
        int[]results=new int[queries.length];
        int[] prefixXorSum= new int[len];
        for(int i=0;i<len;i++){
            prefixXorSum[i]=(i-1>=0?prefixXorSum[i-1]:0)^ arr[i];
        }
        int k=0;
        for(int[]query:queries){
            if(query[0]==query[1]){
                results[k]=arr[query[0]];
                k++;
            }
            else{
                results[k]=(query[0]-1>=0?prefixXorSum[query[0]-1]:0)^(prefixXorSum[query[1]]);
                k++;
            }

        }



     return results;
    }

    public static void main(String[] args) {
        //int[] arr = {1,3,4,8};
        int[] arr = {16};
        //int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
        int[][] queries = {{0,0},{0,0},{0,0}};
        int[] results=xorQueries(arr,queries);
        System.out.println(results.toString());
    }
}
