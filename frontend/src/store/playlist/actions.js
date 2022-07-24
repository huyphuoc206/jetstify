import { $rest } from "@/core/rest-client";
import notice from "@/core/notice";
import * as TYPES from "./types";
import router from "@/router";
const PUBLIC_URL = "/playlist"

export const getPlaylist = async({ commit }) => {
    const { success, data, message } = await $rest.get(PUBLIC_URL);
    if (success) {
        commit(TYPES.SET_PLAYLISTS, data);
    } else {
        notice.error(message)
    }
}

export const createPlaylist = async({ commit }) => {
    const { success, data, message } = await $rest.post(PUBLIC_URL);
    if (success) {
        await getPlaylist({ commit });
        await getPlaylistById({ commit }, data.idPlaylist);
        router.push(`/playlist/${data.idPlaylist}`)
    } else {
        notice.error(message)
    }
}
export const getPlaylistById = async({ commit }, id) => {
    const { success, data, message } = await $rest.get(`${PUBLIC_URL}/${id}`);
    if (success) {
        console.log(data);
        commit(TYPES.SET_PLAYLIST, data);
    } else {
        notice.error(message)
    }
}