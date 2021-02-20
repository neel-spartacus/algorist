package com.geeksforgeeks.me.dynamicprogramming.easy.trees;

import java.util.HashSet;
import java.util.Set;

public class PreToBst {


    static class Node{

        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value=value;
        }
    }


    public static Node constructBst(Node node,int v){

        if(node==null){
            node= new Node(v);
        }
        else if(node.value>v){
            node.left=constructBst(node.left, v);
        }

        else if(node.value<v){
            node.right=constructBst(node.right, v);
        }


        return node;

    }

    public  static int postOrderTraversal(Node prev,Node node,int k,int[] arr,Set unique){

        Node previous=prev;
        Node current=node;
        if (current==null){
            return k;
        }

        while (current.left!=null){
               previous=current;
            current=current.left;
        }

        while (current.right!=null){
            previous=current;
            current=current.right;
        }

        arr[k]=current.value;
        k++;
        unique.add(current.value);
        if(previous.right!=null && !unique.contains(previous.right.value)){
            k=postOrderTraversal(previous,previous.right,k, arr,unique);
        }

        else if(previous.left!=null && !unique.contains(previous.left.value)){
            k=postOrderTraversal(previous,previous.left,k, arr,unique);
        }

        else{
            arr[k]=previous.value;
        }


        return k;


    }

   static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
    }


    static void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        printInorder(node.right);
        System.out.print(node.value + " ");

    }
    public static void main(String[] args) {

        int k=0;
       // int[] preOrder= new int[]{40,30,35,80,100};
        int[] preOrder= new int[]{40,30,32,35,80,90,100,120};
        Set<Integer> s = new HashSet<>();

       /* for(int j=0;j<preOrder.length;j++){
            s.add(preOrder[j]);
        }*/

        Node root=new Node(preOrder[0]);

        for(int i=1;i<preOrder.length;i++){
            constructBst(root, preOrder[i]);
        }

       // printInorder(root);

        int[] postorder= new int[preOrder.length];

        int c= postOrderTraversal(root, root.left, k,postorder ,s );
        int d =postOrderTraversal(root, root.right, c+1,postorder ,s );
        postorder[++d]=root.value;

        for(int h=0;h<postorder.length;h++){
            System.out.println(postorder[h]);
        }



    }
}
