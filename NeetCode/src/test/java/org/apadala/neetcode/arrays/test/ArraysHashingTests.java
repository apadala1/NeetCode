package org.apadala.neetcode.arrays.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apadala.neetcode.arraysHashing.Anagram;
import org.apadala.neetcode.arraysHashing.ContainsDuplicate;
import org.apadala.neetcode.arraysHashing.GroupAnagrams;
import org.apadala.neetcode.arraysHashing.TwoSum;
import org.junit.Assert;
import org.junit.Test;

public class ArraysHashingTests {

	@Test
	public void containsDuplicateTest() {
		ContainsDuplicate object = new ContainsDuplicate();
		int[] values = { 1, 2, 3, 4, 1 };
		int[] values2 = { 1, 2, 3, 4, 5 };
		Assert.assertTrue(object.containsDuplicate(values));
		Assert.assertFalse(object.containsDuplicate(values2));

	}

	@Test
	public void anagramTest() {
		Anagram obj = new Anagram();
		Assert.assertTrue(obj.isAnagram1("anagram", "nagaram"));
		Assert.assertFalse(obj.isAnagram1("car", "rat"));
		Assert.assertTrue(obj.isAnagram("anagram", "nagaram"));
		Assert.assertFalse(obj.isAnagram("car", "rat"));

	}

	@Test
	public void twoSumTest() {
		TwoSum sum = new TwoSum();
		Assert.assertArrayEquals(new int[] { 0, 1 }, sum.twoSum(new int[] { 2, 7, 11, 15 }, 9));
		Assert.assertArrayEquals(new int[] { 1, 2 }, sum.twoSum(new int[] { 3, 2, 4 }, 6));
		Assert.assertArrayEquals(new int[] { 0, 1 }, sum.twoSum(new int[] { 3, 3 }, 6));
	}

	@Test
	public void groupAnagramTest() {

		GroupAnagrams cmd = new GroupAnagrams();
		List<List<String>> result = new ArrayList<>();
		result.add(Arrays.asList("bat"));
		result.add(Arrays.asList("nat", "tan"));
		result.add(Arrays.asList("ate", "eat", "tea"));
		Assert.assertArrayEquals(result.toArray(), cmd.groupAnagrams("eat","tea","tan","ate","nat","bat").toArray());

	}
}
