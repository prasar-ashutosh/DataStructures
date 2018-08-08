package com.practice.ds.linkedlist;

public class OrderedLinekedList {

	public static void main(String[] args) {

		Node first = insert(3, null);
		first = insert(5, first);
		first = insert(2, first);
		first = insert(4, first);
		first = insert(1, first);
		first = insert(6, first);
		System.out.println("Ordered Linked List");
		LinkedListOperations.printLinkedList(first);

		Node list1 = insert(1, null);
		list1 = insert(3, list1);
		list1 = insert(5, list1);
		list1 = insert(7, list1);
		list1 = insert(9, list1);
		
		Node list2 = insert(2, null);
		list2 = insert(4, list2);
		list2 = insert(6, list2);
		list2 = insert(8, list2);
		
		System.out.println("Merge Two list L1 (1,3,5,7,9) L2 (2,4,6,8)");
		Node merged = mergeTwoOrderedLinkedLists(list1, list2);
		LinkedListOperations.printLinkedList(merged);
	}

	public static Node insert(int item, Node first) {
		Node node = new Node(item);
		if (first == null) {
			return node;
		}

		// If item is smallest
		if (item < first.value) {
			node.next = first;
			return node;
		}

		Node cur = first;
		Node prev = null;
		while (cur != null && item > cur.value) {
			prev = cur;
			cur = cur.next;
		}
		prev.next = node;
		node.next = cur;
		return first;
	}

	public static Node mergeTwoOrderedLinkedLists(Node firstL1, Node firstL2) {
		if (firstL1 == null)
			return firstL2;
		if (firstL2 == null)
			return firstL1;

		Node merged = new Node(0);
		Node temp = merged;
		Node temp1 = firstL1;
		Node temp2 = firstL2;

		while (temp1 != null && temp2 != null) {
			if (temp1.value < temp2.value) {
				temp.next = temp1;
				temp1 = temp1.next;

			} else {
				temp.next = temp2;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		if (temp1 != null) {
			temp.next = temp1;
		}
		if (temp2 != null) {
			temp.next = temp2;
		}
		return merged.next;

	}

}
