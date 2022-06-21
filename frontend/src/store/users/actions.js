import { $rest } from "@/core/rest-client";
import notice from "@/core/notice";
import * as TYPES from "./types";

const BASE_URL = "/user";
const FOLLOW = "/follow";

export const getListPodcastFollow = async({ commit }) => {
    const { success, data, message } = await $rest.get(
        `${BASE_URL}${FOLLOW}?type=PODCAST`
    );
    if (success) {
        commit(TYPES.SET_FOLLOWS, data);
    } else {
        notice.error(message);
    }
};
export const getListArtistFollow = async({ commit }) => {
    const { success, data, message } = await $rest.get(
        `${BASE_URL}${FOLLOW}?type=ARTIST`
    );
    if (success) {
        commit(TYPES.SET_FOLLOWS, data);
    } else {
        notice.error(message);
    }
};

export const followPodcast = async({ commit }, podcastId) => {
    const response = await $rest.post(`${BASE_URL}${FOLLOW}s`, {
        type: "PODCAST",
        objectId: podcastId,
    });
    const { success, message } = response;
    if (success) {
        await getListPodcastFollow({ commit });
    } else {
        notice.error(message);
    }

};
export const unFollowPodcast = async({ commit }, followId) => {
    const response = await $rest.post(`${BASE_URL}${FOLLOW}/${followId}`);
    const { success, message } = response;
    if (success) {
        await getListPodcastFollow({ commit });
    } else {
        notice.error(message);
    }
};