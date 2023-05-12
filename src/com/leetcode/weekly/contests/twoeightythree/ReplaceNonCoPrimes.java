package com.leetcode.weekly.contests.twoeightythree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReplaceNonCoPrimes {


    // https://leetcode.com/problems/replace-non-coprime-numbers-in-array/discuss/1823798/JavaC%2B%2BPython-Stack-One-Pass-Solution

    public static List<Integer> replaceNonCoPrimesOptimal(int[] nums) {

        int len=nums.length;

        List<Integer> list= new ArrayList<>();

        for(int i=0;i<len;i++){

            int a=nums[i];
            while (true){
                long num=list.isEmpty()?1:list.get(list.size()-1);
                int gcd=gcd((int)num,a);
                if(gcd==1){
                    break;
                }else{
                    long lcm=((long)num*(long)nums[i])/gcd;
                    list.remove(list.size()-1);
                    a=(int)lcm;
                }
            }

            list.add(a);

        }

        return list;

    }

    public static List<Integer> replaceNonCoprimes(int[] nums) {

        int[] arr=generateModifiedArrayHelper(nums);

        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static int[] generateModifiedArrayHelper(int[] nums){

        int len=nums.length;

        int[] arr= nums;

        for(int i=0,j=i+1;i<len && j<len;i++,j++){
            int gcd=gcd(nums[i],nums[j]);

            if(gcd>1){
                long lcm=((long)nums[i]*(long)nums[j])/gcd;
                int[] modiFiedArr= new int[len-1];
                if(i-1>=0 && j+1<len){
                    System.arraycopy(nums,0,modiFiedArr,0,i);
                    modiFiedArr[i]= (int) lcm;
                    System.arraycopy(nums,j+1,modiFiedArr,i+1,len-(j+1));
                }
                else if(i-1<0){
                    modiFiedArr[i]= (int) lcm;
                    System.arraycopy(nums,j+1,modiFiedArr,j,len-(j+1));
                   // System.arraycopy(nums,j,modiFiedArr,i+1,len-1);
                }
                else if(j+1>len-1){
                    System.arraycopy(nums,0,modiFiedArr,0,len-2);
                    modiFiedArr[len-2]= (int) lcm;
                }
                   arr= generateModifiedArrayHelper(modiFiedArr);
                   return arr;
                }
            else {
                continue;
            }
        }

        return arr;
    }


    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static void main(String[] args) {

        int[] nums={13981,11,25,10535,19565,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,19379,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,72977,2269,2269,2269,2269,2269,2269,2269,2269,2269,2269,2269,2269,2269,2269,2269,2269,33533,155,145,4205,4495,725,29,29,145,25,725,5,145,5,5,155,155,5,5,5,1121,1121,59,59,59,361,19,19,19,1121,19,361,1121,1121,361,361,19,19,80246,4,2,2,2,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,37717,4042,86,2,172,86,4042,4042,172,3698,172,2,172,86,2,172,43,1849,3698,13,121,143,143,11,11,11,143,143,93,31,31,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797,44797};
        //int[] nums={31,97561,97561,97561,97561,97561,97561,97561,97561};
        List<Integer> list=replaceNonCoPrimesOptimal(nums);
        System.out.println(list);
    }
}