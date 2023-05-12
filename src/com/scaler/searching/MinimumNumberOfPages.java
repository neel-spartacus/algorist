package com.scaler.searching;

import java.util.Arrays;

public class MinimumNumberOfPages {

    public static int solve(int[] A,int B){

        Arrays.sort(A);

        int minPages=A[0];
        int maxPages=0;
        for(int i=0;i<A.length;i++){
            maxPages+=A[i];
        }

        int l=0;
        int r=maxPages;
        int result=0;

        while (l<r){
            int mid=l+((r-l)/2);

            if(binaryCheck(A,mid,B)){

               // result=mid;
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }


      // return binaryCheck(A,r,B)?r:r-1;
        return r;
    }

    private static boolean binaryCheck(int[] a, int possibleValue, int b) {
        int initialValue=0;
        b--;
        int i=0;
        while (i<a.length){
            if(a[i]+initialValue>=possibleValue){
                b--;
                initialValue=a[i];
            }
            else{
                initialValue+=a[i];
            }
            i++;
        }

        return b==0?true:false;
    }

    public static void main(String[] args) {
        int[] A={12, 34, 67, 90};
        int B=2;
        System.out.println(solve(A,B));
    }
}
