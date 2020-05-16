package com.ls.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ls.bean.Account;
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
	//查询全部账号
	@Select("select * from jd_user")
	List<Account> selectAllAccount();
	//注册用户
	@Insert("insert into jd_user values(null,#{user.account},#{user.sex},#{user.password},#{user.favourite})")
	void registUser(@Param("user")Account user);
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
	@Insert("insert into jd_cart values(null,#{cart.accountid},#{cart.goodid},#{cart.goodtitle},#{cart.goodprice},#{cart.goodpic},#{cart.shopname},#{cart.goodnum},#{cart.goodsumprice})")
	void addCart(@Param("cart")Cart cart);
	//购物车的东西只改变数量
	@Update("update jd_cart set goodnum=goodnum+#{goodnum},goodsumprice=goodsumprice+#{goodsumprice} where accountid=#{accountid} and goodid=#{goodid}")
	void updateCart(@Param("accountid")int accountid,@Param("goodid")int goodid,@Param("goodnum")String goodnum,@Param("goodsumprice")String goodsumprice);
	//查询某用户的购物车
	@Select("select * from jd_cart where accountid=#{accountid}")
	List<Cart> selectCart(@Param("accountid")String accountid);
	//查询书否存在该商品
	@Select("select * from jd_cart where accountid=#{accountid} and goodid=#{goodid}")
	List<Cart> selectCartgood(@Param("accountid")int accountid,@Param("goodid")int goodid);
	//加减购物车商品街
	@Update("update jd_cart set goodnum=#{goodnum},goodsumprice=#{goodsumprice} where accountid=#{accountid} and goodid=#{goodid}")
	void optCart(@Param("accountid")int accountid,@Param("goodid")int goodid,@Param("goodnum")String goodnum,@Param("goodsumprice")String goodsumprice);
	//删除购物车某个商品
	@Delete("delete from jd_cart where accountid=#{accountid} and goodid=#{goodid}")
	void deleteGood(@Param("accountid")int accountid,@Param("goodid")int goodid);
}
