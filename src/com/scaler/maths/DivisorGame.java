package com.scaler.maths;

public class DivisorGame {



    public static int solve(int A, int B, int C) {
        int gcd=gcd(B,C);
        int lcm=(B*C)/gcd;
        return (A/lcm);
    }

    public static int gcd(int b,int c){
        if(c==0){
            return b;
        }
        return gcd(c,b%c);
    }
    public static void main(String[] args) {

        System.out.println(solve(99413,7473,3438));
    }
}
