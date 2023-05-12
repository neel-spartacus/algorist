package com.leetcode.binarysearch;


//Problem : https://leetcode.com/problems/minimum-speed-to-arrive-on-time/

public class MinimumSpeedToArrive {

    public static int minSpeedOnTime(int[] dist, double hour) {

        int len=dist.length;

        long minSpeed=1;
        long maxSpeed= (long) 1e7;

        double ans=-1;

        while (minSpeed<=maxSpeed){

            long mid= minSpeed +((maxSpeed-minSpeed)/2);
            double timeTaken=0;

            for( int i=0;i<len;i++){
                timeTaken=Math.ceil(timeTaken);
                double value=(double)dist[i]/mid;
                timeTaken+=value;
            }
            if(timeTaken>hour){
                minSpeed=mid+1;
            }
            else{
                ans=mid;
                maxSpeed=mid-1;
            }
        }

        return (int) (ans>1e7?-1:ans);
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

    public static void main(String[] args) {

        int[] dist={1,3,2};

        double hour=1.9;

        System.out.println(minSpeedOnTime(dist,hour));

    }
}
