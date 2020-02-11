/*以下写的都是nodejs的语法， 不要被语法迷惑了， 我们主要看意思， 单词不重要*/

// 引入nodejs中的path模块，引入该模块后，就可以在当前文件中，使用path.join()函数了
// 该函数就是用来拼接地址的！
const path = require('path');

const webpack = require('webpack');

const {VueLoaderPlugin} = require('vue-loader');


// js的新语法，把一个json暴露出去。
// 以便外界可以使用这个json。
module.exports = {
	// __dirname是一个逻辑目，在运行时就是当前项目的真实路径。
	// 入口：
	entry: path.join(__dirname, "./js/main.js" ),
	// 出口：
	output: {
		path: path.join(__dirname, "./dist/"),
		filename: "bundle.js"
	},
	module: {
		rules: [
			// 以下的style-loader和css-loader顺序不能乱，必须这样写！
			// 处理css文件的顺序是，从后往前，先交给css-loader再交给style-loader
			{test:/\.css$/, use:['style-loader', 'css-loader']},
			{test:/\.(gif|jpg|bmp|png|svg|ttf|woff2|woff|eot)$/, use:['url-loader']},
			{test:/\.vue$/, use:['vue-loader']}
		]
	},
	plugins: [
		new webpack.ProvidePlugin({
			$:"jquery",
			jQuery:"jquery"
		}),
		new VueLoaderPlugin()
	],
	resolve: {
		alias: {
			'vue': 'vue/dist/vue.js'
		}
	}
};




