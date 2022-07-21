import { $rest } from "@/core/rest-client";
import notice from "@/core/notice";
import * as TYPES from "./types";

const PUBLIC_URL = "/playlist"

export const getPlaylist = async({ commit }) => {
    const { success, data, message } = await $rest.get(PUBLIC_URL);
    if (success) {
        commit(TYPES.SET_PLAYLISTS, data);
    } else {
        notice.error(message)
    }
}

export const createPlaylist = async({ commit, getters }) => {
    const { idPlaylist } = getters.playlist;
    const { success, message } = await $rest.post(PUBLIC_URL);
    if (success) {
        getPlaylist({ commit });
        getPlaylistById({ commit }, idPlaylist);
    } else {
        notice.error(message)
    }
}
export const getPlaylistById = async({ commit }, id) => {
    const { success, data, message } = await $rest.get(`${PUBLIC_URL}/${id}`);
    if (success) {
        commit(TYPES.SET_PLAYLIST, data);
    } else {
        notice.error(message)
    }
}