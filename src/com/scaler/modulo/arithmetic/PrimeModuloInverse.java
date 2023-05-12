package com.scaler.modulo.arithmetic;

public class PrimeModuloInverse {

    public static long powModIterative(int a,int p,int mod){
        a=a%mod;
        long ans=1;
        while (p>0){
            if(p%2==1){
                ans=(ans*a)%mod;
            }
            long product=((long)a*a)%(mod);
            a= (int) ((product)%mod);
            p/=2;
        }

        return ans;
    }

    public static int solve(int A, int B) {
        return (int) powModIterative(A,B-2,B);
    }

    public static void main(String[] args) {

        System.out.println(solve(6,23));
    }
}
