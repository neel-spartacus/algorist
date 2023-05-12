package com.leetcode.weekly.contests.twoeightyone;

import com.cousera.datastructues.week1.graphs.Dijkstra;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class RepeatLimitedString {

    static class Node{
        private char key;
        private int value;

        public Node(char key, int value) {
            this.key = key;
            this.value = value;
        }

        public char getKey() {
            return key;
        }

        public void setKey(char key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }



    }

    public static String repeatLimitedString(String s, int repeatLimit) {

        int[] count= new int[256];
        Set<Character> charSet=new HashSet<>();
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'0']++;
            charSet.add(s.charAt(i));
        }

        PriorityQueue<Node> priorityQueue= new PriorityQueue<>(Comparator.comparing(Node::getKey,Comparator.reverseOrder()));

        for(Character c:charSet){
            Node node= new Node(c.charValue(),count[c.charValue()-'0']);
            priorityQueue.add(node);
        }
      /*  for(int i=0;i<charSet.size();i++){
            Node node= new Node(charSet.,count[s.charAt(i)-'0']);
            priorityQueue.add(node);
        }*/
        StringBuilder sb= new StringBuilder();
        while (!priorityQueue.isEmpty()){

            Node node1=priorityQueue.poll();
            char char1= node1.getKey();
            int repeat= node1.getValue();

            if(sb.length()==0 || sb.charAt(sb.length()-1)!=char1){

                for(int i=1;i<=repeatLimit && repeat>0;i++){
                    sb.append(char1);
                    repeat--;
                }
                if(repeat>0){
                    node1.setValue(repeat);
                    priorityQueue.add(node1);
                }


            }else{

                if(!priorityQueue.isEmpty()){
                    Node node2=priorityQueue.poll();
                    char char2= node2.getKey();
                    int repeat2= node2.getValue();

                    sb.append(char2);
                    repeat2--;
                    if(repeat2>0){
                        node2.setValue(repeat2);
                        priorityQueue.add(node2);
                    }
                    priorityQueue.add(node1);
                }

            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(repeatLimitedString("cczazcc",3));
        //System.out.println(repeatLimitedString("aababab",2));
    }
}
