package com.practice.ds.heap;

public class HeapSort {

	public static int [] sort(int[] arr) {

		MinBinaryHeap heap = new MinBinaryHeap(arr.length);
		// insert into min heap
		for (int val : arr) {
			heap.insert(val);
		}
		
		System.out.println();
		heap.printHeap();
		System.out.println("\nHeap size = " + heap.size);
		// Swap first and last element of heap, delete the last element of heap
		// and put that in array
		while (heap.size > 1) {
			//System.out.println(heap.minHeap[0]);
			heap.swap(0, heap.size - 1);
			heap.size--;
			heap.heapifyDown(0);
			heap.printHeap();
		}
		
		return heap.minHeap;

	}

	public static void main(String[] args) {
		int arr[] = { 3, 2, 5, 4, 9, 7, 6, 1 };
		for (int val : arr) {
			System.out.print(val + " ");
		}
		int sorted []= sort(arr);
		for (int val : sorted) {
			System.out.print(val + " ");
		}
	}
}
