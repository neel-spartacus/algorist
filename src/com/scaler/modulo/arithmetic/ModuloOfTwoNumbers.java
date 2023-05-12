package com.scaler.modulo.arithmetic;


//https://stackoverflow.com/questions/27387033/given-a-and-b-find-m-such-that-a-mod-m-b-mod-m

public class ModuloOfTwoNumbers {


    public static int solve(int A, int B) {

        return Math.abs(A-B);
    }



    public static void main(String[] args) {

        System.out.println(solve(6816621,8157697));

    }
}
