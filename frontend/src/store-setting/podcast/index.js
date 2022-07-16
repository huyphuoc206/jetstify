import * as actions from "./actions";
import * as getters from "./getters";
import * as TYPES from "./types";

const initState = () => ({
  userInfo: {},
  toggleDialog: false,
});

const mutations = {
  [TYPES.USER_INFO]: (state, info) => {
    state.userInfo = {... info};
  },

  [TYPES.SET_TOGGLE]: (state) => {
    state.toggleDialog = !state.toggleDialog;
  },
};

export default {
  namespaced: true,
  state: initState(),
  getters,
  actions,
  mutations,
};
