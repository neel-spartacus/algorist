package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodilityDemo2 {


    public static int solution(String S) {


        List<Integer> list = new ArrayList<>();
        try {

            char[] chars = S.toCharArray();
            int len = chars.length;
            if (chars[0] - '0' == 0) {
                throw new RuntimeException();
            }
            for (int k = 0; k < len; k++) {

                if (!(S.charAt(k) >= '0'
                        && S.charAt(k) <= '9')) {
                    throw new RuntimeException();
                }


                for (int i = 0; i < len - 1; i++) {
                    list.add(Integer.parseInt(Character.toString(chars[i]) + Character.toString(chars[i + 1])));

                }

                if (list.size()<2&& list.size()>200) {
                    throw new RuntimeException();
                }

            }

        } catch (Exception ex) {
            System.out.println("Invalid input" + ex.getMessage());

        }
        return Collections.max(list);

    }

    public static void main (String[]args){

        String s = "50552";
        System.out.println(solution(s));
    }
}
