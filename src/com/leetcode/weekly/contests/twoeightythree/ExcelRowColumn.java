package com.leetcode.weekly.contests.twoeightythree;

import java.util.ArrayList;
import java.util.List;

public class ExcelRowColumn {

    public static List<String> cellsInRange(String s) {

        String[] strs=s.split(":");

        char[] firstRowColumn=strs[0].toCharArray();
        char[] secondRowColumn=strs[1].toCharArray();

        int firstRowVal=firstRowColumn[0]-'0';
        int firstColVal=Integer.parseInt(String.valueOf(firstRowColumn[1]));
        int secRowVal=secondRowColumn[0]-'0';
        int secCowVal=Integer.parseInt(String.valueOf(secondRowColumn[1]));

        List<String> cells=new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=firstRowVal;i<=secRowVal;i++){

            int start=firstColVal;
            while (start<=secCowVal){

                cells.add(String.valueOf((char) (i+'0'))+start);
                   start++;
            }
            start=firstColVal;
        }

return cells;

    }

    public static void main(String[] args) {

       // String s="K1:L2";
        String s="A1:F1";
        List<String> cellsInString=cellsInRange(s);
        System.out.println(cellsInString);
    }
}
