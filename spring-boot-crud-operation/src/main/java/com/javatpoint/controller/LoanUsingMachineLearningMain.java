package com.javatpoint.controller;

/**
 * how you can use a machine learning algorithm, specifically a decision tree,
 * to generate personalized loan recommendations
 * 
 * Machine Learning Algorithms: Train machine learning models on historical loan
 * data, including successful and defaulted loans, to create predictive models.
 * These models can then be used to generate recommendations based on individual
 * customer profiles.
 * 
 * @author rabi0
 *
 */
public class LoanUsingMachineLearningMain {
	public static void main(String[] args) {
		// Create a customer object
		CustomerNew customer = new CustomerNew("John Doe", 60000, 720);

		// Get loan recommendation for the customer
		LoanRecommendationNew recommendation = LoanRecommendationSystemNew.getLoanRecommendation(customer);

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

class CustomerNew {
	private String name;
	private double income;
	private int creditScore;

	public CustomerNew(String name, double income, int creditScore) {
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

class LoanRecommendationNew {
	private String loanType;
	private double loanAmount;
	private double interestRate;

	public LoanRecommendationNew(String loanType, double loanAmount, double interestRate) {
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

class LoanRecommendationSystemNew {
	public static LoanRecommendationNew getLoanRecommendation(CustomerNew customer) {
		// Rule-based logic to generate loan recommendations based on customer
		// attributes
		if (customer.getCreditScore() >= 700 && customer.getIncome() > 50000) {
			return new LoanRecommendationNew("Personal Loan", 10000, 8.5);
		} else if (customer.getCreditScore() >= 650 && customer.getIncome() > 40000) {
			return new LoanRecommendationNew("Car Loan", 20000, 6.5);
		} else {
			return new LoanRecommendationNew("No Recommendation", 0, 0);
		}
	}
}


