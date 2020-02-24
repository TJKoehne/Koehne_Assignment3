//Thomas Koehne 2/23/20

/*
 * For this program, I changed many of variables to instance variables
 * I made the class have an object which reduced the amount of variable passing
 * this also made it much easier to access data for the quiz
 * The questionType variable is used mainly for the randomized question choice
 * questionType is the same as mathType, which is the on the user originally choose
 *      for everything but when random question is chosen 
 * The purpose of it is to make sure the program knows which math question was asked
 *      when finding the answer.
 */

package CAIPrograms;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	
	//Instance variables are initialized;
	private double userResponse = -1;
	private int isUserCorrect = 0;
	private double grade = 0;
	private double firstRdmNum;
	private double secondRdmNum;
	private double answer;
	private int difficulty;
	private int mathType;
	private int questionType;
	
	//Main method calling the quiz method containing the logic
	public static void main(String[] args) {
		quiz();
	}
	
	//Method containing the logic of the program
	private static void quiz() {
		//creates a new quiz object 
		CAI5 q1 = new CAI5();
		while (true) {
			//checks to see if the user wants to continue using the program
			if (q1.getUserChoice() == 2) {
				System.out.println("Exiting now");
				break;
			}
			q1.grade = 0;
			q1.readDifficulty();
			q1.readProblemType();
			//Loop to ask 10 questions
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

	//generates the random numbers for the problems based on difficulty
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
	
	//Ask the user if they want to take a test or exit the program
	private int getUserChoice() {
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
	
	//gets the difficulty choice from the user
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
	
	//reads the problem type choice from the user
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
	
	//Calculates the answer to the problem based on what of question was asked
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
				answer = (double)Math.round((firstRdmNum / secondRdmNum) *10) /10;
			}
			break;
		}
	}
	
	//ask a question based on the math question type chosen
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
	
	//Used to ask a random question
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
	
	//reads response from the user
	private void readResponse() {
		Scanner in = new Scanner(System.in);
		userResponse = in.nextDouble();
	}
	
	//calculates is the user response was correct
	private void isAnswerCorrect() {
		if (userResponse == answer) {
			grade += 1;
			isUserCorrect = 1;
		} else {
			isUserCorrect = 0;
		}
	}
	
	//displays the problem option text
	private static void displayProblemOptions() {
		System.out.println("What problem type would you like?");
		System.out.println("1. Addition");
		System.out.println("2. Multipication");
		System.out.println("3. Subtraction");
		System.out.println("4. Division");
		System.out.println("5. Random Mix");
	}
	
	//displays the intro option text
	private static void displayIntroMessage() {
		System.out.println("What would you like to do?");
		System.out.println("1. Take a 10 Question Test");
		System.out.println("2. Exit Program");
	}
	
	//displays the difficulty options
	private static void displayDifficultyOptions() {
		System.out.println("What Difficulty would you like?");
		System.out.println("1. One Digit (0-9)");
		System.out.println("2. Two Digits (0-99)");
		System.out.println("3. Three Digits (0-999)");
		System.out.println("4. Four Digits (0-9999)");
	}
	
	//determines which response to displays
	private void displayResponse() {
		if (isUserCorrect == 1) {
			displayCorrectResponse();
		} else {
			displayIncorrectResponse();
		}
	}
	
	//displays a random positive response
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
	
	//displays a random negative response
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
	
	//displays a completion message along with a grade
	private void displayCopmletionMessage() {
		System.out.println("Your Grade is a " + grade * 10 + "%");
		if (grade > 7) {
			System.out.println("Congratulations, you are ready to go to the next level!\n");
		} else {
			System.out.println("Please ask your teacher for extra help.\n");
		}
	}
}