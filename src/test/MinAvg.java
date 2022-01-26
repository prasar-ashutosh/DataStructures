package test;

import java.io.*;
import java.util.*;

public class MinAvg {

	/*
	 * Complete the minimumAverage function below.
	 */
	static int minimumAverage(int[][] customers) {
		Arrays.sort(customers, new Comparator<int[]>() {
			@Override
			public int compare(final int[] entry1, final int[] entry2) {
				if (entry1[0] > entry2[0])
					return 1;
				else
					return -1;
			}
		});
		long count = customers.length;
		long nextCooking = customers[0][1] + customers[0][0];
		long totalWait = customers[0][1];
		if (count == 1)
			return (int) nextCooking;
		for (int i = 1; i < count; i++) {
			long prevCookTime = customers[i - 1][0];
			if (customers[i][0] <= nextCooking) {
				long localSum = 0;
				long localWait = 0;
				List<Integer> list = new ArrayList<Integer>();
				while (i < count && customers[i][0] <= nextCooking) {
					localWait += totalWait - customers[i][0] + prevCookTime;
					list.add(customers[i][1]);
					localSum += customers[i][1];
					i++;
				}
				localWait += findRemainingSum(list);
				totalWait += localWait;
				nextCooking += localSum;
			} else {
                nextCooking += customers[i][1] + customers[i][0];;
                totalWait += customers[i][1];
			}
		}

		long val = totalWait / count;
		return (int) (val);
	}

	static long findRemainingSum(List<Integer> list) {
		Collections.sort(list);
		long sum = 0;
		int len = list.size();
		for (int a : list) {
			sum += len * a;
			len--;
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		
		 int len = 0;
		  BufferedReader br = new BufferedReader(new FileReader("/Users/ashutosh/Desktop/input01.txt")); 		  
		  String st; 
		  int k=0;
		  int[][] customers = new int[50][2];
		  while ((st = br.readLine()) != null) { 
		    if(k==0) {
		    	len = Integer.valueOf(st);
		    }
		    else {
			  String arr [] = st.split("\\s"); 
			  customers[k-1][0]= Integer.valueOf(arr[0]);
			  customers[k-1][1]= Integer.valueOf(arr[1]);			 
		    }
		    k++;
		  } 

		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(customers[i][j] + " ");
			}
			System.out.println("");
		}

		int result = minimumAverage(customers);
		System.out.println(result);
	}

}