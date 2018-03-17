package com.test.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jTest {

	//��ʾʹ��dom4j��xml�ļ�����crud����
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//1.�õ�������
		SAXReader saxReader=new SAXReader();
		//2ָ�������ĸ�xml�ļ�
		Document document=saxReader.read(new File("src/myclasses3.xml"));
		
		//list(document.getRootElement());//�õ���Ԫ��.
		//read(document);
		//add(document);
		//del(document);
		//update(document);
		addByIndex(document);
	}
	
	
	//���һ��Ԫ�ص�ָ��λ��( �ֳ嵽 ¬�����,������ǰ)
	public static void addByIndex(Document document) throws Exception{
		
		//����һ��Ԫ��
		Element newHero=DocumentHelper.createElement("ѧ��");
		newHero.setText("�ֳ�");
		//�õ�����ѧ����list
		List allHeros=document.getRootElement().elements("ѧ��");
		
		for(int i=0;i<allHeros.size();i++){
			//ȡ�������˵���
			Element name=((Element)allHeros.get(i)).element("����");
			if(name.getText().equals("¬����")){
				//System.out.println("���� "+i);
				allHeros.add(i+1, newHero);
				break;
			}
		}
		
		//allHeros.add(1,newHero);
		//����
		//ֱ������������������:
		OutputFormat output=OutputFormat.createPrettyPrint();
		output.setEncoding("utf-8");//����ı���utf-8
		
		//�����ǵ�xml�ļ�����
		// lets write to a file
		//new FileOutputStream(new File("src/myClass.xml"))
        XMLWriter writer = new XMLWriter(
        		new FileOutputStream(new File("src/myclasses3.xml")) /*new FileWriter( "src/com/dom4j/test/myclasses3.xml" )*/,output
        );
        writer.write( document );
        writer.close();
		
		
	}
	
	//����Ԫ��(Ҫ�������ѧ��������+3)
	public static void update(Document document ) throws Exception{
		
		//�õ�����ѧ��������
		List<Element> stus =document.getRootElement().elements("ѧ��");
		
		for(Element el:stus){
			//��el��ȡ������
			Element age=el.element("����");
			age.setText((Integer.parseInt(age.getText())+3)+"");
			Element name=el.element("����");
			//name.setAttributeValue("����", "hello,world");
			name.addAttribute("����2", "okok");
		}
		
		//����
		//ֱ������������������:
		OutputFormat output=OutputFormat.createPrettyPrint();
		output.setEncoding("utf-8");//����ı���utf-8
		
		//�����ǵ�xml�ļ�����
		// lets write to a file
		//new FileOutputStream(new File("src/myClass.xml"))
        XMLWriter writer = new XMLWriter(
        		new FileOutputStream(new File("src/myclasses3.xml")) /*new FileWriter( "src/com/dom4j/test/myclasses3.xml" )*/,output
        );
        writer.write( document );
        writer.close();
		
	}
	
	
	//ɾ��Ԫ��(Ҫ��ɾ����һ��ѧ��)
	public static void del(Document document) throws Exception{
		
		//�ҵ���Ԫ��(��һ��ѧ��element)
		Element stu1=document.getRootElement().element("ѧ��");
		//ɾ��Ԫ��
		stu1.getParent().remove(stu1);
		
		//ɾ��Ԫ�ص�ĳ������
		//stu1.element("����").remove(stu1.element("����").attribute("����"));
		
		
		//����xml
		
		//ֱ������������������:
		OutputFormat output=OutputFormat.createPrettyPrint();
		output.setEncoding("utf-8");//����ı���utf-8
		
		//�����ǵ�xml�ļ�����
		// lets write to a file
		//new FileOutputStream(new File("src/myClass.xml"))
        XMLWriter writer = new XMLWriter(
        		new FileOutputStream(new File("src/myclasses3.xml")) /*new FileWriter( "src/com/dom4j/test/myclasses3.xml" )*/,output
        );
        writer.write( document );
        writer.close();
		
	}
	
	//���Ԫ��(Ҫ��: ���һ��ѧ����xml��)
	
	public static void add(Document docment) throws Exception{
		
		//��������������һ��ѧ���ڵ���� 
		Element newStu=DocumentHelper.createElement("ѧ��");
		Element newStu_name=DocumentHelper.createElement("����");
		//��θ�Ԫ���������
		newStu_name.addAttribute("����", "����");
		newStu_name.setText("�ν�");
		Element newStu_age=DocumentHelper.createElement("����");
		Element newStu_intro=DocumentHelper.createElement("����");
		
		//��������Ԫ�أ��ڵ㣩�ӵ� newStu��
		newStu.add(newStu_name);
		newStu.add(newStu_age);
		newStu.add(newStu_intro);
		//�ٰ�newStu�ڵ�ӵ���Ԫ��
		docment.getRootElement().add(newStu);
		
		//ֱ������������������:
		OutputFormat output=OutputFormat.createPrettyPrint();
		output.setEncoding("utf-8");//����ı���utf-8
		
		//�����ǵ�xml�ļ�����
		// lets write to a file
		//new FileOutputStream(new File("src/myClass.xml"))
        XMLWriter writer = new XMLWriter(
        		new FileOutputStream(new File("src/myclasses3.xml")) /*new FileWriter( "src/com/dom4j/test/myclasses3.xml" )*/,output
        );
        writer.write( docment );
        writer.close();


		
	}
	
	//���ָ����ȡĳ��Ԫ��(Ҫ�� ����ȡ��һ��ѧ������Ϣ,)
	public static void read(Document docment){
		
		//�õ���Ԫ��
		Element root=docment.getRootElement();
		//root.elements("ѧ��") :��ʾȡ�� rootԪ�� �µ�����ѧ��Ԫ��
		//root.element("ѧ��") :��ʾȡ�� rootԪ�� �µĵ�һ��ѧ��Ԫ��
		//root.elements("ѧ��").get(0) : ��ʾȡ�� rootԪ�� �µĵ�һ��ѧ��Ԫ��
		Element stu= (Element) root.elements("ѧ��").get(0);
		
		Element stu_name=stu.element("����");
		
		System.out.println(stu_name.getText()+" ���� "+stu_name.attributeValue("����"));
		//System.out.println(((Element)stu.elements("����").get(0)).getText());
		
		//��������Ĵ����Ƿ��ܹ�(���ȡXXXXX)(xpath����)
		//Element stu2= (Element) root.elements("����").get(0);//==>xpath
		//System.out.println(root.elements("����").size());
		
		//���ʹ��xpath��ȡ����һ��ѧ��
		//Element stu2=(Element) docment.selectSingleNode("/�༶/ѧ��[1]");
	}

	//�������ǵ�xml�ļ�
	public static void list(Element element){
		
		System.out.println(element.getName()+element.getTextTrim());
		
		Iterator iterator=element.elementIterator();
		
		while(iterator.hasNext()){
			
			Element e=(Element) iterator.next();
			//�ݹ�
			list(e);
		}
		
	}
	
}
