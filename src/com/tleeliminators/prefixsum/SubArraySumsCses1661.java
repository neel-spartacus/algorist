package com.tleeliminators.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumsCses1661 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String s = br.readLine();

        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int x = Integer.parseInt(s1[1]);
        long count=0;
        long[] arr= new long[n];
        long[] prefixSum= new long[n];
        Map<Long,Integer> map = new HashMap<>();
        //If prefixsum value ==target,we dont need to subtract prefixsum-target as it is 0 but there exist a sum which is the target value itself
        map.put(Long.valueOf("0"), 1);
       // prefixSum[0]=0;

        String arrayString = br.readLine();

        String[] s2 = arrayString.split(" ");

        for(int i=0;i<n;i++){
            arr[i]=Long.valueOf(s2[i]);
        }
        prefixSum[0]=arr[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=(prefixSum[i-1]+arr[i]);
        }
        for(int i=0;i<n;i++){
            long want=prefixSum[i]-x;
            if(map.containsKey(want)){
                count+=map.get(want);
            }
            if(map.get(prefixSum[i])!=null){
                int temp=map.get(prefixSum[i]);
                map.put(prefixSum[i],temp+1 );
            }
            else {
                map.put(prefixSum[i],1 );
            }

        }


        System.out.println(count);

    }
}
