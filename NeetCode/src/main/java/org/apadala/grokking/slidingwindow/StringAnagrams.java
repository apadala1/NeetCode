package org.apadala.grokking.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

	public static void main(String[] args) {
		String input = "abbcabc";
		String pattern = "abc";

		System.out.println(StringAnagrams.solution(input, pattern));
	}

	public static List<Integer> solution(String input, String pattern) {
		List<Integer> resultSet = new ArrayList<Integer>();

		Map<Character, Integer> charfrequency = new HashMap<Character, Integer>();
		for (char ch : pattern.toCharArray()) {
			charfrequency.put(ch, charfrequency.getOrDefault(ch, 0) + 1);
		}

		int left = 0, matches = 0;
		for (int right = 0; right < input.length(); right++) {

			char rightChar = input.charAt(right);

			if (charfrequency.containsKey(rightChar)) {
				charfrequency.put(rightChar, charfrequency.get(rightChar) - 1);

				if (charfrequency.get(rightChar) == 0) {
					matches++;
				}
			}

			if (matches == charfrequency.size()) {
				resultSet.add(left);
			}

			if (right >= pattern.length() - 1) {
				char leftchar = input.charAt(left);
				left++;

				if (charfrequency.containsKey(leftchar)) {
					if (charfrequency.get(leftchar) == 0) {
						matches--;
					}
					charfrequency.put(leftchar, charfrequency.get(leftchar) + 1);
				}
			}

		}

		return resultSet;
	}

}
