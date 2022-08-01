import * as TYPES from "./types";
import * as getters from "./getters";
import * as actions from "./actions";

const initState = () => ({
  isPlaying: false,
  currentSong: {},
  songs: [],
});

const mutations = {
  [TYPES.SET_PLAYING]: (state, isPlaying) => state.isPlaying = isPlaying,
  [TYPES.SET_CURRENT_SONG]: (state, song) => state.currentSong = { ...song },
  [TYPES.SET_SONGS]: (state, songs) => state.songs = [...songs],
};

export default {
  namespaced: true,
  state: initState(),
  getters,
  actions,
  mutations,
};
