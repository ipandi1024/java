import $ from 'jquery';
import Vue from 'vue';
import layer from 'layui-layer';
import axios from 'axios';
import VueRouter from 'vue-router';
import 'bootstrap3/dist/css/bootstrap.min.css';
import login from '../vue/login.vue';
import reg from '../vue/reg.vue';
import App from '../vue/App.vue';

axios.defaults.baseURL = "http://localhost";

window.$ = $;
window.jQuery = $;
window.axios = axios;
window.Vue = Vue;

// 固定写法
Vue.use(VueRouter);
window.VueRouter = VueRouter;




// 以下代码是专门用于48_vue.html页面的
// 所以，你要测试其他页面，请把底下代码注释！

// 定义路由
var router = new VueRouter({
	routes:[
		{path:"/login", component:login},
		{path:"/reg", component:reg}
	]
});

var app = new Vue({
	el:"#app",
	render:c => c(App),
	router
});








