<!-- this uses the ReviewDisplay Vue component -->
<template>
  <div class="reviews">
    <!-- generate a ReviewDisplay component for each review in filteredReviews array                  -->
    <!-- pass the current review to the ReviewDisplay component for each one generated                -->
    <!--       v-bind:review="review"  ReviewDisplay will receive the data as a prop called review    -->
    <!--       v-bind:variable="props-name"   variable is in this program. props-name is in component -->
    <review-display
      v-for="review in filteredReviews"
      v-bind:key="review.title"
      v-bind:review="review"
    />
  </div>
</template>

<script>
import ReviewDisplay from "./ReviewDisplay";

export default {
  name: "review-list",
  components: {
    ReviewDisplay
  },
  computed: {
    filteredReviews() {
      // set this component's reviewsFiltered to Vuex data store filter property
      const reviewsFilter = this.$store.state.filter; 

      // Copy the reviews array from the Vuex data store
      const reviews = this.$store.state.reviews;
      return reviews.filter(aReview => {
        return reviewsFilter === 0 ? true : reviewsFilter === aReview.rating;
      });
    }
  }
};
</script>

<style>
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

div.main div.well-display div.well {
  cursor: pointer;
}
</style>
