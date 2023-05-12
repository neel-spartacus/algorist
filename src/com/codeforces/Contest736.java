package com.codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Contest736 {


    public static ArrayList<Integer> findPrimeBases(int prime){

        ArrayList<Integer> bases= new ArrayList<>();

        for(int i=2;i<prime;i++){
            int modvalue=prime%i;
            for(int j=i+1;j<prime;j++){
                if(modvalue==(prime%j)){
                    bases.add(i);
                    bases.add(j);
                    break;
                }
            }
            break;
        }
        return bases;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> bases=new ArrayList<>();
        for(int i=0;i<n;i++){
            int prime=scanner.nextInt();
            bases.add(findPrimeBases(prime));

        }

        for(ArrayList<Integer> arrayList:bases){

                 System.out.println(arrayList.get(0) + " " + arrayList.get(1));
             }
        }
    }

