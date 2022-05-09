export const ADMIN_ROUTES = [
  {
    path: "/admin/login",
    name: "AdminLogin",
    meta: {
      fullScreen: true,
    },
    component: () => import("@/pages/admin/login"),
  },
  {
    path: "/admin/home",
    name: "AdminHome",
    meta: {
      fullScreen: true,
    },
    component: () =>
      import("@/pages/admin/home"),
  },
  {
    path: "/admin/category",
    name: "AdminCategory",
    meta: {
      fullScreen: true,
    },
    component: () =>
      import("@/pages/admin/category"),
  },
];
