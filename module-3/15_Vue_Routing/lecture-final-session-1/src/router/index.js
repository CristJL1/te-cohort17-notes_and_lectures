// Vue Router configuration

import Vue from 'vue'              // Access tne Vue framework
import VueRouter from 'vue-router' // Access Vue Router functionality

// @ is shorthand notation for the application root folder
import Products      from '@/views/Products'         // Access the router view called Products.vue in the views folder
import ProductDetail from '@/views/ProductDetail'    // Access the router view called ProductDetail.vue in the views folder    

Vue.use(VueRouter)    // Tell Vue we are using the Vue Router

const routes = [   // Hold the path-router view associations - like @RequestMapping in Controllers
  {    // each path/router view association is in it's own object
    path: '/',            // associate the path '/' (root path) to a router view
    name: 'products',     // name for this path/router view association
    component: Products   // name of the router view component in the views folder
  },
  { // a path with a value is referred to as "dynamic path"
    path: '/products/:id',    // associate this path with a router view
    name: 'product-detail',   // name for this path router view association
    component: ProductDetail  // name of the router view in the views folder
  }
]

const router = new VueRouter({  // instantiate a Vue Router object so we can use Vue Router
  mode: 'history',              // Use history mode - make it look to user as if we using different pages
                                //     put the path in browser address bar and enable the back button
  base: process.env.BASE_URL,   // Get the BASE_URL for the server from env file
  routes                        // Name of the array with the path-router view association
})

export default router           // expose the Vue Router to external processes like Vue
