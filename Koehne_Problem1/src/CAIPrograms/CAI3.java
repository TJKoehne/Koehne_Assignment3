package CAIPrograms;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CAI3 {
	
	public static void main(String[] args) {
		quiz();
	}
	
	private static void quiz() {
		SecureRandom random = new SecureRandom();
		
		int firstRdmNum = random.nextInt(10);
		int secondRdmNum = random.nextInt(10);
		int answer = firstRdmNum * secondRdmNum;
		int userResponse = -1;
		int isUserCorrect = 0;
		int grade = 0;
		
		for(int i=0; i<10; i++){
			askQuestion(firstRdmNum, secondRdmNum);
			userResponse = readResponse();
			isUserCorrect = isAnswerCorrect(userResponse, answer);
			grade += isUserCorrect;
			displayResponse(isUserCorrect);
		}
		displayCopmletionMessage(grade);
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
		if (grade > 7) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		} else {
			System.out.println("Please ask your teacher for extra help.");
		}
	}
}
