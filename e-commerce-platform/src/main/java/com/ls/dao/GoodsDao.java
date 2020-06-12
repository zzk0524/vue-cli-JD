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

	//用户名验证
	@Select("select account from jd_user where account=#{account}")
	Account accountCheck(String account);
	//密码验证
	@Select("select * from jd_user where account=#{account}")
	Account passwordCheck(String account);
	//管理员账号验证
	@Select("select account from jd_admin where account=#{account}")
	Admin adminAccountCheck(String account);
	//管理员密码验证
	@Select("select * from jd_admin where account=#{account}")
	Admin adminPasswordCheck(String account);
	//查询全部账号
	@Select("select * from jd_user")
	List<Account> selectAllAccount();
	//查询管理员账户
	@Select("select * from jd_admin")
	List<Admin> selectAdmin();
	//管理员查询全部用户
	@Select("select * from jd_user")
	List<Account> adminSelectUser();
	//管理员查询全部商品
	@Select("select * from jd_item")
	List<Goods> adminSelectGood();
	//注册用户
	@Insert("insert into jd_user values(null,#{user.account},#{user.sex},#{user.password},#{user.favourite})")
	void registUser(@Param("user")Account user);
	//管理员增加用户信息
	@Insert("insert into jd_user values(null,#{user.account},#{user.sex},#{user.password},#{user.favourite})")
	void adminAddUser(@Param("user")Account user);
	//管理员增加商品信息
	@Insert("insert into jd_item values(null,#{good.sku},#{good.title},#{good.price},#{good.shopname},#{good.comments},#{good.pic},#{good.url},#{good.type})")
	void adminAddGood(@Param("good")Goods good);
	//管理员修改用户信息
	@Update("update jd_user set account=#{user.account},sex=#{user.sex},password=#{user.password},favourite=#{user.favourite} where id=#{user.id}")
	void adminUpdateUser(@Param("user")Account user);
	//管理员修改商品信息
	@Update("update jd_item set sku=#{good.sku},title=#{good.title},price=#{good.price},shopname=#{good.shopname},comments=#{good.comments},pic=#{good.pic},url=#{good.url},type=#{good.type} where id=#{good.id}")
	void adminUpdateGood(@Param("good")Goods good);
	//管理员修改个人信息
	@Update("update jd_admin set account=#{admin.account},password=#{admin.password} where id=#{admin.id}")
	void updateAdmin(@Param("admin")Admin admin);
	//推荐商品用户喜好
	@Select("select * from jd_user where account=#{account}")
	Account recommendGoodsUser(String account);
	//推荐商品列表，查询所有商品
	@Select("select * from jd_item")
	List<Goods> recommendGoods();
	//该用户的购物车中是否有商品,查询该用户购物车中所有商品
	@Select("select * from jd_cart where accountid=(select id from jd_user where account=#{account})")
	List<Cart> currentUserCart(@Param("account")String account);
	//热款推荐
	@Select("select * from jd_item where comments like '%万+'")
	List<Goods> hotGoods();
	//按名称的模糊查询
	@Select("select * from jd_item where title like '%${title}%'")
	List<Goods> selectGoods(@Param("title")String title);
	//直接加入购物车
	@Insert("insert into jd_cart values(null,#{cart.accountid},#{cart.goodid},#{cart.goodtitle},#{cart.goodprice},#{cart.goodpic},#{cart.shopname},#{cart.goodnum},#{cart.goodsumprice},#{cart.goodtype})")
	void addCart(@Param("cart")Cart cart);
	//购物车的东西只改变数量
	@Update("update jd_cart set goodnum=goodnum+#{goodnum},goodsumprice=goodsumprice+#{goodsumprice} where accountid=#{accountid} and goodid=#{goodid}")
	void updateCart(@Param("accountid")int accountid,@Param("goodid")int goodid,@Param("goodnum")String goodnum,@Param("goodsumprice")String goodsumprice);
	//查询某用户的购物车
	@Select("select * from jd_cart where accountid=#{accountid}")
	List<Cart> selectCart(@Param("accountid")String accountid);
	//查询是否存在该商品
	@Select("select * from jd_cart where accountid=#{accountid} and goodid=#{goodid}")
	List<Cart> selectCartgood(@Param("accountid")int accountid,@Param("goodid")int goodid);
	//加减购物车商品街
	@Update("update jd_cart set goodnum=#{goodnum},goodsumprice=#{goodsumprice} where accountid=#{accountid} and goodid=#{goodid}")
	void optCart(@Param("accountid")int accountid,@Param("goodid")int goodid,@Param("goodnum")String goodnum,@Param("goodsumprice")String goodsumprice);
	//删除购物车某个商品
	@Delete("delete from jd_cart where accountid=#{accountid} and goodid=#{goodid}")
	void deleteGood(@Param("accountid")int accountid,@Param("goodid")int goodid);
	//管理员删除用户信息
	@Delete("delete from jd_user where id=#{id}")
	void adminDeleteUser(@Param("id")String id);
	//管理员删除商品信息
	@Delete("delete from jd_item where id=#{id}")
	void adminDeleteGood(@Param("id")String id);
	//修改密码
	@Update("update jd_user set password=#{password} where id=#{id}")
	void updateUser(@Param("id")String id,@Param("password")String password);
}
