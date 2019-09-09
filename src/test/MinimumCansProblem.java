package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumCansProblem {

	public static int minCans(List<Integer> used, List<Integer> total) {

		Collections.sort(total, Collections.reverseOrder());
		long provided = 0;
		int count = 0;
		for (int water : used) {
			provided += water;
		}

		for (int capacity : total) {
			provided = provided - capacity;
			count++;
			if (provided <= 0) {
				break;
			}
		}

		return count;
	}

	public static void main(String[] args) {

		Integer [] totalArr = {3,5,3,5,3};
		Integer [] usedArr = {3,2,1,3,1};
		List<Integer> used = Arrays.asList(usedArr);
		List<Integer> total = Arrays.asList(totalArr);
		int count = minCans(used, total);
		System.out.println(count);						
	}

}
