package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {

	// given a file containing bank routing numbers, this program will display if they are valid
	// we are NOT going to discuss what is a valid number or how to validate a routing number
	// we are focusing on the reading of the file


	// this array is used to determine a valid routing number
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	// note: the throws specification since we are doing file I/O in the program
	public static void main(String[] args) throws FileNotFoundException {

		printApplicationBanner();

		// get a valid filename from the user and define a file object for it
		File inputFile = getInputFileFromUser(); // get a valid filename from the user and define file object for it

		// we will talk about try tomorrow, it relates to exceptions
		try(Scanner fileScanner = new Scanner(inputFile)) { // define a Scanner object for the File object
			while(fileScanner.hasNextLine()) {				// loop while the file has a next line
				String line = fileScanner.nextLine();		// get the next line from the file
				String rtn = line.substring(0, 9);			// extract the first 9 characters from the line
				System.out.print("RTN : " + rtn);			// display the first 9 characters from the line
				if(checksumIsValid(rtn) == false) {			// check to see if we have a valid routing number
					System.out.println(" - Invalid");		// if we don't, display "Invalid"
				}
					else {
						System.out.println(" - Valid");		// if we do, display "Valid"
				}
			}
		}
	} // end of main()


	// any methods called by main must be coded after the end of main and before the end of
	// these functions are all static because they are called from a static method


	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	// get a valid filename from the user
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in); 			  // define a Scanner object for the keyboard
		System.out.print("Please enter path to input file >>> "); // prompt the user for what we want them to enter
		String path = userInput.nextLine();						  // get the response from the user
		System.out.println("Path entered: "+ path + "\n");		  // display what the user entered
		File inputFile = new File(path);						  // define a File object for the path the user gave us

		// .exists() will return whether the path or the File object exists in the current file structure
		if(inputFile.exists() == false) { 						  // checks for the existence of a file
			System.out.println(path+" does not exist"); 		  // if it doesn't exist = print a message
			System.exit(1); // Ends the program       	  // exit the program with a return code 1 (more tomorrow)

			// .isFile() returns whether the path for a File object is a file
		} else if(inputFile.isFile() == false) { 				  // if the path does exist, is it a file?
			System.out.println(path+" is not a file"); 			  // if not a file - display a message
			System.exit(1); 								  // Ends the program with return code 1 (more tomorrow)
		}
		return inputFile; // if the user input was an existing file name, return the file object we created for it
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
} // end of the class that holds main()
