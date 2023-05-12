package com.scaler.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsWithGivenSum {

    final static int mod=(int)1e9+7;

    public static int solve(ArrayList<Integer> A, int B) {

        int n=A.size();

        if(n==1){
            return 0;
        }
        long count=0;

        int i=0;
        int j=n-1;

        while(i<j){
            int first=A.get(i);
            int second=A.get(j);

            if(first+second<B){
                i++;
                continue;
            }else if(first+second>B){
                j--;
                continue;
            }
            else{
                if(first==second){
                    long range=j-i+1;
                    count+=((range*(range-1)/2)%mod);
                    break;
                }
                else{
                    long elements1=0,elements2=0;
                    while (first==A.get(i)){
                        elements1++;
                        i++;
                    }
                    while(second==A.get(j)){
                        elements2++;
                        j--;
                    }
                    count+= ((elements1%mod)*(elements2%mod))%mod;
                }

            }
            }
        return (int)count%mod;
        }



    public static void main(String[] args) {

        ArrayList<Integer> arr= new ArrayList<>();Arrays.asList(2, 2, 3, 4, 4, 5, 6, 7, 10);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(10);

       // arr.add(1);
        System.out.println(solve(arr,8));

    }
}
