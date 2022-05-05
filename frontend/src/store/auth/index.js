import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types";

const initState = () => ({
  token: null,
});

const mutations = {
  [TYPES.SET_TOKEN]: (state, token) => state.token = token,
};

export default {
  namespaced: true,
  state: initState(),
  getters,
  actions,
  mutations,
};
