<!-- router view - which is Vue component so it has the same sections as a Vue component -->

<template>
    <div class="products"> <!-- a Vue template has EXACTLY one div -->
        <h1>Products</h1> <!-- simple page heading -->
        <products-list />  <!-- use the ProductsList.vue component -->
    </div>
</template>

<script>
    // the '@' replaces the relative address we were using in earlier code
    import ProductsList from '@/components/ProductsList' // access the ProductsList.vue from the components folder

export default {
    components: {
        ProductsList
    }
}

</script>

<style scoped>

</style>