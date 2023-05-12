package com.tleeliminators.prefixsum.backtracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/letter-tile-possibilities/
public class LetterTiles {

    public static int numTilePossibilities(String tiles) {

        String[] tileArr= tiles.split("");
        List<String> possibilities= new ArrayList<>();
        Set<String> possibleTiles = new HashSet<>();

        //helper(tileArr, 0, possibilities, "");
        helper(tileArr, 0, possibilities, "");


        for(String tile:possibilities) {

            permutation("",tile, possibleTiles);
        }

        return possibleTiles.size();

    }

    private static void permutation(String prefix, String str,Set<String> tiles) {
        int n = str.length();
        if (n == 0){
            tiles.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n),tiles);
        }
    }


    public static void helperRecursive(String[] arr, int index, List<String> possibilities,String curr){
        if(!curr.isEmpty()){
            possibilities.add(curr);
        }
        if(index==arr.length){
            return;
        }

        helperRecursive(arr, index+1, possibilities, curr);
        curr+=arr[index];
        helperRecursive(arr, index+1, possibilities, curr);
    }

    public static void helper(String[] arr, int index, List<String> possibilities,String curr){

        if(!curr.isEmpty()){
            possibilities.add(curr);
        }
        for(int i=index;i<arr.length;i++){
            String temp=curr;
            curr=curr+arr[i];
            helper(arr, i+1, possibilities, curr);
            curr=temp;
        }

    }
    public static void main(String[] args) {
        String tiles="AAB";
        System.out.println(numTilePossibilities(tiles));
    }
}
