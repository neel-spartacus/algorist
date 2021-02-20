package com.leetcode.november.challenge;

public class MaxDiffSubtree {

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


    public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) {


           if (i < arr.length) {
               TreeNode temp = new TreeNode(arr[i]);
               root = temp;
               // insert left child

               if(root!=null) {
                   root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

                   // insert right child    }
                   root.right = insertLevelOrder(arr, root.right, 2 * i + 2);

               }
           }

        return root;
    }

    public static int maxAncestorDiff(TreeNode root) {


      int left=Math.abs(root.val-Math.abs(findMaxInLeft(root.left, Integer.MIN_VALUE)))>Math.abs(root.val-Math.abs(findMinInLeft(root.left, Integer.MAX_VALUE)))?Math.abs(findMaxInLeft(root.left, Integer.MIN_VALUE)):Math.abs(findMinInLeft(root.left, Integer.MAX_VALUE));
      int right=Math.abs(root.val-Math.abs(findMaxInRight(root.right, Integer.MIN_VALUE)))>Math.abs(root.val-Math.abs(findMinInRight(root.right, Integer.MAX_VALUE)))?Math.abs(findMaxInRight(root.right, Integer.MIN_VALUE)):Math.abs(findMinInRight(root.right, Integer.MAX_VALUE));
      //int right=Math.max(root.val,Math.abs(findMaxInRight(root.right, Integer.MIN_VALUE)))-Math.min(root.val,Math.abs(findMinInRight(root.right, Integer.MAX_VALUE)));

      return Math.max(left,right );



    }

    public static int findMinInLeft(TreeNode node,int min){
        if(node!=null){
            if(node.val<min){
                min=node.val;
            }
            int a=findMinInLeft(node.left, min);
            int b=findMinInLeft(node.right, min);
            min=Math.max(min,Math.min(a,b ));

        }

        return min==Integer.MAX_VALUE?0:min;
    }

    public static int findMaxInLeft(TreeNode node,int max){
        if(node!=null){
            if(node.val>max){
                max=node.val;
            }
            int a=findMaxInLeft(node.left, max);
            int b=findMaxInLeft(node.right, max);
            max=Math.max(max,Math.max(a,b ));
        }

        return max==Integer.MIN_VALUE?0:max;
    }
    public static int findMinInRight(TreeNode node,int min){
        if(node!=null){
            if(node.val<min){
                min=node.val;
            }
            int a=findMinInRight(node.left, min);
            int b=findMinInRight(node.right, min);
            min=Math.min(min,Math.min(a,b ));
        }

        return min==Integer.MAX_VALUE?0:min;
    }

    public static int findMaxInRight(TreeNode node,int max){
        if(node!=null){
            if(node.val>max){
                max=node.val;
            }
            int a=findMaxInRight(node.left, max);
            int b=findMaxInRight(node.right, max);

            max=Math.max(max,Math.max(a,b));
        }

        return max==Integer.MIN_VALUE?0:max;
    }
    public static void main(String[] args) {
       int[] arr = new int[]{21, 7, 14, 1, 1, 2, 2, 3, 3};
        //int[] arr = new int[]{8,3,10,1,6,14,4,7,13};
        TreeNode root = new TreeNode();
        root = insertLevelOrder(arr, root, 0);


        System.out.println(maxAncestorDiff(root));


    }

}