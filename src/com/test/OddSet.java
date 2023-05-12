package com.test;

import java.util.Scanner;

public class OddSet {

    public static void oddSet(int arr[]){

        int n=arr.length;
        int odd=0,even=0;

        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                odd+=1;
            }
            else{
                even+=1;
            }
        }

        if(odd==even){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int x;
            x = scanner.nextInt();
            int[] arr= new int[2*x];
            for(int j=0;j<2*x;j++){
                arr[j] = scanner.nextInt();
            }
           oddSet(arr);


        }

    }
}
