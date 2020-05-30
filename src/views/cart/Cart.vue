<template>
	<div>
		<cart-header></cart-header>
		<cart-container></cart-container>
		<main-footer></main-footer>
	</div>
</template>
<script>
	import CartHeader from 'components/content/cartHeader/CartHeader.vue'
	import CartContainer from 'components/content/cartContainer/CartContainer.vue'
	import MainFooter from 'components/content/mainFooter/MainFooter.vue'
	
	export default{
		name:"Cart",
		components:{
			CartHeader,
			CartContainer,
			MainFooter
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
<style scoped></style>