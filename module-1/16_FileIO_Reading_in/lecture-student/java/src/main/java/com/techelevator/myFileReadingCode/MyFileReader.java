package com.techelevator.myFileReadingCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {
	// since the function contains the File I/O statements
	// and File I/O may cause exceptions to happen (we discuss this tomorrow)
	// we have to tell Java we know that an exception may happen in the function
	//
	// adding the throws specification on the function header tells Java we know that this type of exception could happen
	//
	//					throws = I know I might have this type of exception
	public static void main(String[] args) throws FileNotFoundException {

		// define a file object for the file on our computer we want to read
		// provide a path to the file when defining a File object
		//
		// paths can be: absolute - code all the parts from the root folder of your OS (Windows)
		//
		// paths can be: relative - code the part from the assumed current position to the file
		//
		// absolute paths should be avoided - they tightly couple the program to the directory structure it was created on
		//											if the program is run on a machine with a different directory structure it won't work
		//												because the absolute path doesn't exist in a different directory structure
		//
		// relative paths are preferred because you have loosely coupled the file to the directory structure
		//			it is more likely that the relative paths will be the same from machine to machine
		//
		// path: . = current directory
		//		/ = then (sub-directory or file follows)
		//		numbers.txt - file name

		File theFile = new File("./data/numbers.txt"); // give the File object the path to our file

		// define a scanner for the File object we created for the file on our computer
		Scanner scannerForFile = new Scanner(theFile); // give Scanner the file object we created

		String aLine = ""; // hold a line of input from the file


		int sum = 0; // hold the sum of the numbers in a line

		// if we want to get all the lines in the file
		// we need to go through and get each line in the file one at a time
		// but we can't get a line from the file if there are no more lines in the file
		// we can use the Scanner class hasNextLine() method to see if there is another line in the file
		// we can set a loop to get a line from the file and process it as long as there are lines in the file
		// we will use while loop since we want loop based on a condition (as long as there are line in the file)
		// 			and not a count of lines in the file, in which case we would use a for-loop
		//				for-each-loops only work for collection classes

		// add up each line from my file
		// the file has one or more numbers separated by a single space in each line

		while (scannerForFile.hasNextLine()) { // loop while there ia a line in the file

			aLine = scannerForFile.nextLine(); // get a line from the file and store it in aLine

			// break apart the numbers in the line based on spaces
			// String .split() will create an array of Strings of the values separated by the delimiter

			String[] theNumbers = aLine.split(" "); // break apart the numbers in the line based on spaces

			System.out.println("Line from the file: " + aLine); // display the line from the file

			// reset teh sum to 0 to clear it of the value from the last time through the loop
			sum = 0;

			// loop through the array of Strings holding the numbers from the line in the file

			for (String aNumber : theNumbers) { // aNumber will hold the current element that is in the array
					sum = sum + Integer.parseInt(aNumber); // add the number to a sum after converting the String to an int
			}

			// now that we have the sum, we can display it

			System.out.println("Sum of the numbers is: " + sum);
			System.out.println("Average of the numbers is: " + sum / theNumbers.length);

		} // end of while loop


		
} // end of main ()
} // end of class containing main()