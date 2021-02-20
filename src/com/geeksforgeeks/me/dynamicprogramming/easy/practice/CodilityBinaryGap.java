package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

public class CodilityBinaryGap {

    private static int binaryGap(int N){
        int gap=0;
        int val=0;

        String input=Integer.toBinaryString(N);
        char[] chars=input.toCharArray();
        int len=chars.length;

        for(int i=0;i<len;i++){

            if (chars[i] == '0') {
                 val+=1;
            }
            if(chars[i]=='1' && val>gap){
                gap=val;
                val=0;
            }
        }
        return gap;
    }

    public static void main(String[] args) {

        int gap=binaryGap(9);
        System.out.println(gap);
    }
}
