package com.cousera.datastructues.week1.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        int size = adj.length;
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                result = explore(adj, i, result, visited);
                result = result + 1;
            }


        }
        return result;
    }

    private static int explore(ArrayList<Integer>[] adj, int k, int result, boolean[] visited) {

        visited[k] = true;
        if (adj[k].size() == 0) {
            return result;
        }
        for (int i : adj[k]) {

            if (visited[i]) {
                continue;
            } else {
                result = explore(adj, i, result, visited);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

