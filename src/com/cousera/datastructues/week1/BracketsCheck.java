package com.cousera.datastructues.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BracketsCheck {

   public static class Bracket {
        Bracket(char type, int position) {
            this.type = type;
            this.position = position;
        }

        boolean Match(char c) {
            if (this.type == '[' && c == ']')
                return true;
            if (this.type == '{' && c == '}')
                return true;
            if (this.type == '(' && c == ')')
                return true;
            return false;
        }

        char type;
        int position;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Integer checkposition=null;
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {

                Bracket openbracket= new Bracket(next, position);
                opening_brackets_stack.push(openbracket);
                continue;
                // Process opening bracket, write your code here
            }

            if (next == ')' || next == ']' || next == '}') {

                if(opening_brackets_stack.isEmpty()){
                    checkposition=position+1;
                    break;
                }
                Bracket top=opening_brackets_stack.pop();
                if(top.type!='(' && next==')' || top.type!='[' && next==']' || top.type!='{' && next=='}'){

                    checkposition=position+1;
                    break;


                }
                if(top.type=='(' && next!=')' || top.type=='[' && next!=']' || top.type=='{' && next!='}'){

                    checkposition=top.position+1;
                    break;


                }
                // Process closing bracket, write your code here
            }
        }

        if(checkposition!=null){
            System.out.println(checkposition.intValue());
        }
         else if(opening_brackets_stack.isEmpty()){
            System.out.println("Success");
        }
        else {
            Bracket pop=opening_brackets_stack.pop();
            System.out.println(pop.position+1);
        }


        // Printing answer, write your code here
    }
}
