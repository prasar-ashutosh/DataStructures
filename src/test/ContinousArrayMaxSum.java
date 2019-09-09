package test;

public class ContinousArrayMaxSum {

	public static long contigousArrayMaxSum(int[] arr) {

		long maxSum = 0;
		long maxEndingHere = 0;

		for (int a : arr) {
			maxEndingHere += a;
			
			// If we encounter negative sum, then reinitialize maxEndingHere
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			if (maxSum < maxEndingHere) {
				maxSum = maxEndingHere;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {

		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };

		int[] arr1 = { 0, 5, 0, 1, -9, 2, 0, 5 };
		int[] arr2 = { 1, 3, -2, 1, 2 };

		long val = contigousArrayMaxSum(a);
		System.out.println(val);

		val = contigousArrayMaxSum(arr1);
		System.out.println(val);

		val = contigousArrayMaxSum(arr2);
		System.out.println(val);

	}

}
