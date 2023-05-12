package com.cousera.datastructues.week1.graphs;

import java.util.*;

public class Dijkstra {

    static class Node{
        private long key;
        private int value;

        public Node(long key, int value) {
            this.key = key;
            this.value = value;
        }

        public long getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }



    }


    private static long distance(ArrayList<Integer>[] adj,ArrayList<Integer>[] costNew,int s, int t) {
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

        PriorityQueue<Node> priorityQueue= new PriorityQueue<>(Comparator.comparing(Node::getKey));
        for(int i=0;i<size;i++ ){
            Node node= new Node(dist[i], i);
            priorityQueue.add(node);
        }

        while (!priorityQueue.isEmpty()){
            Node node=priorityQueue.poll();
            int nodeValue=node.getValue();
           // for(int value:adj[nodeValue]){
            for(int i = 0;i<adj[nodeValue].size();i++){
                int weight=costNew[nodeValue]!=null?(costNew[nodeValue].get(i)!=null?costNew[nodeValue].get(i):0):0;
                int value=adj[nodeValue].get(i);

                //Optional<Integer> optional=cost[nodeValue].stream().filter(val-> val.get(value)!=null).map(v->v.get(value)).findFirst();
               // if(optional.isPresent()){
                 //   weight=optional.get();

                if(dist[value]>(dist[nodeValue]+weight)){
                    dist[value]=(dist[nodeValue]+weight);
                    prev[value]=nodeValue;
                    if(priorityQueue.removeIf(node1 -> node1.getValue()==value)){
                        priorityQueue.add(new Node(dist[value],value ));
                    }

                }
            }
        }
        return dist[t]==max?-1:dist[t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        //ArrayList<HashMap<Integer,Integer>>[] cost =(ArrayList<HashMap<Integer,Integer>>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
            //cost[i] = new ArrayList<HashMap<Integer,Integer>>();
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
            //cost[x - 1].add(map);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj,cost, x, y));
    }
}

