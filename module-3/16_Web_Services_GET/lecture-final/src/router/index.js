// Vue Router Configuration (like the class in Java that has all the controllers with @RequestMapping)

import Vue       from 'vue'
import VueRouter from 'vue-router'

// Imports for the router views used in this configuration
import Home      from '../views/Home.vue'
import Board     from '../views/Board.vue'
import Card      from '../views/Card.vue'

Vue.use(VueRouter)  // Tell Vue we are using Vue Router to manage the pages

const routes = [  // Array of path/router views associations
  {
    path: '/',
    name: 'Home',
    component: Home  // Router view called Home.vue in views application folder
  },
  {
    path: '/board/:id',  // this path has a variable called id that is expected to specified with it
    name: 'Board',
    component: Board // Router view called Board.vue in views application folder
  },
  {
    path: '/board/:boardID/card/:cardID',  // this path is expecting two variables called boardID and cardID
    name: 'Card',
    component: Card  // Router view called Card.vue in views application folder
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
