<!-- 
 1. 一个文件的后缀如果是"vue"， 该该文件就是一个vue组件！！
 2. 该组件是独立于任何html页面的（以前定义vue组件都是在html页面中定义的）
 3. 作为独立的vue组件，必须有3部分内容： template 组件内容  script  style
 4. 不用写body，毕竟这不是html页面而是一个独立的组件
-->
<template>
	<div>
		username: <input type="text" v-model="username"> <br>
		password: <input type="text" v-model="password"> <br>
		<button>登录</button>
		<a @click.prevent="f1">去注册</a>
	</div>
</template>

<script>
// 独立的vue组件，必须把自身导出去，这样其他js文件才能把该组件引入！！

// 以下的 {} 就是一个json， 在该json中，就可以定义组件的属性 、方法

export default {
	data() {
		return {
			username: 'aa',
			password: 'bb'
		}
	},
	methods: {
		f1() {
			this.$router.push("/reg");
		}
	}
}

</script>

<style>
</style>
