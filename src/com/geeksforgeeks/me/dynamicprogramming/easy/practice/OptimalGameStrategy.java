package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

public class OptimalGameStrategy {


    static int maxSum(int[] coins,int start, int end){


        int a=0,b=0,sum=0;
        int count=0;

        int size=coins.length;

        int[] dp= new int[size/2 +1];
        if(start>end){
            return 0;
        }


             a = coins[start] + Math.min(maxSum(coins, start + 2,end), maxSum(coins, start + 1, end - 1));
             b = coins[end] + Math.min(maxSum(coins, start, end - 2), maxSum(coins, start + 1, end - 1));
        /*for(int i=1;i<=size/2;i++){
            dp[i]=dp[i-1]+ Math.max(coins[i-1]+ Math.min(coins[i+1],coins[size-1] ),coins[size-1]+Math.min(coins[i-1],
                    coins[size-2]) )
        }*/

        return Math.max(a,b);
    }

    public static void main(String[] args) {

       // List<Integer> coinList= new ArrayList<>(Arrays.asList(5,3,7,10));

        int[] arr={5,3,7,10};
        int size=arr.length;

        System.out.println(maxSum(arr,0,size-1));

    }
}
