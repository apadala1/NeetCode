package org.apadala.grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Akhileshwar.Padala
 *
 *         <br>
 *         given a string find the length of longest substring in it with no
 *         <br>
 *         more than K distinct characters <br>
 *         Example :<br>
 *         araaci , k= 2 ==> 4 output.
 */
public class LongestSubStringwithKDistinctChar {

	public static void main(String[] args) {

		String input1 = "araaci";
		int k = 2;

		System.out.println(LongestSubStringwithKDistinctChar.solution(input1, k));
	}

	public static int solution(String input1, int k) {
		Map<Character, Integer> charFrequency = new HashMap<Character, Integer>();

		int max = 0;
		int right = 0;
		for (int left = 0; left < input1.length(); left++) {
			char leftChar = input1.charAt(left);
			charFrequency.put(leftChar, (charFrequency.getOrDefault(leftChar, 0) + 1));

			while (charFrequency.size() > k) {
				char rightchar = input1.charAt(right);
				charFrequency.put(rightchar, (charFrequency.getOrDefault(rightchar, 0) - 1));
				if (charFrequency.get(rightchar) < 1) {
					charFrequency.remove(rightchar);
				}
				right++;
			}

			if (charFrequency.size() == k)
				max = Math.max(max, left - right + 1);

		}

		return max;
	}
}
