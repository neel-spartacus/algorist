package com.scaler.recursion.backtracking.adityaverma;

public class KthSymbolGrammar {

    public static int findColSymbolGrammar(int row, int col){



        return solve(row,col);



    }

 public static int solve(int row,int col){

     int rowLength= (int) Math.pow(2,row-1);
     int mid=rowLength/2;

        if(row==1&& col==1){
            return 0;
        }

        if(col<=mid){
            return solve(row-1,col);
        }
        else{
            return solve(row-1,col-mid)==0?1:0;
        }

 }

    public static void main(String[] args) {

        int row=3,col=2;
        System.out.println(findColSymbolGrammar(row,col));


    }
}
