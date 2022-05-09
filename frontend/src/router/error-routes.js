export const ERROR_ROUTES = [
    {
      path: "/admin/login",
      name: "AdminLogin",
      meta: {
        fullScreen: true,
      },
      component: () => import("@/pages/admin/login"),
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
  