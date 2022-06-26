import * as actions from "./actions";
import * as getters from "./getters";
import * as TYPES from "./types";

const initState = () => ({
    podcasts: [],
    toggleAbout: false,
});

const mutations = {
    [TYPES.SET_FOLLOWS]: (state, podcasts) => {
        state.podcasts = [...podcasts];
    },

};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};