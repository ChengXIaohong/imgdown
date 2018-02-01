package util;

import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import bean.Sourcezz;
import cons.Constans;

/**
  * xml 相关类
 *2018年2月1日 上午11:32:16
 *author coax coax@outlook.it
 *Description
 **/
public class XmlSupport {
	@SuppressWarnings("unchecked")
	public static <T> List<Sourcezz> loadSource (List<T> ret) {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(Constans.SOURCES_XML_PATH);
		SAXReader reader = new SAXReader ();
		try {
			Document doc = reader.read(in);
			Element node = doc.getRootElement();  
			List<Element> elements = node.elements();
			for (Element sub : elements) {
				String name = sub.attributeValue("name");
				String value = sub.elementText("value");
				if (CxhUtil.isEmpty(name)) {
					name = sub.elementText("name");
				}
				if (CxhUtil.isEmpty(value)) {
					value = sub.attributeValue("value");
				}
				if (CxhUtil.isNotEmpty(value) && CxhUtil.isNotEmpty(name)) {
					Sourcezz item = new Sourcezz(name , value);
					ret.add((T) item);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return (List<Sourcezz>) ret;
	}
}

