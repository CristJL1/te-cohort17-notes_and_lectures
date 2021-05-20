package com.techelevator;  // Java package to hold the class
                           // a package is a group of related Java components
                           // this class is in the same package as our application programs
                                // so we don't have to import it into the application program


public class PlayingCard {  // This is the start of our class


    // This is a class to represent OUR PlayingCard object - we decide what a PlayingCard is and does
    //
    // A class contains the data (variables) and methods (behaviors) for a class
    //
    // We have identified the following basic characteristics of a PlayingCard
    //
    // value
    // suit
    // color
    // shape
    // symbol
    // face up / face down

    // the characteristics of an object are sometimes called attributes or properties

    // the attributes of class are defined as member variables in the class
    // a member is simply a variable defined in a class - a variable that is a member of a class

    // to define a member variable in a class:   access - public - anyone can access it - violates encapsulation
    //                                                    private - only members of the class can access it
    //                                                          encapsulation - protecting the data
    //                                           datatype
    //                                           name
    /******************************************************************************************************************
     * *Data members for the class - initialization of the data is done by the Constructors NOT at definition
     ******************************************************************************************************************/

    private int     cardValue; // Joker = 0, Ace = 1, Jack = 11, Queen = 12, King = 13

    private String   cardSuit;

    private String  cardColor;

    private String  cardShape;

    private String cardSymbol;

    private boolean  isFaceUp; // typically boolean variables start with the word "is"

    /******************************************************************************************************************
     * methods for the class - member methods - member functions - a method is a function in a class
     ******************************************************************************************************************/


    //-----------------------------------------------------------------------------------------------------------------
    // Constructors (ctor) are methods to initialize objects of a class
    // Constructors run AUTOMATICALLY by Java when an object of the class is instantiated/created/defined
    //-----------------------------------------------------------------------------------------------------------------
    // every class should provide constructors to initialize data members of the class
    // if constructors are not provided for a class, Java runs a default constructor that does nothing
    //          numerics = 0, Strings = "", booleans = false, char = "", objects = null
    //
    // constructors are special methods in a class: no return type (not even void), name is the same name as the class,
    //                                                        must have a unique parameter list (datatypes) in the class
    //
    // constructors are usually overloaded functions - same name, but different parameter lists in the class
    //
    // you should always provide at least a default constructor
    // a default constructor is one that takes no parameters and sets the data to default values
    // Java uses default constructors behind the scenes in its processing
    //
    // define a default constructor for a PlayingCard
    //      a default PlayingCard - value = 1, suit = "Spades", color = "Black", shape = "Rectangle"
    //                                          symbol = "A", face-up = true

    public PlayingCard () { // default constructor - same name as the class, no parameters, no return type

        cardValue = 1;
        cardSuit = "Spades";
        cardColor = "Black";
        cardSymbol = "A";
        cardShape = "Rectangle";
        isFaceUp = true;

    }

    // define a constructor to allow a user to crate a card with a specific value, color, and suit

    public PlayingCard (int value, String color, String suit) { // 3 argument constructor
        cardValue = value; // set cardValue to whatever the user wants
        cardSuit = suit; // set the cardSuit to whatever the user wants
        cardColor = color; // set the cardColor to whatever the user wants
        cardShape = "Rectangle"; // set the cardShape to the default shape
        cardSymbol = null; // since they didn't tell us the symbol - set to null (unknown)
        isFaceUp = true; // since they didn't tell us about isFaceUp, set to default

    }

    //-----------------------------------------------------------------------------------------------------------------
    // Getters/Setters - methods that allow access, under control of the class , to private data
    //                  used so application programs can retrieve the values that are in the private data
    //                                    or change the values in the private data
    // not all data members are required to have getters and setters
    // YOU decide which private data you want to allow applications to retrieve or change
    //
    // Getters and Setters should follow the standard Java naming convention
    //                              because many frameworks we use in Java expect the standard names
    //
    // getVariableName          setVariableName         isBooleanVariableName (getter)
    //-----------------------------------------------------------------------------------------------------------------

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;  // we learn about this. tomorrow!
    }

    public String getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public String getCardShape() {
        return cardShape;
    }

    public void setCardShape(String cardShape) {
        this.cardShape = cardShape;
    }

    public String getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }


    //-----------------------------------------------------------------------------------------------------------------
    // Additional methods to support the class
    //-----------------------------------------------------------------------------------------------------------------



    //define a toString() to return our PlayingCard object as a String
    // so Java uses our toString() instead of the parent (Object class) toString()


    @Override // optional - we will lean this tomorrow
    public String toString() {
        return "PlayingCard{" +
                "cardValue=" + cardValue +
                ", cardSuit='" + cardSuit + '\'' +
                ", cardColor='" + cardColor + '\'' +
                ", cardShape='" + cardShape + '\'' +
                ", cardSymbol='" + cardSymbol + '\'' +
                ", isFaceUp=" + isFaceUp +
                '}';
    }
} // End of PlayingCard class

