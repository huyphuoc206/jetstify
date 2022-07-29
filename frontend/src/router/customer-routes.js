import { ROLE_CODE } from "@/core/constants";

export const CUSTOMER_ROUTES = [{
        path: "/",
        name: "Home",
        meta: {
            title: 'Home',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/home"),
    },
    {
        path: "/login",
        name: "Login",
        meta: {
            fullScreen: true,
            title: 'Login'
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/login"),
    },
    {
        path: "/verify-registration/:key",
        name: "VerifyRegistration",
        meta: {
            fullScreen: true,
            title: 'Verify Registration'
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/verify-registration"),
    },
    {
        path: "/forgot-password",
        name: "ForgotPassword",
        meta: {
            fullScreen: true,
            title: 'Forgot Password'
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/forgot-password"),
    },
    {
        path: "/reset-password/:email/:key",
        name: "ResetPassword",
        meta: {
            fullScreen: true,
            title: 'Reset Password'
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/reset-password"),
    },
    {
        path: "/search",
        name: "Search",
        meta: {
            title: 'Search',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/search"),
    },
    {
        path: "/queue",
        name: "Queue",
        meta: {
            title: 'Queue',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/queue"),
    },
    {
        path: "/albums",
        name: "Albums",
        meta: {
            title: 'Albums',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/albums"),
    },
    {
        path: "/artists",
        name: "Artists",
        meta: {
            title: 'Artists',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/artists"),
    },
    {
        path: "/album/1",
        name: "Album",
        meta: {
            title: 'Album Details',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/albums/album"),
    },
    {
        path: "/artist/:id",
        name: "Artist",
        meta: {
            title: 'Artist Details',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/artists/artist"),
    },
    {
        path: "/playlist/:id",
        name: "Playlist",
        meta: {
            title: 'Playlist Details',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/playlists/playlist"),
    },
    {
        path: "/playlists",
        name: "Playlists",
        meta: {
            title: 'Playlist',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/playlists"),
    },
    {
        path: "/track",
        name: "Track",
        meta: {
            title: 'Track',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/track"),
    },
    {
        path: "/podcasts",
        name: "Podcasts",
        meta: {
            title: 'Podcasts',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/podcasts"),
    },
    {
        path: "/podcast/:id",
        name: "Podcast",
        meta: {
            title: 'Podcast Details',
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/podcasts/podcast"),
    },
    {
        path: "/user",
        name: "User",
        meta: {
            title: 'User',
            requiresAuth: true,
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/user"),
    },
    {
        path: "/artist-setting",
        name: "Artist-setting",
        meta: {
            title: 'Artist',
            requiresAuth: true,
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/artist-setting"),
    },
    {
        path: "/podcast-setting",
        name: "Podcast-setting",
        meta: {
            title: 'Podcast',
            requiresAuth: true,
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/podcast-setting"),
    },

];