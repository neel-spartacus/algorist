package com.test.elinvar;


//https://leetcode.com/discuss/interview-question/1412603/Microsoft-or-online-assessment-or-filters-and-houses
public class Test3 {
    public static String solution(String s) {

        int length= s.length();
        int a=0,b=0;
        char ch[] = s.toCharArray();

        for(int i=0;i<length;++i){

            if(ch[i]!='?') {continue;}
            a=0;
            b=0;
            for(int j=i-1; j>=0 && j>=i-2;--j){
                if(ch[j]=='a')
                    a++;
                if(ch[j]=='b')
                    b++;
            }

            for(int j=i+1; j<length && j<=i+2;++j){
                if(ch[j]=='a')
                    a++;
                if(ch[j]=='b')
                    b++;
            }

            if(a==b || b>a)
                ch[i]='a';
            else
                ch[i]='b';


        }

        StringBuilder stringBuilder= new StringBuilder();
        for(char c:ch){
            stringBuilder.append(c);
        }
         return stringBuilder.toString();
    }


    public static void main(String[] args) {
        //String str="??abb";
        String str="a?b?aa";
        System.out.println(solution(str));
    }
}
