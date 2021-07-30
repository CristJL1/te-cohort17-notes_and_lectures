// this is the Vuex data store for the App
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    hotels: [] // hold the hotels from the API call
  },
  mutations: {
    SET_HOTELS(state, data) {
      state.hotels = data;
    },
  },
  actions: {},
  modules: {}
});
