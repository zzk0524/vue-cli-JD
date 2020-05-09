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
		}
	}
</script>
<style scoped></style>