package com.leetcode.recursion;


// Problem : https://leetcode.com/problems/swap-nodes-in-pairs/

public class SwapNodesInPairs {

     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  
  public static ListNode swapPairs(ListNode head) {

         if(head==null){
             return null;
         }
         if(head.next==null){
             return head;
         }

         ListNode temp=head.next;
         head.next=head.next.next;
         temp.next=head;

         temp.next.next= temp.next.next!=null?swapPairs(temp.next.next):null;

         return temp;

      }

      public static void main(String[] args) {

         ListNode head= new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));

         head=swapPairs(head);

         System.out.print(head.val);
    }
}
