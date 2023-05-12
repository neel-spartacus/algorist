package com.cousera.datastructues.week1.graphs.cses.graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class FlightsRoutesCheck {


    public static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj,ArrayList<Integer>[] adjRev) {

        int size = adj.length;
        int sizeRev = adjRev.length;

        int sinkElem=0;
        boolean[] visited = new boolean[size];
        boolean[] visitedStack = new boolean[sizeRev];
        Stack<Integer> order = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        Stack<Integer> disjoint = new Stack<>();
        for (int i = 0; i < size; i++) {
            if (visited[i]) {
                continue;
            } else {
                explore(adj, i, visited, order);
            }

        }

        while (!order.isEmpty()) {

            int val = order.pop();

            if(!visitedStack[val]){
                explore(adjRev, val, visitedStack,ans);
                if(ans.size()==size){
                    System.out.println("YES");
                    return 0;
                }
                else{
                    disjoint.push(val);
                }
                ans.clear();

            }


        }

        System.out.println("NO");
        System.out.println((disjoint.get(1)+1) + " " + (disjoint.get(0)+1));

        return 0;
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
            if((x-1)==(y-1)){
                continue;
            }
            else{
                adj[x - 1].add(y - 1);
                adjRev[y - 1].add(x - 1);
            }

        }
        numberOfStronglyConnectedComponents(adj,adjRev);
    }
}
