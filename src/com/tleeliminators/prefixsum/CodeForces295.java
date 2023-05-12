package com.tleeliminators.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeForces295 {


    public static void main(String[] args) throws IOException {

        double N = 1e5 + 10;

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String s = br.readLine();

        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int k = Integer.parseInt(s1[2]);
        StringBuffer sb= new StringBuffer();
        long[] arr = new long[n];
        long   count[]=new long [m+1];

        String elementLine = br.readLine();
        String[] elements = elementLine.split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(elements[i]);

        }
        int[][] operationArray = new int[m][3];
        for (int i = 0; i < m; i++) {
            String operationsString = br.readLine();
            String[] operations = operationsString.split(" ");
            operationArray[i][0] = Integer.parseInt(operations[0]);
            operationArray[i][1] = Integer.parseInt(operations[1]);
            operationArray[i][2] = Integer.parseInt(operations[2]);


        }

        long[] intialArray = new long[(int) N];
        for (int i = 0; i < k; i++) {
            String queryLine = br.readLine();
            String[] queries = queryLine.split(" ");
            int a = Integer.parseInt(queries[0]);
            int b = Integer.parseInt(queries[1]);
            count[a-1]++;
            count[b]--;


            /*while (a <= b) {
                intialArray[operationArray[a - 1][0] - 1] += operationArray[a - 1][2];
                intialArray[operationArray[a - 1][1]] -= operationArray[a - 1][2];
                a++;

            }*/
        }

        for(int i=0;i<m;i++)   // updating count of each operation
        {
            count[i]+=((i==0)?0:count[i-1]);
        }

        for(int i=0;i<m;i++)   // aplying each operation , number of count[i] times
        {
            long a1=count[i]* operationArray[i][2];
            intialArray[operationArray[i][0]] += a1;
            intialArray[operationArray[i][1]+1] -= a1;
        }


        long[] prefixSum = new long[(int) N];

            prefixSum[0] = intialArray[0];
            for (int j = 1; j < n+2; j++) {
                prefixSum[j] = prefixSum[j - 1]+ intialArray[j];
            }

            for (int p = 0; p < n; p++) {
                arr[p] = arr[p] + prefixSum[p+1];
                sb.append(arr[p]).append(System.lineSeparator());
            }

        System.out.println(sb);

        br.close();
    }
}
