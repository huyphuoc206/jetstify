import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";
import notice from "@/core/notice";
// import { DELETE_SUCCESS, SAVE_SUCCESS } from "@/core/constants";

const BASE_URL = "/artist";

export const getSongs = async({ commit }, id) => {
    const { success, data, message } = await $rest.get(`${BASE_URL}/${id}/songs`);
    if (success) {
        commit(TYPES.SET_SONGS, data);
    } else {
        notice.error(message);
    }

}