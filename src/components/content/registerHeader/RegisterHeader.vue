<template>
	<div class="registerheader">
		<div class="logo_con clearfix">
			<router-link to="/home">
				<a href="javascript:void(0)" class="logo"></a>
			</router-link>
			<div class="logo_title">欢迎注册</div>
			<div class="have_account">
				已有账号？
				<router-link to="/login">
					<a>请登录></a>
				</router-link>	
			</div>
		</div>
	</div>
</template>
<script>
	export default{
		name:"RegisterHeader"
	}
</script>
<style scoped>
	/*头部*/
	.registerheader {
		width: 100%;
	    height: 110px;
	    box-shadow:0 3px 3px red;
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
	/*欢迎注册*/
	.logo_title {
    float: left;
    height: 34px;
    line-height: 34px;
    font-size: 24px;
    color: #333;
    margin-top: 40px;
	}
	/*已有账号*/
	.have_account {
    font-size: 16px;
    float: right;
    margin-top: 55px;
    color: #999;
	}
	/*请登录*/
	.have_account a {
    color: #e22;
    cursor: pointer;
	}
</style>