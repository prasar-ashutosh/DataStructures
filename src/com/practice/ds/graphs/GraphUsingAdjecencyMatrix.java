package com.practice.ds.graphs;

public class GraphUsingAdjecencyMatrix {
	// A graph is a matrix of adjecencies.
	// Size of 2D array = V * V
	static class Graph {
		int V;
		int[][] adjMatrix;

		Graph(int V) {
			this.V = V;
			adjMatrix = new int[V][V];
		}
	}

	// Adds an edge to an undirected graph
	static void addEdge(Graph graph, int src, int dest) {
		// Add an edge from src to dest.
		graph.adjMatrix[src][dest] = 1;

		// Since graph is undirected, add an edge from dest to src also
		graph.adjMatrix[dest][src] = 1;
	}

	// Complexity : O(1)
	static void removeEdge(Graph graph, int src, int dest) {
		// Remove an edge from src to dest.
		graph.adjMatrix[src][dest] = 0;

		// Since graph is undirected, remove an edge from dest to src also
		graph.adjMatrix[dest][src] = 0;
	}

	// Complexity : O(1)
	static boolean checkEdgeBetweenTwoNodes(Graph graph, int src, int dest) {
		boolean edgeExists = false;
		if (graph.adjMatrix[src][dest] == 1 && graph.adjMatrix[dest][src] == 1) {
			edgeExists = true;
		}
		return edgeExists;
	}

	static void printGraph(Graph graph) {
		System.out.println("Adjacency matrix");
		for (int i = 0; i < graph.V; i++) {
			System.out.print("Vertex " + i + " : ");
			for (int j = 0; j < graph.V; j++) {
				System.out.print(graph.adjMatrix[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

	// Adding a vertex is costly in Graphs O(V^2)
	// need to copy the entire 2d array into another array with size 1 more than prev array
	// A better way is to initialize graph with say 10*10 and when it gets full, double the size
	static Graph addVertex(Graph graph) {
		Graph graph2 = new Graph(graph.V + 1);
		for (int i = 0; i < graph.V; i++) {
			for (int j = 0; j < graph.V; j++) {
				graph2.adjMatrix[i][j] = graph.adjMatrix[i][j];
			}
		}
		return graph2;
	}

	public static void main(String args[]) {
		// create the graph given in above figure
		int V = 5;
		Graph graph = new Graph(V);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);

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
		System.out.println("Delete an edge between nodes " + node0 + " and " + node1);
		removeEdge(graph, node0, node1);
		printGraph(graph);
		
		// Add a new vertex
		System.out.println("Adding a new vertex");
		graph = addVertex(graph);
		addEdge(graph, 2, 5);
		addEdge(graph, 3, 5);
		printGraph(graph);
	}
}
