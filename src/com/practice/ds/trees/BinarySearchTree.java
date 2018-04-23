package com.practice.ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		TreeNode tree = bst.generateBSTTree();
		System.out.println("\nprintInOrder: ");
		bst.printInOrder(tree);

		System.out.println("\nprintPreOrder: ");
		bst.printPreOrder(tree);

		System.out.println("\nprintPostOrder: ");
		bst.printPostOrder(tree);

		System.out.println("\nprintLevelTraversal: ");
		bst.printLevelTraversal(tree);

		int val = 1;
		System.out.println("\n\nDeleting a leaf node: " + val);
		bst.deleteRecursive(tree, val);
		System.out.println("printInOrder: ");
		bst.printInOrder(tree);

		val = 2;
		System.out.println("\n\nDeleting a node with no right tree " + val);
		tree = bst.generateBSTTree();
		bst.deleteRecursive(tree, val);
		System.out.println("printInOrder: ");
		bst.printInOrder(tree);

		val = 9;
		System.out.println("\n\nDeleting a node with no left tree: " + val);
		tree = bst.generateBSTTree();
		bst.deleteRecursive(tree, val);
		System.out.println("printInOrder: ");
		bst.printInOrder(tree);

		val = 7;
		System.out.println("\n\nDeleting a node with both left and right trees present: " + val);
		tree = bst.generateBSTTree();
		bst.deleteRecursive(tree, val);
		System.out.println("printInOrder: ");
		bst.printInOrder(tree);

		tree = bst.generateBSTTree();
		System.out.println("\nFind Common ancestor of 6 & 9: ");
		System.out.println(bst.findCommonAncestor(tree, 6, 9).getData());

		System.out.println("\nFind Common ancestor of 1 & 4: ");
		System.out.println(bst.findCommonAncestor(tree, 1, 4).getData());

		System.out.println("\nFind all paths from root to leaves: ");
		int path[] = new int[1000];
		bst.printPathsRecur(tree, path, 0);

		System.out.println("\nFind path from Root to a node: 10");
		List<Integer> list = new ArrayList<Integer>();
		if (bst.findPathFromRootToANode(tree, list, 10)) {
			System.out.println(list);
		}

		System.out.println("\n\nChecking a BST: ");
		tree = bst.generateBSTTree();
		System.out.println(bst.checkBST(tree));

	}

	public TreeNode generateBSTTree() {
		TreeNode tree = insert(null, 5);
		tree = insert(tree, 3);
		tree = insert(tree, 7);
		tree = insert(tree, 4);
		tree = insert(tree, 2);
		tree = insert(tree, 9);
		tree = insert(tree, 6);
		tree = insert(tree, 1);
		tree = insert(tree, 10);

		return tree;
	}

	public TreeNode insert(TreeNode root, int data) {
		TreeNode t = new TreeNode(data);

		if (root == null) {
			return t;
		}

		TreeNode cur = root;
		TreeNode prev = null;

		while (cur != null) {
			prev = cur;
			if (data < cur.getData()) {
				// System.out.println(data + " is less than " + cur.getData());
				cur = cur.getLeft();
			} else {
				// System.out.println(data + " is more than " + cur.getData());
				cur = cur.getRight();
			}
		}

		if (data < prev.getData()) {
			prev.setLeft(t);
		} else {
			prev.setRight(t);
		}
		return root;
	}

	public void printInOrder(TreeNode root) {
		if (root == null)
			return;
		printInOrder(root.getLeft());
		System.out.print(root.getData() + " ");
		printInOrder(root.getRight());
	}

	public void printPreOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			printPreOrder(root.getLeft());
			printPreOrder(root.getRight());
		}
	}

	public void printPostOrder(TreeNode root) {
		if (root != null) {
			printPostOrder(root.getLeft());
			printPostOrder(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}

	public void printLevelTraversal(TreeNode root) {
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode temp = queue.poll();
				if (temp != null) {
					System.out.print(temp.getData() + " ");
					queue.add(temp.getLeft());
					queue.add(temp.getRight());
				}
			}
		}
	}

	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			return 0;
		}
		return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
	}

	public int findLeftMostNode(TreeNode node) {
		int val = node.getData();
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		val = node.getData();
		return val;
	}

	// First find the node
	// if the node to delete is a leaf node, delete that node
	// if the node to delete has just one children, replace the node by children
	// if the node to delete has both children , find the minimum value in the
	// right tree and replace it with the node to be deleted
	public TreeNode deleteRecursive(TreeNode root, int value) {
		// Base condition
		if (root == null)
			return root;

		if (value < root.getData()) {
			root.setLeft(deleteRecursive(root.getLeft(), value));
		} else if (value > root.getData()) {
			root.setRight(deleteRecursive(root.getRight(), value));
		} else {
			// Found the node to delete
			if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			} else {
				int val = findLeftMostNode(root.getRight());
				root.setData(val);
				// Need to search the right tree only as left tree will be smaller than val
				root.setRight(deleteRecursive(root.getRight(), val));
			}
		}
		return root;
	}

	// while traversing from top to bottom, the first node n we encounter with
	// value between n1 and n2, i.e., n1 < n < n2 or same as one of the n1 or
	// n2, is LCA of n1 and n2

	// Logic: If node’s value is greater than both n1 and n2 then our LCA lies
	// in left side of the node, if it’s is smaller than both n1 and n2, then
	// LCA lies on right side. Otherwise root is LCA.
	public TreeNode findCommonAncestor(TreeNode root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		if (root.getData() > n1 && root.getData() > n2) {
			return findCommonAncestor(root.getLeft(), n1, n2);
		} else if (root.getData() < n1 && root.getData() < n2) {
			return findCommonAncestor(root.getRight(), n1, n2);
		} else {
			return root;
		}
	}

	void printPathsRecur(TreeNode node, int path[], int pathLen) {
		if (node == null) {
			return;
		}

		path[pathLen++] = node.getData();

		if (node.getLeft() == null && node.getRight() == null) {
			printArray(path, pathLen);
		} else {
			printPathsRecur(node.getLeft(), path, pathLen);
			printPathsRecur(node.getRight(), path, pathLen);
		}
	}

	void printArray(int ints[], int len) {
		int i;
		for (i = 0; i < len; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println("");
	}

	boolean findPathFromRootToANode(TreeNode node, List<Integer> path, int value) {
		if (node == null)
			return false;

		path.add(node.getData());
		if (node.getData() == value) {
			return true;
		}

		if (node.getLeft() != null && findPathFromRootToANode(node.getLeft(), path, value)) {
			return true;
		}

		if (node.getRight() != null && findPathFromRootToANode(node.getRight(), path, value)) {
			return true;
		}

		// If reached here means not found, so remove the values from the path
		path.remove(path.size() - 1);
		return false;
	}

	boolean checkBST(TreeNode root) {
		storeBTSinAnArray(root);
		System.out.println(list);
		for(int i=1;i<list.size();i++){
			if(list.get(i) < list.get(i-1)){
				return false;
			}
		}
		return true;
	}

	List<Integer> list = new ArrayList<>();

	void storeBTSinAnArray(TreeNode root) {
		if (root != null) {
			storeBTSinAnArray(root.getLeft());
			list.add(root.getData());
			storeBTSinAnArray(root.getRight());
		}

	}

}
