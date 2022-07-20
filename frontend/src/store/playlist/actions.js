import { $rest } from "@/core/rest-client";
import notice from "@/core/notice";
import * as TYPES from "./types";

const PUBLIC_URL = "/playlist"

export const getDataHome = async({ commit }) => {
    const { success, data, message } = await $rest.get(PUBLIC_URL);
    if (success) {
        commit(TYPES.SET_HOME, data);
    } else {
        notice.error(message)
    }
}