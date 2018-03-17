package com.test.dom;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
public class DomXml1 {
	//ʹ��dom������ xml�ļ�����crud����
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//����һ��DocumentBuilderFactory
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//ͨ��DocumentBuilderFactory,�õ�һ��DocumentBuilder����
		DocumentBuilder dBuilder=dbf.newDocumentBuilder();
		//ָ�������ĸ�xml�ļ�
		Document document=dBuilder.parse("src/classes.xml");
//		list(document);
//		read(document);
//		add(document);
//		del(document);
		upd(document);
		System.out.println("ok");
	}
	//������xml�ļ�
	public static void list(Node node){
		if(node.getNodeType()==node.ELEMENT_NODE){
			System.out.println("�ڵ�����:"+node.getNodeName());
		}
		//ȡ��node���ӽڵ�
		NodeList nodeList=node.getChildNodes();
		for(int i=0;i<nodeList.getLength();i++){
			//��ȥ��ʾ
			Node n=nodeList.item(i);
			list(n);
		}
	}
	//����Ĳ�ѯĳ��ѧ������Ϣ(��ʾ��һ��ѧ����������Ϣ)
	//�뿼����λ�ȡĳ��Ԫ�ص�����ֵ,(ȡ��)
	public static void read(Document doc){
		NodeList nl=doc.getElementsByTagName("ѧ��");
		System.out.println("������"+nl.getLength()+"��ѧ��");
		//ȡ����һ��ѧ��
		Element stu=(Element) nl.item(0);
		Element name=(Element) (stu.getElementsByTagName("����")).item(0);
		System.out.println("����:"+name.getTextContent());
		Element age=(Element) (stu.getElementsByTagName("����")).item(0);
		System.out.println("����:"+age.getTextContent());
		Element info=(Element) (stu.getElementsByTagName("����")).item(0);
		System.out.println("����:"+info.getTextContent());
		//�뿼����λ�ȡĳ��Ԫ�ص�����ֵ,(ȡ����һ��ѧ�����Ա�)
		System.out.println("�Ա�:"+stu.getAttribute("sex"));
	}
	//���һ��ѧ����xml�ļ���
	public static void add(Document doc) throws Exception{
		//����һ���µ�ѧ���ڵ�
		Element newStu=doc.createElement("ѧ��");
		//д����
		Element newStu_name=doc.createElement("����");
		newStu_name.setTextContent("С��2");
		Element newStu_age=doc.createElement("����");
		newStu_age.setTextContent("34");
		Element newStu_intro=doc.createElement("����");
		newStu_intro.setTextContent("����һ���ú���");
		//���һ������ֵ
		newStu.setAttribute("sex", "��");
		//�у�����ӵ�ѧ���ڵ�
		newStu.appendChild(newStu_name);
		newStu.appendChild(newStu_age);
		newStu.appendChild(newStu_intro);
		
		//���µ�ѧ���ڵ���ӵ���Ԫ��
		doc.getDocumentElement().appendChild(newStu);
		//�õ�TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//ͨ��TransformerFactory �õ�һ��ת����
		Transformer tf=tff.newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/classes.xml"));
	}
	//ɾ��һ��Ԫ��(ɾ����3��ѧ��)
	public static void del(Document doc) throws Exception{
		//����Ҫ�ҵ����ѧ��
		Element stu= (Element) (doc.getElementsByTagName("ѧ��")).item(2);
		//ɾ��ѧ��
		stu.getParentNode().removeChild(stu);
		//ֻɾ��ѧ����sex����
		//stu.removeAttribute("sex");
		//����xml
		//�õ�TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//ͨ��TransformerFactory �õ�һ��ת����
		Transformer tf=tff.newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/classes.xml"));
	}
	//����Ԫ��(�ѵ�2��ѧ�������ĳ� �ν�)
	public static void upd(Document doc) throws Exception{
		//�ҵ�
		Element node=(Element) doc.getElementsByTagName("ѧ��").item(1);
		Element node_name=(Element) node.getElementsByTagName("����").item(0);
		node_name.setTextContent("�ν�");
		//��������
		node.setAttribute("sex", "��");
		//����xml
		//�õ�TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//ͨ��TransformerFactory �õ�һ��ת����
		Transformer tf=tff.newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/classes.xml"));
	}
}
