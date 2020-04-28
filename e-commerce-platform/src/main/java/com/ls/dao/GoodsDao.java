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
	//�Ƽ���Ʒ�û�ϲ��
	@Select("select * from jd_user where account=#{account}")
	Account recommedGoodsUser(String account);
	//�Ƽ���Ʒ�б�
	@Select("select * from jd_item")
	List<Goods> recommedGoods();
}
