<template>
	<div>
		username: <input type="text" v-model="username"> <br>
		password: <input type="text" v-model="password"> <br>
		<button>注册</button>
		<a @click.prevent="f1">去登录</a>
	</div>
</template>

<script>

export default {
	data() {
		return {
			username: 'xx',
			password: 'yy'
		}
	},
	methods: {
		f1() {
			this.$router.push("/login");
		}
	}
}

</script>

<style>
</style>
