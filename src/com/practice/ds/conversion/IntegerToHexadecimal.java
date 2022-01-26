package com.practice.ds.conversion;

public class IntegerToHexadecimal {

	static char[] hexTable = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static String intToHex(int i) {
		String res = "";
		int num = i;
		while (num > 0) {
			res += hexTable[num % 16];
			num = num / 16;
		}
		return new StringBuilder(res).reverse().toString();
	}

	public static void main(String[] args) {

		System.out.println(Integer.toHexString(5321));
		System.out.println(intToHex(5321));
	}
}
