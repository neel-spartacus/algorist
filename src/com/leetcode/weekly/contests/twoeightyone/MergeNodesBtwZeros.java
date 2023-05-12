package com.leetcode.weekly.contests.twoeightyone;

public class MergeNodesBtwZeros {

     public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

  public static ListNode mergeNodes(ListNode head) {

         int sum=0;
         ListNode dummy=new ListNode();
         ListNode temp=dummy;
         ListNode pointer=head;
         while (pointer.next!=null){
             if(pointer.next.val!=0){
                 sum+=pointer.next.val;
             }else{
                 temp.next=new ListNode(sum);
                 sum=0;
                 temp=temp.next;
             }
              pointer=pointer.next;

         }
          return dummy.next;
     }

     public static void main(String[] args) {
         ListNode head= new ListNode(0);
         head.next=new ListNode(1);
         head.next.next=new ListNode(0);
         head.next.next.next=new ListNode(3);
         head.next.next.next.next=new ListNode(0);
         head.next.next.next.next.next=new ListNode(2);
         head.next.next.next.next.next.next=new ListNode(2);
         head.next.next.next.next.next.next.next=new ListNode(0);

         head=mergeNodes(head);

    }
}
