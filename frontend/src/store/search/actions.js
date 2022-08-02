import notice from "@/core/notice";
import { $rest } from "@/core/rest-client";
import * as TYPES from "./types";
// const queryString = require('query-string');

const SEARCH = "/public/search"

export const getSearchData = async ({ commit }, nameSearch) => {
    const { success, data, message } = await $rest.get(
        SEARCH, { name: nameSearch }
    );
    if (success) {
        commit(TYPES.SET_SEARCH, data);
    } else {
        notice.error(message);
    }
};