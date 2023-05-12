package com.test.codility;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static int solution(String s) {

        int max=Integer.MIN_VALUE;
        char[] chars= s.toCharArray();

        int l= chars.length;

        for(int i=0;i+1<l;i++){
            int tens=(chars[i]-'0')*10;
            int ones=chars[i+1]-'0';

            max=Math.max(max,tens+ones);

        }

        return max;
    }

    public static void main(String[] args) {

        String s="88";
        System.out.println(solution(s));

    }
}
