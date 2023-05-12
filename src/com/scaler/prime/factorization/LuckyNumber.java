package com.scaler.prime.factorization;

public class LuckyNumber {


    public static int solve(int A) {

        int luckyNums=0;
        for(int i=4;i<=A;i++){
            if(!isPrime(i)){
                if(primeFactors(i)){
                    luckyNums++;
                }
            }
        }
        return luckyNums;
    }

    public static boolean primeFactors(int num){

        int primeFactors=0;
        for(int i=2;i*i<num;i++){
            if(num%i==0){
                if(isPrime(i)){
                    primeFactors++;
                }
                if(isPrime(num/i)){
                    primeFactors++;
                }
            }
        }
        return primeFactors==2;
    }

    public static boolean isPrime(int num){

        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println(solve(20));
    }
}
