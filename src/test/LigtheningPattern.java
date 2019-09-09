package test;

import java.util.Scanner;

public class LigtheningPattern {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		printPattern(n);
		in.close();
	}

	public static void printPattern(int n) {

		// check n is odd or even
		int oddOrEven = n%2;

		// rows and columns of 2D array
		int length = (n * 2) - oddOrEven;

		// Use 2D array to store the pattern
		char[][] patternArr = new char[length][length];

		// Initialize each element of array to space character
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				patternArr[i][j] = ' ';
			}
		}

		int repeatition = 0;

		while (repeatition < n) {

			// print x diagonally
			for (int i = 0 + repeatition, j = n - 1; i < n; i++, j++) {
				patternArr[i][j] = 'x';
				patternArr[j][i] = 'x';
			}
			// print o diagonally
			for (int i = 2 + repeatition, j = n - 1; i < n; i++, j++) {
				patternArr[i][j] = 'o';
				patternArr[j][i] = 'o';
			}
			// Pattern repeats itself after 4, so incrementing by 4
			repeatition += 4;
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(patternArr[i][j]);
			}
			System.out.println();
		}
	}

}
