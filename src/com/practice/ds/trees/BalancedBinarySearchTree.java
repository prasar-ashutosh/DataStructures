package com.practice.ds.trees;

import java.util.ArrayList;
import java.util.List;

public class BalancedBinarySearchTree {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		BalancedBinarySearchTree bbst = new BalancedBinarySearchTree();
		TreeNode tree = bst.insert(null, 2);
		tree = bst.insert(tree, 3);
		tree = bst.insert(tree, 4);
		tree = bst.insert(tree, 6);
		tree = bst.insert(tree, 7);
		tree = bst.insert(tree, 8);
		tree = bst.insert(tree, 9);
		System.out.println("Unbalanced BST: ");
		bst.printPreOrder(tree);
		System.out.println("\nUnbalanced BST height: " + bst.height(tree));

		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		bbst.storeBSTNodes(tree, nodeList);
		System.out.println("List of Nodes:");
		System.out.println(nodeList);
		
		TreeNode balTree = bbst.balanceBST(nodeList, 0, nodeList.size() - 1);
		System.out.println("Balanced BST: ");
		bst.printPreOrder(balTree);
		System.out.println("\nBalanced BST height: " + bst.height(balTree));

	}

	public void storeBSTNodes(TreeNode root, List<TreeNode> nodeList) {
		if (root == null)
			return;
		storeBSTNodes(root.getLeft(), nodeList);
		nodeList.add(root);
		storeBSTNodes(root.getRight(), nodeList);
	}

	public TreeNode balanceBST(List<TreeNode> nodeList, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode node = nodeList.get(mid);
		node.setLeft(balanceBST(nodeList, start, mid - 1));
		node.setRight(balanceBST(nodeList, mid + 1, end));
		return node;

	}
}
