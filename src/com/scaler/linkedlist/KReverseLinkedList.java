package com.scaler.linkedlist;

import java.util.List;

public class KReverseLinkedList {

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public static ListNode reverseList(ListNode A, int B) {

        ListNode curr=A;
        ListNode temp=A;

        int len=0;
        while (temp!=null){
            len++;
            temp=temp.next;
        }

        int iterations=len/B;

        temp=A;
        ListNode head=A;
        for(int i=0;i<iterations;i++){
            int count=B;

            while (temp!=null && count>0){
                temp=temp.next;
                count--;
            }
            ListNode plcHld=null;
            if(temp!=null){
                plcHld=temp;
            }

           reversePartialList(head,B);
            //prev=curr;

            count=B;
            while (count>0){
                head=head.next;
                count--;
            }

        }

        return A;

    }

    private static void reversePartialList(ListNode start,int size) {

        ListNode prev=null;
        ListNode curr=start;
        ListNode next=start.next;

        while(curr.next!=null && size>0){
            curr.next=prev;
            prev=curr;
            curr=next;
            next=next.next;
            size--;
        }
        start=prev;
        while (prev.next!=null){
            prev=prev.next;
        }
        prev.next=curr;
        curr=start;


    }

    public static void main(String[] args) {
        ListNode node= new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        node.next.next.next.next.next=new ListNode(6);
        System.out.println(reverseList(node,2));
    }
}
