package com.tleeliminators.prefixsum.backtracking;


//https://leetcode.com/problems/subsets/

import java.util.*;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {

      List<Integer> curr=new ArrayList<>();
      List<List<Integer>> subsets=new ArrayList<>();

      helper(nums,0,subsets,curr);


     return subsets;




    }

    public static void helper(int[] nums, int index, List<List<Integer>> subsets, List<Integer> curr){


        subsets.add(new ArrayList<>(curr));
        int len=nums.length;
        for(int i=index;i<len;i++){
            curr.add((nums[i]));
            //subsets.add(Arrays.asList(nums[index]));
            helper(nums, i+1, subsets,curr);
            curr.remove(curr.size()-1);
        }


    }

        public static void main (String[]args){

            int[] nums = {1, 2, 3};

            List<List<Integer>> subsets=subsets(nums);


          System.out.println(subsets);


        }
    }

