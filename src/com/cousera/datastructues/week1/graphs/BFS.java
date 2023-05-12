package com.cousera.datastructues.week1.graphs;

import java.util.*;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {

        int size=adj.length;
        boolean[] visited = new boolean[size];
        int[] paths= new int[size];
        Deque<Integer> queue= new ArrayDeque<>(size);
        queue.add(s);
        visited[s]=true;

        while (!queue.isEmpty()){
            int elem=queue.poll();
            for(int item:adj[elem]){

                if(visited[item]){
                    continue;
                }
                else {
                     queue.add(item);
                     paths[item]=paths[elem]+1;
                     visited[item]=true;
                }
            }
        }

        return paths[t]==0?-1:paths[t];
    }

    private static int distanceBruteForce(ArrayList<Integer>[] adj, int s, int t) {

        int size=adj.length;
        boolean[] visited = new boolean[size];
        int[] paths= new int[size];
        Deque<Integer> queue= new ArrayDeque<>(size);
        queue.add(s);
        visited[s]=true;

        while (!queue.isEmpty()){
            int elem=queue.poll();
            for(int item:adj[elem]){

                if(visited[item]){
                    continue;
                }
                else {
                    queue.add(item);
                    paths[item]=paths[elem]+1;
                    visited[item]=true;
                }
            }
        }

        return paths[t]==0?-1:paths[t];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            if((x-1)==(y-1)){
                continue;
            }
            else{
                adj[x - 1].add(y - 1);
                adj[y - 1].add(x - 1);
            }

        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

