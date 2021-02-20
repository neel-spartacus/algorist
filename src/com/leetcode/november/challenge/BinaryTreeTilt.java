package com.leetcode.november.challenge;

import java.util.*;

public class BinaryTreeTilt {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int i, Stack stack) {


           if (i < arr.length) {
               TreeNode temp = new TreeNode(arr[i]);
               root = temp;
               // insert left child

               if(root!=null) {
                   root.left = insertLevelOrder(arr, root.left, 2 * i + 1, stack);

                   // insert right child    }
                   root.right = insertLevelOrder(arr, root.right, 2 * i + 2, stack);

               }
           }

        return root;
    }

    static Stack reverseLevelOrder(TreeNode node)
    {
        Stack<TreeNode> S = new Stack();
        Queue<TreeNode> Q = new LinkedList();
        Q.add(node);

        // Do something like normal level order traversal order.Following
        // are the differences with normal level order traversal
        // 1) Instead of printing a node, we push the node to stack
        // 2) Right subtree is visited before left subtree
        while (Q.isEmpty() == false)
        {
            /* Dequeue node and make it root */
            node = Q.peek();
            Q.remove();
            S.push(node);

            /* Enqueue right child */
            if (node.right != null)
                // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
                Q.add(node.right);

            /* Enqueue left child */
            if (node.left != null)
                Q.add(node.left);
        }

        return S;

    }

     static int result=0;
    public static int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }

    private static int postOrder(TreeNode root) {
        if (root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        result += Math.abs(left - right);

        return left + right + root.val;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{21, 7, 14, 1, 1, 2, 2, 3, 3};
        TreeNode root = new TreeNode();
        Stack<TreeNode> stack = new Stack();
        List<Integer> integers = new ArrayList<>();
        root = insertLevelOrder(arr, root, 0, stack);


        System.out.println(findTilt(root));


    }

}