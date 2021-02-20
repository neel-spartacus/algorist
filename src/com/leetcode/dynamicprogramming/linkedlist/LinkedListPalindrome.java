package com.leetcode.dynamicprogramming.linkedlist;

public class LinkedListPalindrome {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            ListNode temp = head;
            int len = 0;

            while (temp != null) {
                len++;
                temp = temp.next;
            }
            int[] arr = new int[len];
            temp = head;
            for (int i = 0; i < len && temp != null; i++) {
                arr[i] = temp.val;
                temp = temp.next;
            }

            ListNode reverseHead = reverseLinkList(head);
            boolean isPalindrome = false;
            for (int k = 0; k < len && reverseHead != null; k++) {
                if (reverseHead.val != arr[k]) {
                     isPalindrome=false;
                     break;
                } else {
                    isPalindrome = true;
                }
                reverseHead = reverseHead.next;
            }
            return isPalindrome;


        }

        private ListNode reverseLinkList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode prev = null;
            ListNode curr = head;
            while (curr.next != null) {
                ListNode temp = curr;
                curr = curr.next;
                temp.next = prev;
                prev = temp;
            }
            curr.next = prev;
            head = curr;
            return head;
        }


    public static void main(String[] args) {

        LinkedListPalindrome l = new LinkedListPalindrome();
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(2);
        headA.next.next.next = new ListNode(1);
       // headA.next.next.next.next = new ListNode(5);
        System.out.println(l.isPalindrome(headA));
    }
}
