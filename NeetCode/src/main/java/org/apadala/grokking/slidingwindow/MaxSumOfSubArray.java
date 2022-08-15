package org.apadala.grokking.slidingwindow;

/**
 * 
 * @author Akhileshwar.Padala <br>
 *         Given an array of positive numbers and a positive number ‘k’, find
 *         the maximum sum of any contiguous subarray of size ‘k’ <br>
 *         Input: [2, 1, 5, 1, 3, 2], k=3 Output: 9 Explanation: Subarray with
 *         maximum sum is [5, 1, 3].<br>
 *         Input: [2, 3, 4, 1, 5], k=2 Output: 7 Explanation: Subarray with
 *         maximum sum is [3, 4].
 */
public class MaxSumOfSubArray {

	/**
	 * Brute Force
	 * 
	 * @param input
	 * @param subArraySize
	 * @return
	 */
	public static int solution1(int[] input, int subArraySize) {

		int result = 0;

		for (int i = 0; i <= input.length - subArraySize; i++) {

			int sum = 0;

			for (int j = i; j < i + subArraySize; j++) {

				sum += input[j];
			}
			result = Math.max(result, sum);
		}

		return result;
	}

	/**
	 * Sliding window
	 * 
	 * @param input
	 * @param subArraySize
	 * @return
	 */
	public static int solution2(int[] input, int subArraySize) {
		int result = 0;
		int window = 0;
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];

			if (i >= subArraySize - 1) {

				result = Math.max(result, sum);
				sum -= input[window];
				window++;

			}

		}

		return result;
	}

	public static void main(String[] args) {
		int[] input1 = { 2, 1, 5, 1, 3, 2 };
		int[] input2 = { 2, 3, 4, 1, 5 };

		System.out.println(MaxSumOfSubArray.solution1(input1, 3));

	}
}
