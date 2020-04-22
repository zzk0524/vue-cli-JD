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
			}
 		},
 		mounted(){
 			this.cancelBack();
 			this.loadMinWith();
 		}
	}
</script>
<style scoped>
	
</style>