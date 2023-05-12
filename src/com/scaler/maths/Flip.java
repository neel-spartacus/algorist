package com.scaler.maths;

public class Flip {

    public static int[] flip(String A) {

        int n=A.length();

        int[] arr= new int[n];
        String[] str=A.split("");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                arr[i]=-1;
            }
            if(arr[i]==0){
                arr[i]=1;
            }
        }

        int sum=0;
        int max=0;
        int lIndex=0;
        int maxLIndex=0;
        int rIndex=0;
        int maxRIndex=0;

        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if(sum==(-n)){
            return new int[0];
        }
        else {
            sum=0;
        }

        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum<0){
                sum=0;
                lIndex=i+1;
            }
            else {
                rIndex=i;
            }

            if(max<sum){
                max=sum;
               maxLIndex=lIndex;
               maxRIndex=rIndex;
                }
            else if(max==sum){
                maxRIndex=maxLIndex==lIndex?(maxRIndex<rIndex?maxRIndex:rIndex):(maxRIndex<rIndex)?maxRIndex:rIndex;
                maxLIndex=(maxLIndex<=lIndex)?maxLIndex:lIndex;
            }

        }


return new int[]{maxLIndex+1,maxRIndex+1};
    }

    public static void main(String[] args) {
        String A="01010110";
        System.out.println(flip(A));

    }
}
