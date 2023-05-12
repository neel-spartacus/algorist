package com.scaler.recursion.backtracking.adityaverma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfSpaces {

    public static List<String> permutation(String str){

        int len=str.length();
        List<String> permutations=new ArrayList<>();
        String output=""+str.substring(0,1);
        String remainingInput=str.substring(1,len);

        helper(remainingInput,output,len,permutations);

        return permutations;
    }


    public static void helper(String input, String output, int len, List<String> permutations){

        if(input.length()==0){
            permutations.add(output);
            return;
        }
        helper(input.substring(1),output+" "+input.substring(0,1),len,permutations);
        helper(input.substring(1),output+input.substring(0,1),len,permutations);
    }

    public static void main(String[] args) {

        String str="AB";
        System.out.println(Arrays.toString(permutation(str).toArray()));
    }
}
