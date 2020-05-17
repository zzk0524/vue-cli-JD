package com.ls.util;

import java.util.ArrayList;

class treeNode1{//树节点
	public String sname;//节点名
	public treeNode1(String str) {//设置节点名的
		sname=str;
	}
	public String getsname() {//获取节点名的
		return sname;
	}
	ArrayList<String> label=new ArrayList<String>();//和子节点间的边标签，集合中元素类型为string
	ArrayList<treeNode1> node=new ArrayList<treeNode1>();//对应子节点，集合中元素类型为treeNode
}

public class CartID3 {
	public ArrayList<String> label=new ArrayList<String>();//特征属性标签，存数据的第一行特征介绍
	public ArrayList<ArrayList<String>> date=new ArrayList<ArrayList<String>>();//训练数据集
	public ArrayList<ArrayList<String>> test=new ArrayList<ArrayList<String>>();//测试数据集
	public ArrayList<String> sum=new ArrayList<String>();//结果种类
	public String[] kind;//存最终结果
	public int x=0;
	public String[] getKind() {
		return kind;
	}
	public CartID3(String favourite,ArrayList<String> datelist){
		//初始化训练数据并得到分类种数
		getDate(favourite);//将训练数据集存到了成员变量date中
		//获取测试数据集
		gettestDate(favourite,datelist);//将测试数据集存到了成员变量test中
		init(date);//传入训练数据集，将结果种类存到sum中
		print(date);//构建并输出决策树，传入的是存好的训练数据
		testdate(test);//预测数据并输出结果
		//System.out.println("进来了");
	}
	public void init(ArrayList<ArrayList<String>> date) {
		//得到种类数
		sum.add(date.get(0).get(date.get(0).size()-1));
        for(int i=0;i<date.size();i++) {
        	if(sum.contains(date.get(i).get(date.get(0).size()-1))==false) {//contains判断元素是否在列表,将最终可能的结果存起来，而且不能重复，最终存出结果为潮流服饰
        		sum.add(date.get(i).get(date.get(0).size()-1));      	    
        	}
		}
	}
	//获取测试数据集
	public void gettestDate(String favourite,ArrayList<String> datelist){
		int length = datelist.size();//记录有多少条数据
		this.kind = new String[length];
		//String[][] teststr = new String[length][2];
		String[] teststr1 = new String[length];//小米，荣耀，iPhone，华为，Redmi,vivo,OPPO ,魅族，锤子，黑鲨，中兴，诺基亚，三星，杂牌
		if(favourite.indexOf("老人手机")!=-1||favourite.indexOf("GB")!=-1) {//如果是手机
			if(favourite.indexOf("小米")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("小米")!=-1) {
						teststr1[i]="小米";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}			
			}else if(favourite.indexOf("荣耀")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("荣耀")!=-1) {
						teststr1[i]="荣耀";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("iPhone")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("iPhone")!=-1) {
						teststr1[i]="iPhone";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("华为")!=-1) {//华为，Redmi,vivo,OPPO ,魅族，锤子，黑鲨，中兴，诺基亚，三星，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("华为")!=-1) {
						teststr1[i]="华为";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("Redmi")!=-1) {//Redmi,vivo,OPPO ,魅族，锤子，黑鲨，中兴，诺基亚，三星，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("Redmi")!=-1) {
						teststr1[i]="Redmi";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("vivo")!=-1) {//vivo,OPPO ,魅族，锤子，黑鲨，中兴，诺基亚，三星，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("vivo")!=-1) {
						teststr1[i]="vivo";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("OPPO")!=-1) {//OPPO ,魅族，锤子，黑鲨，中兴，诺基亚，三星，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("OPPO")!=-1) {
						teststr1[i]="OPPO";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("魅族")!=-1) {//魅族，锤子，黑鲨，中兴，诺基亚，三星，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("魅族")!=-1) {
						teststr1[i]="魅族";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("锤子")!=-1) {//锤子，黑鲨，中兴，诺基亚，三星，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("锤子")!=-1) {
						teststr1[i]="锤子";
					}else {
						teststr1[i]="其他";
					}	
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("黑鲨")!=-1) {//黑鲨，中兴，诺基亚，三星，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("黑鲨")!=-1) {
						teststr1[i]="黑鲨";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("中兴")!=-1) {//中兴，诺基亚，三星，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("中兴")!=-1) {
						teststr1[i]="中兴";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("诺基亚")!=-1) {//诺基亚，三星，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("诺基亚")!=-1) {
						teststr1[i]="诺基亚";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("三星")!=-1) {//三星，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("三星")!=-1) {
						teststr1[i]="三星";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {//小米，荣耀，iPhone，华为，Redmi,vivo,OPPO ,魅族，锤子，黑鲨，中兴，诺基亚，三星，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("老人手机")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("小米")==-1&&datelist.get(i).indexOf("荣耀")==-1&&datelist.get(i).indexOf("iPhone")==-1&&datelist.get(i).indexOf("Redmi")==-1&&datelist.get(i).indexOf("vivo")==-1&&datelist.get(i).indexOf("OPPO")==-1&&datelist.get(i).indexOf("魅族")==-1&&datelist.get(i).indexOf("锤子")==-1&&datelist.get(i).indexOf("黑鲨")==-1&&datelist.get(i).indexOf("中兴")==-1&&datelist.get(i).indexOf("诺基亚")==-1&&datelist.get(i).indexOf("三星")==-1) {
						teststr1[i]="杂牌";
					}else {
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else if(favourite.indexOf("裤")!=-1) {//运动,休闲，牛仔，小脚，打底	
			if(favourite.indexOf("打底")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("裤")!=-1&&datelist.get(i).indexOf("打底")!=-1) {
						teststr1[i]="打底裤";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("小脚")!=-1){
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("裤")!=-1&&datelist.get(i).indexOf("小脚")!=-1) {
						teststr1[i]="小脚裤";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("牛仔")!=-1){
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("裤")!=-1&&datelist.get(i).indexOf("牛仔")!=-1) {
						teststr1[i]="牛仔裤";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("运动")!=-1){
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("裤")!=-1&&datelist.get(i).indexOf("运动")!=-1) {
						teststr1[i]="运动裤";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("休闲")!=-1){
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("裤")!=-1&&datelist.get(i).indexOf("休闲")!=-1) {
						teststr1[i]="休闲裤";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {//运动,休闲，牛仔，小脚，打底	，杂牌
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("裤")!=-1&&datelist.get(i).indexOf("休闲")==-1&&datelist.get(i).indexOf("运动")==-1&&datelist.get(i).indexOf("小脚")==-1&&datelist.get(i).indexOf("打底")==-1&&datelist.get(i).indexOf("牛仔")==-1) {
						teststr1[i]="杂牌";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else if(favourite.indexOf("外套")!=-1||favourite.indexOf("上衣")!=-1) {//短袖，工装，夹克，风衣,休闲
			if(favourite.indexOf("短袖")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("外套")!=-1||datelist.get(i).indexOf("上衣")!=-1)&&datelist.get(i).indexOf("短袖")!=-1) {
						teststr1[i]="短袖";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("工装")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("外套")!=-1||datelist.get(i).indexOf("上衣")!=-1)&&datelist.get(i).indexOf("工装")!=-1) {
						teststr1[i]="工装";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("夹克")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("外套")!=-1||datelist.get(i).indexOf("上衣")!=-1)&&datelist.get(i).indexOf("夹克")!=-1) {
						teststr1[i]="夹克";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("风衣")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("外套")!=-1||datelist.get(i).indexOf("上衣")!=-1)&&datelist.get(i).indexOf("风衣")!=-1) {
						teststr1[i]="风衣";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("休闲")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("外套")!=-1||datelist.get(i).indexOf("上衣")!=-1)&&datelist.get(i).indexOf("休闲")!=-1) {
						teststr1[i]="休闲";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("外套")!=-1||datelist.get(i).indexOf("上衣")!=-1)&&datelist.get(i).indexOf("休闲")==-1&&datelist.get(i).indexOf("夹克")==-1&&datelist.get(i).indexOf("风衣")==-1&&datelist.get(i).indexOf("工装")==-1&&datelist.get(i).indexOf("短袖")==-1) {
						teststr1[i]="杂牌";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else if(favourite.indexOf("鞋")!=-1) {
			if(favourite.indexOf("运动")!=-1&&favourite.indexOf("休闲")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("鞋")!=-1&&datelist.get(i).indexOf("运动")!=-1&&datelist.get(i).indexOf("休闲")!=-1) {
						teststr1[i]="运动休闲";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("鞋")!=-1&&datelist.get(i).indexOf("运动")==-1&&datelist.get(i).indexOf("休闲")==-1) {
						teststr1[i]="杂牌";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else if(favourite.indexOf("零食")!=-1) {//零食
			if(favourite.indexOf("肉")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("零食")!=-1&&datelist.get(i).indexOf("肉")!=-1) {
						teststr1[i]="肉类";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("零食")!=-1&&datelist.get(i).indexOf("肉")==-1) {
						teststr1[i]="非肉类";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else if(favourite.indexOf("家具")!=-1||favourite.indexOf("桌")!=-1||favourite.indexOf("床")!=-1) {
			if(favourite.indexOf("桌")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("家具")!=-1||datelist.get(i).indexOf("桌")!=-1||datelist.get(i).indexOf("床")!=-1)&&datelist.get(i).indexOf("桌")!=-1) {
						teststr1[i]="桌子";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("床")!=-1){
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("家具")!=-1||datelist.get(i).indexOf("桌")!=-1||datelist.get(i).indexOf("床")!=-1)&&datelist.get(i).indexOf("床")!=-1) {
						teststr1[i]="床";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("沙发")!=-1){
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("家具")!=-1||datelist.get(i).indexOf("桌")!=-1||datelist.get(i).indexOf("床")!=-1)&&datelist.get(i).indexOf("沙发")!=-1) {
						teststr1[i]="沙发";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("家具")!=-1||datelist.get(i).indexOf("桌")!=-1||datelist.get(i).indexOf("床")!=-1)&&datelist.get(i).indexOf("沙发")==-1&&datelist.get(i).indexOf("床")==-1&&datelist.get(i).indexOf("桌")==-1) {
						teststr1[i]="杂牌";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else if(favourite.indexOf("清洁")!=-1||favourite.indexOf("洗面奶")!=-1||favourite.indexOf("沐浴露")!=-1||favourite.indexOf("洗发")!=-1) {
			if(favourite.indexOf("洗面奶")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("清洁")!=-1||datelist.get(i).indexOf("洗面奶")!=-1||datelist.get(i).indexOf("沐浴露")!=-1||datelist.get(i).indexOf("洗发")!=-1)&&datelist.get(i).indexOf("洗面奶")!=-1) {
						teststr1[i]="洗面奶";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("洗发")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("清洁")!=-1||datelist.get(i).indexOf("洗面奶")!=-1||datelist.get(i).indexOf("沐浴露")!=-1||datelist.get(i).indexOf("洗发")!=-1)&&datelist.get(i).indexOf("洗发")!=-1) {
						teststr1[i]="洗发水";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("沐浴露")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("清洁")!=-1||datelist.get(i).indexOf("洗面奶")!=-1||datelist.get(i).indexOf("沐浴露")!=-1||datelist.get(i).indexOf("洗发")!=-1)&&datelist.get(i).indexOf("沐浴露")!=-1) {
						teststr1[i]="沐浴露";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("清洁")!=-1||datelist.get(i).indexOf("洗面奶")!=-1||datelist.get(i).indexOf("沐浴露")!=-1||datelist.get(i).indexOf("洗发")!=-1)&&datelist.get(i).indexOf("沐浴露")==-1&&datelist.get(i).indexOf("洗面奶")==-1&&datelist.get(i).indexOf("洗发")==-1) {
						teststr1[i]="杂牌";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else if(favourite.indexOf("拉杆箱")!=-1||favourite.indexOf("旅行箱")!=-1){
			if(favourite.indexOf("密码")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("拉杆箱")!=-1||datelist.get(i).indexOf("旅行箱")!=-1)&&datelist.get(i).indexOf("密码")!=-1) {
						teststr1[i]="密码箱";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("拉杆箱")!=-1||datelist.get(i).indexOf("旅行箱")!=-1)&&datelist.get(i).indexOf("密码")==-1) {
						teststr1[i]="非密码箱";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else if(favourite.indexOf("项链")!=-1||favourite.indexOf("戒指")!=-1||favourite.indexOf("吊坠")!=-1){
			if(favourite.indexOf("项链")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("项链")!=-1||datelist.get(i).indexOf("戒指")!=-1||datelist.get(i).indexOf("吊坠")!=-1)&&datelist.get(i).indexOf("项链")!=-1) {
						teststr1[i]="项链";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("戒指")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("项链")!=-1||datelist.get(i).indexOf("戒指")!=-1||datelist.get(i).indexOf("吊坠")!=-1)&&datelist.get(i).indexOf("戒指")!=-1) {
						teststr1[i]="戒指";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else if(favourite.indexOf("吊坠")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("项链")!=-1||datelist.get(i).indexOf("戒指")!=-1||datelist.get(i).indexOf("吊坠")!=-1)&&datelist.get(i).indexOf("吊坠")!=-1) {
						teststr1[i]="吊坠";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if((datelist.get(i).indexOf("项链")!=-1||datelist.get(i).indexOf("戒指")!=-1||datelist.get(i).indexOf("吊坠")!=-1)&&datelist.get(i).indexOf("吊坠")==-1&&datelist.get(i).indexOf("项链")==-1&&datelist.get(i).indexOf("戒指")==-1) {
						teststr1[i]="杂牌";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else if(favourite.indexOf("玩具")!=-1){
			if(favourite.indexOf("益智")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("玩具")!=-1&&datelist.get(i).indexOf("益智")!=-1) {
						teststr1[i]="益智";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("玩具")!=-1&&datelist.get(i).indexOf("益智")==-1) {
						teststr1[i]="非益智";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else if(favourite.indexOf("宠物")!=-1){
			if(favourite.indexOf("猫")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("宠物")!=-1&&datelist.get(i).indexOf("猫")!=-1) {
						teststr1[i]="猫类";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("宠物")!=-1&&datelist.get(i).indexOf("猫")==-1) {
						teststr1[i]="非猫类";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else if(favourite.indexOf("汽车")!=-1){
			if(favourite.indexOf("汽车用品")!=-1||favourite.indexOf("车载")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("汽车")!=-1&&(datelist.get(i).indexOf("汽车用品")!=-1||favourite.indexOf("车载")!=-1)) {
						teststr1[i]="车载";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(datelist.get(i).indexOf("汽车")!=-1&&datelist.get(i).indexOf("汽车用品")==-1&&datelist.get(i).indexOf("车载")==-1) {
						teststr1[i]="非车载";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}else {//图书
			if(favourite.indexOf("册")!=-1) {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(((datelist.get(i).indexOf("老人手机")==-1||datelist.get(i).indexOf("GB")==-1)&&datelist.get(i).indexOf("裤")==-1&&(datelist.get(i).indexOf("外套")==-1||datelist.get(i).indexOf("上衣")==-1)&&datelist.get(i).indexOf("鞋")==-1&&datelist.get(i).indexOf("零食")==-1&&(datelist.get(i).indexOf("家具")==-1||datelist.get(i).indexOf("桌")==-1||datelist.get(i).indexOf("床")==-1)&&(datelist.get(i).indexOf("清洁")==-1||datelist.get(i).indexOf("洗面奶")==-1||datelist.get(i).indexOf("沐浴露")==-1||datelist.get(i).indexOf("洗发")==-1)&&(datelist.get(i).indexOf("拉杆箱")==-1||datelist.get(i).indexOf("旅行箱")==-1)&&(datelist.get(i).indexOf("项链")==-1||datelist.get(i).indexOf("戒指")==-1||datelist.get(i).indexOf("吊坠")==-1)&&datelist.get(i).indexOf("玩具")==-1&&datelist.get(i).indexOf("宠物")==-1&&datelist.get(i).indexOf("汽车")==-1)&&datelist.get(i).indexOf("册")!=-1) {
						teststr1[i]="成册";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}else {
				for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
					if(((datelist.get(i).indexOf("老人手机")==-1||datelist.get(i).indexOf("GB")==-1)&&datelist.get(i).indexOf("裤")==-1&&(datelist.get(i).indexOf("外套")==-1||datelist.get(i).indexOf("上衣")==-1)&&datelist.get(i).indexOf("鞋")==-1&&datelist.get(i).indexOf("零食")==-1&&(datelist.get(i).indexOf("家具")==-1||datelist.get(i).indexOf("桌")==-1||datelist.get(i).indexOf("床")==-1)&&(datelist.get(i).indexOf("清洁")==-1||datelist.get(i).indexOf("洗面奶")==-1||datelist.get(i).indexOf("沐浴露")==-1||datelist.get(i).indexOf("洗发")==-1)&&(datelist.get(i).indexOf("拉杆箱")==-1||datelist.get(i).indexOf("旅行箱")==-1)&&(datelist.get(i).indexOf("项链")==-1||datelist.get(i).indexOf("戒指")==-1||datelist.get(i).indexOf("吊坠")==-1)&&datelist.get(i).indexOf("玩具")==-1&&datelist.get(i).indexOf("宠物")==-1&&datelist.get(i).indexOf("汽车")==-1)&&datelist.get(i).indexOf("册")==-1) {
						teststr1[i]="不成册";	
					}else{
						teststr1[i]="其他";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//将二维数组转到一个ArrayList中
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//存的测试数据
				}
			}
		}
	}
	//获取训练数据集
	public void getDate(String favourite){
		//String[] favarr = favourite.split(",");//把用户爱好字符串存到数组中去
		System.out.println(favourite);
		if(favourite.indexOf("老人手机")!=-1||favourite.indexOf("GB")!=-1) {//确认一下是手机
			String[] labelstr = new String[] {"品牌","目标手机"};
			for(int i=0;i<labelstr.length;i++){//小米，荣耀，iPhone，华为，Redmi,vivo,OPPO ,魅族，锤子，黑鲨，中兴，诺基亚，三星，杂牌
				label.add(labelstr[i]);//存的特征标签
			}
			//存训练数据
			if(favourite.indexOf("小米")!=-1) {
				String[][] datestr = new String[][] {{"小米","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("荣耀")!=-1) {
				String[][] datestr = new String[][] {{"荣耀","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("iPhone")!=-1) {
				String[][] datestr = new String[][] {{"iPhone","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("华为")!=-1) {
				String[][] datestr = new String[][] {{"华为","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("Redmi")!=-1) {
				String[][] datestr = new String[][] {{"Redmi","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("vivo")!=-1) {
				String[][] datestr = new String[][] {{"vivo","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("OPPO")!=-1) {
				String[][] datestr = new String[][] {{"OPPO","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("魅族")!=-1) {
				String[][] datestr = new String[][] {{"魅族","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("锤子")!=-1) {
				String[][] datestr = new String[][] {{"锤子","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("黑鲨")!=-1) {
				String[][] datestr = new String[][] {{"黑鲨","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("中兴")!=-1) {
				String[][] datestr = new String[][] {{"中兴","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("诺基亚")!=-1) {
				String[][] datestr = new String[][] {{"诺基亚","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("三星")!=-1) {
				String[][] datestr = new String[][] {{"三星","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"杂牌","目标手机"},{"其他","普通手机"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}			
		}else if(favourite.indexOf("裤")!=-1) {//裤子
			System.out.println("是裤子");
			String[] labelstr = new String[] {"类型","目标裤子"};//运动,休闲，牛仔，小脚，打底	
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			//存训练数据
			if(favourite.indexOf("打底")!=-1) {
				String[][] datestr = new String[][] {{"打底裤","目标裤子"},{"其他","其他裤子"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("小脚")!=-1) {
				System.out.println("是小脚裤");
				String[][] datestr = new String[][] {{"小脚裤","目标裤子"},{"其他","其他裤子"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("牛仔")!=-1) {
				String[][] datestr = new String[][] {{"牛仔裤","目标裤子"},{"其他","其他裤子"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("运动")!=-1) {
				String[][] datestr = new String[][] {{"运动裤","目标裤子"},{"其他","其他裤子"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("休闲")!=-1) {
				String[][] datestr = new String[][] {{"休闲裤","目标裤子"},{"其他","其他裤子"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"杂牌","目标裤子"},{"其他","其他裤子"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
		}else if(favourite.indexOf("上衣")!=-1||favourite.indexOf("外套")!=-1) {//这是一个上衣
			String[] labelstr = new String[] {"款式","目标上衣"};//短袖，工装，夹克，风衣,休闲
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			if(favourite.indexOf("短袖")!=-1) {
				String[][] datestr = new String[][] {{"短袖","目标上衣"},{"其他","其他上衣"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("工装")!=-1) {
				String[][] datestr = new String[][] {{"工装","目标上衣"},{"其他","其他上衣"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("夹克")!=-1) {
				String[][] datestr = new String[][] {{"夹克","目标上衣"},{"其他","其他上衣"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("风衣")!=-1) {
				String[][] datestr = new String[][] {{"风衣","目标上衣"},{"其他","其他上衣"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("休闲")!=-1) {
				String[][] datestr = new String[][] {{"休闲","目标上衣"},{"其他","其他上衣"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"杂牌","目标上衣"},{"其他","其他上衣"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
			//存训练数据
		}else if(favourite.indexOf("鞋")!=-1) {//这是一个鞋子
			String[] labelstr = new String[] {"类型","目标鞋"};//运动休闲
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			if(favourite.indexOf("运动")!=-1&&favourite.indexOf("休闲")!=-1) {
				String[][] datestr = new String[][] {{"运动休闲","目标鞋"},{"其他","其他鞋"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"杂牌","目标鞋"},{"其他","其他鞋"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
		}else if(favourite.indexOf("零食")!=-1) {//食品
			String[] labelstr = new String[] {"类型","目标食品"};//
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			if(favourite.indexOf("肉")!=-1) {
				//存训练数据
				String[][] datestr = new String[][] {{"肉类","目标食品"},{"其他","其他食品"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"非肉类","目标食品"},{"其他","其他食品"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
		}else if(favourite.indexOf("家具")!=-1||favourite.indexOf("桌")!=-1||favourite.indexOf("床")!=-1) {//这是一个家具
			String[] labelstr = new String[] {"类型","目标家具"};//床，沙发，桌
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			if(favourite.indexOf("桌")!=-1) {
				//存训练数据
				String[][] datestr = new String[][] {{"桌子","目标家具"},{"其他","其他家具"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("床")!=-1) {
				String[][] datestr = new String[][] {{"床","目标家具"},{"其他","其他家具"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("沙发")!=-1) {
				String[][] datestr = new String[][] {{"沙发","目标家具"},{"其他","其他家具"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"杂牌","目标家具"},{"其他","其他家具"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
		}else if(favourite.indexOf("清洁")!=-1||favourite.indexOf("洗面奶")!=-1||favourite.indexOf("洗发")!=-1||favourite.indexOf("沐浴露")!=-1) {//这是一个个护清洁
			String[] labelstr = new String[] {"类型","目标个护清洁"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			if(favourite.indexOf("洗面奶")!=-1) {
				//存训练数据
				String[][] datestr = new String[][] {{"洗面奶","目标个护清洁"},{"其他","其他个护清洁"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("洗发")!=-1) {
				String[][] datestr = new String[][] {{"洗发水","目标个护清洁"},{"其他","其他个护清洁"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("沐浴露")!=-1) {
				String[][] datestr = new String[][] {{"沐浴露","目标个护清洁"},{"其他","其他个护清洁"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"杂牌","目标个护清洁"},{"其他","其他个护清洁"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
		}else if(favourite.indexOf("拉杆箱")!=-1||favourite.indexOf("旅行箱")!=-1){//这是一个箱包
			String[] labelstr = new String[] {"类型","目标箱包"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			if(favourite.indexOf("密码")!=-1) {
				String[][] datestr = new String[][] {{"密码箱","目标箱包"},{"其他","其他箱包"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"非密码箱","目标箱包"},{"其他","其他箱包"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
		}else if(favourite.indexOf("项链")!=-1||favourite.indexOf("戒指")!=-1||favourite.indexOf("吊坠")!=-1){
			String[] labelstr = new String[] {"类型","目标珠宝"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			if(favourite.indexOf("项链")!=-1) {
				String[][] datestr = new String[][] {{"项链","目标珠宝"},{"其他","其他珠宝"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("戒指")!=-1) {
				String[][] datestr = new String[][] {{"戒指","目标珠宝"},{"其他","其他珠宝"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else if(favourite.indexOf("吊坠")!=-1) {
				String[][] datestr = new String[][] {{"吊坠","目标珠宝"},{"其他","其他珠宝"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"杂牌","目标珠宝"},{"其他","其他珠宝"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
		}else if(favourite.indexOf("玩具")!=-1){//这是一个玩具
			String[] labelstr = new String[] {"类型","目标玩具"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			if(favourite.indexOf("益智")!=-1) {
				String[][] datestr = new String[][] {{"益智","目标玩具"},{"其他","其他玩具"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"非益智","目标玩具"},{"其他","其他玩具"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
		}else if(favourite.indexOf("宠物")!=-1){
			String[] labelstr = new String[] {"类型","目标宠物"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			if(favourite.indexOf("猫")!=-1) {
				String[][] datestr = new String[][] {{"猫类","目标宠物"},{"其他","其他宠物"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"非猫类","目标宠物"},{"其他","其他宠物"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
		}else if(favourite.indexOf("汽车")!=-1){//这可能是一个汽车\
			String[] labelstr = new String[] {"类型","目标汽车用品"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			if(favourite.indexOf("汽车")!=-1||favourite.indexOf("车载")!=-1) {
				String[][] datestr = new String[][] {{"车载","目标汽车用品"},{"其他","其他汽车用品"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"非车载","目标汽车用品"},{"其他","其他汽车用品"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
		}else {//图书
			String[] labelstr = new String[] {"类型","目标书"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			if(favourite.indexOf("册")!=-1) {
				//存训练数据
				String[][] datestr = new String[][] {{"成册","目标书"},{"其他","其他书"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}else {
				String[][] datestr = new String[][] {{"不成册","目标书"},{"其他","其他书"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//存的训练数据
				}
			}
		}
	}
	public double Ent(ArrayList<ArrayList<String>> dat) {
		//计算总的信息熵
		int all=0;
		double amount=0.0;
		for(int i=0;i<sum.size();i++) {
			for(int j=0;j<dat.size();j++) {
				if(sum.get(i).equals(dat.get(j).get(dat.get(0).size()-1))) {
					all++;//结果匹配一致
				}
			}
			if((double)all/dat.size()==0.0) {
				continue;
			}
			amount+=((double)all/dat.size())*(Math.log(((double)all/dat.size()))/Math.log(2.0));
			all=0;
		}
		if(amount==0.0) {
			return 0.0;
		}
		return -amount;//计算信息熵
	}
	//计算条件熵并返回信息增益值
	public double condtion(int a,ArrayList<ArrayList<String>> dat) {//a:0~2,dat['衣服裤子鞋子','新款潮流韩版','潮流服饰']
		ArrayList<String> all=new ArrayList<String>();
		double c=0.0;
		all.add(dat.get(0).get(a));//执行两遍，每一遍加一个，把每个属性加进去
		//得到属性种类
		for(int i=0;i<dat.size();i++) {//0,1,2,3
			if(all.contains(dat.get(i).get(a))==false) {//判断all数组里有没有重复添加的
				all.add(dat.get(i).get(a));//存完之后['是服饰','是潮流','不是服饰','不是潮流']，存的是所有的属性的可能性
			}
		}
		ArrayList<ArrayList<String>> plus=new ArrayList<ArrayList<String>>();//创建了一个二维
		//部分分组
		ArrayList<ArrayList<ArrayList<String>>> count=new ArrayList<ArrayList<ArrayList<String>>>();//三维，存的是划分好的训练数据
		//分组总和
		for(int i=0;i<all.size();i++) {//0123
			for(int j=0;j<dat.size();j++) {//0123
				if(all.get(i).equals(dat.get(j).get(a))==true) {//拿all的每一个与dat的第一列比较，第二轮再第二列比较
					plus.add(dat.get(j));//其实相当于在给dat分类，比如把第一列是服饰的分到一起
				}
			}
			count.add(plus);//把分好的一波又一波存起来，相当于[[[],[]],[[],[]]]
			c+=((double)count.get(i).size()/dat.size())*Ent(count.get(i));//c会累积加4次
			plus.removeAll(plus);//移除所有元素，运完一波就清空一下
		}
		return (Ent(dat)-c);//信息增益
		//返回条件熵
	}
	//计算信息增益最大属性
	public int Gain(ArrayList<ArrayList<String>> dat) {//传入的训练数据['衣服裤子鞋子','新款潮流韩版','潮流服饰']
		ArrayList<Double> num=new ArrayList<Double>();//创建了一个double类型的数组，用来存信息增益，几种属性就存有几个
		//保存各信息增益值
		for(int i=0;i<dat.get(0).size()-1;i++) {//0~1
			num.add(condtion(i,dat));//把每种属性的增益都存起来了，这里就两种
		}
		int index=0;//用来存最大值的下标
		double max=num.get(0);//设第一个数为最大值，进行排序
		for(int i=1;i<num.size();i++) {
			if(max<num.get(i)) {
				max=num.get(i);
				index=i;
			}
		}
		return index;//返回最大值的下标
	}
	//构建决策树
	public treeNode1 creattree(ArrayList<ArrayList<String>> dat) {//传入的训练数据二维['衣服裤子鞋子','新款潮流韩版','潮流服饰']
		int index=Gain(dat);//取到了最大增益属性的下标
		treeNode1 node=new treeNode1(label.get(index));//['服饰','潮流','潮流服饰']
		ArrayList<String> s=new ArrayList<String>();//那个最优属性的各种分类，比如衣裤鞋和非衣裤鞋
		s.add(dat.get(0).get(index));//存入第一行的最大下标的那个属性
		//System.out.println(dat.get(0).get(index));
		for(int i=1;i<dat.size();i++) {//123
			if(s.contains(dat.get(i).get(index))==false) {//查找剩余的每条数据的最大下标的属性是否已经存起来了
				s.add(dat.get(i).get(index));
			}
		}
		ArrayList<ArrayList<String>> plus=new ArrayList<ArrayList<String>>();
		//部分分组
		ArrayList<ArrayList<ArrayList<String>>> count=new ArrayList<ArrayList<ArrayList<String>>>();
		//分组总和
		//得到节点下的边标签并分组
		for(int i=0;i<s.size();i++) {//01，将每一条数据根据s进行归类
			node.label.add(s.get(i));//添加边标签
			//System.out.print("添加边标签:"+s.get(i)+"  ");
			for(int j=0;j<dat.size();j++) {//0123
				if(s.get(i).equals(dat.get(j).get(index))==true) {
					plus.add(dat.get(j));
				}
			}
			count.add(plus);//相当于把每条属性的每种可能分开来存[[[],[]],[[],[]]]
			//以下添加结点
			int k;
			String str=count.get(i).get(0).get(count.get(i).get(0).size()-1);//存的每一组的第一条数据的判断结果【[],[],[['','',''],[]]】
			for(k=1;k<count.get(i).size();k++) {//1，对比的是这一组的剩下的数据结果
				if(str.equals(count.get(i).get(k).get(count.get(i).get(k).size()-1))==false) {//和第一条不一样
					break;//判断子集纯不纯
				}
			}
			if(k==count.get(i).size()) {//2，如果k为总数就划分为一个节点
				treeNode1 dd=new treeNode1(str);
				node.node.add(dd);
			}
			else {
				node.node.add(creattree(count.get(i)));
			}
			plus.removeAll(plus);				
		}	
		return node;//新的这个节点
	}	
	//输出决策树
	public void print(ArrayList<ArrayList<String>> dat) {//dat是存好的训练数据['衣服裤子鞋子','新款潮流韩版','潮流服饰']
		//System.out.println("构建的决策树如下：");
		creattree(dat);//类，调用创建树
		//put(node);//递归调用，输出节点	
	}
	//用于递归的函数
	public void put(treeNode1 node) {
		System.out.println("结点："+node.getsname()+"\n");
		for(int i=0;i<node.label.size();i++) {//01
				System.out.println(node.getsname()+"的标签属性:"+node.label.get(i));
			if(node.node.get(i).node.isEmpty()==true) {
				System.out.println("叶子结点："+node.node.get(i).getsname());
			}
			else {
				put(node.node.get(i));
			}
		}	
	}
	//用于对待决策数据进行预测并将结果保存在指定路径
	public void testdate(ArrayList<ArrayList<String>> test){
		treeNode1 node=null;
		node=creattree(this.date);//类
		for(int i=0;i<test.size();i++) {
			testput(node,test.get(i));//递归调用
		}
	}
	//用于测试的递归调用
	public void testput(treeNode1 node,ArrayList<String> t) {
		int index=0;
		for(int i=0;i<this.label.size();i++) {
			if(this.label.get(i).equals(node.getsname())==true) {
				index=i;
				break;
			}
		}
		for(int i=0;i<node.label.size();i++) {
			if(t.get(index).equals(node.label.get(i))==false) {
				continue;
			}
			if(node.node.get(i).node.isEmpty()==true) {
				System.out.println("分类结果为："+node.node.get(i).getsname());
				//System.out.println(i);
				this.kind[this.x]=node.node.get(i).getsname();//取出分类结果
				this.x++;
				//System.out.println(this.x+this.kind[this.x]);
			}
			else {
				testput(node.node.get(i),t);
			}
		}	
	}
}
