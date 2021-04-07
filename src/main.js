import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from "element-ui"
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'

// 设置反向代理，前端请求默认发送到http://localhost:8443/api
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8095/api'
// 通过axios主动开启withCredentials功能
axios.defaults.withCredentials = true
// 全局注册，之后可在其他组件中通过this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false

Vue.use(ElementUI)

router.beforeEach((to, from, next) => {
  if (store.state.user.username && to.path.startsWith("/admin")) {
    initAdminMenu(router, store);
  }
  // 已登录状态下访问login页面直接跳转到后台首页
  if (store.state.username && to.path.startsWith("/login")) {
    next({
      path: 'admin/dashboard'
    })
  }
  if (to.meta.requireAuth) {
    if (store.state.user) {
      axios.get('/authentication').then(resp => {
        if (resp) next()
      })
    }else {
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    }
  }else {
    next()
  }
})

// http response 拦截器
axios.interceptors.response.use(
    response => {
      return response
    },
    error => {
      if (error) {
        store.commit('logout')
        router.replace('/login')
      }
      // 返回接口的错误信息
      return Promise.reject(error)
    }
)

const initAdminMenu = (router, store) => {
  axios.get('/menu').then(resp => {
    if (resp && resp.status === 200) {
      var fmtRoutes = formatRoutes(resp.data)
      router.addRoutes(fmtRoutes)
      store.commit('initAdminMenu', fmtRoutes)
    }
  })
}
initAdminMenu
// 这里传入的参数routes代表我们从后端获取的菜单列表
const formatRoutes = (routes) => {
  let fmtRoutes = []
  routes.forEach(route => {
    if (route.children) {
      route.children = formatRoutes(route.children)
    }

    let fmtRoute = {
      path : route.path,
      component : resolve => {
        require(['./components/admin/' + route.component + '.vue'], resolve);
      },
      name : route.name,
      nameZh : route.nameZh,
      iconCls : route.iconCls,
      children : route.children
    }
    fmtRoutes.push(fmtRoute)
  })
  return fmtRoutes
}


new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})
