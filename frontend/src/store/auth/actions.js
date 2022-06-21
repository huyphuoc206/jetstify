import IntervalJob from "@/utils/interval-job";
import router from "@/router";
import { INTERVAL_REFRESH_TOKEN_TIME, ROLE_CODE, API_REQUEST } from "@/core/constants";
import { $rest } from "@/core/rest-client";
import store from "@/store";
import * as TYPES from "./types";
import { getPayloadFromToken } from "@/utils/rest-utils";
import __isNumber from "lodash/isNumber";

export const loadAuthentication = async () => {
    try {
        const { success, status } = saveUserInfo(await $rest.get('/token/refresh'));
    if (success) {
        intervalTokenJob.start();
    } else if (status === API_REQUEST.STATUS_CODES.SERVER_ERROR) {
        router.replace('/server-error')
    }
    } finally {
        store.dispatch("global/setReady", true);
    }
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
    await $rest.get('/logout');
    if (role === ROLE_CODE.ADMIN) {
        router.replace({ name: 'AdminLogin' })
    }
};

const saveUserInfo = response => {
    const { success, data } = response;
    if (success) {
        const { accessToken, fullName, avatar } = data;
        const { role } = getPayloadFromToken(accessToken);
        $rest.setAccessToken(accessToken);
        store.commit(`auth/${TYPES.SET_USER_INFO}`, { fullName, avatar, role, accessToken });
    }
    return response;
};


export const updateUserInfo = ({commit} , data) => {
    commit(TYPES.UPDATE_USER_INFO, data);
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

const intervalTokenJob = new IntervalJob({
    event: autoRefreshToken,
    intervalTime: INTERVAL_REFRESH_TOKEN_TIME,
});
