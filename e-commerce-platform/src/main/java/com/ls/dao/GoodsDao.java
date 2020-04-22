package com.ls.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ls.bean.Account;

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
//	@Insert("insert into jd_user values(null,#{user.account},#{user.sex},#{user.password},#{user.favourite})")
//	@Insert("insert into jd_user values(null,'1','2','3','4')")
//	void registUser(@Param("user")Account user);
}
