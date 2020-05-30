 <template>
 	<div>
 		<user-header></user-header>
 		<user-container></user-container>
 		<register-footer></register-footer>
 	</div>
 </template>
 <script>
 	import UserHeader from 'components/content/userHeader/UserHeader.vue';
 	import UserContainer from 'components/content/userContainer/UserContainer.vue';
	import RegisterFooter from 'components/content/registerFooter/RegisterFooter.vue';
 	export default{
 		name:"Register",
 		components:{
 			UserHeader,
 			UserContainer,
 			RegisterFooter
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