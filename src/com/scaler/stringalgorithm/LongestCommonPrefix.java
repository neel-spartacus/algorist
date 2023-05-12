package com.scaler.stringalgorithm;

import com.cousera.datastructues.week1.graphs.Dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LongestCommonPrefix {

    static class Node{
        int index;
        int value;
        String s;

        public Node(){};
        public Node(int index, int value,String s) {
            this.index = index;
            this.value = value;
            this.s=s;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }
    }
    public static String longestCommonPrefix(String[] A) {

       char[] commonString=A[0].toCharArray();
       int maxIdx=commonString.length-1;

       for(int i=1;i<A.length;i++){
           char[] compareString=A[i].toCharArray();
           int j=0;
           while (j<=maxIdx && j<compareString.length && commonString[j]==compareString[j]){
               j++;
           }
           maxIdx=j-1;
       }

       StringBuilder str=new StringBuilder();
       for(int i=0;i<=maxIdx;i++){
           str.append(commonString[i]);
       }

       return str.toString();
    }

    private static String minimizeMaxPrefixLength(int[] zArr,String s) {
        int max=Integer.MAX_VALUE;
        int idx=-1;
       for(int i=0;i<zArr.length;i++){
           if(zArr[i]!=0 && zArr[i]<max){
               max=zArr[i];
               idx=i;
           }
       }
       return s.substring(idx,idx+max);

    }

    public static void main(String[] args) {

        //String[] A={"abcdefgh", "aefghijk", "abcefgh"};
        String[] A={"abcd", "abcd", "ab" };
        System.out.println(longestCommonPrefix(A));
    }
}
