package General_code;

import java.util.*;

public class FindDuplicateCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printduplicatechar("Madam");
		printduplicatechar("programming");

	}

	public static void printduplicatechar(String str) {
		String word=str.toUpperCase();
		char[] ch = word.toCharArray();
		// build HashMap with character and number of times they appear in
		// String
		Map<Character, Integer> hp = new HashMap<Character, Integer>();
		for (Character r : ch) {
			if (hp.containsKey(r))
				hp.put(r, hp.get(r) + 1);
			else
				hp.put(r, 1);

		}

		// Iterate through HashMap to print all duplicate characters of String
		Set<Map.Entry<Character, Integer>> entry = hp.entrySet();
		System.out.printf("List of duplicate characters in String '%s' %n", word);
		for (Map.Entry<Character, Integer> et : entry) {
			if (et.getValue() > 1) {
				System.out.printf("%s : %d %n", et.getKey(), et.getValue());
			}

		}

	}
}
