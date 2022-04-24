package org.apadala.neetcode.arraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Akhileshwar.Padala
 *
 */
public class GroupAnagrams {

	// numbers are faster than strings , use Arrays.hasCode() to generate hashcode
	// for key.

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<List<String>> groupAnagrams(String... strs) {

		Map<Integer, List<String>> resultMap = new HashMap<>();

		Arrays.asList(strs).stream().forEach(value -> {

			int hash = hashFunction(value.toLowerCase());
			if (!resultMap.containsKey(hash)) {
				resultMap.put(hash, new ArrayList<String>());
			}
			resultMap.get(hash).add(value);
		});

		return new ArrayList(resultMap.values());
	}

	public int hashFunction(String str) {
		int[] nums = new int[26];
		for (char value : str.toCharArray()) {
			nums[value - 'a']++;
		}
		return Arrays.hashCode(nums);

	}

	public List<List<String>> groupAnagrams1(String... strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs.length == 0)
			return res;
		HashMap<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] hash = new char[26];
			for (char c : s.toCharArray()) {
				hash[c - 'a']++;
			}
			String str = new String(hash);
			if (map.get(str) == null) {
				map.put(str, new ArrayList<>());
			}
			map.get(str).add(s);
		}
		res.addAll(map.values());
		return res;
	}

}
