package com.scaler.maths;

public class DeleteOne {

    public static int solve(int[] A) {

        int size=A.length;

        int[] preGcd= new int[size+1];
        int[] postGcd= new int[size+1];
        int maxGcd=Integer.MIN_VALUE;
        preGcd[0]=0;
        postGcd[size]=0;
        for(int i=0;i<size;i++){
           preGcd[i+1]=gcd(A[i],preGcd[i]);

        }
        for(int i=size-1;i>0;i--){
            postGcd[i-1]=gcd(A[i],postGcd[i]);
        }
        for(int i=0;i<size;i++){
            maxGcd=Math.max(maxGcd,gcd(preGcd[i],postGcd[i]));
        }

        return maxGcd;
    }

    public static int gcd(int b,int c){
        if(c==0){
            return b;
        }
        return gcd(c,b%c);
    }

    public static void main(String[] args) {
        int[] arr={12,15,18};
        //int[] arr={5,15,30};
        System.out.println(solve(arr));
    }
}
