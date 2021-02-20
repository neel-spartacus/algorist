package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

import java.util.*;

public class CodilityDemo3 {


    public static int solution(String S) {

        int sum = 0;
        try {
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = S.toCharArray();
            int len = chars.length;

            if (len < 0 || len > 300000) {
                throw new RuntimeException();
            }
            for (int k = 0; k < len; k++) {

                if (!(S.charAt(k) >= 'a'
                        && S.charAt(k) <= 'z')) {
                    throw new RuntimeException();
                }
            }
                for (int i = 0; i < len; i++) {

                    if (map.containsKey(chars[i])) {
                        int value = map.get(chars[i]);
                        map.put(chars[i], value + 1);
                    } else {
                        map.put(chars[i], 1);
                    }
                }

                final Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
                final HashSet<Integer> valueSet = new HashSet<Integer>();


                if (map.size() == 1) {
                    return 0;
                }
                if (map.values().stream().distinct().limit(2).count() < 2) {
                    int size = map.size();
                    while (size > 1) {
                        sum += size - 1;
                        size--;
                    }
                    return sum;
                }

                while (iter.hasNext()) {
                    final Map.Entry<Character, Integer> next = iter.next();
                    if (!valueSet.add(next.getValue())) {
                        sum += next.getValue();
                        //iter.remove();
                    }
                }
        }

        catch(Exception ex){
            System.out.println("Invalid input" + ex.getMessage());

        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "ccaaffddecee";
        System.out.println(solution(s));
    }

}