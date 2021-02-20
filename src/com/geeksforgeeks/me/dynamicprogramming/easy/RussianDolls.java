package com.geeksforgeeks.me.dynamicprogramming.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RussianDolls {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] dollSize= new int[num];

       // List<Integer> a = new ArrayList<>(){11,12};

        for(int i=0;i<num;i++){
            dollSize[i]=sc.nextInt();
        }
        int dolls=oddSizedDolls(dollSize);

        System.out.println(dolls);


    }

    public  static int oddSizedDolls(int[] array){

        int count=0;
        int size=array.length;
        Arrays.sort(array);
        for(int i =0;i<size;i++ ){
            if((size==1)||(array[i]==array[i+1] && size == 2)){
                return 1;
            }
            else if(array[i]==array[i+1]){
                count++;

                continue;
            }
            else {
               return count>0?(count + oddSizedDolls(Arrays.copyOfRange(array, i, size))):
                       (count + oddSizedDolls(Arrays.copyOfRange(array, i+1, size)));

            }
        }

   return count;
    }

}
