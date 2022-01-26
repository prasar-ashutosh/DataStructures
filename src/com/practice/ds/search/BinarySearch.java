package com.practice.ds.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	// Return the index of element if found
	// Else return the index where it should be inserted
	public static int search(int arr[], int val, int begin, int end) {
		if (begin <= end) {
			int mid = (begin + end + 1) / 2;
			System.out.println(begin + "--" + mid + "--" + end);
			// Found it
			if (arr[mid] == val) {
				return mid;
			} else if (val > arr[mid]) {
				return search(arr, val, mid + 1, end);
			} else {
				return search(arr, val, begin, mid - 1);
			}
		}
		return begin;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 5, 6, 7, 8, 9, 10, 11 };		
		int index = search(arr, 12, 0, 9);
		System.out.println(index);
		
		List<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1, 5);
		System.out.println(list);
		
	}

}
