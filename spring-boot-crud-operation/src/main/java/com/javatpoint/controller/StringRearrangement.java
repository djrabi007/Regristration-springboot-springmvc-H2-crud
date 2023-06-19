package com.javatpoint.controller;

import java.util.Arrays;
/**
 * How to rearrange a string in such a way so that duplicate chars should come
 * first then non duplicate chars. Also we should sort the characters after
 * rearrangement is done. For example - String s = "freedom"; Out put should be
 * "eedfmor" .
 * 
 * @author rabi0
 *
 */
import java.util.HashMap;
import java.util.Map;

public class StringRearrangement {
	public static void main(String[] args) {
		String s = "freedom";
		String rearrangedString = rearrangeAndSortString(s);
		System.out.println(rearrangedString);
	}

	public static String rearrangeAndSortString(String s) {
		Map<Character, Integer> charCount = new HashMap<>();
		StringBuilder duplicateChars = new StringBuilder();
		StringBuilder nonDuplicateChars = new StringBuilder();

		// Count occurrences of each character in the string
		for (char c : s.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		// Rearrange the characters
		for (char c : s.toCharArray()) {
			if (charCount.get(c) > 1) {
				duplicateChars.append(c);
			} else {
				nonDuplicateChars.append(c);
			}
		}

		// Sort the rearranged string
		char[] sortedChars = duplicateChars.toString().toCharArray();
		Arrays.sort(sortedChars);
		String sortedDuplicateChars = new String(sortedChars);

		// Concatenate the duplicate and non-duplicate characters
		sortedDuplicateChars += nonDuplicateChars.toString();

		return sortedDuplicateChars;
	}
}

