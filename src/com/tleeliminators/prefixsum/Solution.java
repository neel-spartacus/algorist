package com.tleeliminators.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void permutation(String str,List<String> list) {
        permutation("", str,list);
    }

    private static void permutation(String prefix, String str,List<String> list ) {
        int n = str.length();
        if (n == 0) {
             list.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n),list);
        }



    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        double N = 2e5+10;
        int t = Integer.parseInt(br.readLine());
        for(int j=0;j<t;j++){
            String string = br.readLine();


            List<String> list =  new ArrayList<>();
            permutation(string,list);
            //System.out.println(list);

            int start=0;
            for(int i=0;i<list.size();i++){

                String[] org=string.split("");
                String anagram=list.get(i);
                String[] ana=anagram.split("");
                while (start<org.length && !org[start].equals(ana[start])){
                    start++;
                }
                if(start==org.length){
                    System.out.println(anagram);
                    break;
                }
                else {
                    start=0;
                }
            }



        }
        System.out.println("IMPOSSIBLE");
        }

}
