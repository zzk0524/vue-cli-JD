package com.ls.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ls.bean.Account;
import com.ls.bean.Admin;
import com.ls.bean.Cart;
import com.ls.bean.Goods;

@Mapper
public interface GoodsDao {

	//�û�����֤
	@Select("select account from jd_user where account=#{account}")
	Account accountCheck(String account);
	//������֤
	@Select("select * from jd_user where account=#{account}")
	Account passwordCheck(String account);
	//����Ա�˺���֤
	@Select("select account from jd_admin where account=#{account}")
	Admin adminAccountCheck(String account);
	//����Ա������֤
	@Select("select * from jd_admin where account=#{account}")
	Admin adminPasswordCheck(String account);
	//��ѯȫ���˺�
	@Select("select * from jd_user")
	List<Account> selectAllAccount();
	//��ѯ����Ա�˻�
	@Select("select * from jd_admin")
	List<Admin> selectAdmin();
	//����Ա��ѯȫ���û�
	@Select("select * from jd_user")
	List<Account> adminSelectUser();
	//����Ա��ѯȫ����Ʒ
	@Select("select * from jd_item")
	List<Goods> adminSelectGood();
	//ע���û�
	@Insert("insert into jd_user values(null,#{user.account},#{user.sex},#{user.password},#{user.favourite})")
	void registUser(@Param("user")Account user);
	//����Ա�����û���Ϣ
	@Insert("insert into jd_user values(null,#{user.account},#{user.sex},#{user.password},#{user.favourite})")
	void adminAddUser(@Param("user")Account user);
	//����Ա������Ʒ��Ϣ
	@Insert("insert into jd_item values(null,#{good.sku},#{good.title},#{good.price},#{good.shopname},#{good.comments},#{good.pic},#{good.url},#{good.type})")
	void adminAddGood(@Param("good")Goods good);
	//����Ա�޸��û���Ϣ
	@Update("update jd_user set account=#{user.account},sex=#{user.sex},password=#{user.password},favourite=#{user.favourite} where id=#{user.id}")
	void adminUpdateUser(@Param("user")Account user);
	//����Ա�޸���Ʒ��Ϣ
	@Update("update jd_item set sku=#{good.sku},title=#{good.title},price=#{good.price},shopname=#{good.shopname},comments=#{good.comments},pic=#{good.pic},url=#{good.url},type=#{good.type} where id=#{good.id}")
	void adminUpdateGood(@Param("good")Goods good);
	//����Ա�޸ĸ�����Ϣ
	@Update("update jd_admin set account=#{admin.account},password=#{admin.password} where id=#{admin.id}")
	void updateAdmin(@Param("admin")Admin admin);
	//�Ƽ���Ʒ�û�ϲ��
	@Select("select * from jd_user where account=#{account}")
	Account recommendGoodsUser(String account);
	//�Ƽ���Ʒ�б���ѯ������Ʒ
	@Select("select * from jd_item")
	List<Goods> recommendGoods();
	//���û��Ĺ��ﳵ���Ƿ�����Ʒ,��ѯ���û����ﳵ��������Ʒ
	@Select("select * from jd_cart where accountid=(select id from jd_user where account=#{account})")
	List<Cart> currentUserCart(@Param("account")String account);
	//�ȿ��Ƽ�
	@Select("select * from jd_item where comments like '%��+'")
	List<Goods> hotGoods();
	//�����Ƶ�ģ����ѯ
	@Select("select * from jd_item where title like '%${title}%'")
	List<Goods> selectGoods(@Param("title")String title);
	//ֱ�Ӽ��빺�ﳵ
	@Insert("insert into jd_cart values(null,#{cart.accountid},#{cart.goodid},#{cart.goodtitle},#{cart.goodprice},#{cart.goodpic},#{cart.shopname},#{cart.goodnum},#{cart.goodsumprice},#{cart.goodtype})")
	void addCart(@Param("cart")Cart cart);
	//���ﳵ�Ķ���ֻ�ı�����
	@Update("update jd_cart set goodnum=goodnum+#{goodnum},goodsumprice=goodsumprice+#{goodsumprice} where accountid=#{accountid} and goodid=#{goodid}")
	void updateCart(@Param("accountid")int accountid,@Param("goodid")int goodid,@Param("goodnum")String goodnum,@Param("goodsumprice")String goodsumprice);
	//��ѯĳ�û��Ĺ��ﳵ
	@Select("select * from jd_cart where accountid=#{accountid}")
	List<Cart> selectCart(@Param("accountid")String accountid);
	//��ѯ�Ƿ���ڸ���Ʒ
	@Select("select * from jd_cart where accountid=#{accountid} and goodid=#{goodid}")
	List<Cart> selectCartgood(@Param("accountid")int accountid,@Param("goodid")int goodid);
	//�Ӽ����ﳵ��Ʒ��
	@Update("update jd_cart set goodnum=#{goodnum},goodsumprice=#{goodsumprice} where accountid=#{accountid} and goodid=#{goodid}")
	void optCart(@Param("accountid")int accountid,@Param("goodid")int goodid,@Param("goodnum")String goodnum,@Param("goodsumprice")String goodsumprice);
	//ɾ�����ﳵĳ����Ʒ
	@Delete("delete from jd_cart where accountid=#{accountid} and goodid=#{goodid}")
	void deleteGood(@Param("accountid")int accountid,@Param("goodid")int goodid);
	//����Աɾ���û���Ϣ
	@Delete("delete from jd_user where id=#{id}")
	void adminDeleteUser(@Param("id")String id);
	//����Աɾ����Ʒ��Ϣ
	@Delete("delete from jd_item where id=#{id}")
	void adminDeleteGood(@Param("id")String id);
	//�޸�����
	@Update("update jd_user set password=#{password} where id=#{id}")
	void updateUser(@Param("id")String id,@Param("password")String password);
}
