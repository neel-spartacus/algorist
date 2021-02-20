package io.algoexpert.easy.dynamicprogramming;

public class MinNumberOfCoinsForChange {

    private static int MAX = Integer.MAX_VALUE;

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int [] minNumOfChange = new int[n+1];
        int numOfCoins=0;
        minNumOfChange[0]=0;
        for(int i=1;i<n+1;i++)
        {
            minNumOfChange[i]=MAX;
            for(int coin:denoms){
                if(i>=coin){
                    numOfCoins= minNumOfChange[i-coin] +1;
                    minNumOfChange[i]=numOfCoins<minNumOfChange[i]?numOfCoins:minNumOfChange[i];
                }

            }

        }
        return minNumOfChange[n]>0 && minNumOfChange[n]<MAX?minNumOfChange[n]:minNumOfChange[n]==0?0:-1;
    }

    public static void main(String[] args) {

            int[] input={1,5,10};
            //int[] input={3,7};
            System.out.println(minNumberOfCoinsForChange(7, input));
    }
}
