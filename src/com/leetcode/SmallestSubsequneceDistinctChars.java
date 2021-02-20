package com.leetcode;

import java.util.Stack;

public class SmallestSubsequneceDistinctChars {

    public static String Solution(String s){

        char[] chars=s.toCharArray();
        int len=s.length();
        Stack<Character> characterStack= new Stack<>();
        boolean[] all_chars= new boolean[26];

        int[] maxIndex= new int[26];

        for(int j=0;j<len;j++){
            maxIndex[chars[j]-'a']=j;
        }

        for(int k=0;k<len;k++){
            if (characterStack.isEmpty()){
                characterStack.push(chars[k]);
                all_chars[chars[k]-'a']=true;
                continue;
            }

            if(all_chars[chars[k]-'a']){
                continue;
            }
            while (!characterStack.isEmpty() && characterStack.peek()>chars[k] && maxIndex[characterStack.peek()-'a']>=k){
                    all_chars[characterStack.peek()-'a']=false;
                    characterStack.pop();
                }
                characterStack.push(chars[k]);
                all_chars[chars[k]-'a']=true;

            }

        StringBuilder sb = new StringBuilder();

        while (!characterStack.isEmpty()){
            sb.append(characterStack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        //String s="bcabc";
        String s="cbacdcbc";
        System.out.println(Solution(s));
    }
}
