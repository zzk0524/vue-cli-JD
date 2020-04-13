<template>
	<div class="recommend">
		<recommend-head></recommend-head>
		<recommend-body></recommend-body>
	</div>
</template>
<script>
	import RecommendHead from 'components/common/recommend/RecommendHead.vue';
	import RecommendBody from 'components/common/recommend/RecommendBody.vue';

	export default{
		name:"MainRecommend",
		components:{
			RecommendHead,
			RecommendBody
		}
	}
</script>
<style scoped>
	.recommend{
		background-color: rgb(244,244,244);
	}
</style>