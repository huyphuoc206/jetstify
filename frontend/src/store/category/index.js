import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types";
import _ from 'lodash';

const initState = () => ({
    selected: {},
    categories: [],
    categoriesClient: [],
});

const mutations = {
    [TYPES.SET_SELECTED]: (state, item) => state.selected = _.cloneDeep(item),
    
    [TYPES.SET_CATEGORIES]: (state, categories) => state.categories = [...categories],
    
    [TYPES.SET_CATEGORIESCLIENT]: (state, categoriesClient) => state.categoriesClient = [...categoriesClient]
};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};