package com.scaler.twopointers;

public class ContainerWithMostWater {


    public static int maxArea(int[] A) {

        int n=A.length;

        if(n==1){
            return 0;
        }

        int maxArea=Integer.MIN_VALUE;
        int i=0;
        int j=n-1;
        //int maxArea=0;

        while (i<j){
            int area=(j-i)*Math.min(A[i],A[j]);
            maxArea=Math.max(maxArea,area);

            if(A[i]<=A[j]){
                i++;
            }
            else{
                j--;
            }
        }

        return maxArea;

    }
    public static void main(String[] args) {

        int[] arr={1, 5, 4, 3};
        System.out.println(maxArea(arr));
    }
}
