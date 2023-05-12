package com.scaler.modulo.arithmetic;

public class VeryLargePower {


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

    public static int factorial(int n, int mod){
        long ans=1;
        for( int i=1;i<=n;i++){
            ans%=mod;
            ans=((ans)*(i))%(mod-1);//Why mod-1? Refer : https://www.geeksforgeeks.org/find-abm-where-b-is-very-large/
        }
        return (int)ans;
    }

    public static int solve(int A, int B) {
        int mod= (int) (1e9+7);

        int fact=factorial(B,mod);

        return (int)powModIterative(A,fact,mod);
    }
    public static void main(String[] args) {

        System.out.println(solve(2,27));
    }
}
