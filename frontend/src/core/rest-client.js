import axios from "axios";
import store from '@/store';
import __isString from 'lodash/isString';
import __isObject from 'lodash/isObject';
import { API_REQUEST } from "./constants";
import * as RestUtils from '@/utils/rest-utils';

const noInterceptor = (resp) => resp;

const DEFAULT_HEADERS = {
  [API_REQUEST.HEADERS.CONTENT_TYPE]: API_REQUEST.CONTENT_TYPES.JSON,
};

const DEFAULT_REQUEST_OPTIONS = {
  headers: {},
  ignoreInterceptor: false,
};

const ERROR_MESSAGE = {
  400: "Request data went wrong",
  401: "Endpoint requires authentication",
  403: "Forbidden endpoint",
  404: "Endpoint is not found",
  500: "Something went wrong",
};

export class RestClient {

  constructor(options = {}) {
    const { baseURL = "/" } = options;
    this.$axios = axios.create({
      baseURL,
      responseType: API_REQUEST.RESPONSE_TYPE.JSON,
      headers: { ...DEFAULT_HEADERS },
    });
  }

  removeAccessToken = () => {
    this.$axios.defaults.headers.common = { ...DEFAULT_HEADERS };
  }

  setAccessToken(token) {
    if (!token) {
      return;
    }
    this.$axios.defaults.headers.common[API_REQUEST.HEADERS.AUTHORIZATION] = `${API_REQUEST.AUTHORIZATION.BEARER}${token}`;
  }

  addRequestInterceptor = (successHandler, failHandler) => {
    this.$axios.interceptors.request.use(successHandler || noInterceptor, failHandler || noInterceptor);
  }

  addResponseInterceptor = (successHandler, failHandler) => {
    this.$axios.interceptors.response.use(successHandler || noInterceptor, failHandler || noInterceptor);
  }

  async get(url, requestParams = {}, options = DEFAULT_REQUEST_OPTIONS) {
    return await this.#sendRequest(url, RestUtils.REQUEST_METHODS.GET, options, requestParams);
  }

  async post(url, requestBody = {}, options = DEFAULT_REQUEST_OPTIONS) {
    return await this.#sendRequest(url, RestUtils.REQUEST_METHODS.POST, options, requestBody);
  }

  async put(url, requestBody = {}, options = DEFAULT_REQUEST_OPTIONS) {
    return await this.#sendRequest(url, RestUtils.REQUEST_METHODS.PUT, options, requestBody);
  }

  async delete(url, requestParams = {}, options = DEFAULT_REQUEST_OPTIONS) {
    return await this.#sendRequest(url, RestUtils.REQUEST_METHODS.DELETE, options, requestParams);
  }

  #sendRequest = async (url, method, options = DEFAULT_REQUEST_OPTIONS, payload = {}) => {
    if (!url) {
      throw new Error('The value of URL must correct');
    }

    const allOptions = { ...DEFAULT_REQUEST_OPTIONS, ...options };
    const { headers, ignoreInterceptor } = allOptions;

    let params = {};
    let requestBody = {};
    if (RestUtils.METHODS_ALLOW_BODY.includes(method)) {
      requestBody = payload;
    } else {
      params = new URLSearchParams(payload);
    }

    const opts = {
      method,
      params,
      headers,
      data: requestBody,
      transformRequest: [this.#transformRequest],
      ignoreInterceptor
    };

    return await this.#parseResponse(this.$axios.request(url, opts));
  };

  #transformRequest = data => {
    if (__isString(data) || RestUtils.isFormData(data)) {
      return data;
    } else if (__isObject(data)) {
      return JSON.stringify(data);
    }
    throw new Error('Request body must be an one of [String, Object, FormData]');
  }

  #parseResponse = async (requester) => {
    try {
      const resp = await Promise.resolve(requester);
      const { data, isAxiosError } = resp;
      if (isAxiosError) {
        const { status } = resp.toJSON();
        return { status, success: false, message: ERROR_MESSAGE[status] };
      }
      return { status: resp.status, ...data };
    } catch (error) {
      return { status: 500, success: false, message: ERROR_MESSAGE[500] };
    }
  }
}

export const $rest = new RestClient({
  baseURL: 'http://localhost:8081/api'
});

$rest.addResponseInterceptor(
  noInterceptor,
  error => {
    if (!error.toJSON) return error;
    const { status, config: { ignoreInterceptor = false } } = error.toJSON();
    if (!ignoreInterceptor && status === API_REQUEST.STATUS_CODES.UNAUTHORIZED) {
      store.dispatch('auth/logout');
    }
    return error;
  }
);
