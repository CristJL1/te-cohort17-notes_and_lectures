package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */

		/* Create a new instance of a String Literal ( a literal is a value that says what it is)
		 *
		 * 2 ways to define a new String Literal
		 *
		 * 		String name = new String(); // create a new empty string
		 *
		 * 		String name = "some value"; // create a new string containing the value
		 *
		 *  A String Literal is enclosed in double quotes " "  - a series of one or more characters
		 *
		 *  A char literal is enclosed in single quotes ' ' - a SINGLE Character - only 1 character
		 *
		 * A String is NOT a char and a char is NOT a String

		 */

		String softDrink = "Mr. Pibb";  // assign a literal to a String

		String beverage = softDrink + " by Coca-Cola"; // + with a String means concatenation

		System.out.println(beverage);   // Strings can be displayed just by using their name



//--------------------------------------------------------------------------------------------------------		
		System.out.println();
		System.out.println("******************************");
		System.out.println("**** STRING MEMBER METHODS ***");
		System.out.println("******************************");
		System.out.println();

		/*
		 *
		 * String is a class - class names start with a capital letter
		 *
		 * A Class is a description of what an object should look like and what is should/can do (it's behavior)
		 *
		 * an object is an instance of a class
		 *
		 * a cake recipe is a description of how to make a cake - it is NOT the cake; a Class is NOT an object
		 * 		ingredients (data) and process (what to do)
		 *
		 * the cake you make is an instance of the recipe
		 * 		cake is the object and recipe is the class
		 *
		 * A Class contains methods to interact and manipulate objects of the Class
		 *
		 * A method is a function associated with a class
		 *
		 * a member method is a method belonging to a specific class
		 *
		 * to use a method for a class: anObjectForTheMethod.methodName(parameters)
		 *
		 */

		/* Commonly used methods:  stringName.methodName(parameters)
		 *
		 * .length() - return the number of characters in a String
		 * .charAt(index) - returns the character at the index - 0 is first character
		 * .endsWith(search-string) - return true if the String ends with the search-string 
		 * .startsWith(search-string) - return true if the String starts with the search-string
		 * .indexOf(search-string) - return the index of the start of the 1st occurrence of search-string in the String
		 * .lastIndexOf(search-string) - return the index of the start of the last occurrence of search-string in the Stri
		 * .substring(start-index) - return from the start-index to rest of String
		 * .substring(start-index,end-index) - return from the start-index to the end-index (but not the char at end-index)
		 * .toLowerCase() - return the String in all lowercase
		 * .toUpperCase() - return the String in all uppercase
		 * .trim() - return the String with spaces removed from beginning and end of the String
		 * .split(delimiter) - returns and array of strings containing the characters between the delimiter specified
		 */

//          indexes:   0123456789         - use index to refernce individuals chars using charAt()
		String name = "Strong Bad";

		System.out.println("The variable name contains: " + name);
		System.out.println("The number of characters in name is: " + name.length());

		System.out.println("The first character in name is: " + name.charAt(0));   // indexes start at 0
		System.out.println("The second character in name is: " + name.charAt(1));
		System.out.println("The ninth character in name is: " + name.charAt(8));

		System.out.println("Name in all uppercase is: " + name.toUpperCase());
		System.out.println("Name in all lowercase is: " + name.toLowerCase());

		System.out.println("Does name start with Strong? " + name.startsWith("Strong"));
		System.out.println("Does name start with B? " + name.startsWith("B"));
		System.out.println("Does name end with Bad? " + name.endsWith("Bad"));
		System.out.println("Does name end with d? " + name.endsWith("d"));

		System.out.println("Where does Bad start in name? " + name.indexOf("Bad"));
		System.out.println("Where does Strong start in name? " + name.indexOf("Strong"));
		System.out.println("Where does strong start in name? " + name.indexOf("strong"));  // -1 is returned if the string is not in there

		System.out.println("Where does the last a start? " + name.lastIndexOf("a"));

		//substring allows the extraction of a String from inside a String

		System.out.println("Here is the Bad from name: " + name.substring(7));  // start at index 7 and go to the end
		System.out.println("Here is the Strong from name: " + name.substring(0,6)); // start at index 0 to 6, but not what's at index 6


		String answer = "                     Here is the answer                   ";
		System.out.println("The value in answer is: " + answer + " and the end of it");
		System.out.println("The value in answer using trim is: " + answer.trim() + " and the end of it");

		String person = "Chester Elegante, Esq.";

		// display each word in the variable person - words are separated by spaces
		// scan the variable and split it at the spaces
		//
		// .split(delimiter) - returns and array of strings containing the characters between the delimiter specified
		// Define an array of Strings to hold the result of .split()

		System.out.println();
		System.out.println("**************************");
		System.out.println("****** USING .split ******");
		System.out.println("**************************");
		System.out.println();

		String[] words = person.split(" "); // split the String in person based on the spaces and store the results in the String array words

		// go through the array of words and display each one
		// arrays always use for-loops

		for (int i=0; i < words.length; i++) {
			System.out.println("Word #" + i + " is: " + words[i]);
		}


		// Break apart the value in variable person to get his name and title
		// There is a comma in the value that separates the name and the title

		words = person.split(",");

		System.out.println("The name is: " + words[0] + " and the title is: " + words[1].trim());







//--------------------------------------------------------------------------------------------------------	
		
		/*   A String may also be created easily from an array of characters (char) */

		char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' }; // Array of characters (String)
		
		String hello1 = new String(helloArray);  // Create a String using the array of characters
		String hello2 = new String(helloArray);  // Create a String using the array of characters
		
//--------------------------------------------------------------------------------------------------------			
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */

		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

//--------------------------------------------------------------------------------------------------------			



	}
}
