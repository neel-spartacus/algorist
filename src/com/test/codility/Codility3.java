package com.test.codility;

import java.util.Arrays;

public class Codility3 {


    public static int solution( String s){

        if(!isBinary(s.toCharArray())){
            throw new RuntimeException("Invalid input");
        }

        int count = 0;
        int xor=0;
        while(s.length() > 0 && binaryToDecimal(s)!=0) {
            //count++;
            if(s.charAt(s.length() - 1) == '0'){
                s = s.substring(0, s.length() - 1);
                count++;
            }
            else {
                char[] ch = s.toCharArray();
                int curr = s.length() - 1;
                if(curr >= 0 && ch[curr] == '1') {
                    ch[curr] = '0';
                    count++;
                }
                    s = new String(ch);
            }
        }
        return count;
    }

    public static boolean isBinary(char[] input)
    {
        int len=input.length;
        for (int i = 0; i<len; ++i)
            if (input[i] != '0' && input[i] != '1')
                return false;
        return true;
    }

   public static int binaryToDecimal(String n)
    {
        String num = n;
        int dec_value = 0;

        // Initializing base value to 1,
        // i.e 2^0
        int base = 1;

        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            if (num.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }

        return dec_value;
    }

    public static int solve(String s){

        int len=s.length();
        char[] chars=s.toCharArray();
        int[] dp= new int[len];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[len-1]=0;
        if(!isBinary(chars)){
            throw new RuntimeException("Invalid Input");
        }
        else{

            for(int i=len-1;i>=0;i--){
                if(i%2==0){
                    dp[i/2]=Math.min(dp[i/2],dp[i]+1);
                }
                if(i>0){
                    dp[i-1]=Math.min(dp[i-1],dp[i]+1);
                }
            }

        }
        return dp[0];
    }
    public static void main(String[] args) {

        String s="1111010101111";
        System.out.println(solution(s));
    }
}
