const name = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * I will display all of the reviews in the reviews array
 */
function displayReviews() {

// using an HTML template to create the elements rather than document.createElement

// if the HTML content contains a template, use it
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => { // loop for each element in the reviews array
      displayReview(review); // call the displayReviews function with the current element
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 *
 * @param {Object} review The review to display
 */
function displayReview(review) { // display one review which is passed to it
  const main = document.getElementById('main'); // get me a reference to the element with the id="main"
  // generate an instance (content.cloneNode(true)) of the template called "review-template" in the HTML
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerText = review.reviewer; // find the <h4> in the template and set it to the reviewer
  tmpl.querySelector('h3').innerText = review.title; // find the <h3> in the template and set it to the title
  tmpl.querySelector('p').innerText = review.review; // find the <p> in the template and set it to the review
  // there will always be 1 star because it is a part of the template
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode(); // find the <img> in the template and copy it
    tmpl.querySelector('.rating').appendChild(img); // find the parent (class='rating') and append it
  }
  main.appendChild(tmpl);
}

// LECTURE STARTS HERE ---------------------------------------------------------------

// when the page loaded, call all the functions for load the content

// your functions to initialize the page content might take a little while to run
// which could mean they may not complete the page initialization before the browser creates the DOM
// it's good practice to NOT initialize the page until the DOM has been created
// if you try to manipulate the DOM, like initialization, before it's created, the changes are ignored
// the DOMContentLoaded event triggers/happens when the DOM has been fully created
// add an event handler to the document to wait until the DOM is fully created

document.addEventListener('DOMContentLoaded', () => {

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews(); })

/**
 * add an event listener to the add review button to add a review using helper functions
 * 
 * add review button has id="btnToggleForm"
 */

const theAddReviewButton = document.getElementById('btnToggleForm') // get a reference to the add review button
theAddReviewButton.addEventListener('click', (eventObject) => { // when AddReview is clicked
  showHideForm() // call the helper function to show the form
})

/**
 * add an event listener to the save review button to save a review to the array using helper functions
 * 
 * save review button has id='btnSaveReview'
 */


const theSaveReviewButton = document.getElementById('btnSaveReview')
theSaveReviewButton.addEventListener('click', (eventObject) => {
  // the default action for a form is to do an HTTP request to a URL
  // we don't want this form to do that because (1) we don't have an API to handle the data
  // (2) we are handling the data in the form
  eventObject.preventDefault() // disable the default processing of a form
  saveReview()
})



/**
 * Take an event on the description and swap out the description for a text box.
 * using the helper functions toggleDescriptionEdit() and exitDescriptionEdit()
 * 
 * every event handler is passed an Event object containing information about the Event
 * @param {Event} event the event object
 */

// ask the document to add an Event listener to the description on the page (class="description")
const theDescription = document.querySelector('.description'); // get a reference to the description
// .addEventListener() add an event handler to an HTML element
// .addEventListener(event-to-listen-for, function-to-event) - the function is frequently an anonymous function
// add an event handler for the 'click' event on the description and run the anonymous function to handle it


theDescription.addEventListener('click', (eventObject) => {
      toggleDescriptionEdit(eventObject.target) // call the helper function with what was clicked
      //                                           .target in the Event object is a reference to what had the Event
      //                                           here .target is the description on the page


})

// add an event handler to the input box to save the new text when the user presses

const theTextBox = document.getElementById('inputDesc') // get reference to the text box (id="inputDesc")
theTextBox.addEventListener('keyup', (eventObject) => { // when keyup happens in the text box, call the anonymous function
  // the event object for a keyup event .key property contains the name of the key released 
if (eventObject.key === 'Enter') { // only want to exit if the enter key was pressed
  exitDescriptionEdit(eventObject.target, true) // call the helper function with theText reference box and true so the content will be saved
} else {
  if (eventObject.key === 'Escape') {
    exitDescriptionEdit(eventObject.target, false)
  }
}
})





 // helper function to toggle whether the input box for a new description is displayed or not
function toggleDescriptionEdit(desc) { // receive a reference to the description on the page
  const textBox = desc.nextElementSibling; // get a reference to the next sibling of the description 
  //                                              find the input element following the description
  textBox.value = description; // set the input element to the original initial value
  // .classList represents all the classes currently assigned to an element 
  textBox.classList.remove('d-none'); // un-hide the input element (remove the d-none class)
  desc.classList.add('d-none'); // hide the current description (add the d-none class)
  textBox.focus(); // put the cursor in the text box (give it focus)
}

/**
 * Take an event on the text box and set the description to the contents
 * of the text box and then hide the text box and show the description.
 *
 * @param {Event} event the event object
 * @param {Boolean} save should we save the description text
 */

 // helper function to save any new description and un-hide the description element
 // it has 2 parameters: the input box with the new text 
 //     and boolean if true saves the new description text and if false, does not
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling; // get a reference to the description element 
  //                                            it's the previous sibling to the text box
  if (save) { // if we're supposed to save the new text
    desc.innerText = textBox.value; // set the description to the new text
  } //                                  otherwise do nothing
  textBox.classList.add('d-none'); // hide the input text box
  desc.classList.remove('d-none'); // un-hide the description
}


// helper functions to handle adding a review
/**
 * I will show / hide the add review form
 */
function showHideForm() {
  const form = document.querySelector('form'); // get a reference to the form
  const btn = document.getElementById('btnToggleForm'); // get a reference to the add review button

  if (form.classList.contains('d-none')) { // if the form is hidden
    form.classList.remove('d-none'); // un-hide it
    btn.innerText = 'Hide Form'; // change the button text in the add reviews
    document.getElementById('name').focus(); // set the focus to the add review (now Hide form) button
  } else { // if the form is not hidden
    resetFormValues(); // reset the values using a helper function
    form.classList.add('d-none'); // hide the form
    btn.innerText = 'Add Review'; // change the button text to AddReview
  }
}

/**
 * I will reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form'); // get a reference to the form
  const inputs = form.querySelectorAll('input'); // get reference to all input element in an array
  inputs.forEach((input) => { // loop through the array of input elements
    input.value = ''; // set each input element to an empty string
  });
  document.getElementById('rating').value = 1; // get a reference to the rating and set to 1
  document.getElementById('review').value = ''; // get a reference to the review and set it to ''
}

/**
 * I will save the review that was added using the add review from
 */
function saveReview() {
  // we need to save the data in the form to an object and add the object to the reviews array
  // we need to extract the data from the form
  const newName = document.getElementById('name');
  const newTitle = document.getElementById('title');
  const newRating = document.getElementById('rating');
  const newReview = document.getElementById('review');

  // we need to have an object to store the form data into
  // copy the data from the form into the properties of the object
  const aReview = {
    reviewer: newName.value, // copy the value from the name field in the form to the object
    title: newTitle.value, // copy the value from the title field in the form to the object
    rating: newRating.value, // copy the value from the rating field in the form to the object
    review: newReview.value // copy the value from the review field in the form to the object
  }

   // add the object to the reviews array
  reviews.push(aReview) // add the new review object to the end of the reviews array

  // we have the new review in the JavaSCript array, but we need to add it to the DOM to be displayed 
  // the helper function displayReview() which will add a review to the DOM

  displayReview(aReview)
  showHideForm(); // hide the form since we're done with it
 
}
