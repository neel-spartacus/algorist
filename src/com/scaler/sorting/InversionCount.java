package com.scaler.sorting;

import java.util.concurrent.atomic.AtomicInteger;

public class InversionCount {

    final static int mod=(int)1e9+7;

    public static int solve(int[] A) {

        int[] count= new int[1];
        divideNConquer(A,count);

        return count[0]%mod;


    }

    public static int[] divideNConquer(int[] A, int[] count){

        if(A.length==1){
            return A;
        }
        int n=A.length;
        int mid=n/2;

        int[] first=new int[mid];
        for(int i=0;i<mid;i++){
            first[i]=A[i];
        }
        int[] div1=divideNConquer(first,count);
        int[] second= new int[n-mid];
        for(int i=0;i<=second.length&&mid<n;i++){
            second[i]=A[mid];
            mid++;
        }
        int[] div2=divideNConquer(second,count);
        int[] div3=new int[div1.length+ div2.length];

        int i=0;
        int j=0;
        int k=0;

        while (i< div1.length&& j< div2.length){
            if(div1[i]>div2[j]){
                count[0]=((count[0]%mod)+(div1.length-i))%mod;
                div3[k]=div2[j];
                j++;
                k++;
            }else{
                div3[k]=div1[i];
                k++;
                i++;
            }
        }
        if(i==div1.length){
            for(int p=j;p<div2.length;p++){
                div3[k]=div2[p];
                k++;
            }
        }
        if(j==div2.length){
            for(int p=i;p<div1.length;p++){
                div3[k]=div1[p];
                k++;
            }
        }

        return div3;
    }
    public static void main(String[] args) {

        //int[] A={45, 10, 15, 25, 50};
        int[] A={28, 18, 44, 49, 41, 14};

        System.out.println(solve(A));
    }
}
