package com.leetcode.dynamicprogramming.easy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode119 {

    public static List<Integer> getRow(int rowIndex) {

        List<List<Integer>> values= new ArrayList<>();

        values.add(Arrays.asList(1));

        for(int i=1;i<rowIndex+1;i++){
            List<Integer> row= new ArrayList<>();
            List<Integer> prev= values.get(i-1);

            row.add(1);


            for(int j=1;j<i;j++){
                row.add(prev.get(j-1)+prev.get(j));
            }

            row.add(1);

            values.add(row);
        }

        return values.get(rowIndex);
    }


    public static void main(String[] args) {
        int rowIndex=3;
        System.out.println(getRow(3));
    }
}
