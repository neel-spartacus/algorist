package com.scaler.recursion.backtracking.adityaverma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.StreamSupport;

public class DeleteMiddleElementInStack {

    public static void deleteMiddleElement(Stack<Integer> stack){

        int size=stack.size();

        int middle=(size/2)+1;

        helper(stack,middle);

    }

    public static void helper(Stack<Integer> stack,int middle){

        if(middle==1){
            stack.pop();
            return;
        }
        int topElement=stack.pop();
        helper(stack,middle-1);
        stack.push(topElement);

    }


    public static void main(String[] args) {

        int arr[]={1,2,3,4,5,6};

        Stack<Integer> stack= new Stack();
        for(int i= arr.length-1;i>=0;i--){
            stack.push(arr[i]);
        }

        deleteMiddleElement(stack);

        ArrayList<Integer> elements= new ArrayList<>();
        while (!stack.isEmpty()){
            elements.add(stack.pop());
        }

        System.out.println(Arrays.toString(elements.toArray()));
    }
}
