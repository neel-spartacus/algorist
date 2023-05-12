package com.scaler.stringalgorithm;

import java.util.Arrays;

public class ZAlgorithm {

    public static int[] calculateZArray(String s){

        char[] arr=s.toCharArray();
        int n=arr.length;

        int[] zArray=new int[n];
        zArray[0]=0;

        int l=0,r=0;
        for(int i=1;i<n;i++){

            if(i>r){
                l=r=i;
                while (r<n && arr[r]==arr[r-l]){
                    r++;
                }
                zArray[i]=r-l;
                r--;
            }else{
                int k=i-l;
                if(zArray[k]<r-i+1){
                    zArray[i]=zArray[k];
                }
                else{
                    l=i;
                    while (r<n && arr[r]==arr[r-l]){
                        r++;
                    }
                    zArray[i]=r-l;
                    r--;
                }
            }
        }
        return zArray;

    }


    public static void main(String[] args) {

        String s="aabxaabxsaabxaabxay";
        System.out.println(Arrays.toString(calculateZArray(s)));
    }
}
