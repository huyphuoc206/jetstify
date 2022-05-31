import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";
import notice from "@/core/notice";
// import { DELETE_SUCCESS, SAVE_SUCCESS } from "@/core/constants";

const PUBLIC = "/public";
const BASE_URL = "/artist";

export const getSongs = async({ commit }, artistId) => {
    const { success, data, message } = await $rest.get(
        `${PUBLIC}${BASE_URL}/${artistId}/songs`
    );
    if (success) {
        commit(TYPES.SET_SONGS, data);
    } else {
        notice.error(message);
    }
};

export const getPhotos = async({ commit }, artistId) => {
    const { success, data, message } = await $rest.get(
        `${PUBLIC}${BASE_URL}/${artistId}/photos`
    );

    if (success) {
        commit(TYPES.SET_IMAGES, data);
    } else {
        notice.error(message);
    }
};
export const getArtist = async({ commit }, artistId) => {
    const { success, data, message } = await $rest.get(`${PUBLIC}${BASE_URL}/${artistId}`);

    if (success) {
        commit(TYPES.SET_ARTISTS, data);
    } else {
        notice.error(message);
    }
};