package com.scaler.twopointers;

public class AnotherCountRectangles {

    final static int mod=(int)1e9+7;

    public static int solve(int[] A, int B) {

        int n=A.length;

        int i=0;
        int j=n-1;
        long count=0;

        while (i<=j){
            long area=(A[i]*A[j])%mod;

            if(area<B){
                count=(count+(2*(j-i)+1))%mod;
                i++;
            }
            else{
                j--;
            }

        }
        return (int)count%mod;

    }

    public static void main(String[] args) {

        //int[] arr={5, 10, 20, 100, 105 };
        int[] arr={8, 15, 19, 21, 26, 30, 45, 48, 59, 66, 67, 72, 134, 143, 152, 174, 182, 185, 201, 207, 229, 234, 250, 253, 261, 303, 306, 312, 330, 359, 382, 385, 398, 427, 439, 442, 443, 455, 457, 484, 491 };
        //int[] arr={1,2};
       // int target=110;
        int target=902;

        System.out.println(solve(arr,target));
    }
}
