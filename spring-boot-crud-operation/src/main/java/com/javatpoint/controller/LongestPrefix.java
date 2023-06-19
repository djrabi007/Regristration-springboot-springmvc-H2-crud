package com.javatpoint.controller;

/**
 * Find longest prefix String [] word={"flower","flow","fly"} Output should be
 * fl
 * 
 * ANS:: To find the longest common prefix among an array of strings, you can
 * iterate through the characters of the first string and compare them with the
 * corresponding characters in the remaining strings. Here's a Java
 * implementation:
 * 
 * 
 * In this example, the findLongestPrefix method takes an array of strings as
 * input (words). It iterates through each character of the first word and
 * compares it with the corresponding character in the remaining words. The
 * process stops when a mismatch is found or when the end of any word is
 * reached. The length of the common prefix is updated accordingly.
 * 
 * With the given input {"flower", "flow", "fly"}, the method will return "fl"
 * as the longest common prefix among the words.
 * 
 * Please note that the implementation assumes that the input array is not null
 * and contains at least one word. It returns an empty string if the input array
 * is empty or null.
 * 
 * 
 * @author rabi0
 *
 */
public class LongestPrefix {
	public static void main(String[] args) {
		String[] words = { "flower", "flow", "fly" };
		String longestPrefix = findLongestPrefix(words);
		System.out.println(longestPrefix);
	}

	public static String findLongestPrefix(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}

		String firstWord = words[0];
		int prefixLength = firstWord.length();

		for (int i = 1; i < words.length; i++) {
			String currentWord = words[i];
			int j = 0;

			while (j < prefixLength && j < currentWord.length() && firstWord.charAt(j) == currentWord.charAt(j)) {
				j++;
			}

			prefixLength = j; // Update prefix length based on the common characters found
		}

		return firstWord.substring(0, prefixLength);
	}
}
