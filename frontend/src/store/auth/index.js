import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types";

const initState = () => ({
  token: null,
  fullName: null,
  role: null
});

const mutations = {
  [TYPES.SET_USER_INFO]: (state, { fullName, role, accessToken }) => { 
    state.token = accessToken;
    state.fullName = fullName;
    state.role = role;
  },

  [TYPES.RESET_USER_INFO]: state => Object.assign(state, initState())
};

export default {
  namespaced: true,
  state: initState(),
  getters,
  actions,
  mutations,
};
