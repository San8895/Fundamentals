package Arrayz;

import java.util.*;
import java.util.Map.Entry;
/*
 * Print the element sorted by their frequency count
 */

public class ElementFrequencyinArray {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 7, 6, 9, 1, 2, 2, 2, 3, 4, 4, 5, 10, 10, 1, 7 };
		// Arrays.sort(arr);
		HashMap<Integer, Integer> tm = new HashMap<Integer, Integer>();
		for (int r : arr) {
			int val = tm.get(r) == null ? 0 : tm.get(r);
			tm.put(r, val + 1);

		}
		System.out.println(tm);

		// sorting the hashmap by value
		Set<Entry<Integer, Integer>> set = tm.entrySet();
		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(set);

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		
		  System.out.println("Printing the sorted value : Key ====> value ");
		  for(Map.Entry<Integer, Integer> entry:list){
		 System.out.println(entry.getKey()+" ====> "+entry.getValue()); }
		 
		// printing the value by frequency
		System.out.println();
		System.out.println("Printing the sorted value in sorted by their frequency");
		for (Map.Entry<Integer, Integer> entry : list) {
			int i = 0;
			int count = (int) entry.getValue();
			int countval = (int) entry.getKey();
			while (i < count) {
				System.out.print(countval + " ");
				i++;
			}
		}
	}

}
