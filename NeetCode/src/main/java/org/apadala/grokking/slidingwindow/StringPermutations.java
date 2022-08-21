package org.apadala.grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Akhileshwar.Padala
 *
 */
public class StringPermutations {

	public static void main(String[] args) {
		String input = "aaacb";
		String pattern = "abc";

		System.out.println(StringPermutations.solution(input, pattern));
	}

	public static boolean solution(String input, String pattern) {

		if (pattern.length() > input.length()) {
			return false;
		}

		int matched = 0;

		int left = 0;

		Map<Character, Integer> charFrequency = new HashMap<Character, Integer>();

		for (char ch : pattern.toCharArray()) {
			charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
		}

		// this is the sliding window
		for (int right = 0; right < input.length(); right++) {
			char rightChar = input.charAt(right);
			// this section we increment the pointer and check if we have required char in
			// the map and
			// substract with 1 , if we git 0 , then window has frequency matched.
			if (charFrequency.containsKey(rightChar)) {

				charFrequency.put(rightChar, charFrequency.get(rightChar) - 1);

				if (charFrequency.get(rightChar) == 0) {
					matched++;
				}
			}

			// at any given time if matched is qual to hashmap size then we return true.
			if (matched == charFrequency.size()) {
				return true;
			}

			// if we hit a point where window is reached , shrink window by 1 which is left.

			// since we may have counted left most char of the window to be in pattern , we
			// take left most character and check if we counted matched , if yes decrement
			// the match and add one frequencey back to hashmap to keep track of in future

			// this will shrink window by one , and main loop will increase window by one.
			// which will compansate for future window

			if (right >= pattern.length() - 1) {
				char leftChar = input.charAt(left);
				left++;

				if (charFrequency.containsKey(leftChar)) {
					if (charFrequency.get(leftChar) == 0) {
						matched--;
					}
					charFrequency.put(leftChar, charFrequency.get(leftChar) + 1);
				}

			}

		}

		return false;
	}

}
