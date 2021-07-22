<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>
    <p class='author'>(by {{author}})</p> 
    <p class="description">{{ description }}</p>

<!-- if one of the summary boxes is clicked only show rating for the number of stars for the summary -->
<!-- if average rating is clicked - show all reviews -->
<!-- we need to filter the elements in the array that is displayed to only have reviews for stars selected -->
<!-- we need a new array to hold only the reviews with the stars selected - we need original array -->
<!-- sounds like a method to filter the reviews for whatever star is picked -->

    <div class="well-display">
      <div class="well">
        <span class="amount" v-on:click="starFilter=0">{{ averageRating }}</span> <!-- put the value from the average rating property here-->
        Average Rating
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter=1">{{ numberOfOneStarReviews }}</span> <!-- put the value from the numberOfOneStarReviews property here-->
        1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }} <!-- adds an "S" to the word review if it should be plural -->
      </div>                                                        <!-- if the numberOfOneStarReviews is equal to 1 - no 's' at the end -->

      <div class="well">
        <span class="amount" v-on:click="starFilter=2">{{ numberOfTwoStarReviews }}</span> <!-- put the value from the numberOfTwoStarReviews property here-->
        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter=3">{{ numberOfThreeStarReviews }}</span> <!-- put the value from the numberOfThreeStarReviews property here-->
        3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter=4">{{ numberOfFourStarReviews }}</span> <!-- put the value from the numberOfFourStarReviews property here-->
        4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter=5">{{ numberOfFiveStarReviews }}</span> <!-- put the value from the numberOfFiveStarReviews property here-->
        5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
      </div>
    </div>

<!-- we will add a "Show Form" link that will display a form to add a new review -->
<!-- since we're not goint to a different URL when the button is clicked -->
<!--    we use a placeholder link "#" in the href= instead of a URL -->
<!-- use a boolean value to indicate should the form be displayed or not -->
<!-- show form link will toggle the boolean value that controls the form display -->
<!-- we need a click event handler to toggle the boolean value -->
<!-- v-on is how we add event handlers in Vue -->
<!-- we want to prevent the default behavior of clicking an <a> since we are handling the click ourselves -->
<!--      we want to stop the click of the anchor tag from going to the href (default behavior) -->

<a id="show-form-button"
    href="#"
    v-on:click.prevent="showForm = !showForm"> Show Form
</a>

<!-- define a form to collect the information for the new review -->
<!-- v-if on an element says display this element if the condition is true -->
<!-- display our new review form if showForm is true -->
<!-- when a submit is issued, don't fo to a URL with an HTTP request, we will handle it -->
<!--    the .prevent modifier stops the default behavior of an element -->
<form v-if="showForm === true" v-on:submit.prevent="addNewReview"> <!-- call addNewReview on submit -->
  <div class="form-element"> <!-- hold all the fields for the form -->
  <!-- define a field for reviewer and two-way bind it to a variabvle in JavaScript code -->
    <label for="reviewer"> Name: </label>
    <input id="reviewer" type="text" v-model="newReview.reviewer" />
  </div>
  <div class="form-element">
    <label for="title"> Title: </label>
    <input id="title" type="text" v-model="newReview.title" />
  </div>
  <div class="form-element">
    <label for="review"> Review: </label>
    <!-- textarea element allows for multi-line input -->
    <textarea id="review" type="text" v-model="newReview.review" />
  </div>
  <div class="form-element">
    <label for="rating"> Rating: </label>
    <select id="rating" v-model.number="newReview.rating">
      <option value="1"> 1 Star </option>
      <option value="2"> 2 Stars </option>
      <option value="3"> 3 Stars </option>
      <option value="4"> 4 Stars </option>
      <option value="5"> 5 Stars </option>
    </select>
  </div>

<!-- define a Save button to add the new review to our application and hide the form -->
<!-- default behavior for the button click is to submit the form to a URL with an HTTP request -->
<!--    we don't want to do that - we will add an event to the FORM for a click so we can handle it -->

<button> Submit </button>

<!-- define a cancel button to hide the form and not add the new review to the application -->
<!-- stop the default button action (.prevent) state it's a cancel (not a submit button) -->  

<button v-on:click.prevent="resetForm()" type="cancel"> Cancel </button>

</form>


  

<!-- we are coding a class "review" attribute for the div - class= -->
<!--    a conditional class "favorited" based on the variable favorited in the current review - v-bind class= -->
<!-- we want to generate one div for each element in the reviews array - v-for -->
<!-- v-for wants a v-bind:key to keep track of the elements it generates -->
<!-- all that needs to be coded in the div tag, not outside it -->
    <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in filteredReviews()"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <input type="checkbox" v-model="review.favorited" />
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Parties for Squirrels",
      author: 'Nutley McNutNut, Esquirrel', 
      description:
        "Host and plan the perfect cigar party for all of your squirrelly friends.",
      showForm: false, // control whether or not the new review form is displayed (true) or not displayed (false)
      newReview: {}, // hold the data from the new review form - empty object to start
      starFilter: 0, // hold the star value for reviews to be displayed - initialized to an invalid star value
      reviews: [
        {
          reviewer: "Rocky D'Flying Squirrel",
          title: "What a book!",
          review: "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
          rating: 3,
          favorited: false
        },
        {
          reviewer: "Bullwinkle J. Moose",
          title:  "Had a cigar party started in less than 4 hours.",
          review: "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
          rating: 4,
          favorited: true
         },
         {
          reviewer: "Boris Badenov",
          title:  "Maybe NOW I can get that pesky squirrel!",
          review:"I would have rated this book higher if I could read English",
          rating: 1,
          favorited: false
         },
         {
          reviewer: "Natasha Fatale",
          title: "And I thought I could write",
          review:"There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
          rating: 4,
          favorited: false
         },
         {
          reviewer: "Mr. Peabody (Hector J.)",
          title: "Many great ideas I could use if I smoked",
          review:"I received this book from my boy, Sherman.  I think he is dropping me a hint.",
          rating: 1,
          favorited: false
         },
          {
          reviewer: "Dudley DoRight",
          title: "I really liked it!",
          review:"Going to use the tips in my next Boxing Day party",
          rating: 4,
          favorited: true
         }
      ]
    };  // End of return
  }, // End of data()
  // computed properties are generated everytime something changes on the page
 computed: {
    averageRating() {
      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.reviews.length).toFixed(2); // .toFixed() will round a numeric value to the number of decimal places given
    },
    numberOfOneStarReviews() {
      return this.numberOfReviews(1); // call the common method for counting ratings with 1
    },
    numberOfTwoStarReviews() {
      return this.numberOfReviews(2); // call the common method for counting ratings with 2
    },
    numberOfThreeStarReviews() {
      return this.numberOfReviews(3); // call the common method for counting ratings with 3
    },
    numberOfFourStarReviews() {
      return this.numberOfReviews(4); // call the common method for counting ratings with 4
    },
    numberOfFiveStarReviews() {
      return this.numberOfReviews(5); // call the common method for counting ratings with 5
    }
  }, // end of computed

  // methods properties are generated only when called/referenced
  methods: {
    // count the number of reviews with rating we want to count passed in as a parameter
    numberOfReviews(numOfStars) {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === numOfStars);
      }, 0);
    },
    // method to add a new review from data entered in the form
    addNewReview () {
        this.reviews.unshift(this.newReview) // put the new review at the start of the array
        this.resetForm() // call the method to reset the form
    },
    
    resetForm () { // will set all the values in newReview to empty (clear) and hide the form
        this.showForm = false // set the form display variable to false so the form is hidden
        this.newReview = {} // set newReview to an empty object to clear any leftover data
    },

    filteredReviews () {
      // use the .filter array function to find all the reviews with the star rating we want
      // .filter() uses an anonymous function to create a new array based on the value returned from the function for each element
      return this.reviews.filter((aReview) => {
        return aReview.rating === this.starFilter || this.starFilter === 0 // return whether or not the rating in the current element equals the starFilter
      })
    }


  }  // End of methods
}; // End of export

</script>

<style scoped>
div.main {
  margin: 1rem 0;
}

div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review.favorited {
  background-color: lightyellow;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}
p.author {
  font-size: .75rem;
  font-style: italic;
}
div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input, div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type=button] {
  width: 100px;
}
form > input[type=submit] {
  width: 100px;
  margin-right: 10px;
}
</style>

