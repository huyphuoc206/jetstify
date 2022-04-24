import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import vuetify from "./plugins/vuetify";
import store from "./store";
import { $rest } from './core/rest-client';

import "@/assets/scss/common.scss";

Vue.config.productionTip = false;

Vue.prototype.$rest = $rest;

new Vue({
    router,
    vuetify,
    store,
    render: (h) => h(App),
}).$mount("#app");