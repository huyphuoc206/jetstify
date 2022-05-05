export const CUSTOMER_ROUTES = [
  {
    path: "/",
    name: "Home",
    component: () => import("@/pages/customer/home"),
  },
  {
    path: "/collection",
    name: "Collection",
    component: () => import("@/pages/customer/collection"),
  },
  {
    path: "/login",
    name: "Login",
    meta: {
      fullScreen: true,
    },
    component: () => import(/* webpackChunkName: "about" */ "@/pages/customer/login"),
  },
  {
    path: "/search",
    name: "Search",
    component: () => import(/* webpackChunkName: "about" */ "@/pages/customer/search"),
  },
  {
    path: "/queue",
    name: "Queue",
    component: () => import("@/pages/customer/queue"),
  },

  {
    path: "/genres",
    name: "Genres",
    component: () => import("@/pages/customer/genres"),
  },
  {
    path: "/discover",
    name: "Discover",
    component: () => import("@/pages/customer/discover"),
  },
  {
    path: "/",
    redirect: "/browse/featured",
  },
  {
    path: "/album/:id",
    name: "Album",
    component: () => import("@/pages/customer/album"),
  },
  {
    path: "/artist/1",
    name: "Artist",
    component: () => import("@/pages/customer/artist"),
  },
  {
    path: "/overview",
    name: "ArtistOverview",
    component: () => import("@/pages/customer/artist-overview"),
  },
  {
    path: "/about",
    name: "ArtistAbout",
    component: () => import("@/pages/customer/artist-about"),
  },
];
