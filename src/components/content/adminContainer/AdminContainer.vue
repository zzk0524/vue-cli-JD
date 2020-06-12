<template>
	<div class="admin_container">
		<div class="sidebar">
			<div class="menu">
				<div class="menu_item" data-index="1" path="/admin/userManagement">
					<div class="menu_name">用户管理</div>
					<div class="tr_radius divnone"></div>
					<div class="br_radius divnone"></div>
				</div>
				<div class="menu_item" data-index="2" path="/admin/goodManagement">
					<div class="menu_name">商品管理</div>
					<div class="tr_radius divnone"></div>
					<div class="br_radius divnone"></div>
				</div>
				<div class="menu_item" data-index="3" path="/admin/profile">
					<div class="menu_name">个人管理</div>
					<div class="tr_radius divnone"></div>
					<div class="br_radius divnone"></div>
				</div>
			</div>
		</div>
		<div class="right_body">
			<div class="frame">
				<router-view name="sidebar" />
			</div>
		</div>
	</div>
</template>
<script>
	export default{
		name:"AdminContainer",
		methods:{
 	  	loadHeight(){
	  		document.getElementsByClassName("admin_container")[0].style.height = (document.documentElement.clientHeight-70) + "px";
	  	},
	  	menuItemClick(){//侧边栏绑定事件
	  		let _this = this;
	  		let menuItem = document.getElementsByClassName("menu_item");
	  		Array.from(menuItem).forEach((currentValue,index,arr) => {
	  			currentValue.addEventListener("mouseover",() => {
	  				if(currentValue.getAttribute("data-index")=="1"){//如果划过的元素是第一个
	  					if(arr[index+1].getAttribute("class")=="menu_item menu_item_active"){//并且下一个是激活
	  						arr[index+1].childNodes[1].classList.remove("tr_radius");
	  						arr[index+1].childNodes[1].classList.add("tr_radius1");
	  					}
	  				}else if(currentValue.getAttribute("data-index")=="3"){//如果划过的元素是最后一个
	  					if(arr[index-1].getAttribute("class")=="menu_item menu_item_active"){//并且前一个是激活
	  						arr[index-1].childNodes[2].classList.remove("br_radius");
	  						arr[index-1].childNodes[2].classList.add("br_radius1");
	  					}
	  				}else{//如果划过的元素是中间的
	  					if(arr[index-1].getAttribute("class")=="menu_item menu_item_active"){//上一个为激活
	  						arr[index-1].childNodes[2].classList.remove("br_radius");
	  						arr[index-1].childNodes[2].classList.add("br_radius1");
	  					}
	  					if(arr[index+1].getAttribute("class")=="menu_item menu_item_active"){//并且下一个是激活
	  						arr[index+1].childNodes[1].classList.remove("tr_radius");
	  						arr[index+1].childNodes[1].classList.add("tr_radius1");
  						}
	  				}
	  				currentValue.classList.add("menu_item_hover");
	  				currentValue.addEventListener("mouseout",() => {
		  				if(currentValue.getAttribute("data-index")=="1"){//如果划过的元素是第一个
		  					if(arr[index+1].getAttribute("class")=="menu_item menu_item_active"){//并且下一个是激活
		  						arr[index+1].childNodes[1].classList.remove("tr_radius1");
		  						arr[index+1].childNodes[1].classList.add("tr_radius");
		  					}
		  				}else if(currentValue.getAttribute("data-index")=="3"){//如果划过的元素是最后一个
		  					if(arr[index-1].getAttribute("class")=="menu_item menu_item_active"){//并且前一个是激活
		  						arr[index-1].childNodes[2].classList.remove("br_radius1");
		  						arr[index-1].childNodes[2].classList.add("br_radius");
		  					}
		  				}else{//如果划过的元素是中间的
		  					if(arr[index-1].getAttribute("class")=="menu_item menu_item_active"){//上一个为激活
		  						arr[index-1].childNodes[2].classList.remove("br_radius1");
		  						arr[index-1].childNodes[2].classList.add("br_radius");
		  					}
		  					if(arr[index+1].getAttribute("class")=="menu_item menu_item_active"){//并且下一个是激活
		  						arr[index+1].childNodes[1].classList.remove("tr_radius1");
		  						arr[index+1].childNodes[1].classList.add("tr_radius");
	  						}
		  				}
	  					currentValue.classList.remove("menu_item_hover");
	  				})
	  			})
	  		})
	  		Array.from(menuItem).forEach((currentValue,index,arr) => {
	  			currentValue.addEventListener("click",() => {
	  				arr.map(x => {
	  					x.classList.remove("menu_item_active");
	  					x.childNodes[1].setAttribute("class","tr_radius");//还原
	  					x.childNodes[2].setAttribute("class","br_radius");
	  					x.getElementsByClassName("tr_radius")[0].classList.add("divnone");//隐藏
							x.getElementsByClassName("br_radius")[0].classList.add("divnone");
	  				})
	  				currentValue.classList.add("menu_item_active");
	  				currentValue.getElementsByClassName("tr_radius")[0].classList.remove("divnone");
	  				currentValue.getElementsByClassName("br_radius")[0].classList.remove("divnone");
	  				let path = currentValue.getAttribute("path");
						_this.$router.replace(path);
	  			})
	  		})
	  	},
	  	getRouter(){
	  		let menuItem = document.getElementsByClassName("menu_item");
	  		Array.from(menuItem).forEach((currentValue) => {
	  			if(currentValue.getAttribute("path")==window.location.pathname){
	  				currentValue.classList.add("menu_item_active");
	  				currentValue.childNodes[1].classList.remove("divnone");
	  				currentValue.childNodes[2].classList.remove("divnone");
	  			}
	  		})
	  	}
 	  },
 	  mounted(){
 	  	this.loadHeight();
 	  	this.menuItemClick();
 	  	this.getRouter();
 	  }
	}
</script>
<style scoped>
	.divnone{
		display: none !important;
	}
	/*主要内容*/
	.admin_container{
		width: 100%;
		display: flex;
	}
	/*侧边栏*/
	.sidebar{
		width:120px;
		height: 100%;
		background-color: #252423;
		z-index: 2; 
	}
	.menu{
		margin-top: 40px;
	}
	/*侧边栏*/
	.menu_item{
		position: relative;
    padding: 16px 0 16px 27px;
    cursor: pointer;
    color: #999;
	}
	/*鼠标滑过变黑底白字*/
	.menu_item_hover{
		background-color: #040403;
		color: #fff; 
	}
	.menu_item_active{
		position: relative;
		padding: 16px 0 16px 27px;
    cursor: pointer;
		background-color: #fff;
		color: #e33333;
	}
	/*侧边栏文字大小*/
	.menu_name{
		font-size: 13px;
	}
	/*上弧度*/
	.tr_radius{
		display: inline-block;
		width: 10px;
    height: 10px;
    background-color: #fff;
    position: absolute;
    top: -10px;
    right: 0;
    z-index: 3;
	}
	.tr_radius::before {
    content: "";
    display: inline-block;
    width: 10px;
    height: 10px;
    background: #252423;
    position: absolute;
    left: 0;
    top: 0;
    border-radius: 0 0 5px 0;
	}
	.tr_radius1{
		display: inline-block;
		width: 10px;
    height: 10px;
    background-color: #fff;
    position: absolute;
    top: -10px;
    right: 0;
    z-index: 3;
	}
	.tr_radius1::before {
    content: "";
    display: inline-block;
    width: 10px;
    height: 10px;
    background: #040403;
    position: absolute;
    left: 0;
    top: 0;
    border-radius: 0 0 5px 0;
	}
	.br_radius {
    display: inline-block;
    width: 10px;
    height: 10px;
    background-color: #fff;
    position: absolute;
    bottom: -10px;
    right: 0;
    z-index: 3;
	}
	.br_radius::after {
    content: "";
    display: inline-block;
    width: 10px;
    height: 10px;
    background: #252423;
    position: absolute;
    left: 0;
    top: 0;
    border-radius: 0 5px 0 0;
	}
	.br_radius1 {
    display: inline-block;
    width: 10px;
    height: 10px;
    background-color: #fff;
    position: absolute;
    bottom: -10px;
    right: 0;
    z-index: 3;
	}
	.br_radius1::after {
    content: "";
    display: inline-block;
    width: 10px;
    height: 10px;
    background: #040403;
    position: absolute;
    left: 0;
    top: 0;
    border-radius: 0 5px 0 0;
	}
	/*右侧显示*/
	.right_body{
		width: 80%;
		margin: 10px auto;
		height: 90%;
	}
	.frame{
		width: 100%;
		height: 100%;
	}
</style>
