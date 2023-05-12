package com.leetcode.recursion;

import com.sun.xml.internal.messaging.saaj.util.TeeInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullBinaryTree {

    public static class TreeNode {
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

    public static List<TreeNode> allPossibleFBT(int n) {

        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        n = n - 1;
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i);
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = nl;
                    cur.right = nr;
                    res.add(cur);
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {

        int n=7;

        List<TreeNode> nodes=allPossibleFBT(n);
        System.out.println(Arrays.toString(nodes.toArray()));
    }
}
