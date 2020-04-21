<template>
	<div class="recommendbody">
		<div class="recommendbody_inner">
			<ul class="recommendbody_list">
				<li class="recommendbody_item" v-for="(item,index) in personrecommend" :key="index">
					<a href="" class="recommendbody_item_lk">
						<div class="lazyimg recommendbody_img">
							<img src="~assets/img/logo.png" alt="" class="lazyimg_img">
						</div>
						<div class="recommendbody_info">
							<p class="recommendbody_info_name">{{item.name}}</p>
							<div class="recommendbody_info_price">
								<div class="recommendbody_price">
									<span class="recommendbody_info_price_txt">{{item.price}}</span>
								</div>
							</div>
						</div>
					</a>
				</li>
				<!-- <li class="recommendbody_item">
					<a href="" class="recommendbody_item_lk">
						<div class="lazyimg recommendbody_img">
							<img src="~assets/img/logo.png" alt="" class="lazyimg_img">
						</div>
						<div class="recommendbody_info">
							<p class="recommendbody_info_name">【99元两条】牛仔裤男2020春季新款男士修身弹力牛仔长裤小脚裤男裤子男装休闲裤Q13 K159蓝色 送 K01黑色裤子 31</p>
							<div class="recommendbody_info_price">
								<div class="recommendbody_price">
									<span class="recommendbody_info_price_txt">￥99.00</span>
								</div>
							</div>
						</div>
					</a>
				</li>
				<li class="recommendbody_item">
					<a href="" class="recommendbody_item_lk">
						<div class="lazyimg recommendbody_img">
							<img src="~assets/img/logo.png" alt="" class="lazyimg_img">
						</div>
						<div class="recommendbody_info">
							<p class="recommendbody_info_name">【99元两条】牛仔裤男2020春季新款男士修身弹力牛仔长裤小脚裤男裤子男装休闲裤Q13 K159蓝色 送 K01黑色裤子 31</p>
							<div class="recommendbody_info_price">
								<div class="recommendbody_price">
									<span class="recommendbody_info_price_txt">￥99.00</span>
								</div>
							</div>
						</div>
					</a>
				</li>
				<li class="recommendbody_item">
					<a href="" class="recommendbody_item_lk">
						<div class="lazyimg recommendbody_img">
							<img src="~assets/img/logo.png" alt="" class="lazyimg_img">
						</div>
						<div class="recommendbody_info">
							<p class="recommendbody_info_name">【99元两条】牛仔裤男2020春季新款男士修身弹力牛仔长裤小脚裤男裤子男装休闲裤Q13 K159蓝色 送 K01黑色裤子 31</p>
							<div class="recommendbody_info_price">
								<div class="recommendbody_price">
									<span class="recommendbody_info_price_txt">￥99.00</span>
								</div>
							</div>
						</div>
					</a>
				</li>
				<li class="recommendbody_item">
					<a href="" class="recommendbody_item_lk">
						<div class="lazyimg recommendbody_img">
							<img src="~assets/img/logo.png" alt="" class="lazyimg_img">
						</div>
						<div class="recommendbody_info">
							<p class="recommendbody_info_name">【99元两条】牛仔裤男2020春季新款男士修身弹力牛仔长裤小脚裤男裤子男装休闲裤Q13 K159蓝色 送 K01黑色裤子 31</p>
							<div class="recommendbody_info_price">
								<div class="recommendbody_price">
									<span class="recommendbody_info_price_txt">￥99.00</span>
								</div>
							</div>
						</div>
					</a>
				</li> -->
			</ul>
		</div>
	</div>
</template>
<script>
	export default{
		name:"RecommendBody",
		data(){
			return{
				personrecommend:[
					{name:"【99元两条】牛仔裤男2020春季新款男士修身弹力牛仔长裤小脚裤男裤子男装休闲裤Q13 K159蓝色 送 K01黑色裤子 31",price:"￥99.00"},
					{name:"【99元两条】牛仔裤男2020春季新款男士修身弹力牛仔长裤小脚裤男裤子男装休闲裤Q13 K159蓝色 送 K01黑色裤子 31",price:"￥99.00"},
					{name:"【99元两条】牛仔裤男2020春季新款男士修身弹力牛仔长裤小脚裤男裤子男装休闲裤Q13 K159蓝色 送 K01黑色裤子 31",price:"￥99.00"},
					{name:"【99元两条】牛仔裤男2020春季新款男士修身弹力牛仔长裤小脚裤男裤子男装休闲裤Q13 K159蓝色 送 K01黑色裤子 31",price:"￥99.00"},
					{name:"【99元两条】牛仔裤男2020春季新款男士修身弹力牛仔长裤小脚裤男裤子男装休闲裤Q13 K159蓝色 送 K01黑色裤子 31",price:"￥99.00"},
					{name:"【99元两条】牛仔裤男2020春季新款男士修身弹力牛仔长裤小脚裤男裤子男装休闲裤Q13 K159蓝色 送 K01黑色裤子 31",price:"￥99.00"},
					{name:"【99元两条】牛仔裤男2020春季新款男士修身弹力牛仔长裤小脚裤男裤子男装休闲裤Q13 K159蓝色 送 K01黑色裤子 31",price:"￥99.00"}
				]
			}
		},
		methods:{

		},
		mounted(){
			//获得用户id,并发送ajax请求推荐，存到personrecommend
		}
	}
</script>
<style scoped>
	.recommendbody {
    margin: 0 auto;
    width: 1190px;
	}	
	.recommendbody:after{
		display: block;
		content: "";
		clear: both;
	}
	.recommendbody_list {
    margin: 0 -5px;
	}
	/*每个商品框*/
	.recommendbody_item {
    position: relative;
    float: left;
    width: 230px;
    height: 322px;
    margin: 0 5px 10px;
    background: #fff;
    list-style: none;
	}
	.recommendbody_item_lk{
		display: inline-block;
    width: 100%;
    height: 100%;
	}
	.recommendbody_info {
    clear: both;
    line-height: 24px;
    padding: 0 20px;
    height: 65px;
	}
	.recommendbody_info_name {
    height: 48px;
    font-size: 14px;
    line-height: 24px;
    text-align: left;
    color: #666;
    word-break: break-all;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
	}
	.recommendbody_info_price {
    margin-top: 10px;
	}
	.recommendbody_price{
		float: left;
    width: 75px;
    text-align: left;
    display: inline-block;
    font-size: 16px;
    line-height: 18px;
    height: 18px;
    color: #e1251b;
	}
	.recommendbody_info_price_txt {
    font-size: 20px;
    font-weight: 700;
    font-family: arial,sans-serif;
	}
	.lazyimg_img{
		width: 100%;
		height: 100%;
	}
</style>