<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/meatwad.gif" />
    </div>
    <div v-else>
      <h1>{{ card.title }}</h1>
      <p>{{ card.description }}</p>
      <router-link
        tag="button"
        :to="{ name: 'EditCard', params: {cardID: $route.params.cardID} }"
        class="btn editCard"
      >Edit Card</router-link>
      <button class="btn deleteCard" v-on:click="deleteCard">Delete Card</button>
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
      <comments-list :comments="card.comments" />
    </div>

    <div class="board-actions" v-if="!isLoading">
      <router-link :to="{ name: 'Board', params: { id: $route.params.boardID } }">Back to Board</router-link>
    </div>
  </div>
</template>

<script>
import boardsService from "../services/BoardService";
import CommentsList from "@/components/CommentsList";

export default {
  name: "card-detail",
  components: {
    CommentsList
  },
  data() {
    return {
      isLoading: true,
      errorMsg: "",
    };
  },
  methods: {
    retrieveCard() {
      boardsService
        .getCard(this.$route.params.cardID)
        .then(response => {
          this.$store.commit("SET_CURRENT_CARD", response.data);
          this.isLoading = false;
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert(
              "Card not available. This card may have been deleted or you have entered an invalid card ID."
            );
            this.$router.push("/");
          }
        });
    },
    deleteCard() {
      if ( // display a confirmation box
        confirm(
          "Are you sure you want to delete this card? This action cannot be undone."
        )
      ) { // if the user clicked OK in the confirmation box
        boardsService // call the boardsService
          .deleteCard(this.card.id) // to delete it
          .then(response => {
            if (response.status === 200) { // if the API call to delete was successful
              alert("Card successfully deleted"); // display an alert box to say so
              this.$router.push(`/board/${this.card.boardId}`); // go back to the board's page
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error deleting card. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error deleting card. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error deleting card. Request could not be created.";
            }
          });
      }
    },
  },
  created() {
    this.retrieveCard();
  },
  computed: {
    card() {
      return this.$store.state.card;
    }
  }
};
</script>

<style>
.btn.editCard {
  color: #fff;
  background-color: #508ca8;
  border-color: #508ca8;
  margin-bottom: 10px;
}
.btn.deleteCard {
  color: #fff;
  background-color: #ef031a;
  border-color: #ef031a;
  margin-bottom: 10px;
}
</style>
