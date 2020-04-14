 <template>
 	<div>
 		<register-header></register-header>
 	</div>
 </template>
 <script>
 	import RegisterHeader from 'components/content/registerHeader/RegisterHeader.vue';
 	export default{
 		name:"Register",
 		components:{
 			RegisterHeader
 		},
 		mounted(){
 			history.pushState(null, null, document.URL); 
			window.addEventListener('popstate', function() { 
				history.pushState(null, null, document.URL); 
			});
 		}
 	}
 </script>
 <style scoped>
	
 </style>