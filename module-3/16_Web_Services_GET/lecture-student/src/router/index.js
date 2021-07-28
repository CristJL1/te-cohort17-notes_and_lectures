// Vue Router Configuration (like the class in Java that has all the controls with @RequestMapping)

import Vue from 'vue'
import VueRouter from 'vue-router'

// imports for the router views used in this configuration
import Home from '../views/Home.vue'
import Board from '../views/Board.vue'
import Card from '../views/Card.vue'

Vue.use(VueRouter) // tell Vue we are using Vue Router to manage the pages

const routes = [ // array of path/router views associations
  {
    path: '/',
    name: 'Home',
    component: Home // router view called Home.vue in the views application folder
  },
  {
    path: '/board/:id', // this path has a variable called id that is expected to be specified with it
    name: 'Board',
    component: Board // router view called Board.vue in views application folder
  },
  {
    path: '/board/:boardID/card/:cardID', // this path is expecting two variables called boardID and cardID
    name: 'Card',
    component: Card
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
