package com.scaler.prime.factorization;

import java.util.HashMap;
import java.util.Map;

public class FactorialArrayOptimized {


//Observation : https://www.scaler.com/academy/mentee-dashboard/class/7809/assignment/problems/2206/discussion/p/its-a-good-example-of-memoization/9755
// Better observation: https://www.scaler.com/academy/mentee-dashboard/class/7809/assignment/problems/2206/discussion/p/solution-approach-with-java-solution/14085

    public static int[] sieve(int n){
        int[] isPrime= new int[n+5];

        isPrime[0]=1;
        isPrime[1]=1;
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]==0){
                for(int m=i;m*i<=n;m++){
                    isPrime[m*i]=1;
                }
            }
        }

        return isPrime;
    }

    public static int max(int[] A){
        int max=Integer.MIN_VALUE;
        int n=A.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,A[i]);
        }
        return max;
    }

    public static int[] populatePrimeFactorsInFactorial(int n){
        int[] countPrimeFactorsInFactorial= new int[n+1];
        int[] isPrime=sieve(n);

        for(int i=1;i<=n;i++){
            if(isPrime[i]==0){
                countPrimeFactorsInFactorial[i]=countPrimeFactorsInFactorial[i-1]+1;
            }
            else{
                countPrimeFactorsInFactorial[i]=countPrimeFactorsInFactorial[i-1];
            }
        }

        return countPrimeFactorsInFactorial;
    }



    public static int solve(int[] A) {
        int mod= (int) (1e9+7);
        int n=A.length;
        int[] B= new int[n];

        int[] primeInFactorialCount=populatePrimeFactorsInFactorial(max(A));

        for(int i=0;i<n;i++){
            B[i]=primeInFactorialCount[A[i]];
        }
        Map<Integer,Integer> primeCountMap=new HashMap<>();


        for(int i=0;i<n;i++){
            if(B[i]==0){
                continue;
            }
            else{
                if(primeCountMap.containsKey(B[i])){
                    primeCountMap.put(B[i],primeCountMap.get(B[i])+1);
                }
                else{
                    primeCountMap.put(B[i],1);
                }
            }
        }

        final long[] result = {0};

        for(Integer key:primeCountMap.keySet()){
            {
                result[0] +=(Math.pow(2L,primeCountMap.get(key))-1)%mod;
                result[0]%=mod;
            }

        }

        return (int) result[0];
    }

    public static void main(String[] args) {

        int[] A={2,2,3,3};
        //int[] A={2, 3, 4, 5, 6};
        System.out.println(solve(A));
    }
}
