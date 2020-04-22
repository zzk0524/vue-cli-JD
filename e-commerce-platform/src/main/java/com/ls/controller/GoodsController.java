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

@RestController
@RequestMapping("/goods")
@CrossOrigin

public class GoodsController {

	@Autowired
	GoodsService service;
	
	//登录验证
	@GetMapping("/loginCheck")
	public Result loginCheck(String account,String password){
		System.out.println(account+password);
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
}
