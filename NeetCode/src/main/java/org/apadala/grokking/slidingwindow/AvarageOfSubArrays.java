package org.apadala.grokking.slidingwindow;

/**
 * 
 * @author Akhileshwar.Padala
 *
 */
//Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
// Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
public class AvarageOfSubArrays {

	/**
	 * Brute force    0(N * M )
	 * 
	 * @param input
	 * @param subsetsize
	 * @return
	 */
	public static double[] solution1(int[] input, int subsetsize) {

		double result[] = new double[input.length - subsetsize + 1];

		for (int i = 0; i <= input.length - subsetsize; i++) {

			double sum = 0;

			for (int j = i; j < i + subsetsize; j++) {
				sum += input[j];
			}

			result[i] = sum / subsetsize;

		}

		return result;
	}

	/**
	 * Sliding window   0(N)
	 * 
	 * @param input
	 * @param subsetsize
	 * @return
	 */
	public static double[] solution2(int[] input, int subsetsize) {

		double result[] = new double[input.length - subsetsize + 1];
		double sum = 0;
		int window = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
			if (i >= subsetsize - 1) {
				result[window] = sum / subsetsize;
				sum -= input[window];
				window++;
			}

		}

		return result;
	}

	public static void main(String[] args) {
		int[] input = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
		// System.out.println("Brutforce result =" + AvarageOfSubArrays.solution1(input,
		// 5));

		for (double d : AvarageOfSubArrays.solution2(input, 5)) {
			System.out.println(d);
		}
	}
}
