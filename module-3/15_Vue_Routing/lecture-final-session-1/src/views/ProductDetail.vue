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
      components : {
          AverageSummary,
          StarSummary,
          ReviewList
      },
      // Since this router view gets the id pf the product selected by the user
      // it should set the activeProduct property in data store
      // The setting of activeProcuct needs too be done before the component page is displayed
      //
      // The Vue life cycle hookcalled "created" allows us to do some processing 
      //         Vue creates the HTML for the page
      // We will the created hook to set activeProduct in the data store
      created() {  // use the created Vue life cycle hook  
      
         //      this.$route - this page's path ($route) tell Vue Router you want to access the path
         //      params.id   - the value in the path's parameter called id (id is named in router config file)
         const activeProductIDfromPath = this.$route.params.id   // get the id from the URL path

        // store the id in activeProduct in the Vuex data store
         this.$store.commit('SET_ACTIVE_PRODUCT', activeProductIDfromPath)
         
        }  // End of created() hook
}  // end of export
</script>
