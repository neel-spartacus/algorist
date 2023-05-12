package com.cousera.datastructues.week1.graphs;

import java.util.*;

public class Toposort {
    private static Stack<Integer> toposort(ArrayList<Integer>[] adj) {
        int size=adj.length;

        boolean[] visited= new boolean[size];
        Stack<Integer> order = new Stack<Integer>();

        for (int i = 0; i < size; i++) {
            if (visited[i]) {
                continue;
            } else {
                explore(adj, i,order, visited);
            }

        }

        return order;
    }

    private static void explore(ArrayList<Integer>[] adj, int k,Stack<Integer> order, boolean[] visited) {

        visited[k] = true;
        if (adj[k].size() == 0 ) {
            if(!order.contains(k)){
                order.push(k);
                return;
            }
            else {
                return;
            }

        }
        for (int i : adj[k]) {

            if (visited[i]) {
               continue;
            } else {
               explore(adj, i, order, visited);

            }

        }
        if(!order.contains(k)){
            order.push(k);
        }


    }


    private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {
      //write your code here
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] adjRev = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }


        Stack<Integer> order = toposort(adj);
        while (!order.isEmpty()){
            System.out.print((order.pop() + 1) + " ");
        }

    }
}

