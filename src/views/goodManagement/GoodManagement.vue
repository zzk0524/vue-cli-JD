<template>
	<div class="good_management">
		<div class="good_management_header">
			<span class="headline">
				<a href="javascript:void(0)">
					<span>全部商品</span>
					<span class="number">{{goodNumber}}</span>
				</a>
			</span>
			<span class="add_good">
				<a href="javascript:void(0)" @click="addGood()">增加商品</a>
			</span>
			<div class="add_shade divnone" id="good_add_shade">
				<div class="add_form">
					<div class="add_close">
						<span @click="addCloseClick()"></span>
					</div>
					<div class="reg_form2">
						<form>
							<div class="form2_item" id="form2_item_sku">
								<label class="sku2" for="sku2">商品sku</label>
								<input id="sku2" v-model="form2.sku" type="text" class="field" required="required" autocomplete="off">
							</div>
							<div class="form2_item form2_item_title">
								<label class="title2" for="title2">名称</label>
								<input id="title2" v-model="form2.title" type="text" class="field" required="required" autocomplete="off">
							</div>
							<div class="form2_item form2_item_price">
								<label class="price2" for="price2">价格</label>
								<input id="price2" v-model="form2.price" type="text" class="field" required="required" autocomplete="off">
							</div>
							<div class="form2_item form2_item_shopname">
								<label class="shopname2" for="shopname2">店铺名</label>
								<input id="shopname2" v-model="form2.shopname" type="text" class="field" required="required" autocomplete="off">
							</div>
							<div class="form2_item form2_item_comments">
								<label class="comments2" for="comments2">评论数</label>
								<input id="comments2" v-model="form2.comments" type="text" class="field" required="required" autocomplete="off">
							</div>
							<div class="form2_item form2_item_pic">
								<label class="pic2" for="pic2">图片地址</label>
								<input id="pic2" v-model="form2.pic" type="text" class="field" required="required" autocomplete="off">
							</div>
							<div class="form2_item form2_item_url">
								<label class="url2" for="url2">信息来源</label>
								<input id="url2" v-model="form2.url" type="text" class="field" required="required" autocomplete="off">
							</div>
							<div class="form2_item form2_item_type">
								<label class="type2">类型</label>
								<select class="field" id="type2" v-model="form2.type">
									<option value="0">--请选择--</option>
								  <option value="手机">手机</option>
								  <option value="裤子">裤子</option>
								  <option value="上衣">上衣</option>
								  <option value="鞋">鞋</option>
								  <option value="食品">食品</option>
								  <option value="书">书</option>
								  <option value="家具">家具</option>
								  <option value="个护清洁">个护清洁</option>
								  <option value="箱包">箱包</option>
								  <option value="珠宝">珠宝</option>
								  <option value="玩具">玩具</option>
								  <option value="宠物">宠物</option>
								  <option value="汽车用品">汽车用品</option>
								</select>
							</div>
							<div class="add_btn">
								<button type="button" class="btn_add" @click="addBtn()">立即增加</button>
							</div>
						</form> 
					</div>
				</div>
			</div>
		</div>
		<div class="good_management_body">
			<div class="thead">
				<div class="column g_id">商品ID</div>
				<div class="column g_sku">商品sku</div>
				<div class="column g_title">名称</div>
				<div class="column g_price">价格</div>
				<div class="column g_shopname">店铺名</div>
				<div class="column g_comments">评论数</div>
				<div class="column g_pic">图片地址</div>
				<div class="column g_url">信息来源</div>
				<div class="column g_type">类型</div>
				<div class="column g_update">修改</div>
				<div class="column g_delete">删除</div>
			</div>
			<div v-show="loading" class="loading">
				<div class="loading_icon"></div>
			</div>
			<div class="list">
				<div class="good_item_list clearfix" v-for="(item,index) in allGood">
					<div class="cell p_id">
						<span>{{item.id}}</span>
					</div>
					<div class="cell p_sku" :title="item.sku">
						<span>{{item.sku}}</span>
					</div>
					<div class="cell p_title" :title="item.title">
						<span>{{item.title}}</span>
					</div>
					<div class="cell p_price" :title="item.price">
						<span>{{item.price}}</span>
					</div>
					<div class="cell p_shopname" :title="item.shopname">
						<span>{{item.shopname}}</span>
					</div>
					<div class="cell p_comments">
						<span>{{item.comments}}</span>
					</div>
					<div class="cell p_pic" :title="item.pic">
						<span>{{item.pic}}</span>
					</div>
					<div class="cell p_url" :title="item.url">
						<span>{{item.url}}</span>
					</div>
					<div class="cell p_type">
						<span>{{item.type}}</span>
					</div>
					<div class="cell p_update">
						<a href="javascript:void(0)" :data-index="getIndex(index)" @click="updateClick($event)">修改</a>
					</div>
					<div class="cell p_delete">
						<a href="javascript:void(0)" :data-index="getIndex(index)" @click="deleteClick($event)">删除</a>
					</div>
				</div>
				<div class="update_shade divnone" id="good_update_shade">
					<div class="update_form">
						<div class="update_close">
							<span @click="updateCloseClick()"></span>
						</div>
						<div class="reg_form">
							<form>
								<div class="form_item" id="form_item_sku">
									<label class="sku" for="sku">商品sku</label>
									<input id="sku" v-model="form.sku" type="text" class="field" required="required" autocomplete="off">
								</div>
								<div class="form_item form_item_title">
									<label class="title" for="title">名称</label>
									<input id="title" v-model="form.title" type="text" class="field" required="required" autocomplete="off">
								</div>
								<div class="form_item form_item_price">
									<label class="price" for="price">价格</label>
									<input id="price" v-model="form.price" type="text" class="field" required="required" autocomplete="off">
								</div>
								<div class="form_item form_item_shopname">
									<label class="shopname" for="shopname">店铺名</label>
									<input id="shopname" v-model="form.shopname" type="text" class="field" required="required" autocomplete="off">
								</div>
								<div class="form_item form_item_comments">
									<label class="comments" for="comments">评论数</label>
									<input id="comments" v-model="form.comments" type="text" class="field" required="required" autocomplete="off">
								</div>
								<div class="form_item form_item_pic">
									<label class="pic" for="pic">图片地址</label>
									<input id="pic" v-model="form.pic" type="text" class="field" required="required" autocomplete="off">
								</div>
								<div class="form_item form_item_url">
									<label class="url" for="url">信息来源</label>
									<input id="url" v-model="form.url" type="text" class="field" required="required" autocomplete="off">
								</div>
								<div class="form_item form_item_type">
									<label class="type">类型</label>
									<select class="field" id="type" v-model="form.type">
										<option value="0">--请选择--</option>
									  <option value="手机">手机</option>
									  <option value="裤子">裤子</option>
									  <option value="上衣">上衣</option>
									  <option value="鞋">鞋</option>
									  <option value="食品">食品</option>
									  <option value="书">书</option>
									  <option value="家具">家具</option>
									  <option value="个护清洁">个护清洁</option>
									  <option value="箱包">箱包</option>
									  <option value="珠宝">珠宝</option>
									  <option value="玩具">玩具</option>
									  <option value="宠物">宠物</option>
									  <option value="汽车用品">汽车用品</option>
									</select>
								</div>
								<div class="update_btn">
									<button type="button" class="btn_update" @click="updateBtn()">立即修改</button>
								</div>
							</form> 
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>
<script>
	export default{
		name:"GoodManagement",
		data(){
			return{
				allGood:[],
				form: {
					id:'',
					sku:'',
					title:'',
					price:'',
					shopname:'',
					comments:'',
					pic:'',
					url:'',
					type:''
				},
				form1:{//存旧数据,备用
					id:'',
					sku:'',
					title:'',
					price:'',
					shopname:'',
					comments:'',
					pic:'',
					url:'',
					type:''
				},
				form2:{
					id:'',
					sku:'',
					title:'',
					price:'',
					shopname:'',
					comments:'',
					pic:'',
					url:'',
					type:''
				},
				goodNumber:'',
				loading:true
			}
		},
		methods:{
			getIndex(index){//添加序号
				return index+1;
			},
			selectGood(){//查询所有商品
				let _this = this;
				let oAjax = null;
				if(window.XMLHttpRequest){
					oAjax = new XMLHttpRequest();
				}else{
					oAjax = new ActiveXObject("Microsoft.XMLHTTP");
				}
				oAjax.open('GET','http://127.0.0.1/goods/adminSelectGood',true);
				oAjax.send(null);
				oAjax.onreadystatechange=function(){
				  if(oAjax.readyState==4){
				    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
				      //对响应进行解析
				      let adminGood=JSON.parse(oAjax.responseText);				      
				      if(adminGood.code == 1){//查询成功
				      	_this.allGood = [];
				      	_this.allGood = adminGood.data;
				      	_this.goodNumber = _this.allGood.length;//用户数量
				      	_this.loading = false;
				      }
				    }else{
				      //对响应进行解析
				      alert("服务器错误");
				    }
				  }
				}
			},
			addGood(){//增加一个用户
				let goodAddShade = document.getElementById("good_add_shade");
				goodAddShade.classList.remove("divnone");//打开表单
				this.form2.id = "";
				this.form2.sku = "";
				this.form2.title = "";
				this.form2.price = "";
				this.form2.shopname = "";
				this.form2.comments = "";
				this.form2.pic = "";
				this.form2.url = "";
				this.form2.type = "0";
			},
			addCloseClick(){
				let goodAddShade = document.getElementById("good_add_shade");
				goodAddShade.classList.add("divnone");
			},
			addBtn(){//立即增加
				if(this.form2.sku&&this.form2.title&&this.form2.price&&this.form2.shopname&&this.form2.comments&&this.form2.pic&&this.form2.url&&this.form2.type!="0"){//不能为空
					let m = false;
					this.allGood.forEach((currentValue)=>{
						if(currentValue.sku==this.form2.sku){
							m = true;
						}
					})
					if(m){//商品sku不能重
						alert("存在该sku");
					}else{//发送请求
						this.form.price = this.form.price+".00";
						let _this = this;
						let oAjax = null;
						if(window.XMLHttpRequest){
							oAjax = new XMLHttpRequest();
						}else{
							oAjax = new ActiveXObject("Microsoft.XMLHTTP");
						}
						oAjax.open('POST','http://127.0.0.1/goods/adminAddGood',true);
						oAjax.setRequestHeader("Content-type","application/json");
						oAjax.send(JSON.stringify(_this.form2));
						oAjax.onreadystatechange=function(){
						  if(oAjax.readyState==4){
						    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
						      //对响应进行解析
						      let adminGood=JSON.parse(oAjax.responseText);
						      //重新查询一遍
						      if(adminGood.code == 1){//增加成功
						      	_this.addCloseClick();//关闭表单
						      	_this.selectGood();//查询所有用户
						      }
						    }else{
						      //对响应进行解析
						      alert("服务器错误");
						    }
						  }
						}
					}
				}else{
					alert("请填写完整!");
				}
			},
			updateClick(event){//点击修改按钮
				let goodUpdateShade = document.getElementById("good_update_shade");
				goodUpdateShade.classList.remove("divnone");//打开表单
				let index = event.target.getAttribute("data-index");//这是第几条
				this.form.id = this.allGood[index-1].id;
				this.form.sku = this.allGood[index-1].sku;
				this.form.title = this.allGood[index-1].title;
				this.form.price = this.allGood[index-1].price;
				this.form.shopname = this.allGood[index-1].shopname;
				this.form.comments = this.allGood[index-1].comments;
				this.form.pic = this.allGood[index-1].pic;
				this.form.url = this.allGood[index-1].url;
				this.form.type = this.allGood[index-1].type;
				this.form1.id = this.allGood[index-1].id;//备份一边旧数据
				this.form1.sku = this.allGood[index-1].sku;
				this.form1.title = this.allGood[index-1].title;
				this.form1.price = this.allGood[index-1].price;
				this.form1.shopname = this.allGood[index-1].shopname;
				this.form1.comments = this.allGood[index-1].comments;
				this.form1.pic = this.allGood[index-1].pic;
				this.form1.url = this.allGood[index-1].url;
				this.form1.type = this.allGood[index-1].type;
			},
			updateCloseClick(){
				let goodUpdateShade = document.getElementById("good_update_shade");
				goodUpdateShade.classList.add("divnone");//关闭表单
			},
			updateBtn(){//立即修改
				if(this.form.sku&&this.form.title&&this.form.price&&this.form.shopname&&this.form.comments&&this.form.pic&&this.form.url&&this.form.type!="0"){//不能为空
					if(this.form.sku==this.form1.sku&&this.form.title==this.form1.title&&this.form.price==this.form1.price&&this.form.shopname==this.form1.shopname&&this.form.comments==this.form1.comments&&this.form.pic==this.form1.pic&&this.form.url==this.form1.url&&this.form.type==this.form1.type){//与原数据相同
						alert("与原始数据相同!");
					}else{
						let m = false;
						this.allGood.forEach((currentValue)=>{
							if(currentValue.id!=this.form.id&&currentValue.sku==this.form.sku){
								m = true;
							}
						})
						if(m){//sku重复
							alert("商品sku重复!");
						}else{//发送请求
							this.form.price = this.form.price+".00";
							let _this = this;
							let oAjax = null;
							if(window.XMLHttpRequest){
								oAjax = new XMLHttpRequest();
							}else{
								oAjax = new ActiveXObject("Microsoft.XMLHTTP");
							}
							oAjax.open('POST','http://127.0.0.1/goods/adminUpdateGood',true);
							oAjax.setRequestHeader("Content-type","application/json");
							oAjax.send(JSON.stringify(_this.form));
							oAjax.onreadystatechange=function(){
							  if(oAjax.readyState==4){
							    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
							      //对响应进行解析
							      let adminGood=JSON.parse(oAjax.responseText);
							      //重新查询一遍
							      if(adminGood.code == 1){//更新成功
							      	_this.updateCloseClick();//关闭表单
							      	_this.selectGood();//查询所有用户
							      }
							    }else{
							      //对响应进行解析
							      alert("服务器错误");
							    }
							  }
							}
						}
					}
				}else{
					alert("请填写完整!");
				}
			},
			deleteClick(event){//点击删除按钮
				let index = event.target.getAttribute("data-index");//保存这是第几个
				let _this = this;
				let oAjax = null;
				if(window.XMLHttpRequest){
					oAjax = new XMLHttpRequest();
				}else{
					oAjax = new ActiveXObject("Microsoft.XMLHTTP");
				}
				oAjax.open('POST','http://127.0.0.1/goods/adminDeleteGood',true);
				oAjax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				oAjax.send("id="+_this.allGood[index-1].id);
				oAjax.onreadystatechange=function(){
				  if(oAjax.readyState==4){
				    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
				      //对响应进行解析
				      let adminGood=JSON.parse(oAjax.responseText);
				      //重新查询一遍
				      if(adminGood.code == 1){//删除成功
				      	_this.selectGood();//查询所有用户
				      }
				    }else{
				      //对响应进行解析
				      alert("服务器错误");
				    }
				  }
				}
			}
		},
		mounted(){
			this.selectGood();
		}		
	}
</script>
<style scoped>
	.divnone{
		display: none !important;
	}
	.clearfix{
		overflow: auto;
	}
	.good_management{
		height: 100%;
	}
	.good_management_header{
		width: 100%;
		margin-top: 10px;
	}
	.headline{
		display: inline-block;
    height: 26px;
    position: relative;
	}
	.headline a{
		color: #E2231A;
		outline: none;
		font-weight: 700;
    font-size: 16px;
    cursor: pointer;
	}
	/*红线*/
	.headline::after{
		content: "";
		display: inline-block;
		position: absolute;
		width: 80px;
		height: 2px;
		background: #E2231A;
		top: 30px;
		left: 0px;
	}
	.number {
    font-family: verdana;
    font-size: 14px;
	}
	/*增加用户*/
	.add_good{
		display: inline-block;
		width: 70px;
		height: 30px;
		float: right;
		margin-right:80px; 
	}
	.add_good a{
		display: inline-block;
		width: 70px;
		height: 25px;
		outline: none;
    font-weight: 700;
    font-size: 16px;
    cursor: pointer;
    text-align: center;
    line-height: 25px;
	}
	.add_good a:hover{
		border: 1px #E2231A solid;
		color: #E2231A;
		border-radius: 5px;
	}
	/*内容*/
	.good_management_body{
		width: 100%;
		height: 100%;
		margin-top: 5px;
	}
	.thead{
    height: 43px;
    line-height: 43px;
    margin: 0 0 10px;
    padding: 5px 0;
    background: #f3f3f3;
    border: 1px solid #e9e9e9;
    border-top: 0;
	}
	.loading{
		width: 100%;
		height: 50%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.loading_icon{
		position: relative;
		width: 30px;
		height: 30px;
		background: #E2231A;
	  border-radius: 50px;
	  animation: loading 0.4s infinite linear;
	}
	/*两个弧*/
	.loading_icon::after {
		content: '';
	  width: 54px;
	  height: 54px;
	  position: absolute;
	  top: -12px;
	  left: -12px;
	  border-top: 10px solid #E2231A;
	  border-bottom: 10px solid #E2231A;
	  border-left: 10px solid transparent;
	  border-right: 10px solid transparent;
	  border-radius: 50px;
	}
	.column{
    float: left;
    font-size: 12px;
    height: 32px;
    line-height: 32px;
	}
	.g_id{
		width: 70px;
		margin-left: 5px;
	}
	.g_sku{
		width: 100px;
	}
	.g_title{
		width: 200px;
	}
	.g_price{
		width: 80px
	}
	.g_shopname{
		width: 100px;
	}
	.g_comments{
		width: 70px;
	}
	.g_pic{
		width: 100px;
	}
	.g_url{
		width: 100px;
	}
	.g_type{
		width: 80px;
	}
	.g_update,
	.g_delete{
		width: 70px;
	}
	.list{
		width: 100%;
		height: 80%;
		overflow: auto;
	}
	.good_item_list{
		margin: 0 5px 5px 5px;
		border-bottom: 1px #e9e9e9 solid;
	}
	.good_item_list:hover{
		background-color: rgba(193,193,193);
	}
	/*用户信息的每个模块*/
	.cell{
		float: left;
		font-size: 14px;
    height: 40px;
    line-height: 40px;
	}
	.p_id{
		width: 70px;
		text-indent: 10px;
	}
	.p_sku,.p_title,.p_price,.p_shopname,.p_comments,.p_pic,.p_url{
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
	.p_sku{
		width: 100px;
	}
	.p_title{
		width: 200px;
	}
	.p_price{
		width: 80px;
	}
	.p_shopname{
		width: 100px;
	}	
	.p_comments{
		width: 70px;
	}
	.p_pic{
		width: 100px;
	}
	.p_url{
		width: 100px;
	}
	.p_type{
		width: 80px;
	}
	.p_update,
	.p_delete{
		width: 70px;
	}
	.p_update a:hover,
	.p_delete a:hover{
		color: #E2231A;
	}
	/*修改的表单*/
	.update_shade,
	.add_shade{
		position: fixed;
		width: 100%;
		height: 100%;
		top: 0;
		left: 0;
		background-color: rgba(37,36,35,.2);
		z-index: 99;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.update_form,
	.add_form{
		width: 500px;
		height: 500px;
		background-color: #fff;
		border: 1px rgb(178,178,178) solid;
		border-radius: 5px;
		box-shadow: 0px 0px 2px 2px rgb(178,178,178);
	}
	/*关闭*/
	.update_close,
	.add_close{
		width: 100%;
		height: 30px;
		margin-top: 10px;
		display: flex;
		justify-content: flex-end;
		align-items: center;
	}
	/*叉号图标*/
	.update_close span,
	.add_close span{
		display: inline-block;
		width: 19px;
		height: 19px;
		background: url(~assets/img/registericon.png) no-repeat;
		background-position: -49px -114px;
		cursor:pointer;
		margin-right: 10px;
	}
	.reg_form,
	.reg_form2{
		width: 100%;
		height: 90%;
	}
	/*每个输入框*/
	.form_item,
	.form2_item{
		position: relative;
	  border: solid 1px #ddd;
	  width: 400px;
	  height: 45px;
	  margin: 0 auto;
	  margin-bottom: 3px;
	}
	/*划过框变色*/
	.form_item:hover,
	.form2_item:hover{
    border: 1px solid rgb(153,153,153);
	}
	/*label*/
	.sku,.title,.price,.shopname,.comments,.pic,.url,.type,
	.sku2,.title2,.price2,.shopname2,.comments2,.pic2,.url2,.type2{
		float: left;
    width: 107px;
    height: 45px;
    line-height: 45px;
    padding-left: 20px;
    font-size: 14px;		
	}
	.sku,.sku2{
		letter-spacing:1.5px;
	}
	.title,.price,.type,
	.title2,.price2,.type2{
		letter-spacing:27px;
	}
	.shopname,.comments,
	.shopname2,.comments2{
		letter-spacing:7px;
	}
	/*用户input*/
	.form_item .field,
	.form2_item .field{
    border: 0 none;
    font-size: 14px;
    width: 250px;
    height: 42px;
    padding-bottom: 11px;
    padding-left: 20px;
    padding-top: 11px;
    outline: none;
	}
	
	/*注册按钮*/
	.update_btn,
	.add_btn{
		width: 400px;
		margin: 0 auto;
	}
	.btn_update,
	.btn_add{
    width: 100%;
    height: 54px;
    line-height: 54px;
    text-align: center;
    color: #fff;
    background: #e2231a;
    border: 0;
    font-size: 16px;
    font-family: "Microsoft YaHei","Hiragino Sans GB";
    cursor: pointer;
    outline: none;
	}
	/*注册按钮*/
	.btn_update:hover,
	.btn_add:hover{
		background: #c81623;
    color: #eababc;
	}
	/*加载动画*/
	@keyframes loading {
	  0% {
	      transform: rotate(0deg);
	  }
	  50% {
	      transform: rotate(180deg);
	  }
	  100% {
	      transform: rotate(360deg);
	  }
	}
</style>