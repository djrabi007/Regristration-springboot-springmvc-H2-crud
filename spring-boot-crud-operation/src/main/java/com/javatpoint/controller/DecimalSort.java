package com.javatpoint.controller;

import java.util.Arrays;
import java.util.Comparator;

/**
 * requirement Double []num={66.6,788.3,77.2,1113.1} We have to sort the array
 * based on after decimal number the out out should be {1113.1,377.2,788.3,66.6}
 * 
 * @author rabi0
 *
 */
public class DecimalSort {
	public static void main(String[] args) {
		Double[] num = { 66.6, 788.3, 77.2, 1113.1 };
		sortArrayByDecimal(num);
		System.out.println(Arrays.toString(num));
	}

	public static void sortArrayByDecimal(Double[] num) {
		Arrays.sort(num, new Comparator<Double>() {
			@Override
			public int compare(Double num1, Double num2) {
				Double decimal1 = num1 - num1.intValue();
				Double decimal2 = num2 - num2.intValue();
				return decimal1.compareTo(decimal2);
			}
		});
	}
}
