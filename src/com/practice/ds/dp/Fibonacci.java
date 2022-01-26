package com.practice.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	Map<Integer, Integer> map;
	
	public Fibonacci() {
		map = new HashMap();
		map.put(1, 1);
		map.put(2, 1);
	}	
	

	int fibonacci_dp(int n) {
		if(map.containsKey(n)) {
			return map.get(n);
		}
			
		int value = fibonacci(n - 1) + fibonacci(n - 2);
		map.put(n, value);
		return value;
	}
	
	int fibonacci(int n) {
		if(n==1 || n==2) return 1;		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		long t1 = System.currentTimeMillis();
		for (int i = 1; i < 5; i++) {
			System.out.println(i + " : " + f.fibonacci(45));
		}
		long t2 = System.currentTimeMillis();
		for (int i = 1; i < 5; i++) {
			System.out.println(i + " : " + f.fibonacci_dp(45));
		}
		long t3 = System.currentTimeMillis();

		System.out.println("T1: "+ (t2-t1)) ;
		System.out.println("T2: "+ (t3-t2)) ;

	}

}
