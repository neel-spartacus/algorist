package com.leetcode.weekly.contests.twoeightytwo;

public class CountingWordsWithPrefix {

    public static int prefixCount(String[] words, String pref) {

        int count=0;
        for(String word:words){
            if(word.startsWith(pref)){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {

        String[] words={"pay","attention","practice","attend"};
        String pref = "at";
        System.out.println(prefixCount(words,pref));
    }
}
