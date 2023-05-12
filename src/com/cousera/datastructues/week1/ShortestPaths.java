package com.cousera.datastructues.week1;

import java.util.*;

public class ShortestPaths {

    private static void shortestPaths(ArrayList<Integer>[] adj, ArrayList<Integer>[] costNew, int s, long[] dist, ArrayList<Integer> path) {
        {
            int size = adj.length;
            Long max = new Long(Integer.MAX_VALUE);
            int num = (int) 1e4 + 5;
            //long[] dist = new long[size];
            int[] prev = new int[size];
            dist[s] = 0;
            for (int i = 0; i < size; i++) {
                if (i == s) {
                    continue;
                } else {
                    dist[i] = max;
                    prev[i] = num;
                }
            }


            int flag = 0;
            for (int k = 0; k < adj.length; k++) {
                // Node node=priorityQueue.poll();
                //
                flag = -1;
                // for(int value:adj[nodeValue]){
                for (int i = 0; i < adj.length; i++) {
                    int value = 0;
                    int nodeValue = i;
                    int weight = 0;
                    //int weight=0;
                    for (int j = 0; j < adj[i].size(); j++) {
                        weight = costNew[i] != null ? (costNew[i].get(j) != null ? costNew[i].get(j) : 0) : 0;
                        value = adj[i].get(j);
                        if (dist[value] > (dist[nodeValue] + weight)) {
                            dist[value] = (dist[nodeValue] + weight);
                            prev[value] = nodeValue;
                            flag = value;

                        }
                    }


                }
            }
            if (flag == -1) {
                return;
            } else {
                int y = flag;
                for (int i = 0; i < size; i++) {
                    y = prev[y];
                }


                for (int cur = y; ; cur = prev[cur]) {
                    path.add(cur);
                    dist[cur]=max;
                    if (cur == y && path.size() > 1) {
                        break;
                    }
                }




            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(y-1, w);
        }
        int s = scanner.nextInt() - 1;
        long distance[] = new long[n];
        int reachable[] = new int[n];
        int shortest[] = new int[n];
        ArrayList<Integer> path= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            distance[i] = Long.MAX_VALUE;
            reachable[i] = 0;
            shortest[i] = 1;
        }
        shortestPaths(adj, cost, s, distance,path);
        Long max = new Long(Integer.MAX_VALUE);
        int size=adj.length;

        boolean[] visited= new boolean[size];
        Stack<Integer> order = new Stack<Integer>();

       /* for (int i = 0; i < size; i++) {
            if (visited[i]) {
                continue;
            } else {
                dfs(adj,path,distance,i,max,visited);
            }

        }*/

        dfs(adj,path,distance,s,max,visited);
        for (int i = 0; i < n; i++) {
           if(distance[i]==-max){
               System.out.println("-");
           }
           else if(distance[i]==max){
               System.out.println("*");
           }
           else{
               System.out.println(distance[i]);
           }
        }
    }

    private static void dfs(ArrayList<Integer>[] adj, ArrayList<Integer> path, long[] distance, int s,long max,boolean[] visited) {


        visited[s]=true;
        if(adj[s].size()==0){
           return;
        }

        for(int i:adj[s]){
            if(path.contains(i)){
                distance[i]=-max;
            }
            if(visited[i]) {
                continue;
            }
             else {

                dfs(adj, path, distance, i, max, visited);
            }
            }
        }
    }


