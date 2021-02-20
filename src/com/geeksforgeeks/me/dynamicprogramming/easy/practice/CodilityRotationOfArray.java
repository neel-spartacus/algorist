package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

public class CodilityRotationOfArray {


    public static int[] solution(int[] A, int K){

        try{
            int len=A.length;
            if(len<0||len>100){
                throw new RuntimeException();
            }
            if(K<0||K>100){
                throw new RuntimeException();
            }
            for(int i=1;i<=K;i++){
                int tmp=A[len-1];
                for(int j=len-1;j>0;j--){
                    if((-1000<A[j]||A[j]<1000)){
                        A[j]=A[j-1];
                    }
                    else{
                        throw new RuntimeException();
                    }
                }
                A[0]=tmp;
            }
        }
        catch (Exception ex){
            System.out.println("Invalid input" + ex.getMessage());
        }

        return A;
    }

    public static void main(String[] args) {
        int[] a={3,8,9,7,6};
        int k=3;

        int[] vals=solution(a, k);

        for(int v:vals){
            System.out.println(v);
        }
    }
}
