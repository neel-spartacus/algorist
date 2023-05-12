package com.test.codility;

public class BreakChain {

    public static long min(int[] arr, int l, int r) {
        long min = Long.MAX_VALUE;
        for (int i = l; i < r; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public static long breakChain(int[] arr) {

        long min = Long.MAX_VALUE;
        int size = arr.length;

        long[] prefix = new long[size + 1];
        prefix[0] = arr[0];
        for (int i = 1; i < size - 1; i++) {
            if (i + 2 < size - 1) {
                prefix[i] = arr[i] + min(arr, i + 2, size - 1);
            }

        }

        for (int i = 1; i < size; i++) {
            if (prefix[i] == 0) {
                continue;
            } else {
                min = Math.min(min, prefix[i]);
            }

        }


       /* for(int l=1;l<size-3;l++){
            int r=l+2;
            while(r<size-1){
                min=Math.min(min,arr[l]+arr[r]);
                r++;
            }
        }*/

        return min;
    }

    public static void main(String[] args) {

        int[] arr = {150000000, 1000000000, 9865445, 90205058, 30000000, 70000000,90205058,140000500};

        System.out.println(breakChain(arr));

    }
}
