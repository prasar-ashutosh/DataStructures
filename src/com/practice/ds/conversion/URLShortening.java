package com.practice.ds.conversion;

public class URLShortening {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int BASE = ALPHABET.length();

	public static String encode(int num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(ALPHABET.charAt(num % BASE));
			num /= BASE;
		}
		return sb.reverse().toString();
	}

	public static int decode(String str) {
		int num = 0;
		String revStr = new StringBuilder(str).reverse().toString();
		for (int i = 0; i < revStr.length(); i++) {
			
			// cb = (2 * 62^1) + (1 * 62^0)
			// dnh = (3 * 62^2) + ....
			num += Math.pow(BASE, i) * ALPHABET.indexOf(revStr.charAt(i));
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(encode(12345));
		System.out.println(decode("dnh"));

	}

}
