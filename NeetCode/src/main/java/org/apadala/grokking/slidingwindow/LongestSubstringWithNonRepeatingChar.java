package org.apadala.grokking.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithNonRepeatingChar {

	public static void main(String[] args) {
		String input = "pwwkew";

		System.out.println(LongestSubstringWithNonRepeatingChar.solution(input));
		System.out.println(LongestSubstringWithNonRepeatingChar.solution2(input));

	}

	/**
	 * better solution , faster
	 * @param input
	 * @return
	 */
	public static int solution2(String input) {
		int max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int left = 0, right = 0; right < input.length(); right++) {
			char rightchar = input.charAt(right);
			if (map.containsKey(rightchar)) {
				left = Math.max(map.get(rightchar), left);
			}
			max = Math.max(max, right - left + 1);
			map.put(rightchar, right + 1);

		}

		return max;
	}

	/**
	 * Not correct solution failes at pwwkew , Expected =3, output =4
	 * 
	 * @param input
	 * @return
	 */
	private static int solution(String input) {
		int max = 0, left = 0;

		Set<Character> charSet = new HashSet<Character>();

		for (int right = 0; right < input.length(); right++) {
			char rightChar = input.charAt(right);

			while (charSet.contains(rightChar)) {
				charSet.remove(input.charAt(left));
				left++;
			}
			charSet.add(rightChar);
			max = Math.max(max, right - left + 1);

		}

		return max;
	}

}
