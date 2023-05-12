package com.scaler.stringalgorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseString {

    public static String solve(String A) {

        String[] str=A.split(" ");
        List<String> stringList=Arrays.stream(str).filter(s->!s.equals("")).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for(int i=stringList.size()-1;i>=0;i--){
            sb.append(stringList.get(i)).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {

        String A=" The sky    is   blue";
        System.out.println(solve(A));
    }
}
