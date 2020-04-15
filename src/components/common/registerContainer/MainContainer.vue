<template>
	<div class="maincontainer">
		<div class="reg_form">
			<form action="register" method="post">
				<div class="form_item" id="form_item_account">
					<label class="account" for="account">用户名</label>
					<input id="account" v-model="form.account" type="text" class="field" maxlength="20" placeholder="您的账户名和登录名" required="required" @focus="accountfocus($event)" @blur="accountblur($event)">
					<i class="i_status divnone" id="account_status"></i>
					<i class="i_cancel divnone" id="account_cancel" @click="cancelbtn"></i>
				</div>
				<div class="input_tip">
					<span class="form_account_tip">
						<i class="i_tip divnone" id="form_account_i_tip"></i>
						<span id="form_account_tip"></span>
					</span>
				</div>
				<div class="form_item_sex">
					<label for="male" class="sex">男</label>
					<input type="radio" id="male" value="男" name="sex" checked="checked">
					<label for="female" class="sex">女</label>
					<input type="radio" id="female" value="女" name="sex">
				</div>
				<div class="form_item" id="form_item_password">
					<label class="password" for="password">设置密码</label>
					<input id="password" type="text" class="field" maxlength="20" placeholder="建议使用两种或两种以上字符组合" required="required" @focus="passwordfocus($event)" @blur="passwordblur($event)">
					<i class="i_status"></i>
					<i class="i_cancel"></i>
				</div>
				<div class="input_tip">
					<span class="form_password_tip">
						<i class="i_tip"></i>
						操作超时
					</span>
				</div>
				<div class="form_item" id="form_item_password1">
					<label class="password1" for="password1">确认密码</label>
					<input id="password1" type="text" class="field" maxlength="20" placeholder="请再次输入密码" required="required" @focus="password1focus($event)" @blur="password1blur($event)">
					<i class="i_status"></i>
					<i class="i_cancel"></i>
				</div>
				<div class="input_tip">
					<span class="form_password1_tip">
						<i class="i_tip"></i>
						操作超时
					</span>
				</div>
				<div class="form_item_favourite_title"><span>选择感兴趣的内容：</span></div>
				<div class="form_item_favourite">
					<label><input name="favourite" type="checkbox" value="潮流服饰" checked="checked" />潮流服饰</label> 
					<label><input name="favourite" type="checkbox" value="文学读物" />文学读物</label> 
					<label><input name="favourite" type="checkbox" value="电子设备" />电子设备</label> 
					<label><input name="favourite" type="checkbox" value="居家生活" />居家生活</label><br>
					<label><input name="favourite" type="checkbox" value="美味小吃" />美味小吃</label>
					<label><input name="favourite" type="checkbox" value="萌宠乐园" />萌宠乐园</label>
					<label><input name="favourite" type="checkbox" value="珠宝配饰" />珠宝配饰</label>
					<label><input name="favourite" type="checkbox" value="玩具城" />玩具城</label>					
				</div>
				<!-- 裤子上衣鞋      图书      手机     个护清洁汽车用品      食品      宠物      珠宝      玩具 -->
				        
				<div><button class="btn_register" @click="registerbtn">立即注册</button></div>
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
					password:'',
					password1:''
				}
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
				formitemaccount.classList.add("focus_border_color");//边框颜色
				formaccountitip.classList.remove("divnone");//现身
				formaccountitip.classList.add("tip_position_gray");//灰色图标
				formaccounttip.innerHTML = "支持中文、英文、数字、“-”、“_”的组合，4-20个字符";//文字提示
				account.onkeydown = function(){
					accountcancel.classList.remove("divnone");
				}
			},
			accountblur($event){
				let formitemaccount = this.getelement("form_item_account"),
						formaccounttip = this.getelement("form_account_tip"),
						formaccountitip = this.getelement("form_account_i_tip");
				if($event.target.value!=""){
					formitemaccount.classList.remove("focus_border_color");
					formitemaccount.classList.add("slider_border_color");
				}else{
					formitemaccount.classList.remove("focus_border_color");
					formitemaccount.classList.remove("slider_border_color");
				}
				formaccountitip.classList.add("divnone");//隐藏
				formaccountitip.classList.remove("tip_position_gray");//移除灰色图标
				formaccounttip.innerHTML = "";//移除文字提示
			},
			passwordfocus($event){
				let formitempassword = this.getelement("form_item_password");
				formitempassword.classList.add("focus_border_color");

			},
			passwordblur($event){
				let formitempassword = this.getelement("form_item_password");
				// console.log($event.target.value);
				if($event.target.value!=""){
					formitempassword.classList.remove("focus_border_color");
					formitempassword.classList.add("slider_border_color");
				}else{
					formitempassword.classList.remove("focus_border_color");
					formitempassword.classList.remove("slider_border_color");
				}
				
			},
			password1focus($event){
				let formitempassword1 = this.getelement("form_item_password1");
				formitempassword1.classList.add("focus_border_color");

			},
			password1blur($event){
				let formitempassword1 = this.getelement("form_item_password1");
				// console.log($event.target.value);
				if($event.target.value!=""){
					formitempassword1.classList.remove("focus_border_color");
					formitempassword1.classList.add("slider_border_color");
				}else{
					formitempassword1.classList.remove("focus_border_color");
					formitempassword1.classList.remove("slider_border_color");
				}
				
			},
			getelement(eleid){
				return document.getElementById(eleid);
			},
			cancelbtn(){
				let accountcancel = this.getelement("account_cancel");
				this.form.account = "";
				accountcancel.classList.add("divnone");
			},
			registerbtn(){
				//正则判断
				//ajax调用
			}
		},
		mounted(){

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
	.account,.password,.password1{
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
	.password,.password1{
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
		background-position: 0 -117px;
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
	/*活跃时*/
	.form_tip_active{
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