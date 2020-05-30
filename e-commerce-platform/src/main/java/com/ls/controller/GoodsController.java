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
	
	//��¼��֤
	@GetMapping("/loginCheck")
	public Result loginCheck(String account,String password){
		//System.out.println(account+password);
		return service.loginCheck(account,password);
	}
	//��ѯ�����û���
	@GetMapping("/selectAllAccount")
	public Result selectAllAccount(){
		return service.selectAllAccount();
	}
	//ע���û�
	@PostMapping("/registUser")
	public Result registUser(@RequestBody Account user){
		//System.out.println(user);
		return service.registUser(user);
	}
	//��ȡ�Ƽ���Ʒ
	@GetMapping("/recommendGoods")
	public Result recommendGoods(String account) {
		return service.recommendGoods(account);
	}
	//��ȡ�ȿ���Ʒ
	@GetMapping("/hotGoods")
	public Result hotGoods() {
		return service.hotGoods();
	}
	//�������ѯ��Ʒ
	@GetMapping("/selectGoods")
	public Result selectGoods(String title) {
		//System.out.println(title);
		return service.selectGoods(title);
	}
	//���빺�ﳵ
	@PostMapping("/addCart")
	public Result addCart(@RequestBody Cart cart){
		//System.out.println(cart);
		return service.addCart(cart);
	}
	//��ѯ���ﳵ
	@GetMapping("/selectCart")
	public Result selectCart(String accountid) {
		//System.out.println(accountid);
		return service.selectCart(accountid);
	}
	//���¹��ﳵ
	@PostMapping("/updateCart")
	public Result updateCart(@RequestBody Cart cart){
		//System.out.println(cart);
		return service.updateCart(cart);
	}
	//ɾ�����ﳵ��������
	@PostMapping("/deleteCart")
	public Result deleteCart(@RequestBody Cart cart){
		System.out.println(cart);
		return service.deleteCart(cart);
	}
	//�޸�����
	@PostMapping("/updateUser")
	public Result updateUser(String id,String password){
		//System.out.println(cart);
		return service.updateUser(id,password);
	}
}
