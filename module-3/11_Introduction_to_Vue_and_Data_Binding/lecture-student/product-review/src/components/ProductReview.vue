<template> <!-- contains the HTML for our component --> 
    <div class="main"> <!-- a Vue template must have a single div -->
        <!-- use a value from data in the JavaScript code in the HTML -->
        <!-- code name of the varaible or attribute in a mustache expression -->
        <!-- a mustache expression is enclosed in {{}} -->
        <!-- use of a mustache expression is referred to as one-way data binding -->
        <!-- one-way data binding means data can flow from the JavaScript code to the HTML -->
        <!-- two-way data binding means data can flow from the JavaScript code to the HTML and vice versa -->
        <h2> Product Reviews for {{title}} </h2>
        <p class='description'>  {{words}} </p>

    </div>
    

</template>

<script> // contains the JavaScript for the component
export default { // expose the data in this JavaScript to Vue - allow Vue to acces this data
    name: 'product-review', // name of the component in kabob-case (matches name in HTML tag)
    data() {                // data to be shared with Vue needs to be in a function called data()
        return {
            title: 'Cigar Parties for Dummies', // variable to share with Vue
            words: 'Host and plan the perfect cigar party for your squirelly friends'
        } // end of return
    } // end of data()
} // end of export
    

</script>

<style scoped>  /*contains the CSS for our component*/

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
</style>