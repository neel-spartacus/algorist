package com.scaler.bitmanipulation;

public class ReverseBits {


    public static long reverse(long a) {

        long ans = 0;
        for(int i = 0; i < 32; i++) {
            ans<<=1;
            if((a&1)==1){
                ans|=(a&1);
            }
            a>>>=1;
        }
        return ans;
    }
    public static void main(String[] args) {
        long a=3;
        System.out.println(reverse(a));
    }
}
