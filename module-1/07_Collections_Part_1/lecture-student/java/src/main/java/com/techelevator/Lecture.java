package com.techelevator;

// IntelliJ may automatically provide the imports for classes you are using
// not all IDE will do this

import java.awt.*;
import java.util.ArrayList;   // give me access to the code to support  ArrayList class
import java.util.Collections;  // give me access to the code to support Collection class
import java.util.List;  // give me access to the code to support List class

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		// ArrayList is a collection class that allows us a more flexible type of array
		//		variable size, add/remove elements anywhere in the list, access it using methods
		// the elements are stored in the order they are added when you use .add()
		// an ArrayList is a type of list class object

		// 2 common ways to define an ArrayList:

		// ArrayList<data-type> name = new ArrayList();
		// List<data-type> name = new ArrayList();  // more about using this style next week

		// <data-type> is the type of data to be store in the Array LIst (cannot be primitive type)

		// Define a new ArrayList to hold Strings

		ArrayList<String> names = new ArrayList();  // Instantiate an empty ArrayList object

		// .add() method will add elements to the end of the ArrayList

		names.add("Frank"); // add "Frank" to the ArrayList
		names.add("Dana");  // add "Dana" to the ArrayList
		names.add("Alex");
		names.add("Vanese");
		names.add("Jared");

		// names.add(1) gives an error because the ArrayList is defined to hold strings and 1 is NOT a string

		// .size() will return the current number of elements in an ArrayList

		System.out.println("Our ArrayList contains " + names.size() + " elements");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// .get(index) will return the element at the index specified from the ArrayList - index always starts at 0

		System.out.println("The first element is: " + names.get(0));
		System.out.println("The third element is: " + names.get(2));
		System.out.println("The last element is: " + names.get(names.size()-1));  // index of last element is always .size() - 1

		// We can use a for-loop with .get() to process all the elements in an ArrayList from beginning to end

		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Frank"); // we can add a duplicate value to the ArrayList

		System.out.println("--------------------------------------------------");

		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		// .add(index, object) will add an object to anyplace in the array list - index is where you want it

		names.add(3, "Jess"); // add "Jess" at element index 3
		names.add(3, "Amber"); // add "Amber" at element index 3

		System.out.println("--------------------------------------------------");

		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");


		// .remove(index) will remove the element at the index from the ArrayList

		names.remove(0); // remove the element at index 0

		System.out.println("--------------------------------------------------");

		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		// .contains(object) will return true if the object is in the ArrayList

		System.out.println("Is Amber in the list? " + names.contains("Amber"));
		System.out.println("Is Vanese in the list? " + names.contains("Vanese"));
		System.out.println("Is John in the list? " + names.contains("John"));


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");


		// .indexOf(object) will return the index of the first occurrence of the object in the ArrayList


		System.out.println("Jess is at index: " + names.indexOf("Jess"));
		System.out.println("Alex is at index: " + names.indexOf("Alex"));
		System.out.println("John is at index: " + names.indexOf("John"));

		// if "Frank" is in the ArrayList delete him

		// .remove(index) will remove the element at the index
		//.indexOf(object) will return the index of the object in the ArrayList
		// we can nest the method calls to achieve our result

		if (names.contains("Frank")) {  // if "Frank" is in the ArrayList
			names.remove(names.indexOf("Frank")); // find where "Frank" is in the ArrayList and remove him
		}

		System.out.println("--------------------------------------------------");

		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}



		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");


		// .toArray(new data-type[0]) - convert the ArrayList to an array of the datatype after new

		// this is useful when a function needs an array and you have an ArrayList

		String[] namesArray = names.toArray(new String[0]); // convert the ArrayList to an array


		// NOTE: length for an array is a property so no () follow it
		//		 size() for an ArrayList is a method so () follow it
		//		 length() for a String is a method so () follow it
		// methods always have ()

		// a property is a value automatically defined by Java that is related to a Java data structure

		// whenever you see a word followed by () it's a method, except for things like if, for, and while

		System.out.println("--------------------------------------------------");

		for (int i = 0; i < namesArray.length; i++) {
			System.out.println("Element at index #" + i + " is: " + namesArray[i]);
		}


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");


		// Collections.sort(ArrayList) - will sort an ArrayList
		// .sort() is a member of the collections class so it can be used with any collection class
		//							  ArrayList, Queue, Stack are members of the collection class

		// Collections.sort(name) - it will sort alphabetically because it contains Strings
		//							it uses the sort/collating sequence for the coding of the characters

		Collections.sort(names); // sort the ArrayList

		System.out.println("--------------------------------------------------");

		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");


		// Collections.reverse(ArrayList) - reverse the order of the elements in the ArrayList

		Collections.reverse(names); // reverse the order of the ArrayList

		for (int i = 0; i < names.size(); i++) {
			System.out.println("Element at index #" + i + " is: " + names.get(i));
		}


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		// for-each loop is a shorthand for-loop when you want to go from the beginning to the end of an array/ArrayList
		//
		// for-each loops ALWAYS goes from the beginning to the end one element at a time
		// you have no way of knowing in the loop the index or location of the current element
		// you cannot skip elements in the for-each loop
		//
		// a for-each is less flexible than a regular for-loop, but the for-each loop is easier to code
		//
		// for (data-type element-name: array/ArrayList name) - format for a for-each loop
		//
		// the data-type is the data-type of the array/ArrayList
		// each time through the loop, the element-name contains the current element
		//
		// use the element-name to reference the element from the array inside the loop

		// use a for-each loop to display all the elements in our ArrayList

		System.out.println("--------------------------------------------------");

		for (String anElement: names) {
			System.out.println("Element from ArrayList: " + anElement);
		}

		// the for-each does the same thing as this:
		// for (int i = 0; i < names.size(); i++) {
		// 		System.out.println("Element at


	}
}
