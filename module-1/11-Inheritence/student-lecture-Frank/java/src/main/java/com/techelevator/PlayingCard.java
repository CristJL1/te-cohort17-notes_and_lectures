package com.techelevator;

/***************************************************************************************
 * Generic Playing Card Class
 ***************************************************************************************/
public class PlayingCard {
	/***************************************************************************************
	 * Member Instance Variables - Each instance of the class gets a set
	 ***************************************************************************************/
	private int    value;       // Card value
	private String color;       // Card color  
	private String suit;        // Card suit 

	/***************************************************************************************
	 * 3-arg constructor when user uses value, suit and color to instantiate 
	 ***************************************************************************************/
	
	public PlayingCard(int value, String suit, String color) {
		this.value = value;
		this.suit  = suit;
		this.color = color;
	}

	/***************************************************************************************
	 * Getters - allow users to "see" the values in a Playing Card object
	 ***************************************************************************************/
	public int getValue() {
		return value;
	}
	public String getColor() {
		return color;
	}
	public String getSuit() {
		return suit;
	}
	/***************************************************************************************
	 * Setters - allow users to change the values in a Playing Card object
	 ***************************************************************************************/
	public void setValue(int value) {
		this.value = value;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	/***************************************************************************************
	 * Java does not know how to represent objects of your class as Strings.
	 * There are many times Java needs to represent your object as a String"
	 *
	 * 		System.out.println("myObject" + myObject);  Java needs to convert your object to String
	 *
	 * 	If you don't provide a toString() method the Object classes toString() is used, which just returns the location in the code which is all jargon
	 *
	 * toString() override for the Object class: String toString() 
	 *                            to present the values of a Playing Card object as a String
	 *
	 * When a super class does not do what you want, override it
	 *
	 * When overriding a method for another class (super class) you must be sure the override
	 * interfaces the same way as the method you are overriding: same return type, name, parameters
	 *
	 * This means YOU must know what the interface for the method you are overriding looks like
	 *
	 * The optional @Override annotation tells the compiler to make sure my override has the same interface as the method I am overriding
	 * 			It's insurance to make sure you're overriding correctly
	 ***************************************************************************************/
	@Override   // for the Object class: String toString()  - object String method returns String/ and receives no parameters
	public String toString() {
		return "PlayingCard [value=" + value + ", color=" + color + ", suit=" + suit + ", getValue()=" + getValue()
				+ ", getColor()=" + getColor() + ", getSuit()=" + getSuit() + "]";
	}
	/***************************************************************************************
	 * Since the Object class' .equals does not know how to compare objects of our class
	 * we override .equals() and we decide who to compare objects of our class
	 *
	 * equals() override for the Object class: boolean equals(Object) 
	 *                   to allow users to see if two Playing Cards have all the same values
	 ***************************************************************************************/
	@Override  // for the Object class: boolean equals(Object) - Object .equals returns boolean/ receives an Object
	public boolean equals(Object obj) {    // Note: Parameter is a generic Object class because this is an override
		if (this == obj) {                 // If PlayingCard is being compared to itself...
			return true;                   //      it must be equal - return false
		}
		if (obj == null) {                 // If PlayingCard is being compared to a null object...
			return false;                  //       it must be unequal - return false
		}
		if (getClass() != obj.getClass()) {// If PlayingCard is being compared to a non-PlayingCard object...
			return false;                  //       it must be unequal - return false
		}
		PlayingCard other = (PlayingCard) obj; // Instantiate a PlayingCard from the object passed as parametr
		if (color != other.color) {            // If colors are not	equal...
			return false;                      //       it must be unequal - return false
		}
		if (suit != other.suit) {              // If suits are not equal...
			return false;                      //       it must be unequal - return false
		}
		if (value != other.value) {            // If values are not equal...
			return false;                      //       it must be unequal - return false
		}
		return true;                           // All of the above are true, the objects are equal - return true
	}
	/***************************************************************************************
	 * The object class' clone method does not know how to make a clone of our object
	 * we override the .clone() method so we decide how to make a copy of our object
	 *
	 * clone() method to create a copy of a PlayingCard from a PlayingCard
	 *
	 * We can't use @Override here to ask the compiler to verify our override because
	 * our method has a different return type and parameter type than the object class clone method
	 * The Object class clone() method returns an Object and has no parameters
	 * Our classes clone method returns a PlayingCard and has no parameters
	 * 				because we don't want to require a cast to our class when one clones an object
	 * 					making it easier for one to use our class
	 ***************************************************************************************/
	public PlayingCard clone() {
		return new PlayingCard(this.value, this.suit, this.color);  // Use 3-arg ctor to create ne object
	}
}
