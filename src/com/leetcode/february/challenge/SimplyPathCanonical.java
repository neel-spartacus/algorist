package com.leetcode.february.challenge;

import java.util.Stack;

public class SimplyPathCanonical {

    public static String simplifyPath(String path) {


        StringBuilder sb = new StringBuilder();

        try{

            int length=path.length();
            if(length<1 || length>3000){
                throw new RuntimeException();
            }
            String[] strarr=path.split("/");

            for(String str:strarr){
                if(!(str.equals(".") || str.equals("..") || str.matches("[..]*[a-zA-Z][0-9]+")  || str.equals("...") || str.equals("/") || str.equals("") || str.equals("_") || str.matches("[a-zA-Z]+") )){
                    throw new RuntimeException();
                }
            }

            Stack<String> pathValues= new Stack<String>();



            for(String str:strarr){
              /*  if(str.equals("")){
                    if(pathValues.isEmpty()){
                        pathValues.push("/");
                    }
                    else if(pathValues.peek().equals("/")) {
                        continue;
                    }
                   *//* else {
                        pathValues.push("/");
                    }*//*
                }*/
                if(str.equals("/") && pathValues.isEmpty()){
                    pathValues.push("/");
                }
                if(str.equals("//") && !pathValues.isEmpty()){
                    if(pathValues.peek().equals("/")){
                        continue;
                    }

                }
                if(str.matches("..*[a-zA-Z][0-9]+") || str.equals("...")){
                    pathValues.push("/" +str);
                }

                if(str.matches("..") && !pathValues.isEmpty()){
                    if(pathValues.size()==1 && pathValues.peek().equals("/")){
                        continue;
                    }
                    else{
                        pathValues.pop();
                    }

                }
            }

            if(pathValues.isEmpty()){
                return "/";
            }
            else {
                String[] arr=new String[pathValues.size()];

                int i=0;
                while (!pathValues.isEmpty() && i<arr.length){

                    arr[i]=pathValues.pop();
                    i++;
                }

                for(int j=arr.length-1;j>=0;j--){
                    if(j==0 && arr.length>1 && arr[j].equals("/")){
                        continue;
                    }
                    sb.append(arr[j]);
                }


            }
        } catch (Exception ex){
            System.out.println("Invalid input" + ex.getMessage());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        //String s="/a/../../b/../c//.//";
        //String s="/../../../../../a";
        String s="/..hidden";
        //String s="/a//b////c/d//././/..";
        System.out.println(simplifyPath(s));
    }
}
