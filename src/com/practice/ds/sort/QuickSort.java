package com.practice.ds.sort;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 1, 2, 8, 6, 5, 4, 7 };
		System.out.println("Unsorted Array:");
		for (int a : arr) {
			System.out.print(a + " ");
		}

		quickSort(arr, 0, 7);
		System.out.println("\nSorted Array:");
		for (int a : arr) {
			System.out.print(a + " ");
		}

	}

	// find the location of pivot element and quicksort left array and right array
	public static void quickSort(int arr[], int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
	}

	// pivot element = last element of array
	// Move pivot element to its correct position so that all the elements to left of pivot are smaller than the pivot element
	// and all the elements to right of pivot are greater than the pivot element
	public static int partition(int arr[], int start, int end) {
		int i = start - 1;
		int pivot = arr[end];
		for (int j = start; j < end; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, end);
		return i + 1;
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
