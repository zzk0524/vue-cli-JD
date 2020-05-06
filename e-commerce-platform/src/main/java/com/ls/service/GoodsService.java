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
	
	//登录验证
	public Result loginCheck(String account,String password){
		Result result=new Result();
		try {
			if(dao.accountCheck(account)==null) {
				result.setMessage("用户名不存在");
				result.setCode(0);
				result.setSuccess(false);
				return result;
			}else {
				Account usercheck = dao.passwordCheck(account);
				if(usercheck.getPassword().toString().equals(password)) {
					result.setData(usercheck);
					result.setMessage("登录成功");
					result.setCode(1);
					result.setSuccess(true);
					return result;
				}else {
					result.setMessage("密码错误");
					result.setCode(0);
					result.setSuccess(false);
					return result;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			result.setSuccess(false);
			result.setMessage("服务器错误！！");
			System.out.println(e);
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
		
	//推荐商品
	public Result recommendGoods(String account) {
		Result result=new Result();
		try {
			ArrayList<String> alist = new ArrayList<String>();
			List<Goods> blist = dao.recommendGoods();
			Account user = dao.recommendGoodsUser(account);
			String[] favarr = user.getFavourite().toString().split(",");//favarr数组存用户的每个喜好
			for(int i=0;i<blist.size();i++) {
				alist.add(blist.get(i).getTitle().toString());
			}
			ArrayList<String> favarr0 = new ArrayList<String>();//把用户所有喜好的符合条件的商品id都存到里面
			for(int i=0;i<favarr.length;i++) {//有几个喜好，执行几遍
				//System.out.println(favarr[i]);
				ID3 id = new ID3(favarr[i],alist);
				String[] recommend = id.getKind();//获取每一个喜好的结果
				for(int j=0;j<recommend.length;j++) {
					//System.out.println("商品id为"+(j+1)+"的是:"+recommend[j]);
					if(recommend[j].equals(favarr[i])) {
						favarr0.add(Integer.toString(j));
						//System.out.println("商品id为"+(j+1)+"的是:"+recommend[j]);
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
			result.setMessage("推荐成功");
			result.setData(recommendgood);//关于此用户的所有喜好推荐的所有商品
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			result.setSuccess(false);
			result.setMessage("服务器错误！！");
			return result;
		}
	}
	//热款商品
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
			result.setMessage("热款推荐成功");
			result.setData(hotgoods);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			result.setSuccess(false);
			System.out.println(e);
			result.setMessage("服务器错误！！");
			return result;
		}
	}
	//搜索框中查询商品
	public Result selectGoods(String title) {
		Result result=new Result();
		try {
			result.setCode(1);
			result.setSuccess(true);
			result.setMessage("查询成功");
			result.setData(dao.selectGoods(title));
			return result;
		}catch(Exception e) {
			result.setSuccess(false);
			System.out.println(e);
			result.setMessage("服务器错误！！");
			return result;
		}
	}
}
