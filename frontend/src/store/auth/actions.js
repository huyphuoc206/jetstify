import IntervalJob from "@/utils/interval-job";
import router from "@/router";
import { INTERVAL_REFRESH_TOKEN_TIME, ROLE_CODE } from "@/core/constants";
import { $rest } from "@/core/rest-client";
import store from "@/store";
import * as TYPES from "./types";
import { getPayloadFromToken } from "@/utils/rest-utils";
import __isNumber from "lodash/isNumber";

const intervalTokenJob = new IntervalJob({
    event: autoRefreshToken,
    intervalTime: INTERVAL_REFRESH_TOKEN_TIME,
});

export const loadAuthentication = async () => {
    const { success } = saveUserInfo(await $rest.get('/token/refresh'));
    if (success) {
        intervalTokenJob.start();
    }
    return success;
};

export const login = async (dispatch, payload) => {
    const { role } = payload;
    const request = {
        email: payload.email,
        password: payload.password,
        isRemember: payload.isRemember
    };
    const endpoint = role === ROLE_CODE.ADMIN ? '/admin/login' : '/login';

    const { success, message } = saveUserInfo(await $rest.post(endpoint, request, { ignoreInterceptor: true }));
    if (success) {
        intervalTokenJob.start();
    }
    return {
        success,
        message,
    };
};

export const logout = async ({ commit, getters }) => {
    const role = getters.role || ROLE_CODE.CUSTOMER;
    intervalTokenJob.suspend();
    $rest.removeAccessToken();
    commit(TYPES.RESET_USER_INFO);
    $rest.get('/logout');
    if (role === ROLE_CODE.ADMIN) {
        router.replace({ name: 'AdminLogin' })
    }
    
};

const saveUserInfo = response => {
    const { success, data } = response;
    if (success) {
        const { accessToken } = data;
        const { fullName, role } = getPayloadFromToken(accessToken);
        $rest.setAccessToken(accessToken);
        store.commit(`auth/${TYPES.SET_USER_INFO}`, { fullName, role, accessToken });
    }
    return response;
};

const autoRefreshToken = async () => {
    const token = store.getters['auth/token'];
    const { ext } = getPayloadFromToken(token);
    if (__isNumber(ext)) {
        const diffTime = ext - Date.now();
        if (diffTime >= INTERVAL_REFRESH_TOKEN_TIME) {
            return;
        }
    }
    saveUserInfo(await $rest.get('/token/refresh'))
};
