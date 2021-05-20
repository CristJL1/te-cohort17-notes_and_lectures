package com.techelevator;

public class IntroToClassesCard {
        //------------------------------------------------------------------------------------------------------------
        // Application program for the Intro To Classes App

        // main() tells us it's the application program

        // application programs instantiate and use classes to do work for the application
        //------------------------------------------------------------------------------------------------------------
        public static void main(String[] args) {
        /*
        *  This program will demonstrate several concepts presented in the Java cohort
        *  in the topic Introduction to Classes 		
        */
        // instantiate a PlayingCard object:   data-type name = new datatype();
        // a class is a user defined datatype (not defined by the Java language)
        // a class is used like a datatype
        // the new keyword instantiates an object of the class

        // new className() = instantiate an object of the class and run the constructor
        //                      () indicate which constructor to run, in this case the default card "Ace of Spades Face Up"

        PlayingCard aceOfSpades = new PlayingCard();



        System.out.println("Our playing card is : " + aceOfSpades); // display our PlayingCard object
            //                  String              +  PlayingCard object
            //                                      + is String concatenation symbol when used with a String
            //                                      + needs two Strings to work
            //                                      + needs to convert the PlayingCard object to a String
            //                                      if a class has a toString() method it will be used
            //                                      if it doesn't have a toString() method
            //                                          it looks to the parent class for a toString() method
            //                                          if the parent has one, we use it
            //                                      since our parent class (Object) has a toString() method - it runs
            //                                      Object class toString() returns: packageName.className@location


           // we want to access the data member cardValue in our PlayingCard
           // we can't because it's private (Encapsulation)
        System.out.println("The value of my card is: " + aceOfSpades.getCardValue());  // display the value in my PlayingCard
                System.out.println("The color of my card is: " + aceOfSpades.getCardColor());
                System.out.println("The suit of my card is: " + aceOfSpades.getCardSuit());


        aceOfSpades.setCardValue(13); // change the value in my card using the setter provided

                System.out.println("The value of my card is: " + aceOfSpades.getCardValue());

                // nothing stops us from setting the value to anything we want

                aceOfSpades.setCardValue(46); // change the value in my card using the setter provided

                System.out.println("The value of my card is: " + aceOfSpades.getCardValue());

        // define a Black 3 of Clubs PlayingCard
        // I need to use a constructor that takes the value, color, and suit of PlayingCard

                PlayingCard myCard = new PlayingCard(3, "Black", "Clubs");
                System.out.println("My card is: " + myCard);

	}
}
		 

