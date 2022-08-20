package org.apadala.grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		String input = "AABABBA";
		int k = 1;

		System.out.println(LongestRepeatingCharacterReplacement.solution(input, k));
	}

	public static int solution(String input, int k) {
		int max = 0;

		int maxfrequency = 0;
		Map<Character, Integer> freq = new HashMap<Character, Integer>();

		for (int left = 0, right = 0; right < input.length(); right++) {
			char rightchar = input.charAt(right);

			freq.put(rightchar, freq.getOrDefault(rightchar, 0) + 1);
			maxfrequency = Math.max(maxfrequency, freq.get(rightchar));

			while (!((right - left + 1) - maxfrequency <= k)) {
				char leftchar = input.charAt(left);
				freq.put(leftchar, freq.getOrDefault(leftchar, 0) - 1);
				if (freq.get(leftchar) < 1) {
					freq.remove(leftchar);
				}
				left++;
			}
			max = Math.max(max, right - left + 1);

		}

		return max;
	}
}
