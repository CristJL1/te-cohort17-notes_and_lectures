<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ averageRating }}</span>
    Average Rating
  </div>
</template>

<script>
export default {
  name: "average-summary",
  methods: {
    // set the filter property in the data store to 0
    //    so all reviews will be displayed
    // use the UPDATE_FILTER mutation to do this
    // to call a mutation: this.$store.commit("mutation-name", value-to-pass)
    updateFilter() { 
        this.$store.commit("UPDATE_FILTER", 0)
    }
  },
  computed: {
    averageRating() {
      // reviews is the array that has the reviews to be processed by this function
      // the actual reviews are in the Vuex data store
      // we need to copy the reviews from the Vuex data store to this function
      const reviews = this.$store.state.reviews;
      let sum = reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / reviews.length).toFixed(2);
    }
  }
};
</script>
