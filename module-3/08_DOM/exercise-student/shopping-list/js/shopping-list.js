// add pageTitle - call the function that does this
/**
 * @param {string} pageTitle
 */

const pageTitle = 'My Shopping List';

// add groceries - call the function that does this

/**
 * @param {Array} groceries
 */

const groceries = [
  {id: 1, name: 'Milk'},
  {id: 2, name: "Bread"},
  {id: 3, name: "Eggs"},
  {id: 4, name: "Butter"},
  {id: 5, name: "Salt"},
  {id: 6, name: "Bananas"},
  {id: 7, name: "Apples"},
  {id: 8, name: "Peanut Butter"},
  {id: 9, name: "Jelly"},
  {id: 10, name: "Ground Beef"},
];


/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title')
  title.innerText = pageTitle
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    ul.appendChild(li);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {

  const listItems = document.querySelectorAll('li');

  listItems.forEach((status) => {
    listItems.classList.add(".completed");
  });

}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
