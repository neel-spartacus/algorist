package com.scaler.prime.factorization;

public class LuckyNumberSieve {


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

    public static int solve(int A) {
        int[] spf= sieve(A);
        int luckyNums=0;
        for(int i=6;i<=A;i++){
            int count=0;
            int n=i;
            while (n>1){
                count++;
                int f=spf[n];
                while (n%f==0){
                    n/=f;
                }
            }

            if(count==2){
                luckyNums++;
            }
        }

        return luckyNums;
    }
    public static void main(String[] args) {
        System.out.println(solve(24));
    }
}
