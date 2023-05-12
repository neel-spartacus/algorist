package com.test.elinvar;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {

    public static int solution(String S) {
        Map<String,Integer> map= new HashMap<>();
        String[] chars=S.split("");
        for(String c: chars){
            if(map.containsKey(c)){
                Integer val=map.get(c);
                map.put(c,val+1);
            }
            else{
                map.put(c,1);
            }

        }
        String maxOccurence = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

      int count=0;

       for(String s: chars){
           if(!s.equalsIgnoreCase(maxOccurence)){
               count++;
           }
       }
    return count;
    }

    public static void main(String[] args) {
        //String str="^vv<v";
        //String str="v>>>vv";
        String str=">>>";
        System.out.println(solution(str));
    }
}
