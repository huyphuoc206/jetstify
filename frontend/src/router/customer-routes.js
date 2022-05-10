export const CUSTOMER_ROUTES = [
  {
    path: "/",
    name: "Home",
    component: () => import("@/pages/customer/home"),
  },
  {
    path: "/login",
    name: "Login",
    meta: {
      fullScreen: true,
    },
    component: () => import("@/pages/customer/login"),
  },
  {
    path: "/search",
    name: "Search",
    component: () => import("@/pages/customer/search"),
  },
  {
    path: "/queue",
    name: "Queue",
    component: () => import("@/pages/customer/queue"),
  },
  {
    path: "/albums",
    name: "Albums",
    component: () => import("@/pages/customer/albums"),
  },
  {
    path: "/artists",
    name: "Artists",
    component: () => import("@/pages/customer/artists"),
  },
  {
    path: "/album/1",
    name: "Album",
    component: () =>
      import("@/pages/customer/albums/album"),
  },
  {
    path: "/artist/1",
    name: "Artist",
    component: () =>
      import("@/pages/customer/artists/artist"),
  },
  {
    path: "/playlist",
    name: "Playlist",
    component: () =>
      import("@/pages/customer/playlists/playlist"),
  },
  {
    path: "/playlists",
    name: "Playlists",
    component: () =>
      import("@/pages/customer/playlists"),
  },
  {
    path: "/track",
    name: "Track",
    component: () =>
      import("@/pages/customer/track"),
  },
  {
    path: "/podcasts",
    name: "Podcasts",
    component: () =>
      import("@/pages/customer/podcasts"),
  },
  {
    path: "/podcast/1",
    name: "Podcast",
    component: () =>
      import("@/pages/customer/podcasts/podcast"),
  },
  {
    path: "/user/1",
    name: "User",
    component: () =>
      import("@/pages/customer/user"),
  },
];