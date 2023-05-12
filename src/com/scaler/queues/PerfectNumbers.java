package com.scaler.queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PerfectNumbers {

    public static String solve(int A) {

        Queue<Long> queue=new ArrayDeque<>();
        ArrayList<Long> list= new ArrayList<>();
        queue.add(1L);
        queue.add(2L);
        list.add(1L);
        list.add(2L);

        for(int i=2;i<A;i++){
            long item=queue.poll();
            long elem1=(item*10)+1;
            long elem2=(item*10)+2;
            queue.add(elem1);
            queue.add(elem2);
            list.add(elem1);
            list.add(elem2);
        }
    return list.get(A - 1) +String.valueOf(reverseNumber(list.get(A-1)));
    }

    public static long reverseNumber(long num){
        long reverse=0;

        while(num!=0){
            long r=num%10;
            reverse= reverse *10+r;
            num=num/10;
        }
        return reverse;
    }
    public static void main(String[] args) {
        int A=100000;
        System.out.println(solve(A));
    }
}
