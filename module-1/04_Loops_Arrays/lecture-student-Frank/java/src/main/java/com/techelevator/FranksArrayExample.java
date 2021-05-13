package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program");


		int score1 = 10;
		int score2 = 20;
		int score3 = 30;
		int score4 = 40;   // added after program was coded
		int score5 = 50;    // added after program was coded

		int sum = 0;   // hold the sum of the scores

		double avg = 0;   // hold the average of the scores

		sum = score1 + score2 + score3 + score4 + score5;    // a change in the data requires a change in the code

		avg = sum/5;   //  a change in the data requires a change in the code

		// this code is tightly coupled because a change in the data requires a change to the code
		//
		// tightly coupled code is considered a bad programming practice due to one possibly forgetting
			// to change some code which depended on the data - lead to invalid processing

		System.out.println("Sum of the scores is: " + sum);

		System.out.println("Average of the scores is: " + avg);

// ---------------------------------------------------------------------------------------------------------------------

		// use an array to hold and process our scores - make the code loosely coupled (not tied to the data)
		// loosely coupled code means the code is not directly tied to the data
		// 		so changes to the data don't require changes to the code
		//		also a sign of a professional programmer

		//define an empty array to hold scores and put the values in it later

//		int[] myScores = new int[5];  // define an empty array of 5 ints (changed to 5 after coding was done)
//
//		myScores[0] = 10;   // set first element in the array to 10
//		myScores[1] = 20;   // set second element in the array to 20
//		myScores[2] = 30;   // set third element in the array to 30
//		myScores[3] = 40;   // set fourth element in the array to 40
//		myScores[4] = 50;   // set fifth element in the array to 50
//
		//define an array and initialize it to known values at the same time

		// code the values inside {} separated by commas instead of new datatype[number-elements]

		int[] myScores = {10,20,30, 60, 70, 90, 58}; // define and initialize an array - Java figures out the number of elements

//		// myScores.length = the number of elements in the array (5)
//		// myScores.length - 1 = the largest valid index [4]

		// use a for-loop to process an array from the beginning to the end

		// a for-loop has 3 parts: for (initialization; condition; increment)

		// initialization - done once at start of the process
		// condition - is checked before each loop - controls how many times the loop is executed
		// increment - done at the end of each loop (just before it goes back and checks the condition)

		// a for-loop will execute the statements in the loop body as long as the condition is true

		// when processing an array: initialization - set loop-index to 0
		//							 condition - loop as long as the index is inside the array
		//							 increment - add 1 to index

		// for (int i=0; i< arrayName.length; i++)
		//		define and set the loop-index to 0 - start at the first element in the array
		//		i < arrayName.length - keep the index inside the array (max value for i is length-1)
		//		i++ - increment i (add 1 to loop index)

		int total = 0;  //hold the sum total of all value in the array
		double average = 0; // hold the average of the values in the array

		// loop through the array adding each element to total

		for (int i = 0; i < myScores.length; i++) {  // loop through the array adding each element to total
			total = total + myScores[i];   // add the current element to the total (i =0, 1, 2) as we run; i starts at 0
		}
		average = total / myScores.length;  // divide the sum of elements by the number of elements

		System.out.println("Total of array elements is: " + total);
		System.out.println("Average of array element is: " + average);

		// by using an array and the for-loop with the .length value the code is loosely coupled
		// adding and removing elements does not require coding changes

	}   
   
}