package com.scaler.bitmanipulation;

//Similar : https://leetcode.com/problems/single-number-iii/

import java.util.Arrays;

public class SingleNumber3 {

    public static int[] getBinary(int n){

        int[] binary=new int[32];
        for(int i=31;i>=0;i--){
            if(n%2!=0){
                binary[i]=1;
            }
            n/=2;
        }

        return binary;
    }


    public static int[] solve(int[] A) {

        int n=A.length;
        int xor=A[0];
        int firstRightMostSetBit=0;
        int firstElem=0;
        int secondElem=0;

        for(int i=1;i<n;i++){
            xor^=A[i];
        }

        for(int i=0;i<32;i++){
            if((xor&(1<<i))!=0){
                firstRightMostSetBit=i;
                break;
            }
        }

        for(int i=0;i<n;i++){
            if((A[i]&(1<<firstRightMostSetBit))!=0){
                firstElem^=A[i];
            }
            else{
                secondElem^=A[i];
            }
        }

        return firstElem<secondElem?new int[]{firstElem,secondElem}:new int[]{secondElem,firstElem};
    }

    public static void main(String[] args) {

       // int[] A={1, 2, 3, 1, 2, 4};
        //int[] A={186, 256, 102, 377, 186, 377};
        //System.out.println(Arrays.toString(solve(A)));

        int[] neg4=getBinary(-4);
        System.out.println(Arrays.toString(neg4));
        int[] neg2=getBinary(-2);
        System.out.println(Arrays.toString(neg2));
        int a=(-4>>1);
        int[] nega=getBinary(a);
        System.out.println(Arrays.toString(nega));

    }
}
