package com.practice.ds.linkedlist;

public class LinkedListOperations {

	public static void main(String[] args) {

		Node first = insertFront(1, null);
		first = insertFront(2, first);
		first = insertFront(3, first);
		first = insertFront(4, first);
		first = insertFront(5, first);
		System.out.println("Print Linked List (Insert Front)");
		printLinkedList(first);
		System.out.println("Delete From front and Print");
		first = deleteFront(first);
		printLinkedList(first);

		first = insertRear(1, null);
		first = insertRear(2, first);
		first = insertRear(3, first);
		first = insertRear(4, first);
		first = insertRear(5, first);
		System.out.println("Print Linked List (Insert Rear)");
		printLinkedList(first);
		System.out.println("Delete From Rear and Print");
		first = deleteRear(first);
		printLinkedList(first);

		System.out.print("Search 3: Found at index: " + search(3, first) + "\n");
		System.out.print("Search 5: Found at index: " + search(5, first) + "\n");

		System.out.println("\nDelete a node with value 3");
		first = deleteNode(3, first);
		printLinkedList(first);
	}

	public static Node insertFront(int val, Node first) {
		Node node = new Node(val);
		if (first == null) {
			return node;
		}
		node.next = first;
		return node;

	}

	public static Node insertRear(int val, Node first) {
		Node node = new Node(val);
		if (first == null) {
			return node;
		}
		Node temp = first;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		return first;
	}

	public static void printLinkedList(Node first) {
		Node temp = first;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println("\n");
	}

	public static Node deleteFront(Node first) {
		if (first == null) {
			return first;
		}
		Node temp = first.next;
		first = null;
		return temp;
	}

	public static Node deleteRear(Node first) {
		if (first == null) {
			return first;
		}
		Node cur = first;
		Node prev = null;
		while (cur.next != null) {
			prev = cur;
			cur = cur.next;
		}
		cur = null;
		prev.next = null;
		return first;
	}

	/*
	 * Return position of the item in the linked List (zero indexed) Return -1
	 * if not found
	 */
	public static int search(int item, Node first) {
		if (first == null) {
			return -1;
		}
		Node temp = first;
		int index = 0;
		while (temp != null) {
			if (temp.value == item) {
				return index;
			}
			index++;
			temp = temp.next;
		}
		return -1;
	}

	/*
	 * Delete a node whose value is given
	 */
	public static Node deleteNode(int item, Node first) {
		if (first == null) {
			return first;
		}

		if (first.value == item) {
			first = null;
		}

		Node cur = first;
		Node prev = null;
		while (cur != null && item != cur.value) {
			prev = cur;
			cur = cur.next;
		}

		if (cur != null) {
			prev.next = cur.next;
			cur = cur.next;
		}
		return first;
	}

}
