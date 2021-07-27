<template>
  <div id="app" class="main">
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <div class="actions">
      <a href="#">Back to Products</a>&nbsp;|
      <a href="#">Add Review</a>
    </div>
    <div class="well-display">
      <average-summary />
      <star-summary rating="1" />
      <star-summary rating="2" />
      <star-summary rating="3" />
      <star-summary rating="4" />
      <star-summary rating="5" />
    </div>
    <review-list />
  </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary';
import StarSummary from '@/components/StarSummary';
import ReviewList from '@/components/ReviewList.vue';

export default {
    name: 'product-detail',
    components: {
        AverageSummary, 
        StarSummary, 
        ReviewList
    },
    // since this router view gets the id of the product selected by the user
    // it should set the active product property in the data store 
    // the setting of the activeProduct needs to be done before the page is displayed

    // the Vue life cycle called "created" allows us to do some processing
    //      Vue creates the HTML for the page
    // We will use the created hook to set the activeProduct in the data store
    created() { // use the created Vue life cycle hook 
    // get the id from the URL path
    // store the id in activeProduct in the data store
    // this.$route says this page's path ($route) tell Vue Router you want to access the path
    // params.id - the value in the path's paramter called id (id is named in the router configuration file)
    const activeProductIDfromPath = this.$route.params.id

    // store the id in activeProduct in the Vuex data store
    this.$store.commit('SET_ACTIVE_PRODUCT', activeProductIDfromPath)

    } // end of created() hook
}
</script>