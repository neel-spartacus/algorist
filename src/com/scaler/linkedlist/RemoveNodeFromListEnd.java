package com.scaler.linkedlist;


import java.util.List;

public class RemoveNodeFromListEnd {

 static class ListNode {
  public int val;
  public ListNode next;
  ListNode(int x) { val = x; next = null; }
 }

 public static ListNode removeNthFromEnd(ListNode A, int B) {

    int len=0;
    ListNode temp=A;
    ListNode prev=null;
    while (temp!=null){
     len++;
     temp=temp.next;
    }

    if(B>=len){
      A=A.next;
    }
    else {

     int remove=len-B+1;

     temp=A;
     while (remove>1){
      prev=temp;
      temp=temp.next;
      remove--;
     }
     prev.next=temp.next;


    }
     return A;
 }

    public static void main(String[] args) {
        ListNode node= new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        System.out.println(removeNthFromEnd(node,2));
    }

}
