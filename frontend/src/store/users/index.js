import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types";

const initState = () => ({
    follows: [],
});

const mutations = {
    [TYPES.SET_FOLLOWS]: (state, follows) => state.follows = [...follows],
};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};