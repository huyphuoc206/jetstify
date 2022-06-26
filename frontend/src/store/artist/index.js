import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types"

const initState = () => ({
    songs: [],
    artist: {},
    photos: [],
});

const mutations = {
    [TYPES.SET_SONGS](state, songs) {
        state.songs = [...songs];
    },
    [TYPES.SET_ARTIST](state, artist) {
        state.artist = {...artist }
    },
    [TYPES.SET_PHOTOS](state, photos) {
        state.photos = [...photos]
    },

};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};