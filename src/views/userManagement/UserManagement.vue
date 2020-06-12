<template>
	<div class="user_management">
		<div class="user_management_header">
			<span class="headline">
				<a href="javascript:void(0)">
					<span>全部用户</span>
					<span class="number">{{userNumber}}</span>
				</a>
			</span>
			<span class="add_user">
				<a href="javascript:void(0)" @click="addUser()">增加用户</a>
			</span>
			<div class="add_shade divnone" id="add_shade">
				<div class="add_form">
					<div class="add_close">
						<span @click="addCloseClick()"></span>
					</div>
					<div class="reg_form2">
						<form>
							<div class="form2_item" id="form2_item_account">
								<label class="account2" for="account2">用户名</label>
								<input id="account2" v-model="form2.account" type="text" class="field" maxlength="20" required="required" autocomplete="off">
							</div>
							<div class="form2_item_sex">
								<label for="male2" class="sex2">男</label>
								<input type="radio" id="male2" value="男" name="sex2" v-model="form2.sex">
								<label for="female2" class="sex2">女</label>
								<input type="radio" id="female2" value="女" name="sex2" v-model="form2.sex">
							</div>
							<div class="form2_item" id="form2_item_password">
								<label class="password2" for="password2">密码</label>
								<input id="password2" v-model="form2.password" type="text" class="field" maxlength="20" required="required" autocomplete="off">
							</div>
							<div class="form2_item_favourite_title"><span>选择感兴趣的内容：</span></div>
							<div class="form2_item_favourite">
								<label><input name="favourite2" type="checkbox" value="潮流服饰" v-model="favorite2"/>潮流服饰</label> 
								<label><input name="favourite2" type="checkbox" value="文学读物" v-model="favorite2"/>文学读物</label> 
								<label><input name="favourite2" type="checkbox" value="电子设备" v-model="favorite2"/>电子设备</label> 
								<label><input name="favourite2" type="checkbox" value="居家生活" v-model="favorite2"/>居家生活</label><br>
								<label><input name="favourite2" type="checkbox" value="美味小吃" v-model="favorite2"/>美味小吃</label>
								<label><input name="favourite2" type="checkbox" value="萌宠乐园" v-model="favorite2"/>萌宠乐园</label>
								<label><input name="favourite2" type="checkbox" value="珠宝配饰" v-model="favorite2"/>珠宝配饰</label>
								<label><input name="favourite2" type="checkbox" value="玩具城" v-model="favorite2"/>玩具城</label>					
							</div>  
							<div class="add_btn">
								<button type="button" class="btn_add" @click="addBtn()">立即增加</button>
							</div>
						</form> 
					</div>
				</div>
			</div>
		</div>
		<div class="user_management_body">
			<div class="thead">
				<div class="column t_id">用户ID</div>
				<div class="column t_account">用户名</div>
				<div class="column t_sex">性别</div>
				<div class="column t_password">密码</div>
				<div class="column t_favourite">感兴趣的内容</div>
				<div class="column t_update">修改</div>
				<div class="column t_delete">删除</div>
			</div>
			<div class="list">
				<div class="user_item_list clearfix" v-for="(item,index) in allUser">
					<div class="cell p_id">
						<span>{{item.id}}</span>
					</div>
					<div class="cell p_account" :title="item.account">
						<span>{{item.account}}</span>
					</div>
					<div class="cell p_sex">
						<span>{{item.sex}}</span>
					</div>
					<div class="cell p_password" :title="item.password">
						<span>{{item.password}}</span>
					</div>
					<div class="cell p_favourite" :title="item.favourite">
						<span>{{item.favourite}}</span>
					</div>
					<div class="cell p_update">
						<a href="javascript:void(0)" :data-index="getIndex(index)"  @click="updateClick($event)">修改</a>
					</div>
					<div class="cell p_delete">
						<a href="javascript:void(0)" :data-index="getIndex(index)"  @click="deleteClick($event)">删除</a>
					</div>
				</div>
				<div class="update_shade divnone" id="update_shade">
					<div class="update_form">
						<div class="close">
							<span @click="closeClick"></span>
						</div>
						<div class="reg_form">
							 <form>
								<div class="form_item" id="form_item_account">
									<label class="account" for="account">用户名</label>
									<input id="account" v-model="form.account" type="text" class="field" maxlength="20" required="required" autocomplete="off">
								</div>
								<div class="form_item_sex">
									<label for="male" class="sex">男</label>
									<input type="radio" id="male" value="男" name="sex" v-model="form.sex">
									<label for="female" class="sex">女</label>
									<input type="radio" id="female" value="女" name="sex" v-model="form.sex">
								</div>
								<div class="form_item" id="form_item_password">
									<label class="password" for="password">密码</label>
									<input id="password" v-model="form.password" type="text" class="field" maxlength="20" required="required" autocomplete="off">
								</div>
								<div class="form_item_favourite_title"><span>选择感兴趣的内容：</span></div>
								<div class="form_item_favourite">
									<label><input name="favourite" type="checkbox" value="潮流服饰" v-model="favorite"/>潮流服饰</label> 
									<label><input name="favourite" type="checkbox" value="文学读物" v-model="favorite"/>文学读物</label> 
									<label><input name="favourite" type="checkbox" value="电子设备" v-model="favorite"/>电子设备</label> 
									<label><input name="favourite" type="checkbox" value="居家生活" v-model="favorite"/>居家生活</label><br>
									<label><input name="favourite" type="checkbox" value="美味小吃" v-model="favorite"/>美味小吃</label>
									<label><input name="favourite" type="checkbox" value="萌宠乐园" v-model="favorite"/>萌宠乐园</label>
									<label><input name="favourite" type="checkbox" value="珠宝配饰" v-model="favorite"/>珠宝配饰</label>
									<label><input name="favourite" type="checkbox" value="玩具城" v-model="favorite"/>玩具城</label>					
								</div>  
								<div class="update_btn"><button type="button" class="btn_update" @click="updateBtn">立即修改</button></div>
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
		name:"UserManagement",
		data(){
			return{
				allUser:[],
				form: {
					id:'',
					account:'',
					sex:'',
					password:'',
					favourite:''
				},
				form1:{//存旧数据,备用
					id:'',
					account:'',
					sex:'',
					password:'',
					favourite:''
				},
				form2:{
					id:'',
					account:'',
					sex:'',
					password:'',
					favourite:''
				},
				favorite:[],
				favorite2:[],
				userNumber:''
			}
		},
		methods:{
			getIndex(index){
				return index+1;
			},
			updateClick(event){//点击修改按钮
				let updateShade = document.getElementById("update_shade");
				updateShade.classList.remove("divnone");//打开表单
				let index = event.target.getAttribute("data-index");//这是第几条
				this.form.id = this.allUser[index-1].id;//把旧的数据放进去
				this.form.account = this.allUser[index-1].account;
				this.form.password = this.allUser[index-1].password;
				this.form.sex = this.allUser[index-1].sex;
				this.favorite = this.allUser[index-1].favourite.split(",");//数组形式
				this.form1.id = this.form.id;//备份一遍旧数据
				this.form1.account = this.form.account;
				this.form1.password = this.form.password;
				this.form1.sex = this.form.sex;
				this.form1.favourite = this.favorite.join(",");//字符串形式
			},
			deleteClick(event){//点击删除按钮
				//console.log(event.target.getAttribute("data-index"));
				let index = event.target.getAttribute("data-index");//保存这是第几个
				//this.allUser[index-1].id
				//发送请求
				let _this = this;
				let oAjax = null;
				if(window.XMLHttpRequest){
					oAjax = new XMLHttpRequest();
				}else{
					oAjax = new ActiveXObject("Microsoft.XMLHTTP");
				}
				oAjax.open('POST','http://127.0.0.1/goods/adminDeleteUser',true);
				oAjax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				oAjax.send("id="+_this.allUser[index-1].id);
				oAjax.onreadystatechange=function(){
				  if(oAjax.readyState==4){
				    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
				      //对响应进行解析
				      let adminUser=JSON.parse(oAjax.responseText);
				      //重新查询一遍
				      if(adminUser.code == 1){//删除成功
				      	_this.selectUser();//查询所有用户
				      }
				    }else{
				      //对响应进行解析
				      alert("服务器错误");
				    }
				  }
				}
			},
			closeClick(){
				let updateShade = document.getElementById("update_shade");
				updateShade.classList.add("divnone");
			},
			addCloseClick(){
				let addShade = document.getElementById("add_shade");
				addShade.classList.add("divnone");
			},
			selectUser(){//查询所有用户
				let _this = this;
				let oAjax = null;
				if(window.XMLHttpRequest){
					oAjax = new XMLHttpRequest();
				}else{
					oAjax = new ActiveXObject("Microsoft.XMLHTTP");
				}
				oAjax.open('GET','http://127.0.0.1/goods/adminSelectUser',true);
				oAjax.send(null);
				oAjax.onreadystatechange=function(){
				  if(oAjax.readyState==4){
				    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
				      //对响应进行解析
				      let adminUser=JSON.parse(oAjax.responseText);				      
				      if(adminUser.code == 1){//查询成功
				      	_this.allUser = [];
				      	_this.allUser = adminUser.data;
				      	//console.log(_this.allUser);
				      	_this.userNumber = _this.allUser.length;//用户数量
				      }
				    }else{
				      //对响应进行解析
				      alert("服务器错误");
				    }
				  }
				}
			},
			updateBtn(){//立即修改
				//判断不能为空,不能和以前的一样
				if(this.form.account&&this.form.password&&this.form.sex&&this.favorite.join(",")){//都不为空
					if(this.form.account == this.form1.account&&this.form.sex == this.form1.sex&&this.form.password == this.form1.password&&this.favorite.join(",") == this.form1.favourite){//为原始数据
						alert("与原始数据相同!");
					}else{
						let m = false;
						this.allUser.forEach((currentValue)=>{
							if(currentValue.id!=this.form.id&&currentValue.account==this.form.account){
								m = true;
							}
						})
						if(m){//用户名重复
							alert("用户名重复");
						}else{//发送请求
							this.form.favourite = this.favorite.join(",");
							let _this = this;
							let oAjax = null;
							if(window.XMLHttpRequest){
								oAjax = new XMLHttpRequest();
							}else{
								oAjax = new ActiveXObject("Microsoft.XMLHTTP");
							}
							oAjax.open('POST','http://127.0.0.1/goods/adminUpdateUser',true);
							oAjax.setRequestHeader("Content-type","application/json");
							oAjax.send(JSON.stringify(_this.form));
							oAjax.onreadystatechange=function(){
							  if(oAjax.readyState==4){
							    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
							      //对响应进行解析
							      let adminUser=JSON.parse(oAjax.responseText);
							      //重新查询一遍
							      if(adminUser.code == 1){//更新成功
							      	_this.closeClick();//关闭表单
							      	_this.selectUser();//查询所有用户
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
			addUser(){//增加一个用户
				let addShade = document.getElementById("add_shade");
				addShade.classList.remove("divnone");//打开表单
				this.form2.id = "";
				this.form2.account = "";
				this.form2.sex = "男";//设置默认值
				this.form2.password = "";
				this.favorite2 = ["潮流服饰"];//设置默认值
			},
			addBtn(){//立即增加
				if(this.form2.account!=""&&this.form2.password!=""&&this.form2.sex!=""&&this.favorite2.join(",")!=""){//都不为空
					let m = false;
					this.allUser.forEach((currentValue)=>{
						if(currentValue.account==this.form2.account){
							m = true;
						}
					})
					if(m){//用户名重复
						alert("用户名重复");
					}else{//发送请求
						this.form2.favourite = this.favorite2.join(",");
						let _this = this;
						let oAjax = null;
						if(window.XMLHttpRequest){
							oAjax = new XMLHttpRequest();
						}else{
							oAjax = new ActiveXObject("Microsoft.XMLHTTP");
						}
						oAjax.open('POST','http://127.0.0.1/goods/adminAddUser',true);
						oAjax.setRequestHeader("Content-type","application/json");
						oAjax.send(JSON.stringify(_this.form2));
						oAjax.onreadystatechange=function(){
						  if(oAjax.readyState==4){
						    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
						      //对响应进行解析
						      let adminUser=JSON.parse(oAjax.responseText);
						      //重新查询一遍
						      if(adminUser.code == 1){//增加成功
						      	_this.addCloseClick();//关闭表单
						      	_this.selectUser();//查询所有用户
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
			}
		},
		mounted(){
			this.selectUser();//页面一加载就查询所有用户
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
	.user_management{
		height: 100%;
	}
	.user_management_header{
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
	.add_user{
		display: inline-block;
		width: 70px;
		height: 30px;
		float: right;
		margin-right:80px; 
	}
	.add_user a{
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
	.add_user a:hover{
		border: 1px #E2231A solid;
		color: #E2231A;
		border-radius: 5px;
	}
	/*内容*/
	.user_management_body{
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
	.column{
    float: left;
    font-size: 12px;
    height: 32px;
    line-height: 32px;
	}
	.t_id{
		width: 70px;
		margin-left: 5px;
	}
	.t_account{
		width: 200px;
	}
	.t_sex{
		width: 70px;
	}
	.t_password{
		width: 200px
	}
	.t_favourite{
		width: 350px;
	}
	.t_update,
	.t_delete{
		width: 70px;
	}
	.list{
		width: 100%;
		height: 80%;
		overflow: auto;
	}
	.user_item_list{
		margin: 0 5px 5px 5px;
		border-bottom: 1px #e9e9e9 solid;
	}
	.user_item_list:hover{
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
	.p_account{
		width: 200px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
	.p_sex{
		width: 70px;
	}
	.p_password{
		width: 200px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
	.p_favourite{
		width: 350px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
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
	.close,
	.add_close{
		width: 100%;
		height: 30px;
		margin-top: 10px;
		display: flex;
		justify-content: flex-end;
		align-items: center;
	}
	/*叉号图标*/
	.close span,
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
		padding-top: 40px;
	}
	/*每个输入框*/
	.form_item,
	.form2_item{
		position: relative;
	  border: solid 1px #ddd;
	  width: 400px;
	  height: 54px;
	  margin: 0 auto;
	}
	/*划过框变色*/
	.form_item:hover,
	.form2_item:hover{
    border: 1px solid rgb(153,153,153);
	}
	/*label*/
	.account,
	.password,
	.account2,
	.password2{
		float: left;
    width: 107px;
    height: 50px;
    line-height: 50px;
    padding-left: 20px;
    font-size: 14px;		
	}
	/*用户名间距*/
	.account,
	.account2{
		letter-spacing:14px;
	}
	/*设置密码间距*/
	.password,
	.password2{
		letter-spacing:29px;
	}
	/*用户input*/
	.form_item .field,
	.form2_item .field{
    border: 0 none;
    font-size: 14px;
    width: 230px;
    height: 46px;
    padding-bottom: 11px;
    padding-left: 20px;
    padding-top: 16px;
    outline: none;
	}
	/*性别*/
	.sex,
	.sex2{
		font-size: 14px;
		margin-right: 5px;
	}
	/*性别*/
	.form_item_sex,
	.form2_item_sex{
		position: relative;
	  border: solid 1px transparent;
	  width: 400px;
	  height: 54px;
	  line-height: 54px;
	  padding-left: 65px;
	}
	/*男性*/
	#male,
	#male2{
		margin-right: 15px;
	}
	/*爱好*/
	.form_item_favourite,
	.form2_item_favourite{
	  position: relative;
	  border: solid 1px transparent;
	  width: 406px;
	  height: 96px;
	  line-height: 40px;
	  padding-left: 20px;
	  font-size: 12px;
	  margin: 0 auto;
	}
	.form_item_favourite label,
	.form2_item_favourite label{
		margin-right: 33px;
	}
	.form_item_favourite label input,
	.form2_item_favourite label input{
		vertical-align: middle;
		margin-right: 2px;
	}
	.form_item_favourite_title,
	.form2_item_favourite_title{
		width: 400px;
		margin: 0 auto;
		margin-top: 10px;
		font-size: 14px;
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
</style>