<template>
	<div class="recommend">
		<list-head></list-head>
		<list-body @listbodyoffsettop="getListbodyoffsettop" :seagood="segood"></list-body>
		<recommend-head></recommend-head>
		<recommend-body></recommend-body>
	</div>
</template>
<script>
	import RecommendHead from 'components/common/recommend/RecommendHead.vue';
	import RecommendBody from 'components/common/recommend/RecommendBody.vue';
	import ListHead from 'components/common/list/ListHead.vue';
	import ListBody from 'components/common/list/ListBody.vue';
	export default{
		name:"MainRecommend",
		components:{
			RecommendHead,
			RecommendBody,
			ListHead,
			ListBody
		},
		data(){
			return{
				segoods:[]
			}
		},
		props:{
      segood: {
        type: Array,
        default: () => {
          return {}
        }
      }
    },
    watch: {
      segood: function(newVal,oldVal){
        this.segoods = newVal;  //newVal即是chartData
    	}
    },
		methods:{
			getListbodyoffsettop(data){
				this.$emit("listbodyoffsettop",data);
			}
		},
		mounted(){
			
		}
	}
</script>
<style scoped>
	.recommend{
		background-color: rgb(244,244,244);
	}
</style>