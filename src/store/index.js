import Vue from 'vue'
import VueX from 'vuex'

Vue.use(VueX)

export default new VueX.Store({
    state: {
        user: {
            username: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).username
        }
    },
    mutations: {
        initAdminMenu (state, menus) {
            // state.AdminMenu = menus
            state.adminMenus = menus
        },
        login(state, user) {
            state.user = user;
            window.localStorage.setItem('user', JSON.stringify(user));
        },
        logout(state) {
            state.user = ''
            window.localStorage.removeItem('user')
        }
    }
})
