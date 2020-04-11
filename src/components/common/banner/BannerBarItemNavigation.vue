<template>
	<div class="banner-bar-item-navigation">
		<div class="navigation_left">
			<ul class="cate_menu" id="cate_menu">
				<slot name="s0"></slot>
			</ul>
			<div class="cate_pop divnone" id="cate_pop">
				<div class="cate_item" :id="gernerateId(item)" :data-id="item" v-for="item in linum" :key="item">
					这是第{{item}}个li
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
			executebindbannermenu(){
				let catemenu = document.getElementById("cate_menu");
				let catepop = document.getElementById("cate_pop");
				let catemenuitem = catemenu.getElementsByTagName("li");
				for(let i=1;i<=catemenuitem.length;i++){
					this.linum.push(i);
				}
				catemenu.addEventListener("mouseover",(e)=>{
					e = e || window.event;
					if(e.target.tagName.toLowerCase() == "li"||e.target.tagName.toLowerCase() == "a"||e.target.tagName.toLowerCase() == "span"){
						catepop.classList.remove("divnone");
						catepop.addEventListener("mouseover",()=>{
							catepop.classList.remove("divnone");
							catepop.addEventListener("mouseout",()=>{
								catepop.classList.add("divnone");
							})
						})
					}
					catemenu.addEventListener("mouseout",(e)=>{
						e = e || window.event;
						if(e.target.tagName.toLowerCase() == "li"){
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
	.cate_menu>li:hover{
		background-color: rgb(217,217,217);
	}
	.cate_menu>li>a:hover{
		color: #c81623;
	}
	.cate_pop{
		width: 798px;
		height: 468px;
		position: absolute;
		left: 188px;
    	top: -11px;
	    border: 1px solid #f7f7f7;
	    background-color: #fff;
	    -webkit-box-shadow: 2px 0 5px rgba(0,0,0,.3);
	    box-shadow: 2px 0 5px rgba(0,0,0,.3);
	}
	.cate_item{
		width: 800px;
		height: 454px;
		padding: 20px 0 10px;
	}
</style>