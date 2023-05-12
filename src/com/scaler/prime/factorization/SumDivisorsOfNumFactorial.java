package com.scaler.prime.factorization;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumDivisorsOfNumFactorial {

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

    public static  Map<Integer, Set<Integer>> populatePrimeFactorsInFactorial(int n){
        int[] countPrimeFactorsInFactorial= new int[n+1];
        int[] isPrime=sievePrimes(n);
        Map<Integer, Set<Integer>> map= new HashMap<>();

        map.computeIfAbsent(1,k->new HashSet<>()).add(1);
        for(int i=2;i<=n;i++){
            Set<Integer> primeFactorsPrevNum=new HashSet<>(map.get(i-1));
            if(isPrime[i]==0){
                primeFactorsPrevNum.add(i);
            }
            map.put(i,primeFactorsPrevNum);
        }

        return map;
    }

    public static int primePowerCountInFactorial(int k,int n){
        int res = 0;
        int temp=k;
        while (temp<=n) {
            res += n/temp;
            temp*=k;
        }
        return res;
    }

    public static long powMod(int a,int b,int mod){
        if(a==1 || b==1){
            return a;
        }
        if(b==0){
            return 1;
        }
        if(b%2!=0){
            return (a*powMod(a,b-1,mod))%mod;
        }
        else{
            long k=powMod(a,b/2,mod)%mod;
            return ((k*k)%mod);
        }
    }

    public static long powModIterative(int a,int p,int mod){
        a=a%mod;
        long ans=1;
        while (p>0){
            if(p%2==1){
                ans=(ans*a)%mod;
            }
            long product=((long)a*a)%mod;
            a= (int) ((product)%mod);
            p/=2;
        }

        return ans;
    }

    public static long divisors(int p,int e,int mod){
        //return ((powMod(p,e+1,mod)-1)%mod)/(p-1);
        return ((powModIterative(p, e + 1,mod) + mod - 1) * powModIterative(p - 1, mod - 2,mod)) % mod;
    }

    public static int solve(int A) {
        int mod= (int) (1e9+7);
        //Map<Integer, Set<Integer>> primeInFactorialCount=populatePrimeFactorsInFactorial(A);
        int[] spf= sieve(A);
       // int[] isPrime= sievePrimes(A);
        long ans=1;
       for(int i=2;i<=A;i++){
           if(spf[i]==i){
               int e=primePowerCountInFactorial(i,A);
               ans=(ans*(divisors(i,e,mod)%mod))%mod;
               ans%=mod;
           }
       }

       return (int)ans;
    }
    public static void main(String[] args) {

        System.out.println(solve(400000));
    }
}
