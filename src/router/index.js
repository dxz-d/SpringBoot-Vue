import Vue from "vue";
import Router from "vue-router"
// 导入刚才编写的组件
import AppIndex from "@/components/home/Appindex";
import Login from "@/components/Login";
import Home from  "../components/Home"

Vue.use(Router)

export default new Router({
    mode: "history",
    routes: [
        // 下面都是固定的写法
        {
            path: '/login',
            name: 'Login',
            component: Login
        },
        {
            path: '/home',
            name: 'Home',
            component: Home,
            // Home页面不需要被访问
            redirect: '/index',
            children: [
                {
                    path: '/index',
                    name: 'AppIndex',
                    component: AppIndex,
                    meta: {
                        requireAuth: true
                    }
                }
            ]
        }
    ]

})