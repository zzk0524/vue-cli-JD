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
	public Result recommendGoods(String account) {
		Result result=new Result();
		try {
			ArrayList<String> alist = new ArrayList<String>();
			List<Goods> blist = dao.recommendGoods();
			Account user = dao.recommendGoodsUser(account);
			String[] favarr = user.getFavourite().toString().split(",");//favarr������û���ÿ��ϲ��
			for(int i=0;i<blist.size();i++) {
				alist.add(blist.get(i).getTitle().toString());
			}
			ArrayList<String> favarr0 = new ArrayList<String>();//���û�����ϲ�õķ�����������Ʒid���浽����
			for(int i=0;i<favarr.length;i++) {//�м���ϲ�ã�ִ�м���
				//System.out.println(favarr[i]);
				ID3 id = new ID3(favarr[i],alist);
				String[] recommend = id.getKind();//��ȡÿһ��ϲ�õĽ��
				for(int j=0;j<recommend.length;j++) {
					//System.out.println("��ƷidΪ"+(j+1)+"����:"+recommend[j]);
					if(recommend[j].equals(favarr[i])) {
						favarr0.add(Integer.toString(j));
						//System.out.println("��ƷidΪ"+(j+1)+"����:"+recommend[j]);
						//System.out.println(favarr0.get(j));
					}
				}
//				for(int j=0;i<favarr0.size();i++) {
//					System.out.println(favarr0.get(j));
//					//recommendgood.add(blist.get(Integer.parseInt(favarr0.get(i))));
//				}
			}
			//System.out.println(favarr0);
			List<Goods> recommendgood = new ArrayList<Goods>();
			for(int i=0;i<favarr0.size();i++) {
				System.out.println(favarr0.get(i));
				recommendgood.add(blist.get(Integer.parseInt(favarr0.get(i))));
			}
			result.setCode(1);
			result.setSuccess(true);
			result.setMessage("�Ƽ��ɹ�");
			result.setData(recommendgood);//���ڴ��û�������ϲ���Ƽ���������Ʒ
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			result.setSuccess(false);
			result.setMessage("���������󣡣�");
			return result;
		}
	}
	//�ȿ���Ʒ
	public Result hotGoods(){
		Result result=new Result();
		try {
			List<Goods> hotgood = new ArrayList<Goods>();
			List<Goods> hotgoods = new ArrayList<Goods>();
			hotgood = dao.hotGoods();
			for(int i=0 ;i<hotgood.size();i++) {
				if(hotgood.get(i).getComments().length()>=5&&hotgood.get(i).getComments().indexOf(".")==-1) {
					hotgoods.add(hotgood.get(i));
				}
			}
			result.setCode(1);
			result.setSuccess(true);
			result.setMessage("�ȿ��Ƽ��ɹ�");
			result.setData(hotgoods);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result.setSuccess(false);
			System.out.println(e);
			result.setMessage("���������󣡣�");
			return result;
		}
	}
	//�������в�ѯ��Ʒ
	public Result selectGoods(String title) {
		Result result=new Result();
		try {
			result.setCode(1);
			result.setSuccess(true);
			result.setMessage("��ѯ�ɹ�");
			result.setData(dao.selectGoods(title));
			return result;
		}catch(Exception e) {
			result.setSuccess(false);
			System.out.println(e);
			result.setMessage("���������󣡣�");
			return result;
		}
	}
}
