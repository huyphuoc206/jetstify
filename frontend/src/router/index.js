import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [{
        path: "/",
        name: "Home",
        component: () =>
            import ("@/pages/home"),
    },
    {
        path: "/login",
        name: "Login",
        meta: {
            fullScreen: true,
        },
    },
    {
        path: "/collection",
        name: "Collection",
        component: () =>
            import ("@/pages/collection"),
    },
    {
        path: "/user-management",
        name: "UserManagement",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
            import ( /* webpackChunkName: "about" */ "@/pages/user-management"),
    },
    {
        path: "/search",
        name: "Search",
        component: () =>
            import ( /* webpackChunkName: "about" */ "@/pages/search"),
    },
    {
        path: "/queue",
        name: "Queue",
        component: () =>
            import ("@/pages/queue"),
    },

    {
        path: "/genres",
        name: "Genres",
        component: () =>
            import ("@/pages/genres"),
    },
    {
        path: "/discover",
        name: "Discover",
        component: () =>
            import ("@/pages/discover"),
    },
    {
        path: "/",
        redirect: "/browse/featured",
    },
    {
        path: "/album/1",
        name: "Album",
        component: () =>
            import ("@/pages/album"),
    },
    {
        path: "/artist/1",
        name: "Artist",
        component: () =>
            import ("@/pages/artist"),
    },
    {
        path: "/playlist",
        name: "Playlist",
        component: () =>
            import ("@/pages/playlist"),
    },
    {
        path: "/track",
        name: "Track",
        component: () =>
            import ("@/pages/track"),
    },
    {
        path: "/user/1",
        name: "User",
        component: () =>
            import ("@/pages/user"),
    },
    {
        path: "/*",
        redirect: {
            name: "Home",
        },
    },
];

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