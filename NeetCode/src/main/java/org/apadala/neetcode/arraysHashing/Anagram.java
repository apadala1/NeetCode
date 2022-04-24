package org.apadala.neetcode.arraysHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram<BR>
 * https://leetcode.com/problems/valid-anagram/ <BR>
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * @author Akhileshwar.Padala
 *
 */
public class Anagram {

	/**
	 * English Alphabets are 26 count weight of 20 Alphabets then Substract 26
	 * weights again , new result must be all 0's
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		int[] record = new int[26];
		for (char c : s.toCharArray()) {
			record[c - 'a'] += 1;

		}
		for (char c : t.toCharArray()) {
			record[c - 'a'] -= 1;
		}
		for (int i : record) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	// 19 ms solution
	public boolean isAnagram2(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> s_Map = new HashMap<>();
		Map<Character, Integer> t_Map = new HashMap<>();

		for (char value : s.toCharArray()) {
			s_Map.put(value, 1 + s_Map.getOrDefault(value, 0));
		}

		for (char value : t.toCharArray()) {
			t_Map.put(value, 1 + t_Map.getOrDefault(value, 0));
		}

		return s_Map.equals(t_Map);

	}

	// 19 ms solution
	public boolean isAnagram1(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}
		char[] sArray = s.toCharArray();
		Arrays.sort(sArray);
		char[] tArray = t.toCharArray();
		Arrays.sort(tArray);
		return String.valueOf(sArray).equals(String.valueOf(tArray));
	}
}
