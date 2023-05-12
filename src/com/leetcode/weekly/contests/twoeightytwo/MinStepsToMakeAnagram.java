package com.leetcode.weekly.contests.twoeightytwo;

public class MinStepsToMakeAnagram {


    public static int minSteps(String s, String t) {

        int[] countS= new int[256];
        int[] countT= new int[256];

        int min=0;

        for(int i=0;i<s.length();i++){
            countS[s.charAt(i)-'0']++;
        }
        for(int i=0;i<t.length();i++){
            countT[t.charAt(i)-'0']++;
        }

        for(int i=0;i<256;i++){
            if(countS[i]==0 && countT[i]==0){
                continue;
            }
            else if(countS[i]==0 && countT[i]!=0){
                min+=countT[i];
            }
            else if(countS[i]!=0 && countT[i]==0){
                min+=countS[i];
            }
            else{
                int abs=Math.abs(countS[i]-countT[i]);
                min+=abs>=0?abs:(-abs);
            }
        }

        return min;
    }

    public static void main(String[] args) {

        //String s="leetcode";
        String s="thing";
       // String t="leetcode";
        String t="thing";
        System.out.println(minSteps(s,t));
    }
}
