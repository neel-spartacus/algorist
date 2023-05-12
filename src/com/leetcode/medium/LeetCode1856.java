package com.leetcode.medium;

import java.util.Stack;

public class LeetCode1856 {

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


    public  static int maxSumMinProduct(int[] nums) {

        int n=nums.length;
        int[] prev= new int[n];
        int[] next= new int[n];

        prev=find_previous_smallest(nums);
        next=find_next_smallest(nums);

        for(int i=0;i<n;i++){
            System.out.println(prev[i] + " " + i + " " + next[i]);
        }

        int[]prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }

        double answer=0;
        for(int i=0;i<n;i++){
            double sum=prefix[next[i]-1]- (prev[i]==-1?0:prefix[prev[i]]);
            answer=Math.max(answer, sum*nums[i]);
        }


       return (int)answer%1000_000_007;



    }


    public static void main(String[] args) {

        int[] nums={2,5,4,2,4,5,3,1,2,4};

        maxSumMinProduct(nums);
    }
}
