package org.apadala.grokking.slidingwindow;

import java.util.HashMap;

/**
 * 
 * @author Akhileshwar.Padala
 *
 */
public class FruitBasket {

	public static void main(String[] args) {
		char[] fruits = { 'A', 'B', 'C', 'A', 'C' };
		int baskets = 2;

		StringBuilder bldr = new StringBuilder();

		for (char ft : fruits) {
			bldr.append(ft);
		}
		// this is one solution
		System.out.println(LongestSubStringwithKDistinctChar.solution(bldr.toString(), baskets));

		// solution 2
		System.out.println(FruitBasket.solution(fruits, baskets));
	}

	public static int solution(char[] fruits, int baskets) {

		int max = 0, left = 0;

		HashMap<Character, Integer> fruitFrequency = new HashMap<Character, Integer>();

		for (int right = 0; right < fruits.length; right++) {
			char rightChar = fruits[right];
			fruitFrequency.put(rightChar, fruitFrequency.getOrDefault(rightChar, 0) + 1);

			while (fruitFrequency.size() > baskets) {
				char leftchar = fruits[left];
				fruitFrequency.put(leftchar, fruitFrequency.getOrDefault(left, 0) - 1);
				if (fruitFrequency.get(leftchar) < 1) {
					fruitFrequency.remove(leftchar);
				}

				left++;
			}

			if (fruitFrequency.size() == 2) {
				max = Math.max(max, right - left + 1);
			}
		}

		return max;
	}
}
