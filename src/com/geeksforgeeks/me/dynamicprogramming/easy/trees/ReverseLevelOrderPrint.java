package com.geeksforgeeks.me.dynamicprogramming.easy.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderPrint {

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void levelOrderTraversalInReverse(Node node){

        if(node==null){
            return;
        }
        Stack<Node> s =  new Stack<>();
        Queue<Node> q =  new LinkedList<Node>();
        q.offer(node);

        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
            s.push(curr);
        }
        while (!s.isEmpty()){
            System.out.println(s.pop().value + " ");
        }
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);


        levelOrderTraversalInReverse(root);
    }
}
