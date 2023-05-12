package com.test.Contest741;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String s = br.readLine();
        int t=Integer.parseInt(s);
        StringBuilder stringBuilder = new StringBuilder();

        long max=0;
        for(int p=0;p<t;p++){
            String value = br.readLine();
            String[] values=value.split(" ");
            long a=Long.valueOf(values[0]);
            long b=Long.valueOf(values[1]);

            long n = b-a+1;
            long[] arr= new long[(int)n];
            for(int k=0;k<n;k++){
                arr[k]=a;
                a++;
            }

            for (long j = n - 2; j >= 0; --j) {
                // Break loop if answer is greater or equals to
                // the arr[j] as any number modulo with arr[j]
                // can only give maximum value up-to arr[j]-1
                if (max >= arr[(int)j])
                    break;

                // If both elements are same then skip the next
                // loop as it would be worthless to repeat the
                // rest process for same value
                if (arr[(int)j] == arr[(int)j + 1])
                    continue;

                for (long i = 2 * arr[(int)j]; i <= arr[(int)n - 1] + arr[(int)j]; i += arr[(int)j]) {
                    // Fetch the index which is greater than or
                    // equals to arr[i] by using binary search

                    int ind = Arrays.binarySearch(arr, i);

                    if (ind < 0)
                        ind = Math.abs(ind + 1);

                    else {
                        while (arr[ind] == i) {
                            ind--;

                            if (ind == 0) {
                                ind = -1;
                                break;
                            }
                        }
                        ind++;
                    }

                    // Update the answer
                    max = Math.max(max, arr[ind - 1] % arr[(int)j]);
                }
            }
            //return ans;
            stringBuilder.append(max);
            stringBuilder.append(System.lineSeparator());


        }

        System.out.println(stringBuilder);
    }
}
