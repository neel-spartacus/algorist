package com.scaler.bitmanipulation;

public class DivideIntegers {


    //Throws TLE for input A : 2147483647
    //B : 1
    public static int divide(int A, int B) {

        int res=0;
        if(A==(1<<31)&&B==-1){
            return (1<<31)-1;
        }
        int a=Math.abs(A);
        int b=Math.abs(B);

        while (a-b>=0){
            int temp=b;
            int num=1;
            while ((temp<<1)<=a){
                temp<<=1;
                num<<=1;
            }
            res+=num;
            a-=temp;

        }

        return (A>0)==(B>0)?res:-res;
    }

    public static int divideBitsWise(int A, int B) {

            if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
            int a = Math.abs(A), b = Math.abs(B), res = 0;
            for (int x = 31; x >= 0; x--)
                if ((a >>> x) - b >= 0) {
                    res += 1 << x;
                    a -= b << x;
                }
            return (A > 0) == (B > 0) ? res : -res;
        }

    public static void main(String[] args) {
        int A=2147483647;
        int B=1;
        System.out.println(divideBitsWise(A,B));
    }
}
