// Vue router configuration

import Vue from 'vue' // access the Vue framework
import VueRouter from 'vue-router' // access the Vue Router functionality

Vue.use(VueRouter) // tell Vue we are using the Vue router

import Products from '@/views/Products' // access the router view called Products.vue in the views folder
import ProductDetail from '@/views/ProductDetail' // access the router view called ProductDetail.vue in the views folder

const routes = [ // hold the path-router view associations - like @RequestMapping in controllers
{ // each path/router view association is in it's own object
path:'/', // associate the path '/' (root path) to a router view
name: 'products', // name for this path/router view association
component: Products // name of the router view component in the views folder
},
{ // a path with a value in it is referred to as a "dynamic path"
  path: '/products/:id', // associate this path with a router view
  name: 'product-detail', // name for this path router view association
  component: ProductDetail // name of the router view in the views folder
}
]

const router = new VueRouter({ // instantiate a Vue router object so we can use Vue Router
  mode: 'history', // use history mode - make it look to user as if we are using different pages
  //                      put the path in browser address bar and enable
  base: process.env.BASE_URL, // get the BASE_URL for the server from env file
  routes // name of the array with the path-router view associations
})

export default router // expose the Vue Router to external processes like Vue
