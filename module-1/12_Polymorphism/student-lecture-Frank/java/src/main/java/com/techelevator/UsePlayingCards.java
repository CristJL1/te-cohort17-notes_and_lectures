package com.techelevator;

import java.util.ArrayList;

public class UsePlayingCards {
// this is our application program which will instantiate objects and use their methods to manipulate them
	// we know this is the application program because it has the main() method
	public static void main(String[] args) {
		
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");
		System.out.println("aUSACard is :");
		aUSACard.showCard(); // runs the AmericanPlayingCard showCard()

		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES");
		System.out.println("aUSACard2 is :" );
		aUSACard2.showCard();
		
		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES");
		System.out.println("aUSACard3 is :");
		aUSACard3.showCard();
			
		AmericanPlayingCard aUSACard4 = new AmericanPlayingCard(11, "JOHN");
		System.out.println("aUSACard4 is :");
		aUSACard4.showCard();
		
		ItalianPlayingCard anItalianCard1 = new ItalianPlayingCard(13, "SWORDS");
		System.out.println("anItalianCard1 is :");
		anItalianCard1.showCard(); // runs the ItalianPlayingCard showCard()
		
		ItalianPlayingCard anItalianCard2 = new ItalianPlayingCard(9, "COINS");
		System.out.println("anItalianCard2 is :");
		anItalianCard2.showCard();
		
		ItalianPlayingCard anItalianCard3 = new ItalianPlayingCard(11, "DANIEL");
		System.out.println("anItalianCard3 is :");
		anItalianCard3.showCard();
		
		SwissPlayingCard aSwissCard1 = new SwissPlayingCard(13, "ROSES");
		System.out.println("aSwissCard1 is :");
		aSwissCard1.showCard(); // runs the SwissPlayingCard showCard()
		
		SwissPlayingCard aSwissCard2 = new SwissPlayingCard(9, "SHIELDS");
		System.out.println("aSwissCard2 is :");
		aSwissCard2.showCard();
			
		SwissPlayingCard aSwissCard3 = new SwissPlayingCard(10, "ACORNS");
		System.out.println("anSwissCard3 is :");
		aSwissCard3.showCard();
			
		SwissPlayingCard aSwissCard4 = new SwissPlayingCard(11, "JOHN");
		System.out.println("anSwissCard4 is :");
		aSwissCard4.showCard();


		System.out.println("\n ----------------------Polymorphism Examples Start Here ------------------------");

		PlayingCard aCard; // define an object of the superclass


		aCard = aUSACard; // assign a subclass object to the superclass object
		aCard.showCard(); // use the superclass object to invoke a method - run the showCard() for the object IN aCard

		aCard = anItalianCard1; // assign a subclass object to the superclass object
		aCard.showCard(); // use the superclass object to invoke a method - run the showCard() for the object IN aCard

		aCard = aSwissCard1; // assign a subclass object to the superclass object
		aCard.showCard(); // use the superclass object to invoke a method - run the showCard() for the object IN aCard


		ArrayList<PlayingCard> myCards = new ArrayList(); // defined an ArrayList of superclass objects

		myCards.add(anItalianCard1); // add subclass objects to my ArrayList of superclass objects
		myCards.add(aUSACard);
		myCards.add(aSwissCard1);
		myCards.add(aUSACard2);

		System.out.println("\n ---------Here come the elements from the ArrayList-----------");

		// display all the objects in my ArrayList - Polymorphism will cause the correct showCard() for the element to be run

		for (PlayingCard theCard : myCards) { // define a superclass object as element in the for each
			theCard.showCard();					// use the element in the for each to invoke the methods
		}

		System.out.println("\n -------Using a function to display a card---------\n");
		displayCard(aSwissCard3); // call the function to display our card
		displayCard(anItalianCard2);


	} // end of main
	// this must be static because what calls it is static
	static void displayCard(PlayingCard cardyMcCardCard) { // a function receives a superclass object
		cardyMcCardCard.showCard(); // use the superclass object to run a method - Polymorphism will run the correct method for the class
	}

} // end of class that holds main
