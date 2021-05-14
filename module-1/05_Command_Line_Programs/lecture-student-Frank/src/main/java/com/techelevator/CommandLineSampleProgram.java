package com.techelevator;

import java.util.Scanner;   // give me access to the code that supports Scanner

public class CommandLineSampleProgram {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Frank's Command Line Sample Program");
		// read input from the keyboard

		// define scanner object in our program to represent the keyboard
		// Java automatically gives the keyboard the name: System.in
		// Scanner - scan the keyboard input and return data from the keyboard to the program


//      datatype     name   = initial-value        - no different than defining an int, double, or array
		Scanner theKeyboard = new Scanner(System.in);  // define a Scanner for System.in called theKeyboard


		String aLine = "";  // hold a line of input from the keyboard

		System.out.println(" Please enter a line and press enter...");  // prompt the user for input

		// get a line of input from the keyboard and store it in our variable aLine

		aLine = theKeyboard.nextLine();  // .nextLine() - return a line from the keyboard using the Scanner we defined.


		System.out.println("You typed: " + aLine);   // display the line entered by the human at the keyboard


		System.out.println("Please enter a number: ");   // ask the user to enter a number

		aLine = theKeyboard.nextLine();    // get a line from the user

		System.out.println("You entered the number: " + aLine);  // show them what we think they entered

		// we need to convert the number they enter from a string to an int so we can multiply it
		// 		Integer.parseInt() will convert a string containing numeric digits to an int
		//		Double.parseDouble() will convert a string to a double

		int theNumber = Integer.parseInt(aLine);

		System.out.println("Double your number is: " + theNumber * 2);

		int sum = 0;   // hold the sum of the numbers entered by the user

		while (true) { // loop until we hit a break statement inside the loop
			System.out.println("Enter a number or END to end");
			aLine = theKeyboard.nextLine(); // get a line of input from the user
			// cannot use == to compare strings - you learn why on Monday
			// use .equals() method to compare strings
			if (aLine.equals("END")) {  // if they enter the word END
				break;             // break out of the loop
			}

			// if we get here they did not enter the word END

			sum = sum + Integer.parseInt(aLine);    // add to sum the number entered converted to a numeric int


		}  // end of the while loop
		System.out.println("The sum of the numbers entered if: " + sum);








	}

}
