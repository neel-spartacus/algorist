package com.scaler.prime.factorization;

public class LargestCoPrimeDivisor {

    public static int cpFact(int A, int B) {

        int maxCoPrime = Integer.MIN_VALUE;
        for (int i = 1; i * i < A; i++) {
            if (A % i == 0) {
                maxCoPrime = gcd(i, B) == 1 ? Math.max(maxCoPrime, i) : maxCoPrime;
                maxCoPrime = gcd(A / i, B) == 1 ? Math.max(maxCoPrime, A / i) : maxCoPrime;
            }
            if (i * i == A) {
                maxCoPrime = gcd(A, B) == 1 ? Math.max(maxCoPrime, A) : maxCoPrime;
            }

        }

        return maxCoPrime;
    }

        public static int cpFact2 ( int A, int B){
            int res=0;
            do{
                res=gcd(A,B);
                A/=res;
            }while (res!=1);

            return A;
    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }



    public static void main(String[] args) {
        System.out.println(cpFact2(5,10));
    }
}
