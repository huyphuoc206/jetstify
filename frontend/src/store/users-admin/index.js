import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types";
import _ from 'lodash';

const initState = () => ({
    selected: {},
    usersObj: {},
    categoriesClient: [],
    songs: [],
});

const mutations = {
    [TYPES.SET_SELECTED]: (state, item) => state.selected = _.cloneDeep(item),

    [TYPES.SET_USERS]: (state, usersObj) => state.usersObj = {...usersObj},
};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};