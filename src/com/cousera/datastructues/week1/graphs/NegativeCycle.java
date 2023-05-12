package com.cousera.datastructues.week1.graphs;

import java.util.*;

public class NegativeCycle {

    private static long negativeCycle(ArrayList<Integer>[] adj,ArrayList<Integer>[] costNew,int s,int edges) {
        int size=adj.length;
        Long max=new Long(Integer.MAX_VALUE);
        int num=(int)1e4+5;
        long[] dist= new long[size];
        int[] prev= new int[size];
        dist[s]=0;
        for(int i=0;i<size;i++){
            if (i==s){
                continue;
            }
            else {
                dist[i]=max;
                prev[i]=num;
            }
        }


        int flag=0;
        for(int k=0;k<adj.length;k++){
           // Node node=priorityQueue.poll();
           //
            flag=-1;
            // for(int value:adj[nodeValue]){
            for(int i = 0;i<adj.length;i++){
                int value=0;
                int nodeValue=i;
                int weight=0;
                //int weight=0;
                for(int j=0;j<adj[i].size();j++){
                     weight=costNew[i]!=null?(costNew[i].get(j)!=null?costNew[i].get(j):0):0;
                     value=adj[i].get(j);
                    if(dist[value]>(dist[nodeValue]+weight)){
                        dist[value]=(dist[nodeValue]+weight);
                        prev[value]=nodeValue;
                        flag=value;

                    }
                }


            }
        }
        if(flag==-1){
            return 0;
        }
        else{
            return 1;
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

        int source=0;

        System.out.println(negativeCycle(adj,cost,source,m));
    }
}

