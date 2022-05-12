import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "./router";
import store from "./store";
import { $rest } from "./core/rest-client";
import notice from "./core/notice";
import moment from 'moment';

import "@/assets/scss/common.scss";

Vue.config.productionTip = false;

Vue.prototype.$rest = $rest;
Vue.prototype.$notice = notice;
Vue.prototype.moment = moment

store.dispatch("auth/loadAuthentication").then(() => {
  new Vue({
    router,
    vuetify,
    store,
    render: (h) => h(App),
  }).$mount("#app");
})
