package com.scaler.prime.factorization;


//Imp observation : https://math.stackexchange.com/questions/141196/highest-power-of-a-prime-p-dividing-n

public class TrailingZerosFactorial {


    public static int trailingZeroes(int A) {

        int res = 0;
        int temp=5;
        while (temp<=A) {
            res += A/temp;
            temp*=5;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(trailingZeroes(6));
    }
}
