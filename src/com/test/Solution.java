package com.test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {


    public List<String> orderedJunctionBoxes(int noOfBox,List<String> boxList){


        List<String> olddBoxes= new ArrayList<>();
        List<String> newdBoxes= new ArrayList<>();

        for(int k=0;k<noOfBox;k++){
            String box=boxList.get(k);
            String[] boxValues=box.split(" ");
            if(null!=boxValues && boxValues.length>1){
                    if(StringUtils.isNumeric(boxValues[1])){
                        newdBoxes.add(box);
                    }
                    else{
                        olddBoxes.add(box);
                    }
            }
        }

     List<String> oldList=olddBoxes.stream().filter(box->
     {
             String[] boxes=box.split(" ");
             return !StringUtils.isNumeric(boxes[0]);
     }).collect(Collectors.toList());

        List<String> newList=olddBoxes.stream().filter(box->
        {
            String[] boxes=box.split(" ");
            return StringUtils.isNumeric(boxes[0]);
        }).collect(Collectors.toList());

        Collections.sort(oldList)
        ;

        newList.addAll(oldList);

        newList.addAll(newdBoxes);

        return newList;
    }

    public List<String> compareString(List<String> boxes){

        int len=boxes.size();
        for(int i = 0; i < len; ++i) {
            for (int j = i + 1; j < 4; ++j) {
                if (boxes.get(i).compareTo(boxes.get(j)) > 0) {
                    // swap words[i] with words[j[
                    String temp = boxes.get(i);
                    boxes.set(i, boxes.get(j));
                    boxes.set(j, temp);
                }
            }
        }
        return boxes;
    }
    public static void main(String[] args) {

        int n=5;
        List<String> lists=new ArrayList<>();
        lists.add("yklc 82 01");
        lists.add("eo first qpx");
        lists.add("09z cat hamster");
        lists.add("06f 12 25 6");
        lists.add("234 cat dog rabbit");
        Solution solution =  new Solution();

        List<String> v=solution.orderedJunctionBoxes(n,lists );
        for( String a:v){
            System.out.println(a);
        }


    }
}
