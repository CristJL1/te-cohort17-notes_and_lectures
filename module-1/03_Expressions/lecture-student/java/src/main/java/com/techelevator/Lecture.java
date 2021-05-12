package com.techelevator;

public class Lecture {
    /*
    1. This method is named returnNotOne and it returns an int. Change
    it so that it returns something other than a 1.
    */

//  access return   function (parameters)
    public int returnNotOne() {
        return 8;
    }

    /*
    2. This method is named returnNotHalf and it returns a double. Change
    it so that it returns something other than a 0.5.
    */
    public double returnNotHalf() {
        return 0.86;
    }

    /*
    3. This method needs to return a String. Fix it to return a valid String.
    */
    public String returnName() {
        return "String";
    }

    /*
    4. This method currently returns an int. Change it so that it returns a double.
    */
    public double returnDoubleOfTwo() {
        return 2;
    }  // 2 is an int, Java will convert it to a double to return it

    /*
    5. This method should return the language that you're learning. Change
    it so that it does that.
    */
    public String returnNameOfLanguage() {
        return "Java";
    }

    /*
    6. This method uses an if statement to define what to return. Have it
    return true if the if statement passes.

    The if statement allows you to execute statements conditionally

    syntax-1: if (condition) {
                what-to-do-if-the-condition-is-true
              } // end of if statement

    syntax-2: if (condition) {
                what-to-do-if-the-condition-is-true
              } // end of true-process
              else {
                what -to-do-if-the-condition-is-false
              } // end of false process and end of if

    syntax-3: if (condition) {
                what-to-do-if-the-condition-is-true
              } // end of true-process
              else if (condition) {
                what -to-do-if-nested-if-condition-is-true
              } // end of nested if true process
              else {
                what-to-do--if-nested-if-condition-is-false
              }  // end of nested if and nested false


    */
    public boolean returnTrueFromIf() {
        if (true) {
            return true;
        }

        return false;
    }

    /*
    7. This method uses an if to check to make sure that one is equal
    to one. Make sure it returns true when one equals one.


    Note: equal in Java is == NOT just =
          code two equal signs to indicate an equal condition

          = means assignment

          == equal condition



    */
    public boolean returnTrueWhenOneEqualsOne() {
        if (1 == 1) {
            return true;  // terminate function and return true
        }

        return false;   // only way to get here is if the condition from if is false
                        // we need to code this return statement even though it is not needed
                        // the condition we are testing can never be false
                        //but the compiler doesn't know that
                        // so it forces you to code a return statement
    }

    /*
    8. This method checks a parameter passed to the method to see if it's
    greater than 5 and returns true if it is.
    */
    public boolean returnTrueWhenGreaterThanFive(int number) {
        if (number > 5) {
            return true;
        } else {

        }
        return false;
    }

    /*
    9. If you think about it, we really don't need the if statement above.
    How can we rewrite exercise 8 to have only one line of code?
    */
    public boolean returnTrueWhenGreaterThanFiveInOneLine(int number) {

        // you can code an expression that returns the type you want
        //since this function is returning a boolean and a condition results in a boolean
        //we can simply code the condition on the return
        // if this is confusing to you - use the if statement above - only use code you understand
        // don't use shortcut coding techniques unless you fully understand what they do
        //you need to understand what your code is doing
        // if you don't know what you're doing, don't do it

        if (number >5) {
            return true;
        }
         // What can we put here that returns a boolean that we want?
        return false;
    }

    /*
    10. This method will take a number and do the following things to it:
    * If addThree is true, we'll add three to that number
    * If addFive is true, we'll add five to that number
    * We'll then return the result
    */
    public int returnNumberAfterAddThreeAndAddFive(int number, boolean addThree, boolean addFive) {
        if (addThree) {  // since addThree is boolean we don't have to say addThree == true

            number = number + 3;  // if addThree was true add 3 to the number
        }

        // We can't use an else here. They could both be true, so we have to check each one.

        if (addFive) {       // addFive parameter == true add 5 to number
            number += 5;
        }

        return number;
    }

    /*
    11. Write an if statement that returns "Fizz" if the parameter is 3 and returns an empty String for anything else.
    */
    public String returnFizzIfThree(int number) {
        if (number == 3) {
            return "Fizz";
        }
        return "";  // terminate function return and empty string
    }

    /*
    12. Now write the above using the Ternary operator ?:. If you're not sure what this is, you can Google it.

        ternary operator is shorthand for if else coding - only 3 operand operator

        syntax: condition ? result-if-true : result-if-false



    */
    public String returnFizzIfThreeUsingTernary(int number) {
        return (number == 3) ? "Fizz" : "";

    }

    /*
    13. Write an if/else statement that returns "Fizz" if the parameter is 3, "Buzz" if the parameter is 5 and an empty String for anything else.
    */
    public String returnFizzOrBuzzOrNothing(int number) {
        if (number == 3) {
            return "Fizz";
        }
        if (number == 5) {
            return "Buzz";
        }
        return "";
    }

    // return (number == 3) ? "Fizz" : (number == 5) ? "Buzz" : " "

    /*
    14. Write an if statement that checks if the parameter number is either equal to or greater than 18. Return "Adult" if it is or "Minor" if it's not.
    */
    public String returnAdultOrMinor(int number) {
        if (number >= 18) {  // (number == 18 || number > 18)
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    15. Now, do it again with a different boolean operation.
    */
    public String returnAdultOrMinorAgain(int number) {
        if (number == 18 || number > 18) {
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    16. Return as above, but also return "Teen" if the number is between 13 and 17 inclusive.
    */
    public String returnAdultOrMinorOrTeen(int number) {
        if (number >= 18) {
            return "Adult";
        } else if (number >= 13 && number <= 17) {
            return "Teen";
        } else {
            return "Minor";
        }
    }

}