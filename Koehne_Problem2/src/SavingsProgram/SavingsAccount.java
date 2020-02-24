package SavingsProgram;

public class SavingsAccount {
	private static double annualInterestRate = 0;
	private double savingsBalance;
	
	//Calculates the monthly interest based on the annual interest rate and adds it to the savings balance
	public void calculateMonthlyInterest() {
		this.savingsBalance += (savingsBalance * (annualInterestRate)) / 12;
	}
	
	//Updates the static annualInterestRate
	public static void modifyInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;
	}

	//Getters and Setters
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
}
