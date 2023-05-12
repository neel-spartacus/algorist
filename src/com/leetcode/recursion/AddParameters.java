package com.leetcode.recursion;


// https://leetcode.com/problems/different-ways-to-add-parentheses/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddParameters {

    public static List<Integer> diffWaysToCompute(String expression) {

        List<Integer> computedValues= new ArrayList<>();
        int len=expression.length();

        for(int i=0;i<len;i++){
            if((expression.charAt(i)=='+') || (expression.charAt(i)=='-')|| (expression.charAt(i)=='*')){
                String part1=expression.substring(0,i);
                String part2=expression.substring(i+1);
                List<Integer> part1values=diffWaysToCompute(part1);
                List<Integer> part2values=diffWaysToCompute(part2);

                for(Integer value1:part1values){
                    for(Integer value2:part2values){
                        int value=0;
                        if(expression.charAt(i)=='+'){
                            value=value1+value2;
                        }else if(expression.charAt(i)=='-'){
                            value=value1-value2;
                        }else{
                            value=value1*value2;
                        }
                        computedValues.add(value);
                    }
                }

            }
        }
        if(computedValues.size()==0){
            if(!expression.isEmpty()){
                computedValues.add(Integer.valueOf(expression));
            }

        }

        return computedValues;



    }



    public static void main(String[] args) {

        String str= "2*3-4*5";
        //String str= "-1";
        System.out.println(Arrays.toString(diffWaysToCompute(str).toArray()));
    }
}
