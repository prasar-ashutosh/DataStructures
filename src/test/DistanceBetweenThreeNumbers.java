package test;

import java.util.List;

public class DistanceBetweenThreeNumbers {

	/*
	 * FUNCTION foo(list_a, list_b, list_c) x := ARRAY() y := 1000 FOR a in list_a
	 * FOR b in list_b FOR c in list_c z := 0 IF ABS(a-b) < ABS(a-c) z := ABS(a-c)
	 * ELSE z := ABS(a-b) END IF IF z < ABS(b-c) z := ABS(b-c) END IF IF z < y y :=
	 * z x := ARRAY(a, b, c) END IF END FOR END FOR END FOR RETURN x END FUNCTION
	 * 
	 */

	static int[] foo(int[] list1, int[] list2, int[] list3) {
		int[] x = null;
		int y = 1000;
		for (int a : list1) {
			for (int b : list2) {
				for (int c : list3) {
					int z = 0;
					if (Math.abs(a - b) < Math.abs(a - c)) {
						z = Math.abs(a - c);
					} else {
						z = Math.abs(a - b);
					}
					if (z < Math.abs(b - c)) {
						z = Math.abs(b - c);
					}
					if (z < y) {
						y = z;
						x = new int[] { a, b, c };
					}
				}
			}
		}

		return x;
	}

	public static void main(String[] args) {
		int[] list_a = new int[] { 5, 21, 61, 25, 11, 59 };
		int[] list_b = new int[] { 17, 81, 0, 7 };
		int[] list_c = new int[] { 42, 8, 25, 33, 2 };
		printArray(foo(list_a, list_b, list_c));
	}

	static void printArray(int[] arr) {
		for (int a : arr) {
			System.out.print(a);
		}
	}

}
