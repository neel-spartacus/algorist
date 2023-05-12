package com.codeforces;


//https://codeforces.com/problemset/problem/126/B

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Password {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String s = br.readLine();
        char[] password=s.toCharArray();

        int len=password.length;

        long m= (long) (1e9+9);

        int p=31;
        long[] pow_p= new long[len];
        pow_p[0]=1;
        for(int i=1;i<len;i++){
            pow_p[i]=(pow_p[i]*p)%m;
        }

        long[]hash= new long[(int)m];

        for(int i=0;i<len;i++){
            hash[i+1]=(hash[i]+(password[i]-'a'+1)*pow_p[i])%m;
        }

    }
}

