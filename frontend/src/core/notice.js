import store from "@/store";

export class Notification {
  success(message) {
    store.dispatch("global/showSuccessNotice", message);
  }

  error(message) {
    store.dispatch("global/showErrorNotice", message);
  }

  warning(message) {
    store.dispatch("global/showWarningNotice", message);
  }
}

export default new Notification();
