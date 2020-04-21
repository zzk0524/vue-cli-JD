<template>
	<div class="maincontainer">
		<div class="reg_form">
			<form>
				<div class="form_item" id="form_item_account">
					<label class="account" for="account">用户名</label>
					<input id="account" v-model="form.account" type="text" class="field" maxlength="20" placeholder="您的账户名和登录名" required="required" @focus="accountfocus($event)" @blur="accountblur($event)" autocomplete="off">
					<i class="i_status bas divnone" id="account_status"></i>
					<i class="i_cancel divnone" id="account_cancel" @mousedown="accountcancel"></i>
				</div>
				<div class="input_tip">
					<span class="form_account_tip">
						<i class="i_tip divnone" id="form_account_i_tip"></i>
						<span id="form_account_tip"></span>
					</span>
				</div>
				<div class="form_item_sex">
					<label for="male" class="sex">男</label>
					<input type="radio" id="male" value="男" name="sex" v-model="form.sex">
					<label for="female" class="sex">女</label>
					<input type="radio" id="female" value="女" name="sex" v-model="form.sex">
				</div>
				<div class="form_item" id="form_item_password">
					<label class="password" for="password">设置密码</label>
					<input id="password" v-model="form.password" type="password" class="field" maxlength="20" placeholder="建议使用两种或两种以上字符组合" required="required" @focus="passwordfocus($event)" @blur="passwordblur($event)" autocomplete="off">
					<i class="i_status bas divnone" id="password_status"></i>
					<i class="i_cancel divnone" id="password_cancel" @mousedown="passwordcancel"></i>
				</div>
				<div class="input_tip">
					<span class="form_password_tip">
						<i class="i_tip divnone" id="form_password_i_tip"></i>
						<span id="form_password_tip"></span>
					</span>
				</div>
				<div class="form_item" id="form_item_repassword">
					<label class="repassword" for="repassword">确认密码</label>
					<input id="repassword" v-model="form.repassword" type="password" class="field" maxlength="20" placeholder="请再次输入密码" required="required" @focus="repasswordfocus($event)" @blur="repasswordblur($event)" autocomplete="off">
					<i class="i_status bas divnone" id="repassword_status"></i>
					<i class="i_cancel divnone" id="repassword_cancel" @mousedown="repasswordcancel"></i>
				</div>
				<div class="input_tip">
					<span class="form_repassword_tip">
						<i class="i_tip divnone" id="form_repassword_i_tip"></i>
						<span id="form_repassword_tip"></span>
					</span>
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
				<!-- 裤子上衣鞋      图书      手机     个护清洁汽车用品      食品      宠物      珠宝      玩具 -->
				        
				<div><button type="button" class="btn_register" @click="registerbtn">立即注册</button></div>
			</form>
		</div>
	</div>
</template>
<script>
	export default{
		name:"MainContainer",
		data(){
			return{
				form: {
					account:'',
					sex:'男',
					password:'',
					repassword:'',
					favourite:''
				},
				favorite:['潮流服饰'],
				judge:false,
				judge1:false,
				judge2:false,
				accountnumber:[]//通过ajax存入所有的用户名
			}
		},
		methods:{
			accountfocus($event){
				let formitemaccount = this.getelement("form_item_account"),
						formaccounttip = this.getelement("form_account_tip"),
						formaccountitip = this.getelement("form_account_i_tip"),
						account = this.getelement("account"),
						accountstatus = this.getelement("account_status"),
						accountcancel = this.getelement("account_cancel");
				let pattern = /^[\u4e00-\u9fff\w]{5,16}$/;//用户名的正则表达式
				formitemaccount.classList.remove("slider_border_color");//边框颜色
				formitemaccount.classList.add("focus_border_color");//边框颜色
				if($event.target.value!=""){
					if(pattern.exec($event.target.value)){	
						formaccountitip.classList.add("divnone");//隐藏提示图标
						formaccounttip.innerHTML = "";//移除文字提示
						accountcancel.classList.remove("divnone");//显示叉号
						accountstatus.classList.add("divnone");//隐藏对号
					}else{
						formaccountitip.classList.remove("divnone");//显示提示图标
						formaccountitip.classList.remove("tip_position_gray");//移除灰色图标
						formaccountitip.classList.add("tip_position_orange");//添加橘色图标
						formaccounttip.innerHTML = "6-16位中文、字母、数字或'_'的组合";//提示文字
						formaccounttip.classList.add("form_tip_orange");//添加文字颜色
						accountcancel.classList.remove("divnone");//显示叉号
						accountstatus.classList.add("divnone");//移除对号
					}	
				}else{
					formaccountitip.classList.remove("divnone");//显示提示图标
					formaccountitip.classList.remove("tip_position_orange");//移除橘色图标
					formaccountitip.classList.add("tip_position_gray");//添加灰色图标
					formaccounttip.innerHTML = "6-16位中文、字母、数字或'_'的组合";//文字提示
					formaccounttip.classList.remove("form_tip_orange");//移除文字颜色
					accountcancel.classList.add("divnone");//移除叉号
					accountstatus.classList.add("divnone");//移除对号
				}
				account.onkeydown = function(){
					accountcancel.classList.remove("divnone");//显示叉号
				}
			},
			accountblur($event){
				let formitemaccount = this.getelement("form_item_account"),
						formaccounttip = this.getelement("form_account_tip"),
						formaccountitip = this.getelement("form_account_i_tip"),
						accountstatus = this.getelement("account_status"),
						accountcancel = this.getelement("account_cancel");
				let accountjudge = false;
				let pattern = /^[\u4e00-\u9fff\w]{6,16}$/;//用户名的正则表达式
				formitemaccount.classList.remove("focus_border_color");//改边框的颜色
				formitemaccount.classList.add("slider_border_color");//改边框的颜色
				if($event.target.value!=""){
					if(pattern.exec($event.target.value)){
						this.accountnumber.forEach(function(currentValue){
							if(currentValue.account == $event.target.value){
								accountjudge = true;
							}
						});
						if(accountjudge){//用户名重复
							formaccountitip.classList.remove("divnone");//显示提示图标
							formaccountitip.classList.remove("tip_position_gray");//移除灰色图标
							formaccountitip.classList.add("tip_position_orange");//添加橘色图标
							formaccounttip.innerHTML = "用户名重复";//提示文字
							formaccounttip.classList.add("form_tip_orange");//添加文字颜色
							accountcancel.classList.add("divnone");//移除叉号图标
							accountstatus.classList.add("divnone");//隐藏对号
							this.judge = false;
						}else{//用户名正确
							formaccountitip.classList.add("divnone");//隐藏提示图标
							formaccounttip.innerHTML = "";//移除文字提示
							accountcancel.classList.add("divnone");//移除叉号图标
							accountstatus.classList.remove("divnone");//显示对号
							this.judge = true;
						}
					}else{
						formaccountitip.classList.remove("divnone");//显示提示图标
						formaccountitip.classList.remove("tip_position_gray");//移除灰色图标
						formaccountitip.classList.add("tip_position_orange");//添加橘色图标
						formaccounttip.innerHTML = "6-16位中文、字母、数字或'_'的组合";//提示文字
						formaccounttip.classList.add("form_tip_orange");//添加文字颜色
						accountcancel.classList.add("divnone");//移除叉号图标
						accountstatus.classList.add("divnone");//隐藏对号
						this.judge = false;
					}
				}else{
					formaccountitip.classList.remove("divnone");//显示提示图标
					formaccountitip.classList.remove("tip_position_gray");//移除灰色图标
					formaccountitip.classList.add("tip_position_orange");//添加橘色图标
					formaccounttip.innerHTML = "用户名不能为空";//移除文字提示
					formaccounttip.classList.add("form_tip_orange");//添加文字颜色
					accountcancel.classList.add("divnone");//移除叉号图标
					accountstatus.classList.add("divnone");//移除对号
					this.judge = false;
				}	
			},
			passwordfocus($event){
				let formitempassword = this.getelement("form_item_password"),
						formpasswordtip = this.getelement("form_password_tip"),
						formpassworditip = this.getelement("form_password_i_tip"),
						password = this.getelement("password"),
						passwordstatus = this.getelement("password_status"),
						passwordcancel = this.getelement("password_cancel");
				let pattern = /^\S{6,20}$/;/*6-20位*/
				formitempassword.classList.remove("slider_border_color");//边框颜色
				formitempassword.classList.add("focus_border_color");//边框颜色
				if($event.target.value!=""){
					if(pattern.exec($event.target.value)){	
						formpassworditip.classList.add("divnone");//隐藏提示图标
						formpasswordtip.innerHTML = "";//移除文字提示
						passwordcancel.classList.remove("divnone");//显示叉号
						passwordstatus.classList.add("divnone");//隐藏对号
					}else{
						formpassworditip.classList.remove("divnone");//显示提示图标
						formpassworditip.classList.remove("tip_position_gray");//移除灰色图标
						formpassworditip.classList.add("tip_position_orange");//添加橘色图标
						formpasswordtip.innerHTML = "6-20位字母、数字或符号";//添加提示文字
						formpasswordtip.classList.add("form_tip_orange");//添加文字颜色
						passwordcancel.classList.remove("divnone");//显示叉号
						passwordstatus.classList.add("divnone");//移除对号
					}	
				}else{
					formpassworditip.classList.remove("divnone");//显示提示图标
					formpassworditip.classList.remove("tip_position_orange");//移除橘色图标
					formpassworditip.classList.add("tip_position_gray");//添加灰色图标
					formpasswordtip.innerHTML = "6-20位字母、数字或符号";//添加文字提示
					formpasswordtip.classList.remove("form_tip_orange");//移除文字颜色
					passwordcancel.classList.add("divnone");//移除叉号
					passwordstatus.classList.add("divnone");//移除对号
				}
				password.onkeydown = function(){
					passwordcancel.classList.remove("divnone");//显示叉号
				}
			},
			passwordblur($event){
				let pattern = /^\S{6,20}$/,/*6-20位*/ 
					  pattern1 = /^[a-zA-Z]{6,20}$/,//一级强度纯字母
						pattern2 = /^\d{6,20}$/,//一级强度纯数字
						pattern3 = /^[^a-zA-Z0-9]{6,20}$/,//一级强度纯符号
						pattern4 = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/,//数字和字母
						pattern5 = /^(?![\W_]+$)(?![a-zA-Z]+$)[a-zA-Z\W_]{6,20}$/,//字母和字符
						pattern6 = /^(?![\W_]+$)(?![0-9]+$)[0-9\W_]{6,20}$/,//数字和字符
						pattern7 = /^(?![\W_]+$)(?![0-9]+$)(?![a-zA-Z]+$)[a-zA-Z0-9\W_]{6,20}$/;//字母数字和字符
				let formitempassword = this.getelement("form_item_password"),
						formpasswordtip = this.getelement("form_password_tip"),
						formpassworditip = this.getelement("form_password_i_tip"),
						passwordstatus = this.getelement("password_status"),
						passwordcancel = this.getelement("password_cancel");
				formitempassword.classList.remove("focus_border_color");//改边框的颜色
				formitempassword.classList.add("slider_border_color");//改边框的颜色
				if($event.target.value!=""){
					if(pattern.exec($event.target.value)){
						if(pattern1.exec($event.target.value)||pattern2.exec($event.target.value)||pattern3.exec($event.target.value)){//一级强度验证
							formpassworditip.classList.add("divnone");//隐藏提示图标
							formpasswordtip.innerHTML = "";//移除文字提示
							passwordcancel.classList.add("divnone");//移除叉号图标
							passwordstatus.classList.remove("divnone");//显示图标
							passwordstatus.classList.remove("bas");//移除基础
							passwordstatus.classList.remove("zhong");//移除中
							passwordstatus.classList.remove("qiang");//移除强
							passwordstatus.classList.add("ruo");//显示弱
							this.judge1 = true;
						}else if(!pattern1.exec($event.target.value)&&!pattern2.exec($event.target.value)&&!pattern3.exec($event.target.value)&&(pattern4.exec($event.target.value)||pattern5.exec($event.target.value)||pattern6.exec($event.target.value))){
							formpassworditip.classList.add("divnone");//隐藏提示图标
							formpasswordtip.innerHTML = "";//移除文字提示
							passwordcancel.classList.add("divnone");//移除叉号图标
							passwordstatus.classList.remove("divnone");//显示图标
							passwordstatus.classList.remove("bas");//移除基础
							passwordstatus.classList.add("zhong");//显示中
							passwordstatus.classList.remove("qiang");//移除强
							passwordstatus.classList.remove("ruo");//移除弱
							this.judge1 = true;
						}else if(!pattern1.exec($event.target.value)&&!pattern2.exec($event.target.value)&&!pattern3.exec($event.target.value)&&!pattern4.exec($event.target.value)&&!pattern5.exec($event.target.value)&&!pattern6.exec($event.target.value)&&pattern7.exec($event.target.value)){
							formpassworditip.classList.add("divnone");//隐藏提示图标
							formpasswordtip.innerHTML = "";//移除文字提示
							passwordcancel.classList.add("divnone");//移除叉号图标
							passwordstatus.classList.remove("divnone");//显示图标
							passwordstatus.classList.remove("bas");//移除基础
							passwordstatus.classList.remove("zhong");//移除中
							passwordstatus.classList.add("qiang");//显示强
							passwordstatus.classList.remove("ruo");//移除弱
							this.judge1 = true;
						}
					}else{
						formpassworditip.classList.remove("divnone");//显示提示图标
						formpassworditip.classList.remove("tip_position_gray");//移除灰色图标
						formpassworditip.classList.add("tip_position_orange");//添加橘色图标
						formpasswordtip.innerHTML = "6-20位字母、数字或符号";//提示文字
						formpasswordtip.classList.add("form_tip_orange");//添加文字颜色
						passwordcancel.classList.add("divnone");//移除叉号图标
						passwordstatus.classList.add("divnone");//隐藏对号
						this.judge1 = false;
					}
				}else{
					formpassworditip.classList.remove("divnone");//隐藏
					formpassworditip.classList.remove("tip_position_gray");//移除灰色图标
					formpassworditip.classList.add("tip_position_orange");//移除橘色图标
					formpasswordtip.innerHTML = "密码不能为空";//移除文字提示
					formpasswordtip.classList.add("form_tip_orange");//添加文字颜色
					passwordcancel.classList.add("divnone");//移除叉号图标
					passwordstatus.classList.add("divnone");//移除对号
					this.judge1 = false;
				}	
			},
			repasswordfocus($event){
				let formitemrepassword = this.getelement("form_item_repassword"),
						formrepasswordtip = this.getelement("form_repassword_tip"),
						formrepassworditip = this.getelement("form_repassword_i_tip"),
						repassword = this.getelement("repassword"),
						repasswordstatus = this.getelement("repassword_status"),
						repasswordcancel = this.getelement("repassword_cancel"),
						password = this.getelement("password");
				formitemrepassword.classList.remove("slider_border_color");//边框颜色
				formitemrepassword.classList.add("focus_border_color");//边框颜色
				if($event.target.value!=""){
					formrepassworditip.classList.remove("divnone");//显示提示图标
					formrepassworditip.classList.add("tip_position_gray");//添加灰色图标
					formrepassworditip.classList.remove("tip_position_orange");//移除橘色图标
					formrepasswordtip.innerHTML = "两次密码要相同";//提示文字
					formrepasswordtip.classList.remove("form_tip_orange");//移除文字颜色
					repasswordcancel.classList.remove("divnone");//显示叉号
					repasswordstatus.classList.add("divnone");//移除对号
				}else{
					formrepassworditip.classList.remove("divnone");//显示提示图标
					formrepassworditip.classList.remove("tip_position_orange");//移除橘色图标
					formrepassworditip.classList.add("tip_position_gray");//添加灰色图标
					formrepasswordtip.innerHTML = "请再次输入密码";//文字提示
					formrepasswordtip.classList.remove("form_tip_orange");//移除文字颜色
					repasswordcancel.classList.add("divnone");//移除叉号
					repasswordstatus.classList.add("divnone");//移除对号
				}
				repassword.onkeydown = function(){
					repasswordcancel.classList.remove("divnone");//显示叉号
				}
			},
			repasswordblur($event){
				let formitemrepassword = this.getelement("form_item_repassword"),
						formrepasswordtip = this.getelement("form_repassword_tip"),
						formrepassworditip = this.getelement("form_repassword_i_tip"),
						repasswordstatus = this.getelement("repassword_status"),
						repasswordcancel = this.getelement("repassword_cancel"),
						password = this.getelement("password");
				formitemrepassword.classList.remove("focus_border_color");//改边框的颜色
				formitemrepassword.classList.add("slider_border_color");//改边框的颜色
				if($event.target.value!=""){
					if($event.target.value == password.value){
						formrepassworditip.classList.add("divnone");//隐藏提示图标
						formrepasswordtip.innerHTML = "";//移除文字提示
						repasswordcancel.classList.add("divnone");//移除叉号图标
						repasswordstatus.classList.remove("divnone");//显示对号
						this.judge2 = true;					
					}else{
						formrepassworditip.classList.remove("divnone");//显示提示图标
						formrepassworditip.classList.remove("tip_position_gray");//移除灰色图标
						formrepassworditip.classList.add("tip_position_orange");//添加橘色图标
						formrepasswordtip.innerHTML = "两次密码输入不一致";//提示文字
						formrepasswordtip.classList.add("form_tip_orange");//添加文字颜色
						repasswordcancel.classList.add("divnone");//移除叉号图标
						repasswordstatus.classList.add("divnone");//隐藏对号
						this.judge2 = false;
					}
				}else{
					formrepassworditip.classList.remove("divnone");//显示提示图标
					formrepassworditip.classList.remove("tip_position_gray");//移除灰色图标
					formrepassworditip.classList.add("tip_position_orange");//添加橘色图标
					formrepasswordtip.innerHTML = "请再次输入密码";//添加文字提示
					formrepasswordtip.classList.add("form_tip_orange");//添加文字颜色
					repasswordcancel.classList.add("divnone");//移除叉号图标
					repasswordstatus.classList.add("divnone");//移除对号
					this.judge2 = false;
				}	
			},
			getelement(eleid){
				return document.getElementById(eleid);
			},
			accountcancel(){//删除按钮
				let account = this.getelement("account");
				account.value = "";
				this.form.account = "";
			},
			passwordcancel(){
				let password = this.getelement("password");
				password.value = "";
				this.form.password = "";
			},
			repasswordcancel(){
				let repassword = this.getelement("repassword");
				repassword.value = "";
				this.form.repassword = "";
			},
			registerbtn(){//注册按钮
				let _this = this;
				if(_this.favorite.length != 0&&_this.judge == true&&_this.judge1 == true&&_this.judge2 == true){//表单满足条件
					//跳转路由
					//console.log("dfda");
					_this.form.favourite = _this.favorite.join(",");
					// //this.$router.push({name:'Login',params:{data:this.form}});
					 //this.$router.replace({path:'/login',params:{data:this.form}});
					let oAjax = null;
					if(window.XMLHttpRequest){
						oAjax = new XMLHttpRequest();
					}else{
						oAjax = new ActiveXObject("Microsoft.XMLHTTP");
					}
					oAjax.open('POST','http://127.0.0.1/goods/registUser',true);
					oAjax.setRequestHeader("Content-type","application/json");
					oAjax.send(JSON.stringify(_this.form));
					oAjax.onreadystatechange=function(){
					  if(oAjax.readyState==4){
					    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
					      //对响应进行解析
					      let users=JSON.parse(oAjax.responseText);
					      //跳转登录页面
					      alert(users.message);
					      _this.$router.replace({path:'/login'});  
					    }else{
					      //对响应进行解析
					      alert("服务器错误");
					    }
					  }
					}
				}else if(_this.favorite.length == 0&&_this.judge == true){
					alert("请您至少选择一项感兴趣的内容！");
				}
				else{
					alert("信息填写有误！");
				}
			},
			acocuntajax(){
				//ajax请求所有的用户名
				let _this = this;
				let oAjax = null;
				if(window.XMLHttpRequest){
				  oAjax = new XMLHttpRequest();
				}else{
				  oAjax = new ActiveXObject('Microsoft.XMLHTTP');
				}
				oAjax.open('GET','http://127.0.0.1/goods/selectAllAccount',true);
				oAjax.send(null);
				oAjax.onreadystatechange=function(){
				  if(oAjax.readyState==4){
				    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
				      //4.对响应进行解析
				      let users=JSON.parse(oAjax.responseText);
				      _this.accountnumber = users.data;
				    }else{
				      //4.对响应进行解析
				      alert("服务器错误");
				    }
				  }
				}
			}
		},
		mounted(){
			this.acocuntajax()
		}
	}
</script>
<style scoped>
	.divnone{
		display: none !important;
	}
	/*表单内层*/
	.maincontainer{
		margin: 50px auto 60px;
    width: 400px;
	}
	/*每个输入框*/
	.form_item{
		position: relative;
	  border: solid 1px #ddd;
	  width: 400px;
	  height: 54px;
	}
	/*划过框变色*/
	.form_item:hover {
    border: 1px solid rgb(153,153,153);
	}
	/*label*/
	.account,.password,.repassword{
		float: left;
    width: 107px;
    height: 50px;
    line-height: 50px;
    padding-left: 20px;
    font-size: 14px;		
	}
	/*用户名间距*/
	.account{
		letter-spacing:14px;
	}
	/*设置密码间距*/
	.password,.repassword{
		letter-spacing:4px;
	}
	/*用户input*/
	.form_item .field {
    border: 0 none;
    font-size: 14px;
    width: 230px;
    height: 46px;
    padding-bottom: 11px;
    padding-left: 20px;
    padding-top: 16px;
    outline: none;
	}
	/*placeholder属性的颜色*/
	.field::-webkit-input-placeholder { /* WebKit browsers */ 
		color: rgb(204,204,204);
	}
	/*判断对错的图标*/
	.i_status{
		display: block;
		position: absolute;
    width: 16px;
    height: 16px;
    top: 20px;
    right: -30px;
		background: url(~assets/img/registericon.png) no-repeat;
	}
	.bas{
		background-position: 0 -117px;
	}
	.ruo{
		background-position: -17px -134px;
	}
	.zhong{
		background-position: -34px -116px !important;
	}
	.qiang{
		background-position: -34px -134px !important;
	}
	/*删除图标*/
	.i_cancel{
		display: block;
    position: absolute;
    width: 12px;
    height: 12px;
    top: 20px;
    right: 20px;
    cursor: pointer;
    background: url(~assets/img/registericon.png) no-repeat;
		background-position: -53px -119px;
	}
	/*用户名提示区*/
	.input_tip {
    color: #c5c5c5;
    height: 27px;
    font-size: 12px;
    padding-top: 5px;
	}
	/*提示橘色时*/
	.form_tip_orange{
    color: #f91;
	}
	/*提示区的图标*/
	.i_tip {
    display: inline-block;
    width: 16px;
    height: 16px;
    vertical-align: text-top;
    margin-right: 8px;
    background: url(~assets/img/registericon.png) no-repeat;
	}
	.tip_position_gray{
		background-position: 0px -100px;
	}
	.tip_position_orange{
		background-position: -17px -100px;
	}
	/*性别*/
	.sex{
		font-size: 14px;
		margin-right: 5px;
	}
	/*性别*/
	.form_item_sex{
		position: relative;
	  border: solid 1px transparent;
	  width: 400px;
	  height: 54px;
	  line-height: 36px;
	  padding-left: 20px;
	}
	/*男性*/
	#male{
		margin-right: 15px;
	}
	/*爱好*/
	.form_item_favourite{
		position: relative;
	  border: solid 1px transparent;
	  width: 400px;
	  height: 96px;
	  line-height: 40px;
	  padding-left: 20px;
	  font-size: 12px;
	}
	.form_item_favourite label{
		margin-right: 33px;
	}
	.form_item_favourite_title{
		margin-top: 10px;
		font-size: 14px;
	}
	/*注册按钮*/
	.btn_register {
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
	}
	/*注册按钮*/
	.btn_register:hover{
		background: #c81623;
    color: #eababc;
	}
	/*focusbordercolor*/
	.focus_border_color{
		border-color: rgb(102,102,102) ! important;
	}
	/*sliderbordercolor*/
	.slider_border_color{
		border-color: rgb(153,153,153) ! important;
	}
</style>