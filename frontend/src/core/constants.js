export const API_REQUEST = {
  HEADERS: {
    AUTHORIZATION: 'Authorization',
    CONTENT_TYPE: 'Content-Type'
  },

  AUTHORIZATION: {
    BEARER: 'Bearer '
  },

  CONTENT_TYPES: {  
    JSON: 'application/json',
    FORM: 'multipart/form-data'
  },

  STATUS_CODES: {
    BAD_REQUEST: 400,
    UNAUTHORIZED: 401,
    FORBIDDEN: 403,
    NOT_FOUND: 404,
    SERVER_ERROR: 500
  },
  
  RESPONSE_TYPE: {
    JSON: 'json'
  }
};

export const ROLE_CODE = {
  ADMIN: 'ADMIN',
  CUSTOMER: 'CUSTOMER'
}

export const INTERVAL_REFRESH_TOKEN_TIME = 60000; // ms 