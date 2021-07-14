const pageTitle = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * functions to manipulate the DOM to add or change elements.nodes for display
 * 
 * one function for each DOM manipulation we want to do instead of a long string of JavaScript
 */

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  // we need to add the page title variable to the <span> tag in the HTML
  // get a pointer to the element with the id="page-title"

  const thePageTitle = document.getElementById('page-title');

  // find the <span> tag in the element with id="page-title"

  const theSpan = thePageTitle.querySelector('.name'); // ask the page title to tell us what has class="name"

  // assign the contents of the variable title to the <span>

  theSpan.innerText = pageTitle; // set the content of the span to the variable pageTitle
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  // get a pointer to the <p> with the class='description'

  const theDescription = document.querySelector('.description'); // tell me where the tag with class='description' is 

  // set the content of the <p> to the variable description

  theDescription.innerText = description; // set the content of theDescription to the description variable
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 * 
 * call helper functions to add each element of the review to the page (instead of a long stream of JavaScript)
 */
function displayReviews() {

  // get pointer to where the reviews need to be in the document (as children of <div id='main'>)

  const theDiv = document.getElementById('main'); // find the element with the id='main'

  // then loop through the array of reviews adding them one at a time to the document

  reviews.forEach((aReview) => { // use an anonymous function with the forEach sending each review to the anonymous function as a review
    //      create a new <div> for the review

    const newElement = document.createElement('div');

    // add a class='review' to the new <div> so it is styled as a review (css given)
    //      call each helper function (below) with the new <div> as the parent and data for element it's creating

    newElement.setAttribute('class','review');

    // call the function to add the reviewer to the DOM

    addReviewer(newElement, aReview.reviewer);

    // call the function to add the rating to the DOM

    addRating(newElement, aReview.rating);

    // call the function to add the title to the DOM

    addTitle(newElement, aReview.title);

    // call the function to add the review to the DOM

    addReview(newElement, aReview.review);

    // add the new element to the DOM tree under the <dov> with class='main'

    theDiv.insertAdjacentElement('beforeend', newElement);

  }); // end of anonymous function and the forEach loop

 



}


// these functions will be called by displayReviews to handle each new element needed
/**
 * I will creating a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} el: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 * 
 * the first parameter (parent) is where to add the new element
 * the second parameter is the data to tbe included in the new element
 * 
 */
function addReviewer(parent, name) {

const aReviewer = document.createElement('h4') // create an <h4> element for the review name

aReviewer.innerText = name; // set the text in the <h4> to the name we got passed into us

parent.appendChild(aReviewer); // connect the new <h4> to the parent who received

}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  // numberOfStars is a numeric value telling us how many stars to put in the review
  // we have the image for one star - we need to add as many <img> tags as the value in rating
  // we need to set up a loop to add the <img> tags using the numberOfRatings to control the loop
  // because we will have several <img> tags, let's group them in their own <div>
  //      also, we have a style for class='rating' for the rating element, so they need to be in a <div>

  const theRating = document.createElement('div') // create a <div> to hold the rating
  theRating.setAttribute('class', 'rating') // give class='rating' to the new <div>

  for (let i = 0; i < numberOfStars; i++) { // loop for the value in numberOfStars
  const aStar = document.createElement('img'); // create an <img> tag for star

  aStar.setAttribute('class', 'ratingStar'); // assign class='ratingStar' to the new <img> tag

  aStar.src='img/star.png'; // set the src= of the <img> tag to the star image we have

  theRating.appendChild(aStar);// connect the new star to the new rating <div>
  }

  parent.appendChild(theRating);
}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  const theTitle = document.createElement('h3');
  theTitle.innerText = title;
  parent.appendChild(theTitle);
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const theReview = document.createElement('p')
  theReview.innerText = review
  parent.appendChild(theReview);
}

// these functions below are called when the page is loaded to run the DOM manipulation functions defined above

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
