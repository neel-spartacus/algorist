package com.test.tipico;

public class Task1 {


    public static String generateTheString(int n) {

        char[] result = new char[n];

        for (int i = 0; i < n; ++i) {
            result[i] = 'a';
        }

        if (n % 2 == 0) result[0] = 'b';

        return new String(result);
    }

    public static void main(String[] args) {

        int input=200000;
        System.out.println(generateTheString(input));
    }
}
