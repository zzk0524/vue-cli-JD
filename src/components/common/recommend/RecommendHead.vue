<template>
	<div class="recommendhead">
		<div class="recommendhead_floorhd">
			<div class="recommendhead_floorhd_inner">
				<h3 class="recommendhead_floorhd_tit">为你推荐</h3>
			</div>
		</div>
		<div class="recommendhead_wrapper">
			<ul class="recommendhead_wrapper_feedtab">
				<li class="recommendhead_wrapper_feedtab_item" v-for="(item,index) in linum" :key="index">
					<div class="recommendhead_wrapper_feedtab_item_title">
						<span class="recommendhead_wrapper_feedtab_item_title_text">{{item.text}}</span>
					</div>
					<div class="recommendhead_wrapper_feedtab_item_desc">{{item.desc}}</div>
					<div class="recommendhead_wrapper_feedtab_item_gap"></div>
				</li>
			</ul>
		</div>
	</div>
</template>
<script>
	export default{
		name:"RecommendHead",
		data(){
			return{
				linum:[{text:"精选",desc:"猜你喜欢"},{text:"智能先锋",desc:"大电器城"},{text:"居家优品",desc:"品质生活"},{text:"超市百货",desc:"百货生鲜"},{text:"时尚达人",desc:"美妆穿搭"},{text:"进口好货",desc:"京东国际"}]
			}
		}
	}
</script>
<style scoped>
	/*推荐区的标题*/
	.recommendhead_floorhd {
		background-color: rgb(244,244,244);
    height: 65px;
	}
	/*标题的内层*/
	.recommendhead_floorhd_inner {
    margin: 0 auto;
    width: 1190px;
	}
	/*标题文字*/
	.recommendhead_floorhd_tit {
    position: relative;
    width: 180px;
    height: 45px;
    font-size: 28px;
    font-weight: 700;
    text-align: center;
    line-height: 45px;
    color: rgb(51, 51, 51);
    padding: 0px 30px;
    margin: 0px auto 20px;
    overflow: hidden;
	}
	/*标题左边的花纹*/
	.recommendhead_floorhd_tit::before {
    background-image: url(~assets/img/sprite.png);
    width: 25px;
    height: 20px;
    left: 0px;
    background-position: 0px 0px;
	}
	/*标题右边的花纹*/
	.recommendhead_floorhd_tit::after {
    background-image: url(~assets/img/sprite.png);
    width: 25px;
    height: 20px;
    right: 0px;
    background-position: -25px 0px;
	}
	/*花纹的共同样式*/
	.recommendhead_floorhd_tit::after, .recommendhead_floorhd_tit::before {
    content: "";
    position: absolute;
    top: 50%;
    margin-top: -10px;
	}
	/*推荐区的导航栏*/
	.recommendhead_wrapper{
    margin: 0 auto;
    width: 98%;
    margin-bottom: 10px;
    background: rgb(255, 255, 255);
	}
	/*内层*/
	.recommendhead_wrapper_feedtab{
		margin: 0 auto;
    height: 60px;
    width: 1080px;
	}
	/*每一个*/
	.recommendhead_wrapper_feedtab_item{
		position: relative;
    float: left;
    width: 180px;
    height: 60px;
    text-align: center;
    cursor: pointer;
    list-style: none;
	}
	/*每一个中的title*/
	.recommendhead_wrapper_feedtab_item_title {
    color: rgb(51, 51, 51);
    margin-top: 7px;
    font-size: 16px;
    font-weight: 700;
    line-height: 27px;
    height: 27px;
	}
	/*title文字*/
	.recommendhead_wrapper_feedtab_item_title_text {
    color: rgb(255, 255, 255);
    width: 90px;
    height: 27px;
    display: inline-block;
    background: rgb(225, 37, 27);
    border-radius: 50px;
    padding: 0px 5px;
	}
	/*描述*/
	.recommendhead_wrapper_feedtab_item_desc{
		font-size: 14px;
	}
	/*滑过变红*/
	.recommendhead_wrapper_feedtab_item_desc:hover{
		color: #e1251b;
	}
	/*分割线*/
	.recommendhead_wrapper_feedtab_item_gap {
    position: absolute;
    right: 0px;
    top: 0px;
    height: 40px;
    width: 1px;
    margin: 10px 0px;
    background: linear-gradient(white, rgb(223, 223, 223) 51%, white);
	}
</style>