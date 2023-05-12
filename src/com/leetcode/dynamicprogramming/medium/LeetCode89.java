package com.leetcode.dynamicprogramming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89 {

    public static List<Integer> grayCode(int n) {
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);
        for(int i=0;i<n;i++){
            int size=rs.size();
            for(int k=size-1;k>=0;k--)
                rs.add(rs.get(k) | 1<<i);
        }
        return rs;
    }

    public static void main(String[] args) {
        int n=3;
        List<Integer> grayCodes=grayCode(n);
        for(int i:grayCodes){
            System.out.println(i);
        }
    }
}
