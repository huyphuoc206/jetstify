export const REQUEST_METHODS = {
  GET:    'GET',
  POST:   'POST',
  PUT:    'PUT',
  DELETE: 'DELETE'
};
  
export const METHODS_ALLOW_BODY = [
  REQUEST_METHODS.POST,
  REQUEST_METHODS.PUT
];

export const isFormData = data => typeof FormData !== 'undefined' && data instanceof FormData;

export const getPayloadFromToken = token => {
  try {
    if (!token) return {};
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    const jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
  } catch (error) {
    console.log(error);
    return {};
  }
}