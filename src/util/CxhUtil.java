package util;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 *  工具类
 * @author 10864189 coax
 *
 */
public class CxhUtil {
	
	public static boolean isEmpty(Object param) {
		if (null == param) {
			return true;
		}
		if ("" .equals(param)) {
			return true;
		}
		if(param instanceof String ) {
			if(((String)param).length() == 0 ) {
				return true;
			}
		}
		if(param instanceof Collection) {
			if(((Collection<?>)param).size() == 0 ) {
				return true;
			}
		}		
		if(param instanceof Map) {
			if(((Map<?, ?>)param).size() == 0 ) {
				return true;
			}
		}		
		return false;
		
	}
	
	public static boolean isNotEmpty(Object param) {
		if (null == param) {
			return false;
		}
		if ("" .equals(param)) {
			return false;
		}
		if(param instanceof String ) {
			if(((String)param).length() == 0 ) {
				return false;
			}
		}
		if(param instanceof Collection) {
			if(((Collection<?>)param).size() == 0 ) {
				return false;
			}
		}		
		if(param instanceof Map) {
			if(((Map<?, ?>)param).size() == 0 ) {
				return false;
			}
		}		
		return true;
		
	}
	
	public static boolean regex(String sourcesStr , String regexStr) {
		Pattern pattern = Pattern.compile(regexStr);
		return pattern.matcher(sourcesStr).matches();
	}
	
	public static String[] parseHtmlImgReturnAltAndSrc(String htmlImg) throws DocumentException {
		String[] arr = new String[2];
			htmlImg = htmlImg.replace("data-src", "src");  
	    //统一标签URL格式 	
		Document document = DocumentHelper.parseText(htmlImg); 
		Element ele_img = document.getRootElement();
		
		//下面两句是获取img标签中的 alt 和 src
		Attribute src = ele_img.attribute("src");
		Attribute alt = ele_img.attribute("alt");
		if (CxhUtil.isNotEmpty(alt)) {
			arr[0] = alt.getValue();
			arr[1] = src.getValue();
		}
		return arr;
		
	}

}
