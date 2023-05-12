package com.tleeliminators.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StaticRangeSumQueriesCses1646 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String s = br.readLine();

        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int q = Integer.parseInt(s1[1]);
        long[] arr = new long[n + 1];
        arr[0] = 0;
        long[] prefixSum = new long[n + 1];
        prefixSum[0] = 0;
        String secondLine = br.readLine();
        String[] s2 = secondLine.split(" ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(s2[i - 1]);
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < q; i++) {
            String query = br.readLine();
            String[] intValues = query.split(" ");
            int[] m = new int[2];
            m[0] = Integer.parseInt(intValues[0]);
            m[1] = Integer.parseInt(intValues[1]);
            stringBuffer.append(prefixSum[m[1]] - prefixSum[m[0] - 1]);
            stringBuffer.append(System.lineSeparator());
        }

        System.out.println(stringBuffer);

        br.close();

    }
}
