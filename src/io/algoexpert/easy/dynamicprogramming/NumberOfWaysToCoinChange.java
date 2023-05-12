package io.algoexpert.easy.dynamicprogramming;

public class NumberOfWaysToCoinChange {

    private static int MAX = 1000000000;

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int [] numOfWays= new int[n+1];
        numOfWays[0]=1;
        for(int coin:denoms){
          for(int i=1;i<n+1;i++){
                if(coin<=i){
                    numOfWays[i]=numOfWays[i] + numOfWays[i-coin];
                }
            }

        }
        return numOfWays[n];
    }

    public static void main(String[] args) {

            int[] input={1,5,7};
            System.out.println(numberOfWaysToMakeChange(7, input));
    }
}
