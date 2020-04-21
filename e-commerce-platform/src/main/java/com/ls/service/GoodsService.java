package com.ls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ls.bean.Account;
import com.ls.dao.GoodsDao;
import com.ls.util.Result;


@Service
public class GoodsService {

	@Autowired
	GoodsDao dao;
	
	//查询密码
	public Result selectPassword(String account){
		Result result=new Result();
		try {
			result.setSuccess(true);
			result.setData(dao.selectPassword(account));
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result.setSuccess(false);
			result.setMessage("服务器错误！！");
			return result;
		}
	}
	
	//查询所有用户名
	public Result selectAllAccount(){
		Result result=new Result();
		try {
			result.setCode(1);
			result.setSuccess(true);
			result.setMessage("查询成功");
			result.setData(dao.selectAllAccount());
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result.setSuccess(false);
			result.setMessage("服务器错误！！");
			return result;
		}
	}
	//注册用户
	public Result registUser(Account user){
		Result result=new Result();
		try {
			result.setCode(1);
			result.setSuccess(true);
			result.setMessage("注册成功");
			dao.registUser(user);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result.setSuccess(false);
			result.setMessage("服务器错误！！");
			return result;
		}
	}
		
	
}
