package SavingsProgram;

public class SavingsAccountTest {

	public static void main(String[] args) {
		//Creates two SavingsAccount objects
		SavingsAccount saver1 = new SavingsAccount();
		SavingsAccount saver2 = new SavingsAccount();

		//Sets the saving accounts to the initial balance
		saver1.setSavingsBalance(2000.00);
		saver2.setSavingsBalance(3000.00);
		
		//Sets the initial interest rate
		SavingsAccount.modifyInterestRate(0.04);
		
		//Prints out the initial balance of the savings accounts
		System.out.printf("Inital Balance:%nSaver1: %.2f     Saver2: %.2f%n", saver1.getSavingsBalance(), saver2.getSavingsBalance());
		
		//Prints out the balance of the savings accounts for the next 12 months based on the annual interest rate
		System.out.printf("12 Months of %.0f%% Annual Interest Monthly:%n", (SavingsAccount.getAnnualInterestRate() * 100));
		for(int i = 0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.printf("Month %d: Saver1: %.2f     Saver2: %.2f%n", (i + 1), saver1.getSavingsBalance(), saver2.getSavingsBalance());
		}
		
		//Changes the interest rate
		SavingsAccount.modifyInterestRate(0.05);
		
		//Prints out the balance of the savings accounts for the next 12 months based on the annual interest rate
		System.out.printf("12 Months of %.0f%% Annual Interest Monthly:%n", (SavingsAccount.getAnnualInterestRate() * 100));
		for(int i = 0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.printf("Month %d: Saver1: %.2f     Saver2: %.2f%n", (i + 1), saver1.getSavingsBalance(), saver2.getSavingsBalance());
		}
	}

}
