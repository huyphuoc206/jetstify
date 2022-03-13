import * as TYPES from "./types";
import * as getters from "./getters";
import * as actions from "./actions";

const initState = () => ({
  pageTitle: null,
});

const mutations = {
  [TYPES.RANDOM_PAGE_TITLE]: (state, pageTitle) =>
    (state.pageTitle = pageTitle),
};

export default {
  namespaced: true,
  state: initState(),
  getters,
  actions,
  mutations,
};
