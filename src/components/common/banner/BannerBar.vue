<template>
	<div id="bannerBar">
		<slot></slot>
	</div>
</template>
<script>
	export default{
		name:"BannerBar"
	}
</script>
<style scoped>
	/*480*/
	#bannerBar{
		display: flex;
		height: 480px;
		width: 991px;
		border:1px red solid;
	}
</style>