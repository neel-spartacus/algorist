package com.scaler.arrays;

import java.util.Arrays;

public class MaxNonNegativeSubArray {


    public static int[] maxset(int[] A) {
        int size = A.length;
        int start = -1;
        int maxStart = -1;
        int maxEnd = -1;
        int end = -1;

        long maxCurr = 0;

        long maxSumSoFar = 0;
        long maxSoFar = 0;

        for (int i = 0; i < size; i++) {
            if (A[i] < 0 && i > 0) {
               /* maxSumSoFar = Math.max(maxSumSoFar, maxSoFar);
                maxStart = Math.max(maxStart,start);
                maxEnd=Math.max(maxEnd,end);*/
                if(maxSumSoFar<maxSoFar){
                    maxSumSoFar=maxSoFar;
                    maxStart=start;
                    maxEnd=end;
                }
                else if (maxSumSoFar == maxSoFar) {
                    if ((start!=-1 && end!=-1)&&(maxEnd + 1 - maxStart) < (end + 1 - start)) {
                        maxEnd = end;
                        maxStart = start;
                    } else if ((start!=-1 && end!=-1)&&(maxEnd + 1 - maxStart) == (end + 1 - start)) {
                        maxStart = Math.max(maxStart, start);
                        maxEnd = Math.max(maxEnd, end);
                    }
                }
                maxCurr=0;
                maxSoFar=0;
                start=-1;
                continue;

            }
            else {
                maxCurr = Math.max(maxCurr + A[i], A[i]);
                maxSoFar = Math.max(maxCurr, maxSoFar);
                end=i;

            }
            if (A[i] < 0) {
                continue;
            }
            if (start == -1) {
                start = i;
            }

        }
        if(maxSumSoFar<maxSoFar){
            maxSumSoFar=maxSoFar;
            maxStart=start;
            maxEnd=end;
        }

        if(maxStart!=-1 && maxEnd!=-1){
            int[] finalArr = new int[maxEnd-maxStart+1];
            for (int i = 0; maxStart <= maxEnd; i++) {
                finalArr[i] = A[maxStart];
                maxStart++;
            }
            return finalArr;
        }
        else{
             return new int[0];
        }

    }

    public static void main(String[] args) {

        //int[] A = {1, 4, -3, 9, 5, -6};
        //int[] A = { 756898537, -1973594324, -2038664370, -184803526, 1424268980};
        //int[] A ={0, 0, -1, 0 };
        //int[] A ={1967513926, 1540383426, -1303455736, -521595368};
        int[] A ={336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421};
        int[] result = maxset(A);
        if(result!=null){
            System.out.println(Arrays.toString(result));
        }

    }


}
