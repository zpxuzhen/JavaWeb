package com.test.dom4jxpath;

import java.util.List;

import org.dom4j.*;
import org.dom4j.io.*;

public class Test1 {

	//dom4j ��� xpath����
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1.�õ�SAXReader ������
		SAXReader saxReader =new SAXReader();
		//2.ָ��ȥ�����ĸ��ļ�
		Document document = saxReader.read("src/com/test/dom4jxpath/test.xml");
		
		//3.����ʹ��xpath���Ķ�ȡ
		List e=document.selectNodes("/AAA/BBB[1]/CCC[1]/KKK");//���ض��Ԫ�� document.selectSingleNode
		System.out.println(((Element)e.get(0)).getText());
		//System.out.println(((Attribute)e.get(1)).getText());
		
		
		//�������ȷ��ֻ��һ��Node,Ԫ�������ʹ��selectSingleNode
		//Element e2=(Element) document.selectSingleNode("/AAA/BBB[last()]");
		//System.out.println(e2.getText());
	}

}
