package cons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bean.Sourcezz;
import util.CxhUtil;
import util.XmlSupport;

/**
  * ��̬����������
 *2018��2��1�� ����11:28:40
 *author coax coax@outlook.it
 *Description
 **/
public class DynamicConstans implements Serializable{
	/* 
	* @Fields serialVersionUID 
	*/ 
	private static final long serialVersionUID = 1L;
	
	/**
	 * ����ȡ��վ�б�
	 */
	public static List<Sourcezz> sourceItems = new ArrayList<Sourcezz>();
	
	static {
		if (CxhUtil.isEmpty(sourceItems)) {
			sourceItems = XmlSupport.loadSource(sourceItems);
		}
	}
	
	/**
	 * ͼƬ����·��
	 */
	public static String imageSavePath = "";
}

