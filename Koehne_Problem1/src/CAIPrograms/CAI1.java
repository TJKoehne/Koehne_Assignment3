//Thomas Koehne 2/23/20

package CAIPrograms;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	
	//Main method calling the quiz method containing the logic
	public static void main(String[] args) {
		quiz();
	}
	
	//Method containing the logic of the program
	private static void quiz() {
		SecureRandom random = new SecureRandom();
		
		//The number variable are initialized to random numbers
		int firstRdmNum = random.nextInt(9);
		int secondRdmNum = random.nextInt(9);
		//Answer is initialized to the product of the two numbers
		int answer = firstRdmNum * secondRdmNum;
		//last variables are initialized
		//User response starts at 0 so the while loop can happen
		int userResponse;
		int isUserCorrect = 0;
		
		//Loop that ask user to answer the question until they are correct
		while (isUserCorrect == 0) {
			askQuestion(firstRdmNum, secondRdmNum);
			userResponse = readResponse();
			isUserCorrect = isAnswerCorrect(userResponse, answer);
			displayResponse(isUserCorrect);
		}
	}
	
	//Takes in the two numbers and ask the question to answer
	private static void askQuestion(int Num1, int Num2) {
		System.out.println("What is " + Num1 + " x " + Num2 + "?");
	}
	
	//records user response
	private static int readResponse() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	//compares the answer and input to see if the user was correct
	//If so, the method returns a value that will exit the loop
	private static int isAnswerCorrect(int usrInput, int answer) {
		if (usrInput == answer) {
			return 1;
		} else {
			return 0;
		}
	}
	
	//Determines which display message to give to the user
	private static void displayResponse(int isUserCorrect) {
		if (isUserCorrect == 1) {
			displayCorrectResponse();
		} else {
			displayIncorrectResponse();
		}
	}
	
	//Prints a positive message
	private static void displayCorrectResponse() {
		System.out.println("Very good!");
	}
	
	//Prints a negative message
	private static void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}
}
