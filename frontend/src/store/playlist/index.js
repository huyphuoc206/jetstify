import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types";

const initState = () => ({
    home: {},

});

const mutations = {
    [TYPES.SET_HOME]: (state, item) => state.home = item,

};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};