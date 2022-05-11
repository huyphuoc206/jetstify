import { ROLE_CODE } from "@/core/constants";

export const ADMIN_ROUTES = [
    {
        path: "/admin/login",
        name: "AdminLogin",
        meta: {
            fullScreen: true,
            title: 'Login'
        },
        component: () => import(/* webpackChunkName: "admin-pages" */ "@/pages/admin/login"),
    },
    {
        path: "/admin/home",
        name: "AdminHome",
        meta: {
            fullScreen: true,
            title: 'Home Page',
            requiresAuth: true,
            role: ROLE_CODE.ADMIN
        },
        component: () => import(/* webpackChunkName: "admin-pages" */ "@/pages/admin/home"),
    },
    {
        path: "/admin/category",
        name: "AdminCategory",
        meta: {
            title: 'Category',
            requiresAuth: true,
            role: ROLE_CODE.ADMIN
        },
        component: () => import(/* webpackChunkName: "admin-pages" */ "@/pages/admin/category"),
    },
];