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
	
	//��ѯ����
	public Result selectPassword(String account){
		Result result=new Result();
		try {
			result.setSuccess(true);
			result.setData(dao.selectPassword(account));
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result.setSuccess(false);
			result.setMessage("���������󣡣�");
			return result;
		}
	}
	
	//��ѯ�����û���
	public Result selectAllAccount(){
		Result result=new Result();
		try {
			result.setCode(1);
			result.setSuccess(true);
			result.setMessage("��ѯ�ɹ�");
			result.setData(dao.selectAllAccount());
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result.setSuccess(false);
			result.setMessage("���������󣡣�");
			return result;
		}
	}
	//ע���û�
	public Result registUser(Account user){
		Result result=new Result();
		try {
			result.setCode(1);
			result.setSuccess(true);
			result.setMessage("ע��ɹ�");
			dao.registUser(user);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result.setSuccess(false);
			result.setMessage("���������󣡣�");
			return result;
		}
	}
		
	
}
