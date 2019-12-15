import Vue from 'vue';
import vueRouter from 'vue-router';
import Login from "./components/login";

Vue.use(vueRouter);
export default new vueRouter({
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
        }
    ]
})
