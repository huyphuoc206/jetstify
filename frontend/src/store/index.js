import Vue from "vue";
import Vuex from "vuex";
import global from "./global";
import songs from "./songs";
import auth from "./auth";
Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    auth,
    global,
    songs,
  },
});
