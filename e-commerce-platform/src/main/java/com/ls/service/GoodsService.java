package com.ls.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ls.bean.Account;
import com.ls.bean.Cart;
import com.ls.bean.Goods;
import com.ls.util.CartID3;
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
			//System.out.println(e);
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
			List<Cart> usercart = dao.currentUserCart(account);
//			System.out.println(usercart);
			System.out.println(usercart.size()==0);
			List<Goods> recommendgood = new ArrayList<Goods>();
			List<Goods> recommendgood1 = new ArrayList<Goods>();
			List<Goods> recommendgood2 = new ArrayList<Goods>();
			if(usercart.size()!=0) {//���û����ﳵ�����ж���
				List<Goods> alist1 = dao.recommendGoods();//������Ʒ
				ArrayList<String> blist1 = new ArrayList<String>();//������Ʒ
				ArrayList<String> clist1 = new ArrayList<String>();//���û����ﳵ�е���Ʒ
				ArrayList<String> favarr1 = new ArrayList<String>();
				for(int i=0;i<alist1.size();i++) {
					blist1.add(alist1.get(i).getTitle().toString());
				}
				for(int i=0;i<usercart.size();i++) {
					clist1.add(usercart.get(i).getGoodtitle().toString());
					favarr1.add("Ŀ��"+usercart.get(i).getGoodtype().toString());
				}
				ArrayList<String> favarr2 = new ArrayList<String>();//�Ѹ����û����ﳵÿһ����Ʒ�Ƽ���������Ʒid���浽����
				for(int i=0;i<clist1.size();i++) {//�м�����Ʒ��ִ�м���
					CartID3 cartid = new CartID3(clist1.get(i).toString(),blist1);
					String[] recommend = cartid.getKind();//��ȡÿһ��ϲ�õĽ��
					for(int j=0;j<recommend.length;j++) {
						if(recommend[j].equals(favarr1.get(i).toString())) {
							System.out.println(recommend[j]);
							favarr2.add(Integer.toString(j));
						}
					}
				}
				for(int i=0;i<favarr2.size();i++) {
					recommendgood1.add(alist1.get(Integer.parseInt(favarr2.get(i))));
				}
			}
			ArrayList<String> alist = new ArrayList<String>();
			List<Goods> blist = dao.recommendGoods();
			Account user = dao.recommendGoodsUser(account);
			String[] favarr = user.getFavourite().toString().split(",");//favarr������û���ÿ��ϲ��
			for(int i=0;i<blist.size();i++) {
				alist.add(blist.get(i).getTitle().toString());
			}
			ArrayList<String> favarr0 = new ArrayList<String>();//���û�����ϲ�õķ�����������Ʒid���浽����
			for(int i=0;i<favarr.length;i++) {//�м���ϲ�ã�ִ�м���
				ID3 id = new ID3(favarr[i],alist);
				String[] recommend = id.getKind();//��ȡÿһ��ϲ�õĽ��
				for(int j=0;j<recommend.length;j++) {
					if(recommend[j].equals(favarr[i])) {
						favarr0.add(Integer.toString(j));
					}
				}
			}
			for(int i=0;i<favarr0.size();i++) {
				recommendgood2.add(blist.get(Integer.parseInt(favarr0.get(i))));
			}
			if(recommendgood1.size()!=0) {//���ﳵ�Ƽ�+ϲ���Ƽ�
				for(int i=0;i<recommendgood1.size();i++) {
					recommendgood.add(recommendgood1.get(i));
				}
				for(int i=0;i<recommendgood2.size();i++) {
					recommendgood.add(recommendgood2.get(i));
				}
			}else {
				for(int i=0;i<recommendgood2.size();i++) {
					recommendgood.add(recommendgood2.get(i));
				}
			}
			System.out.println(recommendgood.size());
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
			//System.out.println(e);
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
			//System.out.println(e);
			result.setMessage("���������󣡣�");
			return result;
		}
	}
	//���빺�ﳵ
	public Result addCart(Cart cart){
		Result result=new Result();
		try {
			if(!dao.selectCartgood(cart.getAccountid(),cart.getGoodid()).isEmpty()) {//������ﳵ���������Ʒ��ֻ������
				dao.updateCart(cart.getAccountid(),cart.getGoodid(),cart.getGoodnum(),cart.getGoodsumprice());
				result.setCode(1);
				result.setSuccess(true);
				result.setMessage("����ɹ�");
			}else {//ֱ�Ӽ�
				dao.addCart(cart);
				result.setCode(1);
				result.setSuccess(true);
				result.setMessage("����ɹ�");
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			result.setSuccess(false);
			result.setMessage("���������󣡣�");
			return result;
		}
	}
	//��ѯĳ���û��Ĺ��ﳵ
	public Result selectCart(String accountid){
		Result result=new Result();
		try {
			result.setCode(1);
			result.setSuccess(true);
			result.setMessage("��ѯ�ɹ�");
			result.setData(dao.selectCart(accountid));
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result.setSuccess(false);
			result.setMessage("���������󣡣�");
			return result;
		}
	}
	//���¹��ﳵ
	public Result updateCart(Cart cart){
		Result result=new Result();
		try {
			dao.optCart(cart.getAccountid(),cart.getGoodid(),cart.getGoodnum(),cart.getGoodsumprice());
			result.setCode(1);
			result.setSuccess(true);
			result.setMessage("����ɹ�");
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			result.setSuccess(false);
			result.setMessage("���������󣡣�");
			return result;
		}
	}
	//ɾ�����ﳵĳ����Ʒ
	public Result deleteCart(Cart cart){
		Result result=new Result();
		try {
			dao.deleteGood(cart.getAccountid(),cart.getGoodid());
			result.setCode(1);
			result.setSuccess(true);
			result.setMessage("ɾ���ɹ�");
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
