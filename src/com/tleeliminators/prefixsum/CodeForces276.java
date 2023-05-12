package com.tleeliminators.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeForces276 {


    public static long[] sort(long[] arr){
        for (int left=0, right=arr.length-1; left<right; left++, right--) {
            // exchange the first and last
            long temp = arr[left]; arr[left]  = arr[right]; arr[right] = temp;
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String s = br.readLine();

        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        //int k = Integer.parseInt(s1[2]);
        StringBuffer sb= new StringBuffer();
        long[] arr = new long[n];
        long count[]=new long[n+1];
       // count[0]=0;

        String elementLine = br.readLine();
        String[] elements = elementLine.split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.valueOf(elements[i]);

        }

        Arrays.sort(arr);
        arr=sort(arr);

        for (int i = 0; i < m; i++) {
            String queryLine = br.readLine();
            String[] queries = queryLine.split(" ");
            int a = Integer.parseInt(queries[0]);
            int b = Integer.parseInt(queries[1]);
            count[a-1]+=1;
            count[b]-=1;

        }

        for(int i=0;i<n+1;i++)   // updating count of each operation
        {
            count[i]+=(i==0?0:count[i-1]);
        }

        Arrays.sort(count);
        count=sort(count);

        long ans=0;
        for(int i=0;i<n;i++)   // aplying each operation , number of count[i] times
        {
           if(count[i]==0){
              continue;
           }
           else{
               ans+=arr[i]*count[i];
           }
        }

        System.out.println(ans);

        br.close();
    }
}
