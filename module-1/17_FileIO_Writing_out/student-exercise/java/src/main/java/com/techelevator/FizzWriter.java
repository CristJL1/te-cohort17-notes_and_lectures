package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) throws IOException {



		File outputFile = new File("FizzBuzz.txt"); // create the file

		if (outputFile.exists()) { // if the file exists always create a new one to overwrite it
			outputFile.createNewFile();
		}

		FileWriter theFileWriter = new FileWriter(outputFile);

		BufferedWriter aBufferedWriter= new BufferedWriter(theFileWriter);
		PrintWriter diskFileWriter = new PrintWriter(aBufferedWriter);

		int fizzBuzzNumber = 0;

		while (fizzBuzzNumber < 300) {

			for (int i = 0; i < 300; i++) {
				fizzBuzzNumber = fizzBuzzNumber + 1;

				if (fizzBuzzNumber % 3 == 0 && fizzBuzzNumber % 5 == 0) { // return "FizzBuzz if the number is divisible by 3 and 5
					diskFileWriter.println("FizzBuzz");
				} else if (Integer.toString(fizzBuzzNumber).contains("3") && Integer.toString(fizzBuzzNumber).contains("5")) { // return "Fizz Buzz" if the number contains a 3 and a 5 but isn't divisible by both
					diskFileWriter.println("Fizz Buzz");
				}
				else if (fizzBuzzNumber % 3 == 0 || Integer.toString(fizzBuzzNumber).contains("3")) { // return "Fizz" if the number contains a 3
					diskFileWriter.println("Fizz");
				} else if (fizzBuzzNumber % 5 == 0 || Integer.toString(fizzBuzzNumber).contains("5")) { // return "Buzz" if the number contains a 5
					diskFileWriter.println("Buzz");
				} else {
					diskFileWriter.println(fizzBuzzNumber);
				}
			}
		}


	diskFileWriter.close(); // to prevent resource leak

	System.out.println("FizzBuzz.txt has been created."); // output to the user to show file was created

	}

}
