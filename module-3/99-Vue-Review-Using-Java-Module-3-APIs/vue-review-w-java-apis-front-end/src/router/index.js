import Vue          from "vue";
import VueRouter    from "vue-router";
import Home         from "../views/Home.vue";
import HotelDetail  from "../views/HotelDetail.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/hotels/:id", // path to associate with router view
    name: "HotelDetail", // name of this association 
    component: HotelDetail // router view to associate with path - in the views folder of the app
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
