package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class CardDeck {

	// using a queue to hold the deck of PlayingCards
	// a queue is a FiFo data structure
	LinkedList<PlayingCard> deckOfCards = new LinkedList<PlayingCard>();
	private int numCardsInDeck = 54;

	public CardDeck() {
		resetDeck(true); // reset deck with jokers
	}

	public void showDeck() {
		System.out.println("Number of Cards in Deck: " + deckOfCards.size());
		for (PlayingCard aCard : deckOfCards) {
			System.out.println(aCard);
		}
	}

	public boolean anyCardsInDeck() {
		if (deckOfCards.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public PlayingCard dealCard() { // return the first card in the deck, unless it's empty
		if (deckOfCards.size() > 0) {
			return deckOfCards.remove();
		}
		else {
			 return null;
		}
	}

	public void resetDeck(boolean withJoker) { // create a deck of PlayingCards with optional Jokers
		deckOfCards.clear();

		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "CLUBS"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "HEARTS"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "Spades"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "DIAMONDS"));
		}

		if (withJoker) {
			deckOfCards.add(new PlayingCard(0, "JOKER"));
			deckOfCards.add(new PlayingCard(0, "JOKER"));
		}
	}

	public void shuffleDeck() { // using the Collections class shuffle method to randomize the deck of cards
		resetDeck(false); // give me a new deck without Jokers
		Collections.shuffle(deckOfCards); // randomize the cards in the deck
	}

}