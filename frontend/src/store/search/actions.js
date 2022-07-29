import notice from "@/core/notice";
import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";
const queryString = require('query-string');

const SEARCH = "/public/search"

export const getSearchData = async({ commit }, nameSearch) => {
    const params = queryString.stringify(nameSearch)
    const { success, data, message } = await $rest.get(
        `${SEARCH}?${params}`
        // `${SEARCH}?name=a`
    );
    if (success) {

        commit(TYPES.SET_SEARCH, data);

    } else {
        notice.error(message);
    }
};