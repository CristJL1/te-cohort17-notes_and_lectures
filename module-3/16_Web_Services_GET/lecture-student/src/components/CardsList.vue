<template>
  <div>
    <h1>{{ title }}</h1>
    <div class="loading" v-if="isLoading">
      <img src="../assets/squirrel.gif" />
    </div>
      <!-- this <div> is displayed after the page is loaded (v-else) -->
      <!-- we are using 3 instances of the BoardColumn.vue component -->
      <!-- we pass the boardID property in this component with the path variable id (v-bind: boardID) -->
      <!-- '/board/:id' path is what gets uis to thsi compnent (through the router view) -->
      <!-- setting the cards propety in board-column to 'Planned' -->
    <div class="boards" v-else>
      <!-- we pass values for props defined in the BoardColumn.vue component -->
      <board-column
        title="Planned"
        v-bind:cards="planned"
        v-bind:boardID="this.$route.params.id"
      />
      <!-- setting the cards property to 'In Progress' -->
      <board-column
        title="In Progress"
        v-bind:cards="inProgress"
        v-bind:boardID="this.$route.params.id"
      />
      <!-- setting the cards property to 'Completed' -->
      <board-column
        title="Completed"
        v-bind:cards="completed"
        v-bind:boardID="this.$route.params.id"
      />
    </div>
    <!-- this <div> is displayed if the page is not loading -->
    <div class="board-actions" v-if="!isLoading">
      <!-- provide a link back to the home page (path="/") -->
      <router-link to="/">Back to Boards</router-link>
    </div>
  </div>
</template>

<script>
import boardsService from '../services/BoardService';
import BoardColumn from '@/components/BoardColumn';

export default {
  name: 'cards-list',
  components: {
    BoardColumn
  },
  data() {
    return {
      title: '',
      cards: [],
      isLoading: true
    };
  },
  created() {
    boardsService.getCards(this.$route.params.id) // call getCards() in boardServices with the id from 
    .then(response => {                           // wait for the API call getCards() to be done
                                                  // since the response contians many properties
                                                  // we have to identify which we want 
      this.title = response.data.title;          // copy the title property from response data to title
      this.cards = response.data.cards;           // copy the cards propety from response state to cards
      this.isLoading = false;                     // indicate page is done loading 
    });
  },
  computed: {
    planned() {
      return this.cards.filter(card => card.status === 'Planned');
    },
    inProgress() {
      return this.cards.filter(card => card.status === 'In Progress');
    },
    completed() {
      return this.cards.filter(card => card.status === 'Completed');
    }
  }
};
</script>

<style>
.boards {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 20px;
}
.board-actions {
  text-align: center;
  padding: 20px 0;
}
.board-actions a:link,
.board-actions a:visited {
  color: blue;
  text-decoration: none;
}
.board-actions a:hover {
  text-decoration: underline;
}
</style>
