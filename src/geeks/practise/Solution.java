package geeks.practise;

import java.util.Scanner;

public class Solution {

    static int countOfSubstringWithOnes(
            String s)
    {
        int N = s.length();
        int res = 0;
        int countOfOne = 0;
        int []freq = new int[N+1];

        freq[0] = 1;

        for (int i = 0; i < N; i++) {

            if(s.charAt(i)=='1'){
                countOfOne+=1;
            }

            if (countOfOne%2!=0) {

                res += freq[countOfOne];
            }
            freq[countOfOne]++;
        }

        return res;
    }

    static int countOfSubstringWithZeros(
            String s)
    {
        int N = s.length();
        int res = 0;
        int countOfOne = 0;
        int []freq = new int[N+1];

        freq[0] = 1;


        for (int i = 0; i < N; i++) {


            if(s.charAt(i)=='0'){
                countOfOne +=1;
            }

            if (countOfOne%2!=0) {
                res += freq[countOfOne];
            }

            freq[countOfOne]++;
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int n = 0; n < t; n++) {
            int a = sc.nextInt();
            int[] results=new int[2];
            String input=Integer.toBinaryString(a);
            results[0]=countOfSubstringWithZeros(input);
            results[1]=countOfSubstringWithOnes(input);
            System.out.println(results[0] + " " + results[1]);
        }


        }

    }

