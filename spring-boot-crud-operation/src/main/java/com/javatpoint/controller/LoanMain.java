package com.javatpoint.controller;

/**

generate personalized loan recommendations using a simple rule-based approach:
 * Personalized Loan Recommendations: Using the trained models, the system can
 * generate personalized loan recommendations for each customer. The
 * recommendations can include loan types, amounts, interest rates, repayment
 * periods, and other relevant details.
 * 
 * @author rabi0
 *
 */

public class LoanMain {
	public static void main(String[] args) {
		// Create a customer object
		Customer customer = new Customer("John Doe", 60000, 720);

		// Get loan recommendation for the customer
		LoanRecommendation recommendation = LoanRecommendationSystem.getLoanRecommendation(customer);

		// Display the recommendation
		if (recommendation.getLoanType().equals("No Recommendation")) {
			System.out.println("No loan recommendation available for " + customer.getName());
		} else {
			System.out.println("Loan Recommendation for " + customer.getName() + ":");
			System.out.println("Loan Type: " + recommendation.getLoanType());
			System.out.println("Loan Amount: $" + recommendation.getLoanAmount());
			System.out.println("Interest Rate: " + recommendation.getInterestRate() + "%");
		}
	}
}

class Customer {
	private String name;
	private double income;
	private int creditScore;

	public Customer(String name, double income, int creditScore) {
		this.name = name;
		this.income = income;
		this.creditScore = creditScore;
	}

	public String getName() {
		return name;
	}

	public double getIncome() {
		return income;
	}

	public int getCreditScore() {
		return creditScore;
	}
}

class LoanRecommendation {
	private String loanType;
	private double loanAmount;
	private double interestRate;

	public LoanRecommendation(String loanType, double loanAmount, double interestRate) {
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
	}

	public String getLoanType() {
		return loanType;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public double getInterestRate() {
		return interestRate;
	}
}

class LoanRecommendationSystem {
	public static LoanRecommendation getLoanRecommendation(Customer customer) {
		// Rule-based logic to generate loan recommendations based on customer
		// attributes
		if (customer.getCreditScore() >= 700 && customer.getIncome() > 50000) {
			return new LoanRecommendation("Personal Loan", 10000, 8.5);
		} else if (customer.getCreditScore() >= 650 && customer.getIncome() > 40000) {
			return new LoanRecommendation("Car Loan", 20000, 6.5);
		} else {
			return new LoanRecommendation("No Recommendation", 0, 0);
		}
	}
}


