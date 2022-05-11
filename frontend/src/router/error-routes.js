export const ERROR_ROUTES = [
    {
        path: '*',
        name: 'NotFound',
        meta: {
            code: 404,
            fullScreen: true,
            title: 'Page Not Found'
        },
        component: () => import(/* webpackChunkName: "error-pages" */ '@/pages/error-page')
    },
    {
        path: '/server-error',
        name: 'ServerError',
        meta: {
            code: 500,
            fullScreen: true,
            title: 'Internal Server Error'
        },
        component: () => import(/* webpackChunkName: "error-pages" */ '@/pages/error-page')
    },
    {
        path: '/forbidden',
        name: 'Forbidden',
        meta: {
            code: 403,
            fullScreen: true,
            title: 'Access Forbidden'
        },
        component: () => import(/* webpackChunkName: "error-pages" */ '@/pages/error-page')
    },
];
