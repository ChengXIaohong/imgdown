package util;

import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import bean.Sourcezz;
import cons.Constans;
import cons.DynamicConstans;
import down.DownPic;
import view.MianView;

/**
 * 监听器合集
 * @author 10864189 coax
 *
 */
public class Listeners {
	/**
	 * 下载按钮监听
	 * @param mianViewInstance 主窗体
	 * @throws Exception 
	 */
	public static void downPic1(MianView mianViewInstance) throws Exception {
		
		/**
		 * 提示窗对象
		 */
		JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(mianViewInstance));
		dialog.setLocationRelativeTo(Constans.getMianView());
		
		//选择网址名称
		String uriName = null;
		
		//选择存储地址
		String filePath;
		
		//搜索字符
		String searchKey = null;
		
		//是否查询
		boolean hasSearch = mianViewInstance.rdoYes.isSelected();
		
		//URI null check
		uriName = (String)mianViewInstance.boxSelectUrl.getSelectedItem();
		if (CxhUtil.isEmpty(uriName)) {
			JOptionPane.showMessageDialog(dialog , "URI输入", "提示" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//file path null check
		filePath = mianViewInstance.textFilePath.getText();
		if (CxhUtil.isEmpty(filePath)) {
			JOptionPane.showMessageDialog(dialog , "磁盘路径输入", "提示" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (hasSearch) {
			searchKey = mianViewInstance.textSearchText.getText();
			if (CxhUtil.isEmpty(searchKey)) {
				JOptionPane.showMessageDialog(dialog , "搜索关键字输入", "提示" , JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		//filePath check
		if (CxhUtil.isNotEmpty(mianViewInstance.textFilePath.getText())) {
			filePath = mianViewInstance.textFilePath.getText();
			if (!CxhUtil.regex(filePath, Constans.REGEX_FILEPARH)) {
				JOptionPane.showMessageDialog(dialog , "合法磁盘路径输入", "提示" , JOptionPane.ERROR_MESSAGE);
				return;
			}
			DynamicConstans.imageSavePath =  filePath;
		}

		String htmlStr = DownPic.getHtml(uriName);
		Map<String, String> src =  DownPic.getUrl(htmlStr);
		DownPic.downLoad(src);
	}

	/**
	 * @throws DocumentException  
	* @Title: loadUrl 
	* @Description: TODO(读取可下载数据源并且设置进入下拉列表选择项) 
	* @param @param boxSelectUrl    待设定选择框
	* @return void    返回类型 
	* @throws 
	*/
	public static void loadUrl(JComboBox<String> boxSelectUrl) {
		boolean load = boxSelectUrl.getItemCount() == 0;
		List<Sourcezz> listSource = null;
		if( load ) {
			listSource = DynamicConstans.sourceItems;
			for (Sourcezz urlInfo : listSource) {
				boxSelectUrl.addItem(urlInfo.getName());
			}
		}
	}

	/**
	 * @param textSearchText 
	 * @param lbeSearch 
	 * @param rdoNo  
	* @Title: showOrHideSearch 
	* @Description: TODO(根据选择是否查询 控制查询输入框是否展示) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public static void showOrHideSearch(JRadioButton rdoNo, JLabel lbeSearch, JTextField textSearchText) {
		lbeSearch.setVisible(rdoNo.isSelected() ? false : true);
		textSearchText.setVisible(rdoNo.isSelected() ? false : true);
	}
}
