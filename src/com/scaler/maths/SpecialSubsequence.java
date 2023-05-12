package com.scaler.maths;

public class SpecialSubsequence {

    public static int solve(String A) {

        int n= A.length();
        char[] arr= A.toCharArray();
        int ans=0;
        int val=0;

        for(int i=n-1;i>=0;i--){
            if(arr[i]=='G'){
                val++;
            }
            if(arr[i]=='A'){
                ans+=val;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String A="ABCGAG";
        System.out.println(solve(A));
    }
}
