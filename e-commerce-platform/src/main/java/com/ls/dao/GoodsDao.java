package com.ls.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ls.bean.Account;
import com.ls.bean.Goods;

@Mapper
public interface GoodsDao {

	//用户名验证
	@Select("select account from jd_user where account=#{account}")
	Account accountCheck(String account);
	//密码验证
	@Select("select * from jd_user where account=#{account}")
	Account passwordCheck(String account);
	//查询全部账号
	@Select("select * from jd_user")
	List<Account> selectAllAccount();
	//注册用户
	@Insert("insert into jd_user values(null,#{user.account},#{user.sex},#{user.password},#{user.favourite})")
	void registUser(@Param("user")Account user);
	//推荐商品用户喜好
	@Select("select * from jd_user where account=#{account}")
	Account recommendGoodsUser(String account);
	//推荐商品列表
	@Select("select * from jd_item")
	List<Goods> recommendGoods();
	//热款推荐
	@Select("select * from jd_item where comments like '%万+'")
	List<Goods> hotGoods();
	//按名称的模糊查询
	@Select("select * from jd_item where title like '%${title}%'")
	List<Goods> selectGoods(@Param("title")String title);
}
