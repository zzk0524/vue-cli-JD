<template>
	<div class="profile">
		<div class="profile_header">
			<span class="headline">
				<a href="javascript:void(0)">
					<span>管理员信息</span>
				</a>
			</span>
		</div>
		<div class="profile_body">
			<div class="thead">
				<div class="column a_id">管理员ID</div>
				<div class="column a_account">账号</div>
				<div class="column a_password">密码</div>
				<div class="column a_update">修改</div>
			</div>
			<div class="list">
				<div class="admin_item_list clearfix" v-for="item in allAdmin">
					<div class="cell p_id">
						<span>{{item.id}}</span>
					</div>
					<div class="cell p_account">
						<span>{{item.account}}</span>
					</div>
					<div class="cell p_password">
						<span>{{item.password}}</span>
					</div>
					<div class="cell p_update">
						<a href="javascript:void(0)" @click="updateClick()">修改</a>
					</div>
				</div>
				<div class="admin_shade divnone" id="admin_shade">
					<div class="admin_form">
						<div class="close">
							<span @click="closeClick"></span>
						</div>
						<div class="reg_form">
							 <form>
								<div class="form_item" id="form_item_admin_account">
									<label class="account" for="admin_account">账号</label>
									<input id="admin_account" v-model="form.account" type="text" class="field" maxlength="20" required="required" autocomplete="off">
								</div>
								<div class="form_item" id="form_item_admin_password">
									<label class="password" for="admin_password">密码</label>
									<input id="admin_password" v-model="form.password" type="text" class="field" maxlength="20" required="required" autocomplete="off">
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
		name:"Profile",
		data(){
			return{
				allAdmin:[],
				form: {
					id:'',
					account:'',
					password:''
				},
				form1: {
					id:'',
					account:'',
					password:''
				}
			}
		},
		methods:{
			closeClick(){
				let adminShade = document.getElementById("admin_shade");
				adminShade.classList.add("divnone");//打开表单
			},
			updateClick(){//点击修改按钮
				let adminShade = document.getElementById("admin_shade");
				adminShade.classList.remove("divnone");//打开表单
				this.form.id = this.allAdmin[0].id;//把旧的数据放进去
				this.form.account = this.allAdmin[0].account;
				this.form.password = this.allAdmin[0].password;
				this.form1.id = this.form.id;//备份一遍旧数据
				this.form1.account = this.form.account;
				this.form1.password = this.form.password;
			},
			updateBtn(){//立即修改
				if(this.form.account&&this.form.password){//不能为空
					if(this.form.account==this.form1.account&&this.form.password==this.form1.password){//为原始数据
						alert("与原始数据相同!");
					}else{
						if(this.form.account.length<6){//账号1-5位
							let _this = this;
							let oAjax = null;
							if(window.XMLHttpRequest){
								oAjax = new XMLHttpRequest();
							}else{
								oAjax = new ActiveXObject("Microsoft.XMLHTTP");
							}
							oAjax.open('POST','http://127.0.0.1/goods/updateAdmin',true);
							oAjax.setRequestHeader("Content-type","application/json");
							oAjax.send(JSON.stringify(_this.form));
							oAjax.onreadystatechange=function(){
							  if(oAjax.readyState==4){
							    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
							      //对响应进行解析
							      let admin=JSON.parse(oAjax.responseText);
							      //重新查询一遍
							      if(admin.code == 1){//更新成功
							      	_this.closeClick();//关闭表单
							      	_this.selectAdmin();//查询所有用户
							      }
							    }else{
							      //对响应进行解析
							      alert("服务器错误");
							    }
							  }
							}
						}else{
							alert("账号需要1~5位!");
						}
					}
				}else{
					alert("请填写完整!");
				}
			},
			selectAdmin(){//查询管理员
				let _this = this;
				let oAjax = null;
				if(window.XMLHttpRequest){
					oAjax = new XMLHttpRequest();
				}else{
					oAjax = new ActiveXObject("Microsoft.XMLHTTP");
				}
				oAjax.open('GET','http://127.0.0.1/goods/selectAdmin',true);
				oAjax.send(null);
				oAjax.onreadystatechange=function(){
				  if(oAjax.readyState==4){
				    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
				      //对响应进行解析
				      let admin=JSON.parse(oAjax.responseText);				      
				      if(admin.code == 1){//查询成功
				      	_this.allAdmin = [];
				      	_this.allAdmin = admin.data;
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
			this.selectAdmin();
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
	.profile{
		height: 100%;
	}
	.profile_header{
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
	/*内容*/
	.profile_body{
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
	.a_id{
		width: 200px;
		margin-left: 5px;
	}
	.a_account,.a_password{
		width: 300px;
	}
	.a_update{
		width: 100px;
	}
	.list{
		width: 100%;
		height: 80%;
		overflow: auto;
	}
	.admin_item_list{
		margin: 0 5px 5px 5px;
		border-bottom: 1px #e9e9e9 solid;
	}
	.admin_item_list:hover{
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
		width: 200px;
		text-indent: 10px;
	}
	.p_account,
	.p_password{
		width: 300px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
	.p_update{
		width: 100px;
	}
	.p_update a{
		outline: none;
	}
	.p_update a:hover{
		color: #E2231A;
	}
	/*表单*/
	.admin_shade{
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
	.admin_form{
		width: 500px;
		height: 400px;
		background-color: #fff;
		border: 1px rgb(178,178,178) solid;
		border-radius: 5px;
		box-shadow: 0px 0px 2px 2px rgb(178,178,178);
	}
	.close{
		width: 100%;
		height: 30px;
		margin-top: 10px;
		display: flex;
		justify-content: flex-end;
		align-items: center;
	}
	.close span{
		display: inline-block;
		width: 19px;
		height: 19px;
		background: url(~assets/img/registericon.png) no-repeat;
		background-position: -49px -114px;
		cursor:pointer;
		margin-right: 10px;
	}
	.reg_form{
		width: 100%;
		height: 90%;
		padding-top: 40px;
	}
	/*每个输入框*/
	.form_item{
		position: relative;
	  border: solid 1px #ddd;
	  width: 400px;
	  height: 54px;
	  margin: 0 auto;
	  margin-bottom: 30px;
	}
	/*划过框变色*/
	.form_item:hover{
    border: 1px solid rgb(153,153,153);
	}
	.account,
	.password{
		float: left;
    width: 107px;
    height: 50px;
    line-height: 50px;
    padding-left: 20px;
    font-size: 14px;		
    letter-spacing: 10px;
	}

	/*用户input*/
	.form_item .field{
    border: 0 none;
    font-size: 14px;
    width: 230px;
    height: 46px;
    padding-bottom: 11px;
    padding-left: 20px;
    padding-top: 16px;
    outline: none;
	}
	/*注册按钮*/
	.update_btn{
		width: 400px;
		margin: 0 auto;
	}
	.btn_update{
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
	.btn_update:hover{
		background: #c81623;
    color: #eababc;
	}
</style>