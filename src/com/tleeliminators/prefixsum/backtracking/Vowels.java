package com.tleeliminators.prefixsum.backtracking;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Vowels {

    public static void numOfVowels(int n,int count,int index,String[] s,List<String> vowels){
        if(index==n){
            System.out.println(count);
            return;

        }
        if(!s[index].isEmpty() && vowels.contains(s[index].toLowerCase())){
            count++;
        }
        numOfVowels(n, count,index+1 , s, vowels);


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));


        String s = br.readLine();
        int n=s.length();
        int count=0;
        List<String> vowels= Arrays.asList("a","e","i","o","u");

        String[] inputString = s.split("");
        numOfVowels(n, count, 0, inputString, vowels);


    }
}
