package com.geeksforgeeks.me.dynamicprogramming.easy;

import sun.rmi.runtime.NewThreadAction;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReturnValuesWithPrefixOnly {

    public static void main(String[] args) {

        String[] names= new String[]{"Neel","Neelanjit","NeelKanth"};

        System.out.println("List of names before operation");
        printNames(names);

        String[] namesWithPrefix=withPrefixOnly(names, "Neel");

        System.out.println("List of names after operation");
        printNames(namesWithPrefix);

    }


    public static void printNames(String[] names){
        for (String name:names
             ) {
            System.out.println(name);

        }
    }
    public static String[] withPrefixOnly(String[] array,String prefix){

        List<String> names= new ArrayList<>();

        for(int i=0;i<array.length;i++){
            if(array[i].startsWith(prefix) && !array[i].equals(prefix)){
                names.add(array[i]);
            }
            else {
                continue;
            }
        }

        String[] values = new String[names.size()];
        values = names.toArray(values);
        return values;
    }
}
