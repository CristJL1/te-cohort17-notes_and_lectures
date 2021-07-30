<template>
    <div class="bookDetails"> 
       <book-card v-bind:book="book" v-for="book in $store.state.books" v-bind:key="book.isbn" />
    </div>    
</template>

<script>
import BookCard from '../components/BookCard.vue'


    
export default {
    components: {      // List of the Vue components used in this file
        BookCard
    }
}

</script>
<style scoped>

</style>