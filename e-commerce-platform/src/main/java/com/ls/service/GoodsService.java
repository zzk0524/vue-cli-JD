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
				System.out.println("商品id为"+(i+1)+"的是:"+recommed[i]);
			}
//			String[] favarr = user.getFavourite().toString().split(",");
//			ArrayList<String> labels=new ArrayList<String>();
//			ArrayList<ArrayList<String>> dates=new ArrayList<ArrayList<String>>();//训练数据集
//			//把用户爱好字符串存到数组中去
//			System.out.println(favarr[0]);
//			System.out.println(favarr[0] instanceof String);
//			System.out.println(favarr[0]=="潮流服饰");
//			if(favarr[0].equals("潮流服饰")) {//目前只针对潮流服饰实现过滤
//				System.out.println("对的");
//				String[] labelstr = new String[] {"类型","款式","潮流服饰"};
//				for(int i=0;i<labelstr.length;i++){
//					labels.add(labelstr[i]);//存的特征标签
//				}
//				//存训练数据
//				String[][] datestr = new String[][] {{"运动","新款","潮流服饰"},{"休闲","新款","潮流服饰"},{"其他","新款","普通服饰"},{"运动","普通","普通服饰"},{"休闲","普通","普通服饰"},{"其他","普通","普通服饰"}};
//				ArrayList<String> line=null;
//				for(int i=0;i<datestr.length;i++) {
//					line = new ArrayList<String>();
//					for(int j=0;j<datestr[i].length;j++) {
//						line.add(datestr[i][j]);
//					}
//					dates.add(line);//存的训练数据
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
			result.setMessage("服务器错误！！");
			return result;
		}
	}
}
