<template>
  <div id="sideNav">
    <h1>Squirrel Hotel System</h1>
    <div class="hotels">
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      <div class="loading" v-if="isLoading">
        <img src="../assets/animated-squirrel.gif" />
      </div>
      <div>
        <!-- define a click-able link to a router path named "HotelDetail" 
                with a parameter called id with the value of the current hotel's hotelID 
            one of these divs will be generated for each hotel in the hotels array in the data store 
            tag="div" tells Vue to generate the link as a <div> rather than an anchor (<a>) tag-->
        <router-link :to="{ name: 'HotelDetail', params: { id: hotel.id } }"
            class="hotel"
            v-for="hotel in this.$store.state.hotels"
            v-bind:key="hotel.id"
            tag="div"
      >
        {{ hotel.name }}
      </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import HotelService from '../services/HotelServices';

export default {
  name: "home",
  data() {
    return {
      isLoading: true,
      hotels: [],

       /* Start of temporary data for testing purposes */

      hotel : {  
        hotelID: 31952,
        name: "The Squrrel Den"
      },
      /* End of temporary data for testing purposes   */ 
      
       errorMsg: ''
      }   // End of return
  },  // End of data()
  created() {
    this.retrieveBoards();
    this.isLoading = false;
  },
  methods: {
    retrieveBoards() { // get the hotels from an API server
      HotelService.getHotels() // use the getHotels() method in the HotelService
      .then(response => { // wait for API call to finish (so we have data)
                         this.$store.commit("SET_HOTELS", response.data); // store the data in the data store
                         this.isLoading = false; // indicate we are done loading the page
                        })
      .catch (error => { // if there was an error in the API call
        if (error.response) { // if it was a response error - request completed, but with an error
          this.errorMsg = "Error submitting new board. Response received was '" + error.response.statusText + "'.";

        } else if (error.request) { // if it was a request error - request did not complete, may not have even gotten to the server
          this.errorMsg = "Error submitting new board. Server could not be reached.";

        } else { // if any other type of error occured (which it shouldn't)
          this.errorMsg = "Error submitting new board. Request could not be created.";
        }
        this.isLoading = false; // indicate we have not laoded the data for the page
      });
    }
  }
}
</script>

<style scoped>
div#sideNav {
  height: 100%;
  width: 20%;
  position: fixed;
  z-index: 1;
  left: 0;
  margin: 10px;;
  top: 0;
  padding-top: 20px;
  padding-bottom: 20px;
  overflow-x: hidden;
  border-right: solid lightgrey 1px;
}

h1 {
  text-align: center;
}

.boards {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}
/* .board {
  color: #f7fafc;
  border-radius: 10px;
  padding: 40px;
  flex: 1;
  margin: 10px;
  text-align: center;
  cursor: pointer;
  width: 60%;
}
.addBoard {
  color: #f7fafc;
  border-radius: 10px;
  background-color: #28a745;
  font-size: 16px;
  width: 60%;
  margin: 10px;
  padding: 20px;
  cursor: pointer;
}
.form-control {
  margin-bottom: 10px;
}
.btn {margin-bottom: 35px;}
.loading {
  flex: 3;
}
.board:hover:not(.router-link-active), .addBoard:hover {
  font-weight: bold;
}
.router-link-active {
  font-weight: bold;
  border: solid blue 5px;
}
*/
</style>