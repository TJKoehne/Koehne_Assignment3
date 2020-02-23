package SavingsProgram;

public class SavingsAccount {
	private static double annualInterestRate = 0;
	private double savingsBalance;
	
	public void calculateMonthlyInterest() {
		this.savingsBalance += (savingsBalance * (annualInterestRate)) / 12;
	}
	
	public static void modifyInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;
	}

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
