package com.geeksforgeeks.me.dynamicprogramming.easy.practice;

public class CodilityMaximumPath {

    // Function to find the maximum sum
// path in the grid
    static int MaximumPath(int [][]grid)
    {
        // Dimensions of grid[][]
        int N = grid.length;
        int M = grid[0].length;

        // Stores maximum sum at each cell
        // sum[i][j] from cell sum[0][0]
        int [][]sum = new int[N + 1][M + 1];

        // Iterate to compute the maximum
        // sum path in the grid
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= M; j++)
            {
                // Update the maximum path sum
                sum[i][j] = Math.max(sum[i - 1][j],
                        sum[i][j - 1]) +
                        grid[i-1][j-1];
            }
        }

        // Return the maximum sum
        return sum[N][M];
    }

    // Driver Code
    public static void main(String[] args)
    {
        int [][]grid = {{1, 2}, {3, 5}};
        System.out.print(MaximumPath(grid));
    }
}


