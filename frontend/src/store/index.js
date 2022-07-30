import Vue from "vue";
import Vuex from "vuex";
import VuexPersistence from 'vuex-persist'
import global from "./global";
import player from "./player";
import auth from "./auth";
import category from "./category";
import artists from "./artists"
import artist from "./artist"
import search from "./search"
import podcast from "./podcast";
import podcasts from "./podcasts";
import user from "./user";
import home from "./home";
import artistSetting from "./artist-setting";
import podcastSetting from "./podcast-setting";
import playlist from "./playlist";

Vue.use(Vuex);

const vuexLocal = new VuexPersistence({
    storage: window.localStorage,
    supportCircular: true,
    reducer: state => ({
        player: {
            currentSong: state.player.currentSong,
            songs: state.player.songs
        }
    })
})

export default new Vuex.Store({
    modules: {
        auth,
        search,
        global,
        category,
        playlist,
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
    plugins: [vuexLocal.plugin],
});