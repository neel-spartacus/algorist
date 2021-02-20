package com.geeksforgeeks.me.dynamicprogramming.easy.linkedlistops;

public class DeleteNodeLessThanGiven {

    public static void main(String[] args) {

      Node head=createNode(11);
      head.next=createNode(11);
      head.next.next=createNode(15);
      head.next.next.next=createNode(11);
      head.next.next.next.next=createNode(5);
      head.next.next.next.next.next=createNode(6);

      int deleteNodeValue=10;

      System.out.println("Intial list before deletion of any node");
      printNodes(head);

       Node headNode=deleteNodeLesserThan(head, deleteNodeValue);

      System.out.println("List after deletion");
      printNodes(headNode);


    }


    public static Node deleteNodeLesserThan(Node head,int k){

        Node temp=head;
        Node previous=null;

        while(temp!=null && temp.value>k){
               head=temp.next;
               temp=head;
        }

        while(temp!=null){

            while (temp!=null && temp.value <=k){
                   previous=temp;
                   temp=temp.next;
            }
            if(temp==null){
                return head;
            }
            else{
                previous.next=temp.next;
                temp=previous.next;

            }
        }

        return head;
    }

    public static void printNodes(Node node){
        while (node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }

    static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

        public static Node createNode(int value){
            Node node= new Node(value);
            node.next=null;
            return node;
        }
    }
