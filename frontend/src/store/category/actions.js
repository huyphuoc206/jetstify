import { $rest } from "@/core/rest-client";
import notice from "@/core/notice";
import * as TYPES from "./types";
import { DELETE_SUCCESS, SAVE_SUCCESS } from "@/core/constants";

const PUBLIC_URL = "/public/category"
const BASE_URL = "/admin/category"

export const getCategoriesToClient = async({ commit }) => {
    const { success, data, message } = await $rest.get(PUBLIC_URL);
    if (success) {
        commit(TYPES.SET_CATEGORIES, data);
    } else {
        notice.error(message)
    }
}

export const getCategories = async({ commit }) => {
    const { success, data, message } = await $rest.get(BASE_URL);
    if (success) {
        commit(TYPES.SET_CATEGORIES, data);
    } else {
        notice.error(message)
    }
}

export const getCategoryDetails = async({ commit }, id) => {
    if (id) {
        const { success, data, message } = await $rest.get(`${BASE_URL}/${id}`);
        if (success) {
            const { id, name, code } = data;
            commit(TYPES.SET_SELECTED, { id, name, code });
        }
        return { success, message };
    } else {
        commit(TYPES.SET_SELECTED, { name: '', code: '' });
        return { success: true };
    }
}

export const saveCategory = async({ getters, commit }) => {
    const { id, name, code } = getters.selected;
    let response;
    if (id) {
        response = await $rest.put(`${BASE_URL}/${id}`, { name, code });
    } else {
        response = await $rest.post(BASE_URL, { name, code });
    }
    const { success, message, data } = response;
    if (success) {
        notice.success(SAVE_SUCCESS);
        const { id } = data || {};
        !!id && await getCategoryDetails({ commit }, id);
        await getCategories({ commit });
    } else {
        notice.error(message);
    }
}

export const deleteCategory = async({ commit }, id) => {
    const { success, message } = await $rest.delete(`${BASE_URL}/${id}`);
    if (success) {
        notice.success(DELETE_SUCCESS);
        await getCategories({ commit });
    } else {
        notice.error(message);
    }
}