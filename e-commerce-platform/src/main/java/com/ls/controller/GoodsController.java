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
import com.ls.bean.Admin;
import com.ls.bean.Cart;
import com.ls.bean.Goods;

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
		System.out.println(id+password);
		return service.updateUser(id,password);
	}
	//管理员登录验证
	@GetMapping("/adminCheck")
	public Result adminCheck(String account,String password){
		//System.out.println(account+password);
		return service.adminCheck(account,password);
	}
	//管理员查询所有用户
	@GetMapping("/adminSelectUser")
	public Result adminSelectUser(){
		//System.out.println(account+password);
		return service.adminSelectUser();
	}
	//管理员修改用户信息
	@PostMapping("/adminUpdateUser")
	public Result adminUpdateUser(@RequestBody Account user){
		//System.out.println(id+password);
		return service.adminUpdateUser(user);
	}
	//管理员删除用户信息
	@PostMapping("/adminDeleteUser")
	public Result adminDeleteUser(String id){
		//System.out.println(id+password);
		return service.adminDeleteUser(id);
	}
	//管理员增加用户信息
	@PostMapping("/adminAddUser")
	public Result adminAddUser(@RequestBody Account user){
		//System.out.println(user);
		return service.adminAddUser(user);
	}
	//管理员查询所有商品
	@GetMapping("/adminSelectGood")
	public Result adminSelectGood(){
		//System.out.println(account+password);
		return service.adminSelectGood();
	}
	//管理员增加商品信息
	@PostMapping("/adminAddGood")
	public Result adminAddGood(@RequestBody Goods good){
		//System.out.println(user);
		return service.adminAddGood(good);
	}
	//管理员修改商品信息
	@PostMapping("/adminUpdateGood")
	public Result adminUpdateGood(@RequestBody Goods good){
		//System.out.println(id+password);
		return service.adminUpdateGood(good);
	}
	//管理员删除商品信息
	@PostMapping("/adminDeleteGood")
	public Result adminDeleteGood(String id){
		//System.out.println(id+password);
		return service.adminDeleteGood(id);
	}
	//查询管理员账户
	@GetMapping("/selectAdmin")
	public Result selectAdmin(){
		//System.out.println(account+password);
		return service.selectAdmin();
	}
	//管理员修改个人信息
		@PostMapping("/updateAdmin")
		public Result updateAdmin(@RequestBody Admin admin){
			//System.out.println(id+password);
			return service.updateAdmin(admin);
		}
}
