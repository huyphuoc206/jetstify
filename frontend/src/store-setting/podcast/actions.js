import notice from "@/core/notice";
import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";

const BASE_URL = "/user";


export const getInfoPodcast = async({ commit }) => {
    const { success, data, message } = await $rest.get(`${BASE_URL}`);

    if (success) {
        const { fullName, email, avatar } = data;
        commit(TYPES.USER_INFO, { fullName, email, avatar });
    } else {
        notice.error(message);
    }
}

export const setToggleDialog = ({ commit }) => {
    commit(TYPES.SET_TOGGLE);
};