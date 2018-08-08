package com.practice.ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {

	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTree {

	public static void main(String[] args) {

		/*
		 * 1 2 3 4 5 6 7
		 */

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("In order traversal");
		// In order traversal
		inOrderTraversal(root);

		System.out.println("\nLevel Order traversal");
		// Level Order traversal
		levelorderTraversal(root);

		List<Integer> path = new ArrayList<>();
		System.out.println("\nPath from root to 7");
		findPathFromRootToANode(root, 7, path);
		System.out.println(path);

		System.out.println("LCA(4,5): " + findLCA(root, 4, 5));
		System.out.println("LCA(4,3): " + findLCA(root, 4, 3));
		System.out.println("LCA(4,7): " + findLCA(root, 6, 7));

		// Distance between two nodes
		System.out.println("Distance (4,5): " + distanceBtwTwoNodes(root, 4, 5));
		System.out.println("Distance (3,5): " + distanceBtwTwoNodes(root, 3, 5));

	}

	public static void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);

		}
	}

	public static void levelorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node element = queue.poll();
			System.out.print(element.data + " ");
			if (element.left != null) {
				queue.add(element.left);
			}
			if (element.right != null) {
				queue.add(element.right);
			}
		}
	}

	public static int findLCA(Node root, int x, int y) {
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();
		findPathFromRootToANode(root, x, path1);
		findPathFromRootToANode(root, y, path2);

		int lca;
		int i = 0, j = 0;
		while (i < path1.size() && j < path2.size()) {
			if (path1.get(i) != path2.get(j)) {
				// Found the ancestor
				return path1.get(i - 1);
			}
			i++;
			j++;
		}
		if (i <= path1.size()) {
			return path1.get(i - 1);
		} else {
			return path2.get(j - 1);
		}

	}

	public static int distanceBtwTwoNodes(Node root, int x, int y) {
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();
		findPathFromRootToANode(root, x, path1);
		findPathFromRootToANode(root, y, path2);

		int lca = findLCA(root, x, y);
		int distRootToLCA = 0;
		for (int element : path1) {
			if (element != lca) {
				distRootToLCA++;
			}
		}

		int distance = path1.size() + path2.size() - 2 * distRootToLCA;
		return distance;
	}

	public static boolean findPathFromRootToANode(Node node, int x, List<Integer> path) {
		if (node == null)
			return false;

		path.add(node.data);
		if (node.data == x) {
			return true;
		}

		if (node.left != null && findPathFromRootToANode(node.left, x, path)) {
			return true;
		}

		if (node.right != null && findPathFromRootToANode(node.right, x, path)) {
			return true;
		}

		// If reached here means not found, so remove the values from the path
		path.remove(path.size() - 1);
		return false;
	}
	
	public static void printDiagonally(){
		
	}

}
