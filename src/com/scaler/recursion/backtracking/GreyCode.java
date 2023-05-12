package com.scaler.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GreyCode {


    public static ArrayList<Integer> grayCode(int a) {

        ArrayList<Integer> grayCodes=new ArrayList<>();
        ArrayList<String> stringCodes= helper(a);
        for(String code:stringCodes){
            grayCodes.add(binaryToDecimal(code));
        }
        return grayCodes;
    }



    public static ArrayList<String> helper(int value){

        if(value==1){
            ArrayList<String> baseList=new ArrayList<>();
            baseList.add("0");
            baseList.add("1");
            return baseList;
        }
        ArrayList<String> values=helper(value-1);
        ArrayList<String> stringCodes=new ArrayList<>();
        for(String v:values){
            stringCodes.add("0"+v);
        }
        for(int i=values.size();i-->0;){
            stringCodes.add(("1"+(values.get(i))));
        }

        return stringCodes;
    }


    public static int binaryToDecimal(String n)
    {
        String num = n;
        int dec_value = 0;

        // Initializing base value to 1,
        // i.e 2^0
        int base = 1;

        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            if (num.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }

        return dec_value;
    }

    public static void main(String[] args) {

        int a=3;
        System.out.println(grayCode(a));
    }
}
