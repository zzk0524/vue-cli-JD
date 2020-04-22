package com.ls.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ls.bean.Account;

@Mapper
public interface GoodsDao {

	//�û�����֤
	@Select("select account from jd_user where account=#{account}")
	Account accountCheck(String account);
	//������֤
	@Select("select * from jd_user where account=#{account}")
	Account passwordCheck(String account);
	//��ѯȫ���˺�
	@Select("select * from jd_user")
	List<Account> selectAllAccount();
	//ע���û�
	@Insert("insert into jd_user values(null,#{user.account},#{user.sex},#{user.password},#{user.favourite})")
	void registUser(@Param("user")Account user);
//	@Insert("insert into jd_user values(null,#{user.account},#{user.sex},#{user.password},#{user.favourite})")
//	@Insert("insert into jd_user values(null,'1','2','3','4')")
//	void registUser(@Param("user")Account user);
}
