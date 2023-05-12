package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

import java.util.Scanner;

public class BitManipulations {


    public static void bitValues(int num){

        for(int k=5;k>=0;k--){
            if((num & ~(1<<k))!=0){
                System.out.println((num ^(1<<k)));

            }
            else{
                System.out.println(0);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int num=Integer.parseInt(sc.next());
        bitValues(num);

    }
}
