package cons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bean.Sourcezz;
import util.CxhUtil;
import util.XmlSupport;

/**
  * 动态变量常量类
 *2018年2月1日 上午11:28:40
 *author coax coax@outlook.it
 *Description
 **/
public class DynamicConstans implements Serializable{
	/* 
	* @Fields serialVersionUID 
	*/ 
	private static final long serialVersionUID = 1L;
	
	/**
	 * 可爬取网站列表
	 */
	public static List<Sourcezz> sourceItems = new ArrayList<Sourcezz>();
	
	static {
		if (CxhUtil.isEmpty(sourceItems)) {
			sourceItems = XmlSupport.loadSource(sourceItems);
		}
	}
	
	/**
	 * 图片下载路径
	 */
	public static String imageSavePath = "";
}

