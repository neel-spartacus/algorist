package com.leetcode.dynamicprogramming.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class LeetCode239 {

    public static int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        //int  K = 3;
        int  K = 5;
        //int [] arr={1,-1};
        int[] arr = {9,10,9,-7,-4,-8,2,-6};
        //int[] arr = {1,3,-1,-3,5,3,6,7};

        int[] maxSubarray=maxSlidingWindow(arr, K);

        System.out.println(Arrays.toString(maxSubarray));


    }
}
