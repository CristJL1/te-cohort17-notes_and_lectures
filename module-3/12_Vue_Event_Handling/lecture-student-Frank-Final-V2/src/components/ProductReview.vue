<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>
    <p class='author'>(by {{author}})</p> 
    <p class="description">{{ description }}</p>``

    <!-- if one of the summary boxes is clicked only show rating for the number of stars for the summary       -->
    <!-- if Average rating is clicked - show all reviews                                                       -->
    <!-- we need to filter the elements in the array that is displayed to only have reviews for stars selected -->
    <!-- we need a new array to hold only the reviews with the stars selected - we need original array         -->
    <!-- sounds like a method to filter the reviews for whatever star is clicked                               -->
    <!--        we call the method when a summary box is clicked with the number of stars it represents        -->

    <div class="well-display">
      <div class="well">
        <span class="amount" v-on:click="starFilter=0">{{ averageRating }}</span>              <!--  put the value from the averageRating property here -->
        Average Rating
      </div>

      <!-- when a box is clicked set the starFilter the rating the box is summarizing -->
      <!-- the filteredReviews() method uses the value in starFilter                  --> 
      <div class="well">
        <span class="amount" v-on:click="starFilter=1">{{ numberOfOneStarReviews }}</span>     <!--  put the value from the numberOfOneStarReviews property here     -->
        1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}   <!--  adds an 's' to word Review if it should be plural               -->
                                                                     <!--  if the numberOfOneStarReviews is equal to 1 - no 's' at the end -->
                                                                     <!--  if the numberOfOneStarReviews is not 1 -put an 's' at the end -->
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter=2">{{ numberOfTwoStarReviews }}</span>     <!--  put the value from the numberOfTwoStarReviews property here     -->
        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter=3">{{ numberOfThreeStarReviews }}</span>   <!--  put the value from the numberOfThreeStarReviews property here     -->
        3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter=4">{{ numberOfFourStarReviews }}</span>    <!--  put the value from the numberOfFourStarReviews property here     -->
        4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="starFilter=5">{{ numberOfFiveStarReviews }}</span>    <!--  put the value from the numberOfFiveStarReviews property here     -->
        5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
      </div>
    </div>

    <!-- We will add a "Show Form" link that will display a form to add a new review             -->
    <!-- since we are not going to a different URL when the button is clicked                    -->
    <!--       we use a placeholder link "#" in the href= instead of a URL                       -->
    <!-- use a boolean value to indicate should the form be displayed or not                     -->
    <!-- show form link will toggle the boolean value that controls form display                 -->
    <!-- we need a click event handler to toggle the boolean value                               -->
    <!-- v-on is how we add event handlers in Vue                                                -->
    <!-- we want to prevent the default behavior of click an <a> since we are handling the click -->
    <!--    we want stop teh click of <a> from going to the href (default behavior)              -->
    <!-- !boolean - toggles from true and false                                                  -->
    <!--      if showForm is true - "Hide Form", if showForm is false - "Show Form"              -->
    <a id="show-form-button"
       href="#"
       v-on:click.prevent="showForm = !showForm">{{ showForm ? "Hide Form" : "Show Form" }}  
    </a>

    <!-- define a form to collect the information for the new review                                    -->
    <!-- v-if on an element says display this element of the conditon is true                           -->
    <!-- display our new review form is showForm is true                                                -->
    <!-- when a submit is issued, don't go to a URL with and HTTP request, we will handle it            -->
    <!--    the .prevent modifier stops the default behavior of an element                              -->
    <!-- We will handle the submit with a function in the methods section of JavaScript Code            -->
    <form v-if="showForm === true" v-on:submit.prevent="addNewReview"> <!-- call addNewReview on submit -->
      <div class="form-element">   <!-- hold all the fields for the form                 -->
      <!-- define an field for reviewer and two-bind it to a variable in JavaScript code -->
        <label for="reviewer">Name:</label>
        <input  id="reviewer" type="text" v-model="newReview.reviewer" /> 
      </div>

       <div class="form-element">   <!-- hold all the fields for the form                 -->
      <!-- define an field for title and two-bind it to a variable in JavaScript code -->
        <label for="title">Title:</label>
        <input  id="title" type="text" v-model="newReview.title" /> 
      </div>

       <div class="form-element">   <!-- hold all the fields for the form                 -->
      <!-- define an field for rating and two-bind it to a variable in JavaScript code -->
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating"> <!-- .number store as number instead of string                -->
          <option value="1">1 Star</option>                    <!-- value="" is what is returned when the option is selected -->
          <option value="2">2 Stars</option> 
          <option value="3">3 Stars</option> 
          <option value="4">4 Stars</option> 
          <option value="5">5 Stars</option> 
        </select>
      </div>

       <div class="form-element">   <!-- hold all the fields for the form                 -->
      <!-- define an field for review and two-bind it to a variable in JavaScript code    -->
      <!-- a textarea element allows multi-line input  -->
        <label   for="review">Review:</label>
        <textarea id="review" type="text" v-model="newReview.review" /> 
      </div>

    <!-- define a Save button to add the new review to our application and hide the form           -->
    <!-- Default behavior for the button click is to submit the form to a URL with an HTTP request -->
    <!-- we don't want to do that - we will add an evenet to FORM for a click so we can handle     -->
    <!-- disable submit button if form is not valid                                                -->
    <input type="submit" value="Save" v-bind:disabled="!isFormValid"/>
    
    <!-- define a Cancel button to hide the form and not add the new review to the application  -->
    <!-- stop the default button action (.prevent) state it's a cancel (not a submit button)    -->
    <input type="button" value="Cancel" v-on:click.prevent="resetForm()" />
    </form>

    <!-- we coding a class "review" attribute for the div - class=                                                       -->
    <!--           a conditional class "favorited" based on the variable favorited in the current review - v-bind:class= -->
    <!-- we want generate on e div for each element in the reviews array - v-for                                         -->
    <!--         v-for want a v-bind:key inkeep track of the elements it generates                                       -->
    <!-- all that needs to coded in the div tag, not outside it                                                          -->
    <!-- loop thorugh filteredReviews (which has selected reviews) rather than reviews (which all the reviews)           -->
    <!-- Note: theh () in filteredReview() due to it being it being a method call and not a regualr property              -->
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
      showForm: false,      // control whether or not the new review form is displayed or not (true=display)
      newReview: {},        // hold the data from the new review form - empty object to start
      starFilter: 0,        // hold the star value for reviews to be displayed - initialized to an invalid star value
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
      return (sum / this.reviews.length).toFixed(2);  // .toFixed() will round a numeric value to the number of decimal places given
    },
    numberOfOneStarReviews() {
      return this.numberOfReviews(1);  // call the common method for counting ratings with 1
    },
    numberOfTwoStarReviews() {
      return this.numberOfReviews(2);  // call the common method for counting ratings with 2
    },
    numberOfThreeStarReviews() {
      return this.numberOfReviews(3);  // call the common method for counting ratings with 3
    },
    numberOfFourStarReviews() {
      return this.numberOfReviews(4);  // call the common method for counting ratings with 4
    },
    numberOfFiveStarReviews() {        // call the common method for counting ratings with 5
      return this.numberOfReviews(5);
    },
    isFormValid() { // Determine is form content is valid - all fields have been entered - uses truthy/falsey logic
      return this.newReview.reviewer   // true if reviewer is not empty, false if it is
          && this.newReview.title      // true if title is not empty, false if it is
          && this.newReview.rating     // true if rating is not empty, false if it is
          && this.newReview.review      // true if review is not empty, false if it is 
    }
  },  // End of computed
  // method properties are generated only when called/referenced
  methods: {
    // Count the number of reviews with rating we want to count passed in as a parameter
    // Simplify what we did yesterday - 5 separate properties with only the rating value we were looking different
    numberOfReviews(numOfStars) {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === numOfStars);
      }, 0);
    },

    // method to add a new review from data entered in the form
    addNewReview() {
      this.reviews.unshift(this.newReview)  // put the new review at the start of array
      this.resetForm()                      // call the method to reset the form (hide and clear newReview)
    },

    resetForm() {  // will set all the values in newReview to empty (clear) and hide the form
      this.showForm = false;  // Set the form display variable to false so the form is hidden
      this.newReview = {}     // Set newReview to an empty object to clear any leftover data
    },

    // This method will fiter the reviews array and only have the reviews with the star value clicked
    // We need a variable to hold the star value clicked
    filteredReviews() { 
      // use the .filter array function to find all the reviews with the star rating we want
      // .filter() uses a function to create a new array based on the value returned from function for each element
      //                if function returns true for the current element, it is added to resulting array
      //                                    false for teh current element, it is NOT added to resulting array
      //           we pass the function the current element of the array
      return this.reviews.filter((aReview) => {
        // return whether or not the rating in the current element equals starFilter or starFilter is 0 indicating all reviews
        return aReview.rating === this.starFilter || this.starFilter === 0 
    // alternate coding
    //    if (aReview.rating === this.starFilter || this.starFilter === 0) {
    //      return true
    //    }
    //    else {
    //      return false
     //   }
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

