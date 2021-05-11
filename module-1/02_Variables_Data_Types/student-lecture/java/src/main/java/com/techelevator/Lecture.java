/*
this is a block comment which starts with slash-asterisk and ends with asterisk-slash
 */








package com.techelevator;       // define the start of a package called 'com.techelevator'
								// a package is a group of related Java code

public class Lecture {  //define the class to hold the group of related things for our applications

	public static void main(String[] args) {  //This is the start of the main function for our applications
		// System.out - defined by Java to represent the screen
		// .println() - function that tells System.out to display whatever is inside the ()
		// " " - used to define a string of characters
		System.out.println("Hello Java Class");  //Display the words inside the " " on the screen

		// variables are used to hold date for a program
		// variables in Java are assigned a specific type of data they will hold

		// to define a variable in Java - datatype name = initial-value;


		// Choose a data type based on what you want it to hold:

		// if numeric without decimal places, use int
		// if numeric with decimal places, use double
		// if single character, use char
		// if true/false, use boolean
		// if multiple characters, use String - String is a special type in Java

		// avoid float if at all possible - double is better
		// if the number has no decimal places and is outside the range of +/- 2 billion, use long



		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
//	datatype  name            = initial-variable
		int numberOfExercises = 26;

		System.out.println("numberOfExercises is : " + numberOfExercises);  //display the String and the contents of variable numberOfExercises

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/

		double half = 0.5;

		System.out.println("The variable half contains the value of " + half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/

		String name = "TechElevator";

		System.out.println("name is: " + name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/

		int seasonsOfFirefly = 1;

		System.out.println("There were " + seasonsOfFirefly + " seasons of Firefly");

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/

		String myFavoriteLanguage = "Java";

		System.out.println("I love " + myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/

//      double    = double    - data types must match on both sides of the equal sign
		double pi = 3.1416;  // 3.1416 is considered a double because we didn't say it was anything else
		System.out.println("Pi = " + pi);

//      float       = double     - data types were incompatible on either side of equal sign - a double value may not fit in a float variable
//      float	pi2 = 3.1416;
		float pi2 = 3.1416F;  //Because we want a float we have to identify the number as a float using F
		System.out.println("Pi2 = " + pi2);

// casting tells Java to pretend something is a different datatype for just this  statement

		float pi3 = (float) 3.1416;
		System.out.println("Pi3 = " + pi3); //Because we want a float we have to tell Java to pretend that it's a float by casting it

	/*	long aNum = 23;
		int anotherNumber = (int) aNum; cast the long value that is in aNum to an int so Java can assign it
		*/


		/*
		7. Create and set a variable that holds your name.
		*/

		String myName = "JC";
		System.out.println ("Your name is: " + myName);

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/

		int mouseButtons = 2;
		System.out.println ("My mouse has " + mouseButtons + " buttons.");

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/

		double pctBatteryLeft = .70;
		int howMuchBatteryLeft = 70;

		System.out.println("pctLife = " + pctBatteryLeft + " howMuch = " + howMuchBatteryLeft);

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/

		int diff = 121-27;

		System.out.println("diff = " + diff);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/

		double sum = 12.3+32.1;  // + with numerics means add

		System.out.println("sum = " + sum);  // 44.40000000006 is displayed due to the conversion of double (binary type) to a decimal
											// internally a double and float are stored in binary format (a bunch of 1s and 0s)
											// fractions are stored as binary points not decimal points
											// some binary point values cannot be directly converted to decimal point values
											// so approximations of the decimal values are sometimes done when displaying
											// the value is still correct inside the code, it just displays as an approximation
											// we will learn how to make it display correctly later this week

		/*
		12. Create a String that holds your full name.
		*/

		String fullName = "Jess J. Java";

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/

		String greeting = "Hello " + fullName;  // + with string means concatenate
		System.out.println("newString: " + greeting);

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/

		fullName = fullName + " Esquire";  // you can store new values into an existing variable

		System.out.println("the value of fullName is: " + fullName);



		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/

		fullName += " Esquire";  // if you assign back in to the same variable you can use the shorthand assignment operators

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/

		String movieTitle = "Saw " + 2;  // if you concatenate a String + a non-String it converts the non-String to a String automatically

		System.out.println("title = " + movieTitle);

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/

		movieTitle += "0";  // can use a String to concatenate or can use a non-String
		movieTitle += 0;

		/*
		18. What is 4.4 divided by 2.2?
		*/

		System.out.println("4.4 / 2.2 = " + 4.4/2.2);  // you can code an expression for System.out.println

		/*
		19. What is 5.4 divided by 2?
		*/

		System.out.println("5.4 / 2 = " + 5.4/2);

		/*
		20. What is 5 divided by 2?
		*/

		System.out.println("5 / 2 = " + 5/2);  // int/int - result is int - integer arithmetic returns (2)
													// an int quotient and an int remainder

		/*
		21. What is 5.0 divided by 2?
		*/

		System.out.println("5.0 / 2 = " + 5.0/2);  // double / int - result is a double (2.5)
													// double/double - Java converts the int to a double to do the arithmetic

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/

		System.out.println("66.6 / 100 = " + 66.6/100);  // result is .66599999999999 - binary point / decimal point conversion issue


		/*
		23. If I divide 5 by 2, what's my remainder?
		*/

		System.out.println("5/2 remainder = " + 5 % 2);

		/*
		24. What is 1,000,000,000 * 3?
		*/

		System.out.println("1 billion * 3 = " + 1000000000 * (long) 3);  // 3 billion exceeds the maximum size of an int
																	// we need to cast one of the operands to be a long
																	// int * long - converts answer to a long

		System.out.println("1 billion * 3 = " + 1000000000 * 3L);  // explicitly tell Java the 3 is a long value

		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/

		boolean doneWithExercises = false;  // boolean values do not have quotes

		System.out.println("done = " + doneWithExercises);

		/*
		26. Now set doneWithExercise to true.
		*/

		doneWithExercises = true;

		System.out.println("done = " + doneWithExercises);

	} // end of main() function

}  // end of Lecture class
