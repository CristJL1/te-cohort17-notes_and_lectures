<template>
    <div>
        <h1>{{ hotel.name }} Details</h1>

        <div>
           <router-link to="/">Return to Home</router-link>
        </div> 
    </div>
         
</template>
<script>

export default {
    name: "hotel-detail",
       data() {
        return { 
            hotel: { // define an empty object to hold the hotel for the page
                            // since the API returns the hotel data as an object, this must be an object  
              
        } // end of hotel object
    } // end of return
}, // end of data()
// since we need the hotel data before the page is generated (must use it in the HTML)
// we will use a created() hook, so Vue will get the data before it generates the page
created() {
    // we have two ways to get information on a specific hotel
        // get it from the Vue Data Store: this.$store.state.hotels.filter
            // pros: we already have the data from the API server, so there is no API call overhead
            // cons: the data in the data store may be stale, meaning it could have change since we got it

        // call the API server to retrieve it for us: write a service to call the API and then we call it
            // pros: we get the most up to date data
            // cons: the overhead for doing an API call and reliance on the network being up
}
} // end of export default
</script>
<style scoped>

</style>