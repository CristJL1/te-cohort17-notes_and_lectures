<!-- App.vue is the homepage for a Vue application - it's displayed when the app is started -->
<!-- the contents of the App.vue are inserted into the index.html page when the app is started -->
<!-- main.js is the main JavaScript program for Vue and it casuses the App.vue to be inserted into the index -->
<!-- this is where you add the necessary code for any Vue component to be used -->

<template> <!-- HTML for the Vue component -->
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- a Vue component is coded as a tag in your HTML -->
    <!-- HelloWorld is a Vue component in a file called HelloWorld.vue -->
    <!-- Vue components are coded in kabob-case when used in the HTML -->
    <!-- kabob-case is a name in all lowercase with dashes (-) between the main parts -->
    <!-- using kabob-case makes it easier to distinguish vue components from normal HTML tags -->
    <product-review/> <!-- using a Vue component called ProductReview.vue-->
  </div>
</template>

<script> // JavaScript for the component
// import the Vue component into the JavaScipt for the app
// src folder is the root folder for the app
// so all directory reference are relative to the src folder
import ProductReview from './components/ProductReview.vue' // access the ProductReview component

// allow Vue access to the data in the JavaScript code so it can use it and manipulate it
// for a Vue component the JavaScript code holds all the data
export default { // export exposes data in the JavaScript code to outside processes, like Vue
  name: 'App', // name of the application - associate this data object with an application
  components: { // list of Vue component used in the Application
    ProductReview // name of a Vue component - must match the name on the import
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
