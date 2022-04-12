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
        path: "/collection",
        name: "Collection",
        component: () =>
            import ("@/pages/collection"),
    },
    {
        path: "/Login",
        name: "Login",
        component: () =>
            import ( /* webpackChunkName: "about" */ "@/pages/login"),
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
        path: "/album/:id",
        name: "Album",
        component: () =>
            import ("@/pages/album"),
    },
    {
        path: "/artist/:id",
        name: "Artist",
        component: () =>
            import ("@/pages/artist"),
    },
    {
        path: "/overview",
        name: "ArtistOverview",
        component: () =>
            import ("@/pages/artist-overview"),
    },
    {
        path: "/about",
        name: "ArtistAbout",
        component: () =>
            import ("@/pages/artist-about"),
    },

    {
        path: "/*",
        redirect: {
            name: "Home",
        },
    },

    // {
    //     path: "/auth",
    //     component: () =>
    //         import ( /* webpackChunkName: "auth-layout" */ "../layouts/AuthLayout.vue"),
    //     children: [{
    //         path: "/login",
    //         name: "login",
    //         component: () =>
    //             import ( /* webpackChunkName: "login" */ "@/pages/login"),
    //     }, ],
    // },
    // {
    //     path: "/",
    //     name: "Home",
    //     component: () =>
    //         import ( /* webpackChunkName: "app-layout" */ "../layouts/AppLayout.vue"),

    //     children: [{
    //             path: "browse",
    //             component: () =>
    //                 import ("../views/Home.vue"),
    //             children: [{
    //                     path: "featured",
    //                     name: "featured",
    //                     component: () =>
    //                         import ("../views/Featured.vue"),
    //                 },
    //                 {
    //                     path: "genres",
    //                     name: "genres",
    //                     component: () =>
    //                         import ("../views/Genres.vue"),
    //                 },
    //                 {
    //                     path: "discover",
    //                     name: "discover",
    //                     component: () =>
    //                         import ("../views/Discover.vue"),
    //                 },
    //                 {
    //                     path: "",
    //                     redirect: "/browse/featured",
    //                 },
    //             ],
    //         },
    //         {
    //             path: "album/:id",
    //             name: "album",
    //             component: () =>
    //                 import ("../views/Album.vue"),
    //         },
    //         {
    //             path: "artist/:id",
    //             component: () =>
    //                 import ("../views/Artist.vue"),
    //             children: [{
    //                     path: "",
    //                     name: "artist",
    //                     component: () =>
    //                         import ("../views/ArtistOverview.vue"),
    //                 },
    //                 {
    //                     path: "about",
    //                     name: "artist-about",
    //                     component: () =>
    //                         import ("../views/ArtistAbout.vue"),
    //                 },
    //             ],
    //         },
    //         {
    //             path: "search",
    //             name: "search",
    //             component: () =>
    //                 import ("../views/Search.vue"),
    //         },
    //         {
    //             path: "queue",
    //             name: "queue",
    //             component: () =>
    //                 import ("../views/Queue.vue"),
    //         },
    //         {
    //             path: "*",
    //             redirect: {
    //                 name: "featured",
    //             },
    //         },
    //     ],
    //     meta: {
    //         isAuthRequired: true,
    //     },
    // },
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