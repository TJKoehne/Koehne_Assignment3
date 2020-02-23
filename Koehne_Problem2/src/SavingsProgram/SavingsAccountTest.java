package SavingsProgram;

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount();
		SavingsAccount saver2 = new SavingsAccount();

		saver1.setSavingsBalance(2000.00);
		saver2.setSavingsBalance(3000.00);
		
		SavingsAccount.modifyInterestRate(0.04);
		
		System.out.printf("Inital Balance:%nSaver1: %.2f     Saver2: %.2f%n", saver1.getSavingsBalance(), saver2.getSavingsBalance());
		System.out.printf("12 Months of %.0f%% Annual Interest Monthly:%n", (SavingsAccount.getAnnualInterestRate() * 100));
		for(int i = 0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.printf("Month %d: Saver1: %.2f     Saver2: %.2f%n", (i + 1), saver1.getSavingsBalance(), saver2.getSavingsBalance());
		}
		
		SavingsAccount.modifyInterestRate(0.05);
		
		System.out.printf("12 Months of %.0f%% Annual Interest Monthly:%n", (SavingsAccount.getAnnualInterestRate() * 100));
		for(int i = 0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.printf("Month %d: Saver1: %.2f     Saver2: %.2f%n", (i + 1), saver1.getSavingsBalance(), saver2.getSavingsBalance());
		}
	}

}
