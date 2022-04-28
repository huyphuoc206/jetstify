import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: () => import("@/pages/home"),
  },
  {
    path: "/collection",
    name: "Collection",
    component: () => import("@/pages/collection"),
  },
  {
    path: "/login",
    name: "Login",
    meta: {
      fullScreen: true,
    },
    component: () => import(/* webpackChunkName: "about" */ "@/pages/login"),
  },
  {
    path: "/user-management",
    name: "UserManagement",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "@/pages/user-management"),
  },
  {
    path: "/search",
    name: "Search",
    component: () => import(/* webpackChunkName: "about" */ "@/pages/search"),
  },
  {
    path: "/queue",
    name: "Queue",
    component: () => import("@/pages/queue"),
  },

  {
    path: "/genres",
    name: "Genres",
    component: () => import("@/pages/genres"),
  },
  {
    path: "/discover",
    name: "Discover",
    component: () => import("@/pages/discover"),
  },
  {
    path: "/",
    redirect: "/browse/featured",
  },
  {
    path: "/album/:id",
    name: "Album",
    component: () => import("@/pages/album"),
  },
  {
    path: "/artist/1",
    name: "Artist",
    component: () => import("@/pages/artist"),
  },
  {
    path: "/overview",
    name: "ArtistOverview",
    component: () => import("@/pages/artist-overview"),
  },
  {
    path: "/about",
    name: "ArtistAbout",
    component: () => import("@/pages/artist-about"),
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
