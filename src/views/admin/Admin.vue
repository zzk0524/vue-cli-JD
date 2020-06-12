<template>
	<div>
		<admin-header></admin-header>
		<admin-container></admin-container>
	</div>
</template>
<script>
	import AdminHeader from 'components/content/adminHeader/AdminHeader.vue';
	import AdminContainer from 'components/content/adminContainer/AdminContainer.vue';
	export default{
		name:"Admin",
		components: {
	    AdminHeader,
	    AdminContainer
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
<!-- 
	管理员
	1.对商品进行管理
		i.查询商品库存
	   ii.增加单条商品
	  iii.修改商品
	 iiii.删除商品
	 不考虑库存:
	 	增加商品sku不能一样就可以
	 	修改只修改商品的信息
	2.对用户进行管理 
		i.查询所有用户
	   ii.修改用户信息
	  iii.删除该用户
	3.对自己进行管理
-->