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
        component: () =>
            import ("@/pages/login"),
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
        path: "/albums",
        name: "Albums",
        component: () =>
            import ("@/pages/albums"),
    },
    {
        path: "/artists",
        name: "Artists",
        component: () =>
            import ("@/pages/artists"),
    },
    {
        path: "/",
        redirect: "/browse/featured",
    },
    {
        path: "/album/1",
        name: "Album",
        component: () =>
            import ("@/pages/albums/album"),
    },
    {
        path: "/artist/1",
        name: "Artist",
        component: () =>
            import ("@/pages/artists/artist"),
    },
    {
        path: "/playlist",
        name: "Playlist",
        component: () =>
            import ("@/pages/playlists/playlist"),
    },
    {
        path: "/playlists",
        name: "Playlists",
        component: () =>
            import ("@/pages/playlists"),
    },
    {
        path: "/track",
        name: "Track",
        component: () =>
            import ("@/pages/track"),
    },
    {
        path: "/podcasts",
        name: "Podcasts",
        component: () =>
            import ("@/pages/podcasts"),
    },
    {
        path: "/podcast/1",
        name: "Podcast",
        component: () =>
            import ("@/pages/podcasts/podcast"),
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