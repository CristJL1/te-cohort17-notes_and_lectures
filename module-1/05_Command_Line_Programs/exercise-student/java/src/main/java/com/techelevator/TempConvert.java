package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);  // allows keyboard to be used to input values

		String tempInput = "";  // variable to be used for input value

		String tempType = "";

		System.out.println("Please enter a temperature: ");  // prompt user to enter temperature

		tempInput = keyboard.nextLine();  //

		// System.out.println("Your Temperature: " + tempInput) ;  // user should see the message and their input number here

		System.out.println("Is your temperature in (F)ahrenheit or (C)elsius? : ");  // prompt to get user to input temp type

		tempType = keyboard.nextLine();

		// System.out.println("Your Temperature Type: " + tempType);

		if (tempType.equals("F") || tempType.equals("Fahrenheit")) {
			int tempOutputC = (Integer.parseInt(tempInput) - 32) * 5/9;

			System.out.println(tempInput +"F is " + tempOutputC + "C");
		}
		else if (tempType.equals("C") || tempType.equals("Celsius")) {
			int tempOutputF = (Integer.parseInt(tempInput) * 9/5) + 32;

			System.out.println(tempInput + "C is " + tempOutputF + "F");
		}
		else {
			System.out.println("User ID10T Error : Unusable Temperature Type");
		}





	}

}
