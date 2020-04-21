<template>
	<div>
		<div id="header">
		  <div class="header_content">
		    <div id="logo" class="logo">
		    	<img src="~assets/img/logo.png" alt="logo">
		    </div>
				<div id="search">
		      <div class="search_content">
						<div class="form" role="serachbox">
		          <input type="text" autocomplete="off" id="key" class="text" placeholder="华为盒子" aria-label="搜索" v-model="search" @focus="searchfocus($event)"/>
		          <span class="photo_search_bg">
		          	<img src="~assets/img/photo.png" alt="小相机">
		          </span>
		          <button class="search_button" aria-label="搜索" id="search_button" @click="searchbtn">
		          	<img src="~assets/img/search-icon.png" alt="搜索">
		          </button>
		        </div>
		        <div class="divnone">隐藏</div>
						<div id="settleup" class="dropdown">
		          <div class="cw-icon">
		            <div>
		            	<img src="~assets/img/buycar.png" alt="购物车">
									<i class="ci-count" id="shopping-amount">0</i>
		            </div>
		            <a target="_blank" href="#">我的购物车</a>
		        	</div>
		        </div>
		      </div>
		    </div>
		    <div id="hotwords" role aria-label="热搜词">
		    	<a href="#" id="specHotWord" class="style_red">动态轮播的</a>
		    	<a href="#">品质钟表</a>
		    	<a href="#">笔记本</a>
		    	<a href="#">WIS面膜</a>
		    	<a href="#">电脑数码</a>
		    	<a href="#">手机补贴</a>
		    	<a href="#">家装节</a>
		    	<a href="#">运动户外</a>
		    	<a href="#">美妆好物</a>
		    </div>
				<div id="navitems" role="navigation">
		      <ul id="navitems-group1">
		        <li class="fore1">
		          <a class="navitems-lk" href="#" aria-lable="秒杀">秒杀</a>
		        </li>
		        <li class="fore2">
		          <a class="navitems-lk" href="#" aria-lable="优惠券">优惠券</a>
		        </li>
		        <li class="fore3">
		          <a class="navitems-lk" href="#" aria-lable="PLUS会员">PLUS会员</a>
		        </li>
		        <li class="fore4">
		          <a class="navitems-lk" href="#" aria-lable="品牌闪购">品牌闪购</a>
		        </li>
		        <li class="fore5">
		          <a class="navitems-lk" href="#" aria-lable="拍卖">拍卖</a>
		        </li>
		        <li class="fore6">
		          <a class="navitems-lk" href="#" aria-lable="淘淘家电">淘淘家电</a>
		        </li>
		        <li class="fore7">
		          <a class="navitems-lk" href="#" aria-lable="淘淘超市">淘淘超市</a>
		        </li>
		        <li class="fore8">
		          <a class="navitems-lk" href="#" aria-lable="淘淘生鲜">淘淘生鲜</a>
		        </li>
		        <li class="fore9">
		          <a class="navitems-lk" href="#" aria-lable="淘淘国际">淘淘国际</a>
		        </li>
		        <li class="fore10">
		          <a class="navitems-lk" href="#" aria-lable="淘淘金融">淘淘金融</a>
		        </li>
		      </ul>
        </div>
				<div id="treasure">
					<div id="J_promo_lk" class="promo_lk" aria-label="推广位">
						<div><img src="~assets/img/phonecode.png" alt="二维码"></div>
					</div>
				</div>
		  </div>
		</div>
	</div>
</template>
<script>
	export default{
		name:"MainHeader",
		data(){
			return{
				search:''
			}
		},
		methods:{
			getelement(eleid){
				return document.getElementById(eleid);
			},
			searchbtn(){
				//发送ajax请求
			},
			searchfocus($event){
				let timer;
		    $event.target.onkeyup = function(e) {
		      if(timer){
		      	clearTimeout(timer);
		      } 
		      timer = setTimeout(() => {
		        console.log($event.target.value);
		        //发送请求
		      }, 1000)
		    }
			}
		},
		mounted(){

		}
	}
</script>
<style scoped>
	.divnone{
		display: none;
	}
	/*头部*/
	#header{
		width: 100%;
		height: 141px;
		border-bottom:1px rgb(221,221,221) solid;
	}
	/*头部内容*/
	.header_content{
		position: relative;
		width: 1190px;
		height: 100%;
		margin: auto;
	}
	/*logo区域*/
	.logo{
		position: absolute;
		width: 190px;
		height: 120px;
		left: 0;
	    top: 10px;
	    background-color: #fff;
	}
	/*logo图标*/
	.logo img{
		width: 100%;
		height: 100%;
	}
	/*搜索区域*/
	.search_content {
    position: relative;
    height: 60px;
	}
	/*搜索区域*/
	.search_content .form {
    position: absolute;
    left: 260px;
    top: 25px;
    width: 546px;
    height: 36px;
    border: 2px solid #e2231a;
    background: #fff;
	}
	/*搜索框内容*/ 
	#key{
    position: absolute;
    top: 0;
    outline: none;
    left: 0;
    padding: 2px 44px 2px 17px;
    width: 480px;
    height: 32px;
    border: 1px solid transparent;
    line-height: 26px;
    font-size: 12px;
    background: transparent;
	}
	/*相机位置*/
	.search_content .photo_search_bg {
    position: absolute;
    right: 75px;
    top: 10px;
    width: 16px;
    height: 15px;
    overflow: hidden;
	}
	/*相机图标*/
	.search_content .photo_search_bg img {
		width: 100%;
		height: 100%;
	}
	/*搜索按钮*/
	.search_button {
		position: absolute;
    top: 0px;
    outline: none;
    border-radius: 0;
    right: 0;
    width: 58px;
    height: 32px;
    border: none;
    background-color: #e1251b;
	}
	/*搜索图标*/
	.search_button img {
		width: 20px;
		height: 22px;
		margin-top: 6px;
	}
	/*购物车*/
	#settleup {
    position: absolute;
    right: 230px;
    top: 25px;
	}
	/*购物车边框*/
	#settleup .cw-icon {
		display: flex;
		align-items: center;
		overflow: hidden;
    float: left;
    border: 1px solid #e3e4e5;
    width: 130px;
    height: 34px;
    background-color: #fff;
    border-color: #eee;
  }
  #settleup .cw-icon:hover{
  	border: 1px solid #e33333;
  	transition: 1s;
  }
  /*为做上标*/
  #settleup .cw-icon div {
  	position: relative;
  }
  /*购物车上标*/
  #settleup .cw-icon div i {
		position: absolute;
		display: inline-block;
		width: 18px;
		height: 14px;
		left: 27px;
		top: -1px;
    padding: 1px 3px;
    font-size: 12px;
    line-height: 12px;
    color: #fff;
    background-color: #e1251b;
    border-radius: 7px;
    min-width: 12px;
    text-align: center;
  }
  /*购物车图标*/
  #settleup .cw-icon img {
  	width: 16px;
  	height: 18px;
  	margin-top: 5px;
  	margin-left: 15px;
  }
  /*购物车文字*/
  #settleup .cw-icon a{
  	display: inline-block;
		color: #e1251b;
		font-size: 12px;
		margin-left: 16px;
		color: #e33333;
  }
  /*热词*/
	#hotwords {
    overflow: hidden;
    position: absolute;
    left: 260px;
    top: 65px;
    width: 550px;
    height: 20px;
    line-height: 20px;
	}	/*所有的基本样式*/
	#hotwords a {
    float: left;
    margin-right: 10px;
    white-space: nowrap;
    font-size: 12px;
    color: #999;
	}
	#hotwords a:hover{
		color: #e33333;
	}
	/*第一个动态的*/
	.style_red {
    color: #e1251b !important;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
	}
	/*Navitems*/
	#navitems {
    overflow: hidden;
    position: absolute;
    left: 203px;
    bottom: 0;
    height: 60px;
    padding-top: 20px;
	}
	#navitems ul,
	#navitems li {
    float: left;
	}
	#navitems li {
		list-style: none;
		margin-left: 1px;
	}
	/*红字*/
	.fore1 a,
	.fore2 a{
		color: #e1251b;
	}	
	/*a标签*/
	.navitems-lk {
		position: relative;
		display: block;
		height: 40px;
		line-height: 40px;
		font-size: 15px;
		margin: 0 11px;
	}
	.navitems-lk:hover{
		color: #e33333;
	}
	/*手机二维码*/
	#treasure {
    position: absolute;
    right: 0;
    bottom: 10px;
    width: 190px;
    height: 120px;
  }
  .promo_lk {
		width: 77px;
		height: 77px;
		border: 1px solid rgb(243,243,243);
		box-shadow: 2px 2px 2px rgb(243,243,243);
		position: absolute;
		top: -8px;
  	left: 90px;
  }
  .promo_lk div {
  	width: 61px;
  	height: 61px;
  	margin: 7px;
  }
  /*图片*/
  .promo_lk div img {
  	width: 100%;
  	height: 100%;
  }
</style>
