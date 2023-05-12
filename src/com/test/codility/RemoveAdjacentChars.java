package com.test.codility;

import java.nio.charset.StandardCharsets;

public class RemoveAdjacentChars {

    public static String solve(String s){

        if(s.length()==0){
            return "";
        }

        int i=0,j=i+1;
        while(s.length()>1 && j<s.length())
        {
            StringBuilder ans=new StringBuilder();
                if((s.charAt(i)=='A' && s.charAt(j)=='B')|| (s.charAt(i)=='B' && s.charAt(j)=='A')){
                    if(i-1<0){
                        if(s.length()==2) {
                            ans.append("");
                        }else{
                            ans.append(s.substring(j,s.length()));
                        }

                    }
                    else if(j+1>s.length()-1){
                        if(s.length()==2) {
                            ans.append("");
                        }
                        else{
                            ans.append(s.substring(0,i));
                        }

                    }
                    else {
                        ans.append(s.substring(0,i)).append(s.substring(j+1,s.length()));

                    }
                    i=0;
                    j=i+1;
                }
                else if((s.charAt(i)=='C' && s.charAt(j)=='D')|| (s.charAt(i)=='D' && s.charAt(j)=='C')){
                    if(i-1<0){
                        if(s.length()==2) {
                            ans.append("");
                        }else{
                            ans.append(s.substring(j,s.length()));
                        }
                    }
                    else if(j+1>s.length()-1){
                        if(s.length()==2){
                            ans.append("");
                        }
                        else{
                            ans.append(s.substring(0,i));
                        }

                    }
                    else {
                        ans.append(s.substring(0,i)).append(s.substring(j+1,s.length()));
                    }
                    i=0;
                    j=i+1;
                }
                else{
                    i++;
                    j++;
                }
                if(s.length()==2 && ans.toString().equalsIgnoreCase("")){
                    s=ans.toString();
                }
                else{
                    s=ans.toString().length()>0 ?ans.toString():s;
                }

        }

        return s;
    }

    public static String solve2(String s){

        StringBuilder sb = new StringBuilder();
        s=removeDirtyChars(s,"AB");
        s=removeDirtyChars(s,"BA");
        s=removeDirtyChars(s,"CD");
        s=removeDirtyChars(s,"DC");

        return s;


    }


    static final int NO_OF_CHARS = 256;
    static int[] getCharCountArray(String str)
    {
        int count[] = new int[NO_OF_CHARS];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;

        return count;
    }


   public static String removeDirtyChars(String str,
                                   String mask_str)
    {
        int count[] = getCharCountArray(mask_str);
        int ip_ind = 0, res_ind = 0;

        char arr[] = str.toCharArray();

        while (ip_ind != arr.length)
        {
            char temp = arr[ip_ind];
            if (count[temp] == 0) {
                arr[res_ind] = arr[ip_ind];
                res_ind++;
            }
            ip_ind++;
        }

        str = new String(arr);

        /* After above step string is ngring.
        Removing extra "iittg" after string*/

        return str.substring(0, res_ind);
    }

    public static void main(String[] args) {

        //String s="CBACD";
        //String s="CABABD";
        String s="ACBDACBD";
        System.out.println(solve(s));
    }
}
