import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types";

const initState = () => ({
    playlists: [],
});

const mutations = {
    [TYPES.SET_PLAYLISTS]: (state, playlists) => state.playlists = playlists,
   

};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};