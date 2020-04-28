package com.ls.util;
import java.util.ArrayList;//动态数组类型，有数租的特征和链表的特征
import java.util.Arrays;

class treeNode{//树节点
	public String sname;//节点名
	public treeNode(String str) {//设置节点名的
		sname=str;
	}
	public String getsname() {//获取节点名的
		return sname;
	}
	ArrayList<String> label=new ArrayList<String>();//和子节点间的边标签，集合中元素类型为string
	ArrayList<treeNode> node=new ArrayList<treeNode>();//对应子节点，集合中元素类型为treeNode
}

public class ID3 {
	public ArrayList<String> label=new ArrayList<String>();//特征属性标签，存数据的第一行特征介绍
	public ArrayList<ArrayList<String>> date=new ArrayList<ArrayList<String>>();//训练数据集
	public ArrayList<ArrayList<String>> test=new ArrayList<ArrayList<String>>();//测试数据集
	public ArrayList<String> sum=new ArrayList<String>();//结果种类
	public String[] kind;//存最终结果
	public int x=0;
	public String[] getKind() {
		return kind;
	}
	public ID3(String favourite,ArrayList<String> datelist){
		//初始化训练数据并得到分类种数
		getDate(favourite);//将训练数据集存到了成员变量date中
		//获取测试数据集
		gettestDate(datelist);//将测试数据集存到了成员变量test中
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
	public void gettestDate(ArrayList<String> datelist){
		int length = datelist.size();//记录有多少条数据
		this.kind = new String[length];
		String[][] teststr = new String[length][2];
		for(int i=0;i<length;i++) {//过滤每一条数据并且给上特征值,保存在teststr这个二维数组中
			if(datelist.get(i).indexOf("运动")!=-1) {
				teststr[i][0]="运动";
				if(datelist.get(i).indexOf("新款")!=-1) {
					teststr[i][1]="新款";
				}else {
					teststr[i][1]="普通";
				}
			}else if(datelist.get(i).indexOf("休闲")!=-1){
				teststr[i][0]="休闲";
				if(datelist.get(i).indexOf("新款")!=-1) {
					teststr[i][1]="新款";
				}else {
					teststr[i][1]="普通";
				}
			}else {
				teststr[i][0]="其他";
				if(datelist.get(i).indexOf("新款")!=-1) {
					teststr[i][1]="新款";
				}else {
					teststr[i][1]="普通";
				}
			}
			
		}
		ArrayList<String> lines = null;
		for(int i=0;i<teststr.length;i++) {//将二维数组转到一个ArrayList中
			lines = new ArrayList<String>();
			for(int j=0;j<teststr[0].length;j++) {
				lines.add(teststr[i][j]);
			}
			test.add(lines);//存的测试数据
		}
	}
	//获取训练数据集
	public void getDate(String favourite){
		String[] favarr = favourite.split(",");//把用户爱好字符串存到数组中去
		if(favarr[0].equals("潮流服饰")) {//目前只针对潮流服饰实现过滤
			String[] labelstr = new String[] {"类型","款式","潮流服饰"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//存的特征标签
			}
			//存训练数据
			String[][] datestr = new String[][] {{"运动","新款","潮流服饰"},{"休闲","新款","潮流服饰"},{"其他","新款","普通服饰"},{"运动","普通","普通服饰"},{"休闲","普通","普通服饰"},{"其他","普通","普通服饰"}};
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
	public double Ent(ArrayList<ArrayList<String>> dat) {
		//计算总的信息熵
		int all=0;
		double amount=0.0;
		for(int i=0;i<sum.size();i++) {//sum就两种结果
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
	public treeNode creattree(ArrayList<ArrayList<String>> dat) {//传入的训练数据二维['衣服裤子鞋子','新款潮流韩版','潮流服饰']
		int index=Gain(dat);//取到了最大增益属性的下标
		treeNode node=new treeNode(label.get(index));//['服饰','潮流','潮流服饰']
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
				treeNode dd=new treeNode(str);
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
		treeNode node=null;//定义一个根节点
		node=creattree(dat);//类，调用创建树
		put(node);//递归调用，输出节点	
	}
	//用于递归的函数
	public void put(treeNode node) {
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
		treeNode node=null;
		node=creattree(this.date);//类
		for(int i=0;i<test.size();i++) {
			testput(node,test.get(i));//递归调用
		}
	}
	//用于测试的递归调用
	public void testput(treeNode node,ArrayList<String> t) {
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
				//System.out.println("分类结果为："+node.node.get(i).getsname());
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
//	@Override
//	public String toString() {
//		return "ID3 [label=" + label + ", date=" + date + ", test=" + test + ", sum=" + sum + ", kind="
//				+ Arrays.toString(kind) + "]";
//	}
//	public static void main(String[] args){
//		ID3 id=new ID3();//初始化数据，存好训练数据和测试数据和结果种类
//		id.print(id.date);//构建并输出决策树，传入的是存好的训练数据
//		id.testdate(id.test);//预测数据并输出结果
//	}
}



