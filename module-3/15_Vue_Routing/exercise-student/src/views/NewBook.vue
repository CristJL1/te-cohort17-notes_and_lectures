<template>
    <div class="newBooks">   <!-- a Vue template has EXACTLY one div -->
        <new-book-form />
    </div>    
</template>

<script>
import NewBookForm from '../components/NewBookForm.vue'



    
export default {
    components: {      // List of the Vue components used in this file
        NewBookForm
    }
}

</script>
<style scoped>

</style>