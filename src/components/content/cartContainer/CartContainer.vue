<template>
	<div class="cart">
		<div class="w">
			<div class="cart_filter_bar">
				<ul class="switch_cart">
					<li class="switch_cart_item">
						<a href="Javascript:void(0)">
							<em>全部商品</em>
							<span class="number" id="number">{{goodsnum}}</span>
						</a>
					</li>
				</ul>
				<div class="cart_store">
					<span class="label">配送至：</span>
					<div class="ui_area_wrap">
						<div class="ui_area_text_wrap">
							<div class="ui_area_text">山东济宁市曲阜市时庄街道</div>
							<b></b>
						</div>
					</div>
				</div>
				<div class="clr"></div>
				<div class="w_line">
					<div class="floater"></div>
				</div>
			</div>
		</div>
		<div class="cart_warp">
			<div class="w">
				<div class="jd_cart">
					<div class="cart_main">
						<div class="cart_thead">
							<div class="column t_checkbox">
								<div class="cart_checkbox">
									<input type="checkbox" class="jdcheckbox" id="maincheckbox" @click="mainCheckBox($event)">
								</div>全选
							</div>
							<div class="column t_goods">商品</div>
							<div class="column t_props"></div>
							<div class="column t_price">单价</div>
							<div class="column t_quantity">数量</div>
							<div class="column t_sum">小计</div>
							<div class="column t_action">操作</div>
						</div>
						<div class="cart_list">
							<div class="cart_item_list" v-for="(item,index) in cartgoods">
								<div class="cart_tbody">
									<div class="item_list">
										<div class="item_full">
											<div class="item_header">
												<div class="f_txt">
													<span>{{item.shopname}}</span>
												</div>
											</div>
											<div class="item_item">
												<div class="item_form">
													<div class="cell p_checkbox">
														<div class="cart_checkbox">
															<input type="checkbox" class="jdcheckbox singlejdcheckbox" :data-index="getindex(index)" :id="getcheckboxId(index)" @click="singleCheckbox($event)">
														</div>
													</div>
													<div class="cell p_goods">
														<div class="goods_item">
															<div class="p_img">
																<a href="javascript:void(0)">
																	<img :src="item.goodpic" :alt="item.goodtitle">
																</a>
															</div>
															<div class="item_msg">
																<div class="p_name">
																	<a href="javascript:void(0)">{{item.goodtitle}}</a>
																</div>
															</div>
														</div>
													</div>
													<div class="cell p_price">
														<p class="plus_switch">
															<strong>￥<span :id="priceId(index)" :data-index="getindex(index)">{{item.goodprice}}</span></strong>
														</p>
													</div>
													<div class="cell p_quantity">
														<div class="quantity_form">
															<a href="javascript:void(0)" class="decrement disabled" :id="decrementId(index)" @click="decrementClick($event)" :data-index="getindex(index)">-</a>
															<input type="text" class="itxt" :value="item.goodnum" @blur="numBlur($event)" :id="numId(index)" :data-index="getindex(index)" @focus="numFocus($event)">
															<a href="javascript:void(0)" class="increment" :id="incrementId(index)" @click="incrementClick($event)" :data-index="getindex(index)">+</a>
														</div>
													</div>
													<div class="cell p_sum">
														<strong>￥<span :id="pricesumId(index)" :data-index="getindex(index)">{{item.goodsumprice}}</span></strong>
													</div>
													<div class="cell p_ops">
														<a href="javascript:void(0)" class="cart_remove" @click="deleteClick($event)" :data-index="getindex(index)" :id="removeId(index)">删除</a>
													</div>
												</div>
												<div class="item_extra"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div v-show="empty" class="goodsempty">空空如也~</div>
						</div>
					</div>
				</div>
				<div class="cart_floatbar" id="cart_floatbar">
					<div class="ui_ceilinglamp">
						<div class="cart_toolbar" id="cart_toolbar">
							<div class="toolbar_wrap">
								<div class="options_box">
									<div class="select_all">
										<div class="cart_checkbox">
											<input type="checkbox" class="jdcheckbox" @click="mainCheckBox($event)" id="maincheckbox1">
										</div>全选
									</div>
									<div class="operation">
										<a href="javascript:void(0)"></a>
									</div>
									<div class="clr"></div>
									<div class="toolbar_right">
										<div class="normal">
											<div class="comm_right">
												<div class="btn_area">
													<a href="javascript:void(0)" class="submit_btn">
														去结算
													</a>
												</div>
												<div class="price_sum">
													<div>
														<span class="txt_new">总价：</span>
														<span class="sumPrice">
															<em>￥<span>{{sumprice}}</span></em>
														</span>
													</div>
												</div>
												<div class="amount_sum">
													已选择<em>{{amountsum}}</em>件商品
												</div>
												<div class="clr"></div>
											</div>
										</div>
									</div>
								</div>
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
		name:"CartContainer",
		data(){
			return{
				cartgoods:[],
				cartmessage:[],
				optgood:[],
				goodsnum:'',
				sumprice:'0.00',
				empty:false,
				originalnum:'',
				amountsum:'0'
			}
		},
		methods:{
			getcheckboxId(index){//每个商品的选择框设置动态id
				return "checkbox"+(index+1);
			},
			removeId(index){//每个商品的删除设置动态id
				return "remove"+(index+1);
			},
			pricesumId(index){//每个商品总价设置动态id
				return "pricesum"+(index+1);
			},
			priceId(index){//每个商品单价设置动态id
				return "price"+(index+1);
			},
			getindex(index){//data-index属性
				return index+1;
			},
			decrementId(index){//动态给id
				return "decrement"+(index+1);
			},
			numId(index){
				return "num"+(index+1);
			},
			incrementId(index){
				return "increment"+(index+1);
			},
			getMessage(){
				if(this.$route.params.goodscart){//点击加入购物车过来的
					this.cartmessage = this.$route.params.goodscart;
					window.sessionStorage.setItem('cartmessage', JSON.stringify(this.$route.params.goodscart));
					this.selectCart(this.cartmessage.accountid);
				}else{
					if(window.sessionStorage.getItem("userid")){
						this.selectCart(JSON.parse(window.sessionStorage.getItem("userid")));
						let _this = this;
						setTimeout(function(){
							if(_this.goodsnum == 0){
								_this.empty = true;
							}else{
								_this.empty = false;
							}
						},200)
					}else{
						this.cartmessage = JSON.parse(window.sessionStorage.getItem('cartmessage'));
						this.selectCart(this.cartmessage.accountid);
					}
				}
			},
			selectCart(userid){//查找该用户的购物车
				let _this = this;
				let oAjax = null;
				if(window.XMLHttpRequest){
				  oAjax = new XMLHttpRequest();
				}else{
				  oAjax = new ActiveXObject('Microsoft.XMLHTTP');
				}
				oAjax.open('GET','http://127.0.0.1/goods/selectCart?accountid='+userid,true);
				oAjax.send();
				oAjax.onreadystatechange=function(){
				  if(oAjax.readyState==4){
				    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
				      //4.对响应进行解析
				      let goodslist=JSON.parse(oAjax.responseText);
				      //console.log(goodslist);
				      _this.cartgoods = [];
				      _this.cartgoods = goodslist.data;
				      //console.log(_this.cartgoods);
				      _this.goodsnum = _this.cartgoods.length;
				    }else{
				      //4.对响应进行解析
				      alert("服务器错误");
				    }
				  }
				}
			},
			fixedBottom(){
				let cartfloatbar = this.getEle("cart_floatbar");
				let carttoolbar = this.getEle("cart_toolbar");
				if(cartfloatbar.offsetTop>550){
					carttoolbar.classList.add("fixed_bottom");
				}else{
					carttoolbar.classList.remove("fixed_bottom");
				}
				document.addEventListener("scroll",function(){
					if(cartfloatbar.offsetTop-document.documentElement.scrollTop<=document.documentElement.clientHeight){
						carttoolbar.classList.remove("fixed_bottom");
					}else{
						carttoolbar.classList.add("fixed_bottom");
					}
				})
			},
			getEle(id){
				return document.getElementById(id);
			},
			decrementClick($event){//减号
				console.log("减号"+this.cartgoods);
				let index = $event.target.getAttribute("data-index");
				let numid = "num"+index;
				let incrementid = "increment"+index;
				let decrementid = "decrement"+index;
				let priceid = "price"+index;
				let pricesumid = "pricesum"+index;
				let checkboxid = "checkbox"+index;
				let num = this.getEle(numid);
				let increment = this.getEle(incrementid);
				let decrement = this.getEle(decrementid);
				let price = this.getEle(priceid);
				let pricesum = this.getEle(pricesumid);
				let checkbox = this.getEle(checkboxid);
				if(num.value>=2){
					num.value--;
					increment.classList.remove("disabled");
					decrement.classList.remove("disabled");
					pricesum.innerHTML = (num.value*price.innerHTML).toFixed(2);
					this.optgood = [];
					this.optgood = this.cartgoods[index-1];
					this.optgood.goodnum = (parseInt(this.cartgoods[index-1].goodnum)-1).toString();
					this.optgood.goodsumprice = (parseInt(this.optgood.goodnum)*parseInt(this.optgood.goodprice)).toFixed(2);
					if(checkbox.checked){//该商品以被选中
						this.sumprice = (parseInt(this.sumprice) - parseInt(this.optgood.goodprice)).toFixed(2);
					}
					//console.log(this.optgood);
					this.updateCart(this.optgood);//更新数据库
					if(num.value==1){
						decrement.classList.add("disabled");
					}	
				}	
			},
			incrementClick($event){//加号
				let index = $event.target.getAttribute("data-index");
				let numid = "num"+index;
				let incrementid = "increment"+index;
				let decrementid = "decrement"+index;
				let priceid = "price"+index;
				let pricesumid = "pricesum"+index;
				let checkboxid = "checkbox"+index;
				let num = this.getEle(numid);
				let increment = this.getEle(incrementid);
				let decrement = this.getEle(decrementid);
				let price = this.getEle(priceid);
				let pricesum = this.getEle(pricesumid);
				let checkbox = this.getEle(checkboxid);
				if(num.value<200){
					decrement.classList.remove("disabled");
					num.value++;
					pricesum.innerHTML = (num.value*price.innerHTML).toFixed(2);
					this.optgood = [];
					this.optgood = this.cartgoods[index-1];
					this.optgood.goodnum = (parseInt(this.cartgoods[index-1].goodnum)+1).toString();
					this.optgood.goodsumprice = (parseInt(this.optgood.goodnum)*parseInt(this.optgood.goodprice)).toFixed(2);
					if(checkbox.checked){//该商品以被选中
						this.sumprice = (parseInt(this.sumprice) + parseInt(this.optgood.goodprice)).toFixed(2);
					}
					//console.log(this.optgood);
					this.updateCart(this.optgood);//更新数据库
					if(num.value==200){
						increment.classList.add("disabled");
					}
				}
			},
			numFocus($event){
				this.originalnum = "";
				this.originalnum = $event.target.value;
			},
			numBlur($event){
				let index = $event.target.getAttribute("data-index");
				let numid = "num"+index;
				let incrementid = "increment"+index;
				let decrementid = "decrement"+index;
				let priceid = "price"+index;
				let pricesumid = "pricesum"+index;
				let checkboxid = "checkbox"+index;
				let num = this.getEle(numid);
				let increment = this.getEle(incrementid);
				let decrement = this.getEle(decrementid);
				let price = this.getEle(priceid);
				let pricesum = this.getEle(pricesumid);
				let checkbox = this.getEle(checkboxid);
				if(num.value <= 1){
					num.value = 1;
					decrement.classList.add("disabled");
					this.optgood = [];
					this.optgood = this.cartgoods[index-1];
					this.optgood.goodnum = "1";
					this.optgood.goodsumprice = (parseInt(this.optgood.goodnum)*parseInt(this.optgood.goodprice)).toFixed(2);
					if(checkbox.checked == true){
						this.sumprice = (parseInt(this.sumprice)-((parseInt(this.originalnum)-1)*parseInt(this.optgood.goodprice))).toFixed(2);
					}
										//console.log(this.optgood);
					this.updateCart(this.optgood);//更新数据库
				}else if(num.value >= 200){
					num.value = 200;
					increment.classList.add("disabled");
					this.optgood = [];
					this.optgood = this.cartgoods[index-1];
					this.optgood.goodnum = "200";
					this.optgood.goodsumprice = (parseInt(this.optgood.goodnum)*parseInt(this.optgood.goodprice)).toFixed(2);
					if(checkbox.checked == true){
						this.sumprice = (parseInt(this.sumprice)+((200-parseInt(this.originalnum))*parseInt(this.optgood.goodprice))).toFixed(2);
					}
					//console.log(this.optgood);
					this.updateCart(this.optgood);//更新数据库
				}else{
					let nums = num.value;
					//console.log(nums instanceof String);
					increment.classList.remove("disabled");
					decrement.classList.remove("disabled");
					this.optgood = [];
					this.optgood = this.cartgoods[index-1];
					this.optgood.goodnum = nums;
					this.optgood.goodsumprice = (parseInt(this.optgood.goodnum)*parseInt(this.optgood.goodprice)).toFixed(2);
					if(checkbox.checked == true){
						if(parseInt(this.originalnum)<=parseInt(this.optgood.goodnum)){//增加
							this.sumprice = (parseInt(this.sumprice)+((parseInt(this.optgood.goodnum)-parseInt(this.originalnum))*parseInt(this.optgood.goodprice))).toFixed(2);
						}else{
							this.sumprice = (parseInt(this.sumprice)-((parseInt(this.originalnum)-parseInt(this.optgood.goodnum))*parseInt(this.optgood.goodprice))).toFixed(2);
						}
					}
					//console.log(this.optgood);
					this.updateCart(this.optgood);//更新数据库
				}
				pricesum.innerHTML = (num.value*price.innerHTML).toFixed(2);
			},
			loadMinWith(){
	  		document.getElementsByClassName("cartheader")[0].style.minWidth = (window.screen.width-17)+"px";
	  		document.getElementsByClassName("cart")[0].style.minWidth = (window.screen.width-17)+"px";
	  	},
	  	updateCart(optgood){
	  		let _this = this;
				let oAjax = null;
				if(window.XMLHttpRequest){
				  oAjax = new XMLHttpRequest();
				}else{
				  oAjax = new ActiveXObject('Microsoft.XMLHTTP');
				}
				oAjax.open('POST','http://127.0.0.1/goods/updateCart',true);
				oAjax.setRequestHeader("Content-type","application/json");
				oAjax.send(JSON.stringify(optgood));
				oAjax.onreadystatechange=function(){
				  if(oAjax.readyState==4){
				    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
				      //4.对响应进行解析
				      let optgoods=JSON.parse(oAjax.responseText);
				      if(optgoods.code == 1){//更新成功
				      	_this.selectCart(optgood.accountid);//查询数据库重新渲染
				      }
				    }else{
				      //4.对响应进行解析
				      alert("服务器错误");
				    }
				  }
				}
	  	},
	  	jiajianStyle(){
	  		// let decrementlist = document.getElementById("decrement1");
	  		// console.log(decrementlist);
	  		 //console.log(this.cartgoods[0]);
	  		 let _this = this;
	  		 //console.log(_this.cartgoods);
	  		_this.cartgoods.forEach(function(currentValue,index){//数量为1或者200时有样式变动
				  //console.log(index);
				  //console.log("decrement"+(index+1).toString());
				  let decrement = "decrement"+((index+1).toString());
				  let decrementid = _this.getEle(decrement);//获得当前的减号
				  //console.log(decrementid);
					let increment = "increment"+((index+1).toString());
					let incrementid = _this.getEle(increment);//获得当前的加号
			  	if(currentValue.goodnum == 1){
			  		decrementid.classList.add("disabled");
			  		incrementid.classList.remove("disabled");
			  	}else if(currentValue.goodnum == 200){
			  		decrementid.classList.remove("disabled");
			  		incrementid.classList.add("disabled");
			  	}else{
			  		decrementid.classList.remove("disabled");
			  		incrementid.classList.remove("disabled");
			  	}
			  })
	  	},
	  	deleteClick($event){//单个删除
	  		let index = $event.target.getAttribute("data-index");
	  		let _this = this;
	  		let oAjax = null;
	  		_this.optgood = [];
				_this.optgood = _this.cartgoods[index-1];
				_this.sumprice = (parseInt(_this.sumprice) - parseInt(_this.optgood.goodsumprice)).toFixed(2);
				if(window.XMLHttpRequest){
				  oAjax = new XMLHttpRequest();
				}else{
				  oAjax = new ActiveXObject('Microsoft.XMLHTTP');
				}
				oAjax.open('POST','http://127.0.0.1/goods/deleteCart',true);
				oAjax.setRequestHeader("Content-type","application/json");
				oAjax.send(JSON.stringify(_this.optgood));
				oAjax.onreadystatechange=function(){
				  if(oAjax.readyState==4){
				    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
				      //4.对响应进行解析
				      let optgoods=JSON.parse(oAjax.responseText);
				      if(optgoods.code == 1){//更新成功
				      	_this.selectCart(_this.optgood.accountid);//查询数据库重新渲染
				      }
				    }else{
				      //4.对响应进行解析
				      alert("服务器错误");
				    }
				  }
				}
	  	},
	  	mainCheckBox($event){//全选按钮
	  		let jdcheckbox = document.getElementsByClassName("jdcheckbox");
	  		if($event.target.checked){//true
	  			let calsumprice = 0;
	  			jdcheckbox.forEach(function(currentValue){
	  				currentValue.checked = true
	  			})
	  			this.cartgoods.forEach(function(currentValue){
	  				calsumprice += parseInt(currentValue.goodsumprice);
	  			})
	  			this.sumprice = calsumprice.toFixed(2);
	  			this.amountsum = (document.getElementsByClassName("singlejdcheckbox").length).toString();
	  		}else{//false
	  			jdcheckbox.forEach(function(currentValue){
	  				currentValue.checked = false;
	  			})
	  			this.sumprice = "0.00";
	  			this.amountsum = "0";
	  		}
	  	},
	  	singleCheckbox($event){
	  		let index = $event.target.getAttribute("data-index");
	  		let maincheckbox = this.getEle("maincheckbox");
	  		let maincheckbox1 = this.getEle("maincheckbox1");
	  		let singlejdcheckbox = document.getElementsByClassName("singlejdcheckbox");
	  		let i = 0;
	  		if($event.target.checked){
	  			$event.target.checked = true;
	  			this.sumprice = (parseInt(this.sumprice) + parseInt(this.cartgoods[index-1].goodsumprice)).toFixed(2);
	  			this.amountsum = (parseInt(this.amountsum) + 1).toString();
	  		}else{
	  			$event.target.checked = false;
	  			maincheckbox.checked = false;
	  			maincheckbox1.checked = false;
	  			this.sumprice = (parseInt(this.sumprice) - parseInt(this.cartgoods[index-1].goodsumprice)).toFixed(2);
	  			this.amountsum = (parseInt(this.amountsum) - 1).toString();
	  		}
	  		//每当点击的时候判断是否全选了
	  		singlejdcheckbox.forEach(function(currentValue){
	  			if(currentValue.checked){
	  				i++;
	  			}
	  		})
	  		if(i == singlejdcheckbox.length){
	  			maincheckbox.checked = true;
	  			maincheckbox1.checked = true;
	  		}
	  	}
		},
		mounted(){
			this.loadMinWith();
			this.getMessage();//获得相关信息
			let that = this;
			setTimeout(function(){
				that.fixedBottom();//底部付款fixed布局
				that.jiajianStyle();
			},300)
		}
	}
</script>
<style scoped>
	.goodsempty{
		height: 50px;
		line-height: 50px;
		font-size: 20px;
		text-align: center;
		font-weight: 700;
	}
	a{
		outline: none;
	}
	/*清除浮动*/
	.clr {
    display: block;
    overflow: hidden;
    clear: both;
    height: 0;
    line-height: 0;
    font-size: 0;
	}
	/*整个内容部分*/
	.cart{
		margin-top: 30px;
	}
	/*全部商品内容*/
	.w {
    width: 990px;
    margin: 0 auto;
	}
	.cart_filter_bar{
		margin-top: 10px;
	}
	.switch_cart{
		float: left;
    height: 26px;
    overflow: hidden;
    list-style: none;
	}
	.switch_cart_item{
		float: left;
    font-weight: 700;
    font-size: 16px;
    height: 26px;
    line-height: 26px;
    text-align: center;
    padding: 0 0 10px;
    cursor: pointer;
    margin: 5px 30px 0 0;
	}
	.switch_cart_item a{
		color: #E2231A
	}
	/*全部商品文字*/
	.switch_cart_item a em{
		font-style: normal;
	}
	/*购物车商品的个数*/
	.number {
    font-family: verdana;
    font-size: 14px;
	}
	/*配送*/
	.cart_store{
		float: right;
		margin-bottom: 10px;
    padding-left: 122px;
	}
	/*配送至*/
	.label {
    float: left;
    line-height: 26px;
    font-size: 12px;
	}
	/*地址*/
	.ui_area_wrap{
		float: left;
    z-index: 3;
    height: 26px;
    cursor: default;
    margin: 0;
	}
	.ui_area_text_wrap{
		position: relative;
		float: left;
    top: 0;
    height: 23px;
    background: #fff;
    border: 1px solid #CECBCE;
    padding: 0 24px 0 4px;
    line-height: 23px;
    overflow: hidden;
	}
	/*地址文字*/
	.ui_area_text{
		line-height: 23px;
		cursor: default;
		font-size: 12px;
	}
	/*向下的箭头*/
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
	/*红线*/
	.w_line {
    position: relative;
    height: 1px;
    background: #e0e0e0;
	}
	/*红线*/
	.floater {
    position: absolute;
    height: 2px;
    background: #E2231A;
   	width: 79px;
    left: 0px;
    overflow: hidden;
	}
	/*商品内容*/
	.cart_warp {
    background: #fff;
    margin-bottom: 20px;
	}
	/*每栏的名称*/
	.cart_thead{
    height: 43px;
    line-height: 43px;
    margin: 0 0 10px;
    padding: 5px 0;
    background: #f3f3f3;
    border: 1px solid #e9e9e9;
    border-top: 0;
	}
	/*每栏都左浮*/
	.column {
    float: left;
    font-size: 12px;
	}
	/*全选模块*/
	.t_checkbox {
    height: 32px;
    line-height: 32px;
    width: 133px;
    padding-left: 11px;
    font-size: 12px;
	}
	.cart_checkbox{
		float: left;
    margin-right: 5px;
	}
	.jdcheckbox{
		vertical-align: middle;
		margin: 0 3px 0 0;
    padding: 0;
	}
	/*商品*/
	.t_goods {
    width: 208px;
    height: 32px;
    line-height: 32px;
	}
	/*空的*/
	.t_props {
    width: 80px;
    height: 32px;
    padding: 0 10px 0 20px;
		line-height: 32px;
	}
	/*单价*/
	.t_price {
    width: 160px;
    height: 32px;
    padding-right: 40px;
    text-align: right;
    line-height: 32px;
	}
	/*数量*/
	.t_quantity {
    width: 80px;
    height: 32px;
    text-align: center;
		line-height: 32px;
		margin-left: 20px;
	}
	/*小计*/
	.t_sum {
    width: 140px;
    height: 32px;
    padding-right: 40px;
    text-align: right;
    line-height: 32px;
	}
	/*操作*/
	.t_action {
		height: 32px;
    width: 75px;
    line-height: 32px;
    margin-left: 40px;
	}
	/*每个商品*/
	.cart_item_list{
		margin-bottom: 20px;
	}
	/*内部盒子*/
	.cart_tbody {
    font-family: "Microsoft YaHei",SimSun,verdana;
	}
	/*内容盒子*/
	.item_list {
    border-style: solid;
    border-width: 2px 1px 1px;
    border-color: #aaa #f1f1f1 #f1f1f1;
    background: #fff;
	}
	.item_header {
    background: #fff;
    position: relative;
    height: 26px;
    padding: 5px 10px;
    line-height: 26px;
    color: #999;
	}
	.f_txt {
    float: left;
    width: 740px;
    white-space: nowrap;
    text-overflow: ellipsis;
	}
	/*店铺名*/
	.f_txt span {
		display: inline-block;
		font-size: 12px;
    background: #fff;
    color: #f48719;
    border: 1px solid #f48719;
    padding: 1px 10px;
    height: 21px;
    line-height: 16px;
    margin: 0 10px 0 5px;
	}
	/*店铺名下面内容*/
	.item_item {
    border: 0;
    padding: 0 0 1px 40px;
    line-height: 20px;
    background: #fff;
	}
	.item_form {
    border-top: 1px solid #f1f1f1;
    position: relative;
	}
	.item_form:after {
    content: ".";
    display: block;
    height: 0;
    clear: both;
    visibility: hidden;
	}
	.cell {
    float: left;
    padding: 15px 0 10px;
	}
	/*选择按钮*/
	.p_checkbox {
    position: absolute;
    left: -28px;
    top: 26px;
    width: 30px;
    min-height: 10px;
	}
	.cart_checkbox {
    position: relative;
    float: left;
    margin-right: 5px;
	}
	/*图片与文字*/
	.p_goods {
    width: 300px;
    margin-right: 115px;
	}
	.p_img {
    float: left;
    width: 80px;
    height: 80px;
    border: 1px solid #eee;
    margin-right: 10px;
    background: #fff;
    padding: 0;
    text-align: center;
    overflow: hidden;
	}
	.p_img a img{
		width: 100%;
		height: 100%;
	}
	img {
    border: 0;
    vertical-align: middle;
	}
	.p_name {
    height: 40px;
    line-height: 20px;
    overflow: hidden;
	}
	.p_name a{
		color: #333;
		font-size: 12px;
	}
	.p_name a:hover,
	.cart_remove:hover{
		color: #E2231A;
	}
	/*单价*/
	.p_price {
    width: 150px;
    padding-right: 40px;
    font-family: verdana;
    text-align: right;
    overflow: hidden;
    margin-top: 25px;
  }
  .p_price strong {
    display: block;
    color: #333;
    font-weight: 400;
    cursor: pointer;
    font-size: 12px;
	}
	.p_quantity {
    width: 80px;
    margin-top: 25px;
	}
	.quantity_form {
    position: relative;
    overflow: hidden;
    height: 22px;
    width: 84px;
	}
	/*减号*/
	.decrement {
    float: left;
    border: 1px solid #cacbcb;
    border-right: 0;
    height: 20px;
    line-height: 14px;
    padding: 1px 0;
    width: 20px;
    text-align: center;
    color: #666;
    margin: 0;
    background: #fff;
    outline: none;
	}
	/*数量*/
	.itxt {
    position: absolute;
    left: 20px;
    top: 0;
    border: 1px solid #cacbcb;
    width: 44px;
    height: 20px;
    line-height: 20px;
    text-align: center;
    padding: 1px;
    margin: 0;
    font-size: 12px;
    font-family: verdana;
    color: #333;
    -webkit-appearance: none;
	}
	/*加号*/
	.increment {
    float: right;
    border: 1px solid #cacbcb;
    border-left: 0;
    height: 20px;
    line-height: 16px;
    padding: 1px 0;
    width: 20px;
    text-align: center;
    color: #666;
    margin: 0;
    background: #fff;
    outline: none;
	}
	.disabled{
    cursor: not-allowed;
    color: #bdbaba;
	}
	/*总价*/
	.p_sum {
    width: 100px;
    padding-right: 40px;
    text-align: right;
    font-family: verdana;
    margin-left: 65px;
    margin-top: 25px;
	}
	.p_sum strong {
    color: #333;
    font-weight: 700;
    display: block;
    font-size: 12px;
	}
	/*删除*/
	.p_ops {
    width: 75px;
    position: relative;
    margin-left: 10px;
    margin-top: 25px;
	}
	.p_ops a {
    color: #666;
    display: block;
    font-size: 12px;
	}
	.item_extra {
    position: relative;
    margin-bottom: 10px;
	}
	/*结算区*/
	.cart_floatbar{
		position: relative;
	}
	.ui_ceilinglamp{
		width: 990px;
    height: 52px;
    
	}
	.cart_toolbar {
		width: 988px;
    height: 50px;
    border: 1px solid #f0f0f0;
    background: #fff;
    position: relative;
	}
	.toolbar_wrap {
    position: relative;
    width: 988px;
    margin: 0 auto;
	}
	.options_box {
    position: relative;
    height: 50px;
	}
	/*全选*/
	.select_all {
    float: left;
    height: 18px;
    line-height: 18px;
    padding: 16px 0 16px 9px;
    white-space: nowrap;
    font-size: 12px;
	}
	.cart_checkbox {
    position: relative;
    float: left;
    margin-right: 5px;
	}
	.jdcheckbox {
    position: relative;
    float: none;
    vertical-align: middle;
    margin: 0 3px 0 0;
    padding: 0;
	}
	/*删除商品*/
	.operation{
    float: left;
    height: 50px;
    width: 310px;
    line-height: 50px;
	}
	.operation a {
    float: left;
    margin-left: 5px;
    color: #666;
    font-size: 12px;
	}
	/*右侧*/
	.toolbar_right{
    position: absolute;
    height: 52px;
    right: 0;
    top: -1px;
    width: 720px;
	}
	.normal {
    height: 52px;
	}
	.comm_right {
    float: right;
    width: 650px;
	}
	/*结算按钮*/
	.btn_area {
    float: right;
	}
	.submit_btn {
    display: block;
    position: relative;
    width: 94px;
    height: 52px;
    line-height: 52px;
    color: #fff;
    text-align: center;
    font-size: 18px;
    font-family: "Microsoft YaHei";
    background: #e54346;
    overflow: hidden;
    font-weight: 700;
	}
	/*总价*/
	.price_sum {
    float: right;
    height: 50px;
    line-height: 50px;
    margin: 0 5px 0 10px;
    color: #666;
    width: auto;
    position: relative;
	}
	.price_sum div {
    white-space: nowrap;
	}
	/*总价：*/
	.txt_new {
    width: 50px;
    float: left;
    text-align: right;
    color: #999;
    font-size: 12px;
	}
	/*价格数字*/
	.sumPrice {
    display: inline-block;
    text-align: right;
    font-family: verdana;
	}
	.sumPrice em {
    font-size: 16px;
    color: #E2231A;
    font-weight: 700;
    font-style: normal;
	}
	/*已选择商品数*/
	.amount_sum {
    float: right;
    color: #999;
    height: 50px;
    line-height: 50px;
    cursor: pointer;
    font-size: 12px;
	}
	.amount_sum em {
    color: #E2231A;
    font-family: verdana;
    font-weight: 700;
    margin: 0 3px;
    font-style: normal;
	}
	/*结算浮动*/
	.fixed_bottom {
    position: fixed;
    bottom: 0px;
    z-index: 999;
    background: #fff;
    left: 0;
    border-width: 1px 0;
    box-shadow: 0 -1px 8px rgba(0,1,1,.08);
    width: 1349px;
    height: 50px;
	}
</style>