<template>
	<div class="cart">
		<div class="w">
			<div class="cart_filter_bar">
				<ul class="switch_cart">
					<li class="switch_cart_item">
						<a href="Javascript:void(0)">
							<em>全部商品</em>
							<span class="number">5</span>
						</a>
					</li>
				</ul>
				<div class="cart_store">
					<span class="label">配送至：</span>
					<div class="ui_area_wrap">
						<div class="ui_area_text_wrap">
							<div class="ui_area_text">山东济宁市曲阜市时庄街道</div>
							<b></b>
						</div>
					</div>
				</div>
				<div class="clr"></div>
				<div class="w_line">
					<div class="floater"></div>
				</div>
			</div>
		</div>
		<div class="cart_warp">
			<div class="w">
				<div class="jd_cart">
					<div class="cart_main">
						<div class="cart_thead">
							<div class="column t_checkbox">
								<div class="cart_checkbox">
									<input type="checkbox" class="jdcheckbox">
								</div>全选
							</div>
							<div class="column t_goods">商品</div>
							<div class="column t_props"></div>
							<div class="column t_price">单价</div>
							<div class="column t_quantity">数量</div>
							<div class="column t_sum">小计</div>
							<div class="column t_action">操作</div>
						</div>
						<div class="cart_list">
							<div class="cart_item_list">
								<div class="cart_tbody">
									<div class="item_list">
										<div class="item_full">
											<div class="item_header">
												<div class="f_txt">
													<span>森马旗舰店</span>
												</div>
											</div>
											<div class="item_item">
												<div class="item_form">
													<div class="cell p_checkbox">
														<div class="cart_checkbox">
															<input type="checkbox" class="jdcheckbox">
														</div>
													</div>
													<div class="cell p_goods">
														<div class="goods_item">
															<div class="p_img">
																<a href="javascript:void(0)">
																	<img src="//img10.360buyimg.com/cms/s80x80_jfs/t1/99599/10/13078/135225/5e55034dEd9ea2796/1d038e08cfe6b80c.jpg" alt="">
																</a>
															</div>
															<div class="item_msg">
																<div class="p_name">
																	<a href="javascript:void(0)">短袖t恤男条纹针织衫新款衣服春季打底衫时尚男士上衣圆领套头半袖 851 卡其 聚酯纤维 XL</a>
																</div>
															</div>
														</div>
													</div>
													<div class="cell p_price">
														<p class="plus_switch">
															<strong>￥198.00</strong>
														</p>
													</div>
													<div class="cell p_quantity">
														<div class="quantity_form">
															<a href="javascript:void(0)" class="decrement disabled">-</a>
															<input type="text" class="itxt" value="1">
															<a href="javascript:void(0)" class="increment">+</a>
														</div>
													</div>
													<div class="cell p_sum">
														<strong>￥198.00</strong>
													</div>
													<div class="cell p_ops">
														<a href="javascript:void(0)" class="cart_remove">删除</a>
													</div>
												</div>
												<div class="item_extra"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="cart_floatbar"></div>
			</div>
		</div>
	</div>
</template>
<script>
	export default{
		name:"CartContainer",
		methods:{
			getMessage(){
				console.log(this.$route.params.currentuser);
				console.log(this.$route.params.currentgood);
				console.log(this.$route.params.goodnum);
			}
		},
		mounted(){
			this.getMessage();//获得相关信息
		}
	}
</script>
<style scoped>
	/*清除浮动*/
	.clr {
    display: block;
    overflow: hidden;
    clear: both;
    height: 0;
    line-height: 0;
    font-size: 0;
	}
	/*整个内容部分*/
	.cart{
		margin-top: 30px;
	}
	/*全部商品内容*/
	.w {
    width: 990px;
    margin: 0 auto;
	}
	.cart_filter_bar{
		margin-top: 10px;
	}
	.switch_cart{
		float: left;
    height: 26px;
    overflow: hidden;
    list-style: none;
	}
	.switch_cart_item{
		float: left;
    font-weight: 700;
    font-size: 16px;
    height: 26px;
    line-height: 26px;
    text-align: center;
    padding: 0 0 10px;
    cursor: pointer;
    margin: 5px 30px 0 0;
	}
	.switch_cart_item a{
		color: #E2231A
	}
	/*全部商品文字*/
	.switch_cart_item a em{
		font-style: normal;
	}
	/*购物车商品的个数*/
	.number {
    font-family: verdana;
    font-size: 14px;
	}
	/*配送*/
	.cart_store{
		float: right;
		margin-bottom: 10px;
    padding-left: 122px;
	}
	/*配送至*/
	.label {
    float: left;
    line-height: 26px;
    font-size: 12px;
	}
	/*地址*/
	.ui_area_wrap{
		float: left;
    z-index: 3;
    height: 26px;
    cursor: default;
    margin: 0;
	}
	.ui_area_text_wrap{
		position: relative;
		float: left;
    top: 0;
    height: 23px;
    background: #fff;
    border: 1px solid #CECBCE;
    padding: 0 24px 0 4px;
    line-height: 23px;
    overflow: hidden;
	}
	/*地址文字*/
	.ui_area_text{
		line-height: 23px;
		cursor: default;
		font-size: 12px;
	}
	/*向下的箭头*/
	.ui_area_text_wrap b{
		display: block;
    position: absolute;
    top: 3px;
    right: 4px;
    width: 17px;
    height: 17px;
    background: url(~assets/img/ui_area_text_wrap.png) no-repeat 3px 5px;
    overflow: hidden;
	}
	/*红线*/
	.w_line {
    position: relative;
    height: 1px;
    background: #e0e0e0;
	}
	/*红线*/
	.floater {
    position: absolute;
    height: 2px;
    background: #E2231A;
   	width: 79px;
    left: 0px;
    overflow: hidden;
	}
	/*商品内容*/
	.cart_warp {
    background: #fff;
    margin-bottom: 20px;
	}
	/*每栏的名称*/
	.cart_thead{
    height: 43px;
    line-height: 43px;
    margin: 0 0 10px;
    padding: 5px 0;
    background: #f3f3f3;
    border: 1px solid #e9e9e9;
    border-top: 0;
	}
	/*每栏都左浮*/
	.column {
    float: left;
    font-size: 12px;
	}
	/*全选模块*/
	.t_checkbox {
    height: 32px;
    line-height: 32px;
    width: 133px;
    padding-left: 11px;
    font-size: 12px;
	}
	.cart_checkbox{
		float: left;
    margin-right: 5px;
	}
	.jdcheckbox{
		vertical-align: middle;
		margin: 0 3px 0 0;
    padding: 0;
	}
	/*商品*/
	.t_goods {
    width: 208px;
    height: 32px;
    line-height: 32px;
	}
	/*空的*/
	.t_props {
    width: 80px;
    height: 32px;
    padding: 0 10px 0 20px;
		line-height: 32px;
	}
	/*单价*/
	.t_price {
    width: 160px;
    height: 32px;
    padding-right: 40px;
    text-align: right;
    line-height: 32px;
	}
	/*数量*/
	.t_quantity {
    width: 80px;
    height: 32px;
    text-align: center;
		line-height: 32px;
		margin-left: 20px;
	}
	/*小计*/
	.t_sum {
    width: 140px;
    height: 32px;
    padding-right: 40px;
    text-align: right;
    line-height: 32px;
	}
	/*操作*/
	.t_action {
		height: 32px;
    width: 75px;
    line-height: 32px;
    margin-left: 40px;
	}
	/*每个商品*/
	.cart_item_list{
		margin-bottom: 20px;
	}
	/*内部盒子*/
	.cart_tbody {
    font-family: "Microsoft YaHei",SimSun,verdana;
	}
	/*内容盒子*/
	.item_list {
    border-style: solid;
    border-width: 2px 1px 1px;
    border-color: #aaa #f1f1f1 #f1f1f1;
    background: #fff;
	}
	.item_header {
    background: #fff;
    position: relative;
    height: 26px;
    padding: 5px 10px;
    line-height: 26px;
    color: #999;
	}
	.f_txt {
    float: left;
    width: 740px;
    white-space: nowrap;
    text-overflow: ellipsis;
	}
	/*店铺名*/
	.f_txt span {
		display: inline-block;
		font-size: 12px;
    background: #fff;
    color: #f48719;
    border: 1px solid #f48719;
    padding: 1px 10px;
    height: 21px;
    line-height: 16px;
    margin: 0 10px 0 5px;
	}
	/*店铺名下面内容*/
	.item_item {
    border: 0;
    padding: 0 0 1px 40px;
    line-height: 20px;
    background: #fff;
	}
	.item_form {
    border-top: 1px solid #f1f1f1;
    position: relative;
	}
	.item_form:after {
    content: ".";
    display: block;
    height: 0;
    clear: both;
    visibility: hidden;
	}
	.cell {
    float: left;
    padding: 15px 0 10px;
	}
	/*选择按钮*/
	.p_checkbox {
    position: absolute;
    left: -28px;
    top: 26px;
    width: 30px;
    min-height: 10px;
	}
	.cart_checkbox {
    position: relative;
    float: left;
    margin-right: 5px;
	}
	/*图片与文字*/
	.p_goods {
    width: 300px;
    margin-right: 115px;
	}
	.p_img {
    float: left;
    width: 80px;
    height: 80px;
    border: 1px solid #eee;
    margin-right: 10px;
    background: #fff;
    padding: 0;
    text-align: center;
    overflow: hidden;
	}
	img {
    border: 0;
    vertical-align: middle;
	}
	.p_name {
    height: 40px;
    line-height: 20px;
    overflow: hidden;
	}
	.p_name a{
		color: #333;
		font-size: 12px;
	}
	/*单价*/
	.p_price {
    width: 150px;
    padding-right: 40px;
    font-family: verdana;
    text-align: right;
    overflow: hidden;
    margin-top: 25px;
  }
  .p_price strong {
    display: block;
    color: #333;
    font-weight: 400;
    cursor: pointer;
    font-size: 12px;
	}
	.p_quantity {
    width: 80px;
    margin-top: 25px;
	}
	.quantity_form {
    position: relative;
    overflow: hidden;
    height: 22px;
    width: 84px;
	}
	.disabled{
    cursor: not-allowed;
    color: #e9e9e9;
	}
	/*减号*/
	.decrement {
    float: left;
    border: 1px solid #cacbcb;
    border-right: 0;
    height: 20px;
    line-height: 14px;
    padding: 1px 0;
    width: 20px;
    text-align: center;
    color: #666;
    margin: 0;
    background: #fff;
    outline: none;
	}
	/*数量*/
	.itxt {
    position: absolute;
    left: 20px;
    top: 0;
    border: 1px solid #cacbcb;
    width: 44px;
    height: 20px;
    line-height: 20px;
    text-align: center;
    padding: 1px;
    margin: 0;
    font-size: 12px;
    font-family: verdana;
    color: #333;
    -webkit-appearance: none;
	}
	/*加号*/
	.increment {
    float: right;
    border: 1px solid #cacbcb;
    border-left: 0;
    height: 20px;
    line-height: 16px;
    padding: 1px 0;
    width: 20px;
    text-align: center;
    color: #666;
    margin: 0;
    background: #fff;
    outline: none;
	}
	/*总价*/
	.p_sum {
    width: 100px;
    padding-right: 40px;
    text-align: right;
    font-family: verdana;
    margin-left: 65px;
    margin-top: 25px;
	}
	.p_sum strong {
    color: #333;
    font-weight: 700;
    display: block;
    font-size: 12px;
	}
	/*删除*/
	.p_ops {
    width: 75px;
    position: relative;
    margin-left: 10px;
    margin-top: 25px;
	}
	.p_ops a {
    color: #666;
    display: block;
    font-size: 12px;
	}
	.item_extra {
    position: relative;
    margin-bottom: 10px;
	}
</style>