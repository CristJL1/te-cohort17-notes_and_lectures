/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed (const)
  const daysPerWeek = 7; // const defines a variable whose value cannot be changed
                         // normally a const name would be all UPPERCASE

  // console.log() is the JavaSCript equivalent of System.out.println() in Java - display a line on the screen
  // if what you want console.log to display() contains a variable you must code the string in `` (tick marks)
  //      and the variable as ${variable-name}

  console.log(`There are ${daysPerWeek} days in a week`); // semi-colons are usually optional in JavaScript
  

  // Declares a variable those value can be changed (let)

  let daysPerMonth = 30; // let defines a variable that may be changed
  console.log(`There are ${daysPerMonth} days in a month`);

  // another way to define a variable using the var keyword - NOT RECOMMENDED!
  // avoid defining variables with var as it can lead to very confusing and hard to debug code

  // Declares a variable that will always be an array
  const WEEKDAYS = [ // a JavaScript array is defined inside brackets []
  "Monday", // separate multiple values with , just like Java
  "Tuesday",
  "Wednesday",
  "Thursday",
  "Friday",
  "Saturday",
  "Sunday"
  ];

  console.table(WEEKDAYS); //display the array as a table

  console.log(WEEKDAYS);

}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 *
 * data types for parameters are not needed in JavaScript
 * 
 */

function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality - compares the value only
 * === is strict equality - compares the value and datatype
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}

/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * 
 * anything used in a conditional expression will evaluate to true or false
 * if an expression used in a conditional evaluates to "nothing" - 0, null, "", NaN, undefined - it is false
 *                anything else is true
 * 
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
    - JSON stands for JavaScript Object Notation
        if you understand JSON format, you understand JavaSCript objects

    - JavaScript objects are NOT the same as Object-Oriented objects
          no class, no inheritance, no polymorphism, no interfaces
*/
function objects() {
  const person = {        //JavaScript object is enclosed {}
    firstName: "Bill",    // attribute of a JavaScript object are key-value pairs (attribute : value)
    lastName: "Lumbergh", // separate attributes in a JavaSCript object with ,
    age: 42,              // data types may be mixed in a JavaScript object
    employees: [          // array define as an attribute of a JavaScript object
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],                     // end of the array attribute
    // define a toString() for this object - return the object as a string
    toString : function() { // attribute (function name : function())
      return `${this.firstName}, ${this.lastName}, ${this.age}`
    }
  };                       // end of the JavaScript Object

  // call a function define for an object
  console.log(person.toString())

  // Log the object

  console.log(person);  // display the entire object
  console.table(person);

  // Log the first and last name (object.attribute to access an individual attribute in the object)

  console.log(`The person's first name is ${person.firstName} and their last name is ${person.lastName}`)

  // Log each employee
  // loop through the array of employees in the object
  // JavaScript has a for-loop similar to Java's
  //
  for (let i = 0; i < person.employees.length; i++)

  console.log(`Employee #: ${i+1}: ${person.employees[i]}`);
}

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overridden and the most recent one will be used.
*/

function Add(num1, num2) {
  return num1 + num2;
}

// since this function has the same name as an existing function it replaces the existing function (in Java this would have been an overload and it would be fine)
function Add(num1, num2, num3) {
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.

like most languages JavaSCript has libraries of frequently used functions
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);
  console.log(`value.substr(2,3) - ${value.substr(2,3)}`) // substr(start-index, length)
  console.log(`value.substring(2,3) - ${value.substring(2,3)}`) // substring(start-index, end-index)
                                                                    //substring works like Java substring, starts at start index and goes up to, but not including, the end index

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}


/*
#####################################################
Array Functions
#####################################################
*/

//methods to manipulate arrays - a lot more flexibility than arrays in Java

function arrayFunction() {
  let stooges = [
    "Moe",
    "Larry",
    "Curly"
  ]

  console.table(stooges);

  stooges.push("Shemp");
  console.table(stooges);

  stooges.unshift("Curly Joe");
  console.table(stooges);

  stooges.splice(3,0,"Groucho", "Chico", "Harpo"); // add elements starting at index 3 and remove none
  console.table(stooges);

  stooges.splice(3,3); // remove 1 element at index 3
  console.table(stooges);

  stooges.shift(); // remove the first element in the array and shift all elements up one
  console.table(stooges);

  stooges.pop(); // remove one element at the end of the array (last element)
  console.table(stooges);

  // remove an element based on it's value (remove "Larry")
  stooges.splice(stooges.indexOf("Larry"),1); // find the index of Larry and remove him
  console.table(stooges);

  let dan = [
      "Groucho",
      "Chico",
      "Harpo"
  ]

  let oldFunnyGuys = stooges.concat(dan); // arrays can be concatenated

  console.table(oldFunnyGuys);
}
