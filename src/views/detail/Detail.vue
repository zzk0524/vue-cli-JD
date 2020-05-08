<template>
	<div>
		<detail-body></detail-body>
		<main-footer></main-footer>
	</div>
</template>
<script>
	import DetailBody from 'components/content/detailBody/DetailBody.vue'
	import MainFooter from 'components/content/mainFooter/MainFooter.vue'
	export default{
		name:"Detail",
		components:{
			DetailBody,
			MainFooter
		}
	}
</script>
<style scoped>

</style>