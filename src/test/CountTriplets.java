package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.sound.midi.Soundbank;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        if(arr.size() <= 2) return count;
        Map<Long,Long> map = new HashMap<Long,Long>();
        for(Long l:arr){
            if(map. containsKey(l)) 
            {
                map.put(l, map.get(l) +1);
            }
            else map.put(l, new Long(1));
        }

        if(r==1){
            for (Map.Entry<Long,Long> entry : map.entrySet()) {
            if(entry.getValue() >=3){
                long val = entry.getValue();
                count += (val*(val-1)*(val-2))/6;
            }
        }
        return count;
        }

        for(long l:arr){
                long count1 = map.containsKey(l*r) ? map.get(l*r): 0;
                long count2 = map.containsKey(l*r*r) ? map.get(l*r*r): 0;  
                if(r == -1){
                    count2--;
                }             
                count +=  count1*count2;
                map.put(l, map.get(l)-1);
            }        
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/ashutosh/Desktop/input.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);

        System.out.println(ans);
    }
}

