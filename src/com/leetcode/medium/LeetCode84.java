package com.leetcode.medium;

import java.util.Stack;

public class LeetCode84 {

    static class Node{
        int value;
        int index;

        Node(int value,int index){
            this.value=value;
            this.index=index;
        }
    }

    public static int[] find_previous_smallest(int[] nums){
        int n=nums.length;
        int[] prev= new int[n];

        Stack<Node> stack= new Stack<>();
        Node init=new Node(Integer.MIN_VALUE, -1);
        stack.push(init);

        for(int i=0;i<n;i++){

            while (stack.peek().value>=nums[i]){
                stack.pop();
            }
            prev[i]=stack.peek().index;
            stack.push(new Node(nums[i],i ));

        }

        return prev;
    }

    public static int[] find_next_smallest(int[] nums){
        int n=nums.length;
        int[] next= new int[n];

        Stack<Node> stack= new Stack<>();
        Node init=new Node(Integer.MIN_VALUE, n);
        stack.push(init);

        for(int i=n-1;i>=0;i--){

            while (nums[i]<=stack.peek().value){
                stack.pop();
            }
            next[i]=stack.peek().index;
            stack.push(new Node(nums[i],i ));

        }

        return next;
    }


    public  static int largestRectangleArea(int[] heights) {

        int n= heights.length;
        int[] prev= new int[n];
        int[] next= new int[n];

        prev=find_previous_smallest(heights);
        next=find_next_smallest(heights);

        /*for(int i=0;i<n;i++){
            System.out.println(prev[i] + " " + i + " " + next[i]);
        }*/

        int[]prefix=new int[n];
        prefix[0]= heights[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+ heights[i];
        }

        int max_area=heights[0];
        for(int i=0;i<n;i++){
            int diffBreadth=next[i] - (prev[i]+1);
            max_area=Math.max(max_area, diffBreadth* heights[i]);
        }


       return max_area;



    }


    public static void main(String[] args) {

        //int[] nums={2,1,5,6,2,3};
        int[] nums={ 6, 2, 5, 4, 5, 1, 6 };

        System.out.println(largestRectangleArea(nums));
    }
}
