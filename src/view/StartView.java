package view;

import java.awt.EventQueue;

import cons.Constans;

/**∆Ù∂Ø¿‡
 * 
 * @author 10864189 coax
 */
public class StartView {

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MianView frame = Constans.getMianView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
