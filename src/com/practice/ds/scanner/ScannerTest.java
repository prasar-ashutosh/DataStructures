package com.practice.ds.scanner;

import java.util.Scanner;

public class ScannerTest {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		System.out.println(i);
		
		String j = in.nextLine();
		System.out.println(j);

		String s = in.next();
		System.out.println(s);
		in.close();
	} 
	
}
