<!-- router view - which is Vue component so it has the same sections as a VUe component  -->
<template>
    <div class="myBooks">   <!-- a Vue template has EXACTLY one div -->
        <reading-list />
        <nav>
            <a href="/addbook"> Add Book to Reading List </a>
        </nav>
    </div>    
</template>

<script>

import ReadingList from '../components/ReadingList.vue'


    
export default {
    components: {      // List of the Vue components used in this file
        ReadingList
    }
}

</script>
<style scoped>

</style>