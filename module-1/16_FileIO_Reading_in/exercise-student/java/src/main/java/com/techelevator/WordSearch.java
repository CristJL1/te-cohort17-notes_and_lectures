package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {


		File fileToSearch = new File("alices_adventures_in_wonderland.txt");

		Scanner scannerForSearch = new Scanner(fileToSearch);

		String searchResult = "";

		while (scannerForSearch.hasNextLine()) {
			searchResult = scannerForSearch.nextLine();

			System.out.println(searchResult);

			System.out.println(searchResult.lines("dog");
		}








	} // ends main ()

} // ends class containing main()
