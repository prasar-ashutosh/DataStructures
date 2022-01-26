package com.practice.ds.search;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GrowingArrayMedian {

	public static String median(List<Integer> list) {
		int mid = list.size() / 2;
		if (list.size() % 2 == 0) {
			double val = (Double.valueOf(list.get(mid - 1)) + Double.valueOf(list.get(mid))) / 2;
			DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
			df.setMaximumFractionDigits(340);
			return df.format(val);
		} else {
			return String.format("%d", list.get(mid));
		}
	}

	public static int search(List<Integer> list, int val, int begin, int end) {
		if (begin <= end) {
			int mid = (begin + end + 1) / 2;
			// System.out.println(begin + "--" + mid + "--" + end);
			// Found it
			if (list.get(mid) == val) {
				return mid;
			} else if (val > list.get(mid)) {
				return search(list, val, mid + 1, end);
			} else {
				return search(list, val, begin, mid - 1);
			}
		}
		return begin;
	}

	static void median(String a[], int x[]) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < x.length; i++) {
			int val = x[i];
			String median = "";
			if (a[i].equals("r")) {
				if (list.size() == 0) {
					median = "Wrong!";
				} else {
					int index = search(list, val, 0, list.size() - 1);
					if (list.size() > index && val == list.get(index)) {
						// Delete and find median
						list.remove(index);
						if (list.size() == 0) {
							median = "Wrong!";
						} else {
							median = median(list);
						}
					} else {
						median = "Wrong!";
					}
				}
			} else if (a[i].equals("a")) {
				int index = search(list, val, 0, list.size() - 1);
				list.add(index, val);
				median = median(list);
			}
			System.out.println(median);
		}
	}

	public static void main(String[] args) {
//
//		String s[] = { "r", "a", "a", "a", "r", "r", "r" };
//		int x[] = { 1, 1, 2, 1, 1, 2, 1 };
//		median(s, x);

		Scanner in = new Scanner(System.in);

		int N;
		N = in.nextInt();

		String s[] = new String[N];
		int x[] = new int[N];

		for (int i = 0; i < N; i++) {
			s[i] = in.next();
			x[i] = in.nextInt();
		}

		median(s, x);
	}

}

// 0,1,2,3