import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types"

const initState = () => ({
    songs: [],
    artists: {},
    photos: [],
});

const mutations = {
    [TYPES.SET_SONGS](state, songs) {
        state.songs = [...songs];
    },
    [TYPES.SET_ARTISTS](state, artists) {
        state.artists = {...artists }
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