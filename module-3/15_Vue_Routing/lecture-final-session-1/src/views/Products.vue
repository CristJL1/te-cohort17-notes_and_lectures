<!-- router view - which is Vue component so it has the same sections as a VUe component  -->
<template>
    <div class="products">   <!-- a Vue template has EXACTLY one div -->
        <h1>Products</h1>   <!-- simple page heading                -->
        <products-list />    <!-- use the ProductList.vue component  -->
    </div>    
</template>

<script>
    // the '@' replaces the relative address use were using in earlier code
    import ProductsList from '@/components/ProductsList'  // Access the ProductsList.vue from components folder
 
export default {
    components: {      // List of the Vue components used in this file
        ProductsList   // Name of .vue file of a component we use 
    }
}

</script>
<style scoped>

</style>