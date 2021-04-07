<template>
  <div id="app">
    <!--<img alt="Vue logo" src="./assets/logo.png">  -->
    <!--<HelloWorld msg="Welcome to Your Vue.js App"/>-->
    <HelloWorld msg=""/>
    <router-view/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script>

<!-- 前端要做的事情就是处理后端传来的数据，并传递给路由和导航菜单，以实现动态渲染 -->

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /*margin-top: 60px;*/
}
</style>
