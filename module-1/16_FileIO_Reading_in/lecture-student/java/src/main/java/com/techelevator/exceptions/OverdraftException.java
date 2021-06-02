package com.techelevator.exceptions;


// to define your own custom Exceptions
//		create a class that extends Exception
//		provide an optional default constructor that calls the Exception constructor
//		provide any other constructor you want, it still must call Exception constructor

public class OverdraftException extends Exception {

	private double overdraftAmount = 0; // an optional member variable that can be available to a catch block

	// a 2 argument constructor that receives a message and a double value that represents the over draft amount
	public OverdraftException(String message, double overdraftAmount) {
		super(message); //' call the Exception class constructor (our superclass) with the message to display
		this.overdraftAmount = overdraftAmount; // save the overdraft amount so it is available to any catch block
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}
}
