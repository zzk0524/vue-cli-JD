<template>
	<div class="adminheader">
		<div class="logo_con clearfix">
			<a href="javascript:void(0)" class="logo"></a>
			<div class="logo_title">管理系统</div>
			<a href="javascript:void(0)" class="exit" @click="exitBtn()">退出登录</a>
		</div>
	</div>
</template>
<script>
	export default{
		name:"AdminHeader",
		methods:{
			exitBtn(){
				this.$router.replace({name:'Login'});
			}
		}
	}
</script>
<style scoped>
	/*头部*/
	.adminheader {
		width: 100%;
    height: 70px;
    box-shadow:0 2px 2px rgb(178,178,178);
	}
	/*头部的内层*/
	.logo_con {
    width: 90%;
    margin: 0 auto;
	}
	.clearfix:after {
    content: ".";
    display: block;
    height: 0;
    clear: both;
    visibility: hidden;
	}
	/*logo图片*/
	.logo {
    width: 160px;
    height: 50px;
    float: left;
    margin-top: 10px;
    background: url(~assets/img/registerlogo.png) no-repeat;
	}
	/*欢迎注册*/
	.logo_title {
    float: left;
    height: 34px;
    line-height: 34px;
    font-size: 24px;
    color: #333;
    margin-top: 25px;
	}
	.exit{
		float: right;
		height: 34px;
    line-height: 34px;
    color: #333;
    margin-top: 25px;
	}
	.exit:hover{
		color: #E2231A;
	}
</style>