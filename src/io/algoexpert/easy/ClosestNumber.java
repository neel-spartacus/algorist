package io.algoexpert.easy;

import java.util.Hashtable;

public class ClosestNumber {

    public static void main(String[] args) {

        BST binaryTree= new BST(10);
        binaryTree.insert(binaryTree, 5);
        binaryTree.insert(binaryTree, 15);
        binaryTree.insert(binaryTree, 2);
        binaryTree.insert(binaryTree, 5);
        binaryTree.insert(binaryTree, 1);
        binaryTree.insert(binaryTree, 13);
        binaryTree.insert(binaryTree, 22);
        binaryTree.insert(binaryTree, 14);

        int closestValue=findClosestValueInBst(binaryTree, 12);

        System.out.println(closestValue);


    }


    public static int findClosestValueInBst(BST tree, int target) {

        if(tree.value>target && tree.left!=null) {
            int abs=Math.abs(tree.value-target);
            int closestNode=findClosestValueInBst(tree.left, target);
            return abs<Math.abs(closestNode-target)?tree.value:closestNode;

        }
        else if(tree.value<target && tree.right!=null){
            int abs=Math.abs(tree.value-target);
            int closestNode=findClosestValueInBst(tree.right, target);
            return abs<Math.abs(closestNode-target)?tree.value:closestNode;
        }
        else  if(tree.value==target || (tree.value>target && tree.left==null) || (tree.value<target && tree.right==null) ){
            return tree.value;
        }

        return 0;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public void insert( BST bst,int value){
            if(bst.value<=value && bst.right==null){
                bst.right=new BST(value);
            }
            else if(bst.value<=value && bst.right!=null){
                insert(bst.right, value);
            }
            else if(bst.value>value && bst.left==null){
                bst.left=new BST(value);
            }
            else if(bst.value>value && bst.left!=null){
                insert(bst.left, value);
            }

        }
    }
}
