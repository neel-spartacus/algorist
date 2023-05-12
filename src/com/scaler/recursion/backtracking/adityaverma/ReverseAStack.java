package com.scaler.recursion.backtracking.adityaverma;

import java.util.Stack;

public class ReverseAStack {


    public static void reverseStack(Stack<Integer> stack){

        int size=stack.size();


        helper(stack);

    }

    public static void helper(Stack<Integer> stack){

        if(stack.size()==1){
            return;
        }
        int item=stack.pop();
        helper(stack);
        insert(stack,item);

    }

    public static void insert(Stack<Integer> stack,int item){

        if(stack.isEmpty()){
            stack.push(item);
            return;
        }
        int popedElem=stack.pop();
        insert(stack,item);
        stack.push(popedElem);

    }

    public static void main(String[] args) {

        int[] arr={1,2,3,4,5};

        Stack<Integer> stack= new Stack();
        for(int i= arr.length-1;i>=0;i--){
            stack.push(arr[i]);
        }

        reverseStack(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
