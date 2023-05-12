package com.tleeliminators.prefixsum.backtracking;


//https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;

public class HappyString {

    public static String getHappyString(int n, int k) {

        String[] str={"a","b","c"};
        List<String> happyStrings= new ArrayList<>();

        helper(str,0,n, happyStrings,"");


        return happyStrings.size()>=k?happyStrings.get(k-1):"";
    }

public static void helper(String[] arr,int index,int n,List<String> happyStr,String curr){



        if(curr.length()==n){
          happyStr.add(curr);
          return;
        }
        for(int i=index;i<arr.length;i++){
         if(curr.length()==0 || !String.valueOf(curr.charAt(curr.length()-1)).equalsIgnoreCase(arr[i])){
                String temp=curr;
                curr+=arr[i];
                helper(arr,index+1,n, happyStr,curr );
                curr=temp;
            }
            else{
                continue;
            }



        }

}

    public static void main(String[] args) {
        int n=3,k=9;
        System.out.println(getHappyString(n, k));

    }
}
