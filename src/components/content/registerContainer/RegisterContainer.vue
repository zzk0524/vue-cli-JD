<template>
	<div class="registercontainer">
		<main-container></main-container>
	</div>
</template>
<script>
	import MainContainer from 'components/common/registerContainer/MainContainer.vue'
	export default{
		name:"RegisterContainer",
		components:{
			MainContainer
		}
	}
</script>
<style scoped>
	.registercontainer{
		width: 90%;
		margin: 0 auto;
	}
</style>