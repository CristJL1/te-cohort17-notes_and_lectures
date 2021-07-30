

<template>
  <div id="app">
    <router-view />
    <nav>
      <a href="/">Home </a>

      <a href="/mybooks">| My Books</a>
    </nav>
  </div>
</template>

<script>



export default {
  name: 'app'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}
</style>
