package cons;

import util.CxhUtil;
import view.MianView;

/**
 * ������
 * @author 10864189 coax
 *
 */
public class Constans {
	private static MianView mainViewInstance;
	
	/**
	 * ��ַ��֤����
	 */
	public static final String REGEX_URL = "^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\/])+$";
	
	/**
	 * HTMLԴ����img��ǩ����
	 */
	public static final String   REGEX_HTMLIMG =  "<img(.*?)>"; //"<img[\\s\\S]{10,200}alt=\"([^\"]{1,50})\"\\ssrc=\\\"([^\"]{1,200})";
	
	/**
	 * ����·����֤����
	 */
	public static final String REGEX_FILEPARH = "^[a-zA-Z]:(([a-zA-Z]*)||([a-zA-Z]*\\\\))*";
	
	/**
	 * ����ͼƬ������
	 */
	public static int downTotalCount = 0;
	
	/**
	 * ����ͼƬ�ɹ�����
	 */
	public static int downSuccessCount = 0;
	
	/**
	 * ����ͼƬʧ������
	 */
	public static int downFailCount = 0;
	
	
	public static MianView getMianView() {
		if(CxhUtil.isEmpty(mainViewInstance)) {
			mainViewInstance = new MianView();
		}
		return mainViewInstance;
	}
	
	/**
	 * ��չ������������ļ���
	 */
	public static void clearDownNum() {
		Constans.downTotalCount = 0;
		Constans.downSuccessCount = 0;
		Constans.downFailCount = 0;
	}
	
}
