package com.ls.bean;

public class Cart {
	private int id;
	private int accountid;
	private int goodid;
	private String goodtitle;
	private String goodprice;
	private String goodpic;
	private String shopname;
	private String goodnum;
	private String goodsumprice;
	private String goodtype;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	public String getGoodtitle() {
		return goodtitle;
	}
	public void setGoodtitle(String goodtitle) {
		this.goodtitle = goodtitle;
	}
	public String getGoodprice() {
		return goodprice;
	}
	public void setGoodprice(String goodprice) {
		this.goodprice = goodprice;
	}
	public String getGoodpic() {
		return goodpic;
	}
	public void setGoodpic(String goodpic) {
		this.goodpic = goodpic;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getGoodnum() {
		return goodnum;
	}
	public void setGoodnum(String goodnum) {
		this.goodnum = goodnum;
	}
	public String getGoodsumprice() {
		return goodsumprice;
	}
	public void setGoodsumprice(String goodsumprice) {
		this.goodsumprice = goodsumprice;
	}
	public String getGoodtype() {
		return goodtype;
	}
	public void setGoodtype(String goodtype) {
		this.goodtype = goodtype;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", accountid=" + accountid + ", goodid=" + goodid + ", goodtitle=" + goodtitle
				+ ", goodprice=" + goodprice + ", goodpic=" + goodpic + ", shopname=" + shopname + ", goodnum="
				+ goodnum + ", goodsumprice=" + goodsumprice + ", goodtype=" + goodtype + "]";
	}
	
	
}
