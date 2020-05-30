<template>
	<div class="recommendbody" id="recommendbody">
		<div class="recommendbody_inner">
			<ul class="recommendbody_list">
				<li class="recommendbody_item" v-for="(item,index) in personrecommend" :key="index">
					<a href="javascript:void(0)" class="recommendbody_item_lk">
						<div class="lazyimg recommendbody_img">
							<img :src="item.pic" alt="商品图片" class="lazyimg_img" @click="bindclick($event)">
						</div>
						<div class="recommendbody_info">
							<p class="recommendbody_info_name" @click="bindclick($event)">{{item.title}}</p>
							<div class="recommendbody_info_price">
								<div class="recommendbody_price">
									<span class="recommendbody_info_price_txt" @click="bindclick($event)">￥{{item.price}}</span>
								</div>
							</div>
						</div>
					</a>
				</li>
			</ul>
		</div>
	</div>
</template>
<script>
	export default{
		name:"RecommendBody",
		data(){
			return{
				personrecommend:[],
				currentUser:[],
				favourite1:[],//潮流服饰（裤子）
				favourite1_1:[],//潮流服饰(上衣)
				favourite1_2:[],//潮流服饰(鞋)
				favourite2:[],//文学读物（图书）
				favourite3:[],//电子设备（手机）
				favourite4:[],//居家生活（家具）
				favourite4_1:[],//居家生活（个护清洁）
				favourite4_2:[],//居家生活（箱包）
				favourite4_3:[],//居家生活（汽车用品）
				favourite5:[],//美味小吃（食品）
				favourite6:[],//萌宠乐园（宠物）
				favourite7:[],//珠宝配饰（珠宝）
				favourite8:[] //玩具城（玩具）
			}
		},
		methods:{
			getCurrentUser(){
				const tempData = window.sessionStorage.getItem('tempData');
				if(tempData){//如果内存中有用户数据
					this.currentUser = JSON.parse(tempData);
					this.recommendGoods();//推荐商品
				}else{
					if(this.$route.params.user == null){//没登录显示热品
						this.hotGoods();
					}else{
						this.currentUser = this.$route.params.user;
						this.recommendGoods();
					}
				} 
			},
			recommendGoods(){//有用户登录时
				//推荐商品请求
				let _this = this;
				let is_run = true;
				let oAjax = null;
				document.addEventListener("scroll",function(){
					let scrollTop=document.documentElement.scrollTop||document.body.scrollTop;    
					let cHeight=window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;    
					let recommendbody=document.getElementById('recommendbody');    
					if(scrollTop>(recommendbody.offsetTop-cHeight)&&is_run == true){
						
						if(window.XMLHttpRequest){
							oAjax = new XMLHttpRequest();
						}else{
							oAjax = new ActiveXObject("Microsoft.XMLHTTP");
						}
						oAjax.open("GET","http://127.0.0.1/goods/recommendGoods?account="+_this.currentUser.account,true);
						oAjax.send();
						oAjax.onreadystatechange = function(){
							if(oAjax.readyState == 4){
								if(oAjax.status >= 200 && oAjax.status < 300 || oAjax.status == 304){
									//解析响应
									let recommendgoods=JSON.parse(oAjax.responseText);
									//console.log(recommendgoods);
									_this.recommendSort(recommendgoods);//分类整理
								}else{
									//服务器错误
									alert("服务器错误");
								}
							}
						}
						is_run = false;
					}	
				})
			},
			recommendSort(recommendgoods){
				let _this = this;
				recommendgoods.data.forEach(function(currentValue){
					if(currentValue.type=="裤子"&&currentValue.title.indexOf(_this.currentUser.sex)!=-1){
						_this.favourite1.push(currentValue);
					}else if(currentValue.type=="上衣"&&currentValue.title.indexOf(_this.currentUser.sex)!=-1){
						_this.favourite1_1.push(currentValue);
					}else if(currentValue.type=="鞋"&&currentValue.title.indexOf(_this.currentUser.sex)!=-1){
						_this.favourite1_2.push(currentValue);
					}else if(currentValue.type=="图书"){
						_this.favourite2.push(currentValue);
					}else if(currentValue.type=="手机"){
						_this.favourite3.push(currentValue);
					}else if(currentValue.type=="家具"){
						_this.favourite4.push(currentValue);
					}else if(currentValue.type=="个护清洁"){
						_this.favourite4_1.push(currentValue);
					}else if(currentValue.type=="箱包"){
						_this.favourite4_2.push(currentValue);
					}else if(currentValue.type=="汽车用品"){
						_this.favourite4_3.push(currentValue);
					}else if(currentValue.type=="食品"){
						_this.favourite5.push(currentValue);
					}else if(currentValue.type=="宠物"){
						_this.favourite6.push(currentValue);
					}else if(currentValue.type=="珠宝"&&currentValue.title.indexOf(_this.currentUser.sex)!=-1){
						_this.favourite7.push(currentValue);
					}else if(currentValue.type=="玩具"){
						_this.favourite8.push(currentValue);
					}
				});
				//小于10的全部拿来，大于10的只拿10
				_this.personrecommend = [];
				var i = 0;
				while(i<10){
					if(_this.favourite1[i]){_this.personrecommend.push(_this.favourite1[i]);}
					if(_this.favourite1_1[i]){_this.personrecommend.push(_this.favourite1_1[i]);}
					if(_this.favourite1_2[i]){_this.personrecommend.push(_this.favourite1_2[i]);}
					if(_this.favourite2[i]){_this.personrecommend.push(_this.favourite2[i]);}
					if(_this.favourite3[i]){_this.personrecommend.push(_this.favourite3[i]);}
					if(_this.favourite4[i]){_this.personrecommend.push(_this.favourite4[i]);}
					if(_this.favourite4_1[i]){_this.personrecommend.push(_this.favourite4_1[i]);}
					if(_this.favourite4_2[i]){_this.personrecommend.push(_this.favourite4_2[i]);}
					if(_this.favourite4_3[i]){_this.personrecommend.push(_this.favourite4_3[i]);}
					if(_this.favourite5[i]){_this.personrecommend.push(_this.favourite5[i]);}
					if(_this.favourite6[i]){_this.personrecommend.push(_this.favourite6[i]);}
					if(_this.favourite7[i]){_this.personrecommend.push(_this.favourite7[i]);}
					if(_this.favourite8[i]){_this.personrecommend.push(_this.favourite8[i]);}
					i++;
				}
			},
			hotGoods(){//没有用户登录时显示
				//热款推荐请求
				let _this = this;
				let is_run = true;
				let oAjax = null;
				document.addEventListener("scroll",function(){//当滚动一段距离的时候触发 
					let scrollTop=document.documentElement.scrollTop||document.body.scrollTop;    
					let cHeight=window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight;    
					let recommendbody=document.getElementById('recommendbody');    
					if(scrollTop>(recommendbody.offsetTop-cHeight)&&is_run == true){
						if(window.XMLHttpRequest){
							oAjax = new XMLHttpRequest();
						}else{
							oAjax = new ActiveXObject("Microsoft.XMLHTTP");
						}
						oAjax.open("GET","http://127.0.0.1/goods/hotGoods",true);
						oAjax.send();
						oAjax.onreadystatechange = function(){
							if(oAjax.readyState == 4){
								if(oAjax.status >= 200 && oAjax.status < 300 || oAjax.status == 304){
									//解析响应
									let hotgoods = JSON.parse(oAjax.responseText);
									_this.personrecommend = [];
									_this.personrecommend = hotgoods.data;
								}else{
									//服务器错误
									alert("服务器错误");
								}
							}
						}
					}
				})
			},
			bindclick($event){//给每个商品都绑定事件
				const applyParams = window.localStorage.getItem('applyParams');
				let _this = this;
				if($event.target.className == "lazyimg_img"){
					_this.personrecommend.forEach(function(currentValue){
						if('http:'+currentValue.pic == $event.target.currentSrc){
							//找到了当前的数据存起来，先置空再存
							//console.log(applyParams);
							if(applyParams){//如果有数据，先置空再存
								window.localStorage.removeItem('applyParams');
								window.localStorage.removeItem('tempDate');
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentUser));
								//console.log(window.localStorage.getItem('applyParams'));
							}else{//如果没数据，直接存
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentUser));
								//console.log(window.localStorage.getItem('applyParams'));
							}
						}
					})
					// console.log($event.target.currentSrc);
					// console.log(this.personrecommend[0].pic);
				}else if($event.target.className == "recommendbody_info_name"){
					_this.personrecommend.forEach(function(currentValue){
						if(currentValue.title == $event.target.innerHTML){
							//找到了当前的数据存起来，先置空再存
							//console.log(applyParams);
							if(applyParams){//如果有数据，先置空再存
								window.localStorage.removeItem('applyParams');
								window.localStorage.removeItem('tempDate');
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentUser));
								//console.log(window.localStorage.getItem('applyParams'));
							}else{//如果没数据，直接存
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentUser));
								//console.log(window.localStorage.getItem('applyParams'));
							}
						}
					})
				}else{//recommendbody_info_price_txt
					_this.personrecommend.forEach(function(currentValue){
						if("￥"+currentValue.price == $event.target.innerHTML){
							//找到了当前的数据存起来，先置空再存
							//console.log(applyParams);
							if(applyParams){//如果有数据，先置空再存
								window.localStorage.removeItem('applyParams');
								window.localStorage.removeItem('tempDate');
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentUser));
								//console.log(window.localStorage.getItem('applyParams'));
							}else{//如果没数据，直接存
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentUser));
								//console.log(window.localStorage.getItem('applyParams'));
							}
						}
					})
				}
				let {href} = this.$router.resolve({name:'Detail',params:{currentLogin:_this.currentUser}});
				window.open(href, '_blank');//打开详情页
			}
		},
		mounted(){
			//获得用户id,并发送ajax请求推荐，存到personrecommend
			this.getCurrentUser();
		}
	}
</script>
<style scoped>
	.recommendbody {
    margin: 0 auto;
    width: 98%;
	}	
	.recommendbody:after{
		display: block;
		content: "";
		clear: both;
		overflow: hidden;
	}
	.recommendbody_list {
		display: flex;
		flex-wrap: wrap;
		justify-content: flex-start;
    margin: 0 -5px;
	}
	/*每个商品框*/
	.recommendbody_item {
    position: relative;
    float: left;
    width: 230px;
    height: 322px;
    margin: 0 4px 10px;
    background: #fff;
    list-style: none;
	}
	.recommendbody_item_lk{
		display: inline-block;
    width: 100%;
    height: 100%;
	}
	/*图片*/
	.recommendbody_img{
		width: 210px;
		height: 225px;
	}
	.recommendbody_img img{
		width: 100%;
		height: 100%;
	}
	.recommendbody_info {
    clear: both;
    line-height: 24px;
    padding: 0 20px;
    height: 65px;
	}
	.recommendbody_info_name {
    height: 48px;
    font-size: 14px;
    line-height: 24px;
    text-align: left;
    color: #666;
    word-break: break-all;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
	}
	.recommendbody_info_price {
    margin-top: 10px;
	}
	.recommendbody_price{
		float: left;
    width: 75px;
    text-align: left;
    display: inline-block;
    font-size: 16px;
    line-height: 18px;
    height: 18px;
    color: #e1251b;
	}
	.recommendbody_info_price_txt {
    font-size: 20px;
    font-weight: 700;
    font-family: arial,sans-serif;
	}
	.lazyimg_img{
		width: 100%;
		height: 100%;
	}
</style>