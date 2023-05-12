package com.cousera.datastructues.week1.graphs;

import java.util.*;

public class StronglyConnected {

    static int count=1;
    public static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj,ArrayList<Integer>[] adjRev) {

        int size = adj.length;
        int sizeRev = adjRev.length;

        boolean[] visited = new boolean[sizeRev];
        boolean[] visitedStack = new boolean[sizeRev];
        Stack<Integer> order = new Stack<>();
        for (int i = 0; i < size; i++) {
            if (visited[i]) {
                continue;
            } else {
                explore(adj, i, visited, order);
            }

        }


        int[] result = new int[adj.length];
        while (!order.isEmpty()) {

            int val = order.pop();

            if(!visitedStack[val]){
                explore2(adjRev, val, visitedStack,result);
                count++;
            }


        }

        return --count;
    }


    private static void explore2(ArrayList<Integer>[] adj, int k, boolean[] visited,int[] result) {


        visited[k] = true;
        if (adj[k].size() == 0 ) {
                result[k]=count;
                return;
            }

        for (int i : adj[k]) {

            if (visited[i]) {
                if(result[i]==0){
                    result[i]=count;
                }

                continue;
            } else {
                explore2(adj, i, visited,result);

            }

        }
        if(result[k]==0){
            result[k]=count;
        }


    }


    private static void explore(ArrayList<Integer>[] adj, int k, boolean[] visited, Stack<Integer> order) {


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
                explore(adj, i,visited, order);

            }

        }
        if(!order.contains(k)){
            order.push(k);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] adjRev = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            adjRev[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adjRev[y - 1].add(x - 1);
        }
        System.out.println(numberOfStronglyConnectedComponents(adj,adjRev));
    }
}

