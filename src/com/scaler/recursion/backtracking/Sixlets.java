package com.scaler.recursion.backtracking;

import java.util.Arrays;

public class Sixlets {

    public static int solve(int[] A, int B) {

     int n=A.length;
     int  count=0;
     if(n==0 || n>20){
         return 0;
     }
     if(n<B){
         return 0;
     }
     if(n==1 && B==1 && A[0]<=1000){
        return 1;
     }
     int[] curr= new int[n];

     count=subsequenceSum(0,curr,A,B,count);

     return count;

    }

    public static int subsequenceSum(int index,int[] curr,int[] A,int elements, int count){

        int temp=0;
        if(index==A.length){
            if(findSumForElements(curr,A,elements)){
                System.out.println(Arrays.toString(curr));
                count++;
                return count;
            }
            else{
                return 0;
            }

        }

        curr[index]=0;
        temp+=subsequenceSum(index+1,curr,A,elements,count);
        curr[index]=1;
        temp+=subsequenceSum(index+1,curr,A,elements,count);

        return temp;

    }

    private static boolean findSumForElements(int[] curr, int[] a, int elements) {
        int n=curr.length;
        int sum=0;
        for(int i=0;i<n;i++){
                if(curr[i]==1){
                    sum+=a[i];
                    elements--;
                }
            }
        return sum<=1000&&elements==0?true:false;
    }

    public static void main(String[] args) {

        int[] A={1, 2, 8};
        int B=2;

        System.out.println(solve(A,B));

    }
}
