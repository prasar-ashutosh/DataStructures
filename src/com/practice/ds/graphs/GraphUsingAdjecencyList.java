package com.practice.ds.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Undirected graph using adjecency List
public class GraphUsingAdjecencyList {
	// A graph is an array of adjacency lists.
	// Size of array will be V (number of vertices in graph)
	static class Graph {
		int V;
		LinkedList<Integer> adjListArray[];

		Graph(int V) {
			this.V = V;
			// Size of array = # of vertices
			adjListArray = new LinkedList[V];
			// For each vertex initialize a Linked List to store adjacent nodes
			for (int i = 0; i < V; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}

	// Adds an edge to an undirected graph
	static void addEdge(Graph graph, int src, int dest) {
		// Add an edge from src to dest.
		graph.adjListArray[src].addFirst(dest);

		// Since graph is undirected, add an edge from dest
		// to src also
		graph.adjListArray[dest].addFirst(src);
	}

	// Complexity : O(V)
	static void removeEdge(Graph graph, int src, int dest) {
		// Remove an edge from src to dest.
		graph.adjListArray[src].remove(Integer.valueOf(dest));

		// Since graph is undirected, remove an edge from dest to src also
		graph.adjListArray[dest].remove(Integer.valueOf(src));
	}

	// Complexity : O(V)
	static boolean checkEdgeBetweenTwoNodes(Graph graph, int src, int dest) {
		boolean edgeExists = false;
		if (graph.adjListArray[src].contains(Integer.valueOf(dest))) {
			edgeExists = true;
		}
		return edgeExists;
	}

	static void printGraph(Graph graph) {
		System.out.println("Adjacency list: ");
		for (int v = 0; v < graph.V; v++) {
			System.out.print("vertex" + v + " : ");
			System.out.print("head");
			for (Integer pCrawl : graph.adjListArray[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

	static Graph addVertex(Graph graph) {
		Graph graph2 = new Graph(graph.V + 1);
		for (int i = 0; i < graph.V; i++) {
			graph2.adjListArray[i] = graph.adjListArray[i];
		}
		graph2.adjListArray[graph.V] = new LinkedList<>();
		return graph2;
	}

	static void breadthFirstTraversal(Graph graph, int a) {
		List<Integer> visited = new ArrayList<>();
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(a);
		visited.add(a);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			for (int x : graph.adjListArray[node]) {
				if (!visited.contains(x)) {
					queue.offer(x);
					visited.add(x);
				}
			}
		}
	}
	
	static void depthFirstSearchUtil(Graph graph, int a, List<Integer> visited) {
		System.out.print(a + " ");
		visited.add(a);
		
		for (int x : graph.adjListArray[a]) {
			if (!visited.contains(x)) {
				depthFirstSearchUtil(graph, x, visited);
			}
		}
	}


	static void depthFirstTraversal(Graph graph, int a) {
		List<Integer> visited = new ArrayList<>();
		depthFirstSearchUtil(graph, a , visited);
	}

	public static void main(String args[]) {
		// create the graph given in above figure
		int V = 10;
		Graph graph = new Graph(V);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 3);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 3, 4);
		addEdge(graph, 2, 4);		
		addEdge(graph, 2, 5);
		addEdge(graph, 4, 5);		
		addEdge(graph, 5, 6);
		addEdge(graph, 5, 7);
		addEdge(graph, 6, 8);
		addEdge(graph, 6, 7);
		addEdge(graph, 8, 9);
		addEdge(graph, 7, 9);

		// print the adjacency list representation of the above graph
		printGraph(graph);

		// Check if edge exists between two nodes
		int node0 = 0;
		int node1 = 1;
		int node2 = 2;
		System.out.println("Check if edge exists Between Nodes " + node0 + " and " + node1);
		System.out.println(checkEdgeBetweenTwoNodes(graph, node0, node1));
		System.out.println("Check if edge exists Between Nodes " + node0 + " and " + node2);
		System.out.println(checkEdgeBetweenTwoNodes(graph, node0, node2));

		// Delete an edge
//		System.out.println("Delete an edge between nodes " + node0 + " and " + node1);
//		removeEdge(graph, node0, node1);
//		printGraph(graph);

		// Add a new vertex
//		System.out.println("Adding a new vertex");
//		graph = addVertex(graph);
//		addEdge(graph, 2, 5);
//		addEdge(graph, 3, 5);
//		printGraph(graph);

		System.out.println("Breadth First Traversal");
		breadthFirstTraversal(graph, 0);

		System.out.println("\n\nDepth First Traversal");
		depthFirstTraversal(graph, 0);

	}
}