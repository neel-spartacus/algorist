package com.test;

import java.util.ArrayList;
import java.util.List;

public class FloodFillHackerRank {


    private static void fill(char[][] arr, char c, int i, int j, boolean[][] visited) {
        if (arr[i][j] != c)
            return;
        visited[i][j]=true;
        if (i - 1 >= 0 && !visited[i-1][j])
            fill(arr, c, i - 1, j,visited);
        if (j - 1 >= 0 && !visited[i][j-1])
            fill(arr, c, i, j - 1,visited);
        if (i + 1 < arr.length && !visited[i+1][j])
            fill(arr, c, i + 1, j,visited);
        if (j + 1 < arr[i].length && !visited[i][j+1])
            fill(arr, c, i, j + 1,visited);
    }

    public static int strokesRequired(List<String> picture) {
        // Write your code here
        // convert to char array to be sure to have O(n*m) complexity
        // if the list is a linked list the complexity would be worse
        int size=picture.size();
        char[][] arr = new char[size][];

        int index = 0;
        for (String s : picture)
            arr[index++] = s.toCharArray();
        int count = 0;
        boolean[][] visited= new boolean[size][arr[0].length];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (!visited[i][j]) {
                    fill(arr, arr[i][j], i, j,visited);
                    count++;
                }
        return count;
    }

    public static void main(String[] args) {

        List<String> picture= new ArrayList<>();
        picture.add("aabba");
        picture.add("aabba");
        picture.add("aaacb");

        System.out.println(strokesRequired(picture));
    }
}
