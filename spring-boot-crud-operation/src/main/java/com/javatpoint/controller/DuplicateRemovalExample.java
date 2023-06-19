package com.javatpoint.controller;

/**
 * Suppose i have list of 50 string value and some of them are duplicate i want
 * to remove duplicate at the same time I want to count each duplicate values
 * also using stream api how we can do .please provide me the solution
 * 
 * ANS:- To remove duplicates from a list of strings and count the occurrences
 * of each duplicate value using Java 8 Stream API, you can use a combination of
 * distinct() and collect() operations. Here's an example:
 * 
 * @author rabi0
 *
 */
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateRemovalExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple", "banana", "orange", "apple", "mango", "banana", "apple");

		List<String> distinctList = list.stream().distinct().collect(Collectors.toList());

		Map<String, Long> duplicateCountMap = list.stream()
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

		System.out.println("Distinct List: " + distinctList);
		System.out.println("Duplicate Count Map: " + duplicateCountMap);
	}
}
