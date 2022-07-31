import * as actions from "./actions";
import * as getters from "./getters";
import * as TYPES from "./types";

const initState = () => ({
    podcastInfo: {},
    episodes: [],
    toggleDialog: false,
});

const mutations = {
    [TYPES.PODCAST_INFO]: (state, info) => {
        state.podcastInfo = {...info };
    },

    [TYPES.SET_TOGGLE]: (state) => {
        state.toggleDialog = !state.toggleDialog;
    },

    [TYPES.SET_EPISODES]: (state, payload) => {
        state.episodes = [...payload];
    },
};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};