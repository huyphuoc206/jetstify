import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";
import notice from "@/core/notice";
// import { DELETE_SUCCESS, SAVE_SUCCESS } from "@/core/constants";

const PUBLIC = "/public";
const BASE_URL = "/artist";
const USER = "/user";
const FOLLOW = "/follow"

export const getSongs = async({ commit }, artistId) => {
    const { success, data, message } = await $rest.get(
        `${PUBLIC}${USER}/${artistId}/songs`
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

export const followArtist = async({ commit, getters }) => {
    const { artistId } = getters.artist;
    const response = await $rest.post(`${USER}${FOLLOW}s`, {
        type: "ARTIST",
        objectId: artistId
    });
    const { success, message } = response;
    if (success) {
        await getArtist({ commit }, artistId);
    } else {
        notice.error(message);
    }

};
export const unFollowArtist = async({ commit, getters }) => {
    const { artistId, followId } = getters.artist;
    const response = await $rest.delete(`${USER}${FOLLOW}/${followId}`);
    const { success, message } = response;
    if (success) {
        await getArtist({ commit }, artistId);
    } else {
        notice.error(message);
    }
};