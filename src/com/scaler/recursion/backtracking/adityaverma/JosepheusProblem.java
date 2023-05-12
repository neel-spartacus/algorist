package com.scaler.recursion.backtracking.adityaverma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JosepheusProblem {

    public static int safePos(int n,int k){

        List<Integer> positions=new ArrayList<>();
        for(int i=0;i<n;i++){
            positions.add(i+1);
        }

        return helper(positions,0,k);

    }

    public static int helper(List<Integer> positions,int index,int k){

        if(positions.size()==1){
            return positions.get(0);
        }

        index=(index+(k-1))%positions.size();

        positions.remove(index);

       return helper(positions,index,k);

    }

    public static void main(String[] args) {

        int n=40,k=7;

        System.out.println(safePos(n,k));

    }
}
