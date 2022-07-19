import * as actions from "./actions";
import * as getters from "./getters";
import * as TYPES from "./types";

const initState = () => ({
    artistInfo: {},
    toggleDialog: false,
    toggleDialogCreate: true,
});

const mutations = {
    [TYPES.ARTIST_INFO]: (state, info) => {
        state.artistInfo = {...info };
    },

    [TYPES.SET_TOGGLE]: (state) => {
        state.toggleDialog = !state.toggleDialog;
    },

    [TYPES.SET_TOGGLE_CREATE]: (state) => {
        state.toggleDialogCreate = !state.toggleDialogCreate;
    },
};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};