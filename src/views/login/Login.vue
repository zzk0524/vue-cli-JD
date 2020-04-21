<template>
	<div class="login">
		<login-header></login-header>
		<login-container></login-container>
		<login-footer></login-footer>
	</div>
</template>
<script>
	import LoginHeader from 'components/content/loginHeader/LoginHeader.vue'
	import LoginContainer from 'components/content/loginContainer/LoginContainer.vue'
	import LoginFooter from 'components/content/loginFooter/LoginFooter.vue'

	export default{
		name:"Login",
		components:{
			LoginHeader,
			LoginContainer,
			LoginFooter
		},
		data(){
			return{

			}
		},
		methods:{
 			cancelBack(){	
 				history.pushState(null, null, document.URL); 
				window.addEventListener('popstate', function() { 
					history.pushState(null, null, document.URL); 
				});
 			},
 			loadMinWith(){
				document.getElementsByTagName("body")[0].style.minWidth = (window.screen.width-17)+"px";
			},
			registJudge(){
				let form = this.$route.params.data;
				console.log(form);
				console.log(JSON.stringify(form));
				let oAjax = null;
					if(window.XMLHttpRequest){
						oAjax = new XMLHttpRequest();
					}else{
						oAjax = new ActiveXObject("Microsoft.XMLHTTP");
					}
					oAjax.open('POST','http://127.0.0.1/goods/registUser',true);
					oAjax.setRequestHeader("Content-type","application/json");
					oAjax.send(JSON.stringify(form));
					oAjax.onreadystatechange=function(){
					  if(oAjax.readyState==4){
					    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
					      //对响应进行解析
					      let users=JSON.parse(oAjax.responseText);
					      //跳转登录页面
					      alert(users.message);
					      // setTimeout(function(){
					       	 //_this.$router.push({path:'/login'});
					      // 	window.location.href = "/login";
					      // },1000)     
					    }else{
					      //对响应进行解析
					      alert("服务器错误");
					    }
					  }
					}
			}
 		},
 		mounted(){
 			this.cancelBack();
 			this.loadMinWith();
 			//this.registJudge();
 		}
	}
</script>
<style scoped>
	
</style>