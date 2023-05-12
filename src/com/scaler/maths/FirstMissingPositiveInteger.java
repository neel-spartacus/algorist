package com.scaler.maths;

public class FirstMissingPositiveInteger {

    public static int firstMissingPositive(int[] A) {

        int len=A.length;

        for(int i=0;i<len;i++){
            if(A[i]<=0 || A[i]>len){
                continue;
            }
            int pos=A[i]-1;
            int temp=A[i];
            A[i]=A[pos];
            A[pos]=temp;
            if(A[i]!=A[pos]){
                i--;
            }

        }

        int negCounts=0;
        for( int i=0;i<len;i++){
            if(A[i]<0){
                negCounts++;
            }
            if(A[i]!=i+1){
                return i+1;
            }
        }
        return negCounts==len?1:len+1;
    }

   // public static void swap()
    public static void main(String[] args) {

        int[] A={3, 4, -1, 1};
        //int[] A={1,2,0};

        System.out.println(firstMissingPositive(A));

    }
}
