import notice from "@/core/notice";
import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";

const BASE_URL = "/podcastInfo";


export const getInfoPodcast = async ({ commit }) => {
    const { success, data, message } = await $rest.get(BASE_URL);

    if (success) {
        commit(TYPES.PODCAST_INFO, data);
        const episodeResponseList = data.episodeResponseList || [];
        commit(TYPES.SET_EPISODES, episodeResponseList);
    } else {
        notice.error(message);
    }
}

export const setToggleDialog = ({ commit }) => {
    commit(TYPES.SET_TOGGLE);
};

export const updatePodcastInfo = async ({ commit }, payload) => {
    const { success, message } = await $rest.upload(BASE_URL, payload);

    if (success) {
        await getInfoPodcast({ commit });
    }
    return { success, message };
}