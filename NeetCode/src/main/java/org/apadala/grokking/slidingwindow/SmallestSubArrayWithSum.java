package org.apadala.grokking.slidingwindow;

/**
 * 
 * @author Akhileshwar.Padala Given an array of positive numbers and a positive
 *         number ‘S’, find the length of the smallest contiguous subarray whose
 *         sum is greater than or equal to ‘S’. Return 0, if no such subarray
 *         exists.
 * 
 */
public class SmallestSubArrayWithSum {

	/**
	 * Sliding window two pointer problem, variable size
	 * 
	 * @param input
	 * @param sum
	 * @return
	 */
	public static int solution1(int[] input, int sum) {

		int minLength = Integer.MAX_VALUE;

		int left = 0;
		int Wsum = 0;

		for (int right = 0; right < input.length; right++) {

			Wsum += input[right];

			while (Wsum >= sum) {
				minLength = Math.min(minLength, right - left + 1);
				Wsum -= input[left];
				left++;
			}

		}

		return minLength;
	}

	public static void main(String[] args) {
		int[] input = { 2, 1, 5, 2, 3, 5 };
		int sum = 7;

		System.out.println(SmallestSubArrayWithSum.solution1(input, sum));
	}

}
