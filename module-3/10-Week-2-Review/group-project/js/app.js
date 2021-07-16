const PROBLEMS_PER_SET = 10; // maximum number of problems in the problem set displayed to the user

let currentProblem = 0 // this is the current problem being displayed

// need a place to hold the problem set

let problemSet = [];

let userScore = 0; // current problem set score


/* after the DOM is loaded we can add the stuff we need for a problem */

document.addEventListener('DOMContentLoaded', () => {

    // add even listeners for each answer for when it's clicked before we do anything else
    // get a reference to each <li> that represents an answer in an array

    let answerListItems = document.querySelectorAll('#answers ul li');
    // add an event listener for a click to each list item
    answerListItems.forEach((aListItem) => {
        aListItem.addEventListener('click', (eventObject) => {
            // get the answer text that was clicked as a number
            // eventObject.currentTarget is a reference to what was clicked
            // .innerText is the content of the element
            let userAnswer = parseInt(eventObject.currentTarget.innerText);

            // get the correct answer for the current problem
            let correctAnswer = parseInt(problemSet[currentProblem].problem.answer);

            // does the user's answer match the correct answer

            if (userAnswer === correctAnswer) {
                //increment the score
                userScore++;
                // update the score on the screen
                const theDisplayScore = document.querySelector('.currentScore');
                theDisplayScore.innerText = userScore;
            }
            // move to the next problem
            currentProblem++; // increment our problem counter
            document.querySelector('.currentProblem').innerText = currentProblem + 1;
            displayProblem();
            displayAnswers();
        })
    })


    generateProblems(); // display a problem
    displayProblem(); // call the function to generate the problem set
    displayAnswers();
    
})

function generateProblems() {
    // populate the problem set array with the problems

    for (let i = 0; i < PROBLEMS_PER_SET; i++) {
        // define a problem object to hold the components (problem and answer) of a problem
        const problem = {
            left: getRandomNumber(10), // value to the left of the multiply sign
            right: getRandomNumber(10), // value to the right of the multiply sign
            answer: null // answer to the problem - since the values are random we don't know what they are at this point
        }

        // calculate the answer using the random values
        const correctAnswer = problem.left * problem.right;
        //store the correct answer in the problem

        problem.answer = correctAnswer;

        // generate the four possible answers, one correct and 3 random answers
        // call getRandomNumber(82) to receive a random number between 0 and 81
        //      for now we don't care if a random answer happens to match correctAnswer
        //        or if we get the same random value more than once  
        let answers = [correctAnswer, getRandomNumber(82), getRandomNumber(82), getRandomNumber(82)];

        // shuffle the possible answers so the correct one is in a different place each time
        shuffleArray(answers);

        // we need to add the problem and it's answers to the array
        // since we need to add 2 things to the array element - we need to put them in an object
        problemSet.push({problem, answers})
    } // end of loop

    
} // end of function

function displayProblem() {
    // we need to change the element in th DOM (displayable HTML) to have a problem
    // get a reference to where the problem is display to the DOM

    const theProblem = document.getElementById('problem') // this is the <section> with the problem

    // format the expression for the problem (left-value * right-value)
    // the problems are stored in an array called [problemSet]
    // we need the problem in the problemSet for the current problem
    const problemExpression = `${problemSet[currentProblem].problem.left} * ${problemSet[currentProblem].problem.right}`

    // assign the problemExpression to the DOM element

    theProblem.querySelector('div.expression').innerText = problemExpression;

} // end of function

function displayAnswers() {
    // get a reference to the place in the DOM the answers should be displayed
    const theAnswers = document.getElementById('answers');

    const theAnswerSet = theAnswers.querySelector('ul'); // reference to the list of answers

    const eachAnswer = theAnswerSet.querySelectorAll('li'); // array of references to <li> for answers

    const problemAnswers = problemSet[currentProblem].answers; // get the array of answers for the current problem

    // loop through the array of <li> to hold the answers and assign the corresponding answer from the answer array

    for (let i = 0; i < eachAnswer.length; i++) {
        eachAnswer[i].innerText = problemAnswers[i];
        }

} // end of function


// utility code provided by instructions

function getRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max));
}

function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
}