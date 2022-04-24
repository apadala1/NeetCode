package org.apadala.neetcode.arrays.test;

import org.apadala.neetcode.arraysHashing.Anagram;
import org.apadala.neetcode.arraysHashing.ContainsDuplicate;
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
}
