package com.practice.ds.heap;

import java.util.Arrays;

public class MinBinaryHeap {

	/*
	 * 2 4 8 9 7 10 9 15 20
	 * 
	 */

	int capacity;
	int size;
	int[] minHeap;

	public MinBinaryHeap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.minHeap = new int[capacity];
	}

	public int getparentIndex(int i) {
		return (i - 1) / 2;
	}

	public int getleftChildIndex(int i) {
		return 2 * i + 1;
	}

	public int getRightChildIndex(int i) {
		return 2 * i + 2;
	}

	public boolean hasLeftChild(int i) {
		int leftChildIndex = getleftChildIndex(i);
		return leftChildIndex < size;
	}

	public boolean hasRightChild(int i) {
		int rightChildIndex = getRightChildIndex(i);
		return rightChildIndex < size;
	}

	public boolean hasParent(int i) {
		int parentIndex = getparentIndex(i);
		if (i == 0 || i >= size)
			return false;
		return parentIndex >= 0;
	}

	public void swap(int index1, int index2) {
		int temp = minHeap[index1];
		minHeap[index1] = minHeap[index2];
		minHeap[index2] = temp;
	}

	// Double the size of array if it is full
	public void ensureExtraCapacity() {
		if (size == capacity) {
			minHeap = Arrays.copyOf(minHeap, capacity * 2);
			capacity = capacity * 2;
		}
	}

	public int peek() throws Exception {
		if (size == 0) {
			throw new Exception("Heap Empty");
		}
		return minHeap[0];
	}

	// remove the first element, move the last element to front and then balance
	// the heap
	public int poll() throws Exception {
		if (size == 0) {
			throw new Exception("Heap Empty");
		}
		int val = minHeap[0];
		minHeap[0] = minHeap[size - 1];
		size--;
		heapifyDown(0);
		return val;
	}

	public int delete(int index) throws Exception {
		if (index > size) {
			throw new Exception("Invalid Index");
		}
		int val = minHeap[index];
		minHeap[index] = minHeap[size -1];
		size--;
		heapifyDown(index);
		return val;
	}

	public void heapifyDown(int index) {
		int val = minHeap[index];

		while (hasLeftChild(index)) {
			if (minHeap[getleftChildIndex(index)] < val) {
				swap(index, getleftChildIndex(index));
				index = getleftChildIndex(index);
			} else if (hasRightChild(index) && minHeap[getRightChildIndex(index)] < val) {
				swap(index, getRightChildIndex(index));
				index = getRightChildIndex(index);
			} else {
				break;
			}
			val = minHeap[index];
		}
	}

	// insert the element in the end and then heapify up until the element
	// reaches its correct position
	public void insert(int x) {
		ensureExtraCapacity();
		minHeap[size++] = x;
		heapifyUp();
	}

	public void heapifyUp() {
		int index = size - 1;
		int val = minHeap[index];
		while (hasParent(index) && minHeap[getparentIndex(index)] > val) {
			swap(index, getparentIndex(index));
			index = getparentIndex(index);
			val = minHeap[index];
		}
	}

	public void printHeap() {
		for (int x = 0; x < size; x++) {
			System.out.print(minHeap[x] + " ");
		}
	}

	public static void main(String[] args) throws Exception {
		MinBinaryHeap heap = new MinBinaryHeap(10);
		heap.insert(10);
		heap.insert(8);
		heap.insert(5);
		heap.insert(12);
		heap.insert(4);
		heap.insert(6);
		heap.insert(7);
		heap.printHeap();

		System.out.println("\nPEEK: " + heap.peek());
		System.out.println("POLL: " + heap.poll());
		heap.printHeap();		
		heap.delete(2);
		System.out.println("\nDelete element at index 2");
		heap.printHeap();		

	}

}
