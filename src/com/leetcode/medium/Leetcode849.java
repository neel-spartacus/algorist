package com.leetcode.medium;

public class Leetcode849 {

    public static int maxDistToClosest(int[] seats) {

        int size=seats.length;
        int left=-1;
        int max=0;


        for(int i=0;i<size;i++){
            if(seats[i]==0){
                continue;
            }
            if(left==-1){
                max=Math.max(max, i);
            }
            else{
                max=Math.max(max, (i-left)/2);
            }
            left=i;

        }
        if(seats[size-1]==0){
            max=Math.max(max, size-1-left);
        }

  return max;
    }

    public static void main(String[] args) {
        //int[]  seats = new int[]{1,0,0,0,1,0,1};
        int[]  seats = new int[]{0,0,1,0,1,0,0,0};

        System.out.println(maxDistToClosest(seats));
    }

}