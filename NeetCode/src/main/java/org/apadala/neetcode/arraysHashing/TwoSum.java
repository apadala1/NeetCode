package org.apadala.neetcode.arraysHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. Two Sum<br>
 * https://leetcode.com/problems/two-sum/<br>
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * @author Akhileshwar.Padala
 *
 */
public class TwoSum {

	/**
	 * Subtract target with each number , if exists in map return result, if not put
	 * the number and index of number into Map
	 * 
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * if duplicates are allowed
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum1(int[] nums, int target) {

		int x = 0, y = 0;
		List<Integer> numbersList = Arrays.stream(nums).boxed().distinct().toList();

		for (int i = 0; i < numbersList.size(); i++) {

			if (target > numbersList.get(i)) {
				if (numbersList.contains(target - numbersList.get(i))) {
					x = numbersList.get(i);
					y = target - numbersList.get(i);
					break;
				}

			} else {

				if (numbersList.contains(numbersList.get(i) - target)) {
					x = numbersList.get(i);
					y = numbersList.get(i) - target;
					break;
				}

			}
		}

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == x) {
				x = i;
			}

			if (nums[i] == y) {
				y = i;
			}
		}

		return new int[] { x, y };

	}

}
