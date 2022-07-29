import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types";

const initState = () => ({
    homeData: {},
    homeDataDisplay: {},
});

const mutations = {
    [TYPES.SET_HOME]: (state, item) => state.homeData = item,
    [TYPES.SET_HOME_DISPLAY]: (state, item) => state.homeDataDisplay = item,

};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};