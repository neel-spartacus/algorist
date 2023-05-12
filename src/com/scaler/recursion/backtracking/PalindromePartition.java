package com.scaler.recursion.backtracking;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromePartition {

    public static ArrayList<ArrayList<String>> partition(String a) {

        int len=a.length();
        String[] str=a.split("");
        ArrayList<ArrayList<String>> finaList= new ArrayList<>();
        ArrayList<String> palindromeList=new ArrayList<>();
        helper(str,a,str.length,0,palindromeList,finaList);
        return finaList;

    }

    public static void helper(String[] str,String s,int size,int index,ArrayList<String> palindromeList, ArrayList<ArrayList<String>> finaList){

        if (index== size){
             finaList.add(new ArrayList<>(palindromeList));
             return;
        }


        for(int i=index;i<size;i++){
            if(isPalindrome(str,index,i)){
                palindromeList.add(s.substring(index,i+1));
                helper(str,s,size,i+1,palindromeList,finaList);
                palindromeList.remove(palindromeList.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String[] str,int i,int j) {
        while (i<j){
            if(str[i].equals(str[j])){
                ++i;
                --j;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String str="aab";
        ArrayList<ArrayList<String>> results=partition(str);
        System.out.println(Arrays.toString(results.toArray()));

    }
}
