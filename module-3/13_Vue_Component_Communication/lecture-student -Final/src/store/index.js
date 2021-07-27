import Vue  from 'vue'   // Access to Vue framework
import Vuex from 'vuex'  // Access the Vuex part of Vue

Vue.use(Vuex)   // Tell Vue we are using Vuex

// export will expose data to outside process like components and Vue
export default new Vuex.Store({  // define a new Vuex data store
  // state is the name of the object containing all the data in the Vuex data store
  state: {
    name: 'Cigar Parties for Dummies',
    description: 'Host and plan the perfect cigar party for all of your squirrelly friends.',
    filter: 0,
    reviews: [
      {
        reviewer: 'Malcolm Gladwell',
        title: 'What a book!',
        review:
          "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
        rating: 3,
        favorited: false
      },
      {
        reviewer: 'Tim Ferriss',
        title: 'Had a cigar party started in less than 4 hours.',
        review:
          "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
        rating: 4,
        favorited: false
      },
      {
        reviewer: 'Ramit Sethi',
        title: 'What every new entrepreneurs needs. A door stop.',
        review:
          "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
        rating: 1,
        favorited: false
      },
      {
        reviewer: 'Gary Vaynerchuk',
        title: 'And I thought I could write',
        review:
          "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
        rating: 3,
        favorited: false
      }
    ],
  },
  // mutations are functions defined in methods section to change data in the data store
  // generally a mutation receives the data store and the data to be used to change it
  // the data store parameter is automatically provided by Vue when mutation is called
  //     all that is coded when the mutation is called is any values needed to be passed to it
  // by convention mutation names are all uppercase with _ between words
  // a Vuex rule is that any changes to the data store happen in a mutations (Single Responsibility)
  mutations: {
    ADD_REVIEW(state, review) {       // Add a review to the start of the reviews array
      state.reviews.unshift(review);
    },
    UPDATE_FILTER(state, filter) {    // Change the value in the filter variable
      state.filter = filter;
    },
    FLIP_FAVORITED(state, reviewToChange) {  // Toggle favorited between true and false
      reviewToChange.favorited = ! reviewToChange.favorited;
    }
  },
  actions: {
  },
  modules: {
  },
  strict: true  // Enforce the rule that changes to the data store can only be done by mutations
})
