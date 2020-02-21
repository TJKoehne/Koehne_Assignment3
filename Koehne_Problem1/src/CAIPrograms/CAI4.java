package CAIPrograms;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
	
	public static void main(String[] args) {
		quiz();
	}
	
	private static void quiz() {
		int userResponse = -1;
		int isUserCorrect = 0;
		int grade = 0;
		int firstRdmNum;
		int secondRdmNum;
		int answer;
		int difficulty;
		
		while (true) {
			if (getUserChoice() == 2) {
				System.out.println("Exiting now");
				break;
			}
			grade = 0;
			difficulty = readDifficulty();
			for(int i=0; i<10; i++){
				firstRdmNum = generateQuestionArgument(difficulty);
				secondRdmNum = generateQuestionArgument(difficulty);
				answer = firstRdmNum * secondRdmNum;
				askQuestion(firstRdmNum, secondRdmNum);
				userResponse = readResponse();
				isUserCorrect = isAnswerCorrect(userResponse, answer);
				grade += isUserCorrect;
				displayResponse(isUserCorrect);
			}
			displayCopmletionMessage(grade);
		}
	}
	

	private static int generateQuestionArgument(int difficulty) {
		SecureRandom random = new SecureRandom();
		switch (difficulty) {
		case 1:
			return random.nextInt(10);
		case 2:
			return random.nextInt(100);
		case 3:
			return random.nextInt(1000);
		case 4:
			return random.nextInt(10000);
		}
		return 0;
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
	
	private static int readDifficulty() {
		displayDifficultyOptions();
		Scanner in = new Scanner(System.in);
		int userChoice;
		userChoice = in.nextInt();
		while (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4) {
			System.out.println("Choice Must be 1 to 4!");
			displayDifficultyOptions();
			userChoice = in.nextInt();
		}
		return userChoice;
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
	
	private static void askQuestion(int Num1, int Num2) {
		System.out.println("What is " + Num1 + " x " + Num2 + "?");
	}
	
	private static int readResponse() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	private static int isAnswerCorrect(int usrInput, int answer) {
		if (usrInput == answer) {
			return 1;
		} else {
			return 0;
		}
	}
	
	private static void displayResponse(int isUserCorrect) {
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
		}
	}
	
	private static void displayCopmletionMessage(int grade) {
		System.out.println("Your Grade is a " + grade + "/10.");
		if (grade > 7) {
			System.out.println("Congratulations, you are ready to go to the next level!\n");
		} else {
			System.out.println("Please ask your teacher for extra help.\n");
		}
	}
}
