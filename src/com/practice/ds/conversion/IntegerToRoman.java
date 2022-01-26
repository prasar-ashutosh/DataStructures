package com.practice.ds.conversion;

import java.util.TreeMap;

public class IntegerToRoman {

	public static void main(String[] args) {
		int nums[] = new int[] { 1, 2, 3, 4, 9 ,40, 1001};
		String res[] = romanizer(nums);
		for (String str : res) {
			System.out.println(str);
		}
	}

	private final static TreeMap<Integer, String> intRomanMap = new TreeMap<Integer, String>();

	static {
		intRomanMap.put(1000, "M");
		intRomanMap.put(900, "CM");
		intRomanMap.put(500, "D");
		intRomanMap.put(400, "CD");
		intRomanMap.put(100, "C");
		intRomanMap.put(90, "XC");
		intRomanMap.put(50, "L");
		intRomanMap.put(40, "XL");
		intRomanMap.put(10, "X");
		intRomanMap.put(9, "IX");
		intRomanMap.put(5, "V");
		intRomanMap.put(4, "IV");
		intRomanMap.put(1, "I");
	}

	public final static String convertToRoman(int number) {
		int l = intRomanMap.floorKey(number);
		if (number == l) {
			return intRomanMap.get(number);
		}
		return intRomanMap.get(l) + convertToRoman(number - l);
	}

	public static String[] romanizer(int[] numbers) {
		String[] res = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			res[i] = convertToRoman(numbers[i]);
		}
		return res;
	}

}
