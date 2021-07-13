/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * no return type on JavaScript functions because it is loosely typed
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 * no return statement is required in a JavaScript function
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. 
 * But what happens if we don't pass a value in? - result is NaN
 * What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */

function multiplyTogether (firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}


/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */

function multiplyNoUndefined (firstParameter = 0, secondParameter = 0) {
  return firstParameter * secondParameter;
}

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  // variables defined outside a block {} is available from that point in the function down
  //    including any blocks defined from there to the end of the function
  let inScopeInScopeTest = true;

  //using a variable that appears to have not yet been defined - doesn't appear before this line of code
  console.log(`Baddy McBadBad contains: ${baddyMcBadBad}`)

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    // variables define inside a block are only available inside that block or blocks within it
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
    var baddyMcBadBad = "Don't ever use var!"; // defined inside a block, but can be used anywhere
  }
}

/**
 * this is the start of a JavaDoc Comment - notice the ** after the /
 * 
 * JavaDoc is a tool to format comments to be descriptive for function
 * 
 * it will automatically document parts of the function like parameters, return values, etc. 
 */

/**
 * create a string from the parameters and elements in an array passed as arguments
 * 
 * .join() will create a string from an array with separator specified (or , is no separators)
 * 
 * @param {*} name 
 * @param {*} age 
 * @param {*} listOfQuirks 
 * @param {*} separator 
 * @returns
 */

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator); // create a string from listOfQuirks
  //                                                    separator specified
}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 * 
 * convert the values in an array to a sum
 * produce the sum of all the values in the array
 * reduce the array to the sum of the values
 * 
 * a single value out of the array - this is a job for reduce()
 * 
 * .reduce() takes an anonymous function which receives 2 parameters
 *          receives a parameter to hold the result of each anonymous function call (reducer)
 *          receives a parameter which is the current element in the array
 * 
 * general syntax: array.reduce(anonymous function)
 * 
 * more specific syntax: array.reduce((reducer, anElem) => {})
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  // in this anonymous function we will call the reducer sum since it will hold the sum of the array elements
  // we will call the current element of the array aNumber
  // when .reduce() is done, it returns the final value in the reducer(sum)
  //      which we will return from this function
  return numbersToSum.reduce((sum, aNumber) => {
    sum += aNumber; // add the current element to sum
    return sum;
  });
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 * 
 * create a new array from selected elements in another array
 * this is what .filter() does
 * 
 * .filter() uses an anonymous function that takes the current element as a parameter
 * the anonymous function determines if the element it is sent meets the conditions to be included in a new array
 * it returns true if it does and false if it doesn't
 * 
 * .filter() will add the current element to the new array if the anonymous function returns true
 * 
 * when all elements in the array are processed, .filter() returns the new array
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {
  return numbersToFilter.filter((currentElement) => {
    if (currentElement % 3 == 0) {// if the current element is a multiple of 3
    return true; // it should be in the new array
    } else return false;
  })
}


/**
 * This example was added by Frank at the last minute and has no test.
 * Give the browser the html and use the inspect to to run it
 * 
 * create a new array containing the squares of the corresponding elements in an array
 * 
 * .map() takes an anonymous function that received the current element
 *    and then performs a process on the current element and returns it
 * .map() add the value returned from the anonymous function to the new array
 * 
 * The map function will return an array created from the elements passed to it
 * 
 * @param - None
 * @returns {array created from values passed to it}
 */

function mapArrayFunctionExampleFromBook() {
let numbersToSquare = [1, 2, 3, 4];
console.log(`Array calling map to create new array with values squared: `)
console.table(numbersToSquare);

let squaredNumbers = numbersToSquare.map( (number) => {
    return number * number; // square the current element and return it
});

console.log(`Array returned from map with values in passed array squared: `)
console.table(squaredNumbers);
}

/**
 * Another example added by Frank at the last minute and has no test.
 * Give the browser the html and use the inspect to to run it
 * 
 * The forEach() is the JavaScript version of the for-each loop in Java
 * 
 * @param - An array generated as a parameter
 * @returns {array created from values passed to it}
 */
function forEachExample(anArray=["John"   ,"Alex"    ,"Jared"  ,"Agnes","Brian","Josh"  , "Nia",
                                 "JC"     ,"Daniel"  ,"Amber"  ,"Dana" ,"Jess" ,"Vanese", "Ruben",
                                 "Lindsay", "Anthony","Lorenzo","Array McRayRay"])
{
  // forEach() is the JavaScript version of the for-each look in Java
  anArray.forEach((anElement) => { 
    console.log(anElement)
    }) 

    console.table(anArray.sort());

    anArray.reverse();
    console.table(anArray);

}
