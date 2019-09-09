package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FrequencyProblem {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<int[]> queries) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

		List<Integer> response = new ArrayList<>();

		int i = 0;
		for (int[] query : queries) {
			i++;
			int qType = query[0];
			int val = query[1];
			if (qType == 1) {
				addOneToAMap(val, map);
				addOneToAMap(map.get(val), freqMap);
				removeOneFromAMap(map.get(val) - 1, freqMap);
			} else if (qType == 2) {
				Integer freq = map.get(val);
				if (freq != null)
					{addOneToAMap(freq - 1, freqMap);}
				removeOneFromAMap(freq, freqMap);
				removeOneFromAMap(val, map);
			} else if (qType == 3) {
				// Find if any element has frequency of val
				if (freqMap.containsKey(val))
					response.add(1);
				// if(map.values().contains(val)) response.add(1);
				else
					response.add(0);
			}
		}
		return response;
	}

	public static void addOneToAMap(Integer val, Map<Integer, Integer> map) {
		if (val != null) {
			if (map.containsKey(val)) {
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
		}
	}

	public static void removeOneFromAMap(Integer val, Map<Integer, Integer> map) {
		if (val != null) {
			if (map.containsKey(val)) {
				if (map.get(val) == 1) {
					map.remove(val);
				} else {
					map.put(val, map.get(val) - 1);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/ashutosh/Desktop/smallInput.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/ashutosh/Desktop/output.txt"));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<int[]> queries = new ArrayList<>();

		for (int i = 0; i < q; i++) {
			String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			int[] queriesRowItems = new int[2];

			for (int j = 0; j < 2; j++) {
				int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
				queriesRowItems[j] = (queriesItem);
			}

			queries.add(queriesRowItems);
		}

		List<Integer> ans = freqQuery(queries);

		for (int i = 0; i < ans.size(); i++) {
			bufferedWriter.write(String.valueOf(ans.get(i)));

			if (i != ans.size() - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
