<template>
	<div class="listbody" id="listbody">
		<div class="listbody_inner">
			<ul class="listbody_list">
				<li class="listbody_item" v-for="(item,index) in hotgood" :key="index">
					<a href="javascript:void(0)" class="listbody_item_lk">
						<div class="lazyimg listbody_img">
							<img :src="item.pic" alt="商品图片" class="lazyimg_img" @click="bindclick($event)">
						</div>
						<div class="listbody_info">
							<p class="listbody_info_name" @click="bindclick($event)">{{item.title}}</p>
							<div class="listbody_info_price">
								<div class="listbody_price">
									<span class="listbody_info_price_txt" @click="bindclick($event)">￥{{item.price}}</span>
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
		name:"ListBody",
		data(){
			return{
				currentU:[],
				hotgood:[]
			}
		},
		props:{
      seagood: {
        type: Array,
        default: () => {
          return {}
        }
      }
    },
    watch: {//监听值变化
      seagood: function(newVal,oldVal){
      	this.hotgood = [];
        this.hotgood = newVal;  //newVal即是chartData
    	}
    },
		methods:{
			getCurrentU(){
				let listbody=document.getElementById('listbody');   
				this.$emit("listbodyoffsettop",listbody.offsetTop);
				const tempData = sessionStorage.getItem('tempData');
				if(tempData){//如果内存中有用户数据
					this.currentU = JSON.parse(tempData);
				}else{
					if(this.$route.params.user == null){//没登录显示热品
						this.currentU = [];
					}else{
						this.currentU = this.$route.params.user;
					}
				} 
			},
			gethotgoods(){
				let _this = this;
				let oAjax = null;
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
							_this.hotgood = [];
							_this.hotgood = hotgoods.data;
						}else{
							//服务器错误
							alert("服务器错误");
						}
					}
				}
			},
			bindclick($event){//给每个商品都绑定事件
				const applyParams = window.localStorage.getItem('applyParams');
				let _this = this;
				if($event.target.className == "lazyimg_img"){
					_this.hotgood.forEach(function(currentValue){
						if('http:'+currentValue.pic == $event.target.currentSrc){
							//找到了当前的数据存起来，先置空再存
							//console.log(applyParams);
							if(applyParams){//如果有数据，先置空再存
								window.localStorage.removeItem('applyParams');
								window.localStorage.removeItem('tempDate');
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentU));
								//console.log(window.localStorage.getItem('applyParams'));
							}else{//如果没数据，直接存
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentU));
								//console.log(window.localStorage.getItem('applyParams'));
							}
						}
					})
					// console.log($event.target.currentSrc);
					// console.log(this.personrecommend[0].pic);
				}else if($event.target.className == "listbody_info_name"){
					_this.hotgood.forEach(function(currentValue){
						if(currentValue.title == $event.target.innerHTML){
							//找到了当前的数据存起来，先置空再存
							//console.log(applyParams);
							if(applyParams){//如果有数据，先置空再存
								window.localStorage.removeItem('applyParams');
								window.localStorage.removeItem('tempDate');
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentU));
								//console.log(window.localStorage.getItem('applyParams'));
							}else{//如果没数据，直接存
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentU));
								//console.log(window.localStorage.getItem('applyParams'));
							}
						}
					})
				}else{//listbody_info_price_txt
					_this.hotgood.forEach(function(currentValue){
						if("￥"+currentValue.price == $event.target.innerHTML){
							//找到了当前的数据存起来，先置空再存
							//console.log(applyParams);
							if(applyParams){//如果有数据，先置空再存
								window.localStorage.removeItem('applyParams');
								window.localStorage.removeItem('tempDate');
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentU));
								//console.log(window.localStorage.getItem('applyParams'));
							}else{//如果没数据，直接存
								window.localStorage.setItem('applyParams', JSON.stringify(currentValue));
								window.localStorage.setItem('tempDate', JSON.stringify(_this.currentU));
								//console.log(window.localStorage.getItem('applyParams'));
							}
						}
					})
				}
				let {href} = this.$router.resolve({name:'Detail',params:{currentLogin:this._currentU}});
				window.open(href, '_blank');//打开详情页
			}
		},
		mounted(){
			this.getCurrentU();
			this.gethotgoods();
		}
	}
</script>
<style scoped>
	.listbody {
    margin: 0 auto;
    width: 98%;
	}	
	.listbody:after{
		display: block;
		content: "";
		clear: both;
	}
	.listbody_list {
    margin: 0 -5px;
	}
	/*每个商品框*/
	.listbody_item {
    position: relative;
    float: left;
    width: 230px;
    height: 322px;
    margin: 0 5px 10px;
    background: #fff;
    list-style: none;
	}
	.listbody_item_lk{
		display: inline-block;
    width: 100%;
    height: 100%;
	}
	/*图片*/
	.listbody_img{
		width: 210px;
		height: 225px;
	}
	.listbody_img img{
		width: 100%;
		height: 100%;
	}
	.listbody_info {
    clear: both;
    line-height: 24px;
    padding: 0 20px;
    height: 65px;
	}
	.listbody_info_name {
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
	.listbody_info_price {
    margin-top: 10px;
	}
	.listbody_price{
		float: left;
    width: 75px;
    text-align: left;
    display: inline-block;
    font-size: 16px;
    line-height: 18px;
    height: 18px;
    color: #e1251b;
	}
	.listbody_info_price_txt {
    font-size: 20px;
    font-weight: 700;
    font-family: arial,sans-serif;
	}
	.lazyimg_img{
		width: 100%;
		height: 100%;
	}
</style>