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
		width: 1210px;
		margin: 0 auto;
	}
</style>