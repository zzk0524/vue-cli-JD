<template>
	<div class="logincontainer">
		<div class="login_wrap">
			<div class="w">
				<div class="login_form">
					<div class="login_tab login_tab_l">
						<a href="javascript:void(0)" id="loginmode2">扫码登录</a>
					</div>
					<div class="login_tab login_tab_r">
						<a href="javascript:void(0)" class="checked" id="loginmode1">账户登录</a>
					</div>
					<div class="login_box" id="login_box">
						<div class="form">
							<form>
								<div class="item item_fore1">
									<label for="loginname" class="login_label name_label">
									</label>
									<input type="text" id="loginname" class="itxt" name="loginname" autocomplete="off" placeholder="用户名" v-model="form.loginname" @blur="loginnameblur($event)" @focus="loginnamefocus($event)">
									<span class="clear_btn divnone" id="loginname_clear_btn" @click="loginnameclear"></span>
								</div>
								<div class="item item_fore2">
									<label for="loginpwd" class="login_label pwd_label">
									</label>
									<input type="password" id="loginpwd" class="itxt" name="loginpwd" autocomplete="new-password" placeholder="密码" v-model="form.loginpwd" @blur="loginpwdblur($event)" @focus="loginpwdfocus($event)">
									<span class="clear_btn divnone" id="loginpwd_clear_btn" @click="loginpwdclear"></span>
								</div>
								<div class="item item_fore3">
									<div class="safe">
										<span class="forget_pw_safe">
											<a href="javascript:void(0)">忘记密码</a>
										</span>
									</div>
								</div>
								<div class="item item_fore4">
									<div class="login_btn" @click="loginbtn">
										<a href="javascript:void(0)" class="btn_img">登录</a>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="qrcode_login divnone" id="qrcode_login">
						<div class="qrcode_main">
							<div class="qrcode_img"><img src="~assets/img/show.png" alt="二维码"></div>
						</div>
						<div class="qrcode_panel">
							<ul>
								<li class="fore1">
									<span>打开</span>
									<a href="javascript:void(0)"><span class="red">手机淘淘</span></a>
								</li>
								<li>扫描二维码</li>
							</ul>
						</div>
					</div>
					<div class="coagent">
						<ul>
							<li>
								<a href="javascript:void(0)" class="pdl">
									<b class="QQ_icon"></b>
									<span>QQ</span>
								</a>
							</li>
							<li>
								<a href="javascript:void(0)" class="pdl">
									<b class="weixin_icon"></b>
									<span>微信</span>
								</a>
							</li>
							<li class="extra_r">
								<div class="regist_link">
									<router-link to="/register">
										<a href="javascript:void(0)">
											<b></b>
											立即注册
										</a>
									</router-link>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="login_banner">
				<div class="w">
					<div class="i_inner"></div>
				</div>
			</div>
		</div>
	</div>
</template>
<script>
	export default{
		name:"LoginContainer",
		data(){
			return{
				form:{
					loginname:'',
					loginpwd:''
				}
			}
		},
		methods:{
			loginnamefocus($event){
				let loginname = this.getelement("loginname"),
						loginnameclearbtn = this.getelement("loginname_clear_btn");
				if($event.target.value != ""){
					loginnameclearbtn.classList.remove("divnone");
				}else{
					loginnameclearbtn.classList.add("divnone");
				}
				loginname.onkeydown = function(){
					loginnameclearbtn.classList.remove("divnone");//显示叉号
				}
			},
			loginnameblur($event){
				let loginnameclearbtn = this.getelement("loginname_clear_btn");
				if($event.target.value == ""){
					loginnameclearbtn.classList.add("divnone");
				}else{
					loginnameclearbtn.classList.remove("divnone");//显示叉号
				}
			},
			loginpwdfocus($event){
				
				let loginpwd = this.getelement("loginpwd"),
						loginpwdclearbtn = this.getelement("loginpwd_clear_btn");
				if($event.target.value != ""){
					loginpwdclearbtn.classList.remove("divnone");
				}else{
					loginpwdclearbtn.classList.add("divnone");
				}
				loginpwd.onkeydown = function(){
					loginpwdclearbtn.classList.remove("divnone");//显示叉号
				}
			},
			loginpwdblur($event){
				let loginpwdclearbtn = this.getelement("loginpwd_clear_btn");
				if($event.target.value == ""){
					loginpwdclearbtn.classList.add("divnone");//隐藏叉号
				}else{
					loginpwdclearbtn.classList.remove("divnone");//显示叉号
				}
			},
			loginbtn(){
				if((this.form.loginname == ""&&this.form.loginpwd != "")||(this.form.loginname == ""&&this.form.loginpwd == "")){
					alert("请填写用户名！");
				}else if(this.form.loginnameloginname != ""&&this.form.loginpwd == ""){
					alert("请填写密码！");
				}else if(this.form.loginnameloginname != ""&&this.form.loginpwd != ""){
					//发送ajax请求
					
				}
			},
			getelement(eleid){
				return document.getElementById(eleid);
			},
			loginnameclear(){
				let loginname = this.getelement("loginname"),
						loginnameclearbtn = this.getelement("loginname_clear_btn");
				loginname.value = "";
				this.form.loginname = "";
				//隐藏叉号
				loginnameclearbtn.classList.add("divnone");
				//聚焦当前
				loginname.focus();
			},
			loginpwdclear(){
				let loginpwd = this.getelement("loginpwd"),
						loginpwdclearbtn = this.getelement("loginpwd_clear_btn");
				loginpwd.value = "";
				this.form.loginpwd = "";
				//隐藏叉号
				loginpwdclearbtn.classList.add("divnone");
				//聚焦当前
				loginpwd.focus();
			},
			loginmode(){
				let loginmode1 = this.getelement("loginmode1"),
						loginmode2 = this.getelement("loginmode2"),
						qrcodelogin = this.getelement("qrcode_login"),
						loginbox = this.getelement("login_box");
				loginmode1.onclick = function(){
					loginmode2.classList.remove("checked");
					qrcodelogin.classList.add("divnone");
					loginmode1.classList.add("checked");
					loginbox.classList.remove("divnone");
				}
				loginmode2.onclick = function(){
					loginmode1.classList.remove("checked");
					loginbox.classList.add("divnone");
					loginmode2.classList.add("checked");
					qrcodelogin.classList.remove("divnone");
				}
			}
		},
		mounted(){
			this.loginmode();
		}
	}
</script>
<style scoped>
	.divnone{
		display: none;
	}
	/*登录内层*/
	.login_wrap {
	  position: relative;
	  height: 475px;
	  margin: 10px 0 20px;
	  z-index: 5;
	}
	/*表单外层*/
	.w {
    width: 990px;
    margin: 0 auto;
	}
	/*表单*/
	.login_form {
    position: relative;
    float: right;
    top: 40px;
    z-index: 4;
    background: #fff;
    overflow: visible;
    width: 346px;
	}
	/*扫码登录和账户登录*/
	.login_tab {
    height: 54px;
    font-size: 18px;
    font-family: "microsoft yahei";
    text-align: center;
    border-bottom: 1px solid #f4f4f4;
    position: absolute;
    background: #fff;
    display: block;
	}
	/*扫码登录和账户登录*/
	.login_tab_l,.login_tab_r {
    width: 173px;
	}
	/*账户登录*/
	.login_tab_r {
    right: 0;
	}
	/*文字*/
	.login_tab a {
    width: 99%;
    height: 18px;
    position: absolute;
    left: 0;
    top: 18px;
    border-right: 1px solid #f4f4f4;
    text-decoration: none;
	}
	/*点击和滑过*/
	.login_tab a.checked,.login_tab a:hover {
    font-weight: 700;
    color: #e4393c;
	}
	.login_box{
		width: 306px;
    padding: 20px;
    margin-top: 45px;
	}
	.item {
    position: relative;
    margin-bottom: 20px;
  }
  .item_fore1,.item_fore2 {
    border: 1px solid #bdbdbd;
    height: 40px;
    width: 304px;
	}
	.login_label {
    position: absolute;
    z-index: 3;
    top: 0;
    left: 0;
    width: 38px;
    height: 38px;
    border-right: 1px solid #bdbdbd;
    background: url(~assets/img/pwd-icons-new.png) no-repeat;
	}
	/*用户名图标*/
	.name-label {
    background-position: 0 0;
	}
	/*input的位置*/
	.itxt {
    line-height: 38px;
    height: 38px;
    border: 0;
    padding: 10px 0 10px 50px;
    width: 254px;
    float: none;
    overflow: hidden;
    font-size: 14px;
    font-family: '\5b8b\4f53';
    outline: none;
	}
	/*placeholder属性的颜色*/
	.itxt::-webkit-input-placeholder { /* WebKit browsers */ 
		color: #bdbdbd;
	}
	/*叉号*/
	.clear_btn {
    position: absolute;
    z-index: 20;
    right: 6px;
    top: 12px;
    width: 14px;
    height: 14px;
    background: url(~assets/img/pwd-icons-new.png) -25px -143px no-repeat;
    cursor: pointer;
	}
	/*密码图标*/
	.pwd_label {
    background-position: -48px 0;
	}
	/*忘记密码区域*/
	.safe{
		position: relative;
		width: 306px;
		height: 18px;
	}
	.forget_pw_safe{
		position: absolute;
    right: 0;
    top: 0;
    margin: 0;
	}
	/*文字*/
	.forget_pw_safe a{
		color: #666;
		font-size: 13px;
	}
	.forget_pw_safe a:hover{
		color: #E4393C;
	}
	/*登录按钮*/
	.item_fore4 {
    margin-bottom: 10px;
    width: 306px;
    height: 34px;
	}
	.login_btn {
    border: 1px solid #cb2a2d;
    margin: 0 auto;
    height: 32px;
    width: 99%;
    position: relative;
	}
	/*a标签文字*/
	.btn_img {
    border: 1px solid #e85356;
    display: block;
    width: 302px;
    background: #e4393c;
    height: 31px;
    line-height: 31px;
    color: #fff;
    font-size: 20px;
    font-family: 'Microsoft YaHei';
    margin: 0;
    padding: 0 0 0 20px;
    text-align: center;
    cursor: pointer;
    letter-spacing: 20px;
	}
	/*QQ和微信*/
	.coagent {
    padding-left: 20px;
    padding-right: 20px;
    line-height: 50px;
    border-top: 1px solid #f4f4f4;
    height: auto;
    background-color: #fcfcfc;
	}
	.coagent li {
    float: left;
    list-style: none;
	}
	.coagent li:nth-of-type(2){
		margin-left: 10px;
	}
	.pdl {
    display: inline-block;
    position: relative;
    padding-left: 24px;
	}
	.pdl b {
	  width: 19px;
	  height: 18px;
	  display: block;
	  background: url(~assets/img/QQ-weixin.png) no-repeat;
	  margin: 0 auto;
	  position: absolute;
	  float: left;
	  left: 0;
	  top: 16px;
	}
	.pdl span{
		font-size: 12px;
	}
	.pdl span:hover{
		color: #E4393C;
	}
	/*微信图标*/
	.coagent li a.pdl b.weixin_icon {
    background-position: -20px 0;
	}
	.coagent li.extra_r {
    float: right;
	}
	.coagent .regist_link {
    color: #b61d1d;
    font-size: 14px;
	}
	.coagent .regist_link a {
    color: #b61d1d;
	}
	/*立即注册图标*/
	.coagent .regist_link b {
    display: inline-block;
    width: 16px;
    height: 16px;
    overflow: hidden;
    background: url(~assets/img/pwd-icons-new.png) -104px -75px no-repeat;
    vertical-align: middle;
	}
	/*二维码页面*/
	.qrcode_login{
		width: 306px;
    padding: 20px 18px 20px 20px;
    text-align: center;
	}
	.qrcode_main{
		position: relative;
    height: 168px;
    margin-top: 55px;
	}
	.qrcode_img {
    border: 1px solid #f4f4f4;
    padding: 8px;
    width: 155px;
    position: absolute;
    left: 68px;
	}
	/*二维码的大小*/
	.qrcode_img img {
    width: 147px;
    height: 147px;
	}
	/*二维码下面的文字*/
	.qrcode_panel {
    width: 297px;
    margin: 18px auto 14px;
    text-align: center;
	}
	.qrcode_panel li {
    display: inline-block;
    padding: 0 0 0 5px;
    margin: 0 5px 0 0;
    font-size: 12px;
	}
	/*打开手机淘淘*/
	.qrcode_panel a {
    color: #333;
    text-decoration: none;
    margin-left: 3px;
	}
	.red {
    color: #e4393c;
	}

	/*背景色*/
	.login_banner {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 475px;
    background: #e93854;
	}
	/*背景图*/
	.i_inner {
	  position: relative;
	  z-index: 3;
	  height: 475px;
	  background: url(~assets/img/login-bg.png) 0px 0px no-repeat;
	  background-color: #e93854;
	}
</style>