package com.leetcode.dynamicprogramming.aditya.verma.slidingwindow;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstNegNumInWindow {


    public static List<Integer> findFirstNegNums(int[] arr,int size,int w){

        int start=0;
        int end=0;
        List<Integer> firstNegNums=new ArrayList<>();
        List<Integer> negNums=new ArrayList<>();

        while (end<size){
            if(arr[end]<0){
                firstNegNums.add(arr[end]);
            }

            if(end-start+1<w){
                end++;
            }
            else if(end-start+1==w){
                if(firstNegNums.size()==0){
                    negNums.add(0);
                    start++;
                    end++;
                }
                else {
                    negNums.add(firstNegNums.get(0));
                    start++;
                    end++;
                    if(arr[start]!=firstNegNums.get(0)){
                        firstNegNums.remove(0);
                    }
                }

            }
        }

        return negNums;

    }

    public static void main(String[] args) {
        int N = 5, K = 2;
        int[] arr = {-8, 2, 3, -6, 10};

        List<Integer> negValues=findFirstNegNums(arr, N, K);
        System.out.println(Arrays.toString(negValues.toArray()));
    }
}
