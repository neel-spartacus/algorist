package com.leetcode.recursion;



//Problem : https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
public class BinaryString {


    public static char findKthBit(int n, int k) {

    String binaryString=helper(n);
    return binaryString.toCharArray()[k-1];




    }


    public static String helper(int n){

        if(n==1){
            return "0";
        }
        String prev=helper(n-1);
        String inverse=inverse(prev);
        return prev+"1"+reverse(inverse.toCharArray());

    }

    private static String inverse(String prev) {

        String[] arr= prev.split("");
        StringBuilder inverse=new StringBuilder();
        for(String s:arr){
            int val=Integer.parseInt(s)^1;
            inverse.append(String.valueOf(val));
        }
        return inverse.toString();
    }

    private static String reverse(char[] prevArr) {
        int len = prevArr.length;
        char temp;

        for (int i = 0; i < len / 2; i++) {
            temp = prevArr[i];
            prevArr[i] = prevArr[len - 1 - i];
            prevArr[len - 1 - i] = temp;
        }

        return String.valueOf(prevArr);
    }
    public static void main(String[] args) {
        System.out.println(findKthBit(4,11));
    }
}
