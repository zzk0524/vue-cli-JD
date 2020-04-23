<template>
	<div>
		<header-bar>
			<header-bar-item>
				<div class="location">
					<div class="location_content">	
						<img src="~assets/img/location.png" alt="位置">
						<div>山东</div>
					</div>
					<div class="location_list divnone list_position" id="location_list">
						<div class="location_list_first">
							<div class="location_list_first_item" v-for="item in locationItems" :key="item">{{item}}</div>
						</div>
						<div class="location_line"><div>地区专享版本</div></div>
						<div class="location_list_second">
							<div class="location_list_second_item">中国港澳</div>
							<div class="location_list_second_item">中国台湾</div>
							<div class="location_list_second_item">淘淘全球</div>
						</div>
					</div>
				</div>
			</header-bar-item>
			<header-bar-item>
				<div id="moren" class="divnone">
					<router-link to="/login">
						<div>你好，请登录</div>
					</router-link>
				</div>
				<div id="denglu" class="downarrow" v-model="currentLog">
					<div class="denglu_content">
						<div>{{currentLog.account}}abc</div>
					</div>
					<div class="denglu_list divnone">
						<a href="">退出登录</a>
					</div>
				</div>
			</header-bar-item>
			<header-bar-item>
				<router-link to="/register" class="register">
					<div>免费注册</div>
				</router-link>	
			</header-bar-item>
			<header-bar-item>
				<div class="downarrow mine">
					<div class="mine_content">
						<div>我的淘淘</div>
						<img src="~assets/img/downarrow.png" alt="向下箭头">
					</div>
					<div class="mine_list divnone list_position" id="mine_list">
						<div class="mine_list_first">
							<div class="mine_list_first_item">待处理订单</div>
							<div class="mine_list_first_item">消息</div>
							<div class="mine_list_first_item">返修退换货</div>
							<div class="mine_list_first_item">我的回答</div>
							<div class="mine_list_first_item">降价商品</div>
							<div class="mine_list_first_item">我的关注</div>
						</div>
						<div class="mine_line"></div>
						<div class="mine_list_second">
							<div class="mine_list_second_item">我的淘豆</div>
							<div class="mine_list_second_item">我的优惠券</div>
							<div class="mine_list_second_item">我的白条</div>
							<div class="mine_list_second_item">我的理财</div>
						</div>
					</div>
				</div>
			</header-bar-item>
			<header-bar-item>
				<div>
						<div>淘淘会员</div>
				</div>
			</header-bar-item>
			<header-bar-item>
				<div class="downarrow favorite">
					<div class="favorite_content">
						<div>收藏夹</div>
						<img src="~assets/img/downarrow.png" alt="向下箭头">
					</div>	
					<div class="favorite_list list_position divnone" id="favorite_list">
						<div class="favorite_list_first">
							<div class="favorite_list_first_item">收藏的宝贝</div>
							<div class="favorite_list_first_item">收藏的店铺</div>
						</div>
					</div>
				</div>	
			</header-bar-item>
			<header-bar-item>
				<div class="downarrow service">
					<div class="service_content">
						<div>联系客服</div>
						<img src="~assets/img/downarrow.png" alt="向下箭头">
					</div>
					<div class="service_list list_position divnone" id="service_list">
						<div class="kehu">客户</div>
						<div class="service_list_first">
							<div class="service_list_first_item">帮助中心</div>
							<div class="service_list_first_item">售后服务</div>
							<div class="service_list_first_item">在线客服</div>
							<div class="service_list_first_item">意见建议</div>
							<div class="service_list_first_item">电话客服</div>
							<div class="service_list_first_item">客服邮箱</div>
							<div class="service_list_first_item">金融资讯</div>
							<div class="service_list_first_item">全球售客服</div>
						</div>
						<div class="service_line"></div>
						<div class="shanghu">商户</div>
						<div class="service_list_second">
							<div class="service_list_second_item">合作招商</div>
							<div class="service_list_second_item">成长中心</div>
							<div class="service_list_second_item">商家后台</div>
							<div class="service_list_second_item">京麦工作台</div>
							<div class="service_list_second_item">商家帮助</div>
							<div class="service_list_second_item">规则平台</div>
						</div>
					</div>
				</div>
			</header-bar-item>
			<header-bar-item>
				<div class="downarrow navigation">
					<div class="navigation_content">
						<div>网站导航</div>
						<img src="~assets/img/downarrow.png" alt="向下箭头">
					</div>
					<div class="navigation_list divnone list_position" id="navigation_list">
						<div class="navigation_list_content">
							<div class="tszt">特色主题</div>
							<div class="navigation_list_first">
								<div class="navigation_list_first_item" v-for="item in teztItems" :key="item">{{item}}</div>
							</div>
						</div>
						<div class="navigation_line"></div>
						<div class="navigation_list_content">
							<div class="hypd">行业频道</div>
							<div class="navigation_list_second">
								<div class="navigation_list_second_item" v-for="item in hypdItems" :key="item">{{item}}</div>
							</div>
						</div>
						<div class="navigation_line"></div>
						<div class="navigation_list_content">
							<div class="shfw">生活服务</div>
							<div class="navigation_list_third">
								<div class="navigation_list_third_item" v-for="item in shfwItems" :key="item">{{item}}</div>	
							</div>
						</div>
						<div class="navigation_line"></div>
						<div class="navigation_list_content">
							<div class="gdjx">更多精选</div>
							<div class="navigation_list_fourth">
								<div class="navigation_list_fourth_item" v-for="item in gdjxItems" :key="item">{{item}}</div>
							</div>
						</div>
					</div>		
				</div>
			</header-bar-item>
			<header-bar-item>
				<div class="phonett">
					<div class="phonett_content">
						<div>手机淘淘</div>
					</div>
					<div class="phonett_list list_position divnone" id="phonett_list">
						<div class="phonett_list_first">
							<div class="phonett_list_first_item">
								<img src="~assets/img/phonecode.png" alt="二维码">
							</div>
							<div class="phonett_list_first_item">
									<div>手机淘淘</div>
									<div>新人专享大礼包</div>
									<div><img src="~assets/img/iphone.png" alt="安卓苹果"></div>
							</div>
						</div>
						<div class="phonett_line"></div>
						<div class="phonett_list_second">
							<div class="phonett_list_second_item">
								<img src="~assets/img/phonecode2.png" alt="二维码2">
							</div>	
							<div class="phonett_list_second_item">
								<div>关注淘淘</div>
								<div>扫一扫关注参与宠粉大抽奖，限时抽爱奇艺视频月卡</div>	
							</div>	
						</div>
					</div>
				</div>
			</header-bar-item>
		</header-bar>
	</div>
</template>

<script>
	import HeaderBar from 'components/common/header/HeaderBar.vue'
	import HeaderBarItem from 'components/common/header/HeaderBarItem.vue'

	export default{
		name:"MainHeaderBar",
		components:{
			HeaderBar,
			HeaderBarItem
		},
		data(){
			return{
				locationItems:["北京","上海","天津","重庆","河北","山西","河南","辽宁","吉林","黑龙江","内蒙古","江苏","山东","安徽","浙江","福建","湖北","湖南","广东","广西","江西","四川","海南","贵州","云南","西藏","陕西","甘肃","青海","宁夏","新疆","港澳","台湾","钓鱼岛","海外"],
				teztItems:["新品首发","淘淘金融","全球售","国际站","淘淘会员","淘淘预售","台湾售","俄语站","装机大师","0元评测","港澳售","优惠券","秒杀","闪购","印尼站","淘淘金融科技","陪伴计划","出海招商","拍拍二手","买什么"],
				hypdItems:["手机","智能数码","玩3C","电脑办公","家用电器","鲸鱼智能","服装城","淘淘生鲜","家装城","母婴","食品","农资频道","整车","图书","劳动防护"],
				shfwItems:["淘淘众筹","白条","淘淘金融APP","淘淘小金库","理财","话费","水电煤","彩票","旅行","机票酒店","电影票","淘淘到家","游戏","拍拍回收","充值"],
				gdjxItems:["合作招商","淘淘通信","淘淘E卡","企业采购","服务市场","办公生活馆","乡村招募","校园加盟","淘淘社区","游戏社区","知识产权维权","论坛"],
				currentLog:[{id:'',account:'',sex:'',password:'',favourite:''}]
			}
		},
		methods:{
			bindheadmenu(ele,menu){
				 ele.addEventListener("mouseover",()=>{
					menu.classList.remove("divnone");
					menu.addEventListener("mouseover",()=>{
						menu.classList.remove("divnone");
						menu.addEventListener("mouseout",()=>{
							menu.classList.add("divnone");
						})
					})
					ele.addEventListener("mouseout",()=>{
						menu.classList.add("divnone");
					})
				 })
			},
			executebindheadmenu(){
				let locationcontent = document.getElementsByClassName("location_content")[0],
				    locationlist = document.getElementById("location_list"),
				    minecontent = document.getElementsByClassName("mine_content")[0],
				    minelist = document.getElementById("mine_list"),
				    favoritecontent = document.getElementsByClassName("favorite_content")[0],
				    favoritelist = document.getElementById("favorite_list"),
				    servicecontent = document.getElementsByClassName("service_content")[0],
				    servicelist = document.getElementById("service_list"),
				    navigationcontent = document.getElementsByClassName("navigation_content")[0],
				    navigationlist = document.getElementById("navigation_list"),
				    phonettcontent = document.getElementsByClassName("phonett_content")[0],
				    phonettlist = document.getElementById("phonett_list"),
				    denglucontent = document.getElementsByClassName("denglu_content")[0],
				    denglulist = document.getElementsByClassName("denglu_list")[0];
				this.bindheadmenu(locationcontent,locationlist);
				this.bindheadmenu(minecontent,minelist);
				this.bindheadmenu(favoritecontent,favoritelist);
				this.bindheadmenu(servicecontent,servicelist);
				this.bindheadmenu(navigationcontent,navigationlist);
				this.bindheadmenu(phonettcontent,phonettlist);
				this.bindheadmenu(denglucontent,denglulist);
			},
			displayUsername(){
				let moren = document.getElementById("moren"),
						denglu = document.getElementById("denglu");
				moren.classList.add("divnone");
				denglu.classList.remove("divnone");
			},
			morenUsername(){
				let moren = document.getElementById("moren"),
						denglu = document.getElementById("denglu");
				denglu.classList.add("divnone");
				moren.classList.remove("divnone");
			},
			getUserName(){
				const tempData = localStorage.getItem('tempData')
				if(tempData){
					this.currentLog = JSON.parse(tempData);
					this.displayUsername();
				}else{
					if(this.$route.params.user == null){
						this.morenUsername();
					}else{
						this.currentLog = this.$route.params.user;
					  localStorage.setItem('tempData', JSON.stringify(this.$route.params.user));
					  this.displayUsername();
					}
				} 
			}
		},
		mounted(){
			this.executebindheadmenu();
			this.getUserName();
		},
		beforeDestroy () {
    	localStorage.removeItem('tempData');
  	}
	}
</script>

<style scoped>
  /*添加类切换隐藏和显示*/
  .divnone{
  	display: none !important;
  }
  /*头部每一个条都设为相对定位*/
  .header-bar-item{
		position: relative;
  }
	/*第一个item*/
  .header-bar-item:first-of-type{
  	margin-left: 80px;
  	margin-right: 390px;
  }
  /*请登录*/
  .header-bar-item:nth-of-type(2) a{
		color: #999;
  }
  /*经过你好请登录和免费注册,鼠标经过变成小手和红色的字*/
  .header-bar-item:nth-of-type(2) a:hover,
  .header-bar-item:nth-of-type(5):hover,
  .header-bar-item:nth-of-type(3) a,
  .location_content:hover,
  .mine_content:hover,
  .location_list_second_item:hover,
  .mine_list_first_item:hover,
  .mine_list_second_item:hover,
  .favorite_content:hover,
  .favorite_list_first_item:hover,
  .location_list_first_item:hover,
  .service_content:hover,
  .service_list_first_item:hover,
  .service_list_second_item:hover,
  .navigation_content:hover,
  .navigation_list_first_item:hover,
  .navigation_list_second_item:hover,
  .navigation_list_third_item:hover,
  .navigation_list_fourth_item:hover,
  .phonett_content:hover,
  .denglu_content:hover{
  	cursor: pointer;
  	color: #e33333;
  }
  /*用户名显示*/
  .denglu_content{
  	width: 65px;
  }
  .denglu_content div{
  	overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
  }
  #denglu{
  	border: 1px solid transparent;
  }
  /*可以有子菜单框的那几个的背景色和边框*/
  .header-bar-item:first-of-type:hover,
  .header-bar-item:nth-of-type(4):hover,
  .header-bar-item:nth-of-type(6):hover,
  .header-bar-item:nth-of-type(7):hover,
  .header-bar-item:nth-of-type(8):hover,
  #denglu:hover{
  	background-color: #fff;
  	border:rgb(204,204,204) solid 1px;
  }
  /*定位位置*/
  .location{
  	height: 100%;
  	width: 60px;
  }
  /*位置图标*/
  .location img{
  	width: 15px;
  	height: 15px;
  	margin-right: 5px;
  }
  /*隐藏的子菜单定位*/
  .list_position,
  .mine_list,
  .favorite_list,
  .service_list,
  .navigation_list,
  .phonett_list,
  .denglu_list{
		position: absolute;
  	top: 29px;
  	left: -1px;
  	border:rgb(204,204,204) solid 1px;
		z-index: 3;
		background-color: #fff;
  }
  /*位置的子菜单*/
  .location_list{
		width: 322px;
		height: 323px;
  }
  /*遮住边框的白条*/
  .location_list:before,
  .mine_list:before,
  .favorite_list:before,
  .service_list:before,
  .navigation_list:before,
  .denglu_list:before{
  	display: block;
  	position: absolute;
  	top: -2px;
  	content: "";
  	width: 74px;
  	height: 2px;
  	background-color: #fff;
  }
  /*带有隐藏子菜单的设为flex布局*/
  .location_content,
  .mine_content,
  .favorite_content,
  .service_content,
  .navigation_content{
  	display: flex;
  	align-items: center;
  }
  /*定位中的第一部分flex布局*/
  .location_list_first{
  	display: flex;
  	justify-content: space-around;
  	flex-wrap: wrap;
  	color: #999;
  	margin-top: 10px;
  	margin-left: 5px;
  }
  /*定位中的第一部分中的子元素*/
  .location_list_first_item{
		width: 45px;
		height: 25px;
		margin-right: 11px;
		margin-bottom: 3px;
		text-align: left;
		padding-left: 9px;
  }
  /*红色山东*/
  .location_list_first_item:nth-of-type(13),
  .location_list_first_item:nth-of-type(13):hover{
		background-color: rgb(241,2,21);
		color: #fff;
  }
  /*鼠标经过*/
  .location_list_first_item:hover{
  	background-color: rgb(244,244,244);
  }
  /*location水平线*/
  .location_line{
  	width: 264px;
  	height: 30px;
  	border-top: 1px rgb(238,238,238) dotted;
  	margin-left: 22px;
  	margin-top: 10px;
  	padding-top: 10px;
  }
  /*地区专享版本*/
  .location_line div{
  	margin-left: -200px;
  }
  /*地区专享版本下面的内容*/
  .location_list_second{
  	margin-top: 14px;
  	display: flex;
  	flex-wrap: wrap;
  }
  /*中国港澳*/
  .location_list_second_item:nth-of-type(1){
  	margin-left: 17px;
  	margin-right: 114px;
		width: 50px;
  }
  /*中国台湾*/
  .location_list_second_item:nth-of-type(2){
		margin-right: 38px;
  }
  /*淘淘全球*/
  .location_list_second_item:nth-of-type(3){
  	margin-left: 18px;
  }
	/*我的淘淘*/
	.mine_list{
		width: 282px;
		height: 163px;
	}
	/*我的淘淘内容中遮盖边框的白条*/
	.mine_list:before{
		width: 79px;
	}
	/*我的淘淘第一块内容*/
  .mine_list_first{
		display: flex;
		flex-wrap: wrap;
		margin-left: 15px;
		margin-top: 10px;
  }
  /*我的淘淘隐藏子菜单中的定位*/
  .mine_list_first_item,
  .mine_list_second_item:nth-of-type(2){
		margin-right: 70px;
  }
  /*我的淘淘隐藏子菜单中的定位*/
  .mine_list_first_item:nth-of-type(5),
  .mine_list_second_item:nth-of-type(1),
  .mine_list_second_item:nth-of-type(3){
		margin-right: 82px;
  }
  /*我的淘淘隐藏子菜单中的定位*/
  .mine_list_first_item,
  .mine_list_second_item{
  	height: 25px;
  }
  /*我的淘淘中的水平线*/
	.mine_line{
		width: 250px;
		height: 2px;
		border-top: 1px rgb(238,238,238) dotted;
		margin-left: 15px;
		margin-top: 10px;
		margin-bottom: 5px;
	}
	/*我的淘淘第二块内容*/
  .mine_list_second{
		display: flex;
		flex-wrap: wrap;
		margin-left: 15px;
  }
  /*收藏夹*/
  .favorite_list{
		width: 100px;
		height: 66px;
  }
  /*收藏夹内容中遮盖边框的白条*/
  .favorite_list:before{
  	width: 67px;
  }
  /*用户名隐藏区*/
  .denglu_list{
		width: 90px;
		height: 35px;
		left: 7px;
  }
  /*白条*/
  .denglu_list:before{
		width: 63px;
  }
  /*联系客服*/
  .service_list{
		width: 172px;
		height: 246px;
		left: -92px;
  }
  /*联系客服的遮盖白条*/
  .service_list:before{
		left:91px;
		width:79px;
  }
  /*联系客服下的客户和商户*/
  .service_list .kehu,
  .service_list .shanghu{
		color: #000000;
		font-weight: 700;
		width: 30px;
		margin-left: 10px;
		height: 20px;
  }
  /*联系客服下的客户*/
  .service_list .kehu{
  	margin-top: 10px;
  }
  /*第一部分和第二部分flex布局*/
  .service_list_first,
  .service_list_second{
  	display: flex;
  	flex-wrap: wrap;
  	margin-left: 10px;
  }
  .service_list_first_item,
  .service_list_second_item{
  	height: 22px;
  }
  /*第一部分和第二部分布局*/
  .service_list_first_item:nth-child(odd),
  .service_list_second_item:nth-child(odd){
		margin-right: 35px;
  }
  /*联系客服分割线*/
  .service_line{
  	width: 170px;
		height: 2px;
		border-top: 1px rgb(238,238,238) dotted;
		margin-top: 10px;
		margin-bottom: 5px;
  }
  /*网站导航隐藏菜单大小*/
  .navigation_list{
  	width: 1190px;
  	height: 181px;
  	display: flex;
  	left: -1026px;
  	justify-content: space-around;
  }
  /*网页导航中的分割线*/
  .navigation_line{
  	width: 1px;
  	height: 150px;
		border-left: 1px rgb(238,238,238) dotted;
		margin-top: 15px;
	}
	/*每个块又flex布局*/
  .navigation_list_first,
  .navigation_list_second,
  .navigation_list_third,
  .navigation_list_fourth{
		display: flex;
		flex-wrap: wrap;
		margin-left: 10px;
  	justify-content: space-around;
  }
  /*给定第一部分的宽度*/
  .navigation_list_first{
  	width: 360px;
  }
  .navigation_list_second,
  .navigation_list_third,
  .navigation_list_fourth{
  	width: 261px;
  }
  /*网页导航中那几个标题*/
  .tszt,
	.hypd,
	.shfw,
	.gdjx{
		color: #000000;
		font-weight: 700;
		width: 60px;
		margin-top: 5px;
		margin-left: 5px;
	}
	/*遮盖边框的白条*/
	.navigation_list:before{
		left: 1025px;
		width: 79px;
	}
	/*每个最里面的子元素*/
	.navigation_list_first_item,
	.navigation_list_second_item,
	.navigation_list_third_item,
	.navigation_list_fourth_item{
		height: 25px;
		margin-right: 11px;
		text-align: left;
	}
	.navigation_list_first_item{
		width: 77px;
	}
	.navigation_list_second_item,
	.navigation_list_fourth_item{
		width: 73px;
	}
	.navigation_list_third_item{
		width: 73px;
	}
	/*手机淘淘的隐藏区*/
	.phonett_list{
		width: 192px;
		height: 229px;
		left: -115px;
	}
	/*小三角*/
	.phonett_list:before{
		display:block;
		position: absolute;
		content: "";
		border-left: 5px solid transparent;
		border-right: 5px solid transparent;
		border-bottom:5px #fff solid;
		top:-5px;
		left:140px;
	}
	.phonett_list_first,
	.phonett_list_second{
		display: flex;
		margin-top: 10px;
		margin-left: 5px;
	}
	/*两个二维码*/
	.phonett_list_first_item:nth-of-type(1),
	.phonett_list_second_item:nth-of-type(1){
		width: 76px;
		height: 76px;
		border:rgb(204,204,204) solid 1px;
	}
	/*两个二维码*/
	.phonett_list_first_item:nth-of-type(1) img,
	.phonett_list_second_item:nth-of-type(1) img{
		width: 70px;
		height: 70px;
		padding: 3px 2px 0px 2px;
	}
	/*手机淘淘*/
	.phonett_list_first_item:nth-of-type(2) div:nth-of-type(1),
	.phonett_list_second_item:nth-of-type(2) div:nth-of-type(1){
		text-align: left;
		margin-left: 5px;
		height: 25px;
		color: #000000;
		font-weight: 700;
	}
	/*新人专享大礼包*/
	.phonett_list_first_item:nth-of-type(2) div:nth-of-type(2){
		color: rgb(225,37,27);
		text-align: left;
		margin-left: 5px;
		height: 25px;
		cursor: pointer;
	}
	/*分割线*/
	.phonett_line{
		width: 190px;
  	height: 2px;
  	border-top: 1px rgb(231,231,231) solid;
  	margin-top: 7px;
  	padding-top: 10px;
	}
	/*第二个二维码右边的字*/
	.phonett_list_second_item:nth-of-type(2) div:nth-of-type(2){
		color: rgb(225,37,27);
		text-align: left;
		margin-left: 5px;
		height: 50px;
		line-height: 17px;
	}
	/*头部中所有向下的图标*/
	.downarrow img{
		width: 15px;
		height: 15px;
		margin-left: 2px
	}

</style>