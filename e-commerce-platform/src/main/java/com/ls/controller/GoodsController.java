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
		System.out.println(id+password);
		return service.updateUser(id,password);
	}
	//����Ա��¼��֤
	@GetMapping("/adminCheck")
	public Result adminCheck(String account,String password){
		//System.out.println(account+password);
		return service.adminCheck(account,password);
	}
	//����Ա��ѯ�����û�
	@GetMapping("/adminSelectUser")
	public Result adminSelectUser(){
		//System.out.println(account+password);
		return service.adminSelectUser();
	}
	//����Ա�޸��û���Ϣ
	@PostMapping("/adminUpdateUser")
	public Result adminUpdateUser(@RequestBody Account user){
		//System.out.println(id+password);
		return service.adminUpdateUser(user);
	}
	//����Աɾ���û���Ϣ
	@PostMapping("/adminDeleteUser")
	public Result adminDeleteUser(String id){
		//System.out.println(id+password);
		return service.adminDeleteUser(id);
	}
	//����Ա�����û���Ϣ
	@PostMapping("/adminAddUser")
	public Result adminAddUser(@RequestBody Account user){
		//System.out.println(user);
		return service.adminAddUser(user);
	}
	//����Ա��ѯ������Ʒ
	@GetMapping("/adminSelectGood")
	public Result adminSelectGood(){
		//System.out.println(account+password);
		return service.adminSelectGood();
	}
	//����Ա������Ʒ��Ϣ
	@PostMapping("/adminAddGood")
	public Result adminAddGood(@RequestBody Goods good){
		//System.out.println(user);
		return service.adminAddGood(good);
	}
	//����Ա�޸���Ʒ��Ϣ
	@PostMapping("/adminUpdateGood")
	public Result adminUpdateGood(@RequestBody Goods good){
		//System.out.println(id+password);
		return service.adminUpdateGood(good);
	}
	//����Աɾ����Ʒ��Ϣ
	@PostMapping("/adminDeleteGood")
	public Result adminDeleteGood(String id){
		//System.out.println(id+password);
		return service.adminDeleteGood(id);
	}
	//��ѯ����Ա�˻�
	@GetMapping("/selectAdmin")
	public Result selectAdmin(){
		//System.out.println(account+password);
		return service.selectAdmin();
	}
	//����Ա�޸ĸ�����Ϣ
		@PostMapping("/updateAdmin")
		public Result updateAdmin(@RequestBody Admin admin){
			//System.out.println(id+password);
			return service.updateAdmin(admin);
		}
}
