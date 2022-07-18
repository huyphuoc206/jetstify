import Vue from "vue";
import Vuex from "vuex";
import artist from "./artist"
import podcast from "./podcast";


Vue.use(Vuex);

export default new Vuex.Store({
    modules: {

        podcast,

        artist

    },
});