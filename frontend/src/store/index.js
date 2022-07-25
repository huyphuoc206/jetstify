import Vue from "vue";
import Vuex from "vuex";
import global from "./global";
import player from "./player";
import auth from "./auth";
import category from "./category";
import artists from "./artists"
import artist from "./artist"
import podcast from "./podcast";
import podcasts from "./podcasts";
import user from "./user";
import home from "./home";
import artistSetting from "./artist-setting";
import podcastSetting from "./podcast-setting";
Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        auth,
        global,
        category,
        podcast,
        podcasts,
        artists,
        artist,
        user,
        artistSetting,
        podcastSetting,
        home,
        player,
    },
});