package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import cons.Constans;
import util.CxhUtil;

/**
 * 消息展示类
 * @author 10864189 coax
 *
 */
public class ShowMessage {
	
	private static ShowMessage ins = null;
	
	private ShowMessage() {}
	
	public void showMessage(String messageContent,String messageTitle, int messageType) {
		JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(Constans.getMianView()));
		dialog.setLocationRelativeTo(Constans.getMianView());
		JOptionPane.showMessageDialog(dialog , messageContent,CxhUtil.isEmpty(messageTitle) ? "提示" : messageTitle , messageType);
	}
	
	public static ShowMessage getInstance() {
		if(CxhUtil.isEmpty(ins)) {
			ins = new ShowMessage();
		}
		return ins;
	}
}
