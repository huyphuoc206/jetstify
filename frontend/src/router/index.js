import Vue from "vue";
import VueRouter from "vue-router";
import store from "@/store";
import { ADMIN_ROUTES } from "./admin-routes";
import { CUSTOMER_ROUTES } from "./customer-routes";
import { ERROR_ROUTES } from "./error-routes";
import { APP_NAME, ROLE_CODE } from "@/core/constants";

Vue.use(VueRouter);
const routes = [...ADMIN_ROUTES, ...CUSTOMER_ROUTES, ...ERROR_ROUTES];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
});

router.beforeEach((to, from, next) => {
    const { title } = to.meta;
    if (title) {
        document.title = `${APP_NAME} | ${title}`;
    } else {
        document.title = APP_NAME;
    }
    next();
});

router.beforeResolve((to, from, next) => {
    try {
        const { requiresAuth, role } = to.meta;
        const currentRole = store.getters['auth/role'];
        const isAuthenticated = store.getters['auth/isAuthenticated'];
        if (ROLE_CODE.ADMIN === role) {
            if (requiresAuth && !isAuthenticated) {
                return next('/admin/login');
            }
            if (role !== currentRole) {
                return next('/forbidden');
            }
        } else if (ROLE_CODE.CUSTOMER === role) {
            if (requiresAuth && !isAuthenticated) {
                return next('/login');
            }
            if (isAuthenticated && role !== currentRole) {
                return next('/forbidden');
            }
        }

        next();
    } catch (e) {
        return next('/server-error');
    }
});

export default router;