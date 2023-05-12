package com.codeforces;

import java.util.ArrayList;
import java.util.Scanner;

public class Contest736B {


    public static int findmaxpawns(int[][] board,int boardSize){

        int count=0;
        boolean valid=false;
        for(int j=0;j<boardSize;j++){
            valid=false;
            for(int i=boardSize-1;i>0;i--){
                if(board[i][j]==1){
                    valid=true;
                }
               if(valid){

                   if(i==1 && j==0 && (board[i-1][j]==0 || board[i-1][j+1]==1)){
                       count++;
                   }
                   else if(i==1 && j==boardSize-1 && (board[i-1][j]==0 ||board[i-1][j-1]==1)){
                       count++;
                   }

                   else if(i==1 && j>0 && j< boardSize && (board[i-1][j]==0 || board[i-1][j-1]==1 || board[i-1][j+1]==1)){
                       count++;
                   }

                   else {
                       continue;
                   }
               }

               else {
                   continue;
               }
           }
        }

  return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> bases = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int boardSize = scanner.nextInt();
            int[][] board = new int[boardSize][boardSize];
            String enemy = scanner.next();
            String gregory = scanner.next();
            char[] enemyvals = enemy.toCharArray();
            char[] gregoryVals = gregory.toCharArray();

            for (int j = 0; j < enemyvals.length; j++) {
                int k = enemyvals[j]-'0';
                board[0][j] = k;
            }
            for (int j = 0; j < gregoryVals.length; j++) {
                int k =gregoryVals[j]-'0';
                board[boardSize - 1][j] = k;
            }

            bases.add(findmaxpawns(board, boardSize));
        }

       for(int i:bases){
           System.out.println(i);
       }
    }

    }

