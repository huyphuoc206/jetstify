import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";

const BASE_URL = "/public/podcast"

export const setToggleAbout = ({ commit }) => {
    commit(TYPES.SET_TOGGLE);
  };

export const getPodcastDetail = async ({ commit }, id) => {
    if (id) {
        const { success, data, message } = await $rest.get(`${BASE_URL}/${id}`);
        if (success) {
            const { thumbnail,podcastId, namePodcast,fullNameUser, description } = data;
            const { episodeResponseList } = data;
            commit(TYPES.EPISODE_LIST, episodeResponseList);
            commit(TYPES.PODCAST_INFO,  { thumbnail,podcastId, namePodcast,fullNameUser, description });
        }
        return { success, message };
    } else {
      commit(TYPES.PODCAST_INFO, { thumbnail: '',podcastId:'', namePodcast: '',fullNameUser:'', description: '' });
      commit(TYPES.EPISODE_LIST,  []);
        return { success: true };
    }
}

