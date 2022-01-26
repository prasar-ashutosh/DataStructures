package test;

import java.util.stream.*;
//import java.util.stream.IntStream;

public class SmallCode {
	public static void main(String[] s) {
		int i = 0;
		while (++i < 101) {
//			System.out.println(i % 15 < 1 ? "FizzBuzz" : i % 3 < 1 ? "Fizz" : i % 5 < 1 ? "Buzz" : i);
			
			System.out.println(((i % 3 < 1) ? "Fizz": "") + ((i % 5 < 1) ? "Buzz": ""));
		}
	}
}
