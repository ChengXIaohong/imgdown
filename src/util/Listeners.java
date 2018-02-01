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
 * �������ϼ�
 * @author 10864189 coax
 *
 */
public class Listeners {
	/**
	 * ���ذ�ť����
	 * @param mianViewInstance ������
	 * @throws Exception 
	 */
	public static void downPic1(MianView mianViewInstance) throws Exception {
		
		/**
		 * ��ʾ������
		 */
		JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(mianViewInstance));
		dialog.setLocationRelativeTo(Constans.getMianView());
		
		//ѡ����ַ����
		String uriName = null;
		
		//ѡ��洢��ַ
		String filePath;
		
		//�����ַ�
		String searchKey = null;
		
		//�Ƿ��ѯ
		boolean hasSearch = mianViewInstance.rdoYes.isSelected();
		
		//URI null check
		uriName = (String)mianViewInstance.boxSelectUrl.getSelectedItem();
		if (CxhUtil.isEmpty(uriName)) {
			JOptionPane.showMessageDialog(dialog , "URI����", "��ʾ" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//file path null check
		filePath = mianViewInstance.textFilePath.getText();
		if (CxhUtil.isEmpty(filePath)) {
			JOptionPane.showMessageDialog(dialog , "����·������", "��ʾ" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (hasSearch) {
			searchKey = mianViewInstance.textSearchText.getText();
			if (CxhUtil.isEmpty(searchKey)) {
				JOptionPane.showMessageDialog(dialog , "�����ؼ�������", "��ʾ" , JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		//filePath check
		if (CxhUtil.isNotEmpty(mianViewInstance.textFilePath.getText())) {
			filePath = mianViewInstance.textFilePath.getText();
			if (!CxhUtil.regex(filePath, Constans.REGEX_FILEPARH)) {
				JOptionPane.showMessageDialog(dialog , "�Ϸ�����·������", "��ʾ" , JOptionPane.ERROR_MESSAGE);
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
	* @Description: TODO(��ȡ����������Դ�������ý��������б�ѡ����) 
	* @param @param boxSelectUrl    ���趨ѡ���
	* @return void    �������� 
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
	* @Description: TODO(����ѡ���Ƿ��ѯ ���Ʋ�ѯ������Ƿ�չʾ) 
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public static void showOrHideSearch(JRadioButton rdoNo, JLabel lbeSearch, JTextField textSearchText) {
		lbeSearch.setVisible(rdoNo.isSelected() ? false : true);
		textSearchText.setVisible(rdoNo.isSelected() ? false : true);
	}
}
