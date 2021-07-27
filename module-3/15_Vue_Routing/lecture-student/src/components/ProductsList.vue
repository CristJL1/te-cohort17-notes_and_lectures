<template>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th># Reviews</th>
      </tr>
    </thead>
    <tbody>
      <!-- make each item in the table that is displayed clickable -->
      <!-- when clicked it will link to the path named 'product-detail' -->
      <!-- the path was named in the router configuration file (index.js) -->
      <!-- we need to pass the path the id of the product clicked -->
      <tr v-for="product in $store.state.products" v-bind:key="product.id">
        <td>{{ product.id }}</td>
        <td> <!-- have clickable link to the product-detail path -->
             <!-- router link specifies a path teh router should go to -->
             <!-- like a <a href="url"/> -->
            <router-link
            v-bind:to="{name: 'product-detail', params: {id: product.id}}"
            >
            {{ product.name }}
            </router-link>
        </td>
        <td>{{ product.reviews.length }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "products-list"
};
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
</style>
