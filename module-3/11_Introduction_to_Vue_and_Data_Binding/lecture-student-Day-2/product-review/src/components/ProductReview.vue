<template>     <!-- contains the HTML for our component  -->
   <div class="main">  <!-- a Vue template must have a single div -->
      <!-- use a value from data in the JavaScript code in the html                  -->
      <!-- code name of the variable/attribute in a mustache expression              -->
      <!--      a mustache expression is enclosed in {{ }}                           -->
      <!-- use of mustache expression is referred to as one-way data binding         -->
      <!-- one-way data binding means data can flow from the JavaScript code to html -->
      <!-- two-way data binding means data can flow from the JavaScript code to html -->
      <!--                                      and from the html to the JavaScript  -->
      <h2> Product Reviews for {{title}}</h2>  <!-- substitute the value in title -->
      <p class='author'>(by {{author}})</p>    <!-- substitute the value in author  -->
      <p class='description'>{{words}}</p>     <!-- substitute the value in words  -->

      <div class="well-display">

        <div class="well">
          <span class="amount"> {{averageRating}} </span>
          Average Rating
          </div>

        <div class="well">
          <span class="amount"> {{numberOfOneStarReviews}} </span>
          1 Star Rating
          </div>

        <div class="well">
          <span class="amount"> {{numberOfTwoStarReviews}} </span>
          2 Star Rating
          </div>

        <div class="well">
          <span class="amount"> {{numberOfThreeStarReviews}} </span>
          3 Star Rating
          </div>

        <div class="well">
          <span class="amount"> {{numberOfFourStarReviews}} </span>
          4 Star Rating
          </div>

        <div class="well">
          <span class="amount"> {{numberOfFiveStarReviews}} </span>
          5 Star Rating
          </div>

      </div>

          

      <!-- add an element to our page for each element in our reviews array -->
      <!-- define a <div> to hold all the review element on the page -->
      <!-- add class="rating" to the div so it is styled as a rating as define in the CSS-->
      <!-- add a class="favorited" depending on the value in the reviews.favorited variable -->
      <!-- if reviews.favorited is true, the class="favorited" is added to the div -->
      <!-- if reviews.favorited is false, the class="favorited" is removed from the div -->
      <!-- this is called additional class specifications - a class is included if a condition is true -->
      <!-- v-bind:class lets us add a specific class attribute to a tag using data in the JavaScript code -->

      <!-- v-for will generate one <div> element in the page for each element in the array -->
      <!-- v-bind:key="" is used by Vue to maintain the sequence of elements if any are added-->
      <!--          since we are not adding/deleting elements, we don't care what is used -->
      <!--          in v-bind:key, so we use a non-existant variable called id -->
      <!-- each element in the array will be assigned the name aReview for each element generated -->
    <div class="review"
        v-bind:class="{favorited: aReview.favorited}"
        v-for="aReview in reviews" v-bind:key="aReview.id"
        > <!-- end of <div> tag -->
    <h4>{{aReview.reviewer}}</h4>
    <!-- generate a star img based on the value in rating -->
    <!-- use the v-for to generate an img tag based on the rating -->
    <!-- it's OK that rating is not an array, we use the alternate syntax -->
    <!--          v-for n in a variable -->
    <div class="rating">
      <img src="../assets/star.png"
    class="ratingStar"
    v-for="n in aReview.rating" v-bind:key="n"
    /> <!-- end of the <img> tag -->
    </div>
    <h3> {{aReview.title}}</h3>
    <p> {{aReview.review}}</p>
    <!-- add a check box so user can indicate if a review if their favorite -->
    <!-- we are going to connect the checkbox to the favorited attribute of the array element -->
    <!-- if the check box is checked, favorited will be set to true -->
    <!-- if the check box is un-checked, favorited will be set to false -->
    <!-- if favorited is true, the check box will be checked -->
    <!-- if favorited is false, the check box will be un-checked -->

    <!-- connecting an element to a variable in the JavaScript code is two-way binding -->
    <!-- v-model is how we use two-way binding in Vue -->
    <p>
      Favorite?
      <input type="checkbox" v-model="aReview.favorited"/>
      </p>
      </div>

   </div> 

</template>

<script>          // contains the JavaScript for our component
export default {  // expose the data in this JavaScript to Vue - allow Vue access to this data
    name: 'product-review',  // name of the component in kabob-case (matches name in html tag)
    data() {                 // data to be shared with Vue needs to be in a function called data()
        return {             // the data() function returns an object with the data to be shared with Vue
           title : 'Cigar Parties for Squirrels',                                       // variable/attribute to share with Vue
           words : 'Host and plan the perfect cigar party for your squirrely friends',  // variable/attribute to share with Vue
           author: 'Nutley McNutNut, Esquirrel',                                        // variable/attribute to share with Vue
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
                      favorited: false
                      },
                      {
                      reviewer: "Boris Badenov",
                      title:  "What every new entrepreneurs needs. A door stop.",
                      review:" When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
                      rating: 1,
                      favorited: false
                      },
                      {
                      reviewer: "Natasha Fatale",
                      title: "And I thought I could write",
                      review:"There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
                      rating: 3,
                      favorited: false
                      }
           ]
        }  // end of return
    }, // end of data()
    // computed section will compute/generate properties when data on the page changes
    computed: {

      averageRating() { // calculate the average rating of all reviews
        // sum all the rating values in the reviews array and divide it by the number of reviews
      let sum = this.reviews.reduce((totalRating, aReview) => {
        return totalRating += aReview.rating; // add the current rating to totalRating
      } // end of anonymous function
      , 0) // end of .reduce(); ", 0" initializes totalRating and makes it a number
        return sum / this.reviews.length // return the average as a sum divided by the number of reviews
      }, // end of averageRating



      numberOfOneStarReviews() { // a property that will be calculated every time something on the page changes
      // go through the arrays one element at a time and count the number of 1-star reviews
      // we need to reduce the array to the number of one star reviews
      // use the array reduce function to accomplish this
      // .reduce takes one parameter which is a function to hold the result (reducer)
      //        and another parameter which is a function that takes two parameters the current array element and modifies the reducer
      // the return for the property is the value the property represents
      // this.reviews is the array we want to reduce - this. indicates it is in this component
      return this.reviews.reduce((currentCount, aReview) => {
        if (aReview.rating === 1) {
          currentCount++
        }
        return currentCount
      }, 0) // ", 0" initializes the reducer and makes it a number; end of anonymous function and .reduce()
      }, // end of numberOfOneStarReviews()

      numberOfTwoStarReviews() {
        return this.reviews.reduce((currentCount, aReview) => {
        if (aReview.rating === 2) {
          currentCount++
        }
        return currentCount
      }, 0)
      }, // end of numberOfTwoStarReviews()

      numberOfThreeStarReviews() {
        return this.reviews.reduce((currentCount, aReview) => {
        if (aReview.rating === 3) {
          currentCount++
        }
        return currentCount
      }, 0)
      }, // end of numberOfThreeStarReviews()

      numberOfFourStarReviews() {
        return this.reviews.reduce((currentCount, aReview) => {
        if (aReview.rating === 4) {
          currentCount++
        }
        return currentCount
      }, 0)
      }, // end of numberOfFourStarReviews()

      numberOfFiveStarReviews() {
        return this.reviews.reduce((currentCount, aReview) => {
        if (aReview.rating === 5) {
          currentCount++
        }
        return currentCount
      }, 0)
      } // end of numberOfFiveStarReviews()


    },// end of computed section
} // end of export

</script>

<style scoped> /* contains the CSS for our component 
                      scoped on the <style> says that this CSS only applies to this specific component
                        if scoped is omitted the CSS will be applied to all components on the page
                          which may lead to weird, confusing, and undesireable styling 
                          
                          Rule of Thumb: ALWAYS use scoped on the <style> in Vue component*/

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
</style>
