package com.test.dom;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
public class DomXml1 {
	//使用dom技术对 xml文件进行crud操作
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//创建一个DocumentBuilderFactory
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//通过DocumentBuilderFactory,得到一个DocumentBuilder对象
		DocumentBuilder dBuilder=dbf.newDocumentBuilder();
		//指定解析哪个xml文件
		Document document=dBuilder.parse("src/classes.xml");
//		list(document);
//		read(document);
//		add(document);
//		del(document);
		upd(document);
		System.out.println("ok");
	}
	//遍历该xml文件
	public static void list(Node node){
		if(node.getNodeType()==node.ELEMENT_NODE){
			System.out.println("节点名字:"+node.getNodeName());
		}
		//取出node的子节点
		NodeList nodeList=node.getChildNodes();
		for(int i=0;i<nodeList.getLength();i++){
			//再去显示
			Node n=nodeList.item(i);
			list(n);
		}
	}
	//具体的查询某个学生的信息(显示第一个学生的所有信息)
	//请考虑如何获取某个元素的属性值,(取出)
	public static void read(Document doc){
		NodeList nl=doc.getElementsByTagName("学生");
		System.out.println("发现了"+nl.getLength()+"个学生");
		//取出第一个学生
		Element stu=(Element) nl.item(0);
		Element name=(Element) (stu.getElementsByTagName("名字")).item(0);
		System.out.println("名字:"+name.getTextContent());
		Element age=(Element) (stu.getElementsByTagName("年龄")).item(0);
		System.out.println("年龄:"+age.getTextContent());
		Element info=(Element) (stu.getElementsByTagName("介绍")).item(0);
		System.out.println("介绍:"+info.getTextContent());
		//请考虑如何获取某个元素的属性值,(取出第一个学生的性别)
		System.out.println("性别:"+stu.getAttribute("sex"));
	}
	//添加一个学生到xml文件中
	public static void add(Document doc) throws Exception{
		//创建一个新的学生节点
		Element newStu=doc.createElement("学生");
		//写内容
		Element newStu_name=doc.createElement("名字");
		newStu_name.setTextContent("小明2");
		Element newStu_age=doc.createElement("年龄");
		newStu_age.setTextContent("34");
		Element newStu_intro=doc.createElement("介绍");
		newStu_intro.setTextContent("这是一个好孩子");
		//添加一个属性值
		newStu.setAttribute("sex", "男");
		//把內容添加到学生节点
		newStu.appendChild(newStu_name);
		newStu.appendChild(newStu_age);
		newStu.appendChild(newStu_intro);
		
		//把新的学生节点添加到根元素
		doc.getDocumentElement().appendChild(newStu);
		//得到TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//通过TransformerFactory 得到一个转换器
		Transformer tf=tff.newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/classes.xml"));
	}
	//删除一个元素(删除第3个学生)
	public static void del(Document doc) throws Exception{
		//首先要找到这个学生
		Element stu= (Element) (doc.getElementsByTagName("学生")).item(2);
		//删除学生
		stu.getParentNode().removeChild(stu);
		//只删除学生的sex属性
		//stu.removeAttribute("sex");
		//更新xml
		//得到TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//通过TransformerFactory 得到一个转换器
		Transformer tf=tff.newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/classes.xml"));
	}
	//更新元素(把第2个学生的名改成 宋江)
	public static void upd(Document doc) throws Exception{
		//找到
		Element node=(Element) doc.getElementsByTagName("学生").item(1);
		Element node_name=(Element) node.getElementsByTagName("名字").item(0);
		node_name.setTextContent("宋江");
		//更改属性
		node.setAttribute("sex", "男");
		//更新xml
		//得到TransformerFactory
		TransformerFactory tff=TransformerFactory.newInstance();
		//通过TransformerFactory 得到一个转换器
		Transformer tf=tff.newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/classes.xml"));
	}
}
