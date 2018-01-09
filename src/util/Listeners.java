package util;

import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import cons.Constans;
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
		String uri = null;
		String filePath;
		
		//URI null check
		if (CxhUtil.isEmpty(mianViewInstance.textUrl.getText())) {
			JOptionPane.showMessageDialog(dialog , "URI����", "��ʾ" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//file path null check
		if (CxhUtil.isEmpty(mianViewInstance.textFilePath.getText())) {
			JOptionPane.showMessageDialog(dialog , "����·������", "��ʾ" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//URI check
		if (CxhUtil.isNotEmpty(mianViewInstance.textUrl.getText())) {
			 uri = mianViewInstance.textUrl.getText();
			if (!CxhUtil.regex(uri, Constans.REGEX_URL)) {
				JOptionPane.showMessageDialog(dialog , "�Ϸ�URI����", "��ʾ" , JOptionPane.ERROR_MESSAGE);
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
		}
		
		String htmlStr = DownPic.getHtml(uri);
		Map<String, String> src =  DownPic.getUrl(htmlStr);
		DownPic.downLoad(src);
		
		
	}
}
