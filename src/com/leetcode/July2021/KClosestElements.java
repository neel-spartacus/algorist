package com.leetcode.July2021;

import javax.swing.*;
import java.util.*;

public class KClosestElements {

    static class Node{
        int element;
        int absDiff;

        public Node() {}

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public int getAbsDiff() {
            return absDiff;
        }

        public void setAbsDiff(int absDiff) {
            this.absDiff = absDiff;
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n=arr.length;
       List<Integer> closestElements= new ArrayList<>();

        PriorityQueue<Node> queue= new PriorityQueue<>(Comparator.comparing(Node::getAbsDiff).thenComparing(Node::getElement));
        for(int i=0;i<n;i++){
            Node node= new Node();
            node.setElement(arr[i]);
            node.setAbsDiff(Math.abs(arr[i]-x));
            queue.add(node);
        }

       while (k!=0){
           Node node=queue.poll();
           closestElements.add(node.getElement());
           k--;
       }

       Collections.sort(closestElements);

       return closestElements;

    }

    public static void main(String[] args) {

        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        int k = 3, x = 5;

        System.out.println(findClosestElements(arr, k, x));
    }
}
