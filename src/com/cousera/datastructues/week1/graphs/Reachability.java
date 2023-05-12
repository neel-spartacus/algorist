package com.cousera.datastructues.week1.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        int result=0;
        boolean[] visited= new boolean[adj.length];
        if(adj[x].contains(y) || adj[y].contains(x)){
            return 1;
        }
        else{
            for(int j:adj[x]){
                if(!visited[j]){
                    result=explore(adj, j,y,visited,result);
                }

            }
        }
  return result;
    }

    private static int explore(ArrayList<Integer>[] adj,int k,int y,boolean[] visited,int result){
        visited[k]=true;
        if(adj[k].contains(y)){
            return 1;
        }
        for(int i:adj[k]){
            if(visited[i]){
                continue;
            }
            else{
                result=explore(adj, i, y, visited, result);
            }
        }
return result;
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
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

