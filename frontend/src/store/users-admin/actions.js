import { $rest } from "@/core/rest-client";
import notice from "@/core/notice";
import * as TYPES from "./types";
import { DELETE_SUCCESS, SAVE_SUCCESS } from "@/core/constants";

const BASE_URL = "/admin/users"

const DEFAULT_PAGING = {
    page: 1,
    limit: 5
};


export const getUsers = async({ commit }, paging) => {
    const { success, data, message } = await $rest.get(BASE_URL, paging);
    if (success) {
        commit(TYPES.SET_USERS, data);
    } else {
        notice.error(message)
    }
}

export const getUsersDetails = async({ commit }, id) => {
    if (id) {
        const { success, data, message } = await $rest.get(`${BASE_URL}/${id}`);
        if (success) {
            const { id, fullName, email, active } = data;
            commit(TYPES.SET_SELECTED, { id, fullName, email, active });
        }
        return { success, message };
    } else {
        return { success: true };
    }
}

export const saveUsers = async({ getters, commit }) => {
    const {  id, fullName, active } = getters.selected;
    const { success, message } = await $rest.put(`${BASE_URL}/${id}`, {  id, fullName, active });
    if (success) {
        notice.success(SAVE_SUCCESS);
        await getUsers({ commit }, DEFAULT_PAGING);
    } else {
        notice.error(message);
    }
}

export const deleteUsers = async({ commit }, id) => {
    const { success, message } = await $rest.delete(`${BASE_URL}/${id}`);
    if (success) {
        notice.success(DELETE_SUCCESS);
        await getUsers({ commit }, DEFAULT_PAGING);
    } else {
        notice.error(message);
    }
}
