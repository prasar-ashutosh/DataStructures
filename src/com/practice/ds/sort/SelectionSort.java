package com.practice.ds.sort;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 1, 2, 8, 6, 5, 4, 7 };
		System.out.println("Unsorted Array:");
		for (int a : arr) {
			System.out.print(a + " ");
		}

		selectionSort(arr);
		System.out.println("\nSorted Array:");
		for (int a : arr) {
			System.out.print(a + " ");
		}

	}

	// Find the smallest element in the array in every pass and move it to the
	// front
	public static void selectionSort(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, minIndex, i);
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
