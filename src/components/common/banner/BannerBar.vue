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
	/*左侧导航栏+轮播图区*/
	#bannerBar{
		display: flex;
		width: 990px;
		height: 480px;
		background-color: rgb(244,244,244);
	}
</style>