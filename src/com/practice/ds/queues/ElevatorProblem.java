package com.practice.ds.queues;

import java.util.HashSet;
import java.util.Set;

public class ElevatorProblem {

	public static int solution(int[] A, int[] B, int M, int X, int Y) {
		// A [] = weight Array
		// B [] = destination floor
		// M = number of floors
		// X = Max People capacity
		// Y = max weight capacity
		int numStops = 0;
		int numPassangers = 0;
		int totalWeight = 0;
		Set<Integer> floorsServing = new HashSet<Integer>(); 
		for (int i = 0; i < A.length; i++) {
			if (A[i] > Y) {
				// Can not carry this person, so continue with others
				continue;
			}
			if (totalWeight + A[i] <= Y && numPassangers < X) {
				totalWeight += A[i];
				numPassangers++;
				// Using a set because passengers with destination having same floor will be counted as 1 stop.
				floorsServing.add(B[i]);
			} else {
				// number of stops = number of floors being served plus 1 to come back to ground floor
				numStops += floorsServing.size() + 1;
				// Reinitialize the floorsServing for next batch
				floorsServing = new HashSet<Integer>();
				// We need to consider the current person again so subtracting 1 from i
				i--;
				totalWeight = 0;
				numPassangers = 0;
			}
		}
		// Still need to serve the last batch in case it went unserved
		numStops += floorsServing.size() + 1;
		return numStops;
	}
	
	public static void main(String[] args) {
//		int[] A  = {60,80,40};
//		int[] B = {2,3,5};
//		int M = 5;
//		int X = 2;
//		int Y = 200;
		
		int[] A  = {50,350,60,70,120,130,40};
		int[] B = {2,6,2,3,7,5,3};
		int M = 5;
		int X = 4;
		int Y = 300;

		int stops = solution(A, B, M, X, Y);
		System.out.println(stops);
	}


}
