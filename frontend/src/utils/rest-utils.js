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