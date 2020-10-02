package com.mashirosa.medical.da;

import java.io.File;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlReader { // 别人写的xml读取方法，我进行了一点点修改

    public static double reader(String id) throws Exception {
        double tn = 0;
        SAXReader reader = new SAXReader();
        File file = new File("./res","tn.xml").getCanonicalFile();
        Document document = reader.read(file);
        Element root = document.getRootElement();
        List<Element> childElements = root.elements();
        for (Element child : childElements) {
            if (child.attributeValue("id").equals(id))
            {
                return Double.valueOf(child.elementText("info")); // 将字符串类型转换为double类
            }
            //未知属性名情况下
            /*List<Attribute> attributeList = child.attributes();
            for (Attribute attr : attributeList) {
                System.out.println(attr.getName() + ": " + attr.getValue());
            }*/
            //已知属性名情况下
//            System.out.println("id: " + child.attributeValue("id"));
            //未知子元素名情况下
            /*List<Element> elementList = child.elements();
            for (Element ele : elementList) {
                System.out.println(ele.getName() + ": " + ele.getText());
            }
            System.out.println();*/
            //已知子元素名的情况下
//            System.out.println("title:" + child.elementText("title"));
//            System.out.println("info:" + child.elementText("info"));
            //这行是为了格式化美观而存在
//            System.out.println();
        }
        return tn;
    }
}