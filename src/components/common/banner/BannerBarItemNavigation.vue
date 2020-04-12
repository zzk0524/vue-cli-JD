<template>
	<div class="banner-bar-item-navigation">
		<div class="navigation_left">
			<ul class="cate_menu" id="cate_menu">
				<slot name="s0"></slot>
			</ul>
			<div class="cate_pop divnone" id="cate_pop">
				<div class="cate_item divnone" :id="gernerateId(item)" :data-id="item" v-for="item in linum" :key="item">
					<slot :name="getslotname(item)"></slot>
				</div>
			</div>
		</div>
	</div>
</template>
<script>
	export default{
		name:"BannerBarItemNavigation",
		data(){
			return{
				linum:[]
			}
		},
		methods:{
			gernerateId(item){
				return "cate_item" +item;
			},
			getslotname(item){
				return "s" +item;
			},
			findcateitem(cateitemid){//显示当前，关闭其他的列表
				this.linum.forEach((item)=>{
					let cateitem_id = "cate_item"+item;
					if(cateitem_id==cateitemid){
						let cateitem = document.getElementById(cateitemid);
						cateitem.classList.remove("divnone");
					}else{
						let cateitem = document.getElementById(cateitem_id);
						cateitem.classList.add("divnone");
					}
				});
			},
			executebindbannermenu(){
				let _this = this;
				let catemenu = document.getElementById("cate_menu");
				let catepop = document.getElementById("cate_pop");
				let catemenuitem = catemenu.getElementsByTagName("li");
				for(let i=1;i<=catemenuitem.length;i++){
					this.linum.push(i);
				}
				catemenu.addEventListener("mouseover",(e)=>{
					e = e || window.event;
					let index,
						cateitemid;
					if(e.target.className == "cate_menu_item"){
						index = e.target.getAttribute("data-index");
					}else if(e.target.className == "cate_menu_lk"||e.target.className == "cate_menu_line"){
						index = e.target.parentNode.getAttribute("data-index");
					}
					cateitemid = "cate_item"+index;
					if(e.target.className == "cate_menu_item"||e.target.className == "cate_menu_lk"||e.target.className == "cate_menu_line"){
						catepop.classList.remove("divnone");
						_this.findcateitem(cateitemid);
						catepop.addEventListener("mouseover",()=>{
							catepop.classList.remove("divnone");
							catepop.addEventListener("mouseout",()=>{
								catepop.classList.add("divnone");
							})
						})
					}
					catemenu.addEventListener("mouseout",(e)=>{
						e = e || window.event;
						if(e.target.className == "cate_menu_item"||e.target.className == "cate_menu_lk"||e.target.className == "cate_menu_line"){
							catepop.classList.add("divnone");
						}
					})
				},true)
			}
		},
		mounted(){
			this.executebindbannermenu();
		}
	}
</script>
<style scoped>
	.divnone{
		display: none;
	}
	.divblock{
		display: block !important;
	}
    /*左侧导航栏*/
	.banner-bar-item-navigation{
		border:1px green solid;
		width: 190px;
		height: 480px;
		background-color: rgb(254,254,254);
	}
	/*左侧导航栏*/
	.navigation_left{
		position: relative;
	}
	/*左侧导航栏中的ul*/
	.cate_menu{
		overflow: hidden;
	    padding: 10px 0;
	    height: 460px;
	    background-color: #fefefe;
	    color: #636363;
	    margin-top: 10px;
	}
	/*左侧导航的每个li的颜色变化*/
	.cate_menu>li:hover{
		background-color: rgb(217,217,217);
	}
	.cate_menu>li>a:hover{
		color: #c81623;
	}
	/*隐藏区域*/
	.cate_pop{
		width: 798px;
		height: 478px;
		position: absolute;
		left: 188px;
    	top: -11px;
	    border: 1px solid #f7f7f7;
	    background-color: #fff;
	    -webkit-box-shadow: 2px 0 5px rgba(0,0,0,.3);
	    box-shadow: 2px 0 5px rgba(0,0,0,.3);
	}
	/*隐藏区域内层的大小*/
	.cate_item{
		width: 800px;
		height: 478px;
		padding: 20px 0 10px;
	}
	.cate_item>div{
		width: 800px;
	}
</style>