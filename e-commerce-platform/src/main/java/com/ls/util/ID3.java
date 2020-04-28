package com.ls.util;
import java.util.ArrayList;//��̬�������ͣ�����������������������
import java.util.Arrays;

class treeNode{//���ڵ�
	public String sname;//�ڵ���
	public treeNode(String str) {//���ýڵ�����
		sname=str;
	}
	public String getsname() {//��ȡ�ڵ�����
		return sname;
	}
	ArrayList<String> label=new ArrayList<String>();//���ӽڵ��ı߱�ǩ��������Ԫ������Ϊstring
	ArrayList<treeNode> node=new ArrayList<treeNode>();//��Ӧ�ӽڵ㣬������Ԫ������ΪtreeNode
}

public class ID3 {
	public ArrayList<String> label=new ArrayList<String>();//�������Ա�ǩ�������ݵĵ�һ����������
	public ArrayList<ArrayList<String>> date=new ArrayList<ArrayList<String>>();//ѵ�����ݼ�
	public ArrayList<ArrayList<String>> test=new ArrayList<ArrayList<String>>();//�������ݼ�
	public ArrayList<String> sum=new ArrayList<String>();//�������
	public String[] kind;//�����ս��
	public int x=0;
	public String[] getKind() {
		return kind;
	}
	public ID3(String favourite,ArrayList<String> datelist){
		//��ʼ��ѵ�����ݲ��õ���������
		getDate(favourite);//��ѵ�����ݼ��浽�˳�Ա����date��
		//��ȡ�������ݼ�
		gettestDate(datelist);//���������ݼ��浽�˳�Ա����test��
		init(date);//����ѵ�����ݼ������������浽sum��
		print(date);//�����������������������Ǵ�õ�ѵ������
		testdate(test);//Ԥ�����ݲ�������
		//System.out.println("������");
	}
	public void init(ArrayList<ArrayList<String>> date) {
		//�õ�������
		sum.add(date.get(0).get(date.get(0).size()-1));
        for(int i=0;i<date.size();i++) {
        	if(sum.contains(date.get(i).get(date.get(0).size()-1))==false) {//contains�ж�Ԫ���Ƿ����б�,�����տ��ܵĽ�������������Ҳ����ظ������մ�����Ϊ��������
        		sum.add(date.get(i).get(date.get(0).size()-1));      	    
        	}
		}
	}
	//��ȡ�������ݼ�
	public void gettestDate(ArrayList<String> datelist){
		int length = datelist.size();//��¼�ж���������
		this.kind = new String[length];
		String[][] teststr = new String[length][2];
		for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
			if(datelist.get(i).indexOf("�˶�")!=-1) {
				teststr[i][0]="�˶�";
				if(datelist.get(i).indexOf("�¿�")!=-1) {
					teststr[i][1]="�¿�";
				}else {
					teststr[i][1]="��ͨ";
				}
			}else if(datelist.get(i).indexOf("����")!=-1){
				teststr[i][0]="����";
				if(datelist.get(i).indexOf("�¿�")!=-1) {
					teststr[i][1]="�¿�";
				}else {
					teststr[i][1]="��ͨ";
				}
			}else {
				teststr[i][0]="����";
				if(datelist.get(i).indexOf("�¿�")!=-1) {
					teststr[i][1]="�¿�";
				}else {
					teststr[i][1]="��ͨ";
				}
			}
			
		}
		ArrayList<String> lines = null;
		for(int i=0;i<teststr.length;i++) {//����ά����ת��һ��ArrayList��
			lines = new ArrayList<String>();
			for(int j=0;j<teststr[0].length;j++) {
				lines.add(teststr[i][j]);
			}
			test.add(lines);//��Ĳ�������
		}
	}
	//��ȡѵ�����ݼ�
	public void getDate(String favourite){
		String[] favarr = favourite.split(",");//���û������ַ����浽������ȥ
		if(favarr[0].equals("��������")) {//Ŀǰֻ��Գ�������ʵ�ֹ���
			String[] labelstr = new String[] {"����","��ʽ","��������"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			//��ѵ������
			String[][] datestr = new String[][] {{"�˶�","�¿�","��������"},{"����","�¿�","��������"},{"����","�¿�","��ͨ����"},{"�˶�","��ͨ","��ͨ����"},{"����","��ͨ","��ͨ����"},{"����","��ͨ","��ͨ����"}};
			ArrayList<String> line=null;
			for(int i=0;i<datestr.length;i++) {
				line = new ArrayList<String>();
				for(int j=0;j<datestr[i].length;j++) {
					line.add(datestr[i][j]);
				}
				date.add(line);//���ѵ������
			}
		}
	}
	public double Ent(ArrayList<ArrayList<String>> dat) {
		//�����ܵ���Ϣ��
		int all=0;
		double amount=0.0;
		for(int i=0;i<sum.size();i++) {//sum�����ֽ��
			for(int j=0;j<dat.size();j++) {
				if(sum.get(i).equals(dat.get(j).get(dat.get(0).size()-1))) {
					all++;//���ƥ��һ��
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
		return -amount;//������Ϣ��
	}
	//���������ز�������Ϣ����ֵ
	public double condtion(int a,ArrayList<ArrayList<String>> dat) {//a:0~2,dat['�·�����Ь��','�¿������','��������']
		ArrayList<String> all=new ArrayList<String>();
		double c=0.0;
		all.add(dat.get(0).get(a));//ִ�����飬ÿһ���һ������ÿ�����Լӽ�ȥ
		//�õ���������
		for(int i=0;i<dat.size();i++) {//0,1,2,3
			if(all.contains(dat.get(i).get(a))==false) {//�ж�all��������û���ظ���ӵ�
				all.add(dat.get(i).get(a));//����֮��['�Ƿ���','�ǳ���','���Ƿ���','���ǳ���']����������е����ԵĿ�����
			}
		}
		ArrayList<ArrayList<String>> plus=new ArrayList<ArrayList<String>>();//������һ����ά
		//���ַ���
		ArrayList<ArrayList<ArrayList<String>>> count=new ArrayList<ArrayList<ArrayList<String>>>();//��ά������ǻ��ֺõ�ѵ������
		//�����ܺ�
		for(int i=0;i<all.size();i++) {//0123
			for(int j=0;j<dat.size();j++) {//0123
				if(all.get(i).equals(dat.get(j).get(a))==true) {//��all��ÿһ����dat�ĵ�һ�бȽϣ��ڶ����ٵڶ��бȽ�
					plus.add(dat.get(j));//��ʵ�൱���ڸ�dat���࣬����ѵ�һ���Ƿ��εķֵ�һ��
				}
			}
			count.add(plus);//�ѷֺõ�һ����һ�����������൱��[[[],[]],[[],[]]]
			c+=((double)count.get(i).size()/dat.size())*Ent(count.get(i));//c���ۻ���4��
			plus.removeAll(plus);//�Ƴ�����Ԫ�أ�����һ�������һ��
		}
		return (Ent(dat)-c);//��Ϣ����
		//����������
	}
	//������Ϣ�����������
	public int Gain(ArrayList<ArrayList<String>> dat) {//�����ѵ������['�·�����Ь��','�¿������','��������']
		ArrayList<Double> num=new ArrayList<Double>();//������һ��double���͵����飬��������Ϣ���棬�������Ծʹ��м���
		//�������Ϣ����ֵ
		for(int i=0;i<dat.get(0).size()-1;i++) {//0~1
			num.add(condtion(i,dat));//��ÿ�����Ե����涼�������ˣ����������
		}
		int index=0;//���������ֵ���±�
		double max=num.get(0);//���һ����Ϊ���ֵ����������
		for(int i=1;i<num.size();i++) {
			if(max<num.get(i)) {
				max=num.get(i);
				index=i;
			}
		}
		return index;//�������ֵ���±�
	}
	//����������
	public treeNode creattree(ArrayList<ArrayList<String>> dat) {//�����ѵ�����ݶ�ά['�·�����Ь��','�¿������','��������']
		int index=Gain(dat);//ȡ��������������Ե��±�
		treeNode node=new treeNode(label.get(index));//['����','����','��������']
		ArrayList<String> s=new ArrayList<String>();//�Ǹ��������Եĸ��ַ��࣬�����¿�Ь�ͷ��¿�Ь
		s.add(dat.get(0).get(index));//�����һ�е�����±���Ǹ�����
		//System.out.println(dat.get(0).get(index));
		for(int i=1;i<dat.size();i++) {//123
			if(s.contains(dat.get(i).get(index))==false) {//����ʣ���ÿ�����ݵ�����±�������Ƿ��Ѿ���������
				s.add(dat.get(i).get(index));
			}
		}
		ArrayList<ArrayList<String>> plus=new ArrayList<ArrayList<String>>();
		//���ַ���
		ArrayList<ArrayList<ArrayList<String>>> count=new ArrayList<ArrayList<ArrayList<String>>>();
		//�����ܺ�
		//�õ��ڵ��µı߱�ǩ������
		for(int i=0;i<s.size();i++) {//01����ÿһ�����ݸ���s���й���
			node.label.add(s.get(i));//��ӱ߱�ǩ
			//System.out.print("��ӱ߱�ǩ:"+s.get(i)+"  ");
			for(int j=0;j<dat.size();j++) {//0123
				if(s.get(i).equals(dat.get(j).get(index))==true) {
					plus.add(dat.get(j));
				}
			}
			count.add(plus);//�൱�ڰ�ÿ�����Ե�ÿ�ֿ��ֿܷ�����[[[],[]],[[],[]]]
			//������ӽ��
			int k;
			String str=count.get(i).get(0).get(count.get(i).get(0).size()-1);//���ÿһ��ĵ�һ�����ݵ��жϽ����[],[],[['','',''],[]]��
			for(k=1;k<count.get(i).size();k++) {//1���Աȵ�����һ���ʣ�µ����ݽ��
				if(str.equals(count.get(i).get(k).get(count.get(i).get(k).size()-1))==false) {//�͵�һ����һ��
					break;//�ж��Ӽ�������
				}
			}
			if(k==count.get(i).size()) {//2�����kΪ�����ͻ���Ϊһ���ڵ�
				treeNode dd=new treeNode(str);
				node.node.add(dd);
			}
			else {
				node.node.add(creattree(count.get(i)));
			}
			plus.removeAll(plus);				
		}	
		return node;//�µ�����ڵ�
	}	
	//���������
	public void print(ArrayList<ArrayList<String>> dat) {//dat�Ǵ�õ�ѵ������['�·�����Ь��','�¿������','��������']
		//System.out.println("�����ľ��������£�");
		treeNode node=null;//����һ�����ڵ�
		node=creattree(dat);//�࣬���ô�����
		put(node);//�ݹ���ã�����ڵ�	
	}
	//���ڵݹ�ĺ���
	public void put(treeNode node) {
		System.out.println("��㣺"+node.getsname()+"\n");
		for(int i=0;i<node.label.size();i++) {//01
				System.out.println(node.getsname()+"�ı�ǩ����:"+node.label.get(i));
			if(node.node.get(i).node.isEmpty()==true) {
				System.out.println("Ҷ�ӽ�㣺"+node.node.get(i).getsname());
			}
			else {
				put(node.node.get(i));
			}
		}	
	}
	//���ڶԴ��������ݽ���Ԥ�Ⲣ�����������ָ��·��
	public void testdate(ArrayList<ArrayList<String>> test){
		treeNode node=null;
		node=creattree(this.date);//��
		for(int i=0;i<test.size();i++) {
			testput(node,test.get(i));//�ݹ����
		}
	}
	//���ڲ��Եĵݹ����
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
				//System.out.println("������Ϊ��"+node.node.get(i).getsname());
				//System.out.println(i);
				this.kind[this.x]=node.node.get(i).getsname();//ȡ��������
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
//		ID3 id=new ID3();//��ʼ�����ݣ����ѵ�����ݺͲ������ݺͽ������
//		id.print(id.date);//�����������������������Ǵ�õ�ѵ������
//		id.testdate(id.test);//Ԥ�����ݲ�������
//	}
}



