import notice from "@/core/notice";
import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";

const FOLLOW = "/follow"
const USER = "/user"

export const setToggleAbout = ({ commit }) => {
    commit(TYPES.SET_TOGGLE);
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