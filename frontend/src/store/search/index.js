import * as actions from "./actions";
import * as getters from "./getters";
import * as TYPES from "./types";

const initState = () => ({
    dataSearch: {}
});

const mutations = {
    [TYPES.SET_SEARCH]: (state, dataSearch) => {
        state.dataSearch = {...dataSearch };
    },

};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};