import * as TYPES from "./types";

export const setLoading = ({ commit }, isLoading = false) => {
  commit(TYPES.SET_LOADING, isLoading);
};

export const setReady = ({ commit }, isReady = false) => {
    commit(TYPES.SET_READY, isReady);
  };

export const showSuccessNotice = ({ commit }, message) => {
    commit(TYPES.SHOW_SUCCESS_NOTICE, message);
};

export const showErrorNotice = ({ commit }, message) => {
    commit(TYPES.SHOW_ERROR_NOTICE, message);
}

export const showWarningNotice = ({ commit }, message) => {
    commit(TYPES.SHOW_WARNING_NOTICE, message);
}

export const closeNotice = ({ commit }) => {
    commit(TYPES.CLOSE_NOTICE);
}

export const setPlaying = ({commit}, {isPlaying = false, songId }) => {
    commit(TYPES.SET_PLAYING, isPlaying);
    songId && commit(TYPES.SET_CURRENT_SONG, songId);
}