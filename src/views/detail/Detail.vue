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
<style scoped>

</style>