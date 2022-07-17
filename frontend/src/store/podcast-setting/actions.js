import notice from "@/core/notice";
import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";

const BASE_URL = "/podcastInfo";


export const getInfoPodcast = async({ commit }) => {
    const { success, data, message } = await $rest.get(`${BASE_URL}`);

    if (success) {
        commit(TYPES.PODCAST_INFO, data);
    } else {
        notice.error(message);
    }
}

export const setToggleDialog = ({ commit }) => {
    commit(TYPES.SET_TOGGLE);
};