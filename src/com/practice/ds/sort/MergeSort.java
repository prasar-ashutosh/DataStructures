package com.practice.ds.sort;

public class MergeSort {

	public static void main(String[] args) {

		int arr[] = new int[] { 3, 1, 2, 8, 6, 5, 4, 7 };
		System.out.println("Unsorted Array:");
		for (int a : arr) {
			System.out.print(a + " ");
		}

		mergeSort(arr, 0, 7);
		System.out.println("\nSorted Array:");
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}

	// Keep splitting the array into two halves until we have one element in the
	// array and then merge back to get the sorted array
	public static void mergeSort(int arr[], int begin, int end) {
		if (begin < end) {
			int mid = (begin + end) / 2;
			mergeSort(arr, begin, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, begin, mid, mid + 1, end);
		}
	}

	public static void merge(int arr[], int beginArr1, int endArr1, int beginArr2, int endArr2) {
		int lengthArray1 = endArr1 - beginArr1 + 1;
		int lengthArray2 = endArr2 - beginArr2 + 1;
		int tempArray[] = new int[lengthArray1 + lengthArray2];
		int i = beginArr1;
		int j = beginArr2;
		int k = 0;
		while (i <= endArr1 && j <= endArr2) {
			if (arr[i] < arr[j]) {
				tempArray[k++] = arr[i++];
			} else {
				tempArray[k++] = arr[j++];
			}
		}
		while (i <= endArr1) {
			tempArray[k++] = arr[i++];
		}
		while (j <= endArr2) {
			tempArray[k++] = arr[j++];
		}

		for (int l = 0; l < k; l++) {
			arr[beginArr1 + l] = tempArray[l];
		}

	}

}
