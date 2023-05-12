package com.leetcode.weekly.contests.twoeightytwo;

public class MinTimeToCompleteTrips {

    public static long minimumTime(int[] time, int totalTrips) {

        int len=time.length;


        long min=0;
        long max= (long) 1e14;

        long ans=0;

        while(min<=max){

            long mid=min+ ((max-min)/2);
            long trips=0;
            for(int i=0;i<len;i++){
                trips+=(mid/time[i]);
            }
            if(trips>=totalTrips){
                ans=mid;
                max=mid-1;
            }
            else if(trips<=totalTrips){
                min=mid+1;
            }

        }
        return ans;

    }

    public static int max(int[] A){
        int max=0;
        for(int a:A){
            if(a>max){
                max=a;
            }
        }
        return max;
    }
    public static int min(int[] A){
        int min=Integer.MAX_VALUE;
        for(int a:A){
            if(a<min){
                min=a;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        int[] time={5,10,10};
        int totalTrips=9;

        System.out.println(minimumTime(time,totalTrips));
    }
}
