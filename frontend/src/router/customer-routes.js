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
        path: "/playlist",
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
        path: "/user/1",
        name: "User",
        meta: {
            title: 'User',
            requiresAuth: true,
            role: ROLE_CODE.CUSTOMER
        },
        component: () =>
            import ( /* webpackChunkName: "customer-pages" */ "@/pages/customer/user"),
    },

];