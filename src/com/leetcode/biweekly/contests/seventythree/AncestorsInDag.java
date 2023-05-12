package com.leetcode.biweekly.contests.seventythree;


//Problem : https://leetcode.com/contest/biweekly-contest-73/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/

import java.util.*;
import java.util.stream.Collectors;

public class AncestorsInDag {

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {

        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        List<List<Integer>> results=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for(int i=0;i< edges.length;i++){
                adj[edges[i][0]].add(edges[i][1]);
            }

        Map<Integer,Set<Integer>> map= new HashMap<>();
        for(int i=0;i< adj.length;i++){
            dfs(adj,map,i);
        }
        for(int i=0;i<adj.length;i++){
            if(map.containsKey(i)){
                continue;
            }
            map.put(i,new HashSet<>());
        }

        TreeMap<Integer, Set<Integer>> sorted = new TreeMap<>(map);

        sorted.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),
                e->new TreeSet<>(e.getValue())));

        sorted.entrySet().stream().forEach((k)->{
            List<Integer> result=new ArrayList<>(k.getValue());
            Collections.sort(result);
            results.add(result);
        });

        return results;
    }

    public static void dfs(ArrayList<Integer>[] adj,Map<Integer,Set<Integer>> map,int s){

        if(adj[s].size()==0){
            return;
        }
        for(int i:adj[s]){
            map.computeIfAbsent(i, k->new HashSet<Integer>()).add(s);
            if(adj[i].size()>0){
                adj[i].stream().forEach((val)->map.computeIfAbsent(val, k->new HashSet<Integer>()).add(s));
            }
            dfs(adj,map,i);
            map.get(i).addAll(map.getOrDefault(s,new HashSet<>()));
        }

    }

    //Optimal : https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/discuss/1821935/Python3-Java-C%2B%2B-Simple-DFS-O(n-2)

    public static List<List<Integer>> getAncestorsOptimal(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList();
        List<List<Integer>> directChild = new ArrayList();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList());
            directChild.add(new ArrayList());
        }
        for (int[] e: edges)
            directChild.get(e[0]).add(e[1]);
        for (int i = 0; i < n; i++)
            dfsOpt(i, i, ans, directChild);
        return ans;
    }
    private static void dfsOpt(int x, int curr, List<List<Integer>> ans, List<List<Integer>> directChild) {
        for (int ch: directChild.get(curr))
            if(ans.get(ch).size() == 0 || ans.get(ch).get(ans.get(ch).size() - 1) != x) {
                ans.get(ch).add(x);
                dfsOpt(x, ch, ans, directChild);
            }
    }



    public static void main(String[] args) {

        int n = 8;
        //int[][] edgeList = new int[][]{{8,3},{6,3},{1,6},{7,0},{8,5},{2,1},{4,0},{2,3},{0,3},{5,3},{7,4},{4,1}};
        int[][] edgeList = new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        //int[][] edgeList = new int[][]{{1,3},{1,4},{2,3},{2,4},{3,4},{0,1},{0,2},{0,3},{0,4},{1,2}};
        System.out.println(getAncestorsOptimal(n,edgeList));
    }
}
