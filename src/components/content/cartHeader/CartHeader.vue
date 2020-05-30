<template>
	<div class="cartheader">
		<div class="cartheaderbody clearfix">
			<div class="logo_con">
				<a href="javascript:void(0)" class="logo"></a>
				<a href="javascript:void(0)" class="link2">
					<b>购物车</b>
				</a>
			</div>
			<div class="cart_search">
				<div class="form">
					<input type="text" class="itxt" placeholder="自营">
					<input type="button" class="button" value="搜索">
				</div>
			</div>
		</div>
	</div>
</template>
<script>
	export default{
		name:"CartHeader"
	}
</script>
<style scoped>
	.cartheader{
    width: 100%;
		height: 75px;
		box-shadow: 0 3px 3px red;
	}
	/*头部*/
	.cartheaderbody {
		padding: 10px 0 0;
		width: 74%;
    margin: 0 auto;
	}
	/*头部的内层*/
	.logo_con {
		position: relative;
    float: left;
    width: 277px;
    height: 50px;
    margin: 15px 0 22px；
	}
	.clearfix:after {
    content: ".";
    display: block;
    height: 0;
    clear: both;
    visibility: hidden;
	}
	/*logo图片*/
	.logo {
		display: block;
    margin-top: 2px;
    width: 134px;
    height: 42px;
    background: url(~assets/img/registerlogo.png) no-repeat 0 0;
    background-size: 134px 42px;
	}
	.link2 {
    overflow: hidden;
    display: block;
    position: absolute;
    width: 100px;
    height: 40px;
    line-height: 40px;
    top: 9px;
    right: 45px;
    background: #fff;
    font-size: 20px;
    color: #333;
	}
	/*右侧搜索*/
	.cart_search {
    float: right;
    border: 2px solid #c91623;
    background: #c91623;
    height: 28px;
    margin-top: 18px;
    overflow: hidden;
	}
	/*输入框*/
	.cart_search .itxt {
    border: 0;
    height: 24px;
    line-height: 24px;
    width: 270px;
    padding: 3px 5px;
    outline: 0;
    font-size: 12px;
	}
	/*搜索按钮*/
	.cart_search .button {
    display: inline-block;
    vertical-align: top;
    width: 48px;
    height: 26px;
    line-height: 26px;
    background: #c91623;
    text-align: center;
    color: #fff;
    font-weight: 700;
    border: 0;
    font-size: 12px;
    outline: 0;
	}
</style>