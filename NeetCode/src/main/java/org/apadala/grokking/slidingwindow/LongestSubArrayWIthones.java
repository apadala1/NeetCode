package org.apadala.grokking.slidingwindow;

public class LongestSubArrayWIthones {

	public static void main(String[] args) {
		int[] input = { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 };
		int[] input2 = { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 };
		int k = 2;
		int k2 = 3;

		System.out.println(LongestSubArrayWIthones.solution(input, k));
		System.out.println(LongestSubArrayWIthones.solution(input2, k2));
	}

	public static int solution(int[] input, int k) {
		int max = 0;

		int frequency = 0;
		for (int left = 0, right = 0; right < input.length; right++) {

			if (input[right] == 1) {
				frequency++;
			}

			while (right - left + 1 - frequency > k) {
				if (input[left] == 1) {

					frequency--;
				}
				left++;
			}
			max = Math.max(max, right - left + 1);
		}

		return max;
	}

}
