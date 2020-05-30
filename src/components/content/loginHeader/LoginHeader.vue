<template>
	<div class="loginheader">
		<div class="logo_con clearfix">
			<router-link to="/home">
				<a href="javascript:void(0)" class="logo"></a>
			</router-link>
			
			<div class="logo_title">欢迎登录</div>
			<a href="javascript:void(0)" class="q_link">
			<b></b>登录页面，问卷调查
		</a>
		</div>
		
	</div>
</template>
<script>
	export default{
		name:"LoginHeader"
	}
</script>
<style scoped>
	/*头部*/
	.loginheader {
		width: 100%;
	    height: 110px;
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
    margin-top: 24px;
    background: url(~assets/img/registerlogo.png) no-repeat;
	}
	/*欢迎登录*/
	.logo_title {
    float: left;
    height: 34px;
    line-height: 34px;
    font-size: 24px;
    color: #333;
    margin-top: 40px;
	}
	/*问卷调查*/
	.q_link {
    position: relative;
    color: #999;
    float: right;
    top: 52px;
    font-size: 12px;
	}
	.q_link:hover{
		color: #E4393C;
	}
	.q_link b {
    display: inline-block;
    width: 18px;
    height: 14px;
    margin: 0 5px;
    background: url(~assets/img/q-icon.png) no-repeat;
    overflow: hidden;
    vertical-align: middle;
	}
</style>