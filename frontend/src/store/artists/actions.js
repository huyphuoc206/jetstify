import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";
import notice from "@/core/notice";
// import { DELETE_SUCCESS, SAVE_SUCCESS } from "@/core/constants";

const BASE_URL = "/artist";

export const getSongs = async({ commit }, artistId) => {
    const { success, data, message } = await $rest.get(
        `${BASE_URL}/${artistId}/songs`
    );

    if (success) {
        commit(TYPES.SET_SONGS, data);
    } else {
        notice.error(message);
    }
};
export const getSocials = async({ commit }, artistId) => {
    const { success, data, message } = await $rest.get(
        `${BASE_URL}/${artistId}/socials`
    );

    if (success) {
        commit(TYPES.SET_SOCIALS, data);
    } else {
        notice.error(message);
    }
};
export const getImages = async({ commit }, artistId) => {
    const { success, data, message } = await $rest.get(
        `${BASE_URL}/${artistId}/images`
    );

    if (success) {
        commit(TYPES.SET_IMAGES, data);
    } else {
        notice.error(message);
    }
};
export const getArtist = async({ commit }, artistId) => {
    const { success, data, message } = await $rest.get(`${BASE_URL}/${artistId}`);

    if (success) {
        commit(TYPES.SET_ARTISTS, data);
    } else {
        notice.error(message);
    }
};