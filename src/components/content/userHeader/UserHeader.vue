<template>
	<div class="userheader">
		<div class="logo_con clearfix">
			<a href="javascript:void(0)" class="logo"></a>
			<div class="logo_title">修改密码</div>
			<div class="have_account">
					<a @click="backHome()">返回主页></a>	
			</div>
		</div>
	</div>
</template>
<script>
	export default{
		name:"RegisterHeader",
		data(){
			return{
				currentLog:[]//保存当前登录的用户信息
			}
		},
		methods:{
			getCurrentLog(){//保存传来的用户信息
				const tempData = window.sessionStorage.getItem('tempData');
				if(tempData){//刷新页面
					this.currentLog = JSON.parse(tempData);
				}else{
					this.currentLog = this.$route.params.currentLog;
					window.sessionStorage.setItem('tempData', JSON.stringify(this.$route.params.currentLog));
				}
				//console.log(this.$route.params.currentLog);
			},
			backHome(){
				this.$router.replace({name:'Home'});
			}
		},
		mounted(){
			this.getCurrentLog();
		}
	}
</script>
<style scoped>
	/*头部*/
	.userheader {
		width: 100%;
	    height: 110px;
	    box-shadow:0 3px 3px red;
	}
	/*头部的内层*/
	.userheader .logo_con {
    width: 90%;
    margin: 0 auto;
	}
	.userheader .clearfix:after {
    content: ".";
    display: block;
    height: 0;
    clear: both;
    visibility: hidden;
	}
	/*logo图片*/
	.userheader .logo {
    width: 160px;
    height: 50px;
    float: left;
    margin-top: 24px;
    background: url(~assets/img/registerlogo.png) no-repeat;
	}
	/*欢迎注册*/
	.userheader .logo_title {
    float: left;
    height: 34px;
    line-height: 34px;
    font-size: 24px;
    color: #333;
    margin-top: 40px;
	}
  /*返回*/
	.userheader .have_account {
    font-size: 16px;
    float: right;
    margin-top: 55px;
    color: #999;
    cursor: pointer;
	}
</style>