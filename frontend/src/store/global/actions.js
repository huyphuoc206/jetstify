import * as TYPES from "./types";

export const setLoading = async ({ commit }, isLoading = false) => {
  commit(TYPES.SET_LOADING, isLoading);
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
