package com.leetcode;

import java.util.Arrays;

public class MatrixBlockSum1314 {

    public  static int[][] matrixBlockSum(int[][] mat, int K) {

        int m=mat.length;
        int n=mat[0].length;

        int[][] answer= new int[m][n];
        int[][] prefixSum= new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               prefixSum[i][j]=mat[i][j]+(i>0?prefixSum[i-1][j]:0);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                prefixSum[i][j]=prefixSum[i][j]+(j>0?prefixSum[i][j-1]:0);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int r1=Math.max(0, i-K);
                int r2=Math.min(m-1, i+K);
                int c1=Math.max(0, j-K);
                int c2=Math.min(n-1, j+K);

                answer[i][j]=prefixSum[r2][c2]-(c1-1>=0?prefixSum[r2][c1-1]:0)-(r1-1>=0?prefixSum[r1-1][c2]:0)+(r1-1>=0&&c1-1>=0?prefixSum[r1-1][c1-1]:0);
            }
        }
     return answer;
    }

    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        int[][] answer=(matrixBlockSum(mat,2));
       for(int[] value:answer){
           System.out.println(Arrays.toString(value));
       }
    }
}
