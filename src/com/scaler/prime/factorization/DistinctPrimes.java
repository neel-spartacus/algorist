package com.scaler.prime.factorization;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DistinctPrimes {

    public static int[] sievePrimes(int n){
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
        int max=0;
        for(int a:A){
            if(a>max){
                max=a;
            }
        }
        return max;
    }

    public static int[] sieve(int n){
        int[] spf= new int[n+5];
        for(int i=0;i<n+5;i++){
            spf[i]=i;
        }

        for(int i=2;i*i<=n;i++){
            if(spf[i]==i){
                for(int m=i;m*i<=n;m++){
                    if(spf[m*i]>i){
                        spf[m*i]=i;
                    }
                }
            }
        }

        return spf;
    }

    public static int solve(int[] A) {
        int n=A.length;
        Set<Integer> distinctPrimes= new HashSet<>();
        int[] spf=sieve(100005);
        for(int i=0;i<n;i++){
                distinctPrimes.addAll(getPrimeFactors(spf,A[i]));
            }

        return distinctPrimes.size();
    }


    private static Collection<Integer> getPrimeFactors(int[] spf,int num) {
        Set<Integer> primeFactors= new HashSet<>();

        while (num>1){
            int f=spf[num];
            primeFactors.add(f);
            while (num%f==0){
                num/=f;
            }
        }

        return primeFactors;
    }

    private static Collection<Integer> findPrimeFactors(int num) {
        Set<Integer> primeFactors= new HashSet<>();
        int[] isPrime=sievePrimes(num);
        for(int i=2;i*i<=num;i++){
            while(num%i==0 && isPrime[i]==0){
                primeFactors.add(i);
                num/=i;
            }

        }
        if(num>1){
            primeFactors.add(num);
        }

        return primeFactors;
    }


    public static void main(String[] args) {

        //int[] A={96, 98, 5, 41, 80 };
        //int[] A={9, 25,49};
        int[] A={63, 52, 28, 72, 9, 62, 79, 71, 43, 15, 82, 21, 10, 12, 38, 96, 58, 99, 59, 100, 10, 38, 92, 30, 24, 3, 49, 17, 2, 63, 54, 18, 71, 7, 65, 87, 82, 31, 48, 39, 100, 82, 15, 60, 44, 84, 43, 5, 63, 17, 100, 94, 62, 26, 35, 29 };

        System.out.println(solve(A));
    }
}
