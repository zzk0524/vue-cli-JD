package com.ls.util;

import java.util.ArrayList;

class treeNode1{//���ڵ�
	public String sname;//�ڵ���
	public treeNode1(String str) {//���ýڵ�����
		sname=str;
	}
	public String getsname() {//��ȡ�ڵ�����
		return sname;
	}
	ArrayList<String> label=new ArrayList<String>();//���ӽڵ��ı߱�ǩ��������Ԫ������Ϊstring
	ArrayList<treeNode1> node=new ArrayList<treeNode1>();//��Ӧ�ӽڵ㣬������Ԫ������ΪtreeNode
}

public class CartID3 {
	public ArrayList<String> label=new ArrayList<String>();//�������Ա�ǩ�������ݵĵ�һ����������
	public ArrayList<ArrayList<String>> date=new ArrayList<ArrayList<String>>();//ѵ�����ݼ�
	public ArrayList<ArrayList<String>> test=new ArrayList<ArrayList<String>>();//�������ݼ�
	public ArrayList<String> sum=new ArrayList<String>();//�������
	public String[] kind;//�����ս��
	public int x=0;
	public String[] getKind() {
		return kind;
	}
	public CartID3(String favourite,ArrayList<String> datelist){
		//��ʼ��ѵ�����ݲ��õ���������
		getDate(favourite);//��ѵ�����ݼ��浽�˳�Ա����date��
		//��ȡ�������ݼ�
		gettestDate(favourite,datelist);//���������ݼ��浽�˳�Ա����test��
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
	public void gettestDate(String favourite,ArrayList<String> datelist){
		int length = datelist.size();//��¼�ж���������
		this.kind = new String[length];
		//String[][] teststr = new String[length][2];
		String[] teststr1 = new String[length];//С�ף���ҫ��iPhone����Ϊ��Redmi,vivo,OPPO ,���壬���ӣ����裬���ˣ�ŵ���ǣ����ǣ�����
		if(favourite.indexOf("�����ֻ�")!=-1||favourite.indexOf("GB")!=-1) {//������ֻ�
			if(favourite.indexOf("С��")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("С��")!=-1) {
						teststr1[i]="С��";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}			
			}else if(favourite.indexOf("��ҫ")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("��ҫ")!=-1) {
						teststr1[i]="��ҫ";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("iPhone")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("iPhone")!=-1) {
						teststr1[i]="iPhone";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("��Ϊ")!=-1) {//��Ϊ��Redmi,vivo,OPPO ,���壬���ӣ����裬���ˣ�ŵ���ǣ����ǣ�����
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("��Ϊ")!=-1) {
						teststr1[i]="��Ϊ";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("Redmi")!=-1) {//Redmi,vivo,OPPO ,���壬���ӣ����裬���ˣ�ŵ���ǣ����ǣ�����
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("Redmi")!=-1) {
						teststr1[i]="Redmi";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("vivo")!=-1) {//vivo,OPPO ,���壬���ӣ����裬���ˣ�ŵ���ǣ����ǣ�����
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("vivo")!=-1) {
						teststr1[i]="vivo";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("OPPO")!=-1) {//OPPO ,���壬���ӣ����裬���ˣ�ŵ���ǣ����ǣ�����
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("OPPO")!=-1) {
						teststr1[i]="OPPO";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("����")!=-1) {//���壬���ӣ����裬���ˣ�ŵ���ǣ����ǣ�����
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="����";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("����")!=-1) {//���ӣ����裬���ˣ�ŵ���ǣ����ǣ�����
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="����";
					}else {
						teststr1[i]="����";
					}	
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("����")!=-1) {//���裬���ˣ�ŵ���ǣ����ǣ�����
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="����";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("����")!=-1) {//���ˣ�ŵ���ǣ����ǣ�����
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="����";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("ŵ����")!=-1) {//ŵ���ǣ����ǣ�����
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("ŵ����")!=-1) {
						teststr1[i]="ŵ����";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("����")!=-1) {//���ǣ�����
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="����";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {//С�ף���ҫ��iPhone����Ϊ��Redmi,vivo,OPPO ,���壬���ӣ����裬���ˣ�ŵ���ǣ����ǣ�����
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�����ֻ�")!=-1||datelist.get(i).indexOf("GB")!=-1)&&datelist.get(i).indexOf("С��")==-1&&datelist.get(i).indexOf("��ҫ")==-1&&datelist.get(i).indexOf("iPhone")==-1&&datelist.get(i).indexOf("Redmi")==-1&&datelist.get(i).indexOf("vivo")==-1&&datelist.get(i).indexOf("OPPO")==-1&&datelist.get(i).indexOf("����")==-1&&datelist.get(i).indexOf("����")==-1&&datelist.get(i).indexOf("����")==-1&&datelist.get(i).indexOf("����")==-1&&datelist.get(i).indexOf("ŵ����")==-1&&datelist.get(i).indexOf("����")==-1) {
						teststr1[i]="����";
					}else {
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else if(favourite.indexOf("��")!=-1) {//�˶�,���У�ţ�У�С�ţ����	
			if(favourite.indexOf("���")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("��")!=-1&&datelist.get(i).indexOf("���")!=-1) {
						teststr1[i]="��׿�";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("С��")!=-1){
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("��")!=-1&&datelist.get(i).indexOf("С��")!=-1) {
						teststr1[i]="С�ſ�";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("ţ��")!=-1){
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("��")!=-1&&datelist.get(i).indexOf("ţ��")!=-1) {
						teststr1[i]="ţ�п�";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("�˶�")!=-1){
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("��")!=-1&&datelist.get(i).indexOf("�˶�")!=-1) {
						teststr1[i]="�˶���";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("����")!=-1){
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("��")!=-1&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="���п�";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {//�˶�,���У�ţ�У�С�ţ����	������
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("��")!=-1&&datelist.get(i).indexOf("����")==-1&&datelist.get(i).indexOf("�˶�")==-1&&datelist.get(i).indexOf("С��")==-1&&datelist.get(i).indexOf("���")==-1&&datelist.get(i).indexOf("ţ��")==-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else if(favourite.indexOf("����")!=-1||favourite.indexOf("����")!=-1) {//���䣬��װ���пˣ�����,����
			if(favourite.indexOf("����")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("����")!=-1||datelist.get(i).indexOf("����")!=-1)&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("��װ")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("����")!=-1||datelist.get(i).indexOf("����")!=-1)&&datelist.get(i).indexOf("��װ")!=-1) {
						teststr1[i]="��װ";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("�п�")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("����")!=-1||datelist.get(i).indexOf("����")!=-1)&&datelist.get(i).indexOf("�п�")!=-1) {
						teststr1[i]="�п�";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("����")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("����")!=-1||datelist.get(i).indexOf("����")!=-1)&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("����")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("����")!=-1||datelist.get(i).indexOf("����")!=-1)&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("����")!=-1||datelist.get(i).indexOf("����")!=-1)&&datelist.get(i).indexOf("����")==-1&&datelist.get(i).indexOf("�п�")==-1&&datelist.get(i).indexOf("����")==-1&&datelist.get(i).indexOf("��װ")==-1&&datelist.get(i).indexOf("����")==-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else if(favourite.indexOf("Ь")!=-1) {
			if(favourite.indexOf("�˶�")!=-1&&favourite.indexOf("����")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("Ь")!=-1&&datelist.get(i).indexOf("�˶�")!=-1&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="�˶�����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("Ь")!=-1&&datelist.get(i).indexOf("�˶�")==-1&&datelist.get(i).indexOf("����")==-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else if(favourite.indexOf("��ʳ")!=-1) {//��ʳ
			if(favourite.indexOf("��")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("��ʳ")!=-1&&datelist.get(i).indexOf("��")!=-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("��ʳ")!=-1&&datelist.get(i).indexOf("��")==-1) {
						teststr1[i]="������";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else if(favourite.indexOf("�Ҿ�")!=-1||favourite.indexOf("��")!=-1||favourite.indexOf("��")!=-1) {
			if(favourite.indexOf("��")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�Ҿ�")!=-1||datelist.get(i).indexOf("��")!=-1||datelist.get(i).indexOf("��")!=-1)&&datelist.get(i).indexOf("��")!=-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("��")!=-1){
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�Ҿ�")!=-1||datelist.get(i).indexOf("��")!=-1||datelist.get(i).indexOf("��")!=-1)&&datelist.get(i).indexOf("��")!=-1) {
						teststr1[i]="��";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("ɳ��")!=-1){
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�Ҿ�")!=-1||datelist.get(i).indexOf("��")!=-1||datelist.get(i).indexOf("��")!=-1)&&datelist.get(i).indexOf("ɳ��")!=-1) {
						teststr1[i]="ɳ��";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("�Ҿ�")!=-1||datelist.get(i).indexOf("��")!=-1||datelist.get(i).indexOf("��")!=-1)&&datelist.get(i).indexOf("ɳ��")==-1&&datelist.get(i).indexOf("��")==-1&&datelist.get(i).indexOf("��")==-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else if(favourite.indexOf("���")!=-1||favourite.indexOf("ϴ����")!=-1||favourite.indexOf("��ԡ¶")!=-1||favourite.indexOf("ϴ��")!=-1) {
			if(favourite.indexOf("ϴ����")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("���")!=-1||datelist.get(i).indexOf("ϴ����")!=-1||datelist.get(i).indexOf("��ԡ¶")!=-1||datelist.get(i).indexOf("ϴ��")!=-1)&&datelist.get(i).indexOf("ϴ����")!=-1) {
						teststr1[i]="ϴ����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("ϴ��")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("���")!=-1||datelist.get(i).indexOf("ϴ����")!=-1||datelist.get(i).indexOf("��ԡ¶")!=-1||datelist.get(i).indexOf("ϴ��")!=-1)&&datelist.get(i).indexOf("ϴ��")!=-1) {
						teststr1[i]="ϴ��ˮ";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("��ԡ¶")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("���")!=-1||datelist.get(i).indexOf("ϴ����")!=-1||datelist.get(i).indexOf("��ԡ¶")!=-1||datelist.get(i).indexOf("ϴ��")!=-1)&&datelist.get(i).indexOf("��ԡ¶")!=-1) {
						teststr1[i]="��ԡ¶";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("���")!=-1||datelist.get(i).indexOf("ϴ����")!=-1||datelist.get(i).indexOf("��ԡ¶")!=-1||datelist.get(i).indexOf("ϴ��")!=-1)&&datelist.get(i).indexOf("��ԡ¶")==-1&&datelist.get(i).indexOf("ϴ����")==-1&&datelist.get(i).indexOf("ϴ��")==-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else if(favourite.indexOf("������")!=-1||favourite.indexOf("������")!=-1){
			if(favourite.indexOf("����")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("������")!=-1||datelist.get(i).indexOf("������")!=-1)&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="������";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("������")!=-1||datelist.get(i).indexOf("������")!=-1)&&datelist.get(i).indexOf("����")==-1) {
						teststr1[i]="��������";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else if(favourite.indexOf("����")!=-1||favourite.indexOf("��ָ")!=-1||favourite.indexOf("��׹")!=-1){
			if(favourite.indexOf("����")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("����")!=-1||datelist.get(i).indexOf("��ָ")!=-1||datelist.get(i).indexOf("��׹")!=-1)&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("��ָ")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("����")!=-1||datelist.get(i).indexOf("��ָ")!=-1||datelist.get(i).indexOf("��׹")!=-1)&&datelist.get(i).indexOf("��ָ")!=-1) {
						teststr1[i]="��ָ";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else if(favourite.indexOf("��׹")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("����")!=-1||datelist.get(i).indexOf("��ָ")!=-1||datelist.get(i).indexOf("��׹")!=-1)&&datelist.get(i).indexOf("��׹")!=-1) {
						teststr1[i]="��׹";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if((datelist.get(i).indexOf("����")!=-1||datelist.get(i).indexOf("��ָ")!=-1||datelist.get(i).indexOf("��׹")!=-1)&&datelist.get(i).indexOf("��׹")==-1&&datelist.get(i).indexOf("����")==-1&&datelist.get(i).indexOf("��ָ")==-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else if(favourite.indexOf("���")!=-1){
			if(favourite.indexOf("����")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("���")!=-1&&datelist.get(i).indexOf("����")!=-1) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("���")!=-1&&datelist.get(i).indexOf("����")==-1) {
						teststr1[i]="������";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else if(favourite.indexOf("����")!=-1){
			if(favourite.indexOf("è")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("����")!=-1&&datelist.get(i).indexOf("è")!=-1) {
						teststr1[i]="è��";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("����")!=-1&&datelist.get(i).indexOf("è")==-1) {
						teststr1[i]="��è��";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else if(favourite.indexOf("����")!=-1){
			if(favourite.indexOf("������Ʒ")!=-1||favourite.indexOf("����")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("����")!=-1&&(datelist.get(i).indexOf("������Ʒ")!=-1||favourite.indexOf("����")!=-1)) {
						teststr1[i]="����";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(datelist.get(i).indexOf("����")!=-1&&datelist.get(i).indexOf("������Ʒ")==-1&&datelist.get(i).indexOf("����")==-1) {
						teststr1[i]="�ǳ���";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}else {//ͼ��
			if(favourite.indexOf("��")!=-1) {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(((datelist.get(i).indexOf("�����ֻ�")==-1||datelist.get(i).indexOf("GB")==-1)&&datelist.get(i).indexOf("��")==-1&&(datelist.get(i).indexOf("����")==-1||datelist.get(i).indexOf("����")==-1)&&datelist.get(i).indexOf("Ь")==-1&&datelist.get(i).indexOf("��ʳ")==-1&&(datelist.get(i).indexOf("�Ҿ�")==-1||datelist.get(i).indexOf("��")==-1||datelist.get(i).indexOf("��")==-1)&&(datelist.get(i).indexOf("���")==-1||datelist.get(i).indexOf("ϴ����")==-1||datelist.get(i).indexOf("��ԡ¶")==-1||datelist.get(i).indexOf("ϴ��")==-1)&&(datelist.get(i).indexOf("������")==-1||datelist.get(i).indexOf("������")==-1)&&(datelist.get(i).indexOf("����")==-1||datelist.get(i).indexOf("��ָ")==-1||datelist.get(i).indexOf("��׹")==-1)&&datelist.get(i).indexOf("���")==-1&&datelist.get(i).indexOf("����")==-1&&datelist.get(i).indexOf("����")==-1)&&datelist.get(i).indexOf("��")!=-1) {
						teststr1[i]="�ɲ�";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}else {
				for(int i=0;i<length;i++) {//����ÿһ�����ݲ��Ҹ�������ֵ,������teststr�����ά������
					if(((datelist.get(i).indexOf("�����ֻ�")==-1||datelist.get(i).indexOf("GB")==-1)&&datelist.get(i).indexOf("��")==-1&&(datelist.get(i).indexOf("����")==-1||datelist.get(i).indexOf("����")==-1)&&datelist.get(i).indexOf("Ь")==-1&&datelist.get(i).indexOf("��ʳ")==-1&&(datelist.get(i).indexOf("�Ҿ�")==-1||datelist.get(i).indexOf("��")==-1||datelist.get(i).indexOf("��")==-1)&&(datelist.get(i).indexOf("���")==-1||datelist.get(i).indexOf("ϴ����")==-1||datelist.get(i).indexOf("��ԡ¶")==-1||datelist.get(i).indexOf("ϴ��")==-1)&&(datelist.get(i).indexOf("������")==-1||datelist.get(i).indexOf("������")==-1)&&(datelist.get(i).indexOf("����")==-1||datelist.get(i).indexOf("��ָ")==-1||datelist.get(i).indexOf("��׹")==-1)&&datelist.get(i).indexOf("���")==-1&&datelist.get(i).indexOf("����")==-1&&datelist.get(i).indexOf("����")==-1)&&datelist.get(i).indexOf("��")==-1) {
						teststr1[i]="���ɲ�";	
					}else{
						teststr1[i]="����";
					}
				}
				ArrayList<String> lines = null;
				for(int i=0;i<teststr1.length;i++) {//����ά����ת��һ��ArrayList��
					lines = new ArrayList<String>();
					lines.add(teststr1[i]);
					test.add(lines);//��Ĳ�������
				}
			}
		}
	}
	//��ȡѵ�����ݼ�
	public void getDate(String favourite){
		//String[] favarr = favourite.split(",");//���û������ַ����浽������ȥ
		System.out.println(favourite);
		if(favourite.indexOf("�����ֻ�")!=-1||favourite.indexOf("GB")!=-1) {//ȷ��һ�����ֻ�
			String[] labelstr = new String[] {"Ʒ��","Ŀ���ֻ�"};
			for(int i=0;i<labelstr.length;i++){//С�ף���ҫ��iPhone����Ϊ��Redmi,vivo,OPPO ,���壬���ӣ����裬���ˣ�ŵ���ǣ����ǣ�����
				label.add(labelstr[i]);//���������ǩ
			}
			//��ѵ������
			if(favourite.indexOf("С��")!=-1) {
				String[][] datestr = new String[][] {{"С��","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("��ҫ")!=-1) {
				String[][] datestr = new String[][] {{"��ҫ","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("iPhone")!=-1) {
				String[][] datestr = new String[][] {{"iPhone","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("��Ϊ")!=-1) {
				String[][] datestr = new String[][] {{"��Ϊ","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("Redmi")!=-1) {
				String[][] datestr = new String[][] {{"Redmi","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("vivo")!=-1) {
				String[][] datestr = new String[][] {{"vivo","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("OPPO")!=-1) {
				String[][] datestr = new String[][] {{"OPPO","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"����","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"����","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"����","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"����","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("ŵ����")!=-1) {
				String[][] datestr = new String[][] {{"ŵ����","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"����","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"����","Ŀ���ֻ�"},{"����","��ͨ�ֻ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}			
		}else if(favourite.indexOf("��")!=-1) {//����
			System.out.println("�ǿ���");
			String[] labelstr = new String[] {"����","Ŀ�����"};//�˶�,���У�ţ�У�С�ţ����	
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			//��ѵ������
			if(favourite.indexOf("���")!=-1) {
				String[][] datestr = new String[][] {{"��׿�","Ŀ�����"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("С��")!=-1) {
				System.out.println("��С�ſ�");
				String[][] datestr = new String[][] {{"С�ſ�","Ŀ�����"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("ţ��")!=-1) {
				String[][] datestr = new String[][] {{"ţ�п�","Ŀ�����"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("�˶�")!=-1) {
				String[][] datestr = new String[][] {{"�˶���","Ŀ�����"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"���п�","Ŀ�����"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"����","Ŀ�����"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}
		}else if(favourite.indexOf("����")!=-1||favourite.indexOf("����")!=-1) {//����һ������
			String[] labelstr = new String[] {"��ʽ","Ŀ������"};//���䣬��װ���пˣ�����,����
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"����","Ŀ������"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("��װ")!=-1) {
				String[][] datestr = new String[][] {{"��װ","Ŀ������"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("�п�")!=-1) {
				String[][] datestr = new String[][] {{"�п�","Ŀ������"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"����","Ŀ������"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"����","Ŀ������"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"����","Ŀ������"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}
			//��ѵ������
		}else if(favourite.indexOf("Ь")!=-1) {//����һ��Ь��
			String[] labelstr = new String[] {"����","Ŀ��Ь"};//�˶�����
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			if(favourite.indexOf("�˶�")!=-1&&favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"�˶�����","Ŀ��Ь"},{"����","����Ь"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"����","Ŀ��Ь"},{"����","����Ь"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}
		}else if(favourite.indexOf("��ʳ")!=-1) {//ʳƷ
			String[] labelstr = new String[] {"����","Ŀ��ʳƷ"};//
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			if(favourite.indexOf("��")!=-1) {
				//��ѵ������
				String[][] datestr = new String[][] {{"����","Ŀ��ʳƷ"},{"����","����ʳƷ"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"������","Ŀ��ʳƷ"},{"����","����ʳƷ"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}
		}else if(favourite.indexOf("�Ҿ�")!=-1||favourite.indexOf("��")!=-1||favourite.indexOf("��")!=-1) {//����һ���Ҿ�
			String[] labelstr = new String[] {"����","Ŀ��Ҿ�"};//����ɳ������
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			if(favourite.indexOf("��")!=-1) {
				//��ѵ������
				String[][] datestr = new String[][] {{"����","Ŀ��Ҿ�"},{"����","�����Ҿ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("��")!=-1) {
				String[][] datestr = new String[][] {{"��","Ŀ��Ҿ�"},{"����","�����Ҿ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("ɳ��")!=-1) {
				String[][] datestr = new String[][] {{"ɳ��","Ŀ��Ҿ�"},{"����","�����Ҿ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"����","Ŀ��Ҿ�"},{"����","�����Ҿ�"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}
		}else if(favourite.indexOf("���")!=-1||favourite.indexOf("ϴ����")!=-1||favourite.indexOf("ϴ��")!=-1||favourite.indexOf("��ԡ¶")!=-1) {//����һ���������
			String[] labelstr = new String[] {"����","Ŀ��������"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			if(favourite.indexOf("ϴ����")!=-1) {
				//��ѵ������
				String[][] datestr = new String[][] {{"ϴ����","Ŀ��������"},{"����","�����������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("ϴ��")!=-1) {
				String[][] datestr = new String[][] {{"ϴ��ˮ","Ŀ��������"},{"����","�����������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("��ԡ¶")!=-1) {
				String[][] datestr = new String[][] {{"��ԡ¶","Ŀ��������"},{"����","�����������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"����","Ŀ��������"},{"����","�����������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}
		}else if(favourite.indexOf("������")!=-1||favourite.indexOf("������")!=-1){//����һ�����
			String[] labelstr = new String[] {"����","Ŀ�����"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"������","Ŀ�����"},{"����","�������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"��������","Ŀ�����"},{"����","�������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}
		}else if(favourite.indexOf("����")!=-1||favourite.indexOf("��ָ")!=-1||favourite.indexOf("��׹")!=-1){
			String[] labelstr = new String[] {"����","Ŀ���鱦"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"����","Ŀ���鱦"},{"����","�����鱦"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("��ָ")!=-1) {
				String[][] datestr = new String[][] {{"��ָ","Ŀ���鱦"},{"����","�����鱦"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else if(favourite.indexOf("��׹")!=-1) {
				String[][] datestr = new String[][] {{"��׹","Ŀ���鱦"},{"����","�����鱦"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"����","Ŀ���鱦"},{"����","�����鱦"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}
		}else if(favourite.indexOf("���")!=-1){//����һ�����
			String[] labelstr = new String[] {"����","Ŀ�����"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			if(favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"����","Ŀ�����"},{"����","�������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"������","Ŀ�����"},{"����","�������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}
		}else if(favourite.indexOf("����")!=-1){
			String[] labelstr = new String[] {"����","Ŀ�����"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			if(favourite.indexOf("è")!=-1) {
				String[][] datestr = new String[][] {{"è��","Ŀ�����"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"��è��","Ŀ�����"},{"����","��������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}
		}else if(favourite.indexOf("����")!=-1){//�������һ������\
			String[] labelstr = new String[] {"����","Ŀ��������Ʒ"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			if(favourite.indexOf("����")!=-1||favourite.indexOf("����")!=-1) {
				String[][] datestr = new String[][] {{"����","Ŀ��������Ʒ"},{"����","����������Ʒ"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"�ǳ���","Ŀ��������Ʒ"},{"����","����������Ʒ"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}
		}else {//ͼ��
			String[] labelstr = new String[] {"����","Ŀ����"};
			for(int i=0;i<labelstr.length;i++){
				label.add(labelstr[i]);//���������ǩ
			}
			if(favourite.indexOf("��")!=-1) {
				//��ѵ������
				String[][] datestr = new String[][] {{"�ɲ�","Ŀ����"},{"����","������"}};
				ArrayList<String> line=null;
				for(int i=0;i<datestr.length;i++) {
					line = new ArrayList<String>();
					for(int j=0;j<datestr[i].length;j++) {
						line.add(datestr[i][j]);
					}
					date.add(line);//���ѵ������
				}
			}else {
				String[][] datestr = new String[][] {{"���ɲ�","Ŀ����"},{"����","������"}};
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
	}
	public double Ent(ArrayList<ArrayList<String>> dat) {
		//�����ܵ���Ϣ��
		int all=0;
		double amount=0.0;
		for(int i=0;i<sum.size();i++) {
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
	public treeNode1 creattree(ArrayList<ArrayList<String>> dat) {//�����ѵ�����ݶ�ά['�·�����Ь��','�¿������','��������']
		int index=Gain(dat);//ȡ��������������Ե��±�
		treeNode1 node=new treeNode1(label.get(index));//['����','����','��������']
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
				treeNode1 dd=new treeNode1(str);
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
		creattree(dat);//�࣬���ô�����
		//put(node);//�ݹ���ã�����ڵ�	
	}
	//���ڵݹ�ĺ���
	public void put(treeNode1 node) {
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
		treeNode1 node=null;
		node=creattree(this.date);//��
		for(int i=0;i<test.size();i++) {
			testput(node,test.get(i));//�ݹ����
		}
	}
	//���ڲ��Եĵݹ����
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
				System.out.println("������Ϊ��"+node.node.get(i).getsname());
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
}
