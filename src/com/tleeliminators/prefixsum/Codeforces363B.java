package com.tleeliminators.prefixsum;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Codeforces363B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String s = br.readLine();

        String[] s1 = s.split(" ");
        long n = Long.valueOf(s1[0]);
        int  m = Integer.parseInt(s1[1]);

        long[] arr= new long[(int)n];


        String elementLine = br.readLine();
        String[] elements = elementLine.split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.valueOf(elements[i]);
        }

        long[] prefixsum= new long[(int)n+1];
        prefixsum[0]=arr[0];

        for(int i=1;i<n;i++){
            prefixsum[i]=prefixsum[i-1]+arr[i];
        }

        long minHeight=Integer.MAX_VALUE;
        int minIndex=0;
        for(int i=0,j=i+m-1;j<n;i++,j++){
            long height=prefixsum[j]-(i-1<0?0:prefixsum[i-1]);
            if(height<minHeight){
                minHeight=height;
                minIndex=i+1;
            }
        }

        System.out.println(minIndex);
    }

}
