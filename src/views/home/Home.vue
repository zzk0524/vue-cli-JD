<template>
	<div>
		<main-header-Bar></main-header-Bar>
    <main-header></main-header>
    <main-banner></main-banner>
    <main-recommend></main-recommend>
    <main-footer></main-footer>
	</div>
</template>
<script>
	/*页面最上部的导航栏*/
	import MainHeaderBar from 'components/content/mainHeader/MainHeaderBar.vue';
	/*头部*/
	import MainHeader from 'components/content/mainHeader/MainHeader.vue';
	/*banner*/
	import MainBanner from 'components/content/mainBanner/MainBanner.vue';
	/*推荐区*/
	import MainRecommend from 'components/content/mainRecommend/MainRecommend.vue';
	/*footer区*/
	import MainFooter from 'components/content/mainFooter/MainFooter.vue';
	export default{
		name:"Home",
		components: {
	    MainHeaderBar,
	    MainHeader,
	    MainBanner,
	    MainRecommend,
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