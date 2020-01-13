import router from 'vue-router';
import Vue from 'vue'
import Login from "./components/login";
import toubu from "./components/toubu";
import dibu from "./components/dibu";
Vue.use(router);//使用vue-router
export default new router({
    routes: [
        {
            path: '/',
            name: 'HelloWord',
            meta: {
                title: 'HelloWord'
            },
            component: () => import('@/components/HelloWorld.vue')
        },
        {
            path: '/login',
            name: 'login',
            meta: {
                title: '登陆'
            },
            component: Login
        },
        {
            path: '/toubu',
            name: 'toubu',
            meta: {
                title: '头部'
            },
            component: toubu
        },
        {
            path: '/dibu',
            name: 'dibu',
            meta: {
                title: '尾部'
            },
            component: dibu
        }
    ]
})

