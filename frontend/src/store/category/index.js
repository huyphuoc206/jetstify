import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types";
import _ from 'lodash';

const initState = () => ({
    selected: {},
    categories: [],
});

const mutations = {
    [TYPES.SET_SELECTED]: (state, item) => state.selected = _.cloneDeep(item),
    
    [TYPES.SET_CATEGORIES]: (state, categories) => state.categories = [...categories]
};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};