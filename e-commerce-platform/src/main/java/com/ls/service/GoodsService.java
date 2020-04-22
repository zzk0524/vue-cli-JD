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
	
	//��¼��֤
	public Result loginCheck(String account,String password){
		Result result=new Result();
		try {
			if(dao.accountCheck(account)==null) {
				result.setMessage("�û���������");
				result.setCode(0);
				result.setSuccess(false);
				return result;
			}else {
				Account usercheck = dao.passwordCheck(account);
				if(usercheck.getPassword().toString().equals(password)) {
					result.setData(usercheck);
					result.setMessage("��¼�ɹ�");
					result.setCode(1);
					result.setSuccess(true);
					return result;
				}else {
					result.setMessage("�������");
					result.setCode(0);
					result.setSuccess(false);
					return result;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			result.setSuccess(false);
			result.setMessage("���������󣡣�");
			System.out.println(e);
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
