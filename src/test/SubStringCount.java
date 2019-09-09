package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SubStringCount {
	// Complete the substrCount function below.
	static long substrCount(int n, String s) {
		long count = 0;
		char arr[] = s.toCharArray();
		// All the individual characters
		count += n;
		if (n < 2)
			return count;

		int k = 0;
		int end = n;
		for (int i = 1; i < n; i++) {
			for (int j = k; j < end; j++) {
				// i at a time
				if (j + i >= n)
					break;
				if (isSpecialPalindrome(arr, j, j + i)) {
					count++;
				}
			}
			boolean skipLeft = false;
			if (i > 1 && k < n - 1) {
				for (int l = k + 1; l < k + i; l++) {
					if (arr[l] != arr[l - 1]) {
						skipLeft = true;
						break;
					}
				}
				if (skipLeft) {
					k = k + i - 1;
				}					   		
			}
			
			boolean skipRight = false;
			if (i > 1 && end > i) {
				for (int l = end-1; l > end - i; l--) {
					if (arr[l] != arr[l - 1]) {
						skipRight = true;
						break;
					}
				}
				if (skipRight) {
					end = end - i + 1;
				}					   		
			}
			
		}
		return count;
	}

	static boolean isSpecialPalindrome(char[] arr, int left, int right) {
		boolean isSpecial = true;
		int i = left;
		int j = right;
		while (i < j) {
			if (arr[j] != arr[left] || arr[i] != arr[left]) {
				isSpecial = false;
				break;
			}
			i++;
			j--;
		}
		return isSpecial;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = "abcbaba";
		int n = 7;

		long result = substrCount(n, s);

		System.out.println(result);
	}
}
