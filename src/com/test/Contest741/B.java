package com.test.Contest741;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B {

    static int deleteFromEnd(long num, int n)
    {

        // Declare a variable
        // to form the reverse resultant number
        int rev_new_num = 0;

        // Loop with the number
        for (int i = 0; num != 0; i++) {

            int digit =(int) num % 10;
            num = num / 10;

            if (i == n) {
                continue;
            }
            else {

                rev_new_num = (rev_new_num * 10) + digit;
            }
        }

        // Declare a variable
        // to form the resultant number
        int new_num = 0;

        // Loop with the number
        for (int i = 0; rev_new_num != 0; i++) {

            new_num = (new_num * 10)
                    + (rev_new_num % 10);
            rev_new_num = rev_new_num / 10;
        }

        // Return the resultant number
        return new_num;
    }

    static boolean isPrime(long n)
    {

        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;

            // Check if number is 2
        else if (n == 2)
            return true;

            // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        int n=Integer.parseInt(s);

        for(int i = 0;i<n;i++){

            int count=0;
            long remainingNum=0;

            int k=Integer.parseInt(br.readLine());
            String num=br.readLine();

            Stack<Character> stack = new Stack<>();
           // int j =0;



            for(int j=0;j<k;j++){
                long return_num=deleteFromEnd(Long.parseUnsignedLong(num),j);
                if(isPrime(return_num)){
                    continue;
                }
                else{
                    count++;
                    remainingNum=return_num;
                }
            }

            sb.append(String.valueOf(remainingNum).length());
            sb.append(System.lineSeparator());
            sb.append(remainingNum);
        }

        System.out.println(sb);
    }
}
