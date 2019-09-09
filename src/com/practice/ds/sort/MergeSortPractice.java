package com.practice.ds.sort;

public class MergeSortPractice {

	public int[] merge_sort(int arr[], int start, int end) {

		if (start == end)
			return arr;
		int mid = (start + end) / 2;

		arr = merge_sort(arr, start, mid);
		arr = merge_sort(arr, mid + 1, end);
		return merge(arr, start, mid, mid + 1, end);
	}

	public int[] merge(int arr[], int start1, int end1, int start2, int end2) {

		int temp[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		int j = start1;
		int k = start2;
		int l = start1;
		while (j <= end1 && k <= end2) {
			if (arr[j] < arr[k]) {
				temp[l++] = arr[j++];
			} else {
				temp[l++] = arr[k++];
			}
		}

		while (j <= end1) {
			temp[l++] = arr[j++];
		}
		while (k <= end2) {
			temp[l++] = arr[k++];
		}
		return temp;
	}
	
	public static void main(String[] args) {
		MergeSortPractice handler = new MergeSortPractice();
		
		int arr [] = {3,2,5,1,6,4,9,8,0};
		int merged [] = handler.merge_sort(arr, 0, arr.length - 1);
		handler.print(arr);
		handler.print(merged);
	}
	
	public void print(int arr []) {
		System.out.println("Printing array : ");
		
		for(int a: arr) {
			System.out.print(a);
		}
		System.out.println("");

	}

}
