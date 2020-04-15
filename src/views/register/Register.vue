 <template>
 	<div>
 		<register-header></register-header>
 		<register-container></register-container>
 		<register-footer></register-footer>
 	</div>
 </template>
 <script>
 	import RegisterHeader from 'components/content/registerHeader/RegisterHeader.vue';
 	import RegisterContainer from 'components/content/registerContainer/RegisterContainer.vue';
	import RegisterFooter from 'components/content/registerFooter/RegisterFooter.vue';
 	export default{
 		name:"Register",
 		components:{
 			RegisterHeader,
 			RegisterContainer,
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