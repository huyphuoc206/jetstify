import Vue from "vue";
import VueRouter from "vue-router";
import { ADMIN_ROUTES } from "./admin-routes";
import { CUSTOMER_ROUTES } from "./customer-routes";
import { ERROR_ROUTES } from "./error-routes";

Vue.use(VueRouter);

const routes = [...ADMIN_ROUTES, ...CUSTOMER_ROUTES, ...ERROR_ROUTES];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach((to, from, next) => {
  // TODO Implemnt auth logic here

  if (to.matched.some((r) => r.meta.isAuthRequired)) {
    // verify if the user is authenticated
  }

  next();
});

export default router;
