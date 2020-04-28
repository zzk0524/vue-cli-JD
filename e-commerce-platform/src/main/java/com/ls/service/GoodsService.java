package com.ls.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ls.bean.Account;
import com.ls.bean.Goods;
import com.ls.util.ID3;
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
		
	//�Ƽ���Ʒ
	public Result recommedGoods(String account) {
		Result result=new Result();
		try {
			ArrayList<String> alist = new ArrayList<String>();
			List<Goods> blist = dao.recommedGoods();
			Account user = dao.recommedGoodsUser(account);
			for(int i=0;i<blist.size();i++) {
				alist.add(blist.get(i).getTitle().toString());
			}
			ID3 id = new ID3(user.getFavourite().toString(),alist);
		//	System.out.println(id);
			String[] recommed = id.getKind();
			for(int i=0;i<recommed.length;i++) {
				System.out.println("��ƷidΪ"+(i+1)+"����:"+recommed[i]);
			}
//			String[] favarr = user.getFavourite().toString().split(",");
//			ArrayList<String> labels=new ArrayList<String>();
//			ArrayList<ArrayList<String>> dates=new ArrayList<ArrayList<String>>();//ѵ�����ݼ�
//			//���û������ַ����浽������ȥ
//			System.out.println(favarr[0]);
//			System.out.println(favarr[0] instanceof String);
//			System.out.println(favarr[0]=="��������");
//			if(favarr[0].equals("��������")) {//Ŀǰֻ��Գ�������ʵ�ֹ���
//				System.out.println("�Ե�");
//				String[] labelstr = new String[] {"����","��ʽ","��������"};
//				for(int i=0;i<labelstr.length;i++){
//					labels.add(labelstr[i]);//���������ǩ
//				}
//				//��ѵ������
//				String[][] datestr = new String[][] {{"�˶�","�¿�","��������"},{"����","�¿�","��������"},{"����","�¿�","��ͨ����"},{"�˶�","��ͨ","��ͨ����"},{"����","��ͨ","��ͨ����"},{"����","��ͨ","��ͨ����"}};
//				ArrayList<String> line=null;
//				for(int i=0;i<datestr.length;i++) {
//					line = new ArrayList<String>();
//					for(int j=0;j<datestr[i].length;j++) {
//						line.add(datestr[i][j]);
//					}
//					dates.add(line);//���ѵ������
//				}
//			}
//			System.out.println(labels);
//			//System.out.println(labels.get(0));
//			System.out.println(dates);
//			//System.out.println(dates.get(0));
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			result.setSuccess(false);
			result.setMessage("���������󣡣�");
			return result;
		}
	}
}
