<template>
	<div>
		<div class="crumb_wrap">
			<div class="crumb_container">
				<div class="crumb clearfix">
					<div class="item">
						<a href="javascript:void(0)">全部分类</a>
					</div>
					<div class="item sep">></div>
					<div class="item">
						<a href="javascript:void(0)">{{currentGood.type}}</a>
					</div>
				</div>
				<div class="contact clearfix">
					<div class="goodshop">
						<em class="u_jd">自营</em>
					</div>	
					<div class="J_hove_wrap">
						<div class="item">
							<div class="name">
								<a href="javascript:void(0)">{{currentGood.shopname}}</a>
							</div>
						</div>
						<div class="item">
							<div class="customer_service">
								<i class="sprite_im"></i>
								联系客服
							</div>
						</div>
						<div class="item">
							<div class="follow">
								<i class="sprite_follow"></i>
								<span>关注店铺</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="crumb_body">
			<div class="product_intro clearfix">
				<div class="preview_wrap">
					<div class="preview">
						<div class="main_img">
							<img :src="currentGood.pic" :alt="currentGood.title">
						</div>
						<div class="preview_info">
							<div class="left_btns">
								<a href="javascript:void(0)" class="follow">
									<i class="sprite_follow_sku"></i>
									<em>关注</em>
								</a>
								<a href="javascript:void(0)" class="share">
									<i class="sprite_share"></i>
									<em>分享</em>
								</a>
							</div>
							<div class="right_btns">
								<a href="javascript:void(0)" class="report_btn">举报</a>
							</div>
						</div>
					</div>
				</div>
				<div class="itemInfo_wrap">
					<div class="sku_name">{{currentGood.title}}</div>
					<div class="news">
						<div class="p_ad">
							5.05-5.07五一美好生活#领券叠加立减可得【10元无门槛，200-20、300-50、468-130】
							<a href="javascript:void(0)">#点击</a>
						</div>
					</div>
					<div class="summary_first">
						<div class="summary_price_wrap">
							<div class="J_summary_price">
								<div class="dt">淘淘价</div>
								<div class="dd">
									<span class="p_price">
										<span>￥</span>
										<span class="price">{{currentGood.price}}</span>
									</span>
									<a href="javascript:void(0)" class="fans_price">降价通知</a>
								</div>
							</div>
							<div class="J_summary_info clearfix">
								<div class="comment_count">
									<p class="comment">累计评价</p>
									<a href="javascript:void(0)" class="J_comm">{{currentGood.comments}}</a>
								</div>
							</div>
							<div class="summary_quan">
								<div class="dt">优惠券</div>
								<div class="dd">
									<dl>
										<dt class="fl"></dt>
										<dd class="lh">
											<a href="javascript:void(0)" class="J_opentb">
												<span class="quan_item">
													<s></s>
													<b></b>
													<span class="text">满100减10</span>
												</span>
												<span class="quan_item">
													<s></s>
													<b></b>
													<span class="text">满300减50</span>
												</span>
												<span class="quan_item">
													<s></s>
													<b></b>
													<span class="text">满500减80</span>
												</span>
												<span class="more_btn">更多>></span>
											</a>
										</dd>
									</dl>
								</div>
							</div>
							<div class="J_summary_top">
								<div class="summary_promotion">
									<div class="dt">促销</div>
									<div class="dd">
										<div class="p_promotions">
											<div class="J_prom">
												<div class="prom_item">
													<em class="hl_red_bg">限购</em>
													<em class="hl_red">该商品购买1-20件时享受单件价￥109.00，超出数量以结算价为准</em>
												</div>
											</div>
											<div class="J_prom">
												<div class="prom_item">
													<em class="hl_red_bg">满减</em>
													<em class="hl_red">满200元减10元，满300元减20元，满400元减30元</em>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="p_choose_wrap">
						<div class="summary_stock">
							<div class="dt">配送至</div>
							<div class="dd">
								<div class="store clearfix">
									<div class="stock_address">
										<div class="ui_area_text_wrap">
											<div class="ui_area_text">山东济宁市曲阜市时庄街道</div>
											<b></b>
										</div>
									</div>
									<div class="store_prompt">
										<strong>可配货</strong>
									</div>
								</div>
							</div>
						</div>
						<div class="summary_supply">
							<div class="dt">&nbsp;&nbsp;&nbsp;&nbsp;</div>
							<div class="dd">
								<div class="summary_service">
									由
									<span class="hl_red">淘淘</span>
									发货, 并提供售后服务. 有货（外地跨区调货）,暂免调货服务费. 20:00前下单
								</div>
							</div>
						</div>
						<div class="SelfAssuredPurchase">
							<div class="dt">服务支持</div>
							<div class="dd">
								<div class="icon_SelfAssuredPurchase"></div>
								<div class="services">
									<div>
										<a href="javascript:void(0)">闪电退款</a>
									</div>
								</div>
								<div class="promises">
									<a href="javascript:void(0)">隔日达</a>
									<a href="javascript:void(0)">自提</a>
									<a href="javascript:void(0)">99元免基础运费(10kg内)</a>
								</div>
							</div>
						</div>
						<div class="summary_line"></div>
						<div class="choose_btns clearfix">
							<div class="choose_amount">
								<div class="wrap_input">
									<input type="text" class="buy_num" value="1" id="buy_num" @blur="buyNumBlur($event)" v-model="buyNum">
									<a href="javascript:void(0)" class="btn_reduce disabled" id="btn_reduce" @click="reduceBtn">-</a>
									<a href="javascript:void(0)" class="btn_add" id="btn_add" @click="addBtn">+</a>
								</div>
							</div> 
							<a href="javascript:void(0)" class="btn_special1" id="InitCartUrl" @click="addShopCar">加入购物车</a>
						</div>
						<div class="summary_tips">
							<div class="dt">温馨提示</div>
							<div class="dd">
								<ol class="tips_list clearfix">
									<li class="local_txt">·支持7天无理由退货</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>
<script>
	export default{
		name:"DetailBody",
		data(){
			return{
				currentGood:[],
				currentUser:[],
				buyNum:1,
				form:{
					accountid:'',
					goodid:'',
					goodtitle:'',
					goodprice:'',
					goodpic:'',
					shopname:'',
					goodnum:'',
					goodsumprice:''
				}
			}
		},
		methods:{
			loadMinWith(){
	  		document.getElementsByClassName("crumb_wrap")[0].style.minWidth = (window.screen.width-17)+"px";
	  	},
			getApplyParams(){
				this.currentGood = JSON.parse(window.localStorage.getItem('applyParams'));//存入商品数据
				this.currentUser = JSON.parse(window.localStorage.getItem('tempDate'));
				window.localStorage.removeItem("applyParams");
				window.localStorage.removeItem("tempDate");
				// console.log(window.localStorage.getItem('applyParams'));
				// console.log(window.localStorage.getItem('tempData'));
				 // console.log(this.currentGood);
				 // console.log(this.currentUser);
				//用完就清空，只在页面切换之间使用
			},
			reduceBtn(){
				let buynum = document.getElementById("buy_num");
				let btnadd = document.getElementById("btn_add");
				let btnreduce = document.getElementById("btn_reduce");
				if(buynum.value>=2){
					buynum.value--;
					btnadd.classList.remove("disabled");
					if(buynum.value==1){
						btnreduce.classList.add("disabled");
					}	
				}	
			},
			addBtn(){
				let buynum = document.getElementById("buy_num");
				let btnadd = document.getElementById("btn_add");
				let btnreduce = document.getElementById("btn_reduce");
				if(buynum.value<200){
					btnreduce.classList.remove("disabled");
					buynum.value++;
					if(buynum.value==200){
						btnadd.classList.add("disabled");
					}
				}
			},
			buyNumBlur($event){
				let btnreduce = document.getElementById("btn_reduce");
				let btnadd = document.getElementById("btn_add");
				if($event.target.value <= 1){
					$event.target.value = 1;
					btnreduce.classList.add("disabled");
				}else if($event.target.value >= 200){
					$event.target.value = 200;
					btnadd.classList.add("disabled");
				}else{
					btnadd.classList.remove("disabled");
					btnreduce.classList.remove("disabled");
				}
			},
			addShopCar(){//点击加入购物车
				//判断有没有用户登录，没有转到登录页，有直接转购物车，用路由在当前页变化
				if(this.currentUser){//有用户先存数据库去到购物车中,传值商品信息和数量
					//更新数据请求
					let _this = this;
					let oAjax = null;
					let buynum = document.getElementById("buy_num");
					_this.form.accountid = _this.currentUser.id;
					_this.form.goodid = _this.currentGood.id;
					_this.form.goodtitle = _this.currentGood.title;
					_this.form.goodprice = _this.currentGood.price;
					_this.form.goodpic = _this.currentGood.pic;
					_this.form.shopname = _this.currentGood.shopname;
					_this.form.goodnum = buynum.value;
					_this.form.goodsumprice = (_this.currentGood.price*buynum.value).toFixed(2);
					console.log(_this.form);
					console.log(JSON.stringify(_this.form));
					if(window.XMLHttpRequest){
						oAjax = new XMLHttpRequest();
					}else{
						oAjax = new ActiveXObject("Microsoft.XMLHTTP");
					}
					oAjax.open('POST','http://127.0.0.1/goods/addCart',true);
					oAjax.setRequestHeader("Content-type","application/json");
					oAjax.send(JSON.stringify(_this.form));//创建一个form，把数据都存好一起发出去
					oAjax.onreadystatechange=function(){
					  if(oAjax.readyState==4){
					    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
					      //对响应进行解析
					      let goodscart=JSON.parse(oAjax.responseText);
					      if(goodscart.code == 1){
					      	 _this.$router.replace({name:'Cart',params:{goodscart:_this.form}});
					      } 
					    }else{
					      //对响应进行解析
					      alert("服务器错误");
					    }
					  }
					}
				}else{//没用户
					this.$router.replace({name:'Login'});
				}
			}
		},
		mounted(){
			this.loadMinWith();
			this.getApplyParams();
		}
	}
</script>
<style scoped>
	.crumb_wrap .item a:hover,
	.customer_service:hover,
	.follow span:hover,
	.follow em:hover,
	.share em:hover,
	.report_btn:hover,
	.promises a:hover{
		color: #e4393c;
	}
	/*头部灰色条*/
	.crumb_wrap{
		height: 40px;
		background: #f2f2f2;
	}
	/*居中*/
	.crumb_container{
		width: 1210px;
		margin: 0 auto;
	}
	/*左浮*/
	.crumb {
    padding: 13px 0 9px;
    float: left;
	}
	.clearfix:after {
    content: ".";
    display: block;
    height: 0;
    clear: both;
    visibility: hidden;
	}
	/*右浮*/
	.contact {
    padding: 13px 0 0;
    float: right;
	}
	/*每个小块*/
	.crumb .item{
		float: left;
	}
	.crumb .item>a{
		color: #666;
    text-decoration: none;
    font-size: 12px;
	}
	/*>号*/
	.sep{
		font-family: simsun;
    padding: 0 10px;
	}
	/*右浮的商店名*/
	.goodshop{
		float: left;
    margin-right: 10px;
    cursor: pointer;
	}
	/*自营红底白字*/
	.contact .goodshop .u_jd {
    display: inline-block;
    height: 16px;
    padding: 1px;
    line-height: 15px;
    font-family: arial,simsun;
    color: #fff;
    background: #e4393c;
    margin-left: 6px;
    cursor: pointer;
    font-size: 13px;
    font-style: normal;
	}
	/*店铺名字联系客服关注店铺*/
	.J_hove_wrap{
		float: right;
	}
	.J_hove_wrap .item{
		float: left;
	}
	/*店铺名*/
	.J_hove_wrap .name {
    float: left;
    margin-right: 10px;
	}
	.J_hove_wrap .name a{
		color: #666;
    text-decoration: none;
    font-size: 12px;
	}
	/*联系客服图标*/
	.sprite_im{
		display: inline-block;
		width: 16px;
		height: 16px;
		background: url(~assets/img/customer-service.png);
    background-position: -34px -16px;
    vertical-align: text-top;
    margin-right: 5px;
    font-style: normal;
  }
	.customer_service,
	.contact .follow{
		float: left;
		font-size: 12px;
		margin-right: 10px;
		cursor: pointer;
	}
	/*关注店铺*/
	.sprite_follow {
		position: relative;
    top: -1px;
		display: inline-block;
    width: 16px;
    height: 16px;
		background-image: url(~assets/img/customer-service.png);
		background-position: -34px 0;
		vertical-align: middle;
    margin-right: 5px;	
    font-style: normal;
	}
	.crumb_body{
		width: 1160px;
    margin: 0 auto;
	}
	/*主要内容部分*/
	.product_intro {
    margin-top: 10px;
    margin-bottom: 10px;
    margin-left: 50px;
	}
	/*商品图片区*/
	.preview_wrap{
		width: 352px;
		float: left;
    padding-bottom: 15px;
	}
	/*图片*/
	.main_img{
		border: 1px solid #eee;
    margin-bottom: 20px;
	}
	.main_img img{
		width: 100%;
		height: 100%;
	}
	/*图片下面的分享*/
	.preview_info {
    height: 20px;
  }
	.left_btns {
    float: left;
	}
	.left_btns a {
    cursor: pointer;
    margin-right: 2px;
    color: #666;
    text-decoration: none;
	}
	.sprite_follow_sku,
	.sprite_share{
		display: inline-block;
		background-image: url(~assets/img/customer-service1.png);
		vertical-align: middle;
    margin-right: 5px;
    font-style: normal;
	}
	/*关注图标*/
  .sprite_follow_sku {
    width: 14px;
    height: 13px;
    background-position: -44px -40px;
	}
	.left_btns .follow em,
	.left_btns .share em{
		font-style: normal;
		font-size: 12px;
	}
	/*分享*/
	.sprite_share{
		width: 15px;
    height: 14px;
    background-position: -45px -24px;
	}
	/*举报*/
	.right_btns{
		float: right;
	}
	.right_btns>a{
		font-size: 12px;
	}
	/*右侧商品详情*/
	.itemInfo_wrap{
		width: 658px;
    float: left;
    margin-left: 50px;
	}
	/*商品title区*/
	.sku_name{
		font: 700 16px Arial,"microsoft yahei";
    color: #666;
    padding-top: 10px;
    line-height: 28px;
    margin-bottom: 5px;
	}
	/*搞活动news*/
	.news{
		color: #e4393c;
    margin-bottom: 5px;
	}
	/*前一段文字*/
	.p_ad{
		width: 590px;
    white-space: normal;
    margin-bottom: 5px;
		line-height: 1.5em;
		font-size: 12px;
	}
	/*点击*/
	.p_ad>a{
		text-decoration: underline;
		color: #5e69ad;
	}
	/*价格促销*/
	.summary_first{
		padding-bottom: 5px;
	}
	/*内容盒子*/
	.summary_price_wrap{
		position: relative;
		padding: 10px 0 0;
    background: #f3f3f3;
	}
	/*价格区域*/
	.J_summary_price{
		margin-bottom: 5px;
	}
	/*淘淘价*/
	.J_summary_price .dt{
		line-height: 34px;
		float: left;
    padding-left: 10px;
    color: #999;
    font-size: 12px;
    letter-spacing: 5px;
    font-family: simsun;
	}
	/*淘淘价右侧区域*/
	.J_summary_price .dd{
		margin-left: 70px;
	}
	.p_price{
		color: #e4393c;
    font-family: "microsoft yahei";
    margin-right: 10px;
    overflow: hidden;
	}
	.p_price span {
    font-size: 16px;
    color: #e4393c;
	}
	.price {
		font-size: 22px !important;
	} 
	/*降价通知*/
	.fans_price{
		color: #005aa0;
    vertical-align: 2px;
    text-decoration: none;
    font-size: 12px;
	}
	/*评论数*/
	.J_summary_info{
		position: absolute;
    z-index: 1;
    right: 10px;
    top: 8px;
    color: #999;
	}
	.comment_count{
		border-left: solid 1px #e6e6e6;
    text-align: center;
    padding: 0 10px;
    line-height: 15px;
    float: left;
    color: #999;
	}
	/*累计评价*/
	.comment{
		font-size: 12px;
	}
	/*评价数*/
	.J_comm{
		font: 14px verdana;
    color: #005ea7;
    margin-left: 5px;
    text-decoration: none;
	}
	/*优惠券区域*/
	.summary_quan{
		padding-bottom: 2px;
		margin-bottom: 3px;
    line-height: 32px;
    height: 34px;
	}
	/*优惠券*/
	.summary_quan .dt{
		float: left;
    padding-left: 10px;
    color: #999;
    line-height: 32px;
    font-size: 12px;
    letter-spacing: 5px;
    font-family: simsun;
	}
	/*优惠券右侧区域*/
	.summary_quan .dd{
		padding-top: 8px;
		margin-left: 70px;
	}
	.summary_quan .dd dl .fl{
		float: left;
	}
	.quan_item{
		position: relative;
    float: left;
    height: 18px;
    padding-left: 2px;
    line-height: 15px;
    text-align: center;
    border-top: 1px solid #df3033;
    border-bottom: 1px solid #df3033;
    background: #ffdedf;
    font-size: 14px;
    white-space: nowrap;
    margin-right: 13px;
    cursor: pointer;
	}
	/*波浪线*/
	.quan_item s{
		position: absolute;
    top: -1px;
    display: block;
    height: 18px;
    width: 2px;
    overflow: hidden;
    background: url(~assets/img/quan-arr.gif) no-repeat;
    left: 0;
    background-position: -2px 0;
	}
	/*波浪线*/
	.quan_item b{
		position: absolute;
    top: -1px;
    display: block;
    height: 18px;
    width: 2px;
    overflow: hidden;
    background: url(~assets/img/quan-arr.gif) no-repeat;
    right: -2px;
	}
	/*满减文字*/
	.quan_item .text{
		padding: 0 10px;
    color: #df3033;
    font-size: 12px;	
	}
	/*更多*/
	.summary_quan .more_btn {
    font-family: SimSun;
    font-size: 12px;
    color: #999;
    float: left;
    height: 16px;
    line-height: 18px;
    cursor: pointer;
	}
	/*促销区域*/
	.summary_promotion{
		padding-bottom: 5px;
	}
	/*促销*/
	.summary_promotion .dt{
		line-height: 30px;
		float: left;
    padding-left: 10px;
    font-family: simsun;
    color: #999;
    font-size: 12px;
    letter-spacing: 18px;
	}
	/*促销右侧*/
	.summary_promotion .dd{
		position: relative;
		margin-left: 70px;
	}
	.p_promotions{
		position: relative;
    line-height: 30px;
    padding-right: 90px;
	}
	/*限购*/
	.hl_red_bg{
		color: #df3033;
    background: 0 0;
    border: 1px solid #df3033;
    padding: 2px 3px;
    margin-right: 5px;
    display: inline-block;
    line-height: 16px;
    font-style: normal;
    font-size: 12px;
	}
	/*限购内容*/
	.hl_red{
		color: #666;
    line-height: 18px;
		font-style: normal;
		font-size: 12px;
	}
	/*配送模块*/
	.p_choose_wrap{
		padding-bottom: 5px;
	}
	/*配送*/
	.summary_stock .dt{
		float: left;
    padding-left: 10px;
    font-family: simsun;
    color: #999;
    font-size: 12px;
    letter-spacing: 5px;
	}
	/*配送右侧*/
	.summary_stock .dd{
		margin-left: 70px;
	}
	.summary_stock .store {
    margin-bottom: 5px;
	}
	/*地址*/
	.stock_address {
    float: left;
    margin-top: -3px;
    margin-left: -5px;
	}
	.ui_area_text_wrap{
		float: left;
    position: relative;
    top: 0;
    height: 23px;
    background: #fff;
    border: 1px solid #CECBCE;
    padding: 0 24px 0 4px;
    line-height: 23px;
    overflow: hidden;
	}
	.ui_area_text{
		font-size: 12px;
	}
	/*向下小箭头*/
	.ui_area_text_wrap b{
		display: block;
    position: absolute;
    top: 3px;
    right: 4px;
    width: 17px;
    height: 17px;
    background: url(~assets/img/ui_area_text_wrap.png) no-repeat 3px 5px;
    overflow: hidden;
	}
	/*可配货*/
	.store_prompt {
		margin-left: 10px;
    margin-right: 10px;
    color: #999;
    height: 24px;
    float: left;
	}
	.store_prompt strong {
    margin-right: 5px;
    float: left;
    font-size: 12px;
	}	
	/*由淘淘发货*/
	.summary_supply {
    clear: both;
    margin-top: -10px;
    margin-bottom: 3px;
    line-height: 32px;
	}
	.summary_supply .dt{
		float: left;
    padding-left: 10px;
    font-family: simsun;
    color: #999;
	}
	.summary_supply .dd{
		margin-left: 70px;
	}
	.summary_service {
    color: #999;
    font-size: 12px;
	}
	.summary_service .hl_red {
    color: #e4393c;
	}
	/*服务支持*/
	.SelfAssuredPurchase{
		font-family: "Microsoft YaHei";
		margin-bottom: 3px;
    line-height: 32px;
	}
	.SelfAssuredPurchase .dt{
		float: left;
    padding-left: 10px;
    font-family: simsun;
    color: #999;
    font-size: 12px;
	}
	.SelfAssuredPurchase .dd{
		margin-left: 70px;
	}
	/*放心购图标*/
	.icon_SelfAssuredPurchase {
		position: relative;
    top: -3px;
    vertical-align: middle;
    display: inline-block;
    width: 84px;
    height: 16px;
    background-image: url(~assets/img/fangxingou.png);
    background-position: 0 -16px;
    cursor: pointer;
	}
	/*闪电退款*/
	.services {
    overflow: hidden;
    position: relative;
    display: inline-block;
    height: 20px;
    line-height: 20px;
    padding: 0 10px;
    background-color: #fff;
    font-size: 12px;
    top: -3px;
    vertical-align: middle;
	}
	.services a{
    color: #646fb0;
    font-size: 12px;
    word-break: keep-all;
	}
	/*次日达*/
	.promises {
    line-height: 18px;
    margin-top: -3px;
    margin-bottom: 3px;
	}
	.promises a {
    margin-right: 5px;
    color: #999;
    font-size: 12px;
    word-break: keep-all;
	}
	/*分割线*/
	.summary_line{
		height: 0;
    overflow: hidden;
    border-bottom: 1px dotted #dfdfdf;
    margin-bottom: 15px;
	}
	/*选择数量的区域*/
	.choose_btns{
		margin-top: 10px;
    margin-bottom: 20px;
    padding: 0 10px;
	}
	.choose_amount{
		width: 58px;
    height: 44px;
    overflow: hidden;
    border: 1px solid #ccc;
    position: relative;
    margin-right: 10px;
    float: left;
	} 
	/*数量输入*/
	.choose_amount .buy_num{
		display: block;
    width: 43px;
    height: 42px;
    line-height: 42px;
    position: absolute;
    top: 1px;
    left: 0;
    border: 0;
    text-align: center;
	}
	.choose_amount a {
    display: block;
    width: 15px;
    text-align: center;
    height: 23px;
    line-height: 22px;
    overflow: hidden;
    background: #f1f1f1;
    color: #666;
    position: absolute;
    right: -1px;
    border: 1px solid #ccc;
	}
	/*减号*/
	.btn_reduce{
		bottom: -1px;
		outline: none;
	}
	/*数量为1时减号的样式*/
	.choose_amount a.disabled {
    color: #ccc;
    cursor: not-allowed;
	}
	/*加号*/
	.btn_add {
    top: -1px;
    outline: none;
	}
	/*加入购物车*/
	.btn_special1{
		margin-right: 10px;
    float: left;	
    height: 46px;
    line-height: 46px;
    padding: 0 26px;
    font-size: 18px;
    font-family: "microsoft yahei";
    font-weight: 700;
    background-color: #df3033;
    color: #fff;
    display: inline-block;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
	}
	/*温馨提示*/
	.summary_tips{
		margin-bottom: 5px;
	}
	.summary_tips .dt{
		float: left;
    padding-left: 10px;
    font-family: simsun;
    color: #999;
    font-size: 12px;
	}
	.summary_tips .dd{
		margin-left: 70px;
	}
	.tips_list{
		list-style: none;
	}
	.local_txt{
		float: left;
    margin-right: 15px;
    font-family: simsun;
    color: #999;
    font-size: 12px;
	}
</style>