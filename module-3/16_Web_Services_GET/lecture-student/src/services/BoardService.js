// this contains the services that are used by the application






import axios from 'axios'; // access the axios framework

const http = axios.create({ // instantiate an axios object to do our API calls
  baseURL: "http://localhost:3000" // we provide the axios object with the server baseURL
});

export default {

  // call the API server with the path 'boards' and return the data in the response
  // '/boards' returns all the boards as an array (tested in Postman)
  getBoards() {
    // http - name of the axios object we defined

    return http.get('/boards'); // call axios to do a GET with teh '/boards' path added to baseURL
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(boardID, cardID) {
    return http.get(`/boards/${boardID}`).then((response) => {
      const cards = response.data.cards;
      return cards.find(card => card.id == cardID);
    })
  }

}
