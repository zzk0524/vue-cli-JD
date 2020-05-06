<template>
	<div>
		<main-header-Bar></main-header-Bar>
    <main-header :listbodyhight="listbodyh" @searchgoods="getsearchgoods"></main-header>
    <main-banner></main-banner>
    <main-recommend @listbodyoffsettop="getListbodyoffsettop" :segood="searchgood"></main-recommend>
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
	  data(){
	  	return{
	  		listbodyh:"",
	  		searchgood:[]
	  	}
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
	  	},
	  	getListbodyoffsettop(data){
				this.listbodyh = data;
			},
			getsearchgoods(data){
				this.searchgood = data;
				//console.log(this.searchgood);
				//this.$refs.children.say();
			}
 	  },
 	  mounted(){
 	  	this.cancelBack();
 	  	this.loadMinWith();
 	  	//console.log(localStorage.getItem('tempData'));
 	  }
	}
</script>
<style scoped>
	
</style>