// this contains the services used by the application

// axios is framework to make it easier to APIs from JavaScript
// Calls to APIs are asynchronous
//      Asynchronous means you don't wait for it to finish before continuing
// Normally when you execute a JavaScript statement you don't move to the 
//        next statement until it's done (Synchronous)
//
// With API Asynchronous processing you move to the next statement as soon 
//        as the API call is issued
// The next statement could execute before the API call is done - which may be a problem
// Since we don't know how long the API call will take to complete,
//       if subsequent processing depends on the API call, we need to wait until it's done
//
// When you do an async call to API, the call issues a promise
// a promise is notification from the API call it will tell you when it is done
//
// .then() for an API call says when the promise is fulfilled (API call completes), do this processing

import axios from 'axios';  // Access the axios framework

const http = axios.create({          // instantiate an axios object to do our API calls
  baseURL: "http://localhost:3000"   //    we provide the axios object with the server baseURL
});

export default {  // Expose the contents to external processes like the application or Vue

  // services methods that can be used by the app

  // Call the API server with the path '/boards' and return the data in the response
  // '/boards' returns all the boards as an array (tested in Postman)
  getBoards() {
    //     http   - name of the axios object we defined
    //     .get() - do an HTTP GET request with the path given added to baseURL
    //     .get() - returns the response object from the HTTP GET (data is in body of response)
    return http.get('/boards');  // call axios to do a GET with the '/boards' path added to baseURL
  },

  // call the API to retrieve the cards for the boardID it is passed
  getCards(boardID) {
    return http.get(`/boards/${boardID}`)  // issue an async API call and return a promise
  },

  getCard(boardID, cardID) {
    return http.get(`/boards/${boardID}`).then((response) => {
      const cards = response.data.cards;
      return cards.find(card => card.id == cardID);
    })
  }

}
