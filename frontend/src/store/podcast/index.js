import * as actions from "./actions";
import * as getters from "./getters";
import * as TYPES from "./types";

const initState = () => ({
  toggleAbout: false,
});

const mutations = {
  [TYPES.SET_TOGGLE]: (state) => {
    state.toggleAbout = !state.toggleAbout;
  },
};

export default {
  namespaced: true,
  state: initState(),
  getters,
  actions,
  mutations,
};
