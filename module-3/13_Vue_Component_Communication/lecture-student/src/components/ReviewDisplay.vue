<template>
  <div class="review" v-bind:class="{ favorited: review.favorited }" v-bind:key="review.id">
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
      <!-- add an event handler so when the checkbox chnages we run onFavoritedChange() for the review -->
      <input
        type="checkbox"
        v-bind:checked="review.favorited"
        v-on:change="onFavoritedChange(review)"
      />
    </p>
  </div>
</template>

<script>
export default {
  name: "review-display",
  // props is used for data that comes from outside the component
  //              it can come from other components that use this one or from events
  // we are expecting an array we will call review from outside thsi component
  // the ReviewList component that uses this component will pass the data for the props named review
  props: ["review"], // the review to be displayed by this component
  methods: {
    onFavoritedChange() { // use the data store mutation to toggle favorited variable
      this.$store.commit("FLIP_FAVORITED", this.review)
    }
  }
};
</script>

<style>
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
