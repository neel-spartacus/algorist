package com.scaler.searching;

public class A {

    public static int solve(int num){

        int min=Integer.MAX_VALUE;

        int n=3;
        while (n>0){

            int val=(int)Math.pow(10,n);
            int q=(num/val);
            int r=(num%val);
            min=Math.min(min,(q+r));
            n--;
        }

        return min;
    }

    public static void main(String[] args) {

        System.out.println(solve(2932));
    }
}
