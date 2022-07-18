import * as TYPES from "./types";
import * as getters from "./getters";
import * as actions from "./actions";

const DEFAULT_SNACKBAR = {
  show: false,
  color: "",
  message: "",
};

const MESSAGE_TYPE_COLORS = {
  success: "green",
  error: "red",
  warning: "orange",
};

const showNotice = (state, type, message) => {
  state.snackbar = {
    show: true,
    color: MESSAGE_TYPE_COLORS[type],
    message: message,
  };
};

const initState = () => ({
  isLoading: false,
  isReady: false,
  snackbar: { ...DEFAULT_SNACKBAR },
  isPlaying: false,
  songId: null,
});

const mutations = {
  [TYPES.SET_LOADING]: (state, isLoading) => (state.isLoading = isLoading),

  [TYPES.SET_READY]: (state, isReady) => (state.isReady = isReady),

  [TYPES.SHOW_SUCCESS_NOTICE]: (state, message) =>
    showNotice(state, "success", message),

  [TYPES.SHOW_ERROR_NOTICE]: (state, message) =>
    showNotice(state, "error", message),

  [TYPES.SHOW_WARNING_NOTICE]: (state, message) =>
    showNotice(state, "warning", message),

  [TYPES.CLOSE_NOTICE]: (state) => (state.snackbar = { ...DEFAULT_SNACKBAR }),

  [TYPES.SET_PLAYING]: (state, isPlaying) => state.isPlaying = isPlaying,
  [TYPES.SET_CURRENT_SONG]: (state, songId) => state.songId = songId,
};

export default {
  namespaced: true,
  state: initState(),
  getters,
  actions,
  mutations,
};
