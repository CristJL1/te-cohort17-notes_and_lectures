<!-- router view - which is Vue component so it has the same sections as a VUe component  -->
<template>
    <div class="books">   <!-- a Vue template has EXACTLY one div -->
        <best-seller-list />   <!-- use the ProductList.vue component  -->
        <new-releases-list />
    </div>    
</template>

<script>

    // import BestSellerList from '@/components/BestSellerList' 
    // import NewReleasesList from '@/components/NewReleasesList'
import NewReleasesList from '../components/NewReleasesList.vue'
import BestSellerList from '../components/BestSellerList.vue'
    
export default {
    components: {      // List of the Vue components used in this file
        BestSellerList,
        NewReleasesList
    }
}

</script>
<style scoped>

</style>