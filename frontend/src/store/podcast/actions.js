import notice from "@/core/notice";
import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";

const BASE_URL = "/public/podcast"
const FOLLOW = "/follow"
const USER = "/user"

export const setToggleAbout = ({ commit }) => {
    commit(TYPES.SET_TOGGLE);
};

export const getPodcastDetail = async({ commit }, id) => {
    const { success, data, message } = await $rest.get(`${BASE_URL}/${id}`);
    if (success) {
        const { thumbnail, podcastId, namePodcast, fullNameUser, description, followId } = data;
        const { episodeResponseList } = data;
        commit(TYPES.EPISODE_LIST, episodeResponseList);
        commit(TYPES.PODCAST_INFO, { thumbnail, podcastId, namePodcast, fullNameUser, description, followId });
    } else {
        notice.error(message);
    }
}
export const followPodcast = async({ commit, getters }) => {
    const podcastId = getters.podcastInfo.podcastId;
    const response = await $rest.post(`${USER}${FOLLOW}s`, {
        type: "PODCAST",
        objectId: podcastId,
    });
    const { success, message } = response;
    if (success) {
        await getPodcastDetail({ commit }, podcastId);
    } else {
        notice.error(message);
    }

};
export const unFollowPodcast = async({ commit, getters }) => {
    const { podcastId, followId } = getters.podcastInfo;
    const response = await $rest.delete(`${USER}${FOLLOW}/${followId}`);
    const { success, message } = response;
    if (success) {
        await getPodcastDetail({ commit }, podcastId);
    } else {
        notice.error(message);
    }
};
export const getListPodcastFollow = async({ commit }) => {
    const { success, data, message } = await $rest.get(
        `${USER}${FOLLOW}?type=PODCAST`
    );
    if (success) {
        commit(TYPES.SET_FOLLOWS, data);
    } else {
        notice.error(message);
    }
};