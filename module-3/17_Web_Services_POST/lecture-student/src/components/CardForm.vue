<template>
<!-- when the submit button is clicked for the form, the submitForm method is run -->
  <form v-on:submit.prevent="submitForm" class="cardForm">
    <!-- the following <div> will display only if there is a value in errorMsg -->
    <!-- if errorMsg has a value display it: v-show="errorMsg" -->
    <!-- v-show says display the element if the condition is true, hide it if it's false -->
    <!-- v-show="errorMsg" - true is errorMsg has a value, false is not (truthy/falsey) -->
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
    <!-- when the cancel button is clicked, call the cancelForm method -->
    <button class="btn btn-cancel" v-on:click.prevent="cancelForm" type="cancel">Cancel</button>
  </form>
</template>

<script>
import boardsService from "../services/BoardService"; // access the BoardService.js
import moment from "moment"; // moment.js is simply to use date/time formatter

export default {
  name: "card-form",
  props: {
    cardID: {
      type: Number, // telling JavaScript the value must be a number and not a string 
      default: 0
    }
  },
  data() {
    return {
      card: { // model for a card object - all properties are two-way bound to a form field
        title: "",
        description: "",
        status: "Planned", // default status set to planned
        tag: "",
        avatar: "",
        date: null
      },
      errorMsg: "" // this will be set to a message if an error occurs and displayed in the page (v-show)
    };
  },
  methods: {
    submitForm() { // this is called when user wants to add a card using the data in the form
    // create and populate a card object to be sent to the service that will call API server
      const newCard = {
        boardId: Number(this.$route.params.boardID), // boardID should be a numeric version of the path variable boardID (the board the card belongs in)
        title: this.card.title,                       // set the title to the model card object title
        description: this.card.description,           // set the description to the model card object description
        status: this.card.status,                     // set the status to the model card object status
        tag: this.card.tag,                           // set the tag to the model card object tag
        avatar: "https://randomuser.me/api/portraits/lego/1.jpg", // get a random picture for avatar
        date: moment().format("MMM Do YYYY") // use moment.js to format the current date
      };

      if (this.cardID === 0) { // if cardID is 0, we know it's a new card - call addCard()
        // add
        boardsService         // use a method in boardService
          .addCard(newCard)   // call addCard() method with the newCard we created and populated above
          .then(response => { // wait for the API call to get done
            if (response.status === 201) {                    // if the card was added OK
              this.$router.push(`/board/${newCard.boardId}`); // tell Vue Router to go back and display the board
            }
          })
          // .catch receives an error object which it can use 
          .catch(error => { // if the API call had an error (.catch) - call the handleErrorResponse method
                            //          we wrote using the error object and an indicator of what we were doing
            this.handleErrorResponse(error, "adding");
          });
      } else { // if cardID is not 0 - call updateCard() - cardID is not passed to this view 
      //                                                                so for a new card it will be 0
      //                                                                for an existing card it will not be 0
        // update, but keep the values for data not entered in the form 
        newCard.id = this.cardID;           // reset the newCard id to current card id
        newCard.avatar = this.card.avatar;  // reset the newCard avatar to current card avatar
        newCard.date = this.card.date;      // reset the newCard date to current card date
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
    cancelForm() { // is called when user clicks the cancel button 
      this.$router.push(`/board/${this.$route.params.boardID}`); // tell Vue Router to go back to board page
      //                                                              for the current board
    },
    handleErrorResponse(error, verb) { // common error response handler - receives error object and a message
    // two types of errors that can occur in an API call
    // response error - request completed, but had an HTTP error status returned 
    // request error - there was an error in the request itself and it probably didn't even make it to the server
    //                        specifically the request did not complete - there is no HTTP status code
      if (error.response) { // if it was a response error
        this.errorMsg =     // set the error message to word "Error", what was passed in, some more words
                            // and the status text (a short description of the error) with a "."
          "Error " + verb + " card. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) { // if it was a request error
        this.errorMsg = // set errorMsg to a simple message
          "Error " + verb + " card. Server could not be reached.";
      } else { // if it wasn't a response or request error (should never happen)
        this.errorMsg = // set errorMsg to a generic description of the problem
          "Error " + verb + " card. Request could not be created.";
      }
    }
  },
  // created() hook is executed BEFORE Vue generates the HTML and allows us to do processing required by the HTML
  //                          such as getting data from the API
  created() {
    if (this.cardID != 0) { // if the card already exists (it has a cardID)
      boardsService
        .getCard(this.cardID) // go get it from the API server
        .then(response => { // wait for the API request to finish
          this.card = response.data; // then assign the response data (card from the server) to card property
        })
        .catch(error => {
          if (error.response && error.response.status === 404) { // if card not found on server
            alert( // display a JavaScript alert window
              "Card not available. This card may have been deleted or you have entered an invalid card ID."
            );
            this.$router.push("/"); // go back to the home page
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
