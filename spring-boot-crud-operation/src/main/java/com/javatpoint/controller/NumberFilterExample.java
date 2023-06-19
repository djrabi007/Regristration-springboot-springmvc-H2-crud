package com.javatpoint.controller;

/**
 * How to get number whose start with one? List<Integer> list=
 * Arrays.asList{10,20,15,30,16,30,45}; expected output is :10,15,16
 * 
 * ANS: To filter the numbers that start with one from the given list, you can
 * use Java 8 Stream API and filter based on the condition using the String
 * representation of each number. Here's an example:
 * 
 * @author rabi0
 *
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberFilterExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 20, 15, 30, 16, 30, 45);

		List<Integer> filteredList = list.stream().filter(number -> String.valueOf(number).startsWith("1"))
				.collect(Collectors.toList());

		System.out.println("Filtered List: " + filteredList);
	}
}
