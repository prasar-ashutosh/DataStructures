package com.practice.ds.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 1, 2, 8, 6, 5, 4, 7 };
		System.out.println("Unsorted Array:");
		for (int a : arr) {
			System.out.print(a + " ");
		}

		bubbleSort(arr);
		System.out.println("\nSorted Array:");
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}

	// In every pass, bubble the largest value to the end of the array
	// This is done by repeatedly swapping the adjacent elements if they are in
	// wrong order.
	public static void bubbleSort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j + 1] < arr[j]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
