package com.scaler.prime.factorization;

import java.util.Arrays;

public class PrimeSum {

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

    public static int[] primesum(int A) {

        int[] isPrime=sieve(A);

        for(int i=2;i<A;i++){
            if(isPrime[i]==0){
                if(isPrime[A-i]==0){
                    return new int[]{i,A-i};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(primesum(12)));
    }
}
