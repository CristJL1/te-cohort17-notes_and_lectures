<template>     <!-- contains the HTML for our component  -->
   <div class="main">  <!-- a Vue template must have a single div -->
      <!-- use a value from data in the JavaScript code in the html                  -->
      <!-- code name of the variable/attribute in a mustache expression              -->
      <!--      a mustache expression is enclosed in {{ }}                           -->
      <!-- use of mustache expression is referred to as one-way data binding         -->
      <!-- one-way data binding means data can flow from the JavaScript code to html -->
      <!-- two-way data binding means data can flow from the JavaScript code to html -->
      <!--                                      and from the html to the JavaScript  -->
      <h2> Product Reviews for {{title}}</h2>  <!-- we will add data to this tag in a minute -->
      <p class='author'>(by {{author}})</p>
      <p class='description'>{{words}}</p>     <!-- we will add data to this tag in a minute  -->
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
    } // end of data()
} // end of export

</script>

<style scoped> /* contains the CSS for our component */

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
