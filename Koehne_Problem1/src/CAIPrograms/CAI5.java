package CAIPrograms;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	
	private double userResponse = -1;
	private int isUserCorrect = 0;
	private int grade = 0;
	private double firstRdmNum;
	private double secondRdmNum;
	private double answer;
	private int difficulty;
	private int mathType;
	private int questionType;
	
	public static void main(String[] args) {
		quiz();
	}
	
	private static void quiz() {

		CAI5 q1 = new CAI5();
		while (true) {
			if (getUserChoice() == 2) {
				System.out.println("Exiting now");
				break;
			}
			q1.grade = 0;
			q1.readDifficulty();
			q1.readProblemType();
			for(int i=0; i<10; i++){
				q1.generateQuestionArgument();
				q1.askQuestion();
				q1.readResponse();
				q1.getAnswer();
				q1.isAnswerCorrect();
				q1.displayResponse();
			}
			q1.displayCopmletionMessage();
		}
	}

	private void generateQuestionArgument() {
		SecureRandom random = new SecureRandom();
		switch (difficulty) {
		case 1:
			firstRdmNum = random.nextInt(10);
			secondRdmNum = random.nextInt(10);
			break;
		case 2:
			firstRdmNum = random.nextInt(100);
			secondRdmNum = random.nextInt(100);
			break;
		case 3:
			firstRdmNum = random.nextInt(1000);
			secondRdmNum = random.nextInt(1000);
			break;
		case 4:
			firstRdmNum = random.nextInt(10000);
			secondRdmNum = random.nextInt(10000);
			break;
		}
	}
	
	private static int getUserChoice() {
		displayIntroMessage();
		Scanner in = new Scanner(System.in);
		int userChoice;
		userChoice = in.nextInt();
		while (userChoice != 1 && userChoice != 2) {
			System.out.println("Choice Must be 1 or 2!");
			userChoice = in.nextInt();
		}
		return userChoice;
	}
	
	private void readDifficulty() {
		displayDifficultyOptions();
		Scanner in = new Scanner(System.in);
		int userChoice;
		userChoice = in.nextInt();
		while (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4) {
			System.out.println("Choice Must be 1 to 4!");
			displayDifficultyOptions();
			userChoice = in.nextInt();
		}
		this.difficulty =  userChoice;
	}
	
	private void readProblemType() {
		displayProblemOptions();
		Scanner in = new Scanner(System.in);
		mathType = in.nextInt();
		while (mathType != 1 && mathType != 2 && mathType != 3 && mathType != 4 && mathType != 5) {
			System.out.println("Choice Must be 1 to 5!");
			displayProblemOptions();
			mathType = in.nextInt();
		}
		questionType = mathType;
	}
	
	private void getAnswer() {
		switch (questionType) {
		case 1:
			answer = firstRdmNum + secondRdmNum;
			break;
		case 2:
			answer = firstRdmNum * secondRdmNum;
			break;
		case 3:
			answer = firstRdmNum - secondRdmNum;
			break;
		case 4:
			if (firstRdmNum == 0 || secondRdmNum == 0) {
				answer = 0;
			} else {
//				System.out.println((double)Math.round((firstNum / secondNum) *10) /10);
				answer = (double)Math.round((firstRdmNum / secondRdmNum) *10) /10;
			}
			break;
		}
	}
	
	private void askQuestion() {
		switch (mathType) {
		case 1:
			System.out.println("What is " + (int) firstRdmNum + " + " + (int) secondRdmNum + "?");
			break;
		case 2:
			System.out.println("What is " + (int) firstRdmNum + " x " + (int) secondRdmNum + "?");
			break;
		case 3:
			System.out.println("What is " + (int) firstRdmNum + " - " + (int) secondRdmNum + "?");
			break;
		case 4:
			System.out.println("What is " + (int) firstRdmNum + " / " + (int) secondRdmNum + "? (Round to nearest 10th)");
			break;
		case 5:
			this.askRandomQuestion();
		}
		
	}
	
	private void askRandomQuestion() {
		SecureRandom random = new SecureRandom();
		questionType = (random.nextInt(4) + 1);
		switch (questionType) {
		case 1:
			System.out.println("What is " + (int) firstRdmNum + " + " + (int) secondRdmNum + "?");
			break;
		case 2:
			System.out.println("What is " + (int) firstRdmNum + " x " + (int) secondRdmNum + "?");
			break;
		case 3:
			System.out.println("What is " + (int) firstRdmNum + " - " + (int) secondRdmNum + "?");
			break;
		case 4:
			System.out.println("What is " + (int) firstRdmNum + " / " + (int) secondRdmNum + "? (Round to nearest 10th)");
			break;
		}
	}
	
	private void readResponse() {
		Scanner in = new Scanner(System.in);
		userResponse = in.nextDouble();
	}
	
	private void isAnswerCorrect() {
		if (userResponse == answer) {
			grade += 1;
			isUserCorrect = 1;
		} else {
			isUserCorrect = 0;
		}
	}
	
	private static void displayProblemOptions() {
		System.out.println("What problem type would you like?");
		System.out.println("1. Addition");
		System.out.println("2. Multipication");
		System.out.println("3. Subtraction");
		System.out.println("4. Division");
		System.out.println("5. Random Mix");
	}
	
	private static void displayIntroMessage() {
		System.out.println("What would you like to do?");
		System.out.println("1. Take a 10 Question Test");
		System.out.println("2. Exit Program");
	}
	
	private static void displayDifficultyOptions() {
		System.out.println("What Difficulty would you like?");
		System.out.println("1. One Digit (0-9)");
		System.out.println("2. Two Digits (0-99)");
		System.out.println("3. Three Digits (0-999)");
		System.out.println("4. Four Digits (0-9999)");
	}
	
	private void displayResponse() {
		if (isUserCorrect == 1) {
			displayCorrectResponse();
		} else {
			displayIncorrectResponse();
		}
	}
	
	private static void displayCorrectResponse() {
		SecureRandom random = new SecureRandom();
		int output = random.nextInt(4);
		switch(output) {
		case 0:
			System.out.println("Very Good!");
			break;
		case 1:
			System.out.println("Excellent!");
			break;
		case 2:
			System.out.println("Nice Work!");
			break;
		case 3:
			System.out.println("Keep up the Good Work!");
			break;
		}
	}
	
	private static void displayIncorrectResponse() {
		SecureRandom random = new SecureRandom();
		int output = random.nextInt(4);
		switch(output) {
		case 0:
			System.out.println("No. Please try again.");
			break;
		case 1:
			System.out.println("Wrong. Try once more.");
			break;
		case 2:
			System.out.println("Don’t give up!");
			break;
		case 3:
			System.out.println("No. Keep trying.");
			break;
		}
	}
	
	private void displayCopmletionMessage() {
		System.out.println("Your Grade is a " + grade + "/10.");
		if (grade > 7) {
			System.out.println("Congratulations, you are ready to go to the next level!\n");
		} else {
			System.out.println("Please ask your teacher for extra help.\n");
		}
	}
}
