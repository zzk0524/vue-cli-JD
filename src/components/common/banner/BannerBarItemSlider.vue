<template>
	<div class="banner-bar-item-slider" id="banner-bar-item-slider">
		<div class="banner_slide" id="banner_slide">
			<slot></slot>
		</div>
		<a href="javascript:void(0)" class="button prev" id="prev"></a>
		<a href="javascript:void(0)" class="button next" id="next"></a>
		<div class="dots" id="dots">
			<span v-for="item in dotsnum" :key="item"></span>
		</div>
	</div>
</template>
<script>
	export default{
		name:"BannerBarItemSlider",
		data(){
			return{
				dotsnum:[]
			}
		},
		methods:{
			startAutoPlay(bannerbaritemslider,bannerimg,dots,timer,index,size){
				let that = this;
				bannerbaritemslider.addEventListener("mouseover",function(){//鼠标移入停止播放
					 if(timer){
				    		clearInterval(timer);
					 }
				});
				timer = setInterval(function(){//自动播放
				  index++;
				  if(index >= size){
				   index = 0;
				  }
				  that.changeImg(bannerimg,dots,index,size);
				},3000);
			},
			changeImg(bannerimg,dots,index,size){//核心，显示哪张
   			for(let i=0;i<size;i++){
       		dots[i].className = "";
       		bannerimg[i].classList.add("divnone");
   			}
   			dots[index].className = "active";
   			bannerimg[index].classList.remove("divnone");
			},
			slideImg(bannerimg,dots,timer,index,size){//图片轮播整合
				let that = this;
				let bannerbaritemslider = document.getElementById("banner-bar-item-slider");
				that.startAutoPlay(bannerbaritemslider,bannerimg,dots,timer,index,size);//自动播放
				bannerbaritemslider.addEventListener("mouseout",function(){
					that.startAutoPlay(bannerbaritemslider,bannerimg,dots,timer,index,size);
				});
    	  /*点击小点点*/
    	  for(let i=0;i<size;i++){
		      dots[i].id = i;
		      dots[i].addEventListener("click",function(){
			      index = this.id;
			      that.changeImg(bannerimg,dots,index,size);
		      });
		    }
		    /*下一张按钮*/
		    next.addEventListener("click",function(){
		    	index++;
		      if(index>=size){
		      	index=0;
		      } 
		      that.changeImg(bannerimg,dots,index,size);
		    });
		    /*上一张按钮*/
		    prev.addEventListener("click",function(){
		    	index--;
		      if(index<0){
		      	index=size-1;
		      } 
		      that.changeImg(bannerimg,dots,index,size);
		    });
			},
			sliderWrapper(){//图片轮播准备工作
				let bannerslide = document.getElementById("banner_slide"),
				    bannerimg = bannerslide.getElementsByTagName("img");
				let dot = document.getElementById("dots"),
						dots = dot.getElementsByTagName("span"),
				    next = document.getElementById("next"),
				    prev = document.getElementById("prev");
					  dots[0].className = "active";
				let timer = null,
						index = 0,
						size = bannerimg.length;
				this.slideImg(bannerimg,dots,timer,index,size);//调用图片轮播函数
			},
			applydotsnum(){
				let bannerslide = document.getElementById("banner_slide"),
				  bannerimg = bannerslide.getElementsByTagName("img");
				  this.dotsnum = Array.from(bannerimg).map((item,index)=>{
					return index+1;
				});
			}
		},
		mounted(){
			/*v-for的渲染*/
			this.applydotsnum();
			/*渲染完再js*/
			this.$nextTick(() => {
			 	this.sliderWrapper();
			})
		}
	}
</script>
<style scoped> 
	/*隐藏类*/
	.divnone{
		display: none !important;
	}
	/*图片轮播区域*/
	.banner-bar-item-slider{
		width: 790px;
		height: 480px;
		margin-left: 10px;
		position:relative;
		overflow:hidden;
	}
	/*图片轮播区的内层*/
	.banner_slide{
		width: 790px;
		height: 480px;
	}
	/*每个图片*/
	.banner_slide>img{
		display: block;
		width: 790px;
		height: 480px;
		float: left;
		cursor: pointer;
	}
	/*图片轮播的两个按钮*/
	.button{
	  position: absolute;
	  transform:rotate(180deg);
	  top: 50%;
	  left: 0px;
	  height: 80px;
	  width: 40px;
	  margin-top:-40px;
	  background:url(~assets/img/arrow.png) center center no-repeat;
	}
	/*图片轮播右边的按钮*/
	.next{
		transform:rotate(0deg);
		left:auto;
		right:0;
	}
	/*滑过按钮*/
	.button:hover{
		background-color:#333;
		opacity: 0.8;
		filter:alpha(opacity=80);
	}
	/*小点点*/
	.dots {
		position: absolute;
		bottom: 24px;
		right: 0;
		text-align: right;
		padding-right: 24px;
		line-height: 12px;
	}
	/*小点点*/
	.dots span {
		display: inline-block;
		width: 12px;
		height: 12px;
		border-radius: 50%;
		margin-left: 8px;
		background-color: rgba(7, 17, 27, 0.4);
		cursor: pointer;
		box-shadow: 0 0 0 2px rgba(255, 255, 255, 0.8) inset;
	}
	/*活跃状态的小点点*/
	.dots span.active{
		box-shadow: 0 0 0 2px rgba(7, 17, 27, 0.4) inset;
		background-color: #ffffff;
	}
</style>