package cons;

import util.CxhUtil;
import view.MianView;

/**
 * 常量类
 * @author 10864189 coax
 *
 */
public class Constans {
	private static MianView mainViewInstance;
	
	/**
	 * 网址验证正则
	 */
	public static final String REGEX_URL = "^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\/])+$";
	
	/**
	 * HTML源代码img标签正则
	 */
	public static final String   REGEX_HTMLIMG =  "<img(.*?)>"; //"<img[\\s\\S]{10,200}alt=\"([^\"]{1,50})\"\\ssrc=\\\"([^\"]{1,200})";
	
	/**
	 * 磁盘路径验证正则
	 */
	public static final String REGEX_FILEPARH = "^[a-zA-Z]:(([a-zA-Z]*)||([a-zA-Z]*\\\\))*";
	
	/**
	 * 下载图片总数量
	 */
	public static int downTotalCount = 0;
	
	/**
	 * 下载图片成功数量
	 */
	public static int downSuccessCount = 0;
	
	/**
	 * 下载图片失败数量
	 */
	public static int downFailCount = 0;
	
	
	public static MianView getMianView() {
		if(CxhUtil.isEmpty(mainViewInstance)) {
			mainViewInstance = new MianView();
		}
		return mainViewInstance;
	}
	
	/**
	 * 清空关于下载数量的计数
	 */
	public static void clearDownNum() {
		Constans.downTotalCount = 0;
		Constans.downSuccessCount = 0;
		Constans.downFailCount = 0;
	}
	
}
