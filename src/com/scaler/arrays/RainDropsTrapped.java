package com.scaler.arrays;

public class RainDropsTrapped {

    public static int trap(final int[] A) {
        int len=A.length;
        int[] maxOnLeft= new int[len];
        int[] maxOnRight= new int[len];

        for(int i=0;i<len;i++){
            int maxLeft=Integer.MIN_VALUE;
            int maxRight=Integer.MIN_VALUE;
            for(int j=i+1;j<len;j++){
                maxRight=Math.max(A[j],maxRight);
            }
            if(maxRight==Integer.MIN_VALUE){
                maxOnRight[i]=0;
            }
            else{
                maxOnRight[i]=maxRight;
            }


            for(int j=i-1;j>=0;j--){
                maxLeft=Math.max(A[j],maxLeft);
            }
            if(maxLeft==Integer.MIN_VALUE){
                maxOnLeft[i]=0;
            }
            else{
                maxOnLeft[i]=maxLeft;
            }

        }

        int totalUnits=0;
        for(int i=0;i<len;i++){
            int finalMax=Math.min(maxOnRight[i],maxOnLeft[i]);
            if(A[i]<finalMax){
                totalUnits+=finalMax-A[i];
            }
        }

        return totalUnits;
    }

    public static int trapOptimized(final int[] A) {
        int len=A.length;
        int[] prefixMax= new int[len+1];
        int[] postMax= new int[len+1];
        prefixMax[0]=A[0];
        postMax[len]=A[len-1];

        for(int i=0;i<len;i++){
            prefixMax[i+1]=Math.max(A[i],prefixMax[i]);
        }

        for(int i=len-1;i>0;i--){
            postMax[i-1]=Math.max(A[i],postMax[i]);
        }

        int totalUnits=0;
        for(int i=0;i<len;i++){
            int finalMax=Math.min(prefixMax[i],postMax[i]);
            if(A[i]<finalMax){
                totalUnits+=finalMax-A[i];
            }
        }

        return totalUnits;
    }

    public static void main(String[] args) {

        //int[] A={0,1,0,2};
        //int[] A={0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] A={56, 6, 52, 43, 23, 47, 48, 38, 96, 46, 30, 66, 80, 15, 62, 71, 61, 12, 98, 9, 28, 81, 70, 59, 95, 34, 9, 60, 70, 81, 71, 67, 58, 20, 22, 3, 95, 85, 20, 24, 74, 5, 23, 33, 75, 50, 38, 75, 68, 26, 46, 30, 75, 18, 4, 42, 51, 59, 8, 77 };

        System.out.println(trapOptimized(A));


    }
}
