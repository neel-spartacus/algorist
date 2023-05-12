package com.scaler.queues;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

    public static String solve(String A) {
        Map<String,Integer> freqMap= new HashMap<>();
        String[] strArr=A.split("");
        Queue<String> queue= new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
      /*  freqMap = A.chars().mapToObj(c -> Character.toString((char) c))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));*/

        for(String str:strArr){
            if(freqMap.containsKey(str)){
                int val=freqMap.get(str);
                freqMap.put(str,val+1);
            }
            else{
                freqMap.put(str,1);
            }
            if(freqMap.get(str)==1){
                queue.add(str);
                sb.append(queue.peek());
            }
            else if (freqMap.get(str)>1){
                if(str.equals(queue.peek())){
                    queue.poll();
                }
                if(queue.isEmpty()){
                    sb.append("#");
                }else{
                    String item=queue.peek();
                    while (item!=null && !queue.isEmpty()&&freqMap.get(item)>1){
                        queue.poll();
                        item=queue.peek();
                    }
                    if(queue.peek()!=null){
                        sb.append(queue.peek());
                    }
                    else{
                        sb.append("#");
                    }
                }
            }

        }

        return sb.toString();
    }
    public static void main(String[] args) {

        //String A="iergxwhddh";
        String A="jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl";
        //String A="abadbc";
        System.out.println(solve(A));
    }
}
