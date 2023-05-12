package com.scaler.prime.factorization;

public class ArrayAndPrimeDivisors {

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
    public static int solve(int[] A, int B) {

        int[] isPrime=sievePrimes(max(A)+1);
        int n=A.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(isPrime[A[i]]==0){
                if(B%A[i]==0){
                    count++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] A={1, 2, 3, 4, 5};
        System.out.println(solve(A,6));
    }
}
