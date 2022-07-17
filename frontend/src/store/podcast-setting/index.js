import * as actions from "./actions";
import * as getters from "./getters";
import * as TYPES from "./types";

const initState = () => ({
    podcastInfo: {},
    toggleDialog: false,
});

const mutations = {
    [TYPES.PODCAST_INFO]: (state, info) => {
        state.podcastInfo = {...info };
    },

    [TYPES.SET_TOGGLE]: (state) => {
        state.toggleDialog = !state.toggleDialog;
    },
};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};