import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types"

const initState = () => ({
    songs: [],
    artists: {},
    socials: [],
    images: [],
});

const mutations = {
    [TYPES.SET_SONGS](state, songs) {
        state.songs = [...songs];
    },
    [TYPES.SET_ARTISTS](state, artists) {
        state.artists = {...artists }
    },
    [TYPES.SET_SOCIALS](state, socials) {
        state.socials = [...socials]
    },
    [TYPES.SET_IMAGES](state, images) {
        state.images = [...images]
    }
};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};