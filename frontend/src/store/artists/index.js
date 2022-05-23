import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types"

const initState = () => ({
    songs: [],
});

const mutations = {
    [TYPES.SET_SONGS](state, songs) {
        state.songs = [...songs];
    },
};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};