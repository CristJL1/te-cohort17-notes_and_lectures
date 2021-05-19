package com.techelevator;


import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Map is a Collection class to store and access key-value pairs

		// key - a unique identifier to associate with a value
		// value - the data to be associated with a key

		// A Map is also known as an "associative array"

		// the content of the key must be unique
		// the content of the value does not have to be unique

		//Types of Maps

		//		HashMap       - entries are stored in an unknown order
		//		TreeMap       - entries are store in key sequence order
		//		LinkedHashMap - entries are stored in the order in which they were added

		// if you don't care about the order use a HashMap
		// if you wanna store the items in the map in the order they were added use a LinkedHashMap

		// Two common ways of defining a map:

		// Map <key-data-type, value-data-type> nameOfMap = new typeOfMap();

		// typeOfMap <key-data-type, value-data-type> nameOfMap = new typeOfMap();

		// define a HashMap where the key is a string and the value is a string

		// Map<String, String> myMap  = new HashMap();
		// or
		// HashMap<String, String> myMap = new HashMap();
		// or
		// Map<String, String) myMap = new HashMap<String, String>();
		// or
		// HashMap<String, String> myMap = new HashMap<String, String>();


		// define a Map to associate a person's name with where they live - e.g. "Frank" - "Mayfield"
		// key is a String - the person's name
		// value is a String - the name of the place they live

		//   key      value
		//  type      type    map name = new  typeOfMap();

		Map<String, String> residence = new LinkedHashMap();

		// TreeMap stores the entries in key sequence
		// HashMap stores the entries in unknown sequence
		// LinkedHashMap stores the entries in entry sequence

		// add a few people to our map by using .put(content-of-key, content-of-value)

		residence.put("Frank", "Mayfield, OH");
		residence.put("Nia", "Streetsboro, OH");
		residence.put("Anthony", "West Des Moines, IA");
		residence.put("JC", "University Heights, OH");
		residence.put("Dana", "Buffalo, NY");
		residence.put("Daniel", "Buffalo, NY");
		residence.put("Strong Bad", "Free Country, USA");

		// use .get(key) to retrieve an entry from the Map - returns the value associated with the key given or null

		System.out.println("Anthony lives in " + residence.get("Anthony"));
		System.out.println("Nia lives in " + residence.get("Nia"));
		System.out.println("JC lives in " + residence.get("JC"));
		System.out.println("Dana lives in " + residence.get("Dana"));

		String whoWeWant = "Daniel";

		System.out.println(whoWeWant + " lives in " + residence.get(whoWeWant));

		System.out.println("John lives in " + residence.get("John"));

		System.out.println("Frank lives in " + residence.get("Frank"));

		// since the content of a key must be unique in a Map
		// if you try to add an entry with existing key - it updates the value for the existing key - AND DOESN'T TELL YOU
		System.out.println("\n-----------------add Frank living in Highland Heights-----------------------");

		residence.put("Frank", "Highland Heights"); // Frank is already a key in the map

		System.out.println("\n" +"Frank lives in " + residence.get("Frank"));



		// .containsKey(Key) - check to see if a key is already in the Map before we try to add it

		if (residence.containsKey(whoWeWant)) { // check if the key we want to add is already in the map
			System.out.println("\n" + whoWeWant + " is already in the Map - continuing will update the value");
		}
		else { // if whoWeWant is not already in the Map - add them
			residence.put(whoWeWant, "Timbuktu");
		}

		System.out.println("\n---------------------------------------------------------------------");

		// to process all the entries in a Map
		// we need to get all the keys in the Map and use them to access them
		// .keySet() may be used to retrieve all the keys from a Map as a Set object

		// a Set object is a unique set of values from a Collection class

		// 		to define a Set object: Set<data-type> name = something-that-gives-us-a-Set

		Set<String> theKeys = residence.keySet();  // hold all the keys from the Map - keys are String in our Map

		// we can go through the Set of keys once at a time retrieving an entry from the map

		for (String aKey: theKeys) {  // go through the keys one at a time storing the current key in aKey
			System.out.println("Entry in Map for Key: " + aKey + " is: " + residence.get(aKey));  // the value for the current key
		}


		// .remove(key) will remove an entry from the Map for the key given

		residence.remove("Frank");  // remove the entry for the key "Frank" from the Map

		System.out.println("\n" +"Frank lives in " + residence.get("Frank"));



	}

}
