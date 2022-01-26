package com.practice.ds.sort;

public class MergeSortPractice {

	public int[] merge_sort(int arr[], int start, int end) {

		if (start >= end) {
			return arr;
		} else {
			int mid = (start + end) / 2;
			arr = merge_sort(arr, start, mid);
			arr = merge_sort(arr, mid + 1, end);
			return merge(arr, start, mid, mid + 1, end);
		}
	}

	public static int[] merge(int arr[], int l1, int r1, int l2, int r2) {
		int[] temp = new int[arr.length];
		int i = 0;
		for (int a : arr) {
			temp[i++] = a;
		}

		int left1 = l1;
		int left2 = l2;
		int t = l1;
		while (left1 <= r1 && left2 <= r2) {
			if (arr[left1] < arr[left2]) {
				temp[t++] = arr[left1++];
			} else {
				temp[t++] = arr[left2++];
			}
		}

		while (left1 <= r1) {
			temp[t++] = arr[left1++];
		}

		while (left2 <= r2) {
			temp[t++] = arr[left2++];
		}

		return temp;
	}

	public static void main(String[] args) {
		MergeSortPractice handler = new MergeSortPractice();

		int arr[] = { 3, 2, 5, 1, 6, 4, 9, 8, 0 };
		int merged[] = handler.merge_sort(arr, 0, arr.length - 1);
		handler.print(arr);
		handler.print(merged);
	}

	public void print(int arr[]) {
		System.out.println("Printing array : ");

		for (int a : arr) {
			System.out.print(a);
		}
		System.out.println("");

	}

}
