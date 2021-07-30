import axios from 'axios';         // Access the Axois API call framework

const http = axios.create({        // Instantiate an Axios object with the base URL for the API server
  baseURL: "http://localhost:3000"
});

export default {

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(cardID) {
    return http.get(`/cards/${cardID}`)
  },
// Code is new for today's lecture

// this function will add a new card to API server resource
// HTTP POST request is used to add to a server resource
//
// POST requires the data to added to the body of HTTP request
//      the data can be a complete JSON object defined as property in the code like card in the example
//         or it can be an "inline" JSON object {
//                                               name: Frank,
//                                               job: "Instructor"
//                                              } 
// a complete JSON object should be sent to the API server
  addCard(card) {    // Receive the card to be added to the API resource
    return http.post('/cards', card);  // Issue an HTTP POST to the API server with the card parameter
  },

// this function will update a card on API server resource
// HTTP PUT request is used to update a server resource
//
// PUT requires the data to added to the body of HTTP request
//     the data can be a complete JSON object defined as property in the code like card in the example
//        or it can be an "inline" JSON object {
//                                               name: Frank,
//                                               job: "Instructor"
//                                              } 
// a complete JSON object should be sent to the API server
//
// the REST protocol requires all properties in the object sent to serve for PUT be populated
//                            not just the value that has changed
//
// some servers simply replace the complete set of data in the resource with the data in the object passed
//      others may examine the object passed and figure what has changed and ony change those values
  updateCard(card) {      // Receive the card to be updated on the server - must have all properties populated
    // code tick marks (`) to generate a string that has data value substitution (${})
    return http.put(`/cards/${card.id}`, card);  // Issue an HTTP PUT request using the card passed as a parameter
  },

  // since an HTTP DELETE does not require data in the body of the request, you don't need to specify an object
  //       it IS possible to pass data with an axios delete(), it's not as simple as just add an object in the call
  //       it is NOT recommended you pass data in a delete, because most server don't look for any data on an HTTP DELETE
  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`); // Issue an HTTP DELETE for the cardID passed as a parameter
  },

  // this method will call the API server to add a Board to it's resources
  addBoard(aBoard){
    return http.post('/boards', aBoard)  // call API path to add a board with the board we were given
  },

  // this will delete a board from API resource given the boardID
  deleteBoard(aBoardID) {
    return http.delete(`/boards/${aBoardID}`)
  }

}
