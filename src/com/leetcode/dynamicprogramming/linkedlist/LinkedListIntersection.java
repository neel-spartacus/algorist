package com.leetcode.dynamicprogramming.linkedlist;

public class LinkedListIntersection {

      //Definition for singly-linked list.
      public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
              val = x;
              next = null;
          }
      }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode reverseHeadA=headA;
            ListNode reverseHeadB=headB;
            if(headA==null || headB==null){
                return null;
            }

            if(headA.next!=null){
                reverseHeadA=reverseLinkList(headA);
                ListNode tmp=reverseHeadA;
                while(tmp!=null){
                    System.out.println(tmp.val);
                    tmp=tmp.next;

                }
            }
/*            System.out.println("------------------------------");
            if(headB.next!=null){
                reverseHeadB=reverseLinkList(headB);
                ListNode tmp=reverseHeadB;
                while(tmp!=null){
                    System.out.println(tmp.val);
                    tmp=tmp.next;
                }
            }*/

            while(reverseHeadA!=null && headB!=null){
                if(reverseHeadA==headB){
                    return headB;
                }
                reverseHeadA=reverseHeadA.next;
                headB=headB.next;
            }
            return null;
        }

        private ListNode reverseLinkList(ListNode head){

            if(head==null){
                return null;
            }
            ListNode prev=null;
            ListNode curr=head;
            while(curr.next!=null){
                ListNode temp=curr;
                curr=curr.next;
                temp.next=prev;
                prev=temp;
            }
            curr.next=prev;
            head=curr;

            return head;
        }

    public static void main(String[] args) {

          LinkedListIntersection l = new LinkedListIntersection();
        ListNode headA= new ListNode(4);
        headA.next=new ListNode(1);
        headA.next.next=new ListNode(8);
        headA.next.next.next=new ListNode(4);
        headA.next.next.next.next=new ListNode(5);

        ListNode headB= new ListNode(5);
        headB.next=new ListNode(0);
        headB.next.next=new ListNode(1);
        headB.next.next.next=new ListNode(8);
        headB.next.next.next.next=new ListNode(4);
        headB.next.next.next.next.next=new ListNode(5);

        ListNode intersection=l.getIntersectionNode(headA, headB);
        System.out.println(intersection.val);
    }


    }

