package com.test;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class Test {

    //Given a string with repeated characters and a distance d.
    //Return the string in which all the repeated characters becomes d distance apart.
    //Exmapl:-s=abb,d=2,bab
    //aabbc,d=2,ababac

    public static void main(String[] args) {

        String a="abb";
        int distance=2;

        String returnesSring=find(a,distance);
        System.out.println(returnesSring);
    }

    private static String find(String a,int d) {
        char[] chars=a.toCharArray();
        //int[] freq= new int[chars.length];
        Map<Character,Integer> charFreq=new HashMap<>();
        for(int i=0;i<chars.length;i++){
            char c=chars[i];
            int initialdis=0;
            for (char cc='a';cc<='z';++cc) {
                int dis = (cc - c);
                if (dis <= d && dis > initialdis) {
                    initialdis = dis;
                    c = cc;
                }
            }
            d=d-initialdis;
            chars[i]=c;
            }
            return (new String(chars));
        }
    }

