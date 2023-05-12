package com.cousera.datastructues.week1.graphs;

import java.util.*;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        int size=adj.length;
        boolean[] visited = new boolean[size];
        String[] colors= new String[size];
        Deque<Integer> queue= new ArrayDeque<>(size);

        for(int i=0;i<size;i++){
            if(adj[i].size()>0){
                queue.add(i);
                break;
            }
        }

        while (!queue.isEmpty()){
            int elem=queue.poll();
            for(int item:adj[elem]){

                if(visited[item]){
                    if(colors[elem]==colors[item]){
                        return 0;
                    }
                    else{
                        continue;
                    }
                }
                else {
                    queue.add(item);
                    if(colors[elem]=="Black"){
                        colors[item]="White";
                    }
                    else {
                        colors[item]="Black";
                    }
                    visited[item]=true;
                }
            }
        }

        return 1;
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
        System.out.println(bipartite(adj));
    }
}

