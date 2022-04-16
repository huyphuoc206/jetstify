import Vue from "vue";
import Vuex from "vuex";
import global from "./global";
import songs from "./songs";
Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        global,
        songs,
    },
});