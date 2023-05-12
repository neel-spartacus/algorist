package com.tleeliminators.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Codeforces1398C {


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));

            String s = br.readLine();

            int n = Integer.parseInt(s);


            for(int i=0;i<n;i++){
                long count=0;
                Map<Long,Integer> map = new HashMap<>();
                map.put(Long.valueOf("0"), 1);
                String s1=br.readLine();
                String s2=br.readLine();
                String[] elements=s2.split("");
                int len=Integer.parseInt(s1);
                long[] prefixSum=new long[len];
                int[] arr= new int[len];
                for(int j=0;j<len;j++){
                    arr[j]=Integer.parseInt(elements[j]);
                }
                prefixSum[0]=arr[0];
                for (int k = 1;k<len;k++){
                    prefixSum[k]=prefixSum[k-1]+arr[k];
                }
                for(int p=0;p<len;p++){

                    long want=prefixSum[p]-p-1;
                    if(map.containsKey(want)){
                        int temp=map.get(want)+1;
                        map.put(want,temp);
                        count+=temp-1;// This is done because when 2 prefix are same,we need to count it as 1
                    }

                    else {
                        map.put(want,1);
                    }


                }
                System.out.println(count);
                //System.out.println(count + (count*(count-1))/2);
            }


    }
}
