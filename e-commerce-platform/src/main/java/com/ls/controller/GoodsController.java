package com.ls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ls.service.GoodsService;
import com.ls.util.Result;
import com.ls.bean.Account;
import com.ls.bean.Cart;

@RestController
@RequestMapping("/goods")
@CrossOrigin

public class GoodsController {

	@Autowired
	GoodsService service;
	
	//登录验证
	@GetMapping("/loginCheck")
	public Result loginCheck(String account,String password){
		//System.out.println(account+password);
		return service.loginCheck(account,password);
	}
	//查询所有用户名
	@GetMapping("/selectAllAccount")
	public Result selectAllAccount(){
		return service.selectAllAccount();
	}
	//注册用户
	@PostMapping("/registUser")
	public Result registUser(@RequestBody Account user){
		//System.out.println(user);
		return service.registUser(user);
	}
	//获取推荐商品
	@GetMapping("/recommendGoods")
	public Result recommendGoods(String account) {
		return service.recommendGoods(account);
	}
	//获取热款商品
	@GetMapping("/hotGoods")
	public Result hotGoods() {
		return service.hotGoods();
	}
	//搜索框查询商品
	@GetMapping("/selectGoods")
	public Result selectGoods(String title) {
		//System.out.println(title);
		return service.selectGoods(title);
	}
	//加入购物车
	@PostMapping("/addCart")
	public Result addCart(@RequestBody Cart cart){
		//System.out.println(cart);
		return service.addCart(cart);
	}
	//查询购物车
	@GetMapping("/selectCart")
	public Result selectCart(String accountid) {
		//System.out.println(accountid);
		return service.selectCart(accountid);
	}
	//更新购物车
	@PostMapping("/updateCart")
	public Result updateCart(@RequestBody Cart cart){
		//System.out.println(cart);
		return service.updateCart(cart);
	}
	//删除购物车单个东西
	@PostMapping("/deleteCart")
	public Result deleteCart(@RequestBody Cart cart){
		System.out.println(cart);
		return service.deleteCart(cart);
	}
	//修改密码
	@PostMapping("/updateUser")
	public Result updateUser(String id,String password){
		//System.out.println(cart);
		return service.updateUser(id,password);
	}
}
