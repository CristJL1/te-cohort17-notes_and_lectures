package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner userInput = new Scanner(System.in);

		System.out.println("Where is your file located? ");

		String fileLocation = userInput.nextLine();

		System.out.println("What word would you like to search for? ");

		String searchWord = userInput.nextLine();

		System.out.println("Is your search case sensitive? Y\\N");

		String caseSensitiveInput = userInput.nextLine();

	//	File fileToSearch = new File("alices_adventures_in_wonderland.txt");
		//		location if you want to search in "Alice's Adventures in Wonderland"
	//  File fileToSearch = new File("./java/src/test/resources/dr_jekyll_mr_hyde.txt");
		//		location if you want to search in "Dr. Jeykll and Mr. Hyde"

		File fileToSearch = new File(fileLocation);

		Scanner scannerForSearch = new Scanner(fileToSearch);

		String searchResult = "";

		int lineNumber = 0;


		while (scannerForSearch.hasNextLine()) {

			searchResult = scannerForSearch.nextLine();

			lineNumber++;

			String [] wordsInDoc = searchResult.split(" ");

			for (String searchWordReturn : wordsInDoc) {
				if (caseSensitiveInput.equals("Y") || caseSensitiveInput.equals("y")) {
					if (searchWordReturn.contains(searchWord)) {
						System.out.println(lineNumber + ") " + searchResult);
					}

				}
				else if (caseSensitiveInput.equals("N") || caseSensitiveInput.equals("n")) {
					if (searchWordReturn.toLowerCase().contains(searchWord.toLowerCase())) {
						System.out.println(lineNumber + ") " + searchResult);
					}
				}
			}

		}

	} // ends main ()

} // ends class containing main()
