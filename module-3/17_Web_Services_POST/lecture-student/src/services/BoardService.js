import axios from 'axios';

const http = axios.create({
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
  // code is new for today's lecture

  // this function will add a new card to API server resource
  // HTTP POST request is used to add to a server resource
  //
  // POST requires the data to be added to the body of the request
  //    the data can be a complete JSON object defined as a property in the code 
  //        or it can be an "inline JSON object" 
  //        {
  //        name: Frank,
  //        job: instructor,  
  //        }

  // a complete JSON object should be sent to the API server 
  addCard(card) { // receive the card to be added to the API resource
    return http.post('/cards', card); // issue an HTTP POST to the API server with the card parameter
  },

  // this function will update a card to API server resource
  // HTTP PUT request is used to update to a server resource
  //
  // PUT requires the data to be added to the body of the request
  //    the data can be a complete JSON object defined as a property in the code 
  //        or it can be an "inline JSON object" 
  //        {
  //        name: Frank,
  //        job: instructor,  
  //        }

  // a complete JSON object should be sent to the API server 

  // the REST protocol requires all properties in the object sent to the server for PUT be populated
  //                  not just the value that has changed

  // some servers simply replace the complete set of data in the resource with the data in the object
  //        others may examine the object and figure out what had changed and only change those values
  updateCard(card) { // receive the card to be updated from the server - must have all properties populated
    // code tick marks (`) to generate a string that has data value substitution(${})
    return http.put(`/cards/${card.id}`, card); // issue an HTTP PUT request using the card passed as a parameter
  },

  // since an HTTP DELETE does not require data in the body of a request, you don't need to specify an object
  //    it is possible to pass data with an axios delete(), it's not as simple as just add an object to the call
  //    it is NOT recommended you pass data in a delete, because most servers don't look for any data on an HTTP DELETE
  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`); // issue an HTTP DELETE for the cardID passed as a parameter
  },

  // this method will call the API server to add a Board to it's resources

  addBoard (aBoard) {
    return http.post('/boards', aBoard) // call the API path to add a board with the board we were given
  },

  // this will delete a board from API resource given the boardID

  deleteBoard(aBoardID) {
    return http.delete(`/boards/${aBoardID}`)
  }
}
