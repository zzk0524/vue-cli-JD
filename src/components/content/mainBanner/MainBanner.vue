<template>
	<div>
		<banner-bar>
			<banner-bar-item></banner-bar-item>
			<banner-bar-item></banner-bar-item>           
		</banner-bar>
	</div>
</template>
<script>
	import BannerBar from "components/common/banner/BannerBar.vue";
	import BannerBarItem from "components/common/banner/BannerBarItem.vue";

	export default{
		name:"MainBanner",
		components:{
			BannerBar,
			BannerBarItem                                                                    
		}
	}
</script>
<style coped>
	
</style>