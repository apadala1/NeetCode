package org.apadala.neetcode.arraysHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate <br>
 * https://leetcode.com/problems/contains-duplicate/<br>
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * 
 * 
 * @author Akhileshwar.Padala
 *
 */
public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {

		Set<Integer> numbersSet = new HashSet<>();

		for (int number : nums) {
			if (!numbersSet.add(number)) {
				return true;
			}
		}
		return false;
	}

}
