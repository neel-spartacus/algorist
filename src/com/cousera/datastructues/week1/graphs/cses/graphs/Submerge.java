package com.cousera.datastructues.week1.graphs.cses.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Submerge {


    public static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {

        int size = adj.length;
        int[] disc = new int[size];
        int[] low = new int[size];
        int[] ap = new int[size];
        int time = 0;

        int sinkElem = 0;
        int count = 0;
        boolean[] visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (visited[i]) {
                continue;
            } else {
                sinkElem = explore(adj, i, i, visited, disc, low, ap, time);
                ap[i] = sinkElem>1?sinkElem:0;
            }
        }

        for (int p : ap) {
            if (p != 0) {
                count++;
            }
        }

        return count;
    }


    private static void dfs(int u, int p) {

    }


    private static int explore(ArrayList<Integer>[] adj, int u, int p, boolean[] visited, int[] disc, int[] low, int[] ap, int time) {

        int size = adj.length;
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj[u]) {

            if (v == p) {
                continue;
            }
            if (!visited[v]) {
                children++;
                explore(adj, v, u, visited, disc, low, ap, time);
                if (disc[u] <= low[v]) {
                    ap[u] = 1;
                }
                low[u] = Math.min(low[u], low[v]);
            } else {
                low[u] = Math.min(disc[v], low[u]);
            }

        }

        return children;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        while (n != 0 && m != 0) {
            ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < m; i++) {
                int x, y;
                x = scanner.nextInt();
                y = scanner.nextInt();
                if ((x - 1) == (y - 1)) {
                    continue;
                } else {
                    adj[x - 1].add(y - 1);
                    adj[y - 1].add(x - 1);
                }

            }
            System.out.println();
            System.out.println(numberOfStronglyConnectedComponents(adj));
            if(scanner.hasNext()){
                n = scanner.nextInt();
                m = scanner.nextInt();
                if(n==0&& m==0){
                    System.exit(0);
                }
            }


        }
    }
}

