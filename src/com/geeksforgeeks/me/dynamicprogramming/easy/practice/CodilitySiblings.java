package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

import java.util.Arrays;
import java.util.Collections;

public class CodilitySiblings {

    public static int solution(int N) {

        StringBuilder builder= new StringBuilder();
        try{
            if(N<0 || N>10000){
                throw new RuntimeException();
            }
            String tmp = Integer.toString(N);

            Integer[] value = new Integer[tmp.length()];
            for (int i = 0; i < value.length; i++)
            {
                value[i] = tmp.charAt(i) - '0';
            }

            Arrays.sort(value, Collections.reverseOrder());

            for(int v:value){
                builder.append(v);
            }

            return Integer.parseInt(builder.toString());
        }
        catch (Exception ex){
            System.out.println("Invalid input" + ex.getMessage());
        }

        return Integer.parseInt(builder.toString());
    }

    public static void main(String[] args) {

        int n=213;

        System.out.println(solution(n));
    }
}
