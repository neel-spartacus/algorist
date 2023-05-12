package com.test;

import com.cousera.datastructues.week1.TreeHeightCalculate;

public class SuperStackHackerRank {

   public static class SuperStack{
        public class Node{
            int value;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        Node head;
       public SuperStack() {
           this.head=null;
       }

       public String push(int val){

           Node temp = new Node(val);
           if(head==null){
               head=temp;
               head.next=null;
           }
           else{
               temp.next=head;
               head=temp;
           }
           return String.valueOf(head.value);
        }

        public String pop(){
           head=head.next;
           if(head==null){
               return "EMPTY";
           }
           else{
               return String.valueOf(head.value);
           }
        }

        public String inc(int range,int valueAdd){

           Node temp=head;
           int traversalSize=size()-range;
           while (traversalSize!=0){
                    temp=temp.next;
                    traversalSize--;
           }
           while (temp!=null){
               int val=temp.value;
               val+=valueAdd;
               temp.value=val;
               temp=temp.next;
           }

           if(head==null){
               return "EMPTY";
           }
           else{
               return String.valueOf(head.value);
           }


        }

       public int size()
       {
           Node temp = head;
           int size = 0;
           while(temp != null)
           {
               size += 1;
               temp = temp.next;
           }
           return size;
       }
    }

    public static void superStack(String[] operations){
       int len=operations.length;

       SuperStack superStack= new SuperStack();
       StringBuilder sb = new StringBuilder();
       for(int i=0;i<len;i++){
           String operation=operations[i];
           if(operation.startsWith("push")){
               String[] values=operation.split(" ");
               sb.append(superStack.push(Integer.parseInt(values[1])));
               sb.append(System.lineSeparator());
           }
           else if(operation.equalsIgnoreCase("pop")){
               sb.append(superStack.pop());
               sb.append(System.lineSeparator());
           }
           else {
               String[] operationValues=operation.split(" ");
               sb.append(superStack.inc(Integer.parseInt(operationValues[1]),Integer.parseInt(operationValues[2])));
               sb.append(System.lineSeparator());
           }
       }

       System.out.println(sb);
    }

    public static void main(String[] args) {

       //String[] operations={"push 4","push 5","inc 2 1","pop","pop"};
       String[] operations={"push 4", "pop", "push 3", "push 5", "push 2", "inc 3 1", "pop", "push 1", "inc 2 2", "push 4", "pop", "pop"};
       superStack(operations);

    }


}
