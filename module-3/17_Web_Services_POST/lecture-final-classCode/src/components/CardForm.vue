<!-- this will be displayed when the user wants to add a new card                       -->
<template>
<!-- when the submit button is clicked for the form, the submitForm method is run       -->
  <form v-on:submit.prevent="submitForm" class="cardForm">
    <!-- The follwing div will display only iif there is a a value in errorMsg          -->
    <!--  if errorMsg has a value display it: v-show="errorMsg"                         -->
    <!-- v-show show says display the element if the condition is true, hide if false   -->
    <!-- v-show="errorMsg" - true if errorMsg has a value, false if not (truthy/falsey) -->
    <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
    <div class="form-group">
      <label for="title">Title:</label>
      <input id="title" type="text" class="form-control" v-model="card.title" autocomplete="off" />
    </div>
    <div class="form-group">
      <label for="tag">Tag:</label>
      <select id="tag" class="form-control" v-model="card.tag">
        <option value="Feature Request">Feature Request</option>
        <option value="Design">Design</option>
        <option value="Q&A">Q&A</option>
      </select>
      <label for="status">Status:</label>
      <select id="tag" class="form-control" v-model="card.status">
        <option value="Planned">Planned</option>
        <option value="In Progress">In Progress</option>
        <option value="Completed">Completed</option>
      </select>
    </div>
    <div class="form-group">
      <label for="description">Description:</label>
      <textarea id="description" class="form-control" v-model="card.description"></textarea>
    </div>
    <button class="btn btn-submit">Submit</button>
    <!-- when the cancel button is clicked, call the cancelForm method                       -->
    <button class="btn btn-cancel" v-on:click.prevent="cancelForm" type="cancel">Cancel</button>
  </form>
</template>

<script>
import boardsService from "../services/BoardService";  // Access the BoardService.js code
import moment from "moment";                           // moment.js is simply to use date/time formatter

export default {
  name: "card-form",
  props: {
    cardID: {
      type: Number,  // Tell JavaScript the value must be a number and not a string
      default: 0
    }
  },
  data() {
    return {
      card: {   // model of a card object - all properties are two-way bound to form field
        title: "",
        description: "",
        status: "Planned",  // default status set to planned
        tag: "",
        avatar: "",
        date: null
      },
      errorMsg: ""  // this will be set to a message if an error occurs and display in the page (v-show)
    };
  },
  methods: {
    submitForm() { // this called when user want to add a card usingthe data in the form
      // create and populate a card object to be sent to the service that will call API server
      const newCard = {
        // boardID should be a numeric version of the path variable boardID (the board the card belongs in)
        boardId: Number(this.$route.params.boardID),  
        title: this.card.title,               // Set the title to the model card object title
        description: this.card.description,   // Set the description to the model card object description
        status: this.card.status,             // Set the status to the model card object status
        tag: this.card.tag,                   // Set the tag to the model card object tag
        avatar: "https://randomuser.me/api/portraits/lego/1.jpg",  // Get a random picture for avatar
        date: moment().format("MMM Do YYYY")  // use moment.js to format the current date
      };

      if (this.cardID === 0) {  // if cardId is 0, we know it's a new card - call addCard()
        // add
        boardsService           // Use a method in boardsService
          .addCard(newCard)     //     call addCard method with the newCard we created and popuated above
          .then(response => {   // Wait for the API call to get done
            if (response.status === 201) {                     // if the card was added OK (HTTP Status 201-Added)
              this.$router.push(`/board/${newCard.boardId}`);  // tell Vue Router to go back and display the board
            }
          })
          // .catch receives an error object which it can use to troubleshoot error
          .catch(error => {   // if the API call had an error (.catch) - call the handleErrorResponse method
                              //                                         we wrote using the error object
                              //                                          and a indicator of what we were doing
            this.handleErrorResponse(error, "adding");
          });
      } else {   // if cardID is not 0 - call updateCard() - cardID is passed to this view so for
                 //                                          so for a new card it will be 0
                 //                                             for an existing card ut will not be 0
        // update, but keep the values for data not entered in the form
        newCard.id = this.cardID;              // reset the newCard id to current card id
        newCard.avatar = this.card.avatar;     // reset the newCard avatar to current card avatar
        newCard.date = this.card.date;         // reset the newCard date to current card date
        boardsService
          .updateCard(newCard)
          .then(response => {
            if (response.status === 200) {
              this.$router.push(`/board/${newCard.boardId}`);
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "updating");
          });
      }
    },
    cancelForm() {  // is called when the user clicks the cancel button
      this.$router.push(`/board/${this.$route.params.boardID}`); // tell Vue Router to back to board page
                                                                 //      for the current board
    },
    handleErrorResponse(error, verb) {  // common error response handler - receives error object and a message
      // Two type of errors that can occur in an API call
      //     response error - request completed, but had an HTTP error status returned
      //     request error  - an error in the request itself and it probably didn't make it to the server
      //                      the request did complete - there is no HTTP status code

      if (error.response) {  // if it was a response error
        this.errorMsg =      // set the error message to word "Error", what was passed in, some more words
                             //     and the status text (a short description of the error) with a '.'
          "Error " + verb + " card. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) { // if it was a request error
        this.errorMsg =  //set errorMsg to a simple message
          "Error " + verb + " card. Server could not be reached.";
      } else {   // if it wasn't a response or request error (should never happen)
        this.errorMsg =   // set errorMasg to a generic description of the problem
          "Error " + verb + " card. Request could not be created.";
      }
    }
  },
  // created() hook is executed BEFORE Vue generates the HTML 
  //           and allows us to do processing required by the HTML (like getting data from API)
  created() {
    if (this.cardID != 0) { // If the card already exists (it has a cardID)
      boardsService
        .getCard(this.cardID)  // Go get it from the API server
        .then(response => {    //    wait for the API request to finish
          this.card = response.data; // then assign the response data (card from the server) to card property
        })
        .catch(error => {
          if (error.response && error.response.status === 404) { // if card not found on server
            alert(  // display a JavaScript alert window
              "Card not available. This card may have been deleted or you have entered an invalid card ID."
            );
            this.$router.push("/");  // go to home page
          }
        });
    }
  }
};
</script>


<style>
.cardForm {
  padding: 10px;
  margin-bottom: 10px;
}
.form-group {
  margin-bottom: 10px;
  margin-top: 10px;
}
label {
  display: inline-block;
  margin-bottom: 0.5rem;
}
.form-control {
  display: block;
  width: 80%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
textarea.form-control {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}
select.form-control {
  width: 20%;
  display: inline-block;
  margin: 10px 20px 10px 10px;
}
.btn-submit {
  color: #fff;
  background-color: #0062cc;
  border-color: #005cbf;
}
.btn-cancel {
  color: #fff;
  background-color: #dc3545;
  border-color: #dc3545;
}
.status-message {
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  text-align: center;
  padding: 10px;
  margin-bottom: 10px;
}
.status-message.success {
  background-color: #90ee90;
}
.status-message.error {
  background-color: #f08080;
}
</style>
