package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AmericanPlayingCard extends PlayingCard{

	// static means there is only one shared by all
	// final means it cannot be changed once it has been assigned a value
	// static final means only one occurrence, shared by all, that cannot be changed

	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;
	private static Map<String,  String> suitMap  = new HashMap<String , String>();  // associate a suit and a color
	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>();  // associate a value and word that describes it

	// since the suitMap and valueMap are static - only static methods may change them
	// static data may exist without any objects of the class being instantiated
	// if the initializeMaps() method was in constructors, it may never be run - our Maps would not get initialized
	// we need to tell Java to run initializeMap() when the application starts which is when static data is created
	// by putting the call to initializeMaps() outside any function/method - Java knows to run it
			// at the start of the app

	// static is required because it is calling the static method initializeMaps
	static { // no function/method definition - anonymous function
		initializeMaps(); // call the function to initialize the suitMap and valueMap
	}
	
	public AmericanPlayingCard() 
	{
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);
	} 

	public AmericanPlayingCard(int value, String suit) {

		// use the conditional operator (?) to provide conditional parameters to a method
		// the way the conditional operator works: condition ? value-if-true : value-if-false
		//
		// suitMap.containsKey(suit) ? suit : DEFAULTSUIT
		//
		// if the suitMap contains a key that equals the suit we were passed, use it, otherwise use DEFAULTSUIT
		//
		//     color         != null ?        color      : default color
		// suitMap.get(suit) != null ? suitMap.get(suit) : DEFAULTCOLOR)
		//
		// if the value returned from using the get for suitMap using the suit passed is not null,
				// use the color from the suitMap, otherwise use the DEFAULTCOLOR
		//
		// if no color is return from the suitMap, use the default color


		// call the superclass constructor with the value passed and the suit and color we determine
		super(value,                                                        // Call super ctor with value passed
			  suitMap.containsKey(suit) ? suit : DEFAULTSUIT,               // If valid suit passed, use it otherwise use DEFAULTSUIT
		      suitMap.get(suit) != null ? suitMap.get(suit) : DEFAULTCOLOR);// If valid suit passed, use color for suit otherwise use DEFAULTCOLOR  
		
		if (value > MAXVALUE) {
			setValue(MAXVALUE);
		}
		if (value < MINVALUE) {
			setValue(MINVALUE);
		}
	}

	// this must be a static method because it is changing static data (suitMap and valueMap)

	static private void initializeMaps() { // initialize the suitMap and valueMap
		// 			  key		  value
		suitMap.put("SPADES"   , "BLACK");
		suitMap.put("CLUBS"    , "BLACK");
		suitMap.put("DIAMONDS" , "RED");
		suitMap.put("HEARTS"   , "RED");
		suitMap.put(DEFAULTSUIT, DEFAULTCOLOR); // the DEFAULTSUIT is associated with the DEFAULTCOLOR

		//          key   value
		valueMap.put(0,"Joker");
		valueMap.put(1,"Ace");
		valueMap.put(2,"Two");
		valueMap.put(3,"Three");
		valueMap.put(4,"Four");
		valueMap.put(5,"Five");
		valueMap.put(6,"Six");
		valueMap.put(7,"Seven");
		valueMap.put(8,"Eight");
		valueMap.put(9,"Nine");
		valueMap.put(10,"Ten");
		valueMap.put(11,"Jack");
		valueMap.put(12,"Queen");
		valueMap.put(13,"King");
	}
	
	@Override
	public String toString() {
		return "AmericanPlayingCard: " 
	          +"Value: "  + valueMap.get(getValue())
	          +" - Color: " + suitMap.get(getSuit()) 
			  +" - Suit: "  + getSuit()
			  +" - super.toString()=" + super.toString() + "\n";
	}

	public void showCard() {
		System.out.println(this.toString());
	}

}
