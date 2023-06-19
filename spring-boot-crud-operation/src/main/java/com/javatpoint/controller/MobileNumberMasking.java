package com.javatpoint.controller;

/**
 * Input - String mobileNumber = "9012674578" Output- 901xxxx578;
 * 
 * @author rabi0
 *
 */
public class MobileNumberMasking {
	public static void main(String[] args) {
		String mobileNumber = "9012674578";
		String maskedNumber = maskMobileNumber(mobileNumber);
		System.out.println(maskedNumber);
	}

	public static String maskMobileNumber(String mobileNumber) {
		if (mobileNumber.length() != 10) {
			System.out.println("Invalid mobile number!");
			return mobileNumber;
		}

		StringBuilder maskedNumber = new StringBuilder(mobileNumber);
		for (int i = 3; i < 7; i++) {
			maskedNumber.setCharAt(i, 'x');
		}

		return maskedNumber.toString();
	}
}
