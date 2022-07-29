import { $rest } from "@/core/rest-client";
import notice from "@/core/notice";
import * as TYPES from "./types";

const PUBLIC_URL = "/public/home"

const LIMIT = 6;

export const getDataHome = async({ commit }) => {
    const { success, data, message } = await $rest.get(PUBLIC_URL);
    if (success) {
        commit(TYPES.SET_HOME, data);
        const limitData = {};
        for (const key in data) {
            limitData[key] = data[key].slice(0, LIMIT);
        }
        commit(TYPES.SET_HOME_DISPLAY, limitData);
    } else {
        notice.error(message)
    }
}

export const setHomeDataDisplay = ({ commit, getters }, obj) => {
    const { key, isSeeAll } = obj;
    const homeData = getters.homeData;
    const homeDataDisplay = getters.homeDataDisplay;
    const result = {};
    result[key] = isSeeAll ? homeData[key] : homeData[key].slice(0, LIMIT);
    console.log(result);
    console.log(homeData);
    commit(TYPES.SET_HOME_DISPLAY, {...homeDataDisplay, ...result });
}