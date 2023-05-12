package com.cousera.datastructues.week1;

import java.util.*;
import java.io.*;

public class TreeHeightCalculate {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public static class Node{
    	int value;
    	List<Node> nodeList;
    	public Node(){
    		nodeList= new ArrayList<>();
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		Node root= new Node();

		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
				//nodes[i]= new Node();
			}
			//0  1  2 3 4
			//4 -1 4 1 1
			for (int i = 0; i < n; i++) {
				int k = parent[i];
				if (k != -1) {
					continue;
				} else {
					root.value = i;
					break;
				}
			}

			Queue<Node> queue = new ArrayDeque();
			((ArrayDeque) queue).push(root);
			while (!queue.isEmpty()) {
				Node node = ((ArrayDeque<Node>) queue).pop();
				for (int i = 0; i < n; i++) {
					if (node.value == parent[i]) {
						Node childNode = new Node();
						childNode.value=i;
						node.nodeList.add(childNode);
						((ArrayDeque<Node>) queue).push(childNode);
					}
				}



			}
		}

		int computeHeightQueue( Node root) {
			int height=0;
			if(root==null){
				return 0;
			}
			Queue<Node> queue= new ArrayDeque<>();
			((ArrayDeque<Node>) queue).push(root);

			while (!queue.isEmpty()){
				Node node=((ArrayDeque<Node>) queue).pop();
				if(queue.isEmpty()){
					height++;
				}
				for(Node child:node.nodeList){
					((ArrayDeque<Node>) queue).push(child);
				}
			// Replace this code with a faster implementation


		}

		return 0;
	}


	int[] heights= new int[n];
	int computeHeightRecursive( Node root) {

			int height=0;
			if(root==null){
				return 0;
			}
			if(heights[root.value]!=0){
				return heights[root.value];
			}
			else{
				heights[root.value]++;
			}
			;
			// Replace this code with a faster implementation
				for(Node node:root.nodeList){
					heights[node.value]=heights[root.value]+computeHeightRecursive(node);
				}

                return 0;
			}

		}


	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new TreeHeightCalculate().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeightRecursive(tree.root));
	}
}
