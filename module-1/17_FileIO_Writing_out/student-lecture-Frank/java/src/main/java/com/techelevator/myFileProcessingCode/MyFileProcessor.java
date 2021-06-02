package com.techelevator.myFileProcessingCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFileProcessor {

	/*********************************************************************************
	 * This program will read each line from the numbers.txt file
	 * and write each number in the line and the sum of those numbers to a file
	 * 
	 * Each line in the file contains one or more numbers separated by commas
	 * 
	 * @throws FileNotFoundException 
	 *********************************************************************************/
	
	public static void main(String[] args) throws IOException {

		// define a File object for the output file we want to create and write to
		// we want the file in the application data folder
		// we want to call it "outputFileMcFileFile.txt"
		File theOutputFile = new File("./data/outputFileMcFileFile.txt");

		// tell Java to actually create the file in the file system
		theOutputFile.createNewFile(); // allocate a new file - any existing version is destroyed

		//define a PrintWriter for the File object that represents our output disk file
		PrintWriter fileWriter = new PrintWriter(theOutputFile);
		
		// Define the input file and Scanner object to read it - file is in the data folder of the project folder
		File myFile = new File("./data/numbers.txt");  // Assign a File object to numbers.txt

		// Check to be sure the File Object is assigned an existing file - terminate if not
		// .exists() - is the path specified a name in the file system
		// .isFile() - is the name the name of a file in the file system
		// since we can only read files in a Java program - we want to be sure the path we have is a file
		// if the path does not exist or the path is not a file - terminate the program with a message
		if (!myFile.exists() || !myFile.isFile()) {
			System.out.println("path specified is not an existing file");

			// there are 2 ways to terminate a program/method/function:
			// 1. a return statement - return to the caller of the method/program/function
			// 2. System.exit(value) - return to the operating System - all programs in the callstack are terminated
			//							with the value specified in the () - a return code
			//							return codes may be checked by scripting languages that execute applications
			//							the meaning of return codes is up to the script that checks them
			//							in general return codes are multiples of 4
			//								0 - usually means no errors and a program was successful
			//								4 - usually means there were minor errors but the program was still successful
			//								8 - usually means a serious error, the program completed but the result may be incorrect
			//								12 - usually means a severe error, program completed, but NOT successfully
			//								16 - usually means a catastrophic error, program did not do much of anything
			System.exit(16);   // terminate program with a return code of 16 - whatever that means
		}
		
		Scanner theFile = new Scanner(myFile);         // Assign the File Object to a Scanner
		
		int lineTotal  = 0;  // hold the sum of the numbers in the line we read
		String theLine = ""; // hold the line with the numbers from the file
		
		// Loop through the file one line at a time while there are lines in the file
		while(theFile.hasNextLine()) {
			// Read a line from the file and store it in theLine
			theLine = theFile.nextLine();
			// Break the line up into separate values based on the , separating the value
			String[] theValues = theLine.split(",");
			//    For each value in the line...
			for(int i=0; i < theValues.length; i++) {
				// Convert the individual value from String to numeric so we can add them
				// we can only do arithmetic with numeric values
				// the data from the file is a String
				// so to do arithmetic with data from the file it needs to be converted to numeric value
				// Integer.parseInt(String) to convert to an int
				// Double.parseDouble(String) to convert to a double
				int aValue = Integer.parseInt(theValues[i]); // convert the String value to an int
				// Add each value from the line to sum
				lineTotal += aValue;
				// write the values in the line to our output file using the PrintWriter object
				fileWriter.println("Input Line Value[" +i+"] is: " + aValue);
			}
		//    write the sum of the values to our output file using the PrintWriter object
			fileWriter.println("The sum of the values in the line is: " + lineTotal);
		//    Reset sum before looping again to be sure we only get the sum of the numbers in the line
		    lineTotal = 0;
		}
		// Close the output file to avoid a resource leak and force any output to be written to the disk
		// when data is written from a program to a disk it is held in memory called a buffer
		// the memory buffer is allocated/created when you instantiate the file object (open the file)
		// the memory buffer is written to the disk only when it gets full and you try to write more
		// 		or the file is closed
		// failure to close a output disk file may leave data in memory not written to the disk
		// ALWAYS be sure an output disk closed when you are done writing to it (end of program)
		fileWriter.close();
	}
}