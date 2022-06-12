import * as actions from "./actions";
import * as getters from "./getters";
import * as TYPES from "./types";

const initState = () => ({
  podcastInfo: {},
  episodeList: [],
  toggleAbout: false,
});

const mutations = {
  [TYPES.EPISODE_LIST]: (state, episodeList) => {
    state.episodeList = [...episodeList];
  },

  [TYPES.PODCAST_INFO]: (state, info) => {
    state.podcastInfo = {... info};
  },
  
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
