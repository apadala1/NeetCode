package org.apadala.neetcode.arraysHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate <br>
 * https://leetcode.com/problems/contains-duplicate/<br>
 * Given an integer array numbers, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * 
 * 
 * @author Akhileshwar.Padala
 *
 */
public class ContainsDuplicate {

	/**
	 * Hash Set has 0(1) time complexity for add , remove , contains operation ,
	 * there are N elements to add to hashSet , if add returns false , then we hit
	 * duplicate. <br>
	 * total time complexity = 0(n); <br>
	 * total space complexity = 0(n) since we are storing elements into Data
	 * structure , DS.
	 * 
	 * @param nums
	 * @return
	 */
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
