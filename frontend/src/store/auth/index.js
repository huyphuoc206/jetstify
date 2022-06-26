import * as getters from "./getters";
import * as actions from "./actions";
import * as TYPES from "./types";

const initState = () => ({
  token: null,
  fullName: null,
  role: null,
  avatar: null,
});

const mutations = {
  [TYPES.SET_USER_INFO]: (state, { fullName, avatar, role, accessToken }) => { 
    state.token = accessToken;
    state.fullName = fullName;
    state.role = role;
    state.avatar = avatar;
  },

  [TYPES.UPDATE_USER_INFO]: (state, { fullName, avatar }) => { 
    state.fullName = fullName;
    state.avatar = avatar;
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