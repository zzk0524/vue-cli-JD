<template>
	<div class="usercontainer">
		<div class="maincontainer">
			<form>
				<div class="form_item">
					<label class="account">用户名</label>
					<span>{{currentUser.account}}</span>
				</div>
				<div class="input_tip"></div>
				<div class="form_item" id="form_item_userPassword">
					<label class="userPassword" for="userPassword">原密码</label>
					<input id="userPassword" v-model="form.userPassword" type="password" class="field" maxlength="20" placeholder="请输入原密码" required="required" @focus="userPasswordfocus($event)" @blur="userPasswordblur($event)" autocomplete="off">
					<i class="i_status bas divnone" id="userPassword_status"></i>
					<i class="i_cancel divnone" id="userPassword_cancel" @mousedown="userPasswordcancel"></i>
				</div>
				<div class="input_tip">
					<span class="form_userPassword_tip">
						<i class="i_tip divnone" id="form_userPassword_i_tip"></i>
						<span id="form_userPassword_tip"></span>
					</span>
				</div>
				<div class="form_item" id="form_item_newPassword">
					<label class="newPassword" for="newPassword">新密码</label>
					<input id="newPassword" v-model="form.newPassword" type="password" class="field" maxlength="20" placeholder="建议使用两种或两种以上字符组合" required="required" @focus="newPasswordfocus($event)" @blur="newPasswordblur($event)" autocomplete="off">
					<i class="i_status bas divnone" id="newPassword_status"></i>
					<i class="i_cancel divnone" id="newPassword_cancel" @mousedown="newPasswordcancel"></i>
				</div>
				<div class="input_tip">
					<span class="form_newPassword_tip">
						<i class="i_tip divnone" id="form_newPassword_i_tip"></i>
						<span id="form_newPassword_tip"></span>
					</span>
				</div>
				<div class="form_item" id="form_item_reNewPassword">
					<label class="reNewPassword" for="reNewPassword">确认密码</label>
					<input id="reNewPassword" v-model="form.reNewPassword" type="password" class="field" maxlength="20" placeholder="请再次输入密码" required="required" @focus="reNewPasswordfocus($event)" @blur="reNewPasswordblur($event)" autocomplete="off">
					<i class="i_status bas divnone" id="reNewPassword_status"></i>
					<i class="i_cancel divnone" id="reNewPassword_cancel" @mousedown="reNewPasswordcancel"></i>
				</div>
				<div class="input_tip">
					<span class="form_reNewPassword_tip">
						<i class="i_tip divnone" id="form_reNewPassword_i_tip"></i>
						<span id="form_reNewPassword_tip"></span>
					</span>
				</div>
				<div><button type="button" class="btn_update" @click="updatebtn">立即修改</button></div>
			</form>
		</div>
	</div>
</template>
<script>
	export default{
		name:"RegisterContainer",
		data(){
			return{
				form: {
					userPassword:'',//原密码
					newPassword:'',//新密码
					reNewPassword:''//再次新密码
				},
				currentUser:[],//当前用户
				judge:false,//原密码
				judge1:false,//新密码
				judge2:false//再次新密码
			}
		},
		methods:{
			getTempData(){//存储数据
				const tempData = window.sessionStorage.getItem('tempData');
				this.currentUser = JSON.parse(tempData);
			},
			userPasswordfocus($event){
				let formitemuserpassword = this.getelement("form_item_userPassword"),
						formuserpasswordtip = this.getelement("form_userPassword_tip"),
						formuserpassworditip = this.getelement("form_userPassword_i_tip"),
						userpassword = this.getelement("userPassword"),
						userpasswordstatus = this.getelement("userPassword_status"),
						userpasswordcancel = this.getelement("userPassword_cancel");
				formitemuserpassword.classList.remove("slider_border_color");//边框颜色
				formitemuserpassword.classList.add("focus_border_color");//边框颜色
				if($event.target.value!=""){//如果有内容
					if($event.target.value == this.currentUser.password){	//为原密码
						formuserpassworditip.classList.add("divnone");//隐藏提示图标
						formuserpasswordtip.innerHTML = "";//移除文字提示
						userpasswordcancel.classList.remove("divnone");//显示叉号
						userpasswordstatus.classList.add("divnone");//隐藏对号
					}else{//不为原密码
						formuserpassworditip.classList.remove("divnone");//显示提示图标
						formuserpassworditip.classList.remove("tip_position_gray");//移除灰色图标
						formuserpassworditip.classList.add("tip_position_orange");//添加橘色图标
						formuserpasswordtip.innerHTML = "与原密码不一致";//添加提示文字
						formuserpasswordtip.classList.add("form_tip_orange");//添加文字颜色
						userpasswordcancel.classList.remove("divnone");//显示叉号
						userpasswordstatus.classList.add("divnone");//移除对号
					}	
				}else{
					formuserpassworditip.classList.remove("divnone");//显示提示图标
					formuserpassworditip.classList.remove("tip_position_orange");//移除橘色图标
					formuserpassworditip.classList.add("tip_position_gray");//添加灰色图标
					formuserpasswordtip.innerHTML = "请输入原密码";//添加文字提示
					formuserpasswordtip.classList.remove("form_tip_orange");//移除文字颜色
					userpasswordcancel.classList.add("divnone");//移除叉号
					userpasswordstatus.classList.add("divnone");//移除对号
				}
				userpassword.onkeydown = function(){
					userpasswordcancel.classList.remove("divnone");//显示叉号
				}
			},
			userPasswordblur($event){
				let formitemuserpassword = this.getelement("form_item_userPassword"),
						formuserpasswordtip = this.getelement("form_userPassword_tip"),
						formuserpassworditip = this.getelement("form_userPassword_i_tip"),
						userpasswordstatus = this.getelement("userPassword_status"),
						userpasswordcancel = this.getelement("userPassword_cancel");
				formitemuserpassword.classList.remove("focus_border_color");//改边框的颜色
				formitemuserpassword.classList.add("slider_border_color");//改边框的颜色
				if($event.target.value!=""){
					if($event.target.value == this.currentUser.password){//成功
						formuserpassworditip.classList.add("divnone");//隐藏提示图标
						formuserpasswordtip.innerHTML = "";//移除文字提示
						userpasswordcancel.classList.add("divnone");//移除叉号图标
						userpasswordstatus.classList.remove("divnone");//显示对号
						this.judge = true;	
					}else{
						formuserpassworditip.classList.remove("divnone");//显示提示图标
						formuserpassworditip.classList.remove("tip_position_gray");//移除灰色图标
						formuserpassworditip.classList.add("tip_position_orange");//添加橘色图标
						formuserpasswordtip.innerHTML = "与原密码不一致";//提示文字
						formuserpasswordtip.classList.add("form_tip_orange");//添加文字颜色
						userpasswordcancel.classList.add("divnone");//移除叉号图标
						userpasswordstatus.classList.add("divnone");//隐藏对号
						this.judge = false;
					}
				}else{
					formuserpassworditip.classList.remove("divnone");//隐藏
					formuserpassworditip.classList.remove("tip_position_gray");//移除灰色图标
					formuserpassworditip.classList.add("tip_position_orange");//移除橘色图标
					formuserpasswordtip.innerHTML = "原密码不能为空";//移除文字提示
					formuserpasswordtip.classList.add("form_tip_orange");//添加文字颜色
					userpasswordcancel.classList.add("divnone");//移除叉号图标
					userpasswordstatus.classList.add("divnone");//移除对号
					this.judge = false;
				}
			},
			newPasswordfocus($event){
				let formitemnewpassword = this.getelement("form_item_newPassword"),
						formnewpasswordtip = this.getelement("form_newPassword_tip"),
						formnewpassworditip = this.getelement("form_newPassword_i_tip"),
						newpassword = this.getelement("newPassword"),
						newpasswordstatus = this.getelement("newPassword_status"),
						newpasswordcancel = this.getelement("newPassword_cancel");
				let pattern = /^\S{6,20}$/;/*6-20位*/
				formitemnewpassword.classList.remove("slider_border_color");//边框颜色
				formitemnewpassword.classList.add("focus_border_color");//边框颜色
				if($event.target.value!=""){
					if(pattern.exec($event.target.value)){	
						if($event.target.value==this.currentUser.password){
							formnewpassworditip.classList.remove("divnone");//显示提示图标
							formnewpassworditip.classList.remove("tip_position_gray");//移除灰色图标
							formnewpassworditip.classList.add("tip_position_orange");//添加橘色图标
							formnewpasswordtip.innerHTML = "不能和原密码相同";//添加提示文字
							formnewpasswordtip.classList.add("form_tip_orange");//添加文字颜色
							newpasswordcancel.classList.remove("divnone");//显示叉号
							newpasswordstatus.classList.add("divnone");//移除对号
						}else{
							formnewpassworditip.classList.add("divnone");//隐藏提示图标
							formnewpasswordtip.innerHTML = "";//移除文字提示
							newpasswordcancel.classList.remove("divnone");//显示叉号
							newpasswordstatus.classList.add("divnone");//隐藏对号
						}
					}else{
						formnewpassworditip.classList.remove("divnone");//显示提示图标
						formnewpassworditip.classList.remove("tip_position_gray");//移除灰色图标
						formnewpassworditip.classList.add("tip_position_orange");//添加橘色图标
						formnewpasswordtip.innerHTML = "6-20位字母、数字或符号";//添加提示文字
						formnewpasswordtip.classList.add("form_tip_orange");//添加文字颜色
						newpasswordcancel.classList.remove("divnone");//显示叉号
						newpasswordstatus.classList.add("divnone");//移除对号
					}	
				}else{
					formnewpassworditip.classList.remove("divnone");//显示提示图标
					formnewpassworditip.classList.remove("tip_position_orange");//移除橘色图标
					formnewpassworditip.classList.add("tip_position_gray");//添加灰色图标
					formnewpasswordtip.innerHTML = "6-20位字母、数字或符号";//添加文字提示
					formnewpasswordtip.classList.remove("form_tip_orange");//移除文字颜色
					newpasswordcancel.classList.add("divnone");//移除叉号
					newpasswordstatus.classList.add("divnone");//移除对号
				}
				newpassword.onkeydown = function(){
					newpasswordcancel.classList.remove("divnone");//显示叉号
				}
			},
			newPasswordblur($event){
				let pattern = /^\S{6,20}$/,/*6-20位*/ 
					  pattern1 = /^[a-zA-Z]{6,20}$/,//一级强度纯字母
						pattern2 = /^\d{6,20}$/,//一级强度纯数字
						pattern3 = /^[^a-zA-Z0-9]{6,20}$/,//一级强度纯符号
						pattern4 = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/,//数字和字母
						pattern5 = /^(?![\W_]+$)(?![a-zA-Z]+$)[a-zA-Z\W_]{6,20}$/,//字母和字符
						pattern6 = /^(?![\W_]+$)(?![0-9]+$)[0-9\W_]{6,20}$/,//数字和字符
						pattern7 = /^(?![\W_]+$)(?![0-9]+$)(?![a-zA-Z]+$)[a-zA-Z0-9\W_]{6,20}$/;//字母数字和字符
				let formitemnewpassword = this.getelement("form_item_newPassword"),
						formnewpasswordtip = this.getelement("form_newPassword_tip"),
						formnewpassworditip = this.getelement("form_newPassword_i_tip"),
						newpasswordstatus = this.getelement("newPassword_status"),
						newpasswordcancel = this.getelement("newPassword_cancel");
				formitemnewpassword.classList.remove("focus_border_color");//改边框的颜色
				formitemnewpassword.classList.add("slider_border_color");//改边框的颜色
				if($event.target.value!=""){
					if(pattern.exec($event.target.value)){
						if($event.target.value==this.currentUser.password){
							formnewpassworditip.classList.remove("divnone");//显示提示图标
							formnewpassworditip.classList.remove("tip_position_gray");//移除灰色图标
							formnewpassworditip.classList.add("tip_position_orange");//添加橘色图标
							formnewpasswordtip.innerHTML = "不能和原密码相同";//提示文字
							formnewpasswordtip.classList.add("form_tip_orange");//添加文字颜色
							newpasswordcancel.classList.add("divnone");//移除叉号图标
							newpasswordstatus.classList.add("divnone");//隐藏对号
							this.judge1 = false;
						}else{
							if(pattern1.exec($event.target.value)||pattern2.exec($event.target.value)||pattern3.exec($event.target.value)){//一级强度验证
								formnewpassworditip.classList.add("divnone");//隐藏提示图标
								formnewpasswordtip.innerHTML = "";//移除文字提示
								newpasswordcancel.classList.add("divnone");//移除叉号图标
								newpasswordstatus.classList.remove("divnone");//显示图标
								newpasswordstatus.classList.remove("bas");//移除基础
								newpasswordstatus.classList.remove("zhong");//移除中
								newpasswordstatus.classList.remove("qiang");//移除强
								newpasswordstatus.classList.add("ruo");//显示弱
								this.judge1 = true;
							}else if(!pattern1.exec($event.target.value)&&!pattern2.exec($event.target.value)&&!pattern3.exec($event.target.value)&&(pattern4.exec($event.target.value)||pattern5.exec($event.target.value)||pattern6.exec($event.target.value))){
								formnewpassworditip.classList.add("divnone");//隐藏提示图标
								formnewpasswordtip.innerHTML = "";//移除文字提示
								newpasswordcancel.classList.add("divnone");//移除叉号图标
								newpasswordstatus.classList.remove("divnone");//显示图标
								newpasswordstatus.classList.remove("bas");//移除基础
								newpasswordstatus.classList.add("zhong");//显示中
								newpasswordstatus.classList.remove("qiang");//移除强
								newpasswordstatus.classList.remove("ruo");//移除弱
								this.judge1 = true;
							}else if(!pattern1.exec($event.target.value)&&!pattern2.exec($event.target.value)&&!pattern3.exec($event.target.value)&&!pattern4.exec($event.target.value)&&!pattern5.exec($event.target.value)&&!pattern6.exec($event.target.value)&&pattern7.exec($event.target.value)){
								formnewpassworditip.classList.add("divnone");//隐藏提示图标
								formnewpasswordtip.innerHTML = "";//移除文字提示
								newpasswordcancel.classList.add("divnone");//移除叉号图标
								newpasswordstatus.classList.remove("divnone");//显示图标
								newpasswordstatus.classList.remove("bas");//移除基础
								newpasswordstatus.classList.remove("zhong");//移除中
								newpasswordstatus.classList.add("qiang");//显示强
								newpasswordstatus.classList.remove("ruo");//移除弱
								this.judge1 = true;
							}
						}
					}else{
						formnewpassworditip.classList.remove("divnone");//显示提示图标
						formnewpassworditip.classList.remove("tip_position_gray");//移除灰色图标
						formnewpassworditip.classList.add("tip_position_orange");//添加橘色图标
						formnewpasswordtip.innerHTML = "6-20位字母、数字或符号";//提示文字
						formnewpasswordtip.classList.add("form_tip_orange");//添加文字颜色
						newpasswordcancel.classList.add("divnone");//移除叉号图标
						newpasswordstatus.classList.add("divnone");//隐藏对号
						this.judge1 = false;
					}
				}else{
					formnewpassworditip.classList.remove("divnone");//隐藏
					formnewpassworditip.classList.remove("tip_position_gray");//移除灰色图标
					formnewpassworditip.classList.add("tip_position_orange");//移除橘色图标
					formnewpasswordtip.innerHTML = "密码不能为空";//移除文字提示
					formnewpasswordtip.classList.add("form_tip_orange");//添加文字颜色
					newpasswordcancel.classList.add("divnone");//移除叉号图标
					newpasswordstatus.classList.add("divnone");//移除对号
					this.judge1 = false;
				}	
			},
			reNewPasswordfocus($event){
				let formitemrenewpassword = this.getelement("form_item_reNewPassword"),
						formrenewpasswordtip = this.getelement("form_reNewPassword_tip"),
						formrenewpassworditip = this.getelement("form_reNewPassword_i_tip"),
						renewpassword = this.getelement("reNewPassword"),
						renewpasswordstatus = this.getelement("reNewPassword_status"),
						renewpasswordcancel = this.getelement("reNewPassword_cancel"),
						newpassword = this.getelement("newPassword");
				formitemrenewpassword.classList.remove("slider_border_color");//边框颜色
				formitemrenewpassword.classList.add("focus_border_color");//边框颜色
				if($event.target.value!=""){
					formrenewpassworditip.classList.remove("divnone");//显示提示图标
					formrenewpassworditip.classList.add("tip_position_gray");//添加灰色图标
					formrenewpassworditip.classList.remove("tip_position_orange");//移除橘色图标
					formrenewpasswordtip.innerHTML = "两次密码要相同";//提示文字
					formrenewpasswordtip.classList.remove("form_tip_orange");//移除文字颜色
					renewpasswordcancel.classList.remove("divnone");//显示叉号
					renewpasswordstatus.classList.add("divnone");//移除对号
				}else{
					formrenewpassworditip.classList.remove("divnone");//显示提示图标
					formrenewpassworditip.classList.remove("tip_position_orange");//移除橘色图标
					formrenewpassworditip.classList.add("tip_position_gray");//添加灰色图标
					formrenewpasswordtip.innerHTML = "请再次输入密码";//文字提示
					formrenewpasswordtip.classList.remove("form_tip_orange");//移除文字颜色
					renewpasswordcancel.classList.add("divnone");//移除叉号
					renewpasswordstatus.classList.add("divnone");//移除对号
				}
				renewpassword.onkeydown = function(){
					renewpasswordcancel.classList.remove("divnone");//显示叉号
				}
			},
			reNewPasswordblur($event){
				let formitemrenewpassword = this.getelement("form_item_reNewPassword"),
						formrenewpasswordtip = this.getelement("form_reNewPassword_tip"),
						formrenewpassworditip = this.getelement("form_reNewPassword_i_tip"),
						renewpasswordstatus = this.getelement("reNewPassword_status"),
						renewpasswordcancel = this.getelement("reNewPassword_cancel"),
						newpassword = this.getelement("newPassword");
				formitemrenewpassword.classList.remove("focus_border_color");//改边框的颜色
				formitemrenewpassword.classList.add("slider_border_color");//改边框的颜色
				if($event.target.value!=""){
					if($event.target.value == newpassword.value){
						formrenewpassworditip.classList.add("divnone");//隐藏提示图标
						formrenewpasswordtip.innerHTML = "";//移除文字提示
						renewpasswordcancel.classList.add("divnone");//移除叉号图标
						renewpasswordstatus.classList.remove("divnone");//显示对号
						this.judge2 = true;					
					}else{
						formrenewpassworditip.classList.remove("divnone");//显示提示图标
						formrenewpassworditip.classList.remove("tip_position_gray");//移除灰色图标
						formrenewpassworditip.classList.add("tip_position_orange");//添加橘色图标
						formrenewpasswordtip.innerHTML = "两次密码输入不一致";//提示文字
						formrenewpasswordtip.classList.add("form_tip_orange");//添加文字颜色
						renewpasswordcancel.classList.add("divnone");//移除叉号图标
						renewpasswordstatus.classList.add("divnone");//隐藏对号
						this.judge2 = false;
					}
				}else{
					formrenewpassworditip.classList.remove("divnone");//显示提示图标
					formrenewpassworditip.classList.remove("tip_position_gray");//移除灰色图标
					formrenewpassworditip.classList.add("tip_position_orange");//添加橘色图标
					formrenewpasswordtip.innerHTML = "请再次输入密码";//添加文字提示
					formrenewpasswordtip.classList.add("form_tip_orange");//添加文字颜色
					renewpasswordcancel.classList.add("divnone");//移除叉号图标
					renewpasswordstatus.classList.add("divnone");//移除对号
					this.judge2 = false;
				}	
			},
			getelement(eleid){
				return document.getElementById(eleid);
			},
			userPasswordcancel(){
				let userpassword = this.getelement("userPassword");
				userpassword.value = "";
				this.form.userpassword = "";
			},
			newPasswordcancel(){
				let newpassword = this.getelement("newPassword");
				newpassword.value = "";
				this.form.newpassword = "";
			},
			reNewPasswordcancel(){
				let renewpassword = this.getelement("reNewPassword");
				renewpassword.value = "";
				this.form.renewpassword = "";
			},
			updatebtn(){//注册按钮
				let _this = this;
				if(_this.judge == true&&_this.judge1 == true&&_this.judge2 == true){//表单满足条件
					let oAjax = null;
					if(window.XMLHttpRequest){
						oAjax = new XMLHttpRequest();
					}else{
						oAjax = new ActiveXObject("Microsoft.XMLHTTP");
					}
					oAjax.open('POST','http://127.0.0.1/goods/updateUser',true);
					oAjax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
					oAjax.send("id="+_this.currentUser.id+"&password="+_this.form.newPassword);
					oAjax.onreadystatechange=function(){
					  if(oAjax.readyState==4){
					    if(oAjax.status>=200 && oAjax.status<300 || oAjax.status==304){
					      //对响应进行解析
					      let users=JSON.parse(oAjax.responseText);
					      //跳转登录页面
					      if(users.code == 1){
					      	alert(users.message);
					      	_this.$router.replace({path:'/login'});  
					      }else{
					      	alert("修改失败,请稍后再试");
					      }
					    }else{
					      //对响应进行解析
					      alert("服务器错误");
					    }
					  }
					}
				}else{
					alert("信息填写有误！");
				}
			}
		},
		mounted(){
			this.getTempData();
		}
	}
</script>
<style scoped>
	.usercontainer{
		width: 90%;
		margin: 0 auto;
	}
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
	.form_item span{
		display: inline-block;
		height: 50px;
		line-height: 50px;
		margin-left: 20px;
	}
	/*label*/
	.account,
	.userPassword,
	.newPassword,
	.reNewPassword{
		float: left;
    width: 107px;
    height: 50px;
    line-height: 50px;
    padding-left: 20px;
    font-size: 14px;		
	}
	/*用户名间距*/
	.account,
	.userPassword,
	.newPassword{
		letter-spacing:14px;
	}	
	/*设置密码间距*/
	.reNewPassword{
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
	/*注册按钮*/
	.btn_update {
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
	.btn_update:hover{
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